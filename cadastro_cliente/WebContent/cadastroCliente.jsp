<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Cliente</title>
<link rel="stylesheet" href="css/cadastro.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

 	<h1>Cadastro de Cliente</h1>
 	
 	
 		<br><br>
 		
 		<h4 class="${class}">${msg}</h4>

		<form action="ClienteServelet" method="post">
		 <ul class="form-style-1">
			<input type="text" class="field-long" readonly="readonly" name="id" value="${cliente.id }">
			<br>
			<label>Nome:</label>
			<input type="text" class="field-long" name="nome" value="${cliente.nome }">
			<br>
			<label>Email:</label>
			<input type="text" class="field-long" name="email" value="${cliente.email }">
			<br>
			<label>Senha:</label>
			<input type="password" class="field-long" name="senha" value="${cliente.senha }">
			<br>
			<label>Telefone:</label>
			<input type="text" class="field-long" name="fone" value="${cliente.fone }">
			<br>
			<br>
			<br>
			<li><input type="submit" value="Salvar"> <input type="submit" value="Limpar"></li>
		</ul>
		</form>
		
		
		<div class="container">
					
				<table class="table" width="50%">
					  <thead class="thead-dark">
					    <tr>
					      <th scope="col">#</th>
					      <th scope="col">Nome</th>
					      <th scope="col">Email</th>
					      <th scope="col">Senha</th>
					      <th scope="col">Telefone</th>
					      <th scope="col">Ação</th>
					      <th scope="col">Ação</th>
					    </tr>
					  </thead>
					  <tbody>
					  <c:forEach items="${clientes}" var="cliente">
					    <tr>
					    <td scope="row"><c:out value="${cliente.id }"></c:out> </td>
				    	<td><c:out value="${cliente.nome }"></c:out> </td>
				    	<td><c:out value="${cliente.email }"></c:out> </td>
				    	<td><c:out value="${cliente.senha }"></c:out> </td>
				    	<td><c:out value="${cliente.fone }"></c:out> </td>
				    	<td><a href="ClienteServelet?acao=excluir&id=${cliente.id }"><img src="imagens/delete.png"/></a></td>
				    	<td><a href="ClienteServelet?acao=editar&id=${cliente.id }"><img src="imagens/update.png"/></a></td>
					    </tr>
					   </c:forEach>
					  </tbody>
					</table>
		</div>
		<br>
		<br>	
		

</body>
</html>