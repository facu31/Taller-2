package com.taller2.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.taller2.dto.crearprueba.PreguntaDTO;
import com.taller2.dto.crearprueba.PruebaAutomaticaDTO;
import com.taller2.dto.crearprueba.PruebaDTO;
import com.taller2.model.prueba.Materia;
import com.taller2.model.prueba.Pregunta;
import com.taller2.model.prueba.Prueba;
import com.taller2.model.prueba.Resultado;
import com.taller2.model.prueba.Tema;
import com.taller2.service.PruebaServiciosImpl;
import com.taller2.sesion.SesionActiva;

@Controller
public class PruebaController {

	@Autowired
	private PruebaServiciosImpl pruebaServiciosImpl;
	
	@Autowired 
	private SesionActiva sesion;
	
	
 	@GetMapping("prueba/listadoPruebasParaProfesores")
    public String listadoPruebasParaProfesores(Model model) {
        model.addAttribute("pruebas", pruebaServiciosImpl.obtenerPruebasExistentes());
        return "prueba/listadoPruebasParaProfesores"; 
    }
 	
 	@GetMapping("prueba/realizar/{id}")
    public String nuevaPrueba(@PathVariable(value = "id") int id, Model model) {
 		Prueba prueba = pruebaServiciosImpl.obtenerPrueba(id);  
 		
        model.addAttribute("prueba", prueba);

        return "prueba/realizarPrueba";
    }
 	
 	@GetMapping("prueba/listadoPruebasParaEstudiantes")
    public String viewHomePage(Model model) {
        model.addAttribute("pruebas", pruebaServiciosImpl.obtenerPruebasPublicadas());
        return "prueba/listadoPruebasParaEstudiantes"; 
    }
 	
 	@PostMapping("prueba/corregir")
    public String corregir(@ModelAttribute("prueba") Prueba prueba, Model model) {
 		Resultado resultado = pruebaServiciosImpl.calcularResultado(prueba);
 		
 		model.addAttribute("resultado", resultado.toString());
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
    public String guardarPrueba(@RequestBody PruebaDTO pruebaDTO) {
 		System.out.println("Se esta guardando la prueba");
 		
 		Prueba prueba = new Prueba();
 		prueba.setDesc(pruebaDTO.getDesc());
 		prueba.setTitulo(pruebaDTO.getTitulo());
 		pruebaServiciosImpl.guardarPrueba(prueba, Arrays.asList(pruebaDTO.getPreguntas()));
        
        return "prueba/pruebasExistentes"; 
    }
 	
 	@GetMapping("prueba/formularioCrearPruebaAutomatica")
 	public String crearPruebaAutomatica(Model model) {
 		PruebaAutomaticaDTO prueba = new PruebaAutomaticaDTO();
 		
 		List<Tema> temas = pruebaServiciosImpl.obtenerTemas();
 		
		model.addAttribute("pruebaAutomaticaDTO", prueba);
		model.addAttribute("temas", temas);
		
 		return "prueba/crearPruebaAutomatica";
 	}
 	
 	@PostMapping("prueba/generarPruebaAutomatica")
 	public String generarPruebaAutomatica(@ModelAttribute("pruebaAutomaticaDTO") PruebaAutomaticaDTO confPrueba,  
 			Errors errors, RedirectAttributes redirectAttributes) {
 		System.out.println(confPrueba);
 		
 		Prueba prueba = new Prueba();
 		prueba.setDesc(confPrueba.getDescripcion());
 		prueba.setTitulo(confPrueba.getTitulo());
 		
 		List<Pregunta> preguntas = pruebaServiciosImpl.obtenerPreguntasAleatoriamente(
 				confPrueba.getCantPreguntas(), confPrueba.getTemaSeleccionado());
 		
 		if (preguntas.size() > 0) {
 			pruebaServiciosImpl.guardarPrueba(prueba, PreguntaDTO.buildPreguntaDTO(preguntas));
 			//esto quedo bastante feo, corregir cuando se pueda
 			redirectAttributes.addFlashAttribute("errorMessage",  "Preba guardadad");
 		} else {
 			System.out.println("No existen preguntas para el tema.");
 			redirectAttributes.addFlashAttribute("errorMessage",  "No hay preguntas para ese tema, no se puede crear Prueba");
 		}
 		
 		return "redirect:/prueba/formularioCrearPruebaAutomatica";
 	}
 	
 	
	@GetMapping("prueba/borrar/{id}")
    public String borrarPrueba(@PathVariable(value = "id") int id, Model model) {
 		try {
 			pruebaServiciosImpl.borrarPrueba(id);
 			return "redirect:/prueba/listadoPruebasParaProfesores";
 		}catch (Exception e) {
 			System.out.println(e.getMessage());
 			model.addAttribute("mensaje", "No se puede borrar una prueba que tenga resultados ingresados");
 			return "error/error";
 		}
    }
	
	@GetMapping("prueba/publicar/{id}")
    public String publicarPrueba(@PathVariable(value = "id") int id, Model model) {
		pruebaServiciosImpl.publicarPrueba(id);
		return "redirect:/prueba/listadoPruebasParaProfesores";
    }
 	
	
	
	@GetMapping("prueba/resultados")
 	public String listarResultados(Model model) {
 		PruebaAutomaticaDTO prueba = new PruebaAutomaticaDTO();
 		
 		List<Resultado> resultados = pruebaServiciosImpl.obtenerResultados();
 		
		model.addAttribute("resultados", resultados);
		
 		return "prueba/resultadosDeAlumno";
 	}
}
