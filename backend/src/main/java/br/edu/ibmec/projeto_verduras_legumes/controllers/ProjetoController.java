package br.edu.ibmec.projeto_verduras_legumes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hotelaria-ibmec")
public class ProjetoController {
	@GetMapping({ "", "/", "/index", "/index.html", "/home" })
	public String index() {
		return "/index";
	}

	@GetMapping("/lazer/externa")
	public String lazerExterna() {
		return "/hotel/area-lazer-externa";
	}
}

// GET /hotelaria-ibmec

// RESPONSE

// "/index"
