package br.edu.ibmec.projeto_verduras_legumes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ibmec.projeto_verduras_legumes.models.Newsletter;
import br.edu.ibmec.projeto_verduras_legumes.services.NewsletterService;

@Controller
@RequestMapping("/newsletter")
public class NewsletterController {
	@Autowired
	NewsletterService newsletterService;

	@PostMapping("/register")
	public String register_newsletter(Newsletter newsletter) {
		newsletterService.save(newsletter);

		// try to redirect maybe....

		// todo
		return "/error";
	}
}
