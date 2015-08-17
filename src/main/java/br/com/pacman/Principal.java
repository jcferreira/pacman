package br.com.pacman;

import java.io.Serializable;

import br.com.pacman.exception.PacmanException;
import br.com.pacman.jogo.JogoPacman;

public class Principal implements Serializable {

	private static final long serialVersionUID = -8564230245789663623L;

	public static void main(String[] args) {
		
		JogoPacman jogoPacman = new JogoPacman();
		try {
			jogoPacman.jogar();
		} catch (PacmanException ex) {
			System.out.println("  >>>>>>  " + ex.getMessage());
		} catch (Exception ex) {
			System.out.println("Ocorreu um erro na execução do programa: " + ex.getMessage());
			ex.printStackTrace();
		}
		
	}

}
