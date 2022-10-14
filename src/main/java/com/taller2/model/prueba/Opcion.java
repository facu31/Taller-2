package com.taller2.model.prueba;

public class Opcion {
	private int id;
	private String descOpcion;
	private int idPregunta;
	private String valorCorrecto;
	private String valorIngresado;
	
	public Opcion() {
		
	}
	
	public Opcion(int id, String descOpcion, String valorCorrecto) {
		this.id = id;
		this.descOpcion = descOpcion;
		this.valorCorrecto = valorCorrecto;
	}
	

	public Opcion(String descOpcion) {
		this.descOpcion = descOpcion;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescOpcion() {
		return descOpcion;
	}
	public void setDescOpcion(String descOpcion) {
		this.descOpcion = descOpcion;
	}

	public int getIdPregunta() {
		return idPregunta;
	}

	public void setIdPregunta(int idPregunta) {
		this.idPregunta = idPregunta;
	}

	public String getValorCorrecto() {
		return valorCorrecto;
	}

	public void setValorCorrecto(String valorCorrecto) {
		this.valorCorrecto = valorCorrecto;
	}

	public String getValorIngresado() {
		return valorIngresado;
	}

	public void setValorIngresado(String valorIngresado) {
		this.valorIngresado = valorIngresado;
	}

	
	
}
