package com.taller2.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class Sistema {
	/* esto es porque no tengo una base de datos, después se borra */
	private List<Profesor> profesores;
	
	public Sistema() {
	}
	
	public List<Profesor> listaProfesores() {
		return profesores;
	}
}
