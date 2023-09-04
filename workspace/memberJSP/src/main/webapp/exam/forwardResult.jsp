<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
String apple = (String)request.getAttribute("apple");
// setAttribute는 객체이고, getAttribute는 String 즉, 형변환 필요 - (String)


%>

결과 = <%=apple %>