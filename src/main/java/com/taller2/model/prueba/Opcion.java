package com.taller2.model.prueba;

public class Opcion {
	private int id;
	private String descOpcion;
	
	
	
	public Opcion(int id, String descOpcion) {
		this.id = id;
		this.descOpcion = descOpcion;
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescOpcion() {
		return descOpcion;
	}
	public void setDescOpcion(String descOpcion) {
		this.descOpcion = descOpcion;
	}

}
