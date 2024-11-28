package br.edu.ibmec.projeto_verduras_legumes.models;

import java.util.Base64;

import org.springframework.web.multipart.MultipartFile;

import br.edu.ibmec.projeto_verduras_legumes.utils.ResourceType;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "RESOURCES", schema = "PROJETO")
public class Resource {
	@Id
	@Basic(optional = false)
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer ID;

	@Column(name = "IMAGE", nullable = true, length = 268435456)
	public byte[] image;

	@Column(name = "DESCRIPTION", nullable = true, length = 2048)
	public String description;

	@Column(name = "TIPO", nullable = false)
	public ResourceType type;

	public Integer getID() {
		return ID;
	}

	public void setID(Integer id) {
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

	public String getImage() {
		return Base64.getEncoder().encodeToString(image);
	}

	public String getTypePretty() {
		switch (type) {
			case IMAGE:
				return "Imagem";
			case DESCRIPTION:
				return "Texto";
			case BOTH:
				return "Imagem e Texto";
			default:
				return "Tipo desconhecido";
		}
	}

	public String testimonialPart1() {
		// gets everything in the text part before "-"
		if (description.indexOf("-") == -1) {
			return description;
		}

		return description.substring(0, description.indexOf("-"));
	}

	public String testimonialPart2() {
		// gets everything in the text part after "-"
		if (description.indexOf("-") == -1) {
			return "";
		}

		return description.substring(description.indexOf("-") + 1);
	}

}
