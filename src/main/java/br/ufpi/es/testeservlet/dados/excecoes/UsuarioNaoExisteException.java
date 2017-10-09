package br.ufpi.es.testeservlet.dados.excecoes;

public class UsuarioNaoExisteException extends Exception {
	public UsuarioNaoExisteException(){
		super("Usuário não existe!");
	}
}
