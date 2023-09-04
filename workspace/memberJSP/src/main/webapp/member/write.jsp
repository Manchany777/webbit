<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="member.bean.MemberDTO"  %>
<%@ page import="member.dao.MemberDAO" %>
<%@ page import="java.util.Date" %>
	<%-- import도 이름순서대로 하는 게 좋다. --%>

<%
request.setCharacterEncoding("UTF-8"); // 한글패치
// 주의) post 방식에선 request영역에 대해서 한글처리를 먼저해야 한글이 깨지지 않는다. (get 방식에선 필요x)

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
	out.println("<h3>회원가입이 완료되었습니다.<br> 로그인 해주세요.</h3>");
	out.println("<br/><br/>");
	out.println("<input type='button' value='로그인 하기' onclick=location.href='/memberJSP/member/loginForm.jsp'; />");
} else {
	out.println("<h3>회원 등록에 실패하였습니다.<br> 다시 시도해주세요.</h3>");
	out.println("<br/><br/>");
	out.println("<input type='button' value='뒤로가기' onclick='history.go(-1)'/>");
}
%>
</body>
</html>