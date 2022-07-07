package com.taller2.model.prueba;

import java.util.ArrayList;
import java.util.List;

public class Prueba {
	private int id;
	private String titulo;
	private String desc;
	private List<Pregunta> preguntas; ; 
	
	public Prueba() {
		
	}
	
	public Prueba(int id, String titulo, String desc) {
		this.id = id;
		this.titulo = titulo;
		this.desc = desc;
		this.preguntas = new ArrayList<Pregunta>();
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
	
	public void agregarPregunta(Pregunta pregunta) {
		this.preguntas.add(pregunta);
	}

	public List<Pregunta> getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(List<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}
	
	public String calcularResultado() {
		int totOk = 0;
		for(Pregunta preg: preguntas) {
			if (preg.getIdOpcionIngresada().equals(preg.getIdOpcionCorrecta())) totOk++;
		}
		return totOk + " preguntas correctas de un total de " + preguntas.size();
	}
	
}
