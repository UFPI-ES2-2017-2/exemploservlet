package br.ufpi.es.testeservlet.dados.excecoes;

public class UsuarioJaExisteException extends Exception {
	public UsuarioJaExisteException(){
		super("Usuário já existe");
	}
}
