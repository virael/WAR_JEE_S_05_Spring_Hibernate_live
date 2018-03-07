<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Biblioteka - dodawanie nowej książki</title>
<style type="text/css">
.error {
  background-color: red;
  color: white;
}
</style>
</head>
<body>
  <f:form action="add" method="post" modelAttribute="book">
    <div>
      Tytul: <f:input path="title"/><f:errors path="title" cssClass="error"/>
    </div>
    <div>
      Autor: <f:select path="authors" items="${authors}" multiple="true" itemLabel="name" itemValue="id"/><f:errors path="authors" cssClass="error"/>
    </div>
    <div>
      Rating: <f:input type="number" path="rating" min="1" max="10" /><f:errors path="rating" cssClass="error"/>
    </div>
    <div>
      Wydawca: <f:select path="publisher.id" items="${publishers}" itemLabel="name" itemValue="id"/><f:errors path="publisher" cssClass="error"/>
    </div>
    <div>
      Opis: <f:textarea path="description" cols="30" rows="4" /><f:errors path="description" cssClass="error"/>
    </div>
    <div>
      Liczba stron: <f:input type="number" path="pages" min="1" /><f:errors path="pages" cssClass="error"/>
    </div>
    <div>
      <input type="submit" value="Dodaj książkę"/>
    </div>
  </f:form>
</body>
</html>