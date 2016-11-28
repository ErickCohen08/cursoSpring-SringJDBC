package com.ercosystems.dao;

import java.util.List;

public interface CrudDao<T> {	
	public boolean save(T t);
	public boolean update(T t);
	public boolean delete(int id);
	public List<T> findAll();
	public T findById(int id);
	public List<T> findByNombre(String nombre);
}
