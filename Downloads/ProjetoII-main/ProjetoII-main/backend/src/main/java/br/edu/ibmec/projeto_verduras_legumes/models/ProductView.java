/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ibmec.projeto_verduras_legumes.models;

/**
 *
 * @author mbia
 */
import jakarta.persistence.*;

@Entity
@Table(name = "PRODUCT_VIEWS") // Nome da tabela no banco de dados
public class ProductView {

    @Id
    @Column(name = "PRODUCT_ID") // Nome da coluna no banco de dados
    private Integer productId;

    @Column(name = "VIEWS_COUNT", nullable = false) // Nome da coluna no banco de dados
    private Integer viewsCount = 0;

    public ProductView() {
    }

    public ProductView(Integer productId) {
        this.productId = productId;
        this.viewsCount = 0;
    }

    // Getters e Setters
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getViewsCount() {
        return viewsCount;
    }

    public void setViewsCount(Integer viewsCount) {
        this.viewsCount = viewsCount;
    }

    public void incrementView() {
        this.viewsCount++;
    }
}
