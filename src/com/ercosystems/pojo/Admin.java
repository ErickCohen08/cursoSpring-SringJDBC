package com.ercosystems.pojo;

import java.sql.Timestamp;

public class Admin {

	private int idAd;
	private String nombre;
	private String cargo;
	private Timestamp fechacreacion;

	
	
	public Admin() {		
	}

	public Admin(String nombre, String cargo, Timestamp fechacreacion) {
		this.nombre = nombre;
		this.cargo = cargo;
		this.fechacreacion = fechacreacion;
	}

	public int getIdAd() {
		return idAd;
	}

	public void setIdAd(int idAd) {
		this.idAd = idAd;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Timestamp getFechacreacion() {
		return fechacreacion;
	}

	public void setFechacreacion(Timestamp fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	@Override
	public String toString() {
		return "Administrador [idAd=" + idAd + ", nombre=" + nombre + ", cargo=" + cargo + ", fechacreacion="
				+ fechacreacion + "]";
	}
}
