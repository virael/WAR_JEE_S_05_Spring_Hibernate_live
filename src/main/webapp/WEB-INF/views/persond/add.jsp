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
      Password: <f:password path="password"/>
    </div>
    <div>
      E-mail: <f:input type="email" path="email"/>
    </div>
    <div>
      Imię: <f:input path="firstName"/>
    </div>
    
    <div>
      Nazwisko: <f:input path="lastName"/>
    </div>
    
    <div>
    	Mężczyzna: <f:radiobutton path="gender" value="M"/>
		Kobieta: <f:radiobutton path="gender" value="F"/>
    </div>
    
    <div>
    	Kraj: <f:select path="country" items="${countries}" />
    </div>
    
    <div>
    	Uwagi: <f:textarea path="notes" rows="3" cols="20"/>
    </div>
    
    <div>
    	Zgoda na otrzymywanie mailingów: <f:checkbox path="mailingList"/>
    </div>
    
    <div>
    	Znajomość języków programowania: <f:select path="programmingSkills" items="${skills}" multiple="true" />
    </div>
    
    <div>
    	Hobby: <f:checkboxes items="${hobbies}" path="hobbies"/> 
    </div>
    
    <div>
      <input type="submit" value="Dodaj osobę"/>
    </div>
  </f:form>
</body>
</html>