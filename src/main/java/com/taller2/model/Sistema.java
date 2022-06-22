package com.taller2.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class Sistema {
	/* esto es porque no tengo una base de datos, después se borra */
	private List<Profesor> profesores;
	
	public Sistema() {
		profesores = new ArrayList<Profesor>();
		profesores.add(new Profesor(1,"juan","perez","jp@gmail.com"));
		profesores.add(new Profesor(2,"juan","rodriguez","jro@gmail.com"));
		profesores.add(new Profesor(3,"maria","gonzalez","maria@gmail.com"));
	}
	
	public List<Profesor> listaProfesores() {
		return profesores;
	}
}
