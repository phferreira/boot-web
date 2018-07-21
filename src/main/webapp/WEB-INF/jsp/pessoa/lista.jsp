<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de pessoas</title>
</head>

<body>

	<a href="/pessoa/novo">Nova pessoa</a>
	<table>
		<thead>
			<tr>
				<td>Codigo</td>
				<td>Nome</td>
				<td>CPF</td>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${pessoas}" var="pessoa">
				<tr>
					<td>${pessoa.codigo}</td>
					<td>${pessoa.nome}</td>
					<td>${pessoa.cpf}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>

</html>