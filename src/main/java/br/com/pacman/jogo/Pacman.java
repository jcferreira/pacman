package br.com.pacman.jogo;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.pacman.arquivo.LeitorArquivo;
import br.com.pacman.model.Jogo;

public class Pacman {

	private final String REGEX_PACMAN = "^P=\\((\\d{1,2}),(\\d{1,2})\\)$";
	private final String REGEX_COMIDA = "^C=\\((\\d{1,2}),(\\d{1,2})\\)$";
	private final String REGEX_DIMENSOES_GRID = "^(\\d{1,2})x(\\d{1,2})$";
	private final String REGEX_GRID = "^(█.*█)$";
	private final String REGEX_FIM = "^=== FIM ===$";
	
	private final Pattern PATTERN_PACMAN = Pattern.compile(REGEX_PACMAN);
	private final Pattern PATTERN_COMIDA = Pattern.compile(REGEX_COMIDA);
	private final Pattern PATTERN_DIMENSOES_GRID = Pattern.compile(REGEX_DIMENSOES_GRID);
	private final Pattern PATTERN_GRID = Pattern.compile(REGEX_GRID);
	private final Pattern PATTERN_FIM = Pattern.compile(REGEX_FIM);

	private LeitorArquivo leitorArquivo = new LeitorArquivo();
	
	public static void main(String[] args) {
		new Pacman().iniciarJogo();
	}
	
	public void iniciarJogo() {
		List<Jogo> jogos = montarJogos();
	}
	
	private List<Jogo> montarJogos() {
		List<String> linhas = leitorArquivo.carregarLinhasArquivo();
		List<Jogo> jogos = new ArrayList<Jogo>();
		
		Jogo jogo = new Jogo();
		for (String linha : linhas) {
			if (analisarLinha(linha.trim(), jogo) == PATTERN_FIM) {
				jogos.add(jogo);
				jogo = new Jogo();
			}
		}
		
		return jogos;
	}
	
	private Pattern analisarLinha(String linha, Jogo jogo) {
		Pattern pattern = null;
		
		Matcher matcherPacman = PATTERN_PACMAN.matcher(linha);
		Matcher matcherComida = PATTERN_COMIDA.matcher(linha);
		Matcher matcherDimensoesGrid = PATTERN_DIMENSOES_GRID.matcher(linha);
		Matcher matcherGrid = PATTERN_GRID.matcher(linha);
		Matcher matcherFim = PATTERN_FIM.matcher(linha);
		
		if (matcherPacman.matches()) {
			pattern = PATTERN_PACMAN;
			jogo.setPacman(Long.parseLong(matcherPacman.group(1)), Long.parseLong(matcherPacman.group(2)));
		} else if (matcherComida.matches()) {
			pattern = PATTERN_COMIDA;
			jogo.setComida(Long.parseLong(matcherComida.group(1)), Long.parseLong(matcherComida.group(2)));
		} else if (matcherDimensoesGrid.matches()) {
			pattern = PATTERN_DIMENSOES_GRID;
			jogo.setDimensoes(Long.parseLong(matcherDimensoesGrid.group(1)), Long.parseLong(matcherDimensoesGrid.group(2)));
		} else if (matcherGrid.matches()) {
			pattern = PATTERN_GRID;
			jogo.addGrid(matcherGrid.group(1));
		} else if (matcherFim.matches()) {
			pattern = PATTERN_FIM;
		}
		
		return pattern;
	}
	
}
