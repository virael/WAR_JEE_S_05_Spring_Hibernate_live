<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Biblioteka - potwierdzenie usunięcia książki</title>
</head>
<body>
	<h2>Czy potwierdzasz usunięcie następującej książki?</h2>
	<table>
		<tr>
			<th>Id</th>
			<th>Tytuł</th>
			<th>Autor</th>
			<th>Rating</th>
			<th>Opis</th>
			<th>Wydawca</th>
		</tr>
		<tr>
			<td>${book.id}</td>
			<td>${book.title}</td>
			<td><c:forEach items="${book.authors}" var="author">${author.name}<br />
				</c:forEach></td>
			<td>${book.rating}</td>
			<td>${book.description}</td>
			<td>${book.publisher.name}</td>
		</tr>
	</table>
	<f:form action="remove" method="post" modelAttribute="book">
		<f:hidden path="id"/>
		<input type="submit" value="Potwierdź"/>
	</f:form>
	<f:form action="list" method="get">
		<input type="submit" value="Anuluj"/>
	</f:form>
</body>
</html>