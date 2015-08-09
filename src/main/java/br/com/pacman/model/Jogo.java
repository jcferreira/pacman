package br.com.pacman.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class Jogo implements Serializable {

	private static final long serialVersionUID = -2874522428332270252L;
	
	@Getter @Setter
	private Pacman pacman;
	
	@Getter @Setter
	private Comida comida;
	
	@Getter @Setter
	private DimensaoGrid dimensoes;
	
	@Getter
	private List<String> grid;
	
	@Getter @Setter
	private String[][] melhorCaminho;
	
	
	public void addGrid(String grid) {
		if (this.grid == null) this.grid = new ArrayList<String>();
		this.grid.add(grid);
	}
	
	public void imprimirMelhorCaminho() {
		
	}
	
	
	


}


