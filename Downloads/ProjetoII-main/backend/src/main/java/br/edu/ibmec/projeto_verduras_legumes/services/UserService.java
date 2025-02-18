package br.edu.ibmec.projeto_verduras_legumes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ibmec.projeto_verduras_legumes.models.User;
import br.edu.ibmec.projeto_verduras_legumes.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

	public void save(User user) {
		userRepository.save(user);
	}

    // Implementa o método para buscar o usuário pelo email
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
