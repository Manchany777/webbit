<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
// 데이터
String name = request.getParameter("name");
String gender = request.getParameter("gender").equals("0") ? "남자":"여자";;
// 굳이 int로 형변환 할 필요없이 이렇게 바로 남자, 여자를 오게 만들어도 된다.
String color = request.getParameter("color");
String[] hobby = request.getParameterValues("hobby");
String[] subject = request.getParameterValues("subject");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
ul {
	color: <%=color %>; 
	/* 내가 선택한 색상으로 글자가 바뀌도록 설정 */
}
</style>
</head>
<body>
<br>
※ 신상명세서<br><br>
● 이름 : <%=name %> <br><br>
● 성별 : <%=gender %><br><br>
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
	<%for(int i=0; i<hobby.length; i++) { %>
		<%=hobby[i] %>
	<%} %><br><br>
● 과목 :
	<%for(String sub : subject) { %>
		<%=sub %>
	<%} %><br><br>
</body>
</html>