package com.taller2.view.prueba.crearpreguntavf;

public class PreguntaVFDTO {
	private int idTema;
	private int opcionCorrecta;
	private String enunciado;
	
	
	public int getIdTema() {
		return idTema;
	}
	public void setIdTema(int idTema) {
		this.idTema = idTema;
	}
	public int getOpcionCorrecta() {
		return opcionCorrecta;
	}
	public void setOpcionCorrecta(int opcionCorrecta) {
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
