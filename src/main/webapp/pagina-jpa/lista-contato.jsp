<%@page import="br.com.dc.bd.jpa.Repositorio"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<fieldset >
<legend> <strong>Lista De Contatos</strong></legend>
	<table border="3px" cellpadding="10px" bordercolor="red">
		<tr>
			<td>Id</td>
			<td>Nome</td>
			<td>Email</td>
			<td>Endereco</td>
			<td>Data</td>
			<td>Login</td>
			<td>Senha</td>
			<td>Editar</td>
			<td>Excluir</td>
		</tr>

		<c:forEach var="contato" items="${listaRepositorio}">
			<tr>
				<td>${contato.id}</td>
				<td>${contato.nome}</td>
				<td><c:choose>
				<c:when test="${not empty contato.email}"><a href="mailto:${contato.email}">${contato.email}</a></c:when>
				<c:otherwise>Email nao informado</c:otherwise>
				</c:choose>
				</td>
				
				<td>${contato.endereco}</td>
				<td>
				<fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy"/>
				</td>
				<td>${contato.usuario.login}</td>
				<td>${contato.usuario.senha}</td>
				<td><a href="/Fj21/jpa?logica=BuscaContatoJpa&id=${contato.id}"><img alt="editar" src="../resources/imagens/editar_1.png" width="100"></a></td>
				<td><a href="/Fj21/jpa?logica=ExcluirContatoJpa&id=${contato.id}" onclick="return confirm('Excluir contato ?')"><img alt="excluir" src="../resources/imagens/excluir_1.png" width="100"></a></td>
			</tr>
		</c:forEach>


	</table>
</fieldset>
</body>
</html>