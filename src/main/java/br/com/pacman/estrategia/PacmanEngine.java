package br.com.pacman.estrategia;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.pacman.model.Celula;
import br.com.pacman.model.Jogo;
import br.com.pacman.model.TipoCelula;

public class PacmanEngine implements Serializable {

	private static final long serialVersionUID = 8312042664675866410L;
	
	private Jogo jogo;
	
	
	public PacmanEngine(Jogo jogo) {
		this.jogo = jogo;
	}
	
	
	public void definirMelhorCaminho() {
		List<Celula> caminhoPercorrido = new ArrayList<Celula>();
		caminhoPercorrido = recuperarVizinhosMelhorCaminho(jogo.getPacman());
		validarSeEncontrouComida(caminhoPercorrido);
		imprimirMelhorCaminho(caminhoPercorrido);
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
			System.out.println(" >>>>  Não foi encontrado caminho até a comida!  <<<< ");
		}
	}
	
	private void imprimirMelhorCaminho(List<Celula> caminhoPercorrido) {
		if (caminhoPercorrido != null && !caminhoPercorrido.isEmpty()) {
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
				jogo.getLabirinto()[linha][coluna] = "*";
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
