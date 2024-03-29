package com.taller2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.taller2.dto.crearpregunta.OpcionCorrelacionDTO;
import com.taller2.dto.crearpregunta.OpcionDTO;
import com.taller2.dto.crearpregunta.PreguntaCorrelacionDTO;
import com.taller2.dto.crearpregunta.PreguntaMultipleOpcionDTO;
import com.taller2.dto.crearpregunta.PreguntaRespuestaCortaDTO;
import com.taller2.dto.crearpregunta.PreguntaVFDTO;
import com.taller2.model.prueba.Opcion;
import com.taller2.model.prueba.Pregunta;
import com.taller2.model.prueba.Tema;
import com.taller2.service.PruebaServiciosImpl;

@Controller
public class PreguntaController {
	@Autowired
	private PruebaServiciosImpl pruebaServiciosImpl;

	@GetMapping("/prueba/crearPregunta")
    public String agregarPregunta (Model model) {
 		
 		return "prueba/crearPregunta";
 	}
	@GetMapping("/prueba/crearPregunta/verdaderoFalso")
    public String verdaderoFalso (Model model) {
 		List<Tema> temas = pruebaServiciosImpl.obtenerTemas();
 		PreguntaVFDTO preguntaVF = new PreguntaVFDTO();
 		
		model.addAttribute("temas", temas);
		model.addAttribute("preguntaVFDTO", preguntaVF);
		
 		return "prueba/fragment_preguntaVF:: fragmento";
 	}
 	
	@GetMapping("/prueba/crearPregunta/multipleOpcion")
    public String multipleOpcion (Model model) {
 		List<Tema> temas = pruebaServiciosImpl.obtenerTemas();
 		
		model.addAttribute("temas", temas);
 		return "prueba/fragment_preguntaMOpcion:: fragmento";
 	}
	
	@GetMapping("/prueba/crearPregunta/respuestaCorta")
    public String respuestaCorta (Model model) {
 		List<Tema> temas = pruebaServiciosImpl.obtenerTemas();
 		PreguntaRespuestaCortaDTO preguntaRC = new PreguntaRespuestaCortaDTO();
 		
		model.addAttribute("temas", temas);
		model.addAttribute("preguntaRespuestaCortaDTO", preguntaRC);
 		return "prueba/fragment_preguntaRespuestaCorta:: fragmento";
 	}
	
	@GetMapping("/prueba/crearPregunta/correlacion")
    public String correlacion (Model model) {
 		List<Tema> temas = pruebaServiciosImpl.obtenerTemas();
 		PreguntaCorrelacionDTO preguntaCorr = new PreguntaCorrelacionDTO();
 		
		model.addAttribute("temas", temas);
		model.addAttribute("preguntaCorrelacionDTO", preguntaCorr);
 		return "prueba/fragment_preguntaCorrelacion:: fragmento";
 	}

	
	
 	
 	@PostMapping("/prueba/grabarPreguntaVF")
    public String grabarPreguntaVF(@ModelAttribute("preguntaVFDTO") PreguntaVFDTO preguntaVF,
    		RedirectAttributes redirectAttributes) {
 		System.out.println(preguntaVF);
 		
 		//tranformo la información que se obtiene de la capa de presentacion en objetos del modelo
 		Pregunta pregunta = new Pregunta();
 		pregunta.setEnunciado(preguntaVF.getEnunciado());
 		pregunta.setIdOpcionCorrecta(preguntaVF.getOpcionCorrecta());
 		pregunta.setIdTema(preguntaVF.getIdTema());
 		pregunta.setTipo(Pregunta.TIPO_SELECCION);
 		
 		List<Opcion> opciones = new java.util.ArrayList<Opcion>();
 		opciones.add(new Opcion(1, "Verdadero", null));
 		opciones.add(new Opcion(2, "Falso", null));
 		pregunta.setOpciones(opciones);
 		
 		pruebaServiciosImpl.altaPreguntaConOpciones(pregunta);
 		
 		redirectAttributes.addFlashAttribute("mensajeOk",  "La pregunta se guardo correctamente");
 		return "redirect:/prueba/crearPregunta";
    }
 	
 	
 	@PostMapping("prueba/guardarPreguntaMultipleOpcion")
    public String guardarPregunta(@RequestBody PreguntaMultipleOpcionDTO preguntaMTO, 
    		RedirectAttributes redirectAttributes) {
 		
 		System.out.println(preguntaMTO);
 		
 		int idOpcion = 1;
 		int idOpcionCorrecta = 0;
 		List<Opcion> opciones = new java.util.ArrayList<Opcion>();
 		for(OpcionDTO opc:preguntaMTO.getOpciones()) {   //Recorre las opciones ingresadas
 			opciones.add(new Opcion(idOpcion++, opc.getEnunciado(), null));
 			System.out.println(opc.getEnunciado() + " " + preguntaMTO.getOpcionCorrecta());
 			if (opc.getEnunciado().trim().equals(preguntaMTO.getOpcionCorrecta().trim())) {
 				idOpcionCorrecta = idOpcion;
 			}
 		}
 		
 		Pregunta pregunta = new Pregunta();
 		pregunta.setEnunciado(preguntaMTO.getEnunciado());
 		pregunta.setTipo(Pregunta.TIPO_SELECCION);
 		pregunta.setIdOpcionCorrecta(idOpcionCorrecta-1);
 		pregunta.setIdTema(preguntaMTO.getIdTema());
 		pregunta.setOpciones(opciones);
 		
 		
        
 		pruebaServiciosImpl.altaPreguntaConOpciones(pregunta);
 		
 		redirectAttributes.addFlashAttribute("mensajeOk",  "La pregunta se guardo correctamente");
 		return "redirect:/prueba/crearPregunta";
    }
 	
