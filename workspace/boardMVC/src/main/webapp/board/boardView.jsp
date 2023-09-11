<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
<c:if test="${ boardDTO != null }">
<table border="1" cellpadding="5" cellspacing="0" border="1" frame="hsides" rules="rows">
	<tr>
		<th>제목</th>
		<td colspan="5">${ boardDTO.subject }</td>
	</tr>
	<tr>
		<th>글번호 :</th>
		<td>${ boardDTO.getSeq() }</td>
		<th>작성자 :</th>
		<td>${ boardDTO.name }</td>
		<th>조회수 :</th>
		<td>${ boardDTO.hit }</td>

	</tr>
	<tr>
		<th>내용</th>
		<td id="content" colspan="5">${ boardDTO.content.replaceAll("\\s+", " ").replaceAll("\\n+", "<br>") }</td>
	</tr>
</table>
</c:if>
<br/>
<input type="button" value="목록" onclick="javascript:location.href='../board/BoardList.do?pg=${ pg }'" />
<%-- BoardPaging 없이 하려면 그냥 변수 pg만 쓰면 되지만 BoardPaging 클래스를 쓰려면 boardPaging.getCurrentPage()를 호출해야 한다.  --%>
<%-- 여기서는 memberJSP와 달리 BoardViewService에서 boardPaging객체를 생성하지 않았으므로 boardPaging.currentPage는 쓰지 못한다. --%>
</body>
</html>