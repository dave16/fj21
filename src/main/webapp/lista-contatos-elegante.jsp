<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:import url="cabecalho.jsp" />
	<br />
	<br />
	<br />
	<br />
	
	<jsp:useBean id="dao" class="br.com.dc.bd.jdbc.ContatoDAO" />

	<table border="3px" cellpadding="10px" bordercolor="red">
		<tr>
			<td>Id</td>
			<td>Nome</td>
			<td>Email</td>
			<td>Endereco</td>
			<td>Data</td>
			<td>Data de Cadastro</td>
			<td>Editar</td>
			<td>Excluir</td>
		</tr>

		<c:forEach var="contato" items="${dao.lista}">

			<tr>
				<td>${contato.id}</td>
				<td>${contato.nome}</td>
				<td><c:choose>
						<c:when test="${not empty contato.email}">
							<a href="mailto:${contato.email}">${contato.email}</a>
						</c:when>
						<c:otherwise>E mail nao informado</c:otherwise>
					</c:choose></td>
				<td>${contato.endereco}</td>
				<td><fmt:formatDate value="${contato.dataNascimento.time}"
						pattern="dd/MM/yyyy" /></td>
				<td><fmt:formatDate value="${contato.dataCadastro.time }"/>
				<td><a href="mvc?logica=BuscaContato&id=${contato.id}"><img alt="Editar" src="resources/imagens/editar.png" width="90" height="50"></a></td>
				<td><a href="mvc?logica=ExcluirContato&id=${contato.id}" onclick = "return confirm('Você tem certeza que deseja excluir este registro?')"> <img  alt="excluir" width="120" height="100" src="resources/imagens/excluir.png"></a></td>
			</tr>

		</c:forEach>

	</table>
<br/><br/>
<c:import url="rodape.jsp"/>
</body>
</html>