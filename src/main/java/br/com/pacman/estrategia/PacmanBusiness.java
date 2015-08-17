package br.com.pacman.estrategia;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.pacman.exception.PacmanException;
import br.com.pacman.model.Celula;
import br.com.pacman.model.Jogo;
import br.com.pacman.model.TipoCelula;

public class PacmanBusiness implements Serializable {

	private static final long serialVersionUID = 8312042664675866410L;
	
	private Jogo jogo;
	
	public PacmanBusiness(Jogo jogo) {
		this.jogo = jogo;
	}
	
	public void definirMelhorCaminho() {
		validarJogo(jogo);
		List<Celula> caminhoPercorrido = new ArrayList<Celula>();
		caminhoPercorrido = recuperarVizinhosMelhorCaminho(jogo.getPacman());
		validarSeEncontrouComida(caminhoPercorrido);
		imprimirMelhorCaminho(caminhoPercorrido);
	}
	
	public void validarJogo(Jogo jogo) {
		if (jogo.getPacman() == null) {
			throw new PacmanException("Não foi informado a posição do pacman no labirinto.");
		}
		
		if (jogo.getComida() == null) {
			throw new PacmanException("Não foi informado a posição da comida no labirinto.");
		}
		
		if (jogo.getDimensoes() == null) {
			throw new PacmanException("Não foi informado as dimensões do labirinto.");
		}
		
	}

	private List<Celula> recuperarVizinhosMelhorCaminho(Celula celulaAtual) {
		List<Celula> caminhosPercorridos = new ArrayList<Celula>();
		List<Celula> melhoresVizinhos = new ArrayList<Celula>();
		melhoresVizinhos.add(celulaAtual);
		
		do {
			List<Celula> vizinhos = recuperarVizinhos(melhoresVizinhos);
			if (!vizinhos.isEmpty()) { 
				caminhosPercorridos.addAll(vizinhos);
			}
			melhoresVizinhos = new ArrayList<Celula>();
			melhoresVizinhos = vizinhos;
		} while (!melhoresVizinhos.isEmpty() && !encontrouComida(melhoresVizinhos));
		
		return melhoresVizinhos;
	}
	
	private List<Celula> recuperarVizinhos(List<Celula> celulasAtuais) {
		List<Celula> celulasVizinhas = new ArrayList<Celula>();
		
		for (Celula celulaAtual : celulasAtuais) {
			int linha = celulaAtual.getCoordenadas().getLinha();
			int coluna = celulaAtual.getCoordenadas().getColuna();
			Celula celulaVizinha = null;
			
			// Vizinho Acima
			celulaVizinha = jogo.getCelula(linha-1, coluna);
			if (podeAdicionarCelula(celulaVizinha)) {
				celulaVizinha.setCelulaPai(celulaAtual);
				celulasVizinhas.add(celulaVizinha);  	
				if (celulaVizinha.isComida()) 
					break;
			}
			
			// Vizinho Abaixo
			celulaVizinha = jogo.getCelula(linha+1, coluna);
			if (podeAdicionarCelula(celulaVizinha)) {
				celulaVizinha.setCelulaPai(celulaAtual);
				celulasVizinhas.add(celulaVizinha);
				if (celulaVizinha.isComida()) 
					break;
			}
			
			// Vizinho Esquerda
			celulaVizinha = jogo.getCelula(linha, coluna-1);
			if (podeAdicionarCelula(celulaVizinha)) {
				celulaVizinha.setCelulaPai(celulaAtual);
				celulasVizinhas.add(celulaVizinha);
				if (celulaVizinha.isComida()) 
					break;
			}
			
			// Vizinho Direita
			celulaVizinha = jogo.getCelula(linha, coluna+1);
			if (podeAdicionarCelula(celulaVizinha)) {
				celulaVizinha.setCelulaPai(celulaAtual);
				celulasVizinhas.add(celulaVizinha);
				if (celulaVizinha.isComida()) 
					break;
			}
		}
		
		return celulasVizinhas;
	}
	
	private boolean podeAdicionarCelula(Celula celulaVizinha) {
		if (celulaVizinha != null && !celulaVizinha.possuiCelulaPai() && celulaVizinha.getTipoCelula() != TipoCelula.PAREDE && celulaVizinha.getTipoCelula() != TipoCelula.PACMAN) 
			return true;
		
		return false;
	}

	private boolean encontrouComida(List<Celula> vizinhos) {
		for (Celula vizinho : vizinhos) {
			if (vizinho.isComida())
				return true;
		}
		return false;
	}
	
	private void validarSeEncontrouComida(List<Celula> caminhoPercorrido) {
		Celula comida = null;
		if (caminhoPercorrido != null && !caminhoPercorrido.isEmpty()) {
			for (Celula vizinho : caminhoPercorrido) {
				if (vizinho.isComida()) {
					comida = vizinho;
					break;
				}
			}
		}
		if (comida == null) {
			throw new PacmanException("Não foi encontrado caminho até a comida!");
		}
	}
	
	private void imprimirMelhorCaminho(List<Celula> caminhoPercorrido) {
		if (caminhoPercorrido != null && !caminhoPercorrido.isEmpty()) {
			System.out.println(jogo.printLinhaPacman());
			System.out.println(jogo.printLinhaComida());
			System.out.println(jogo.printLinhaDimensoes());
			
			Celula caminho = caminhoPercorrido.get(0).getCelulaPai();
			for (Celula vizinho : caminhoPercorrido) {
				if (vizinho.isComida()) {
					caminho = vizinho.getCelulaPai();
					break;
				}
			}
			while (!caminho.isPacman()) {
				int linha = caminho.getCoordenadas().getLinha();
				int coluna = caminho.getCoordenadas().getColuna();
				caminho = caminho.getCelulaPai();
				jogo.getLabirinto()[linha][coluna] = TipoCelula.CAMINHO_PERCORRIDO.getValor();
			}
			
			for (String[] linhas : jogo.getLabirinto()) {
				String celula = "";
				for (String coluna : linhas) {
					celula += coluna;
				}
				
				System.out.println(celula);
			}

		}
	}
	
}
