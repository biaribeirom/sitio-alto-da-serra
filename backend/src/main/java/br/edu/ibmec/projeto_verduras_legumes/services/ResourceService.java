package br.edu.ibmec.projeto_verduras_legumes.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ibmec.projeto_verduras_legumes.models.Resource;
import br.edu.ibmec.projeto_verduras_legumes.repository.ResourceRepository;

@Service
public class ResourceService {
	@Autowired
	ResourceRepository resourceRepository;

	public void save(Resource resource) {
		resourceRepository.save(resource);
	}

	public Optional<Resource> findByID(Integer id) {
		return resourceRepository.findByID(id);
	}
}
