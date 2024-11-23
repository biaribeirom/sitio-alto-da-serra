package br.edu.ibmec.projeto_verduras_legumes.utils;

public class ResourceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException() {
		super("Resource not found");
	}
}