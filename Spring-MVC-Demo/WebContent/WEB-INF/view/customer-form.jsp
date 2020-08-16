<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title>Customer Registration Form</title>
<style>
.error{color:red}
</style>
</head>
<body>
<i>Fill out the Form.Asterick(*) means required.</i>
<form:form action="processForm" modelAttribute="customer">
	FirstName:<form:input path="firstName"/>
	<br/><br/>
	
	LastName(*):<form:input path="lastName"/>
	<form:errors path="lastName" cssClass="error"/>

	<br/><br/>
	FreePasses:<form:input path="freePasses"/>
	<form:errors path="freePasses" cssClass="error"/>
	
	<br/><br/>
	PostalCode:<form:input path="postalCode"/>
	<form:errors path="postalCode" cssClass="error"/>
	
	<br/><br/>
	<input type="submit" value="submit"/>

</form:form>


</body>

</html>