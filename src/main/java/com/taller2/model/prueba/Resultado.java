package com.taller2.model.prueba;

import java.util.Date;

import com.taller2.model.Alumno;

public class Resultado {
	private int id;
	private Alumno alumno;
	private Date fecha;
	private Prueba prueba;
	private int cantPreguntas;
	private int cantPregunasBien;
	
	
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
	public int getCantPregunasBien() {
		return cantPregunasBien;
	}
	public void setCantPregunasBien(int cantPregunasBien) {
		this.cantPregunasBien = cantPregunasBien;
	}
	@Override
	public String toString() {
		 return this.getCantPregunasBien()+ " preguntas correctas de un total de " + this.getCantPreguntas();
	}
	
}
