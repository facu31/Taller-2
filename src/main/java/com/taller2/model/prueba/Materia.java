package com.taller2.model.prueba;

import java.util.List;

public class Materia {
	private int id;
	private String desc;
	
	public Materia() {
		
	}
	
	public Materia(int idMateria, String desc) {
		this.id = idMateria;
		this.desc = desc;
	}
	
	public Materia(int idMateria) {
		this.id = idMateria;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
