<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
String login = (String)request.getAttribute("apple");
// setAttribute는 객체이고, getAttribute는 String 즉, 형변환 필요 - (String)
%>

아이디 또는 비밀번호가 틀렸으니 다시 로그인하세요.
<br/><br/>
<input type='button' value='뒤로가기' onclick='history.go(-1)'/>
</body>
</html>