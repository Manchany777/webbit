<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
request.setAttribute("apple", "사과");

//페이지 이동 (RequestDispatcher 인터페이스)
//forwar와 같은 의미이다. 이쪽을 forward보다 더 많이 씀.
RequestDispatcher dispatcher = request.getRequestDispatcher("forwardResult.jsp"); // 상대번지만 써야함 (절대번지는 x)
dispatcher.forward(request, response); // 제어권 넘기기
//아래의 것과 똑같은 효과
%>

<%-- <jsp:forward page="forwardResult.jsp" /> --%>