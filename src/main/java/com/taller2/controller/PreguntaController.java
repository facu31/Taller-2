package com.taller2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.taller2.model.prueba.Tema;
import com.taller2.service.PruebaServiciosImpl;
import com.taller2.view.prueba.PruebaAutomaticaDTO;
import com.taller2.view.prueba.crearpreguntavf.PreguntaVFDTO;

@Controller
public class PreguntaController {
	@Autowired
	private PruebaServiciosImpl pruebaServiciosImpl;

	@GetMapping("/prueba/crearPregunta")
    public String agregarPregunta (Model model) {
 		
 		return "prueba/crearPregunta";
 	}
	@GetMapping("/prueba/crearPregunta/verdaderoFalso")
    public String verdaderoFalsoPrincipal (Model model) {
 		List<Tema> temas = pruebaServiciosImpl.obtenerTemas();
 		PreguntaVFDTO preguntaVF = new PreguntaVFDTO();
 		
		model.addAttribute("temas", temas);
		model.addAttribute("preguntaVFDTO", preguntaVF);
		
 		return "prueba/fragment_preguntaVF:: fragmento";
 	}
 	
 	@GetMapping("/prueba/crearPregunta/multipleOpcion")
    public String multipleOpcionPrincipal (Model model) {
 		List<Tema> temas = pruebaServiciosImpl.obtenerTemas();
 		
		model.addAttribute("temas", temas);
 		return "prueba/fragment_preguntaMOpcion:: fragmento";
 	}
 	
 	@PostMapping("/prueba/grabarPreguntaVF")
    public String grabarPreguntaVF(@ModelAttribute("pruebaAutomaticaDTO") PreguntaVFDTO preguntaVF) {
 		System.out.println(preguntaVF);
        return ""; 
    }
}
