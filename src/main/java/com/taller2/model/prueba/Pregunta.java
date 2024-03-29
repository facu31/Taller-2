package com.taller2.model.prueba;

import java.util.List;

public class Pregunta {
	public static final int TIPO_SELECCION = 1;
	public static final int TIPO_INGRESO = 2;
	
	private int id;
	private int tipo;
	private String enunciado;
	private List<Opcion> opciones;
	private int idOpcionCorrecta;
	private int puntaje;
	private int IdTema;
	
	
	private Integer idOpcionIngresada;
	
	public Pregunta(int id, String enunciado, int idOpcCorrecta, int IdTema, int tipo, int puntaje) {
		this.id = id;
		this.enunciado = enunciado;
		this.idOpcionCorrecta = idOpcCorrecta;
		this.IdTema = IdTema;
		this.tipo = tipo;
		this.puntaje = puntaje;
	}
	
	public Pregunta(int id, String enunciado, int idOpcCorrecta, int IdTema, int tipo) {
		this.id = id;
		this.enunciado = enunciado;
		this.idOpcionCorrecta = idOpcCorrecta;
		this.IdTema = IdTema;
		this.tipo = tipo;
	}
	
	public Pregunta() {
		
	}

	public Pregunta(int id) {
		this.id = id;
	}

	public Integer getIdOpcionIngresada() {
		return idOpcionIngresada;
	}

	public void setIdOpcionIngresada(Integer idOpcionIngresada) {
		this.idOpcionIngresada = idOpcionIngresada;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public List<Opcion> getOpciones() {
		return opciones;
	}

	public void setOpciones(List<Opcion> opciones) {
		this.opciones = opciones;
	}

	public int getIdOpcionCorrecta() {
		return idOpcionCorrecta;
	}

	public void setIdOpcionCorrecta(int idOpcionCorrecta) {
		this.idOpcionCorrecta = idOpcionCorrecta;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

	public int getIdTema() {
		return IdTema;
	}

	public void setIdTema(int idTema) {
		IdTema = idTema;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	
	
	
}
