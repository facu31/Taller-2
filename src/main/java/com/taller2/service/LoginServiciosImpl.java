package com.taller2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taller2.model.Alumno;
import com.taller2.model.Profesor;
import com.taller2.service.dao.AlumnoDAO;
import com.taller2.service.dao.ProfesorDAO;

@Service
public class LoginServiciosImpl implements LoginServicios{

	@Autowired
	ProfesorDAO profesorDAO;
	
	@Autowired
	AlumnoDAO alumnoDAO;
	
	@Override
	public boolean autenticar(String usr, String pass) {
		boolean autorizado = false;
		Profesor profesor = profesorDAO.buncarProfesor(usr);
		Alumno alumno = alumnoDAO.buncarAlumno(usr);
		if (profesor != null) {
			if (profesor.getContrasenia().equals(pass)) autorizado = true;
		} else if (alumno != null) {
			if (alumno.getContrasenia().equals(pass)) autorizado = true;
		} 
		
		return autorizado;
	}

}
