package br.edu.ibmec.projeto_verduras_legumes.services;

import java.util.Base64;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ibmec.projeto_verduras_legumes.models.Product;
import br.edu.ibmec.projeto_verduras_legumes.repository.ProductRepository;
import br.edu.ibmec.projeto_verduras_legumes.utils.ResourceNotFoundException;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;

	public void save(Product product) {
		productRepository.save(product);
	}

	public Product findByID(Integer id) {
		Optional<Product> product = productRepository.findByID(id);

		if (product.isPresent()) {

			return product.get();
		}

		throw new ResourceNotFoundException();
	}

	public void delete(Integer id) {
		productRepository.deleteById(id);
	}

	public Product[] getProducts() {
		return productRepository.findAll().toArray(Product[]::new);
	}
}
