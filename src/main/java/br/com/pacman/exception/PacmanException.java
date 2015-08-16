package br.com.pacman.exception;

public class PacmanException extends RuntimeException {

	private static final long serialVersionUID = 7082086902465093371L;

	public PacmanException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

	public PacmanException(String mensagem) {
		this(mensagem, (Throwable) null);
	}
	
}
