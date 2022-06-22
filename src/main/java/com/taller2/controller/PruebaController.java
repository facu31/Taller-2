package com.taller2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.taller2.service.PruebaServiciosImpl;

@Controller
public class PruebaController {

	@Autowired
	private PruebaServiciosImpl pruebaServiciosImpl;
	
 	@GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("pruebas", pruebaServiciosImpl.obtenerPrubas());
        return "pruebasExistentes";
    }
}
