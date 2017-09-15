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
}
