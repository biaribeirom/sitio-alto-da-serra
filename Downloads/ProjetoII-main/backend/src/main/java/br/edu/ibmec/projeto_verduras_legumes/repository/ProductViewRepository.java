/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.edu.ibmec.projeto_verduras_legumes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ibmec.projeto_verduras_legumes.models.ProductView;

/**
 *
 * @author mbia
 */

@Repository
public interface ProductViewRepository extends JpaRepository<ProductView, Integer> {

}
