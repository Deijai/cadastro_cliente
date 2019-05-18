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
			<label>Nome:</label>
			<input type="text" name="nome">
			<br>
			<label>Email:</label>
			<input type="text" name="email">
			<br>
			<label>Senha:</label>
			<input type="password" name="senha">
			<br>
			<input type="submit" value="Salvar">
		</form>
		
		<br>
		<br>
		<br>
		<br>
		
		<table border="1">
		
			   <tr>
			    	<td><c:out value="ID"></c:out> </td>
			    	<td><c:out value="NOME"></c:out> </td>
			    	<td><c:out value="EMAIL"></c:out> </td>
			    	<td><c:out value="SENHA"></c:out> </td>
			    	<td>AÇÂO</td>
			    	<td>AÇÂO</td>
			    </tr>
			    
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