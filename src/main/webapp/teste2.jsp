<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="resources/css/bootstrap.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form class="form-horizontal">
		<fieldset>

			<!-- Form Name -->
			<legend>Cadastro</legend>

			<!-- Text input-->
			<div >
				<label class="control-label" for="nome">Nome</label>
				<div class="controls">
					<input id="nome" name="nome" type="text"
						placeholder="Digite seu Nome" class="input-xlarge">

				</div>
			</div>

			<!-- Text input-->
			<div class="control-group">
				<label class="control-label" for="email">Email</label>
				<div class="controls">
					<input id="email" name="email" type="text"
						placeholder="Digite seu Email" class="input-xlarge" required="">

				</div>
			</div>

			<!-- Password input-->
			<div class="control-group">
				<label class="control-label" for="senha">Senha</label>
				<div class="controls">
					<input id="senha" name="senha" type="password"
						placeholder="Digite uma senha" class="input-xlarge" required="">

				</div>
			</div>

			<!-- Password input-->
			<div class="control-group">
				<label class="control-label" for="confirmeSenha">Confirme a
					Senha</label>
				<div class="controls">
					<input id="confirmeSenha" name="confirmeSenha" type="password"
						placeholder="Digite novamente sua senha" class="input-xlarge"
						required="">

				</div>
			</div>

			<!-- Button (Double) -->
			<div class="control-group">
				<label class="control-label" for="ok"></label>
				<div class="controls">
					<button id="ok" name="ok" class="btn btn-success">Ok</button>
					<button id="cancelar" name="cancelar" class="btn btn-danger">Cancelar</button>
				</div>
			</div>

		</fieldset>
	</form>
</body>
</html>