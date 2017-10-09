package br.ufpi.es.testeservlet.dados;

import java.util.List;

import br.ufpi.es.testeservlet.dados.excecoes.UsuarioJaExisteException;
import br.ufpi.es.testeservlet.dados.excecoes.UsuarioNaoExisteException;
import br.ufpi.es.testeservlet.entidades.Usuario;

public interface IRepositorioUsuarios {
	public void inserir(Usuario u) throws UsuarioJaExisteException;
	public List<Usuario> listar() throws UsuarioNaoExisteException;
	public Usuario buscar(String login, String senha) throws UsuarioNaoExisteException;
	public void alterar(Usuario original, Usuario novo) throws UsuarioNaoExisteException;
	public void remover(Usuario u) throws UsuarioNaoExisteException;
	public List<Usuario> buscarPorConteudoETipo(String conteudo, String tipo) throws UsuarioNaoExisteException;
}
