<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.bean.BoardDTO"  %>
<%@ page import="board.bean.BoardPaging" %>
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
int pg = Integer.parseInt(request.getParameter("pg"));
		
//DB객체 생성
BoardDAO boardDAO = new BoardDAO();
BoardDTO boardDTO = boardDAO.boardDetail(seq); // 글 내용은 한사람 거니까 BoardDTO 담아오면 된다.

// 페이징 처리 
BoardPaging boardPaging = new BoardPaging(); // 하나씩 꺼내오기
boardPaging.setCurrentPage(pg);
// 여기서는 BoardPaging의 currentPage변수에만 값을 담아오는 것이기때문에 makePagingHTML(); 메소드는 쓰이지 않는다.
// makePagingHTML();메소드는 페이징처리를 위해 구현한 메소드이기때문에 페이지값만 담아올 때에는 쓸 이유가 없는 것이다. 따라서
// boardPaging.makePagingHTML(); 메소드는 여기서 실행시키면 안 된다. (에러뜸)
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
th, td {

}
th	{
	width: 80px;
	height: 30px;
	background-color: #DACCCC;
}
td {
	width: 200px;
    padding: 5px 10px;
}
td#content {
	height: 400px;
	padding: 15px;
	border-left: none;
	vertical-align: top;
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
		<td id="content" colspan="5"><%= boardDTO.getContent().replaceAll("\\s+", " ").replaceAll("\\n+", "<br>") %></td>
	</tr>
</table>
<br/>
<input type="button" value="목록" onclick="javascript:location.href='../board/BoardList.jsp?pg=<%= boardPaging.getCurrentPage() %>'" />
</body>
</html>