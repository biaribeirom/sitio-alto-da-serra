package br.edu.ibmec.projeto_verduras_legumes.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ibmec.projeto_verduras_legumes.models.Resource;
import br.edu.ibmec.projeto_verduras_legumes.services.ResourceService;

@Controller
@RequestMapping("/")
public class ProjetoController {
	@Autowired
	ResourceService resourceService;

	@GetMapping({ "", "/", "/index", "/index.html", "/home" })
	public String index(Model model) {
		Resource banner = resourceService.findByID(1);
		model.addAttribute("banner", banner);

		Resource about = resourceService.findByID(2);
		// System.out.println(aboutImage);
		model.addAttribute("about", about);

		Resource dummyProduct1 = resourceService.findByID(3);
		model.addAttribute("dummy_product_1", dummyProduct1);
		Resource dummyProduct2 = resourceService.findByID(4);
		model.addAttribute("dummy_product_2", dummyProduct2);
		Resource dummyProduct3 = resourceService.findByID(5);
		model.addAttribute("dummy_product_3", dummyProduct3);

		Resource testimonial1 = resourceService.findByID(6);
		model.addAttribute("testimonial_1", testimonial1);
		Resource testimonial2 = resourceService.findByID(7);
		model.addAttribute("testimonial_2", testimonial2);
		Resource testimonial3 = resourceService.findByID(8);
		model.addAttribute("testimonial_3", testimonial3);

		Resource email = resourceService.findByID(9);
		model.addAttribute("email", email);
		Resource phone = resourceService.findByID(10);
		model.addAttribute("phone", phone);
		Resource address = resourceService.findByID(11);
		model.addAttribute("address", address);

		Resource facebook = resourceService.findByID(12);
		model.addAttribute("facebook", facebook);
		Resource instagram = resourceService.findByID(13);
		model.addAttribute("instagram", instagram);
		Resource whatsapp = resourceService.findByID(14);
		model.addAttribute("whatsapp", whatsapp);

		// String[] products = productService.getProducts();

		return "/index";
	}
}
