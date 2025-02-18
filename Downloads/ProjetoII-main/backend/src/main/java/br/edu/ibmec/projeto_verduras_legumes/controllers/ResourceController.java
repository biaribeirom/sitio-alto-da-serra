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
import br.edu.ibmec.projeto_verduras_legumes.services.ResourceService;
import br.edu.ibmec.projeto_verduras_legumes.utils.ResourceNotFoundException;
import br.edu.ibmec.projeto_verduras_legumes.utils.ResourceType;
import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping({ "/resource", "/resources", "/recurso", "/recursos" })
public class ResourceController {
	@Autowired
	private ResourceService resourceService;

	@PostMapping("/update/{id}")
	public String update_resource(@PathVariable("id") Integer id,
			@RequestParam(name = "image", required = false) MultipartFile image,
			Resource resource, HttpServletRequest request) {
		Resource old;
		try {
			old = resourceService.findByID(id);
		} catch (ResourceNotFoundException e) {
			System.out.println("product not found, id is: " + id);
			return "error";
		}

		if (old.type != ResourceType.IMAGE) {
			if (resource.getDescription() == null || resource.getDescription().isEmpty()) {
				resource.setDescription(old.getDescription());
			}
		} else {
			resource.description = old.description;
		}

		if (old.type != ResourceType.DESCRIPTION) {
			byte[] imageBytes;
			try {
				imageBytes = image.getBytes();
			} catch (IOException e) {
				e.printStackTrace();
				return "error";
			}
			if (imageBytes.length == 0) {
				resource.image = old.image;
			} else {
				resource.image = imageBytes;
			}
		} else {
			resource.image = old.image;
		}

		resource.ID = id;
		resource.type = old.type;

		resourceService.save(resource);

		// get image from resource 9 and put it on 10, then save 10
		Resource resource10 = resourceService.findByID(10);
		Resource resource9 = resourceService.findByID(9);

		resource10.image = resource9.image;
		resourceService.save(resource10);

		return "redirect:" + request.getHeader("Referer");
	}

	// somente ativar quando for criar novos recursos, o que necessita editar o site
	// inteiro
	@PostMapping("/create")
	public @ResponseBody String process_register(@RequestParam("image") MultipartFile image, Resource resource) {
		try {
			resource.image = image.getBytes();

		} catch (IOException e) {
			e.printStackTrace();
			return "it in fact did not work";
		}

		resourceService.save(resource);

		return "it worked uhhh the id is " + resource.getID();
	}

}
