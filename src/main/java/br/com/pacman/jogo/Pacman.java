package br.com.pacman.jogo;

import java.util.ArrayList;
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
		List<Jogo> jogos = montarJogos();
		
	}
	
	private List<Jogo> montarJogos() {
		List<String> linhas = leitorArquivo.carregarLinhasArquivo();
		List<Jogo> jogos = new ArrayList<Jogo>();
		
		Jogo jogo = new Jogo();
		for (String linha : linhas) {
			if (analisarLinha(linha, jogo) == PATTERN_FIM) {
				jogos.add(jogo);
				jogo = new Jogo();
			}
		}
		
		return jogos;
	}
	
	private Pattern analisarLinha(String linha, Jogo jogo) {
		Pattern pattern = null;
		
		if (linhaFezMatcher(PATTERN_PACMAN.matcher(linha))) {
			pattern = PATTERN_PACMAN;
			jogo.setPacman(linha);
		} else if (linhaFezMatcher(PATTERN_COMIDA.matcher(linha))) {
			pattern = PATTERN_COMIDA;
			jogo.setComida(linha);
		} else if (linhaFezMatcher(PATTERN_GRID.matcher(linha))) {
			pattern = PATTERN_GRID;
			jogo.addGrid(linha);
		} else if (linhaFezMatcher(PATTERN_FIM.matcher(linha))) {
			pattern = PATTERN_FIM;
		}
		
		return pattern;
	}
	
	
	private boolean linhaFezMatcher(Matcher matcher) {
		return matcher.matches();
	}
	
}
