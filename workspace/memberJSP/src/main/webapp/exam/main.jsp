<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>*** include directive ***</h3>
<%@ include file="today.jsp" %> <!-- 디렉티브 include -->

<h3>*** include JSP tag ***</h3>
<jsp:include page="image.jsp"/> <!-- jsp include 태그 -->
<!-- 아래쪽을 더 선호 -->

<%
String name = "홍길동"; //- 변수명 중복으로 error
%>

<%-- <h3>today.jsp name = <%= name %></h3> --%>

<h3>main.jsp name = <%= name %></h3>

<h3>*** 3초뒤에 네이버로 이동 ***</h3>
<% response.setHeader("Refresh", "3;url=https://www.naver.com"); %>  
<!-- 3초뒤에 네이버로 이동 -->


</body>
</html>