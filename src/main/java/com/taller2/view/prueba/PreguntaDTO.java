package com.taller2.view.prueba;

import com.fasterxml.jackson.annotation.JsonAlias;

public class PreguntaDTO {
	@JsonAlias("Id")
	private int id;
	
	@JsonAlias("Pregunta")
	private String enunciado;
	
	@JsonAlias("Puntos")
	private int puntos;
	
	public PreguntaDTO(int id, String enunciado, int puntos) {
		this.id = id;
		this.enunciado = enunciado;
		this.puntos = puntos;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEnunciado() {
		return enunciado;
	}
	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	
	
}
