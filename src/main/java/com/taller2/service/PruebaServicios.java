package com.taller2.service;

import java.util.List;

import com.taller2.model.prueba.Prueba;

public interface PruebaServicios {
	public List<Prueba> obtenerPruebasExistentes();
	
	public Prueba obtenerPrueba(int idPrueba);
}
