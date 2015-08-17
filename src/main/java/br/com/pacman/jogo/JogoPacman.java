package br.com.pacman.jogo;

import java.io.Serializable;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.pacman.arquivo.LeitorArquivo;
import br.com.pacman.estrategia.PacmanBusiness;
import br.com.pacman.exception.PacmanException;
import br.com.pacman.model.Comida;
import br.com.pacman.model.DimensaoGrid;
import br.com.pacman.model.Jogo;
import br.com.pacman.model.Pacman;

public class JogoPacman implements Serializable {

	private static final long serialVersionUID = 4042758511106783875L;
	
	private final String ARQUIVO = "src/main/resources/input.txt";
	
	private final String REGEX_PACMAN = "^P=\\((\\d{1,2}),(\\d{1,2})\\)$";
	private final String REGEX_COMIDA = "^C=\\((\\d{1,2}),(\\d{1,2})\\)$";
	private final String REGEX_DIMENSOES_GRID = "^(\\d{1,2})x(\\d{1,2})$";
	private final String REGEX_GRID = "^(█.*█)$";
	
	private final Pattern PATTERN_PACMAN = Pattern.compile(REGEX_PACMAN);
	private final Pattern PATTERN_COMIDA = Pattern.compile(REGEX_COMIDA);
	private final Pattern PATTERN_DIMENSOES_GRID = Pattern.compile(REGEX_DIMENSOES_GRID);
	private final Pattern PATTERN_GRID = Pattern.compile(REGEX_GRID);

	private LeitorArquivo leitorArquivo = new LeitorArquivo();
	
	public boolean jogar() {
		Jogo jogo = montarJogos();
		jogo.build();
		PacmanBusiness engine = new PacmanBusiness(jogo);
		engine.definirMelhorCaminho();
		return true;
	}
	
	private Jogo montarJogos() {
		List<String> linhas = leitorArquivo.carregarLinhasArquivo(ARQUIVO);
		Jogo jogo = new Jogo();
		for (String linha : linhas) {
			criarEstruturaJogo(linha.trim(), jogo);
		}
		return jogo;
	}
	
	private Pattern criarEstruturaJogo(String linha, Jogo jogo) {
		Pattern pattern = null;
		
		Matcher matcherPacman = PATTERN_PACMAN.matcher(linha);
		Matcher matcherComida = PATTERN_COMIDA.matcher(linha);
		Matcher matcherDimensoesGrid = PATTERN_DIMENSOES_GRID.matcher(linha);
		Matcher matcherGrid = PATTERN_GRID.matcher(linha);
		
		if (matcherPacman.matches()) {
			pattern = PATTERN_PACMAN;
			jogo.setPacman(new Pacman(Integer.parseInt(matcherPacman.group(1)), Integer.parseInt(matcherPacman.group(2))));
		} else if (matcherComida.matches()) {
			pattern = PATTERN_COMIDA;
			jogo.setComida(new Comida(Integer.parseInt(matcherComida.group(1)), Integer.parseInt(matcherComida.group(2))));
		} else if (matcherDimensoesGrid.matches()) {
			pattern = PATTERN_DIMENSOES_GRID;
			jogo.setDimensoes(new DimensaoGrid(Integer.parseInt(matcherDimensoesGrid.group(1)), Integer.parseInt(matcherDimensoesGrid.group(2))));
		} else if (matcherGrid.matches()) {
			pattern = PATTERN_GRID;
			jogo.addGrid(matcherGrid.group(1));
		}
		
		return pattern;
	}
	
}
