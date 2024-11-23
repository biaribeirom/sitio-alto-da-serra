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

import br.edu.ibmec.projeto_verduras_legumes.models.Resource;
import br.edu.ibmec.projeto_verduras_legumes.services.ResourceService;

@Controller
@RequestMapping("/resource")
public class ResourceController {
	@Autowired
	private ResourceService resourceService;

	// @PostMapping({ "/login" })
	// public String login(@RequestBody UserModel userModel) {
	// return "login";
	// }

	@GetMapping("/{id}")
	public @ResponseBody Resource interface_register(@PathVariable("id") Integer id) {
		return resourceService.findByID(id);
	}

	@PostMapping("/create")
	public @ResponseBody String process_register(@RequestParam("image") MultipartFile image, Resource resource) {
		try {
			resource.image = image.getBytes();

		} catch (IOException e) {
			e.printStackTrace();
			return "it in fact did not work";
		}

		resourceService.save(resource);

		return "it worked uhhh the id is " + resource.getId();
	}

}
