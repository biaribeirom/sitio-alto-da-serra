package br.edu.ibmec.projeto_verduras_legumes.models;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

enum ResourceType {
	IMAGE, // 1
	DESCRIPTION, // 2
	BOTH, // 3
}

@Entity
@Table(name = "RESOURCES", schema = "PROJETO")
public class Resource {
	@Id
	@Basic(optional = false)
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer ID;

	@Column(name = "IMAGE", nullable = true, length = 268435456)
	public byte[] image;

	@Column(name = "DESCRIPTION", nullable = true, length = 2048)
	public String description;

	@Column(name = "TIPO", nullable = false)
	public ResourceType type;

	public Integer getId() {
		return ID;
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

	public ResourceType getType() {
		return type;
	}

	public void setType(ResourceType type) {
		this.type = type;
	}

}
