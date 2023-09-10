<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- <% 
String id = null;
id = (String)session.getAttribute("memId"); 
%> --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>*** 메인화면 ***</h1>
<c:if test="${ sessionScope.memId == null }">
	<!-- memId 세션이 없으면 -->
	<h3><a href="">회원가입</a></h3>
	<h3><a href="http://localhost:8080/boardMVC/member/loginForm.do">로그인</a></h3>
</c:if>
<c:if test="${ sessionScope.memId != null}">
	<!-- memId 세션이 있으면 -->
	<h3><a href="http://localhost:8080/boardMVC/member/logout.do">로그아웃</a></h3>
	<h3><a href="./board/boardWriteForm.jsp">글쓰기</a></h3>
</c:if>

<%-- <% if(id == null) {%>
	<!-- memId 세션이 없으면 -->
	<h3><a href="">회원가입</a></h3>
	<h3><a href="http://localhost:8080/boardMVC/member/loginForm.do">로그인</a></h3>
<%}else{ %>
	<!-- memId 세션이 있으면 -->
	<h3><a href="http://localhost:8080/boardMVC/member/logout.do">로그아웃</a></h3>
	<h3><a href="./board/boardWriteForm.jsp">글쓰기</a></h3>
<%} %> --%>

<!-- 카페에서 세션유무(로그인유무) 상관없이 목록은 볼 수 있는 것처럼 -->
<h3><a href="/boardMVC/board/BoardList.do?pg=1">목록</a></h3>
</body>
</html>