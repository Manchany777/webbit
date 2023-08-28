<%-- xml로 자료를 받으려면 toncentType을 text/xml로 바꿔줘야 함. --%>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--  <?xml version="1.0" encoding="UTF-8"?> 앞에 공백이 있으면 안됨. 위의 태그와 <?xml version="1.0" encoding="UTF-8"?> 태그 사이에 있는걸 다 공백으로 인식  --%> 
<%--  so, 아래 태그를 이용해서 공백제거 처리가 필요 --%>
<%@ page trimDirectiveWhitespaces="true" %> <%-- xml태그 시작전에 공백 제거 --%>    
 
 <% 
 // DB연동
 // 만약에 user_id가 "hong이면  이미 DB에  저장된 아이디로 취급(아직 db연동 단계가 아니기에) (true) - 사용x
 // 																	   (false)  - 사용 가능
 	String user_id = request.getParameter("user_id"); // 요청이 왔을 때 파라미터 값이 'user_id'인 걸 꺼내와라
 													  // {'user_id': user_id}에서의 'user_id'
 	
	boolean result = false;
	if(user_id.equals("hong")) result =true;  // 자바는 문자열 비교 바로 못하기때문에 equals를 써야 한다.
 %>
 
 <%-- XML로 보내기 --%>
 <?xml version="1.0" encoding="UTF-8"?>
 <checkID>
 	<result><%= result %></result>
 </checkID>

