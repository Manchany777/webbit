<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<%
	boolean result = true;
	String message = "덧글 등록 완료";
	
	String num = request.getParameter("num");
	String datetime = request.getParameter("datetime");
	String writer = request.getParameter("writer");
	String content = request.getParameter("content");
%>

 <%-- XML로 보내기 --%>
 <?xml version="1.0" encoding="UTF-8"?>
 <comment>
 	<result><%= result %></result>
 	<message><%= message %></message>
 	<item>
 		<num><%= num %></num>
 		<writer><%= writer %></writer>
 		<content><%= content %></content>
 		<datetime><%= datetime %></datetime>
 	</item>
 </commetn>