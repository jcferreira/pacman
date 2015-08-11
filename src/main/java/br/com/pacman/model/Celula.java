package br.com.pacman.model;

import java.io.Serializable;

import lombok.Data;

public @Data class Celula extends Posicao implements Serializable {
	
	private static final long serialVersionUID = 5295509070077605746L;

	private TipoCelula tipoCelula;
	
	
	public Celula(int linha, int coluna, String valorCelula) {
		super(new Coordenadas(linha, coluna));
		this.definirTipoCelula(valorCelula);
	}
	
	public int getValorDaPosicaoEmRelacaoComida(Comida comida) {
		return Math.abs(this.getCoordenadas().getLinha() - comida.getCoordenadas().getLinha()) + 
			   Math.abs(this.getCoordenadas().getColuna() - comida.getCoordenadas().getColuna());
	}
	
	public boolean isParede() {
		return TipoCelula.PAREDE == tipoCelula;
	}
	
	public boolean isCaminho() {
		return TipoCelula.CAMINHO == tipoCelula;
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
