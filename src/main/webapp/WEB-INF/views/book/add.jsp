<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Biblioteka - dodawanie nowej książki</title>
</head>
<body>
  <f:form action="add" method="post" modelAttribute="book">
    <div>
      Tytul: <f:input path="title"/>
    </div>
    <div>
      Rating: <f:input type="number" path="rating" min="1" max="10" />
    </div>
    <div>
      Wydawca: <f:select path="publisher.id" items="${publishers}" itemLabel="name" itemValue="id"/>
    </div>
    <div>
      Opis: <f:textarea path="description" cols="30" rows="4" />
    </div>
    <div>
      <input type="submit" value="Dodaj książkę"/>
    </div>
  </f:form>
</body>
</html>