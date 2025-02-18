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
import br.edu.ibmec.projeto_verduras_legumes.utils.ModelHelper;

@Controller
@RequestMapping("/")
public class ProjetoController {
	@Autowired
	ResourceService resourceService;

	@Autowired
	ProductService productService;

	@GetMapping({ "", "/", "/index", "/index.html", "/home" })
	public String index(Model model) {
		ModelHelper modelHelper = new ModelHelper(resourceService, model);

		modelHelper.addBanner();

		modelHelper.addResource(2, "about");

		modelHelper.addResource(3, "dummy_product_1");
		modelHelper.addResource(4, "dummy_product_2");
		modelHelper.addResource(5, "dummy_product_3");

		Product[] products = productService.getProducts();
		model.addAttribute("products", products);

		modelHelper.addResource(6, "testimonial_1");
		modelHelper.addResource(7, "testimonial_2");
		modelHelper.addResource(8, "testimonial_3");

		modelHelper.addFooterThings();

		modelHelper.addEmptyNewsletter();

		return "index";
	}

	@GetMapping("/sobre-nos")
	public String sobrenos(Model model) {
		ModelHelper modelHelper = new ModelHelper(resourceService, model);

		modelHelper.addBanner();

		modelHelper.addResource(15, "about_us");

		modelHelper.addResource(16, "who_are_we_image_1");
		modelHelper.addResource(17, "who_are_we_image_2");
		modelHelper.addResource(18, "who_are_we_text");

		modelHelper.addResource(19, "objective_text");
		modelHelper.addResource(20, "objective_1");
		modelHelper.addResource(21, "objective_2");
		modelHelper.addResource(22, "objective_3");
		modelHelper.addResource(23, "objective_4");

		modelHelper.addResource(25, "other_site");

		modelHelper.addFooterThings();

		return "sobrenos";
	}

	@GetMapping("/error")
	public String error(Model model) {
		return "error";
	}
}
