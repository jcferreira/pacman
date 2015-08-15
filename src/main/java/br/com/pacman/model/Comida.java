package br.com.pacman.model;

import java.io.Serializable;

import lombok.Data;

public @Data class Comida extends Celula implements Serializable {
	
	private static final long serialVersionUID = 3200982652747691809L;

	public Comida(int linha, int coluna) {
		super(linha, coluna, TipoCelula.COMIDA.getValor());
	}
	
}
