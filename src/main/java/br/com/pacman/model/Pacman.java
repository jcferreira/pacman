package br.com.pacman.model;

import java.io.Serializable;

import lombok.Data;

public @Data class Pacman implements Serializable {
	
	private static final long serialVersionUID = -3652926977790367274L;
	
	private Coordenadas coordenadas;
	
	public Pacman(Long linha, Long coluna) {
		this.coordenadas = new Coordenadas(linha, coluna);
	}
}
