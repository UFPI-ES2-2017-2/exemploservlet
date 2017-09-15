<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.LinkedList" %>
    <%@page import="br.ufpi.es.testeservlet.entidades.*" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de usuários</title>
</head>
<body>

<%  
// retrieve your list from the request, with casting 
LinkedList<Usuario> list = (LinkedList<Usuario>) request.getAttribute("usuarios");

// print the information about every category of the list
for(Usuario u : list) {
    out.println(u.getId() + " - ");
    out.println(u.getNome() + " - ");
    out.println(u.getEmail());
    out.println("<br>");
}
%>

</body>
</html>