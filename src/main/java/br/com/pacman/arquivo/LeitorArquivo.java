package br.com.pacman.arquivo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LeitorArquivo {

	private final String ARQUIVO = "src/main/resources/input.txt";
	
	
	public List<String> carregarLinhasArquivo() {
		List<String> linhas = new ArrayList<String>();
		Scanner scanner = null;
		
		try {
			scanner = new Scanner(new FileReader(ARQUIVO));
		} catch (FileNotFoundException e) {
			
		} catch (Exception e) { 
			
		}
		
		while (scanner.hasNextLine()) {
			linhas.add(scanner.nextLine());
		}
		return linhas;
	}
	
	
}
