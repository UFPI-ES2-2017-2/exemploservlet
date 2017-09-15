<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="br.ufpi.es.testeservlet.entidades.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Página Principal</title>
</head>
<body>
<h2>Bem vindo ao sistema web simplificado implementado com servlets</h2>
	<%
		Usuario usuario = (Usuario) request.getAttribute("usuario");
		out.println("Login: " + usuario.getLogin() + "<br>");
		out.println("Nome: " + usuario.getNome() + "<br>");
		out.println("E-mail: " + usuario.getEmail() + "<br>");
	%>
	<br>
	<a href="#">Inserir Usuario</a>
	<br>
	<a href="listarusuarios">Listar Usuários</a>
	<br>
	<a href="buscarusuario">Buscar Usuário</a>
	<br>
	<a href="#">Alterar Usuário</a>
	<br>
	<a href="listarusuariosjson">Listar Usuário em formato JSON</a>
	<br>
	<a href="efetuarlogout">Logout</a>
</body>
</html>