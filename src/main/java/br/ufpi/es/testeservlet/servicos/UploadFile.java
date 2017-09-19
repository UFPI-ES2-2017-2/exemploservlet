package br.ufpi.es.testeservlet.servicos;

import java.io.FileNotFoundException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import br.ufpi.es.testeservlet.controle.upload.ArmazenaItemArquivo;
import br.ufpi.es.testeservlet.controle.upload.ProcessaUpload;
import br.ufpi.es.testeservlet.utilidades.Constantes;
import br.ufpi.es.testeservlet.visao.*;

/**
 * Servlet implementation class UploadFile
 */
public class UploadFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Formulario form = new Formulario();
	private String uploadPath;   
	private String processamento="erro";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadFile() {
        super();
    }
    
    /**
	 * Inicializa o servlet
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException { 
        uploadPath = System.getProperty(Constantes.USER_DIRECTORY);
		
		System.out.println("Servlet inicializado...");
		System.out.println("Path do upload: " + uploadPath);
	}
 
	/**
	 * Get do usuario
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		PrintWriter saida = response.getWriter();

		if (session.getAttribute("usuario") != null) {
			form.limpaPagina();
			form.montaPagina("Bem vindo ao fileupload");
			saida.print(form.pagina());
		} else {
			response.sendRedirect("efetuarlogin");
		}
	}
	
	/**
	 * Envia resposta para o usuario
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		PrintWriter saida = response.getWriter();
		String nomeArquivo = "";

		if (session.getAttribute("usuario") != null) {
			checaMultipart(request);
			DiskFileItemFactory factory = new ArmazenaItemArquivo().executa();
			try {
				nomeArquivo = new ProcessaUpload().executa(request, nomeArquivo, factory, this.uploadPath);
				processamento = "sucesso";
			} catch (FileUploadException ex) {
				throw new ServletException(ex);
			} catch (FileNotFoundException ex) {
				processamento = "Erro: arquivo não existe!";
				System.out.println("Arquivo não existe!");
			} catch (Exception ex) {
				throw new ServletException(ex);
			} finally {
				System.out.println("Upload do arquivo " + nomeArquivo + " concluido com " + processamento + "!");
				form.limpaPagina();
				form.montaPagina("Upload do arquivo " + nomeArquivo + " concluido com " + processamento + "!");
				saida.print(form.pagina());
			}
		} else {
			response.sendRedirect("efetuarlogin");
		}

	}

	/**
	 * Check o upload request do tipo multipart
	 * @param request requisiรงรฃo do Servlet
	 */
	private void checaMultipart(HttpServletRequest request) {
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		
		if (!isMultipart) {
			return;
		}
	}
	
}
