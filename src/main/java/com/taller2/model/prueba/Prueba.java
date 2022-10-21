package com.taller2.model.prueba;

import java.util.ArrayList;
import java.util.List;

import com.taller2.model.Profesor;

import lombok.Getter;
import lombok.Setter;

public class Prueba {
	public static final int PUBLICADA = 1;
	public static final int NO_PUBLICADA = 0;
	
	private int id;
	private String titulo;
	private String desc;
	private List<Pregunta> preguntas; ; 
	private int publicada;
	private Profesor profesor;
	
	
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

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public Prueba() {
		
	}
	
	public Prueba(int id, String titulo) {
		this.id =id;
		this.titulo =titulo;
	}
	
	public Prueba(int id, String titulo, String desc, int publicada, Profesor profesor) {
		this.id = id;
		this.titulo = titulo;
		this.desc = desc;
		this.preguntas = new ArrayList<Pregunta>();
		this.publicada = publicada;
		this.profesor = profesor;
	}
	


	public Resultado calcularResultado() {
		int totOk = 0;
		int puntajeTotal = 0;
		int puntajePrueba = 0;
		for(Pregunta preg: preguntas) {
			puntajePrueba = puntajePrueba + preg.getPuntaje();
			
			if (preg.getTipo() == Pregunta.TIPO_SELECCION) {
				if (preg.getIdOpcionIngresada().equals(preg.getIdOpcionCorrecta())) {
					totOk++;
					puntajeTotal = puntajeTotal + preg.getPuntaje();
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
					puntajeTotal =puntajeTotal + preg.getPuntaje();
				}
			}
			
		}
		
		Resultado resultado = new Resultado();
		resultado.setCantRespuestasBien(totOk);
		resultado.setCantPreguntas(preguntas.size());
		resultado.setPuntajeMaximoPrueba(puntajePrueba);
		resultado.setPuntajeObtenido(puntajeTotal);
		return resultado;
	}
	
}
