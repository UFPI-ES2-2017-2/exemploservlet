package br.ufpi.es.testeservlet.servicos;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.ufpi.es.testeservlet.controle.ControladorUsuarios;
import br.ufpi.es.testeservlet.dados.RepositorioListaUsuarios;
import br.ufpi.es.testeservlet.dados.excecoes.UsuarioNaoExisteException;
import br.ufpi.es.testeservlet.entidades.Usuario;

/**
 * Servlet implementation class BuscarUsuario
 */
public class BuscarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RepositorioListaUsuarios repositorio;
	private ControladorUsuarios controlador;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarUsuario() {
        super();
        repositorio = new RepositorioListaUsuarios();
        repositorio.populaUsuarios();
        controlador = new ControladorUsuarios(repositorio);
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
    	
    	if (session.getAttribute("usuario") != null) {
    		response.sendRedirect("buscar-usuario.jsp");
    	}else {
    		response.sendRedirect("principal");
    	}
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recupar os dados passados pelo formulario de busca
		String conteudo = request.getParameter("conteudobusca");
		String tipo = request.getParameter("opcaotipo");
		HttpSession session = request.getSession();
		String mensagem = "";
		
		List<Usuario> lista = new LinkedList<Usuario>();
		
		//checa se tem uma sessão válida e reencaminha a resposta para exibir o resultado da busca
		if (session.getAttribute("usuario") != null) {
			try {
				lista = controlador.buscaPorConteudoETipo(conteudo, tipo);
			} catch (UsuarioNaoExisteException e) {
				mensagem = e.getMessage(); 
			}
			request.setAttribute("mensagem", mensagem);
			request.setAttribute("usuarios", lista);
			request.getRequestDispatcher("lista-usuarios.jsp").forward(request, response);
		}else {
			response.sendRedirect("principal");
		}
	}

}

	