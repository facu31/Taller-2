package com.taller2.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MenuController {

	@GetMapping("/menu")
    public String menu (Model model) {
 		
 		return "Menu";

	}
	
 		@GetMapping("/MenuEstudiante")
 	    public String MenuEstudiante (Model model) {
 	 		
 	 		return "MenuEstudiante";

	}
 		
 		@GetMapping("/MenuProfesor")
 	    public String MenuProfesor (Model model) {
 	 		
 	 		return "MenuProfesor";

	}
}
