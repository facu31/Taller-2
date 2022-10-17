package com.taller2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taller2.model.Alumno;
import com.taller2.model.Profesor;
import com.taller2.service.dao.AlumnoDAO;
import com.taller2.service.dao.ProfesorDAO;
import com.taller2.sesion.SesionActiva;
import com.taller2.sesion.UsuarioActivo;

@Service
public class LoginServiciosImpl implements LoginServicios{
	
	@Autowired
	ProfesorDAO profesorDAO;
	
	@Autowired
	AlumnoDAO alumnoDAO;
	
	@Autowired
	SesionActiva sesion;
	
	@Override
	public boolean autenticar(String usr, String pass) {
		
		if (isAdmin(usr, pass)) return true;
		if (isProfesor(usr, pass)) return true;
		if (isAlumno(usr, pass)) return true;
		
		return false;
	}

	private boolean isAlumno(String usr, String pass) {
		boolean isAlumno = false;
		Alumno alumno = alumnoDAO.buncarAlumno(usr);
		if (alumno != null) {
			if (alumno.getContrasenia().equals(pass)) {
				sesion.setUsuario(new UsuarioActivo(alumno.getUsuario(), UsuarioActivo.USUARIO_ESTUDIANTE));
				isAlumno = true;
			} 
		}

		return isAlumno;
	}

	private boolean isProfesor(String usr, String pass) {
		boolean isProfesor = false;
		Profesor profesor = profesorDAO.buncarProfesor(usr);
		if (profesor != null) {
			if (profesor.getContrasenia().equals(pass)) {
				isProfesor = true;
				sesion.setUsuario(new UsuarioActivo(profesor.getUsuario(), UsuarioActivo.USUARIO_PROFESOR));
			}
		}
		return isProfesor;
	}

	private boolean isAdmin(String usr, String pass) {
		if (usr.equals(UsuarioActivo.ADMIN_USR) && pass.equals(UsuarioActivo.ADMIN_PASS)) {
			sesion.setUsuario(new UsuarioActivo(UsuarioActivo.ADMIN_USR, UsuarioActivo.USUARIO_ADMIN));
			return true;
		} else {
			return false;
		}
	}
}
