package br.com.pacman.jogo;

import java.io.Serializable;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.pacman.arquivo.LeitorArquivo;
import br.com.pacman.estrategia.PacmanEngine;
import br.com.pacman.exception.PacmanException;
import br.com.pacman.model.Comida;
import br.com.pacman.model.DimensaoGrid;
import br.com.pacman.model.Jogo;
import br.com.pacman.model.Pacman;

public class JogoPacman implements Serializable {

	private static final long serialVersionUID = 4042758511106783875L;
	
	private final String REGEX_PACMAN = "^P=\\((\\d{1,2}),(\\d{1,2})\\)$";
	private final String REGEX_COMIDA = "^C=\\((\\d{1,2}),(\\d{1,2})\\)$";
	private final String REGEX_DIMENSOES_GRID = "^(\\d{1,2})x(\\d{1,2})$";
	private final String REGEX_GRID = "^(█.*█)$";
	
	private final Pattern PATTERN_PACMAN = Pattern.compile(REGEX_PACMAN);
	private final Pattern PATTERN_COMIDA = Pattern.compile(REGEX_COMIDA);
	private final Pattern PATTERN_DIMENSOES_GRID = Pattern.compile(REGEX_DIMENSOES_GRID);
	private final Pattern PATTERN_GRID = Pattern.compile(REGEX_GRID);

	private LeitorArquivo leitorArquivo = new LeitorArquivo();
	
	public void iniciarJogo() {
		Jogo jogo = montarJogos();
		jogo.build();
		PacmanEngine engine = new PacmanEngine(jogo);
		engine.definirMelhorCaminho();
	}
	
	private Jogo montarJogos() {
		List<String> linhas = leitorArquivo.carregarLinhasArquivo();
		Jogo jogo = new Jogo();
		for (String linha : linhas) {
			criarEstruturaJogo(linha.trim(), jogo);
		}
		validarJogo(jogo);
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
	
	private void validarJogo(Jogo jogo) {
		if (jogo.getPacman() == null) {
			throw new PacmanException("Não foi informado a posição do pacman no labirinto.");
		}
		
		if (jogo.getComida() == null) {
			throw new PacmanException("Não foi informado a posição da comida no labirinto.");
		}
		
		if (jogo.getDimensoes() == null) {
			throw new PacmanException("Não foi informado as dimensões do labirinto.");
		}
		
		if (jogo.getPacman() == null) {
			throw new PacmanException("O labirinto informado não está no padrão de leitura esperado.");
		}
		
	}
	
}
