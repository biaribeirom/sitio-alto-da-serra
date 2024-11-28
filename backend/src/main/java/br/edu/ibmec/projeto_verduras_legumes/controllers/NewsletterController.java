package br.edu.ibmec.projeto_verduras_legumes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ibmec.projeto_verduras_legumes.models.Newsletter;
import br.edu.ibmec.projeto_verduras_legumes.services.NewsletterService;
import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/newsletter")
public class NewsletterController {
	@Autowired
	NewsletterService newsletterService;

	@PostMapping("/register")
	public String register_newsletter(Newsletter newsletter, HttpServletRequest request) {
		try {
			newsletterService.save(newsletter);
		} catch (Exception e) {
			// ignore exceptions, page should reload anyways....
		}

		return "redirect:" + request.getHeader("Referer");
	}

	@DeleteMapping("/delete/{id}")
	public String delete_newsletter(@PathVariable("id") Integer id, Model model, HttpServletRequest request) {
		newsletterService.delete(id);

		return "redirect:" + request.getHeader("Referer");
	}
}
