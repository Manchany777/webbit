<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
String id = null;
id = (String)session.getAttribute("memId"); 
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>*** 메인화면 ***</h1>

<% if(id == null) {%>
	<!-- memId 세션이 없으면 -->
	<h3><a href="http://localhost:8080/memberMVC/member/writeForm.do">회원가입</a></h3>
	<h3><a href="http://localhost:8080/boardMVC/member/loginForm.do">로그인</a></h3>
<%}else{ %>
	<!-- memId 세션이 있으면 -->
	<h3><a href="http://localhost:8080/boardMVC/member/logout.do">로그아웃</a></h3>
	<h3><a href="./board/boardWriteForm.jsp">글쓰기</a></h3>
<%} %>

<!-- 카페에서 세션유무(로그인유무) 상관없이 목록은 볼 수 있는 것처럼 -->
<h3><a href="./board/BoardList.jsp?pg=1">목록</a></h3>
</body>
</html>