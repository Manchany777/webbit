<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<%
	boolean result = true;
	String message = "덧글 삭제 완료";
%>

<%-- XML로 보내기 --%>
<?xml version="1.0" encoding="UTF-8"?>
<login>
	<result><%= result %></result>
	<message><%= message %></message>
</login>