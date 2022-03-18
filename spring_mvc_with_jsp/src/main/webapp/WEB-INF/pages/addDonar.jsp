<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	

<form:form modelAttribute = "command" method="post">
<div>
<label>Mobile Number</label>
<form:input path ="mobileNumber"/>
</div>

<div>
<label>first Name</label>
<form:input path ="firstName"/>
<form:errors path="firstName" style="color:#FF0000"></form:errors>

</div>

<div>
<label>blood Group</label>
<form:select items="${groups}" path="bloodGroup"/>
</div>

<div>
<label>date Last Donated</label>
<form:input type="date" path ="dateLastDonated"/>
<form:errors path = "dateLastDonated" style="color:#FF0000"></form:errors>
</div>

<input type = "submit">

</form:form>
</body>
</html>