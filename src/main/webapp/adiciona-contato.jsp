<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link rel="stylesheet" href="resources/core/jquery-ui.css" type="text/css">
<script type="text/javascript" src="resources/core/jquery-1.8.0.js"></script>
<script type="text/javascript" src="resources/core/jquery-ui.js"></script>
<script type="text/javascript" src="resources/core/scripts.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
	<c:import url="cabecalho.jsp" />

	<form action="adicionaContato" method="post">

		Nome : <input type="text" name="nome"><br> 
		Email : <input	type="text" name="email"><br>
	    Endereco : <input type="text" name="endereco"><br> 
	    Data Nascimento : <input type="text" name="dataNascimento" id="datepicker"><br> 
	    
	    <input	type="submit" value="Ok">
	</form>

	<c:import url="rodape.jsp" />
</body>
</html>