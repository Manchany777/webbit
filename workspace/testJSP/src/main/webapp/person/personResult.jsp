<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
// 데이터
String name = request.getParameter("name");
int gender = Integer.parseInt(request.getParameter("gender"));
String color = request.getParameter("color");
String[] hobby = request.getParameterValues("hobby");
String[] subject = request.getParameterValues("subject");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<br>
※ 신상명세서<br><br>
● 이름 : <%=name %> <br><br>
● 성별 : 
	<% if(gender == 0) { %>
		<%= "남자" %>
	<% } else if (gender == 1) { %>
		<%= "여자" %>
	<% } %><br><br>
● 색깔 :
	<%switch (color) {
		case "red":
			out.println("빨강");
			break;
		case "green":
			out.println("초록");
			break;
		case "blue":
			out.println("파랑");
			break;
		case "magenta":
			out.println("보라");
			break;
		case "cyan":
			out.println("하늘");
			break;
	}%><br><br>

<%-- 	<%switch (color) { %>
		<%case red: %>
			<%="빨강" %>
			<%break; %>
		<%case green: %>
			<%="초록" %>
			<%break; %>
		<%case blue: %>
			<%="파랑" %>
			<%break; %>
		<%case magenta: %>
			<%="보라" %>
			<%break; %>
		<%case cyan: %>
			<%="하늘" %>
			<%break; %>
	<%} %>  --%>

● 취미 : 
	<%for(String hob : hobby) { %>
		<%=hob %>
	<%} %><br><br>
● 과목 :
	<%for(String sub : subject) { %>
		<%=sub %>
	<%} %><br><br>
</body>
</html>