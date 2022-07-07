package com.taller2.service.dao;

import java.util.List;

import com.taller2.model.prueba.Opcion;
import com.taller2.model.prueba.Pregunta;
import com.taller2.model.prueba.Prueba;

public interface PruebaDAO {
	
	public List<Prueba> obtenerPruebas();
	public Prueba obtenerPrueba(int idPrueba);
	public List<Pregunta> obtenerPreguntas(int idPrueba);
	public List<Opcion> obtenerOpciones(int idPregunta);
}
