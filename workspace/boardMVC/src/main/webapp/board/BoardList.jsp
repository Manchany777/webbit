<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
  	    		
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
#currentPaging {
	border: 1px solid #ccc;
	margin: 5px;
	padding: 5px 8px;
	color: red;
	cursor: pointer;
}
#paging {
	margin: 5px;
	padding: 5px 8px;
	color: black;
	cursor: pointer;
}

</style>
</head>
<body>
<c:if test="${ requestScope.list != null }"> <!-- if문 -->
<table border="1" frame="hsides" rules="rows">
	<tr>
		<th width="100">글번호</th>
		<th width="400">제 목</th>
		<th width="150">작성자</th>
		<th width="150">작성일</th>
		<th width="100">조회수</th>
	</tr>
	<c:forEach var="boardDTO" items="${ list }"> 
	<tr>
		<td align="center">	${ boardDTO.seq }</td>
		<td class="boardSubject"> 
			<a class="subjectA" href="#javascript:void(0)" onclick="isLogin('${ boardDTO.id }',${ boardDTO.subject },${ pg })">
				${ boardDTO.subject }
			</a>
		</td>
		<td align="center">${ boardDTO.id }</td>
		<td align="center"><fmt:formatDate value="${ boardDTO.logtime }" pattern="yyyy.MM.dd"/></td>
		<td align="center">${ boardDTO.hit }</td>
	</tr>
	</c:forEach>
</table>

<img alt="망상토끼" src="../image/망상토끼.gif" 
	onclick="location.href='../index.jsp'" style="cursor: pointer;" width="50" height="50">
<br/>

<div style="width: 900px; text-align:center;">${ boardPaging.pagingHTML }</div>
</c:if>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.7.0.min.js"></script>
<script>
function boardPaging(pg) {
	// BoardPaging에서 호출할 함수를 만듦
	location.href = "/boardMVC/board/BoardList.do?pg=" + pg;
}

function isLogin(id, seq, pg){
   if(id == 'null'){ alert("먼저 로그인하세요");
	   location.href = "boardView.do?seq="+seq+ "&pg="+pg;
   } else location.href = "boardView.do?seq="+seq+ "&pg="+pg;
}
</script>
</body>
</html>