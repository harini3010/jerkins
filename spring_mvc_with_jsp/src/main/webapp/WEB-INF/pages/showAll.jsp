<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2 style="text-align: center">List Of Blood Donors</h2>

<table><tr>
<th>Mobile Number</th>
<th>first Name</th>
<th>Blood Group</th>
<th>Date Last Donated</th>

</tr>
<c:forEach items="${list}" var="eachItem">
<tr>
<td>${eachItem.mobileNumber}</td>
<td>${eachItem.firstName}</td>
<td>${eachItem.bloodGroup}</td>
<td>${eachItem.dateLastDonated}</td>

</tr>
</c:forEach>
</table>
</body>
</html>