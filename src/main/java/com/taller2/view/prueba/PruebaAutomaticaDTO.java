package com.taller2.view.prueba;

public class PruebaAutomaticaDTO {
	private int idTema;
	private int cantPreguntas;
	private int puntajeTotal;
	private String titulo;
	private String descripcion;
	
	
	public int getIdTema() {
		return idTema;
	}
	public void setIdTema(int idTema) {
		this.idTema = idTema;
	}
	public int getCantPreguntas() {
		return cantPreguntas;
	}
	public void setCantPreguntas(int cantPreguntas) {
		this.cantPreguntas = cantPreguntas;
	}
	public int getPuntajeTotal() {
		return puntajeTotal;
	}
	public void setPuntajeTotal(int puntajeTotal) {
		this.puntajeTotal = puntajeTotal;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public String toString() {
		return "PruebaAutomaticaDTO [idTema=" + idTema + ", cantPreguntas=" + cantPreguntas + ", puntajeTotal="
				+ puntajeTotal + ", titulo=" + titulo + ", descripcion=" + descripcion + "]";
	}
	
	
	
	
}
