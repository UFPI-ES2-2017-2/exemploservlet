package br.ufpi.es.testeservlet.servicos;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.ufpi.es.testeservlet.controle.ControladorUsuarios;
import br.ufpi.es.testeservlet.dados.RepositorioListaUsuarios;
import br.ufpi.es.testeservlet.entidades.Usuario;

/**
 * Servlet implementation class ListaUsuariosJSON
 */
public class ListaUsuariosJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RepositorioListaUsuarios repositorio;
	private ControladorUsuarios controlador;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListaUsuariosJSON() {
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

		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		String jsonStr = gson.toJson(lista);

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().append(jsonStr);
	}

}
