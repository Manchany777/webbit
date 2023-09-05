<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.dao.MemberDAO" import="member.bean.MemberDTO" %>
    
<% 
//String name = request.getParameter("name");

String name = null;
String id = null;
String email1 = null;

//쿠키
/*
Cookie[] ar = request.getCookies(); // 특정 쿠키만을 가져오지 못함. 모든 쿠키들을 가져온다.(name, id 둘 중 하나만 가져오지 못하고 둘 다 가져와야 함)
									// 이렇게 배열로 해서 한 번에 꺼내야함
if(ar != null) { // 3초 지나도 null이 아니라면(쿠키가 살아있다면)
	for(int i=0; i < ar.length; i++) {
		String cookieName = ar[i].getName();
		String cookieValue = ar[i].getValue();
		
		System.out.println("쿠키명 = " + cookieName);
		System.out.println("쿠키값 = " + cookieValue);
		System.out.println(); 
		
		if(cookieName.equals("memName")) name = cookieValue;
		if(cookieName.equals("memId")) id = cookieValue;
		
	}//for
}//if
*/

//세션
name = (String)session.getAttribute("memName");
// String    <= 캐스팅 필요 =>        Object
id = (String)session.getAttribute("memId");
email1 = (String)session.getAttribute("memEmail");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<img alt="망상토끼" src="../image/망상토끼.gif" 
	onclick="location.href='../index.jsp'" style="cursor: pointer;" width="50" height="50">
<br/>

<h3><%=name %>님 환영합니다.</h3>
이메일 주소 : <%=email1 %> <br/><br/>
<input type="button" value="로그아웃" onclick="location.href='logout.jsp'">

<br/><br/>
<input type='button' value='회원가입' onclick=location.href='/memberJSP/member/writeForm.jsp' />
</body>
</html>