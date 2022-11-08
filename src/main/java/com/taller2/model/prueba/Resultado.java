package com.taller2.model.prueba;

import java.util.Date;

import com.taller2.model.Alumno;

public class Resultado {
	private int id;
	private Alumno alumno;
	private Date fecha;
	private Prueba prueba;
	private int cantPreguntas;
	private int cantRespuestasBien;
	private int puntajeObtenido;
	private int puntajeMaximoPrueba;
	private int porcentaje;
	
	public Resultado() {
		
	}
	public Resultado(int id, Alumno alumno, Date fecha, Prueba prueba, int cantPreguntas, int cantRespuestasBien,
			int puntajeObtenido, int puntajeMaximoPrueba) {
		this.id = id;
		this.alumno = alumno;
		this.fecha = fecha;
		this.prueba = prueba;
		this.cantPreguntas = cantPreguntas;
		this.cantRespuestasBien = cantRespuestasBien;
		this.puntajeObtenido = puntajeObtenido;
		this.puntajeMaximoPrueba = puntajeMaximoPrueba;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Alumno getAlumno() {
		return alumno;
	}
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Prueba getPrueba() {
		return prueba;
	}
	public void setPrueba(Prueba prueba) {
		this.prueba = prueba;
	}
	public int getCantPreguntas() {
		return cantPreguntas;
	}
	public void setCantPreguntas(int cantPreguntas) {
		this.cantPreguntas = cantPreguntas;
	}
	public int getCantRespuestasBien() {
		return cantRespuestasBien;
	}
	public void setCantRespuestasBien(int cantPregunasBien) {
		this.cantRespuestasBien = cantPregunasBien;
	}
	
	public int getPuntajeObtenido() {
		return puntajeObtenido;
	}
	public void setPuntajeObtenido(int puntajeObtenido) {
		this.puntajeObtenido = puntajeObtenido;
	}
	public int getPuntajeMaximoPrueba() {
		return puntajeMaximoPrueba;
	}
	public void setPuntajeMaximoPrueba(int puntajeMaximoPrueba) {
		this.puntajeMaximoPrueba = puntajeMaximoPrueba;
	}
	public int getPorcentaje() {
		return porcentaje;
	}
	public void setPorcentaje(int porcentaje) {
		this.porcentaje = porcentaje;
	}
	
	
	
}
