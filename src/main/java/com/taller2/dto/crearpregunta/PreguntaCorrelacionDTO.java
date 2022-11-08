package com.taller2.dto.crearpregunta;

public class PreguntaCorrelacionDTO {
	private String enunciado;
	private int idTema;
	private OpcionCorrelacionDTO[] opciones;
	
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
	public OpcionCorrelacionDTO[] getOpciones() {
		return opciones;
	}
	public void setOpciones(OpcionCorrelacionDTO[] opciones) {
		this.opciones = opciones;
	}

}
