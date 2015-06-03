<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
* {
	font-family: Verdana, Arial;
}

table {
	background-color: #EEEEEE;
	border: solid #CCCCCC 1px;
}

th {
	background-color: #CCCCCC;
	color: #FFFFFF;
}

.campo {
	border: solid #CCCCCC 1px;
}
</style>



</head>
<body>
	<form method="POST" action="LogarJPA">
<b style="color:blue"> ${mensagem}</b>
		<table>

			<tr>

				<th colspan="2">Login</th>

			</tr>

			<tr>

				<td>Login:</td>

				<td><input class="campo" type="text" name="login" /></td>

			</tr>

			<tr>

				<td>Senha:</td>

				<td><input class="campo" type="password" name="senha" /></td>

			</tr>
			
			

			<tr>

				<td colspan="2" align="center"><input type="submit"
					value="Entrar" /></td>

			</tr>

		</table>

	</form>

</body>
</html>