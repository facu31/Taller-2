package com.taller2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.taller2.model.Profesor;
import com.taller2.service.ProfesorServiciosImpl;

@Controller
public class ProfesorController {
	
	@Autowired
	private ProfesorServiciosImpl profesorServiciosImpl;
	
	/* este request se invoca cuando de llama a la página de nuevo profesor */
	@GetMapping("/agregarProfesor")
    public String grabarProfesor(Model model) {
		Profesor profesor = new Profesor();
		model.addAttribute("profesor", profesor);
        return "nuevoProfesor";
    }
	
	/* este request se llama desde el boton grabar de la página de nuevo empleado */
	@PostMapping("/saveProfesor")
    public String saveEmployee(@ModelAttribute("profesor") Profesor profesor) {
        profesorServiciosImpl.grabar(profesor);
        return "redirect:/profesores";
    }
	
	@GetMapping("/profesores")
    public String mantenimeintoProfesores(Model model) {
        model.addAttribute("profesores", profesorServiciosImpl.obtenerProfesores());
        return "manteProfesores"; 
        
    }
	
}
