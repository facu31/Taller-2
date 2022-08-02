package com.taller2.service;

import java.util.List;

import com.taller2.model.prueba.Materia;
import com.taller2.model.prueba.Prueba;
import com.taller2.model.prueba.Tema;

public interface PruebaServicios {
	public List<Prueba> obtenerPruebasExistentes();
	
	public Prueba obtenerPrueba(int idPrueba);
	
	public List<Materia> obtenerMaterias();
	public List<Tema> obtenerTemas();
}
