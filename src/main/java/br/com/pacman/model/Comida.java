package br.com.pacman.model;

import java.io.Serializable;

import lombok.Data;

public @Data class Comida implements Serializable {
	
	private static final long serialVersionUID = 3200982652747691809L;

	private Coordenadas coordenadas;
	
	public Comida(Long linha, Long coluna) {
		this.coordenadas = new Coordenadas(linha, coluna);
	}
}
