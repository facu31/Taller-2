package com.taller2.service;

import java.util.List;

import com.taller2.model.Alumno;

public interface AlumnoServicios
{
	public List<Alumno> obtenerAlumnos();
	public void grabar(Alumno alumno);
	void borrarAlumno(int id);
}
