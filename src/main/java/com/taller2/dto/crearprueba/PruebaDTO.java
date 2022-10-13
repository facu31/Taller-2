package com.taller2.dto.crearprueba;

import java.util.Arrays;

public class PruebaDTO {
	private String titulo;
	private String desc;
	private PreguntaDTO[] preguntas;
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public PreguntaDTO[] getPreguntas() {
		return preguntas;
	}
	public void setPreguntas(PreguntaDTO[] preguntas) {
		this.preguntas = preguntas;
	}
	@Override
	public String toString() {
		return "PruebaDTO [titulo=" + titulo + ", desc=" + desc + ", preguntas=" + Arrays.toString(preguntas) + "]";
	}
	
	
	
}
