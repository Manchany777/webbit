<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.bean.BoardDTO"  %>
<%@ page import="board.dao.BoardDAO" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
    
<%
request.setCharacterEncoding("UTF-8"); // 한글패치
//주의) post 방식에선 request영역에 대해서 한글처리를 먼저해야 한글이 깨지지 않는다. (get 방식에선 필요x)

//세션에 담기
String id = null;
String name = null;
String email = null;

id = (String)session.getAttribute("memId");
name = (String)session.getAttribute("memName");
email = (String)session.getAttribute("memEmail");

// 데이터
int seq = Integer.parseInt(request.getParameter("seq"));

		
//DB객체 생성
BoardDAO boardDAO = new BoardDAO();
BoardDTO boardDTO = boardDAO.boardDetail(seq);

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table {
	border-collapse: collapse;
}
th	{
	width: 120px;
	height: 50px;
}
td {
	width: 200px;
}
</style>
</head>
<body>
<table border="1" cellpadding="5" cellspacing="0" border="1" frame="hsides" rules="rows">
	<tr>
		<th>제목</th>
		<td colspan="5"><%= boardDTO.getSubject() %></td>
	</tr>
	<tr>
		<th>글번호 :</th>
		<td><%= boardDTO.getSeq() %></td>
		<th>작성자 :</th>
		<td><%= boardDTO.getName() %></td>
		<th>조회수 :</th>
		<td><%= boardDTO.getHit() %></td>

	</tr>
	<tr>
		<th>내용</th>
		<td colspan="5" height="400px"><%= boardDTO.getContent() %></td>
	
	</tr>
</table>
<br/>
<input type="button" value="목록" onclick="javascript:location.href='../index.jsp'" />
</body>
</html>