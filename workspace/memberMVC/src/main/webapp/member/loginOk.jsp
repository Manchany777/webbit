<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.dao.MemberDAO" import="member.bean.MemberDTO" %>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3><%-- ${ sessionScope.memName } --%> ${ memName }님 환영합니다.</h3> 
<!-- pageScope requestScope 어디에도 담은적 없기때문에 자연스럽게 까지 올라간다. -->
이메일 주소 : ${ sessionScope.memEmail } <br/><br/>
<input type="button" value="로그아웃" onclick="location.href='http://localhost:8080/memberMVC/member/logout.do'">

<br/><br/>
<input type='button' value='글목록 바로가기' onclick=location.href='/memberJSP/board/BoardList.jsp?pg=1' />
</body>
</html>