package com.taller2.service;

import java.util.List;

import com.taller2.model.Profesor;

public interface ProfesorServicios
{
	public List<Profesor> obtenerProfesores();
	public void grabar(Profesor profesor);
	public Profesor buscarProfesor(int idProfesor);
	public void actualizar(Profesor profesor);

}
