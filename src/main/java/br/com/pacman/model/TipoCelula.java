package br.com.pacman.model;

public enum TipoCelula {

	PACMAN("☺"),
	COMIDA("ϖ"),
	PAREDE("█"),
	CAMINHO("·"),
	CAMINHO_PERCORRIDO("*");
	
	private String valor;
	
	private TipoCelula(String valor) {
		this.valor = valor;
	}
	
	public String getValor() {
		return this.valor;
	}
	
}
