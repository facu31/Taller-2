package com.taller2.model.prueba;

public class Tema {
	private int id;
	private String desc;
	private Materia materia;
	
	public Tema() {
		
	}
	
	public Tema(int id, String desc) {
		this.id = id;
		this.desc = desc;
	}
	
	public Tema(int id, String desc, int idMateria) {
		this.id = id;
		this.desc = desc;
		this.materia =new Materia(idMateria);
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
	public Materia getMateria() {
		return materia;
	}
	public void setMateria(Materia materia) {
		this.materia = materia;
	}
	
	
}
