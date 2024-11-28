package br.edu.ibmec.projeto_verduras_legumes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import br.edu.ibmec.projeto_verduras_legumes.utils.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping({ "/produtos", "/products", "/product", "/produto" })
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

		// montar msg de whatsapp
		Resource phone = resourceService.findByID(10);
		String phoneString = phone.getDescription().replace(" ", "").replace("+", "").replace("(", "").replace(")", "")
				.replace("-", "");

		Product product = productService.findByID(id);
		model.addAttribute("product", product);

		String whatsappLink = "https://wa.me/" + phoneString + "?text=Olá eu quero uma " + product.getName() + "!";

		model.addAttribute("whatsappLink", whatsappLink);

		modelHelper.addFooterThings();

		return "product";
	}

	// talvez desativar isso / colocar auth seria bom,
	// todo
	@PostMapping("/upload")
	public String process_register(@RequestParam("image") MultipartFile image, Product product,
			HttpServletRequest request) {
		try {
			product.image = image.getBytes();

		} catch (IOException e) {
			e.printStackTrace();
			return "error";
		}

		productService.save(product);

		return "redirect:" + request.getHeader("Referer");
	}

	@PostMapping("/update/{id}")
	public String update_product(@PathVariable("id") Integer id, @RequestParam("image") MultipartFile image,
			Product product, HttpServletRequest request) {
		Product old;
		try {
			old = productService.findByID(id);
		} catch (ResourceNotFoundException e) {
			System.out.println("product not found, id is: " + id);
			return "error";
		}

		// reconcile nulls on new with old
		if (product.getName() == null || product.getName().isEmpty()) {
			product.setName(old.getName());
		}

		if (product.getDescription() == null || product.getDescription().isEmpty()) {
			product.setDescription(old.getDescription());
		}

		if (product.getPrice() == null) {
			product.setPrice(old.getPrice());
		}

		if (product.getStock() == null) {
			product.setStock(old.getStock());
		}

		byte[] imageBytes;
		try {
			imageBytes = image.getBytes();
		} catch (IOException e) {
			e.printStackTrace();
			return "error";
		}
		if (imageBytes.length == 0) {
			product.image = old.image;
		} else {
			product.image = imageBytes;

		}

		product.ID = id;

		productService.save(product);

		return "redirect:" + request.getHeader("Referer");
	}

	@GetMapping("/delete/{id}")
	public String delete_product(@PathVariable("id") Integer id, Model model, HttpServletRequest request) {
		productService.delete(id);

		return "redirect:" + request.getHeader("Referer");
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

		return "catalogo";
	}

}
