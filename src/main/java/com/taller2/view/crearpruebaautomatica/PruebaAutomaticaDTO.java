package com.taller2.view.crearpruebaautomatica;

import java.util.List;

import com.taller2.model.prueba.Tema;

public class PruebaAutomaticaDTO {
	private Integer cantPreguntas;
	private Integer puntajeTotal;
	private String titulo;
	private String descripcion;
	private int temaSeleccionado;
	

	public int getTemaSeleccionado() {
		return temaSeleccionado;
	}


	public void setTemaSeleccionado(int temaSeleccionado) {
		this.temaSeleccionado = temaSeleccionado;
	}


	
	public Integer getCantPreguntas() {
		return cantPreguntas;
	}


	public void setCantPreguntas(Integer cantPreguntas) {
		this.cantPreguntas = cantPreguntas;
	}


	
	public Integer getPuntajeTotal() {
		return puntajeTotal;
	}


	public void setPuntajeTotal(Integer puntajeTotal) {
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
		return "PruebaAutomaticaDTO [idTema=" + temaSeleccionado+ ", cantPreguntas=" + cantPreguntas + ", puntajeTotal="
				+ puntajeTotal + ", titulo=" + titulo + ", descripcion=" + descripcion + "]";
	}
	
	
	
	
}
