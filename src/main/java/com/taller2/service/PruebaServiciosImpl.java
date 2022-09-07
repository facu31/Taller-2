package com.taller2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taller2.model.prueba.Materia;
import com.taller2.model.prueba.Pregunta;
import com.taller2.model.prueba.Prueba;
import com.taller2.model.prueba.Tema;
import com.taller2.service.dao.PruebaDAO;
import com.taller2.view.prueba.PreguntaDTO;

@Service
public class PruebaServiciosImpl implements PruebaServicios {
	@Autowired
	PruebaDAO pruebaDAO;
	
	
	@Override
	public List<Prueba> obtenerPruebasExistentes() {
		return pruebaDAO.obtenerPruebas();
	}

	@Override
	public Prueba obtenerPrueba(int idPrueba) {
		Prueba prueba = pruebaDAO.obtenerPrueba(idPrueba);
		prueba.setPreguntas(pruebaDAO.obtenerPreguntas(idPrueba));
		
		for (Pregunta preg: prueba.getPreguntas()) {
			preg.setOpciones(pruebaDAO.obtenerOpciones(preg.getId()));
		}
		return prueba;
	}

	@Override
	public List<Materia> obtenerMaterias() {
		return pruebaDAO.obtenerMaterias();
	}

	@Override
	public List<Tema> obtenerTemas() {
		return pruebaDAO.obtenerTemas();
	}
	
	@Override
	public List<Pregunta> filtrarPreguntas(int idMateria, int idTema) {
		if (idMateria != 0 && idTema !=0) return pruebaDAO.filtrarPreguntasPorMateriaTema(idMateria,idTema);
		if (idMateria != 0 && idTema ==0) return pruebaDAO.filtrarPreguntasPorMateria(idMateria);
		if (idMateria == 0 && idTema !=0) return pruebaDAO.filtrarPreguntasPorTema(idTema);
		return pruebaDAO.obtenerTodasLasPreguntas();
	}

	@Override
	public void guardarPrueba(Prueba prueba, List<PreguntaDTO> preguntas) {
		//guardar registro en tabla prueba
		prueba.setId(pruebaDAO.obtenerIdPrueba());
		pruebaDAO.altaPrueba(prueba);
		
		//guardar registros en relación
		for(PreguntaDTO pregunta: preguntas) {
			pruebaDAO.altaPruebaPreguntas(prueba.getId(), pregunta.getId());
		}
	}

	public List<Pregunta> obtenerPreguntasAleatoriamente(int cantPreguntas, int idTema) {
		return pruebaDAO.obtenerPreguntasAleatoriamente(cantPreguntas, idTema);
	}
}
