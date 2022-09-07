package com.taller2.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.taller2.model.prueba.Materia;
import com.taller2.model.prueba.Pregunta;
import com.taller2.model.prueba.Prueba;
import com.taller2.model.prueba.Tema;
import com.taller2.service.PruebaServiciosImpl;
import com.taller2.view.prueba.PreguntaDTO;
import com.taller2.view.prueba.PruebaAutomaticaDTO;

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
 	
 	
 	
 	@PostMapping("prueba/guardarPrueba")
    public String guardarPrueba(@RequestBody PreguntaDTO[] preguntas) {
      
 		Prueba prueba = new Prueba();
 		prueba.setDesc("hola");
 		prueba.setTitulo("mundo");
 		pruebaServiciosImpl.guardarPrueba(prueba, Arrays.asList(preguntas));
        
        return "prueba/pruebasExistentes"; 
    }
 	
 	@GetMapping("prueba/formularioCrearPruebaAutomatica")
 	public String crearPruebaAutomatica(Model model) {
 		PruebaAutomaticaDTO prueba = new PruebaAutomaticaDTO();
		model.addAttribute("prueba", prueba);
 		return "prueba/crearPruebaAutomatica";
 	}
 	
 	@PostMapping("prueba/generarPruebaAutomatica")
 	public String generarPruebaAutomatica(@RequestBody com.taller2.view.prueba.PruebaAutomaticaDTO confPrueba) {
 		System.out.println(confPrueba);
 		
 		Prueba prueba = new Prueba();
 		prueba.setDesc(confPrueba.getDescripcion());
 		prueba.setTitulo(confPrueba.getTitulo());
 		
 		List<Pregunta> preguntas = pruebaServiciosImpl.obtenerPreguntasAleatoriamente(
 				confPrueba.getCantPreguntas(), confPrueba.getIdTema());
 		
 		
 		pruebaServiciosImpl.guardarPrueba(prueba, PreguntaDTO.buildPreguntaDTO(preguntas));
 		return "prueba/pruebasExistentes";
 	}
 	
 	@GetMapping("/prueba/crearPregunta")
    public String agregarPregunta (Model model) {
 		
 		return "prueba/crearPregunta";
 	}
 	
 	
 	@GetMapping("/prueba/crearPregunta/verdaderoFalso")
    public String verdaderoFalsoPrincipal (Model model) {
 		
 		return "prueba/fragment_preguntaVF:: fragmento";
 	}
 	
 	@GetMapping("/prueba/crearPregunta/multipleOpcion")
    public String multipleOpcionPrincipal (Model model) {
 		
 		return "prueba/fragment_preguntaMOpcion:: fragmento";
 	}
 	
}
