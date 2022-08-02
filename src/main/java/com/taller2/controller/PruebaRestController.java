package com.taller2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taller2.model.prueba.Materia;
import com.taller2.service.PruebaServicios;

@RestController
public class PruebaRestController {
	
	@Autowired
	private PruebaServicios pruebaServicios;
	
	@GetMapping("/materias")
    public List<Materia> materias() {
        return pruebaServicios.obtenerMaterias();
    }
}
