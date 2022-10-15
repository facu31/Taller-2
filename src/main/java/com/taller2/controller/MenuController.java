package com.taller2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {

	@GetMapping("/menu")
	public String menu(Model model) {

		return "Menu";

	}

	@GetMapping("/MenuEstudiante")
	public String menuEstudiante(Model model) {

		return "MenuEstudiante";

	}

	@GetMapping("/MenuProfesor")
	public String menuProfesor(Model model) {

		return "MenuProfesor";

	}
	
	@GetMapping("/MenuAdministrativo")
	public String menuAdministrativo(Model model) {

		return "MenuAdministrativo";

	}
}
