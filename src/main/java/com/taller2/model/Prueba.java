package com.taller2.model;

public class Prueba {
	private int id;
	private String titulo;
	private String desc;
	
	
	public Prueba(int id, String titulo, String desc) {
		this.id = id;
		this.titulo = titulo;
		this.desc = desc;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
}
