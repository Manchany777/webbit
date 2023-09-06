<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<fmt:requestEncoding value="UTF-8" /> <%-- request.setCharacterEncoding("UTF-8");  와 같음--%>
<ul>
	<li>이 름 : ${ param['name'] }</li><br><br>
	
	<li>나 이 : ${ param.age }살&emsp;
		<c:if test="${param.age  >= 19}">성인</c:if>
		<c:if test="${param.age  < 19}">청소년</c:if>
	</li><br><br>
	
	<li>색 깔 :
		<c:if test="${ param.color == 'red' }">빨강</c:if>
		<c:if test="${ param.color == 'green' }">초록</c:if>
		<c:if test="${ param.color eq 'blue' }">파랑</c:if>
		<c:if test="${ param.color eq 'magenta' }">보라</c:if>
		<c:if test="${ param.color == 'cyan' }">하늘</c:if>
	</li><br><br>
	
	<li>색 깔 :
		<c:choose>
			<c:when test="${ param.color == 'red' }">빨강</c:when>
			<c:when test="${ param.color == 'green' }">초록</c:when>
			<c:when test="${ param.color eq 'blue' }">파랑</c:when>
			<c:when test="${ param.color eq 'magenta' }">보라</c:when>
			<c:otherwise>하늘</c:otherwise>
		</c:choose>
	</li><br><br>
	
	<li>취 미 : ${ paramValues['hobby'][0] }
			   ${ paramValues['hobby'][1] }
			   ${ paramValues['hobby'][2] }
			   ${ paramValues['hobby'][3] }
			   ${ paramValues['hobby'][4] }
		<br><br>
		취 미 : ${ paramValues.hobby[0] }
			   ${ paramValues.hobby[1] }
			   ${ paramValues.hobby[2] }
			   ${ paramValues.hobby[3] }
			   ${ paramValues.hobby[4] }
	</li><br><br>
	
	<%-- for(String data : paramValues.hobby) --%> 
	<c:forEach var="data" items="${ paramValues.hobby }"> 
		${ data }
	</c:forEach>
</ul>
</body>
</html>

<%-- 
request.getParameter() ===> ${param}  // 값 하나
request.getParameterValues() ===> ${paramValues} // 값 여러개
--%>