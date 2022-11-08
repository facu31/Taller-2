package com.taller2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.taller2.model.prueba.Tema;
import com.taller2.service.TemaServiciosImpl;

@Controller
public class TemaController {
	
	@Autowired
	private TemaServiciosImpl temaServiciosImpl;
	

	@GetMapping("/tema/listar")
    public String listarTema(Model model) {
		List<Tema> temas = temaServiciosImpl.obtenerTemas();
		
		model.addAttribute("temas", temas);
        return "/temas/listarTemas";
    }

	
}
