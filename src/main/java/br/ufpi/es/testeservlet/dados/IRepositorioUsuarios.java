package br.ufpi.es.testeservlet.dados;

import java.util.List;

import br.ufpi.es.testeservlet.entidades.Usuario;

public interface IRepositorioUsuarios {
	public void inserir(Usuario u);
	public List<Usuario> listar();
	public Usuario buscar(String login, String senha);
	public void alterar(Usuario original, Usuario novo);
	public void remover(Usuario u);
}
