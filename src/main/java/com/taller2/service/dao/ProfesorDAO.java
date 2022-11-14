package com.taller2.service.dao;

import java.util.List;

import com.taller2.model.Profesor;

public interface ProfesorDAO {
	public int altaProfesor(Profesor prof);

	public List<Profesor> obtenerProfesores();

	public Object borrarProfesor(int id);
	
	public Profesor buncarProfesor(String usuario);

	public Profesor buscarProfesor(int idProfesor);

	public void actualizarProfesor(Profesor profesor);
}
