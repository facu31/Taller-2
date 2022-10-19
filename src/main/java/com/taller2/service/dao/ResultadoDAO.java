package com.taller2.service.dao;

import java.util.List;

import com.taller2.model.prueba.Resultado;

public interface ResultadoDAO {
	public void grabarResultado(Resultado resultado);

	public List<Resultado> obtenerResultados(int id);
}
