<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
  <h2>Udało się zarejestrować osobę</h2>
  <div>
      Login: ${person.login}
    </div>
    <div>
      E-main: ${person.email}
    </div>
    <div>
      Password: ${person.password}
    </div>
    <div>
      Imię: ${person.firstName}
    </div>
    
    <div>
      Nazwisko: ${person.lastName}
    </div>
    
    <div>
    	Płeć: ${person.gender=='M' ? 'Mężczyzna' : 'Kobieta'}
    </div>
    
    <div>
    	Kraj: ${person.country}
    </div>
    
    <div>
    	Uwagi: ${person.notes}
    </div>
    
    <div>
    	Zgoda na otrzymywanie mailingów: ${person.mailingList}
    </div>
    
    <div>
    	Znajomość języków programowania: 
    	<c:forEach items="${person.programmingSkills}" var="skill">
    		${skill}
    	</c:forEach>
    </div>
    
    <div>
    	Hobby: 
    	<c:forEach items="${person.hobbies}" var="hobby">
    		${hobby}
    	</c:forEach> 
    </div>
</body>
</html>