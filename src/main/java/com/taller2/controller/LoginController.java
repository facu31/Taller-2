package com.taller2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.taller2.dto.login.UsuarioDTO;
import com.taller2.service.LoginServiciosImpl;

@Controller
public class LoginController {

	@Autowired
	private LoginServiciosImpl loginServices;
	
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("usuarioActivo", new UsuarioDTO());
		return "login";
	}
	
	@PostMapping("/login/ingresar")
	public String loginIngresar(@ModelAttribute("usuarioActivo") UsuarioDTO usuario, Model model, RedirectAttributes redirectAttributes) {
		if (loginServices.autenticar(usuario.getIdentificador(), usuario.getPass())) {
			return "redirect:/menu";
		} else {
			redirectAttributes.addFlashAttribute("errorMessage",  "Usuario o contraseña incorrecta");
			return "redirect:/login";
		}
		
	}
}
