package br.com.pacman;

import junit.framework.TestCase;

import org.junit.Test;

import br.com.pacman.estrategia.PacmanBusiness;
import br.com.pacman.exception.PacmanException;
import br.com.pacman.model.Comida;
import br.com.pacman.model.DimensaoGrid;
import br.com.pacman.model.Jogo;
import br.com.pacman.model.Pacman;

public class PacmanBusinessTest extends TestCase {

	@Test
    public void testJogoValido() {
    	Jogo jogo = new Jogo();
    	jogo.setPacman(new Pacman(0, 0));
    	jogo.setComida(new Comida(0, 0));
    	jogo.setDimensoes(new DimensaoGrid(0, 0));
    	PacmanBusiness pacmanBusiness = new PacmanBusiness(jogo);
    	pacmanBusiness.validarJogo(jogo);
    }

	@Test(expected = PacmanException.class)
    public void testNaoEncontreiComidaNoLabirinto() {
    	Jogo jogo = new Jogo();
    	jogo.setDimensoes(new DimensaoGrid(0, 0));
    	jogo.setPacman(new Pacman(0, 0));
    	PacmanBusiness pacmanBusiness = new PacmanBusiness(jogo);
    	pacmanBusiness.validarJogo(jogo);
    }
    
	@Test(expected = PacmanException.class)
    public void testNaoEncontreiPacmanNoLabirinto() {
    	Jogo jogo = new Jogo();
    	jogo.setDimensoes(new DimensaoGrid(0, 0));
    	jogo.setComida(new Comida(0, 0));
    	PacmanBusiness pacmanBusiness = new PacmanBusiness(jogo);
    	pacmanBusiness.validarJogo(jogo);
    }

	@Test(expected = PacmanException.class)
    public void testNaoEncontreiDimensoesNoLabirinto() {
    	Jogo jogo = new Jogo();
    	jogo.setComida(new Comida(0, 0));
    	jogo.setPacman(new Pacman(0, 0));
    	PacmanBusiness pacmanBusiness = new PacmanBusiness(jogo);
    	pacmanBusiness.validarJogo(jogo);
    }

}
