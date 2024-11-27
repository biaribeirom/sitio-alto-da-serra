package br.edu.ibmec.projeto_verduras_legumes.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import br.edu.ibmec.projeto_verduras_legumes.models.Newsletter;

@Repository
public interface NewsletterRespository extends JpaRepository<Newsletter, Integer> {
	Optional<Newsletter> findByEmail(String email);

	void deleteById(@NonNull Integer id);

	@NonNull
	List<Newsletter> findAll();
}
