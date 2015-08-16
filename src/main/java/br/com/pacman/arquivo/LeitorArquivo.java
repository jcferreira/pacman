package br.com.pacman.arquivo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.pacman.exception.PacmanException;

public class LeitorArquivo implements Serializable {

	private static final long serialVersionUID = -7402580264152967775L;
	
	
	public List<String> carregarLinhasArquivo(String arquivo) {
		List<String> linhas = new ArrayList<String>();
		Scanner scanner = null;
		
		try {
			scanner = new Scanner(new FileReader(arquivo));
		} catch (FileNotFoundException e) {
			throw new PacmanException("Não foi encontrado arquivo informado.");
		} catch (Exception e) { 
			throw new PacmanException("Não foi possível ler o arquivo de origem.", e);
		}
		
		while (scanner.hasNextLine()) {
			linhas.add(scanner.nextLine());
		}
		scanner.close();
		return linhas;
	}
	
	
}
