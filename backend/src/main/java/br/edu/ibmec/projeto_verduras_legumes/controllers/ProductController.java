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
import br.edu.ibmec.projeto_verduras_legumes.models.Resource;
import br.edu.ibmec.projeto_verduras_legumes.services.ProductService;
import br.edu.ibmec.projeto_verduras_legumes.services.ResourceService;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;
	@Autowired
	private ResourceService resourceService;

	// @PostMapping({ "/login" })
	// public String login(@RequestBody UserModel userModel) {
	// return "login";
	// }

	@GetMapping("/{id}")
	public String interface_register(@PathVariable("id") Integer id, Model model) {
		Resource banner = resourceService.findByID(1);
		model.addAttribute("banner", banner);

		Product product = productService.findByID(id);
		model.addAttribute("product", product);

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

		return "/product";
	}

	@PostMapping("/create")
	public @ResponseBody String process_register(@RequestParam("image") MultipartFile image, Product product) {
		try {
			product.image = image.getBytes();

		} catch (IOException e) {
			e.printStackTrace();
			return "it in fact did not work";
		}

		productService.save(product);

		return "it worked uhhh the id is " + product.getId();
	}

}
