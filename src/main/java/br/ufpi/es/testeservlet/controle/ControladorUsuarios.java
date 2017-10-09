package br.ufpi.es.testeservlet.controle;

import java.util.List;

import br.ufpi.es.testeservlet.dados.IRepositorioUsuarios;
import br.ufpi.es.testeservlet.dados.excecoes.UsuarioJaExisteException;
import br.ufpi.es.testeservlet.dados.excecoes.UsuarioNaoExisteException;
import br.ufpi.es.testeservlet.entidades.Usuario;

public class ControladorUsuarios {
	IRepositorioUsuarios repositorio;
	
	public ControladorUsuarios(IRepositorioUsuarios tipo){
		this.repositorio = tipo;
	}
	
	/**
	 * Retorna todos os usuários cadastrados na lista de usuários
	 * @return lista de usuários
	 * @throws UsuarioNaoExisteException 
	 */
	public List<Usuario> getUsuarios() throws UsuarioNaoExisteException{
		return repositorio.listar();
	}
	
	/**
	 * Dados login e senha de um usuário checa se ele existe
	 * @param login login do usuário
	 * @param senha senha do usuário
	 * @return um Usuário se existe e null se não existe
	 * @throws UsuarioNaoExisteException 
	 */
	public Usuario buscar(String login, String senha) throws UsuarioNaoExisteException{
		return repositorio.buscar(login, senha);
	}
	
	/**
	 * Faz uma busca de usuário de acordo com o tipo de busca escolhida
	 * @param conteudo dado do usuário
	 * @param tipo tipo nome, email ou login
	 * @return lista contendo resultado da busca
	 * @throws UsuarioNaoExisteException 
	 */
	public List<Usuario> buscaPorConteudoETipo(String conteudo, String tipo) throws UsuarioNaoExisteException{
		return repositorio.buscarPorConteudoETipo(conteudo, tipo);
	}
	
	/**
	 * Insere um novo usuário no repositório
	 * @param u dados do Usuario
	 * @throws UsuarioJaExisteException 
	 */
	public void inserir(Usuario u) throws UsuarioJaExisteException {
		this.repositorio.inserir(u);
	}
}