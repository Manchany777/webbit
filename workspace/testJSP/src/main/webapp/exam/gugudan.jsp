<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%!
int x;
int y;
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<% for(int x=1; x<10; x++) { %>	
	<tr>
	<% for(int y=2; y<=9; y++) { %>
		<td><%= y %> * <%= x %> = <%= y*x %></td>
	<% } //for y %>
	</tr>
<% }// for x %>
</table>
</body>
</html>