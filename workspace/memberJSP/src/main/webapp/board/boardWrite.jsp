<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="board.bean.BoardDTO"  %>
<%@ page import="board.dao.BoardDAO" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
	<%-- import도 이름순서대로 하는 게 좋다. --%>

<%
request.setCharacterEncoding("UTF-8"); // 한글패치
// 주의) post 방식에선 request영역에 대해서 한글처리를 먼저해야 한글이 깨지지 않는다. (get 방식에선 필요x)

// 데이터
String subject = request.getParameter("subject");
String content = request.getParameter("content");

// 응답

// 세션에 담기
String id = null;
String name = null;
String email = null;

id = (String)session.getAttribute("memId");
name = (String)session.getAttribute("memName");
email = (String)session.getAttribute("memEmail");

// 세션에 담은 데이터를 한 번에 실어가기 위해
Map<String, String> map = new HashMap<String, String>();
map.put("id", id);  // 오른쪽에 있는 id값을 왼쪽의 "id"란 이름으로 부여한다.
map.put("name", name);
map.put("email", email);
map.put("subject", subject);
map.put("content", content);

//DB객체 생성
BoardDAO boardDAO = new BoardDAO();
boardDAO.boardWrite(map);  // DB에 Map들고 insert(저장)
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- <h3>작성하신 글을 저장하였습니다.</h3> -->

<script type="text/javascript">
/*
window.onload=function(){
	alert("작성하신 글을 저장하였습니다.");
	// 목록
}
*/
// boardWrite.js에서 alert("작성하신 글을 저장하였습니다.");를 대신 찍을거라 <html>안의 내용이 필요가 없어진다.
</script>
</body>
</html>