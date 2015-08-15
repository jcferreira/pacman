package br.com.pacman.model;

import java.io.Serializable;

import lombok.Data;

@Data class Posicao implements Serializable {
	
	private static final long serialVersionUID = 229586795988892979L;

	private Coordenadas coordenadas;
	
	public Posicao(Coordenadas coordenadas) {
		this.coordenadas = coordenadas;
	}
	
}