 	@PostMapping("/prueba/grabarPreguntaRespuestaCorta")
    public String grabarPreguntaRespuestaCorta(@ModelAttribute("preguntaRespuestaCortaDTO") PreguntaRespuestaCortaDTO preguntaRespuestaCorta,
    		RedirectAttributes redirectAttributes) {
 		
 		System.out.println(preguntaRespuestaCorta);
 		
 		Pregunta pregunta = new Pregunta();
 		pregunta.setEnunciado(preguntaRespuestaCorta.getEnunciado());
 		pregunta.setTipo(Pregunta.TIPO_INGRESO);
 		pregunta.setIdOpcionCorrecta(0); //en este tipo de pregunta no hay una opción correcta
 		pregunta.setIdTema(preguntaRespuestaCorta.getIdTema());
 		
 		
 		List<Opcion> opciones = new java.util.ArrayList<Opcion>();
 		//este tipo de opciones no tiene descripcion
 		opciones.add(new Opcion(1, "",preguntaRespuestaCorta.getOpcionCorrecta()));
 		pregunta.setOpciones(opciones);
 		
 		pruebaServiciosImpl.altaPreguntaConOpciones(pregunta);
 		
 		return "redirect:/prueba/crearPregunta";
 	}
 	
 	
 	@PostMapping("prueba/guardarPreguntaCorrelacion")
    public String guardarPreguntaCorrelacion(@RequestBody PreguntaCorrelacionDTO preguntaDTO, 
    		RedirectAttributes redirectAttributes) {
 		
 		System.out.println(preguntaDTO);
 		
 		int idOpcion = 1;
 		List<Opcion> opciones = new java.util.ArrayList<Opcion>();
 		for(OpcionCorrelacionDTO opc:preguntaDTO.getOpciones()) {   //Recorre las opciones ingresadas
 			opciones.add(new Opcion(idOpcion++, opc.getEnunciado(), opc.getValorCorrecto()));
 		}
 		
 		Pregunta pregunta = new Pregunta();
 		pregunta.setEnunciado(preguntaDTO.getEnunciado());
 		pregunta.setTipo(Pregunta.TIPO_INGRESO);
 		pregunta.setIdOpcionCorrecta(0);
 		pregunta.setIdTema(preguntaDTO.getIdTema());
 		
 		pregunta.setOpciones(opciones);
 		
 		
        
 		pruebaServiciosImpl.altaPreguntaConOpciones(pregunta);
 		
 		redirectAttributes.addFlashAttribute("mensajeOk",  "La pregunta se guardo correctamente");
 		return "redirect:/prueba/crearPregunta";
    }
 	
 	@GetMapping("/pregunta/listarPreguntas")
    public String listarPreguntas(Model model) {
 		model.addAttribute("preguntas", pruebaServiciosImpl.obtenerPreguntasExistentes());
        return "pregunta/preguntasExistentes"; 
 	}
 	
 	
 	@GetMapping("pregunta/borrar/{id}")
    public String borrarPregunta(@PathVariable(value = "id") int id, Model model) {
 		try {
 			pruebaServiciosImpl.borrarPregunta(id);
 			return "redirect:/pregunta/listarPreguntas";
 		}catch (Exception e) {
 			System.out.println(e.getMessage());
 			model.addAttribute("mensaje", "No se puede borrar una pregunta que este incluida en una Prueba.");
 			return "error/error";
 		}
    }
 	
 	@GetMapping("pregunta/verOpciones/{id}")
    public String verOpciones(@PathVariable(value = "id") int id, Model model) {
		model.addAttribute("pregunta", pruebaServiciosImpl.obtenerPregunta(id));
		return "pregunta/listarOpciones";
 		
    }
 	
	
 	
 	
}
