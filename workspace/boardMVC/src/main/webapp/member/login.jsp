<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.dao.MemberDAO" import="member.bean.MemberDTO" %>
<%@ page import="java.net.URLEncoder" %>
<% 
//데이터
String id = request.getParameter("id");
String pwd = request.getParameter("pwd");

//MemberDTO memberDTO = new MemberDTO();
//memberDTO.setId(id);
//memberDTO.setPwd(pwd);

//DB
MemberDAO memberDAO = new MemberDAO();
//String name = memberDAO.login(id, pwd); // 아래도 name대신 전부 memberDTO로 수정
MemberDTO memberDTO = memberDAO.login(id, pwd);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% if(memberDTO == null) {
	response.sendRedirect("loginFail.jsp");
} else {
	//response.sendRedirect("loginOk.jsp?name="+ URLEncoder.encode(name, "UTF-8"));
	
	// 쿠키
	/*
	//Cookie cookie = new Cookie("쿠키명", 값);
	Cookie cookie = new Cookie("memName", name);
	cookie.setMaxAge(30*60); // 초 단위 - 30분
	response.addCookie(cookie); // 현재 쿠키를 클라이언트에 저장
	
	Cookie cookie2 = new Cookie("memId", id);
	cookie2.setMaxAge(30*60); // 초 단위 - 30분
	response.addCookie(cookie2); // 현재 쿠키를 클라이언트에 저장
	*/
	
	// 세션
	
	//HttpSession session = request.getSession(); // 세션 생성 -> but, error why? session은 jsp 내장객체이기때문
	//session.setAttribute("memName", name);	// so, 다른 객체의 메소드를 통해 생성
	session.setAttribute("memName", memberDTO.getName());
	session.setAttribute("memId", id);	
	session.setAttribute("memEmail", memberDTO.getEmail1()+"@"+memberDTO.getEmail2());
	
	// session.setAttribute("memId", memberDTO);	// 12개 정보가 통으로 세션으로 넘어감
	
	response.sendRedirect("loginOk.jsp");
} %>
	<%-- response.sendRedirect("loginOk.jsp?name="+ name); => 이렇게 하면 에러 발생 why?--%>
	<%-- name 변수의 한글이 아스키코드값이 아니기때문에 이름이 한글일 경우 깨져서 에러 발생하기때문에 한글처리를 해야 한다. --%>
</body>
</html>