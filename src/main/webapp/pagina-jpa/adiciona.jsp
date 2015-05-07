<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="../resources/core/jquery-1.8.0.js"></script>
<script type="text/javascript" src="../resources/core/jquery-ui.js"></script>
<script type="text/javascript" src="../resources/core/jquery.maskedinput.min.js"></script>
<script type="text/javascript" src="../resources/core/scripts.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:import url="/cabecalhojpa.jsp"></c:import>
<form action="/Fj21/jpa" method=get>
<label for="nome">Nome :</label>
<input type="text" name="nome" id="nome"><br/>
<label for="email">Email : </label>
<input type="text" name="email" id="email"><br/>
<label for="endereco">Endereco</label>
<input type="text" name="endereco" id="endereco"><br/>
<label for="dataNascimento">Data Nascimento</label>
<input type="text" name="dataNascimento" id="dataNascimento"><br/>
<label for="login">Login</label>
<input type="text" name="login" id="login"><br/>
<label for="senha">Senha</label>
<input type="password" name="senha" id="senha"><br/><br/>
<input type="reset" value="Cancelar">
<input type="submit" value="Ok">
<input type="hidden" name="logica" value="AdicionaContatoJpa"><br/>
<c:import url="/rodape.jsp"></c:import>
</form>
</body>
</html>