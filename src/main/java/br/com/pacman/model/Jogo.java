package br.com.pacman.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
	
	@Getter
	private Map<String, Celula> celulas;
	
	@Getter @Setter
	private String[][] melhorCaminho;
	
	
	public void addGrid(String grid) {
		if (this.grid == null) this.grid = new ArrayList<String>();
		this.grid.add(grid);
	}
	
	public void build() {
		this.celulas = new HashMap<String, Celula>();
		
		for (int linha=0 ; linha < grid.size() ; linha++) {
			for(int coluna=0 ; coluna  < grid.get(linha).length() ; coluna++) {
				celulas.put(linha+","+coluna, new Celula(linha, coluna, grid.get(linha).substring(coluna, coluna=1)));
			}
		}
	}
	
	public Celula getCelula(int linha, int coluna) {
		return celulas.get(linha+","+coluna);
	}
	
	public void imprimirMelhorCaminho() {
		
	}

	

}


