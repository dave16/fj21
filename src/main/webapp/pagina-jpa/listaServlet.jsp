<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:forward page="/jpa">
		<jsp:param name="logica" value="ListaContatoJpa" />
	</jsp:forward>
	<form action="/Fj21/jpa">

		<input type="submit" value="Listar"> <input type="hidden"
			name="logica" value="ListaContatoJpa">
	</form>
</body>
</html>