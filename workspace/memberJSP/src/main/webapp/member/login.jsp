<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.dao.MemberDAO" import="member.bean.MemberDTO" %>
<%@ page import="java.net.URLEncoder" %>
 <%
// 데이터
String id = request.getParameter("id");
String pwd = request.getParameter("pwd");

MemberDTO memberDTO = new MemberDTO();
memberDTO.setId(id);
memberDTO.setPwd(pwd);

// DB
MemberDAO memberDAO = new MemberDAO();
String name = memberDAO.login(id, pwd);

// 응답
response.setContentType("text/html;charset=UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% if(name == null) {
	response.sendRedirect("loginFail.jsp");
} else {
	response.sendRedirect("loginOk.jsp?name="+ URLEncoder.encode(name, "UTF-8"));

} %>
	<!-- response.sendRedirect("loginOk.jsp?name="+ name); => 이렇게 하면 에러 발생 why?-->
	<!-- name 변수의 한글이 아스키코드값이 아니기때문에 이름이 한글일 경우 깨져서 에러 발생하기때문에 한글처리를 해야 한다. -->
</body>
</html>