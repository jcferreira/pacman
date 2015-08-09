package br.com.pacman.model;

import java.io.Serializable;

import lombok.Data;

public @Data class Coordenadas implements Serializable {

	private static final long serialVersionUID = 6085456245659351743L;
	
	private Long linha;
	private Long coluna;

	public Coordenadas(Long linha, Long coluna) {
		this.linha = linha;
		this.coluna = coluna;
	}
}
