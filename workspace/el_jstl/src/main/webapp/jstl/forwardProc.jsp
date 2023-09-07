<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.jstl.PersonDTO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>

<% 
// 자바 역할
List<String> list = new ArrayList<String>(); // 배열에 담음
list.add("호랑이");
list.add("사자");
list.add("기린");
list.add("코끼리");
list.add("타조");
list.add("코알라");
list.add("여우");

// 진짜 자바 파일
PersonDTO aa = new PersonDTO("홍길동", 25);
PersonDTO bb = new PersonDTO("라이언", 23);
PersonDTO cc = new PersonDTO("프로도", 30);

List<PersonDTO> list2 = new ArrayList<PersonDTO>(); // 단순 배열이 아닌 객체에 담음
list2.add(aa);
list2.add(bb);
list2.add(cc);



//객체는 주소를 통해서 넘길수가 없다. so, request 객체를 통해서 넘긴다.
request.setAttribute("list", list);
//request객체 대신 session으로 넘길수도 있다. but, session은 주로 보안에 필요한 정보를 넘기기때문에 이런 단순 정보는 잘 안쓴다.
//session.setAttribute("list", list);
request.setAttribute("list2", list2);


// 페이지 이동
RequestDispatcher dispatcher= request.getRequestDispatcher("forwardResult.jsp"); // 상대번지 (절대번지 쓰면 x)
dispatcher.forward(request, response); // 제어권 넘기기
%>

<jsp:forward page="forwardResult.jsp" />