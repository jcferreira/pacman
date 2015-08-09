package br.com.pacman.model;

import java.io.Serializable;

import lombok.Data;

public @Data class Pacman implements Serializable {
	
	private static final long serialVersionUID = -3652926977790367274L;
	
	private Long linha;
	private Long coluna;
	
	public Pacman(Long linha, Long coluna) {
		this.linha = linha;
		this.coluna = coluna;
	}
}
