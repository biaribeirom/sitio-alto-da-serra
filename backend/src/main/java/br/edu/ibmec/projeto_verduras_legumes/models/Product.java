package br.edu.ibmec.projeto_verduras_legumes.models;

import java.util.Base64;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PRODUCTS", schema = "PROJETO")
public class Product {
	@Id
	@Basic(optional = false)
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer ID;

	@Column(name = "NOME", nullable = true, length = 2048)
	public String name;
	@Column(name = "DESCRICAO", nullable = true, length = 2048)
	public String description;

	@Column(name = "PRECO", nullable = false)
	public Double price;

	@Column(name = "ESTOQUE", nullable = false)
	public Integer stock;

	@Column(name = "IMAGE", nullable = true, length = 268435456)
	public byte[] image;

	public Integer getId() {
		return ID;
	}

	public String getURL() {
		return "/product/" + ID;
	}

	public void setId(Integer id) {
		this.ID = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return "R$" + price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public boolean isSoldOut() {
		return stock <= 0;
	}

	public String getImage() {
		return Base64.getEncoder().encodeToString(image);
	}
}
