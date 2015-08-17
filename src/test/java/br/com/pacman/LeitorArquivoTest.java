package br.com.pacman;

import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;

import br.com.pacman.arquivo.LeitorArquivo;
import br.com.pacman.exception.PacmanException;

public class LeitorArquivoTest extends TestCase {
	
	
	@Test
    public void testLerArquivoInputComSucesso() {
		LeitorArquivo leitor = new LeitorArquivo();
    	String arquivo = "src/main/resources/input.txt";
    	List<String> linhas = leitor.carregarLinhasArquivo(arquivo);
        assertTrue( !linhas.isEmpty() );
    }

    @Test(expected=PacmanException.class) 
    public void testErroNaLeituraArquivo() {
    	LeitorArquivo leitor = new LeitorArquivo();
    	String arquivo = "arquivo_invalido.txt";
    	leitor.carregarLinhasArquivo(arquivo);
    }

    
}
