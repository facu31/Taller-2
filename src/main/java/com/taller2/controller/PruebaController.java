package com.taller2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.taller2.model.prueba.Pregunta;
import com.taller2.model.prueba.Prueba;
import com.taller2.service.PruebaServiciosImpl;

@Controller
public class PruebaController {

	@Autowired
	private PruebaServiciosImpl pruebaServiciosImpl;
	
 	@GetMapping("/pruebas")
    public String viewHomePage(Model model) {
        model.addAttribute("pruebas", pruebaServiciosImpl.obtenerPruebasExistentes());
        return "pruebasExistentes"; 
    }
 	
 	@GetMapping("/realizar/{id}")
    public String nuevaPrueba(@PathVariable(value = "id") int id, Model model) {
 		Prueba prueba = pruebaServiciosImpl.obtenerPrueba(id);  
 		
        model.addAttribute("prueba", prueba);

        return "realizarPrueba";
    }
 	
 	@PostMapping("/corregir")
    public String corregir(@ModelAttribute("prueba") Prueba prueba, Model model) {
        
 		model.addAttribute("resultado", prueba.calcularResultado());
        return "resultadoPrueba"; 
    }
}
