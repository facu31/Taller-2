package com.taller2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.taller2.model.Prueba;

@Service
public class PruebaServiciosImpl implements PruebaServicios{

	@Override
	public List<Prueba> obtenerPrubas() {
		List<Prueba> pruebas = new ArrayList<Prueba>();
		pruebas.add(new Prueba(1,"prueba 1", "desc prueba1"));
		pruebas.add(new Prueba(2,"prueba 2", "desc prueba2"));
		return pruebas;
	}

}
