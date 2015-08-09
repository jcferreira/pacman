package br.com.pacman.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

public class Jogo implements Serializable {

	private static final long serialVersionUID = -2874522428332270252L;
	
	private Pacman pacman;
	private Comida comida;
	private List<String> grid;
	
	
	public void setPacman(String pacman) {
		this.pacman = new Pacman(pacman);
	}
	
	public void setComida(String comida) {
		this.comida = new Comida(comida);
	}
	
	public void addGrid(String grid) {
		if (this.grid == null) this.grid = new ArrayList<String>();
		this.grid.add(grid);
	}
	
	
	
	public @Data class Pacman implements Serializable {
		
		private static final long serialVersionUID = -3652926977790367274L;
		

		private String linha;
		
		private String coluna;
		
		public Pacman(String pacman) {
			String[] dimensao = pacman.split(",");
			this.linha = dimensao[0];
			this.coluna = dimensao[1];
		}
		
	}
	
	public @Data class Comida {
		
		private String linha;
		
		private String coluna;
		
		public Comida(String comida) {
			String[] dimensao = comida.split(",");
			this.linha = dimensao[0];
			this.coluna = dimensao[1];
		}
		
	}

}


