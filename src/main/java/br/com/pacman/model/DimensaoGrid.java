package br.com.pacman.model;

import java.io.Serializable;

import lombok.Data;

public @Data class DimensaoGrid implements Serializable {

	private static final long serialVersionUID = -3935868702480627298L;
	
	private Long linhas;
	private Long colunas;
	
	
	public DimensaoGrid(Long linhas, Long colunas) {
		this.linhas = linhas;
		this.colunas = colunas;
	}

}
