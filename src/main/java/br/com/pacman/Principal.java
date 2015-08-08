package br.com.pacman;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		try {
			Scanner scanner = new Scanner(new FileReader("src/main/resources/input.txt"));
			while (scanner.hasNextLine()) {
				String linha = scanner.nextLine();
				System.out.println(linha);
			}
		} catch(FileNotFoundException e) {
			
		}
		
	}

}
