<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Biblioteka - lista wszytskich książek</title>
</head>
<body>
  <h2>Lista książek</h2>
  <table>
    <tr>
        <th>Id</th>
        <th>Tytuł</th>
        <th>Autor</th>
        <th>Rating</th>
        <th>Opis</th>
        <th>Wydawca</th>
        <th>Liczba stron</th>
    </tr>
    <c:forEach items="${books}" var="book">
        <tr>
            <td>${book.id}</td>
            <td>${book.title}</td>
            <td>
              <c:forEach items="${book.authors}" var="author">${author.name}<br/></c:forEach>
            </td>
            <td>${book.rating}</td>
            <td>${book.description}</td>
            <td>${book.publisher.name}</td>
            <td>${book.pages}</td>
            <td><a href="<c:url value='edit?id=${book.id}'/>">Edytuj książkę</a></td>
            <td><a href="<c:url value='remove?id=${book.id}'/>">Usuń książkę</a></td>
        </tr>
    </c:forEach>
  </table>
  <a href="<c:url value='add'/>">Dodaj nową książkę</a>
</body>
</html>