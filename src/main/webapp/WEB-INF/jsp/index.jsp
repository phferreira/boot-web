<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Spring-Boot-MVC</title>
	</head>

	<body>
				
		<form action="/pessoa/salvar" method="post">
			<label for="nome">Nome</label>
			<input type="text" name="nome" id="nome">
			<label for="cpf">CPF</label>
			<input type="text" name="cpf" id="cpf">
			
			<input type="submit" name="enviar">
			<a href="/pessoa/lista">Cancelar</a>
		</form>
		
	</body>
	
</html>