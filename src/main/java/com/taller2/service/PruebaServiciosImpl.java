package com.taller2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taller2.model.prueba.Materia;
import com.taller2.model.prueba.Pregunta;
import com.taller2.model.prueba.Prueba;
import com.taller2.model.prueba.Tema;
import com.taller2.service.dao.PruebaDAO;

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

	public List<Pregunta> filtrarPreguntas(int materia, int tema) {
		return pruebaDAO.filtrarPreguntas(materia,tema);
	}
}
