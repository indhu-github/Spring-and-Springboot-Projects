<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title>Student Registration form</title>
</head>
<body>
<form:form action="processForm" modelAttribute="student">
First Name:<form:input path="firstName"/>
<br>

Last Name:<form:input path="lastName"/>
<br>

Country:
<form:select path="country">
	
	<form:options items="${student.countryOptions}"/>
	
	
</form:select>

<br/><br/>

Favourite Language:
C<form:radiobutton path="favouriteLanguage" value="C"/>
Java<form:radiobutton path="favouriteLanguage" value="Java"/>
Python<form:radiobutton path="favouriteLanguage" value="Python"/>
Js<form:radiobutton path="favouriteLanguage" value="Js"/>

<br/><br/>
Operating Systems:
MS Windows:<form:checkbox path="operatingSystems" value="MS Windows"/>
Linux:<form:checkbox path="operatingSystems" value="Linux"/>
Mac OS:<form:checkbox path="operatingSystems" value="Mac OS"/>


<input type="submit" value="submit"/>
</form:form>


</body>


</html>