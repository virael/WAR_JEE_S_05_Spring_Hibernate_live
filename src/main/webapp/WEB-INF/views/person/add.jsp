<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
  <f:form action="add" method="post" modelAttribute="person">
    <div>
      Login: <f:input path="login"/>
    </div>
    <div>
      E-mail: <f:input type="email" path="email"/>
    </div>
    <div>
      Password: <f:password path="password"/>
    </div>
    <div>
      <input type="submit" value="Dodaj osobę"/>
    </div>
  </f:form>
</body>
</html>