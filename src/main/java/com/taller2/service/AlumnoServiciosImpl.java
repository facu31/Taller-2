package com.taller2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taller2.model.Alumno;
import com.taller2.model.Profesor;
import com.taller2.service.dao.AlumnoDAO;

@Service
public class AlumnoServiciosImpl implements AlumnoServicios{
	@Autowired
	AlumnoDAO alumnoDAO;
	
	@Override
	public List<Alumno> obtenerAlumnos() {
		return alumnoDAO.obtenerAlumnos();
	}

	@Override
	public void grabar(Alumno alumno) {
		alumnoDAO.altaAlumno(alumno);
	}

	public void borrarAlumno(int id) {
		alumnoDAO.borrarAlumno(id);
	}

}
