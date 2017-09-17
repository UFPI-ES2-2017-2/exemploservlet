package br.ufpi.es.testeservlet.servicos;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.ufpi.es.testeservlet.controle.ControladorUsuarios;
import br.ufpi.es.testeservlet.dados.RepositorioListaUsuarios;
import br.ufpi.es.testeservlet.entidades.Usuario;

/**
 * Servlet implementation class ListaUsuarios
 */
public class ListaUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RepositorioListaUsuarios repositorio;
	private ControladorUsuarios controlador;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListaUsuarios() {
		super();
		repositorio = new RepositorioListaUsuarios();
		repositorio.populaUsuarios();
		controlador = new ControladorUsuarios(repositorio);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Usuario> lista = controlador.getUsuarios();
		/*
		 * for (Usuario u:lista){ response.getWriter().append("Usuario : ["
		 * +u.getId() + "]" + " - " + u.getNome() + " - " + u.getEmail()); }
		 */
		HttpSession session = request.getSession();

		if (session.getAttribute("usuario") != null) {
			request.setAttribute("usuarios", lista);
			request.getRequestDispatcher("lista-usuarios.jsp").forward(request, response);
		} else {
			response.sendRedirect("principal");
		}

	}

}
