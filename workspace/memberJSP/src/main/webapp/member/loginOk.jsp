<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.dao.MemberDAO" import="member.bean.MemberDTO" %>
    
<% 
String name = request.getParameter("name");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<%=name %>님 환영합니다.
<br/><br/>
<input type='button' value='목록' onclick=location.href='/memberJSP/member/writeForm.jsp'; />
</body>
</html>