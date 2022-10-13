package com.taller2.dto.crearprueba;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.taller2.model.prueba.Pregunta;

public class PreguntaDTO {
	@JsonAlias("Id")
	private int id;
	
	@JsonAlias("Pregunta")
	private String enunciado;
	
	@JsonAlias("Puntos")
	private int puntos;
	
	@JsonAlias("idMateria")
	private int idMateria;
	
	
	
	
	public PreguntaDTO(int id, String enunciado, int puntos, int idMateria) {
		this.id = id;
		this.enunciado = enunciado;
		this.puntos = puntos;
		this.idMateria= idMateria;
	}
	
	
	public PreguntaDTO(int id) {
		this.id = id;
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
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	public void setidMateria(int idMateria) {
		this.idMateria = idMateria;
	}


	public static List<PreguntaDTO> buildPreguntaDTO(List<Pregunta> preguntas) {
		List<PreguntaDTO> preguntasDTO = new java.util.ArrayList<PreguntaDTO>();
		for (Pregunta pre: preguntas) {
			preguntasDTO.add(new PreguntaDTO(pre.getId()));
		}
		return preguntasDTO;
	}


	@Override
	public String toString() {
		return "PreguntaDTO [id=" + id + ", enunciado=" + enunciado + ", puntos=" + puntos + ", idMateria=" + idMateria
				+ "]";
	}
	
	
}
