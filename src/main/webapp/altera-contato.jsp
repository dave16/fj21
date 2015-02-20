<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="resources/core/jquery-ui.css" type="text/css">
<script type="text/javascript" src="resources/core/jquery-1.8.0.js"></script>
<script type="text/javascript" src="resources/core/jquery-ui.js"></script>
<script type="text/javascript" src="resources/core/scripts.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:import url="cabecalho.jsp"/>

<h3>Formulário para alteração de contatos : </h3>

<form action="mvc" method="post">
Id : <input type="text" name="id"><br/>
Nome : <input type="text" name="nome"><br/>
E-mail : <input type="text" name="email"> <br/>
Endereço : <input type="text" name="endereco"><br/>
Data de Nascimento <input type="text" name="dataNascimento" id="datepicker"><br/>

<input type="hidden" name="logica" value="AlteraContato">
<input type="submit" value="Ok">

</form>

<c:import url="rodape.jsp"/>

</body>
</html>