package com.ercosystems.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.ercosystems.pojo.Admin;
import com.ercosystems.rowmapper.AdminRowMapper;

@Component("adminDao")
public class AdminDaoImpl implements CrudDao<Admin> {

	private NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	private void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public boolean save(Admin admin) {
		// MapSqlParameterSource paramMap = new MapSqlParameterSource();
		// paramMap.addValue("nombre", admin.getNombre());
		// paramMap.addValue("cargo", admin.getCargo());
		// paramMap.addValue("fechaCreacion", admin.getFechacreacion());

		return jdbcTemplate.update(
				"insert into Admin (nombre, cargo, fechacreacion) values (:nombre, :cargo, :fechacreacion) ",
				new BeanPropertySqlParameterSource(admin)) == 1;
	}

	@Override
	public boolean update(Admin admin) {
		return jdbcTemplate.update(
				"update Admin set nombre = :nombre, cargo = :cargo, fechacreacion = :fechacreacion where idAd = :idAd",
				new BeanPropertySqlParameterSource(admin)) == 1;
	}

	@Override
	public boolean delete(int id) {
		return jdbcTemplate.update("delete from Admin where idAd = :idAd", new MapSqlParameterSource("idAd", id)) == 1;
	}

	@Override
	public List<Admin> findAll() {
		return jdbcTemplate.query("select * from admin", new AdminRowMapper());
	}

	@Override
	public Admin findById(int id) {
		return jdbcTemplate.queryForObject("select * from admin where idAd = :idAd",
				new MapSqlParameterSource("idAd", id), new AdminRowMapper());
	}

	@Override
	public List<Admin> findByNombre(String nombre) {
		return jdbcTemplate.query("select * from admin where nombre like :nombre",
				new MapSqlParameterSource("nombre", "%" + nombre + "%"), new AdminRowMapper());
	}

}
