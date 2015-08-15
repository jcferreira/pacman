package br.com.pacman.model;

import java.io.Serializable;

import lombok.Data;

public @Data class Celula extends Posicao implements Serializable {
	
	private static final long serialVersionUID = 5295509070077605746L;

	private TipoCelula tipoCelula;
	
	private Celula celulaPai;
	
	
	public Celula(int linha, int coluna, String valorCelula) {
		super(new Coordenadas(linha, coluna));
		this.definirTipoCelula(valorCelula);
	}
	
	public boolean isPacman() {
		return TipoCelula.PACMAN == tipoCelula;
	}
	
	public boolean isComida() {
		return TipoCelula.COMIDA == tipoCelula;
	}
	
	public boolean isCaminho() {
		return TipoCelula.CAMINHO == tipoCelula;
	}
	
	public boolean isParede() {
		return TipoCelula.PAREDE == tipoCelula;
	}
	
	public boolean isCaminhoPercorrido() {
		return TipoCelula.CAMINHO_PERCORRIDO == tipoCelula;
	}
	
	public boolean possuiCelulaPai() {
		return this.celulaPai != null;
	}
	
	private void definirTipoCelula(String valorCelula) {
		if (TipoCelula.CAMINHO.getValor().equals(valorCelula)) {
			this.tipoCelula = TipoCelula.CAMINHO;
		} else if (TipoCelula.PACMAN.getValor().equals(valorCelula)) {
			this.tipoCelula = TipoCelula.PACMAN;
		} else if (TipoCelula.COMIDA.getValor().equals(valorCelula)) {
			this.tipoCelula = TipoCelula.COMIDA;
		} else if (TipoCelula.PAREDE.getValor().equals(valorCelula)) {
			this.tipoCelula = TipoCelula.PAREDE;
		} else if (TipoCelula.CAMINHO_PERCORRIDO.getValor().equals(valorCelula)) {
			this.tipoCelula = TipoCelula.CAMINHO_PERCORRIDO;
		}
	}
	
	
}
