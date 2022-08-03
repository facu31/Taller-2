package com.taller2.model.prueba;

import java.util.List;

public class Pregunta {
	private int id;
	private String enunciado;
	private List<Opcion> opciones;
	private int idOpcionCorrecta;
	private int puntaje;
	
	
	private Integer idOpcionIngresada;
	

	public Pregunta() {
		
	}
	
	public Pregunta(int id, String enunciado, int idOpcCorrecta) {
		this.id = id;
		this.enunciado = enunciado;
		this.idOpcionCorrecta = idOpcCorrecta;
		
	}

	public Integer getIdOpcionIngresada() {
		return idOpcionIngresada;
	}

	public void setIdOpcionIngresada(Integer idOpcionIngresada) {
		this.idOpcionIngresada = idOpcionIngresada;
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

	public List<Opcion> getOpciones() {
		return opciones;
	}

	public void setOpciones(List<Opcion> opciones) {
		this.opciones = opciones;
	}

	public int getIdOpcionCorrecta() {
		return idOpcionCorrecta;
	}

	public void setIdOpcionCorrecta(int idOpcionCorrecta) {
		this.idOpcionCorrecta = idOpcionCorrecta;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
	
	
}
