package com.taller2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.taller2.model.Profesor;
import com.taller2.model.prueba.Prueba;
import com.taller2.service.ProfesorServiciosImpl;

@Controller
public class ProfesorController {
	
	@Autowired
	private ProfesorServiciosImpl profesorServiciosImpl;
	
	/* este request se invoca cuando de llama a la página de nuevo profesor */
	@GetMapping("/profesor/agregarProfesor")
    public String grabarProfesor(Model model) {
		Profesor profesor = new Profesor();
		model.addAttribute("profesor", profesor);
        return "nuevoProfesor";
    }
	
	@PostMapping("/profesor/saveProfesor")
    public String saveEmployee(@ModelAttribute("profesor") Profesor profesor) {
        profesorServiciosImpl.grabar(profesor);
        return "redirect:/profesor/listadoProfesores";
    }
	
	@GetMapping("/profesor/listadoProfesores")
    public String mantenimeintoProfesores(Model model) {
        model.addAttribute("profesores", profesorServiciosImpl.obtenerProfesores());
        return "manteProfesores"; 
        
    }
	
	@GetMapping("/profesor/borrar/{id}")
    public String borrarProfesor(@PathVariable(value = "id") int id, Model model) {
		try {
			profesorServiciosImpl.borrarProfesor(id);
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
			model.addAttribute("mensaje", "No se puede borrar un profesor que haya creado pruebas.");
			return "error/error";
		}
		 return "redirect:/profesor/listadoProfesores";
    }
	
}
