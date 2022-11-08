package com.taller2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.taller2.dto.login.UsuarioDTO;
import com.taller2.sesion.SesionActiva;

@Controller
public class MenuController {

	@Autowired
	private SesionActiva sesion;
	
	@GetMapping("/principal")
	public String principal(Model model) {

		return "principal";

	}
	
	@GetMapping("/menu")
	public String menu(Model model) {
		if (sesion.getUsuario() != null)  {
			model.addAttribute("usuario", sesion.getUsuario().getTipo());
			if (sesion.isEstudiante() ||sesion.isProfesor() || sesion.isAdmin()) {
				return "menu";
			}
			return "redirect:/login";
		}
		return "redirect:/login";
		
	}
	
}
