/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ibmec.projeto_verduras_legumes.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ibmec.projeto_verduras_legumes.models.ProductView;
import br.edu.ibmec.projeto_verduras_legumes.repository.ProductViewRepository;

/**
 *
 * @author mbia
 */
@Service
public class ProductViewService {

    @Autowired
    private ProductViewRepository productViewRepository;

    public void incrementView(Integer productId) {
        System.out.println("Incrementando visualização para o produto com ID: " + productId);

        ProductView productView = productViewRepository.findById(productId).orElse(null);

        if (productView == null) {
            System.out.println("Produto não encontrado, criando novo registro...");
            productView = new ProductView(productId);
            productView.incrementView();
        } else {
            System.out.println("Produto encontrado, incrementando visualizações...");
            productView.incrementView();
        }

        productViewRepository.save(productView);
        System.out.println("Visualizações salvas: " + productView.getViewsCount());
    }

    public List<ProductView> getAllProductViews() {
        return productViewRepository.findAll();
    }

}
