<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head><base>
<meta charset="ISO-8859-1">
<title>Jeevan Blood Bank</title>
<link rel="icon" type="img/png" href="/images/blood image1.jpg">
<style>
ul>li{
margin:10px;
}
h1{
text-align:center;
}
ul{
display:table;
margin: 0 auto;
}
.headImg{
display:block;
margin:auto;
width:40%;
}
.lista{
text-decoration:none;
}
</style>
</head>
<body>

<div>
<img src="/images/logo.jpg" class="headImg">
</div>

<h1> ${heading} </h1>
<ul>
<li><a href="add" class="lista"> Add Donar</a></li>

<li><a href="findAll" class="lista"> Find all donar </a></li>

<li><a href="srchByGroup" class="lista"> Search By Blood Group</a></li>

<li><a href="findName" class="lista"> Find By First Name </a></li>

</ul>
</body>
</html>