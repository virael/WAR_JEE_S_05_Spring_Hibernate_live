<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Biblioteka - formularz do edycji książki</title>
</head>
<body>
  <h2>Edycja książki</h2>
  <f:form action="edit" method="post" modelAttribute="book">
    <div>
      Tytul: <f:input path="title"/>
    </div>
    <div>
      Autor: <f:select path="authors" items="${authors}" multiple="true" itemLabel="name" itemValue="id"/>
    </div>
    <div>
      Rating: <f:input type="number" path="rating" min="1" max="10"/>
    </div>
    <div>
      Wydawca: <f:select path="publisher.id" items="${publishers}" itemLabel="name" itemValue="id"/>
    </div>
    <div>
      Opis: <f:textarea path="description" cols="30" rows="4"/>
    </div>
    <div>
      Liczba stron: <f:input type="number" path="pages" min="1" />
    </div>
        <f:hidden path="id"/>
    <div>
      <input type="submit" value="Zapisz zmiany"/>
    </div>
  </f:form>
</body>
</html>