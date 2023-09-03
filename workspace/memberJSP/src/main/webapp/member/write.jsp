<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.dao.MemberDAO" import="member.dto.MemberDTO" import="java.util.Date" %>

<%
request.setCharacterEncoding("UTF-8"); // 한글패치

// 데이터
String name = request.getParameter("name");
String id = request.getParameter("id");
String pwd = request.getParameter("pwd");
String gender = request.getParameter("gender");
String email1 = request.getParameter("email1");
String email2 = request.getParameter("email2");
String tel1 = request.getParameter("tel1");
String tel2 = request.getParameter("tel2");
String tel3 = request.getParameter("tel3");
String zipcode = request.getParameter("zipcode");
String addr1 = request.getParameter("addr1");
String addr2 = request.getParameter("addr2");

MemberDTO memberDTO = new MemberDTO();
memberDTO.setName(name);
memberDTO.setId(id);
memberDTO.setPwd(pwd);
memberDTO.setGender(gender);
memberDTO.setEmail1(email1);
memberDTO.setEmail2(email2);
memberDTO.setTel1(tel1);
memberDTO.setTel2(tel2);
memberDTO.setTel3(tel3);
memberDTO.setZipcode(zipcode);
memberDTO.setAddr1(addr1);
memberDTO.setAddr2(addr2);

// DB
MemberDAO memberDAO = new MemberDAO();
int su = memberDAO.regist(memberDTO);

//응답

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
if(su == 1) {
	out.println("<h3>등록 완료</h3>");
	out.println("<br/><br/>");
	out.println("<input type='button' value='로그인 하기' onclick=location.href='/memberJSP/member/loginForm.jsp'; />");
} else {
	out.println("<h3>등록 실패</h3>");
	out.println("<br/><br/>");
	out.println("<input type='button' value='뒤로가기' onclick='history.go(-1)'/>");
}
%>
</body>
</html>