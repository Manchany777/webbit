<!-- 환경 설정 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- 명령 처리  -->    
<% 
	// 데이터(get 방식은 전부 문자로 받음)
	String keyword = request.getParameter("keyword"); // ("변수명")
%>    

<!-- 결과 출력 -->
<!-- <%--= keyword --%>를 가져가는게 아니라 keyword에 대한 결과물을 가져가는 것 -->
결과는 <%= keyword %>



<!-- ajax에서 jsp 데이터를 받을 때 디렉티브 이하를 통으로 옮겨가기 때문에 아래 내용 삭제해도 무관  -->
<!--
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>
  -->