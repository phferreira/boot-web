<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Spring-Boot-MVC</title>
	</head>

	<body>
		Funcionou ${valor} teste
		
		<form action="/enviar" method="post">
			<input type="text" name="nome" value="${nome}">
			<input type="text" name="cpf" value="${cpf}">
			<input type="submit" name="enviar">
			<input type="submit" name="cancelar">
		</form>
		
	</body>
	
</html>