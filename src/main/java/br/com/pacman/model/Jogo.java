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
	
	
	public void setPacman(Pacman pacman) {
		this.pacman = pacman;
	}
	
	public void setComida(Comida comida) {
		this.comida = comida;
	}
	
	public void setDimensoes(DimensaoGrid dimensaoGrid) {
		this.dimensoes = dimensaoGrid;
	}

	public void addGrid(String grid) {
		if (this.grid == null) this.grid = new ArrayList<String>();
		this.grid.add(grid);
	}
	
	public void imprimirMelhorCaminho() {
		
	}
	
	
	


}


