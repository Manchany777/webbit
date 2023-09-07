<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %> <%-- MemberDAO.jsp파일을 import --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="paramForm" action="checkId.do">
	<h3> ${ param.id }는(은) 이미 사용중입니다. </h3>
	아이디 <input type="text" name="id" id="id" placeholder="아이디 입력" style="width: 150px;" />
	<input type="submit" value="중복체크"> 
</form>
</body>
</html>