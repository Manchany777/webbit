<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
// 데이터
int x = Integer.parseInt(request.getParameter("x"));
int y = Integer.parseInt(request.getParameter("y"));
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 2-2번 -->
<form action="mul.jsp">
<%=x %> + <%=y %> = <%= x+y %> <br><br>

<!-- 2-3번 여기있는 입력상자는 굳이 보일 필요 없으므로 hidden 처리 -->
<input type="hidden" name="x" value="<%=x %>" />
<input type="hidden" name="y" value="<%=y %>" />


<!-- 1번 button은 데이터를 가져가지 않는다. so, 주소에다 데이터를 싣어보내야 한다 -->
<!-- onclick="location.href='mul.jsp?변수=값&변수=값' -->
<input type="button" value="곱구하기-button" onclick="location.href='mul.jsp?x=<%=x %>&y=<%=y %>'">
<!-- 2-1번 submit으로 할시 한 세트인 action 있는 form을 만들어야 함
입력상자에 입력한 값만 데리고 가는데, sum.jsp는 입력상자가 없어서 데이터를 데려갈 수 없다.
then? input.jsp의 입력상자를 끌고 와야함 -->
<input type="submit" value="곱구하기-submit">
</form>
</body>
</html>