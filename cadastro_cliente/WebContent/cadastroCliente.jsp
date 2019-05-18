<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Cliente</title>
</head>
<body>

 	<h1>Cadastro de Cliente</h1>

		<form action="ClienteServelet" method="post">
			<input type="text" readonly="readonly" name="nome" value="${cliente.id }">
			<br>
			<label>Nome:</label>
			<input type="text" name="nome" value="${cliente.nome }">
			<br>
			<label>Email:</label>
			<input type="text" name="email" value="${cliente.email }">
			<br>
			<label>Senha:</label>
			<input type="password" name="senha" value="${cliente.senha }">
			<br>
			<input type="submit" value="Salvar">
		</form>
		
		<br>
		<br>
		<br>
		<br>
		
		<table border="1">
				<c:forEach items="${clientes}" var="cliente">
					<tr>
				    	<td><c:out value="${cliente.id }"></c:out> </td>
				    	<td><c:out value="${cliente.nome }"></c:out> </td>
				    	<td><c:out value="${cliente.email }"></c:out> </td>
				    	<td><c:out value="${cliente.senha }"></c:out> </td>
				    	<td><a href="ClienteServelet?acao=excluir&id=${cliente.id }">Excluir</a></td>
				    	<td><a href="ClienteServelet?acao=editar&id=${cliente.id }">Editar</a></td>
				    </tr>
				</c:forEach>
		</table>

</body>
</html>