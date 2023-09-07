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
<!-- 숫자 형식 -->
<fmt:formatNumber type="number" value="123456789" /> <br>
<fmt:formatNumber type="number" value="123456789.88"  /> <br>
<fmt:formatNumber type="number" value="123456789.88" maxFractionDigits="1" /> <br>
<br>

<fmt:formatNumber type="number" value="123456789" pattern="#,###" /> <br>
<fmt:formatNumber type="number" value="123456789.88" pattern=".##" /> <br>
<fmt:formatNumber type="number" value="123456789.88" pattern="#,###.##" /> <br>

<fmt:formatNumber type="number" value="0000.00" pattern="#,###.##" /> <br>
<fmt:formatNumber type="number" value="0000.00" pattern="0,000.00" /> <br> <!-- 강제로 0을 표시 -->
<fmt:formatNumber type="number" value="12.3"  pattern="000.00" /> <br>
<fmt:formatNumber type="number" value="12.3"  pattern="#00.0#" /> <br>
<br>

<!-- 날짜 형식 -->
<!-- 지금 당장은 급해서 java util의 Date를 빌려썼지만 앞으로는 이건 안 쓸 것이다. -->
<c:set var="now" value="<%=new java.util.Date() %>" /> <br>
<c:out value="${now}" /> <br>
date : <fmt:formatDate value="${now}" type="date"/> <br>
time : <fmt:formatDate value="${now}" type="time"/> <br>
both : <fmt:formatDate value="${now}" type="both"/> <br>
<br>

<fmt:formatDate value="${now}" pattern="yyyy-MM-dd hh:mm" type="both"/> <br> <!-- hh : 12시 -->
<fmt:formatDate value="${now}" pattern="yyyy-MM-dd" type="date"/> <br>
<fmt:formatDate value="${now}" pattern="yy-MM-dd E요일 a" type="date"/> <br>
<fmt:formatDate value="${now}" pattern="HH:mm:ss" type="time"/> <br> <!-- HH : 24시 -->



</body>
</html>