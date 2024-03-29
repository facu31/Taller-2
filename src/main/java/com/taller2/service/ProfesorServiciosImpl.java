package com.taller2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taller2.model.Profesor;
import com.taller2.service.dao.ProfesorDAO;

@Service
public class ProfesorServiciosImpl implements ProfesorServicios{
	@Autowired
	ProfesorDAO profesorDAO;
	
	@Override
	public List<Profesor> obtenerProfesores() {
		return profesorDAO.obtenerProfesores();
	}

	@Override
	public void grabar(Profesor profesor) {
		profesorDAO.altaProfesor(profesor);
	}

	public void borrarProfesor(int id) {
		profesorDAO.borrarProfesor(id);
	}

	@Override
	public Profesor buscarProfesor(int idProfesor) {
		return profesorDAO.buscarProfesor(idProfesor);
	}

	public void actualizar(Profesor profesor) {
		profesorDAO.actualizarProfesor(profesor);
	}

}
