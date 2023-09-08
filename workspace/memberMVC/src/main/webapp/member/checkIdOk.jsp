<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3> ${ param.id }는(은) 사용 가능합니다. </h3>
<input type="button" value="사용하기" onclick="checkIdClose('${ param.id }')"> <!-- 여기는 절대 submit 쓰면 안된다. 위의 checkId.jsp로 넘어가버림  -->
<br>

<script type="text/javascript">
function checkIdClose(id){
	// 오프너(opener) - 팝업 창(자식창)에서 원래 있던 창(부모창)에 접근 하거나 서로 상호작용을 할 수 있는 객체
	opener.document.getElementById("id").value = '${param.id}'; // 중복체크에서 사용하기로 한 아이디를 찍어주기
	opener.document.getElementById("useCheckedId").value = '${param.id}';
	window.close(); // 중복체크 창 닫기
	opener.document.getElementById("pwd").focus(); // 중복체크 완료 후 비밀번호 창으로 포커스 맞추기
}
</script>
</body>
</html>