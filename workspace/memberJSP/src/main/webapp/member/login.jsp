<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.dao.MemberDAO" import="member.bean.MemberDTO" %>
 
 <%
// 데이터
String id = request.getParameter("id");
String pwd = request.getParameter("pwd");

MemberDTO memberDTO = new MemberDTO();
memberDTO.setId(id);
memberDTO.setPwd(pwd);

// DB
MemberDAO memberDAO = new MemberDAO();
boolean checkLogin =  memberDAO.isExistMember(id, pwd);

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
<% if(checkLogin) { %>
	<%=id %>님 환영합니다.
	<br/><br/>
	<input type='button' value='목록' onclick=location.href='/memberJSP/member/writeForm.jsp'; />
<% } else { %>
	아이디 또는 비밀번호가 틀렸으니 다시 로그인하세요.
	<br/><br/>
	<input type='button' value='뒤로가기' onclick='history.go(-1)'/>
<% } %>

</body>
</html>