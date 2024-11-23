package br.edu.ibmec.projeto_verduras_legumes.models;

import java.util.UUID;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "USERS", schema = "PROJETO")
public class User {
	@Id
	@Basic(optional = false)
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public UUID user_id;

	@Column(name = "NOME", nullable = false, length = 512)
	private String name;

	@Column(name = "EMAIL", nullable = false, unique = true, length = 512)
	private String email;

	@Column(name = "SENHA", nullable = false, length = 512)
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
