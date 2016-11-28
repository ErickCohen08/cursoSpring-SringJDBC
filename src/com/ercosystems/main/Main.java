package com.ercosystems.main;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ercosystems.dao.CrudDao;
import com.ercosystems.pojo.Admin;

public class Main {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring_config.xml");

		CrudDao<Admin> adminDao = (CrudDao<Admin>) applicationContext.getBean("adminDao");

		Timestamp ts = new Timestamp(new Date().getTime());

		Admin admin = new Admin();
		admin.setNombre("Martin");
		admin.setCargo("Gerente");
		admin.setFechacreacion(ts);

		try {
			adminDao.save(admin);
			
			//buscar todos
			/*List<Admin> admins = adminDao.findAll();
			for (Admin adminss : admins) {
				System.out.println(adminss);
			}*/
						
			
			//Busqueda por Id
			//System.out.println(adminDao.findById(7));
			
			
			//Busqueda por nobre
			/*List<Admin> admins = adminDao.findByNombre("a");			
			for (Admin adminss : admins) {
				System.out.println(adminss);
			}*/
			
			
			
			//Modificar
			Admin admin1 = adminDao.findById(14);
			System.out.println();
			
			
			
		} catch (Exception ex) {
			System.out.println("error: "+ex);
		} 

		((ClassPathXmlApplicationContext) applicationContext).close();

	}

}
