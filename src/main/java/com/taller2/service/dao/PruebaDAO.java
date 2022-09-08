package com.taller2.service.dao;

import java.util.List;

import com.taller2.model.prueba.Materia;
import com.taller2.model.prueba.Opcion;
import com.taller2.model.prueba.Pregunta;
import com.taller2.model.prueba.Prueba;
import com.taller2.model.prueba.Tema;
import com.taller2.view.crearprueba.PreguntaDTO;

public interface PruebaDAO {
	
	public List<Prueba> obtenerPruebas();
	public Prueba obtenerPrueba(int idPrueba);
	public List<Pregunta> obtenerPreguntas(int idPrueba);
	public List<Opcion> obtenerOpciones(int idPregunta);
	public List<Materia> obtenerMaterias();
	public List<Tema> obtenerTemas();
	
	public List<Pregunta> filtrarPreguntasPorMateriaTema(int materia, int tema);
	public List<Pregunta> filtrarPreguntasPorMateria(int materia);
	public List<Pregunta> filtrarPreguntasPorTema(int tema);
	public List<Pregunta> obtenerTodasLasPreguntas();
	
	public void altaPruebaPreguntas(int idPrueba, int idPregunta);
	public void altaPrueba(Prueba prueba);
	public int obtenerIdPrueba();
	public List<Pregunta> obtenerPreguntasAleatoriamente(int cantPreguntas, int idTema);
	
	public void altaPregunta(Pregunta pregunta);
	public void altaOpcion(Opcion opcion);
	public int obtenerIdPregunta();
}
