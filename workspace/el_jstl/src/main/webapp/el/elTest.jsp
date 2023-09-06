<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1" width="50%">
	<tr>
		<th width="50%">표현식</th>
		<th>값</th>
	</tr>
	
	<tr>
		<td align="center">\${ 25 + 3 }</td>
		<td align="center">${ 25 + 3 }</td>
		<!-- \ : 그대로 출력하는 EL의 문법 -->
	</tr>
	<tr>
		<td align="center">\${ 25/ 3 }</td>
		<td align="center">${ 25 / 3 }</td>
		<%-- 주의)자바는 정수, 실수 따지기때문에 <%=25/3%>  라고 하면 결과값 8 출력 --%>
	</tr>
	<tr>
		<td align="center">\${25 div 3 }</td>
		<td align="center">${25 div 3 }</td>
		<!-- 나누기 (더하기는 없음) -->
	</tr>
	<tr>
		<td align="center">\${ 25 % 3 }</td>
		<td align="center">${ 25 % 3 }</td>
		<!-- 웹이니까 정수 실수 안따짐 -->
	</tr>
	<tr>
		<td align="center">\${ 25 mod 3 }</td>
		<td align="center">${ 25 mod 3}</td>
	</tr>
	<tr>
		<td align="center">\${ 25 < 3 }</td>
		<td align="center">${ 25 < 3}</td>
	</tr>
	<tr>
		<td align="center">\${ 25 ne 3 }</td>
		<td align="center">${ 25 ne 3 }</td>
		<!-- ne : not equal -->
	</tr>
	<tr>
		<td align="center">\${ header['host'] }</td>
		<td align="center">${ header['host'] }</td>
		<!-- 내장객체 header : 현재 서버가 무엇인지-->
	</tr>
	<tr>
		<td align="center">\${ header.host }</td>
		<td align="center">${ header.host }</td>
		<!-- 바로 위와 결과 동일 -->
	</tr>
</table>
</body>
</html>