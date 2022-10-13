package com.taller2.model.prueba;

public class Opcion {
	private int id;
	private String descOpcion;
	private int idPregunta;
	private String valor;
	
	public Opcion() {
		
	}
	
	public Opcion(int id, String descOpcion) {
		this.id = id;
		this.descOpcion = descOpcion;
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


	public String getValor() {
		return valor;
	}


	public void setValor(String valor) {
		this.valor = valor;
	}

	
}
