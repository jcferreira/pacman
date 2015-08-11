package br.com.pacman.model;

import java.io.Serializable;

import lombok.Data;

public @Data class DimensaoGrid implements Serializable {

	private static final long serialVersionUID = -3935868702480627298L;
	
	private Coordenadas coordenadas;
	
	public DimensaoGrid(int linhas, int colunas) {
		this.coordenadas = new Coordenadas(linhas, colunas);
	}

}
