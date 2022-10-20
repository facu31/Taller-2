package com.taller2.model.prueba;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Prueba {
	public static final int PUBLICADA = 1;
	public static final int NO_PUBLICADA = 0;
	
	private int id;
	private String titulo;
	private String desc;
	private List<Pregunta> preguntas; ; 
	private int publicada;
	
	public Prueba() {
		
	}
	
	public Prueba(int id, String titulo) {
		this.id =id;
		this.titulo =titulo;
	}
	
	public Prueba(int id, String titulo, String desc, int publicada) {
		this.id = id;
		this.titulo = titulo;
		this.desc = desc;
		this.preguntas = new ArrayList<Pregunta>();
		this.publicada = publicada;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	
	public void agregarPregunta(Pregunta pregunta) {
		this.preguntas.add(pregunta);
	}

	public List<Pregunta> getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(List<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}
	
	public int getPublicada() {
		return publicada;
	}

	public void setPublicada(int publicada) {
		this.publicada = publicada;
	}

	public Resultado calcularResultado() {
		int totOk = 0;
		for(Pregunta preg: preguntas) {
			if (preg.getTipo() == Pregunta.TIPO_SELECCION) {
				if (preg.getIdOpcionIngresada().equals(preg.getIdOpcionCorrecta())) {
					totOk++;
				}
			} else {
				//preguntas de ingreso de texto libre o correlacion
				int totOpcionOk = 0;
				for (Opcion opcion:preg.getOpciones()) {
					if (opcion.getValorCorrecto().toLowerCase().trim().equals(opcion.getValorIngresado().toLowerCase().trim())) {
						totOpcionOk ++;
					}
				}
				if (preg.getOpciones().size() == totOpcionOk) {
					totOk ++;
				}
			}
			
		}
		
		Resultado resultado = new Resultado();
		resultado.setCantRespuestasBien(totOk);
		resultado.setCantPreguntas(preguntas.size());
		return resultado;
	}
	
}
