package br.com.empresa.api.handler;

public class UsuarioNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	
	public UsuarioNotFoundException(String message) {
		super(message);
	}

}
