package br.com.pacman;

import org.junit.Test;

import junit.framework.TestCase;
import br.com.pacman.exception.PacmanException;
import br.com.pacman.jogo.JogoPacman;

public class PacmanTest extends TestCase {
	
	
	@Test
    public void testJogoComSucesso() {
    	JogoPacman pacman = new JogoPacman();
    	boolean executouComSucesso = pacman.jogar();
    	assertTrue( executouComSucesso );
    }
    
    @Test(expected = PacmanException.class)
    public void testJogoFalhou() {
    	JogoPacman pacman = new JogoPacman();
    	boolean executouComSucesso = pacman.jogar();
    	assertTrue( executouComSucesso );
    }
    
}
