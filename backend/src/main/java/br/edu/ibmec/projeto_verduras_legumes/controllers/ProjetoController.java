package br.edu.ibmec.projeto_verduras_legumes.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ibmec.projeto_verduras_legumes.models.Product;
import br.edu.ibmec.projeto_verduras_legumes.models.Resource;
import br.edu.ibmec.projeto_verduras_legumes.services.ProductService;
import br.edu.ibmec.projeto_verduras_legumes.services.ResourceService;

@Controller
@RequestMapping("/")
public class ProjetoController {
	@Autowired
	ResourceService resourceService;

	@Autowired
	ProductService productService;

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

	@GetMapping("/sobre-nos")
	public String sobrenos(Model model) {
		Resource banner = resourceService.findByID(1);
		model.addAttribute("banner", banner);

		// Resource about = resourceService.findByID(2);
		// model.addAttribute("about", about);
		Resource about_us = resourceService.findByID(15);
		model.addAttribute("about_us", about_us);

		Resource who_are_we_image_1 = resourceService.findByID(16);
		model.addAttribute("who_are_we_image_1", who_are_we_image_1);
		Resource who_are_we_image_2 = resourceService.findByID(17);
		model.addAttribute("who_are_we_image_2", who_are_we_image_2);
		Resource who_are_we_text = resourceService.findByID(18);
		model.addAttribute("who_are_we_text", who_are_we_text);

		Resource objective_text = resourceService.findByID(19);
		model.addAttribute("objective_text", objective_text);
		Resource objective_1 = resourceService.findByID(20);
		model.addAttribute("objective_1", objective_1);
		Resource objective_2 = resourceService.findByID(21);
		model.addAttribute("objective_2", objective_2);
		Resource objective_3 = resourceService.findByID(22);
		model.addAttribute("objective_3", objective_3);
		Resource objective_4 = resourceService.findByID(23);
		model.addAttribute("objective_4", objective_4);

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

		return "/sobrenos";
	}

	@GetMapping("/produtos")
	public String catalogo(Model model) {
		// different banner
		Resource banner = resourceService.findByID(24);
		model.addAttribute("banner", banner);

		// todo implement product loading logic here
		Product[] products = productService.getProducts();
		model.addAttribute("products", products);

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

		return "/catalogo";
	}
}
