<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Student Confirmation form</title>
</head>
<body>
The student is confirmed:${student.firstName} ${student.lastName}
<br/><br/>
Country:${student.country}
<br/><br/>
Favourite Language:${student.favouriteLanguage}
<br/><br/>
Operating Systems:
<ul>
<c:forEach var="temp" items="${student.operatingSystems}">
<li>${temp}</li>
</c:forEach>
</ul>
</body>