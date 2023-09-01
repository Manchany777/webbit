<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.dao.MemberDAO" %> <%-- MemberDAO.jsp파일을 import --%>
    
<%
// 데이터
String id = request.getParameter("id");

// DB
MemberDAO memberDAO = new MemberDAO();
boolean exist =  memberDAO.isExistId(id); // isExistId - 메소드 이름

// 응답
response.setContentType("text/html;charset=UTF-8");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="checkId.jsp">
<% if(exist) { %>
	<h3><%=id %>는(은) 이미 사용중입니다. </h3>
	아이디 <input type="text" name="id" id="id" placeholder="아이디 입력" style="width: 150px;" />
	<input type="submit" value="중복체크"> <!-- 재귀 체크(내가 나스스로를 체크) -->
<% } else { %>
	<h3><%=id %>는(은) 사용 가능합니다. </h3>
	<input type="button" value="사용하기" onclick="checkIdClose('<%=id %>')"> <!-- 여기는 절대 submit 쓰면 안된다. 위의 checkId.jsp로 넘어가버림  -->
<%} %><br>
</form>

<script type="text/javascript">
function checkIdClose(id){
	opner.document.getElementById("id").value = id; // 중복체크에서 사용하기로 한 아이디를 찍어주기
	window.close(); // 중복체크 창 닫기
	opner.document.getElementById("pwd").focus(); // 중복체크 완료 후 비밀번호 창으로 포커스 맞추기
}
</script>
</body>
</html>