package com.taller2.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.taller2.dto.crearprueba.PruebaDTO;
import com.taller2.model.prueba.Materia;
import com.taller2.model.prueba.Prueba;
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
