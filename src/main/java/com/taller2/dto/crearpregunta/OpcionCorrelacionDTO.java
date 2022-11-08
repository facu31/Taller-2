package com.taller2.dto.crearpregunta;

import com.fasterxml.jackson.annotation.JsonAlias;

public class OpcionCorrelacionDTO {
	@JsonAlias("Opcion")
	private String enunciado;
	
	@JsonAlias("Valor Correcto")
	private String valorCorrecto;
	
	public String getEnunciado() {
		return enunciado;
	}
	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}
	public String getValorCorrecto() {
		return valorCorrecto;
	}
	public void setValorCorrecto(String valorCorrecto) {
		this.valorCorrecto = valorCorrecto;
	}
	@Override
	public String toString() {
		return "OpcionCorrelacionDTO [enunciado=" + enunciado + ", valorCorrecto=" + valorCorrecto + "]";
	}

}
