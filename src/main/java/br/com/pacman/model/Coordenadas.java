package br.com.pacman.model;

import java.io.Serializable;

import lombok.Data;

public @Data class Coordenadas implements Serializable {

	private static final long serialVersionUID = 6085456245659351743L;
	
	private int linha;
	private int coluna;

	public Coordenadas(int linha, int coluna) {
		this.linha = linha;
		this.coluna = coluna;
	}
}
