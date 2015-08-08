package br.com.pacman.jogo;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.pacman.arquivo.LeitorArquivo;
import br.com.pacman.model.Jogo;

public class Pacman {

	private final String REGEX_PACMAN = "P=\\(\\d{1,2},\\d{1,2}\\)";
	private final String REGEX_COMIDA = "C=\\(\\d{1,2},\\d{1,2}\\)";
	private final String REGEX_GRID = "\\d{1,2}x\\d{1,2}";
	private final String REGEX_FIM = "=== FIM ===";
	
	private final Pattern PATTERN_PACMAN = Pattern.compile(REGEX_PACMAN);
	private final Pattern PATTERN_COMIDA = Pattern.compile(REGEX_COMIDA);
	private final Pattern PATTERN_GRID = Pattern.compile(REGEX_GRID);
	private final Pattern PATTERN_FIM = Pattern.compile(REGEX_FIM);

	private LeitorArquivo leitorArquivo = new LeitorArquivo();
	
	public void iniciarJogo() {
		
	}
	
	private void montarJogos() {
		List<String> linhas = leitorArquivo.carregarLinhasArquivo();
		
		for (String linha : linhas) {
			
		}
		

	}
	
	private Pattern analisarLinha(String linha) {
		

		
		return null;
	}

	private Pattern descobrirPattern(String linha, Jogo jogo) {
		Pattern pattern = null;
		
		if (linhaFezMatcher(PATTERN_PACMAN.matcher(linha))) {
			
		} else if (linhaFezMatcher(PATTERN_COMIDA.matcher(linha))) {
			pattern = PATTERN_COMIDA;
		} else if (linhaFezMatcher(PATTERN_GRID.matcher(linha))) {
			pattern = PATTERN_GRID;
		} else if (linhaFezMatcher(PATTERN_FIM.matcher(linha))) {
			pattern = PATTERN_FIM;
		}
		
		return pattern;
	}
	
	
	private boolean linhaFezMatcher(Matcher matcher) {
		return matcher.matches();
	}
	
}
