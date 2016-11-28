package com.ercosystems.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ercosystems.pojo.Admin;

public class AdminRowMapper implements RowMapper<Admin> {

	@Override
	public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
		Admin admin = new Admin();

		admin.setIdAd(rs.getInt("idAd"));
		admin.setNombre(rs.getString("nombre"));
		admin.setCargo(rs.getString("cargo"));
		admin.setFechacreacion(rs.getTimestamp("fechaCreacion"));

		return admin;
	}
}
