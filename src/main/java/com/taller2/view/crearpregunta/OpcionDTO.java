package com.taller2.view.crearpregunta;

import com.fasterxml.jackson.annotation.JsonAlias;

public class OpcionDTO {
	@JsonAlias("Opcion")
	private String enunciado;
	
	public String getEnunciado() {
		return enunciado;
	}
	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}
	
	@Override
	public String toString() {
		return "OpcionDTO [enunciado=" + enunciado + "]";
	}
	
	
}
