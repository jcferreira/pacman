package br.com.pacman.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

public class Jogo implements Serializable {

	private static final long serialVersionUID = -2874522428332270252L;
	
	private Pacman pacman;
	private Comida comida;
	private DimensaoGrid dimensoes;
	private List<String> grid;
	
	
	public void setPacman(Long linha, Long coluna) {
		this.pacman = new Pacman(linha, coluna);
	}
	
	public void setComida(Long linha, Long coluna) {
		this.comida = new Comida(linha, coluna);
	}
	
	public void setDimensoes(Long linha, Long coluna) {
		this.dimensoes = new DimensaoGrid(linha, coluna);
	}

	public void addGrid(String grid) {
		if (this.grid == null) this.grid = new ArrayList<String>();
		this.grid.add(grid);
	}
	
	
	
	public @Data class Pacman implements Serializable {
		
		private static final long serialVersionUID = -3652926977790367274L;
		
		private Long linha;
		private Long coluna;
		
		public Pacman(Long linha, Long coluna) {
			this.linha = linha;
			this.coluna = coluna;
		}
	}
	
	public @Data class Comida implements Serializable {
		
		private static final long serialVersionUID = 3200982652747691809L;

		private Long linha;
		private Long coluna;
		
		public Comida(Long linha, Long coluna) {
			this.linha = linha;
			this.coluna = coluna;
		}
	}

	public @Data class DimensaoGrid implements Serializable {
		
		private static final long serialVersionUID = -3935868702480627298L;
		
		private Long linhas;
		private Long colunas;
		
		
		public DimensaoGrid(Long linhas, Long colunas) {
			this.linhas = linhas;
			this.colunas = colunas;
		}
	}

}


