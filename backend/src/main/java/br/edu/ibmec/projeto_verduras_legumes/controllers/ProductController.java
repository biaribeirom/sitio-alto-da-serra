package br.edu.ibmec.projeto_verduras_legumes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.ibmec.projeto_verduras_legumes.models.Product;
import br.edu.ibmec.projeto_verduras_legumes.models.ProductView;
import br.edu.ibmec.projeto_verduras_legumes.models.Resource;
import br.edu.ibmec.projeto_verduras_legumes.services.ProductService;
import br.edu.ibmec.projeto_verduras_legumes.services.ProductViewService;
import br.edu.ibmec.projeto_verduras_legumes.services.ResourceService;
import br.edu.ibmec.projeto_verduras_legumes.utils.ModelHelper;

@Controller
@RequestMapping("/produtos")
public class ProductController {
	@Autowired
	private ProductService productService;
	@Autowired
	private ResourceService resourceService;
	@Autowired
	private ProductViewService productViewService;

	// @PostMapping({ "/login" })
	// public String login(@RequestBody UserModel userModel) {
	// return "login";
	// }

	@GetMapping("/{id}")
	public String interface_register(@PathVariable("id") Integer id, Model model) {
		ModelHelper modelHelper = new ModelHelper(resourceService, model);

		modelHelper.addBanner();

		// ! trampo da bia
		productViewService.incrementView(id);

		Product product = productService.findByID(id);
		model.addAttribute("product", product);

		modelHelper.addFooterThings();

		return "/product";
	}

	// talvez desativar isso / colocar auth seria bom,
	// todo
	@PostMapping("/upload")
	public @ResponseBody String process_register(@RequestParam("image") MultipartFile image, Product product) {
		try {
			product.image = image.getBytes();

		} catch (IOException e) {
			e.printStackTrace();
			return "it in fact did not work";
		}

		productService.save(product);

		return "product uploaded, id is: " + product.getId();
	}

	@GetMapping({ "", "/", "/home" })
	public String catalogo(Model model) {
		ModelHelper modelHelper = new ModelHelper(resourceService, model);

		// different banner
		modelHelper.addResource(24, "banner");

		Product[] products = productService.getProducts();
		model.addAttribute("products", products);

		modelHelper.addFooterThings();

		modelHelper.addEmptyNewsletter();

		return "/catalogo";
	}

}
