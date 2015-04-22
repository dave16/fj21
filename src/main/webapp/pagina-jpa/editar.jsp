<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="../resources/core/jquery-1.8.0.js"></script>
<script type="text/javascript" src="../resources/core/jquery-ui.js"></script>
<script type="text/javascript"
	src="../resources/core/jquery.maskedinput.min.js"></script>
<script type="text/javascript" src="../resources/core/scripts.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/Fj21/jpa" method="post">

		<fieldset>
			<legend>Editar</legend>
			<table border="1"
				style="width: 20%; margin-left: 300px; margin-bottom: 100px; margin-top: 100px">
				<tr>
					<td>Editar :</td>
					<td><input type="text" name="id" value="${buscaContato.id}"></td>
				</tr>

				<tr>
					<td>Nome :</td>
					<td><input type="text" name="nome"
						value="${buscaContato.nome}"></td>
				</tr>

				<tr>
					<td>Email :</td>
					<td><input type="text" name="email"
						value="${buscaContato.email}"></td>
				</tr>

				<tr>
					<td>Endereco :</td>
					<td><input type="text" name="endereco"
						value="${buscaContato.endereco }"></td>
				</tr>

				<tr>
					<td>Data Nascimento</td>
					<td><input type="text" id="dataNascimento"
						name="dataNascimento"
						value="<fmt:formatDate value="${buscaContato.dataNascimento.time}" pattern="dd/MM/yyyy"/>"></td>
				</tr>

				<tr>
					<td>Login</td>
					<td><input type="text" name="login" id="login"
						value="${buscaContato.usuario.login}"></td>
				</tr>

				<tr>
					<td>Senha</td>
					<td><input type="password" name="senha" id="senha"
						value="${buscaContato.usuario.senha}"></td>
				</tr>

				<td><input type="submit" value="Ok"></td>
				<input type="hidden" name="logica" value="EditarJpa">
			</table>
		</fieldset>
</body>
</html>