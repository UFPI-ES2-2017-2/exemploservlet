package br.ufpi.es.testeservlet.servicos;

import java.io.IOException;
import java.util.Date;

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
 * Servlet implementation class EfetuarLogin
 */
public class EfetuarLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RepositorioListaUsuarios repositorio;
	private ControladorUsuarios controlador;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EfetuarLogin() {
        super();
        repositorio = new RepositorioListaUsuarios();
        repositorio.populaUsuarios();
        controlador = new ControladorUsuarios(repositorio);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if (session.getAttribute("usuario") != null){
			response.sendRedirect("principal");
		}else{
			response.sendRedirect("formlogin.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login;
		String senha;
		String mensagem="";
		
		login = request.getParameter("login");
		senha = request.getParameter("senha");
		Usuario usuario=null;
		
		HttpSession session = request.getSession();
		
		try {
			usuario = controlador.buscar(login, senha);
		} catch (UsuarioNaoExisteException e) {
			mensagem = e.getMessage();
		}
		
		if (usuario != null){	
			session.setAttribute("email", usuario.getEmail());
			Date criacaoSessaoUsuario = new Date(session.getCreationTime());
			session.setAttribute("usuario", usuario);
			System.out.println("Usuario " + session.getAttribute("email") + " logado as" + criacaoSessaoUsuario);
			response.sendRedirect("principal");
		}else{
			session.setAttribute("mensagem", mensagem);
			response.sendRedirect("formlogin.jsp");
		}
		
	}

}
