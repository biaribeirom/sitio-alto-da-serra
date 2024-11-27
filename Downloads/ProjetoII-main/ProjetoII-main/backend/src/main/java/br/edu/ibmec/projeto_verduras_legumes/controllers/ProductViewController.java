/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ibmec.projeto_verduras_legumes.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ibmec.projeto_verduras_legumes.models.ProductView;
import br.edu.ibmec.projeto_verduras_legumes.services.ProductViewService;

/**
 *
 * @author mbia
 */

@Controller
@RequestMapping("/product-views")
public class ProductViewController {

    @Autowired
    private ProductViewService productViewService;

    @GetMapping("/page")
    public String getProductViewsPage(Model model) {
        // Busca os dados no banco de dados
        List<ProductView> productViews = productViewService.getAllProductViews();

        // Adiciona os dados ao modelo para o Thymeleaf
        model.addAttribute("productViews", productViews);

        // Retorna o nome do template (views.html)
        return "admin/views";
    }
}
