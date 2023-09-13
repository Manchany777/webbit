<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
	border-collapse: collapse;
}
th, td {
	padding: 5px;
}
#boardWriteForm div {
	color: red;
	font-size: 8pt;
	font-weight: bold;
}
</style>
</head>
<body>
<c:if test="${ boardDTO != null }">
<!-- <form id="boardWriteForm" method="post" action="boardWrite.jsp"> -->
<form id="boardWriteForm">
<h3 style="text-align: center">글 수정</h3>
<hr style="margin-bottom: 5px; margin-top:5px;">
	<table border="1">
		<tr>
			<th width="70" height="30">제목</th>
			<td>
				<input name="subject" id="subject" type="text" size="50" style="height:20px;" value="${ boardDTO.subject }">
				<div id="subjectDiv"></div>
			</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
				<textarea name="content" id="content" rows="15" cols="50">${ boardDTO.content.replaceAll("\\s+", " ").replaceAll("\\n+", "<br>") }</textarea>
				<div id="contentDiv"></div>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="글수정" id="boardWriteBtn">&nbsp;&nbsp;&nbsp;
				<input type="button" value="다시작성" id="boardResetBtn">
			</td>
		</tr>
	</table>
	<input type="hidden" name="seq" id="seq" value="${boardDTO.seq}">
	<input type="hidden" name="pg" id="pg" value="${pg}">
</form>
</c:if>
<!-- 스크립트도 위에서 아래로 흐르기때문에 순서를 지켜줘야 한다. 더 우선순위가 높은 것을 위에다 둬야 함 -->
<script type="text/javascript" src="http://code.jquery.com/jquery-3.7.0.min.js"></script>
<script type="text/javascript" src="../js/boardModify.js"></script>
<script type="text/javascript">
$(function() {
	$('#boardResetBtn').on('click', function() {
		$('#subject').val("");
		$('#content').val("");
		$('#subject').focus();
	});
});
</script>
</body>
</html>