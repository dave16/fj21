<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link rel="stylesheet" href="resources/core/jquery-ui.css"
	type="text/css">
<script type="text/javascript" src="resources/core/jquery-1.8.0.js"></script>
<script type="text/javascript" src="resources/core/jquery-ui.js"></script>
<script type="text/javascript" src="resources/core/scripts.js"></script>
<script type="text/javascript"
	src="resources/core/jquery.maskedinput.min.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
	<c:import url="cabecalho.jsp" />

	<form action="mvc" method="post">
		<fieldset >
		<legend>Cadastro</legend>
		
	SSSS <input type="text"><br>
	eeee <input type="text">	
			<table border="1"
				style="width: 20%; margin-left: 300px; margin-bottom: 100px; margin-top: 100px">
				<tr>
					<td>Nome :</td>
					<td><input type="text" name="nome"></td>
				</tr>

				<tr>
					<td>Email :</td>
					<td><input type="text" name="email"></td>
				</tr>

				<tr>
					<td>Endereco :</td>
					<td><input type="text" name="endereco"></td>
				</tr>

				<tr>
					<td>Data DatePicker :</td>
					<td><input type="text" name="dataDatePicker" id="datepicker"></td>
				</tr>

				<tr>
					<td>Data Nascimento</td>
					<td><input type="text" id="dataNascimento" name="dataNascimento"></td>
				</tr>

				<tr>
					<td>Login</td>
					<td><input type="text" name="login" id="login"></td>
				</tr>

				<tr>
					<td>Senha</td>
					<td><input type="password" name="senha" id="senha"></td>
				</tr>

				<tr>
					<td></td>
					<td><input type="password" name="verificaSenha"
						id="verificaSenha"></td>
				</tr>

				<tr>
					<td></td>
					<td><input type="reset" value="Cancelar "> <input
						type="submit" value="OK "></td>
				</tr>
				<input type="hidden" name="logica" value="AdicionaContato">
			</table>
			
		</fieldset>
	</form>

	<c:import url="rodape.jsp" />
</body>
</html>