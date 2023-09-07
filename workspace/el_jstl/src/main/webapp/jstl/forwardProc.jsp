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


//객체는 주소를 통해서 넘길수가 없다.
request.setAttribute("list", list);

// 페이지 이동
RequestDispatcher dispatcher= request.getRequestDispatcher("forwardResult.jsp"); // 상대번지 (절대번지 쓰면 x)
dispatcher.forward(request, response); // 제어권 넘기기
%>

<jsp:forward page="forwardResult.jsp" />