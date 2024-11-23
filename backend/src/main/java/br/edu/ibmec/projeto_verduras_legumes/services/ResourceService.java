package br.edu.ibmec.projeto_verduras_legumes.services;

import java.util.Base64;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ibmec.projeto_verduras_legumes.models.Resource;
import br.edu.ibmec.projeto_verduras_legumes.repository.ResourceRepository;
import br.edu.ibmec.projeto_verduras_legumes.utils.ResourceNotFoundException;

@Service
public class ResourceService {
	@Autowired
	ResourceRepository resourceRepository;

	public void save(Resource resource) {
		resourceRepository.save(resource);
	}

	public Resource findByID(Integer id) {
		Optional<Resource> resource = resourceRepository.findByID(id);

		if (resource.isPresent()) {

			return resource.get();
		}

		throw new ResourceNotFoundException();
	}

	// public String[] getProducts() {
	// return resourceRepository
	// .findAll()
	// .stream()
	// .map(resource -> getImage(resource))
	// .toArray(String[]::new);
	// }
}
