package com.taller2.dto.crearpregunta;

public class PreguntaRespuestaCortaDTO {
	private int idTema;
	private String opcionCorrecta;
	private String enunciado;
	
	
	public int getIdTema() {
		return idTema;
	}
	public void setIdTema(int idTema) {
		this.idTema = idTema;
	}
	
	public String getOpcionCorrecta() {
		return opcionCorrecta;
	}
	public void setOpcionCorrecta(String opcionCorrecta) {
		this.opcionCorrecta = opcionCorrecta;
	}
	public String getEnunciado() {
		return enunciado;
	}
	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}
	@Override
	public String toString() {
		return "PreguntaVFDTO [idTema=" + idTema + ", opcionCorrecta=" + opcionCorrecta + ", enunciado=" + enunciado
				+ "]";
	}
	
	
	
}
