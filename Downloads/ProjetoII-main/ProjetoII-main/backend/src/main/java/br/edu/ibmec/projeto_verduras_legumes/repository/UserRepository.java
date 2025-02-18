package br.edu.ibmec.projeto_verduras_legumes.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ibmec.projeto_verduras_legumes.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
	Optional<User> findByName(String name);

	User findByEmail(String email);
}
