package br.edu.ibmec.projeto_verduras_legumes.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import br.edu.ibmec.projeto_verduras_legumes.models.Newsletter;
import br.edu.ibmec.projeto_verduras_legumes.models.Resource;
import br.edu.ibmec.projeto_verduras_legumes.services.ResourceService;

// used to auto insert some cool stuff into spring Models so i dont have to repeat myself so often :P
public class ModelHelper {
	public ModelHelper(ResourceService resourceService, Model model) {
		// System.out.println("hi");
		// System.out.println(resourceService2);
		this.resourceService = resourceService;
		this.model = model;
	}

	ResourceService resourceService;
	Model model;

	public void addResource(Integer id, String attr) {
		Resource resource = resourceService.findByID(id);
		model.addAttribute(attr, resource);
	}

	public void addBanner() {
		Resource banner = resourceService.findByID(1);

		model.addAttribute("banner", banner);
	}

	public void addFooterThings() {
		Resource email = resourceService.findByID(9);
		Resource phone = resourceService.findByID(10);
		Resource address = resourceService.findByID(11);
		Resource facebook = resourceService.findByID(12);
		Resource instagram = resourceService.findByID(13);
		Resource whatsapp = resourceService.findByID(14);

		model.addAttribute("email", email);
		model.addAttribute("phone", phone);
		model.addAttribute("address", address);
		model.addAttribute("facebook", facebook);
		model.addAttribute("instagram", instagram);
		model.addAttribute("whatsapp", whatsapp);
	}

	public void addEmptyNewsletter() {
		model.addAttribute("newsletter", new Newsletter());
	}
}
