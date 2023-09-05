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

// 데이터 (for 페이징) - 파라미터를 통해서(=목록에서) 접근해야 하기때문에 이 파일을 바로 실행하면 에러 발생
int pg = Integer.parseInt(request.getParameter("pg"));
// 1페이지당 5개씩
int endNum = pg*5;
int startNum = endNum-4;
		
		
//DB객체 생성
BoardDAO boardDAO = new BoardDAO();
List<BoardDTO> list = boardDAO.getBoardList(startNum, endNum);
%>

  	    		
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
a {
	color: black;
	text-decoration: none; 
	outline: none
}
a:hover, a:active {
	color: green;
	text-decoration: underline;
}
table {
	border-collapse: collapse;
}
th, td {
	padding: 5px;
}
</style>
</head>
<body>
<table border="1" frame="hsides" rules="rows">
	<tr>
		<th width="100">글번호</th>
		<th width="400">제 목</th>
		<th width="150">작성자</th>
		<th width="150">작성일</th>
		<th width="100">조회수</th>
	</tr>
	<% for(BoardDTO boardDTO : list){ %>
	<tr>
		<td align="center"><%= boardDTO.getSeq() %></td>
		<td class="boardSubject">
			<a href="#" onclick="detailRead('<%= boardDTO.getSeq() %>'); return false;">
				<%= boardDTO.getSubject() %>
			</a>
		</td>
		<td align="center"><%= boardDTO.getName() %></td>
		<td align="center"><%= new SimpleDateFormat("yyyy.MM.dd").format(boardDTO.getLogtime()) %></td>
		<td align="center"><%= boardDTO.getHit() %></td>
	</tr>
	<%}%>
</table>

<img alt="망상토끼" src="../image/망상토끼.gif" 
	onclick="location.href='../index.jsp'" style="cursor: pointer;" width="50" height="50">
<br/>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.7.0.min.js"></script>
<script type="text/javascript">
function detailRead(seq){
	var id = sessionStorage.getItem("memId"); // 세션 값 가져오기
	console.log(id);
	if (id == null) {
		alert("먼저 로그인하세요");
	} else {
		window.location.href = "http://localhost:8080/memberJSP/member/boardView.jsp?seq=" + boardDTO.getSeq();
	}
}
</script>
</body>
</html>