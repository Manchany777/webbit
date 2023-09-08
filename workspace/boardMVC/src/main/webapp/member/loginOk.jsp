<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

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

<h3>${ name }님 환영합니다.</h3>
이메일 주소 : ${ email1 } <br/><br/>
<input type="button" value="로그아웃" onclick="location.href='logout.do'">

<br/><br/>
<input type='button' value='글목록 바로가기' onclick=location.href='/boardMVC/board/BoardList.jsp?pg=1' />
</body>
</html>