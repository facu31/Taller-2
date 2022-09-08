package com.taller2.view.prueba.crearpregunta;

import com.fasterxml.jackson.annotation.JsonAlias;

public class OpcionDTO {
	@JsonAlias("Opcion")
	private String enunciado;
	
	@JsonAlias("Correcta")
	private boolean esCorrecta;
	
	
	public String getEnunciado() {
		return enunciado;
	}
	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}
	public boolean isEsCorrecta() {
		return esCorrecta;
	}
	public void setEsCorrecta(boolean esCorrecta) {
		this.esCorrecta = esCorrecta;
	}
	@Override
	public String toString() {
		return "OpcionDTO [enunciado=" + enunciado + ", esCorrecta=" + esCorrecta + "]";
	}
	
	
}
