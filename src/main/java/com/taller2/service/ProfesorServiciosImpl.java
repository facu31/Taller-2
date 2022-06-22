package com.taller2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taller2.model.Profesor;
import com.taller2.model.Sistema;

@Service
public class ProfesorServiciosImpl implements ProfesorServicios{
	
	@Autowired
	private Sistema sistema;
	
	@Override
	public List<Profesor> obtenerProfesores() {
		return sistema.listaProfesores();
	}

	@Override
	public void grabar(Profesor profesor) {
		sistema.listaProfesores().add(profesor);
	}

}
