package br.edu.ibmec.projeto_verduras_legumes.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ibmec.projeto_verduras_legumes.models.Resource;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Integer> {
	Optional<Resource> findByID(Integer id);
}
