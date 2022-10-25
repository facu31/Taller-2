package com.taller2.service.dao;

import java.util.List;

import com.taller2.model.Alumno;

public interface AlumnoDAO {
	public int altaAlumno(Alumno alumno);
	
	public List<Alumno> obtenerAlumnos();
	
	public Alumno buncarAlumno(String usuario);

	public Object borrarAlumno(int id);
	
	
}
