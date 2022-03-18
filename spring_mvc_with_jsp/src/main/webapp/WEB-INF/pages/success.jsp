<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>First Name</th>
			<th>Blood Group</th>
			<th>Mobile Number</th>
			<th>Date Last Donated</th>
		</tr>
		<tr>
			<td>${command.firstName}</td>
			<td>${command.bloodGroup}</td>
			<td>${command.mobileNumber}</td>
			<td>${command.dateLastDonated}</td>
		</tr>
	</table>
	<p>${command}</p>
</body>
</html>