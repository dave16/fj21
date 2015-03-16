<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Máscara em jQuery</title>
<script type="text/javascript" src="resources/core/jquery-1.8.0.js"></script>
<script type="text/javascript"
	src="resources/core/jquery.maskedinput.min.js"></script>
<link rel="stylesheet" href="resources/css/teste.css">
<script type="text/javascript">
	$(document).ready(function() {
		$(function() {
			$("#data").mask("99/99/9999");
		});
	});
</script>
<style type="text/css">
fieldset {
	background-color: #F0F0F0 ;
	color: black;
	display: block;
	margin-left: 2px;
	margin-right: 2px;
	padding-top: 0.35em;
	padding-bottom: 0.625em;
	padding-left: 0.75em;
	padding-right: 0.75em;
	border: 1px groove(internal value);
}


</style>
</head>
<body>
	<form>
		<fieldset>
			<legend>Personalia:</legend>
			 <label for="nome" >Nome :</label>  <label for="email"> Email :</label><br>
			<input type="text" id="nome">  <input type="text" id="email"><br>
			Date of birth: <input type="text" id="data">
		</fieldset>
	</form>
	
	
</body>
</html>