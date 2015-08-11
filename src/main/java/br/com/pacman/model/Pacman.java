package br.com.pacman.model;

import java.io.Serializable;

import lombok.Data;

public @Data class Pacman extends Posicao implements Serializable {
	
	private static final long serialVersionUID = -3652926977790367274L;
	
	public Pacman(int linha, int coluna) {
		super(new Coordenadas(linha, coluna));
	}
	
}
