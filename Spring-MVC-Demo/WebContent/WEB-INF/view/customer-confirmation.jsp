<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Customer Confirmation</title>
</head>
<body>
The customer is confirmed:${customer.firstName} ${customer.lastName}
<br/><br/>
FreePasses:${customer.freePasses}
<br/><br/>
PostalCode:${customer.postalCode}
</body>
</html>