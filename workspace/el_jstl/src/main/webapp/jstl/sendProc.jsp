<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>

<% 
// 자바 역할
List<String> list = new ArrayList<String>();
list.add("호랑이");
list.add("사자");
list.add("기린");
list.add("코끼리");
list.add("타조");
list.add("코알라");
list.add("여우");


// *** 페이지 이동
// response.sendRedirect("sendResult.jsp?list=" + list); // x
//주소를 통해서는 객체가 넘어가지 못한다.
//객체가 주소값이 아니라 "클래스@47acd6"라는 단순 문자열로 들어가버리기때문이다. 

// 객체는 주소를 통해서 넘길수가 없다.
request.setAttribute("list", list);
// so, 객체를 주소값으로 실어보내자 한것 request객체에 실어보내자 한것

// 그런데 이렇게 하면 또 다른 문제가 생긴다.
// 바로 데이터 공유가 안된다는 것이다.
// 이 넘기는 값은 sendProc의 것이지 sendResult의 것이 아니다.

// 페이지 이동
response.sendRedirect("sendResult.jsp");
%>