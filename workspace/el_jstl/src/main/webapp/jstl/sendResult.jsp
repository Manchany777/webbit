<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
결과 = ${ requestScope.list }
</body>
</html>
<!-- 자바로 처리하면 null값이 오지만 web으로 오면 빈칸이 온다. -->
<!-- request.getAttribute(); == ${ requestScope }-->