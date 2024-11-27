package br.edu.ibmec.projeto_verduras_legumes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ibmec.projeto_verduras_legumes.models.Newsletter;
import br.edu.ibmec.projeto_verduras_legumes.models.Product;
import br.edu.ibmec.projeto_verduras_legumes.repository.NewsletterRespository;

@Service
public class NewsletterService {
	@Autowired
	NewsletterRespository newsletterRespository;

	public void save(Newsletter newsletter) {
		newsletterRespository.save(newsletter);
	}

	public void delete(Integer id) {
		newsletterRespository.deleteById(id);
	}

	public Newsletter[] getNewsletters() {
		return newsletterRespository.findAll().toArray(Newsletter[]::new);
	}
}
