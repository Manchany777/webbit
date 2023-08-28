<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<%-- DB 연동 : 만약에 user_id가 "hong", user_password가 "111"이면 로그인 성공 --%>
<% 
boolean result = true;
String message = "홍길동님이 로그인하였습니다.";

String user_id = request.getParameter("user_id");
String user_password = request.getParameter("user_password");

// 원래 여기가 DB로 갔다와야함
if(!user_id.equals("hong")) {
	result = false;
	message = "가입하지 않은 아이디 입니다";
}

if(!user_password.equals("111")) {
	result = false;
	message = "비밀번호가 맞지 않습니다.";
}
// 여기까지
%>

<%-- XML로 보내기 --%>
<?xml version="1.0" encoding="UTF-8"?>
<login>
	<result><%= result %></result>
	<message><%= message %></message>
</login>