package com.taller2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.taller2.model.prueba.Materia;
import com.taller2.model.prueba.Pregunta;
import com.taller2.model.prueba.Prueba;
import com.taller2.model.prueba.Tema;
import com.taller2.service.PruebaServiciosImpl;

@Controller
public class PruebaController {

	@Autowired
	private PruebaServiciosImpl pruebaServiciosImpl;
	
 	@GetMapping("prueba/listar")
    public String viewHomePage(Model model) {
        model.addAttribute("pruebas", pruebaServiciosImpl.obtenerPruebasExistentes());
        return "prueba/pruebasExistentes"; 
    }
 	
 	@GetMapping("prueba/realizar/{id}")
    public String nuevaPrueba(@PathVariable(value = "id") int id, Model model) {
 		Prueba prueba = pruebaServiciosImpl.obtenerPrueba(id);  
 		
        model.addAttribute("prueba", prueba);

        return "prueba/realizarPrueba";
    }
 	
 	@PostMapping("prueba/corregir")
    public String corregir(@ModelAttribute("prueba") Prueba prueba, Model model) {
        
 		model.addAttribute("resultado", prueba.calcularResultado());
        return "prueba/resultadoPrueba"; 
    }
 	
 	@GetMapping("/prueba/crearPrueba")
    public String crearPrueba(Model model) {
 		Prueba nuevaPrueba = new Prueba();
 		List<Materia> materias = pruebaServiciosImpl.obtenerMaterias();
 		materias.add(new Materia(0, "(Todas)"));
 		
 		List<Tema> temas =  pruebaServiciosImpl.obtenerTemas();
 		temas.add(new Tema(0,"(Todos)"));
 		
        model.addAttribute("prueba", nuevaPrueba);
        model.addAttribute("materias", materias);
        model.addAttribute("temas", temas); 
        
        return "prueba/crearPrueba"; 
    }
 	
 	@GetMapping("/prueba/filtrarPreguntas/materia/{idM}/tema/{idT}")
    public String filtrarPreguntas (
    		@PathVariable("idM") int idMateria,
    		@PathVariable("idT") int idTema
    		,Model model) {
 		
 		List<Pregunta> preguntasFil = pruebaServiciosImpl.filtrarPreguntas(idMateria,idTema);
 		
 		model.addAttribute("preguntasfiltradas", preguntasFil);
 		return "prueba/fragment_preguntasFiltradas:: fragmentoPreguntasFiltradas";
 	}
 	
 	
 	@GetMapping("/prueba/agregarPregunta/pregunta/{idPre}")
    public String agregarPregunta (
    		@PathVariable("idPre") int idPregunta
    		,Model model) {
 		
 		List<Pregunta> preguntasSeleccionadas = pruebaServiciosImpl.filtrarPreguntas(0,0);
 		
 		model.addAttribute("preguntasSeleccionadas", preguntasSeleccionadas);
 		return "prueba/fragment_preguntasSeleccionadas:: fragmentoPreguntasSeleccionadas";
 	}
 	
}
