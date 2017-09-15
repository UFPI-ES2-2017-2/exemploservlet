package br.ufpi.es.testeservlet.controle;

import java.util.List;

import br.ufpi.es.testeservlet.dados.IRepositorioUsuarios;
import br.ufpi.es.testeservlet.entidades.Usuario;

public class ControladorUsuarios {
	IRepositorioUsuarios repositorio;
	
	public ControladorUsuarios(IRepositorioUsuarios tipo){
		this.repositorio = tipo;
	}
	
	/**
	 * Retorna todos os usuários cadastrados na lista de usuários
	 * @return lista de usuários
	 */
	public List<Usuario> getUsuarios(){
		return repositorio.listar();
	}
	
	/**
	 * Dados login e senha de um usuário checa se ele existe
	 * @param login login do usuário
	 * @param senha senha do usuário
	 * @return um Usuário se existe e null se não existe
	 */
	public Usuario buscar(String login, String senha){
		return repositorio.buscar(login, senha);
	}
	
	/**
	 * Faz uma busca de usuário de acordo com o tipo de busca escolhida
	 * @param conteudo dado do usuário
	 * @param tipo tipo nome, email ou login
	 * @return lista contendo resultado da busca
	 */
	public List<Usuario> buscaPorConteudoETipo(String conteudo, String tipo){
		return repositorio.buscarPorConteudoETipo(conteudo, tipo);
	}
	
	/**
	 * Insere um novo usuário no repositório
	 * @param u dados do Usuario
	 */
	public void inserir(Usuario u) {
		this.repositorio.inserir(u);
	}
}