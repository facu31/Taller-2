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
	
	
	
	public Resultado() {
		
	}
	public Resultado(int id, Alumno alumno, Date fecha, Prueba prueba, int cantPreguntas, int cantRespuestasBien) {
		this.id = id;
		this.alumno = alumno;
		this.fecha = fecha;
		this.prueba = prueba;
		this.cantPreguntas = cantPreguntas;
		this.cantRespuestasBien = cantRespuestasBien;
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
	@Override
	public String toString() {
		 return this.getCantRespuestasBien()+ " preguntas correctas de un total de " + this.getCantPreguntas();
	}
	
}
