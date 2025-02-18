package br.edu.ibmec.projeto_verduras_legumes.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import br.edu.ibmec.projeto_verduras_legumes.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	Optional<Product> findByID(Integer id);

	@NonNull
	List<Product> findAll();
}
