package com.taller2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.taller2.model.Alumno;
import com.taller2.model.Profesor;
import com.taller2.service.AlumnoServiciosImpl;

@Controller
public class AlumnoController {
	
	@Autowired
	private AlumnoServiciosImpl alumnoServiciosImpl;
	
	/* este request se invoca cuando de llama a la página de nuevo alumno */
	@GetMapping("/alumno/agregarAlumno")
    public String grabaralumno(Model model) {
		Alumno alumno = new Alumno();
		model.addAttribute("alumno", alumno);
        return "nuevoAlumno";
    }
	
	@PostMapping("/alumno/saveAlumno")
    public String saveAlumno(@ModelAttribute("alumno") Alumno alumno) {
        alumnoServiciosImpl.grabar(alumno);
        return "redirect:/alumno/listadoAlumnos";
    }
	
	@GetMapping("/alumno/listadoAlumnos")
    public String mantenimientoAlumnos(Model model) {
        model.addAttribute("alumnos", alumnoServiciosImpl.obtenerAlumnos());
        return "manteAlumno"; 
        
    }
	
	@GetMapping("/alumno/borrar/{id}")
    public String borrarAlumno(@PathVariable(value = "id") int id, Model model) {
		try {
			alumnoServiciosImpl.borrarAlumno(id); 
			
		} catch (Exception e) {
 			System.out.println(e.getMessage());
 			model.addAttribute("mensaje", "No se puede borrar un alumno que tenga resultados asociados.");
 			return "error/error";
 		}

		 return "redirect:/alumno/listadoAlumnos";
    }
	
}
