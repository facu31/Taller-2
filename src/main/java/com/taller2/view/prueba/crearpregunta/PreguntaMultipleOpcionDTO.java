package com.taller2.view.prueba.crearpregunta;

import java.util.Arrays;

public class PreguntaMultipleOpcionDTO {
	private String enunciado;
	private int idTema;
	private OpcionDTO[] opciones;
	
	public String getEnunciado() {
		return enunciado;
	}
	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}
	public int getIdTema() {
		return idTema;
	}
	public void setIdTema(int idTema) {
		this.idTema = idTema;
	}
	public OpcionDTO[] getOpciones() {
		return opciones;
	}
	public void setOpciones(OpcionDTO[] opciones) {
		this.opciones = opciones;
	}
	@Override
	public String toString() {
		return "PreguntaMultipleOpcionDTO [enunciado=" + enunciado + ", idTema=" + idTema + ", opciones="
				+ Arrays.toString(opciones) + "]";
	}
	
	
}
