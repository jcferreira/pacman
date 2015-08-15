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
		List<Celula> melhoresVizinhos = new ArrayList<Celula>();
		melhoresVizinhos = recuperarVizinhosMelhorCaminho(jogo.getPacman());
		System.out.println(" >>>>>>>>>>>>>>>>  " + melhoresVizinhos.size());
		
		
	}
	
	
	
/*
	private List<Celula> recuperarVizinhosMelhorCaminho(Celula celulaAtual, List<Celula> melhoresVizinhos) {
		
		for (Celula celulaVizinha : recuperarVizinhos(celulaAtual)) {
System.out.println(" >>> Celula Atual   - Tipo: " + celulaAtual.getTipoCelula() + "  |  Coordenadas: " + celulaAtual.getCoordenadas().getLinha() + "," + celulaAtual.getCoordenadas().getColuna());
System.out.println(" >>> Celula Vizinha - Tipo: " + celulaVizinha.getTipoCelula() + "  |  Coordenadas: " + celulaVizinha.getCoordenadas().getLinha() + "," + celulaVizinha.getCoordenadas().getColuna());
			if (celulaVizinha.getTipoCelula() == TipoCelula.COMIDA) break;
			
			if (podeAdicionarCelula(celulaAtual, celulaVizinha)) {
				melhoresVizinhos.add(celulaVizinha);
			} else {
				continue;
			}
			// verificar loop infinito;
			for (Celula celula : melhoresVizinhos) {
				recuperarVizinhosMelhorCaminho(celula, melhoresVizinhos);
			}
		}
		
		return melhoresVizinhos;
	}
*/
	
	
	
	
	
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
	
	
/*
	private List<Celula> recuperarVizinhosMelhorCaminho(Celula celulaAtual) {
		List<Celula> melhoresVizinhos = new ArrayList<Celula>();
		
		for (Celula celulaVizinha : recuperarVizinhos(celulaAtual)) {
			if (podeAdicionarCelula(celulaAtual, celulaVizinha)) {
				melhoresVizinhos.add(celulaVizinha);
			}
		}
		
		return melhoresVizinhos;
	}
*/

	

	private List<Celula> recuperarVizinhos(List<Celula> celulasAtuais) {
		List<Celula> celulasVizinhas = new ArrayList<Celula>();
		
		for (Celula celulaAtual : celulasAtuais) {
			int linha = celulaAtual.getCoordenadas().getLinha();
			int coluna = celulaAtual.getCoordenadas().getColuna();
			
			Celula celulaVizinha = null;
			
			//Celula Acima
			celulaVizinha = jogo.getCelula(linha-1, coluna);
			if (podeAdicionarCelula(celulaVizinha)) {
				celulaVizinha.setCelulaPai(celulaAtual);
				celulasVizinhas.add(celulaVizinha);  	
				if (celulaVizinha.isComida()) 
					break;
			}
			
			//Celula Abaixo
			celulaVizinha = jogo.getCelula(linha+1, coluna);
			if (podeAdicionarCelula(celulaVizinha)) {
				celulaVizinha.setCelulaPai(celulaAtual);
				celulasVizinhas.add(celulaVizinha);
				if (celulaVizinha.isComida()) 
					break;
			}
			
			// Celula Esquerda
			celulaVizinha = jogo.getCelula(linha, coluna-1);
			if (podeAdicionarCelula(celulaVizinha)) {
				celulaVizinha.setCelulaPai(celulaAtual);
				celulasVizinhas.add(celulaVizinha);
				if (celulaVizinha.isComida()) 
					break;
			}
			
			// Celula Direita
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
	
	private boolean podeAdicionarCelula(Celula celulaAtual, Celula celulaVizinha) {
		if (celulaVizinha == null || celulaVizinha.getTipoCelula() == TipoCelula.PAREDE) return false;
		
		if (celulaVizinha.getValorDaPosicaoEmRelacaoComida(jogo.getComida()) < celulaAtual.getValorDaPosicaoEmRelacaoComida(jogo.getComida())) {
			return true;
		} 
			
		return false;
	}

	private boolean podeAdicionarCelula(Celula celulaVizinha) {
		if (celulaVizinha != null && !celulaVizinha.possuiCelulaPai() && celulaVizinha.getTipoCelula() != TipoCelula.PAREDE) 
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
	
	
}
