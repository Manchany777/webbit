<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
// 쿠키 삭제 (특정 쿠키만 못지우기때문에 모든 쿠키를 다 잡아와야함)
/*
Cookie[] ar = request.getCookies();
if(ar != null) {
	for(int i=0; i < ar.length; i++) {
		if(ar[i].getName().equals("memName")) {
			ar[i].setMaxAge(0); // 쿠키 삭제 (시간 0초로)
			response.addCookie(ar[i]); // 클라이언트에 저장(보내기)
		}
		if(ar[i].getValue().equals("memId")) {
			ar[i].setMaxAge(0); // 쿠키 삭제 (시간 0초로)
			response.addCookie(ar[i]); // 클라이언트에 저장(보내기)
		}
		
	}//for
}//if
*/

// 세션
session.removeAttribute("memName"); // 특정 세션만 제거
session.removeAttribute("memId");
session.removeAttribute("memEmail");
			
// session.invalidate(); // 모든 세션 한 번에 무효화 (remove와 invalidate 둘 중에 하나만 쓰면 된다.)
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
<h3>로그아웃</h3>
</body>
</html>