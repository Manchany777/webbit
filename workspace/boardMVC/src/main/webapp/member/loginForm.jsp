<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table {
	border: 1px solid gray;
}
h3 {
	text-align:center;
}
#loginForm div {
	font-size: 8pt;
	font-weight: bold;
	color: red;
}
</style>
</head>
<body>
<form id="loginForm" method="post" action="login.do">
<h3>로그인 페이지</h3>
<table border="1" cellpadding="5" cellspacing="0" align="center" >
    <tr>
        <th align="center"">아이디</td>
        <td>
        	<input type="text" name="id" id="id" maxlength="10" placeholder="아이디 입력" size="9" />
        	<div id="idDiv"></div>
        </td>
    </tr>
    <tr>
        <th align="center">비밀번호</td>
        <td>
        	<input type="password" name="pwd" id="pwd" maxlength="10" size="15" />
        	<div id="pwdDiv"></div>
        </td>
    </tr>
    <tr>
	    <th colspan="2">
	   		<button type="submit" id="loginBtn">로그인</button>
	    </th>
    </tr>
</table>
</form>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.7.0.min.js"></script>
<script type="text/javascript">
// button 태그로 type submit하면, 버튼을 클릭했을 때 폼이 제출되기 때문에 유효성 검사가 필요한 경우 폼 제출 전에 JavaScript에서 이를 처리해야 한다.
$('#loginForm').submit(function(event) {
    // 초기화
    $('#idDiv').empty();
    $('#pwdDiv').empty();
    
    if ($('#id').val() == '') {
        $('#idDiv').text('아이디를 입력하세요.');
        $('#id').focus();
        event.preventDefault(); // 제출 방지
    } else if ($('#pwd').val() == '') {
        $('#pwdDiv').text('비밀번호를 입력하세요.');
        $('#pwd').focus();
        event.preventDefault(); // 제출 방지
    }
});

// 쌤님 버전
/*
$(function(){
	$('#loginForm').click(function(event) {
	    $('#idDiv').empty();
	    $('#pwdDiv').empty();
	    
	    if ($('#id').val() == '') {
	        $('#idDiv').text('아이디를 입력하세요.');
	    } else if ($('#pwd').val() == '') {
	        $('#pwdDiv').text('비밀번호를 입력하세요.');
	        $('#pwd').focus();
	    } else {
	    	$.ajax({});
	    }
	});
});*/

// 이 코드에서는 $('#loginForm').submit() 이벤트를 사용하여 폼 제출 시 유효성 검사를 수행하고, 
// 필요한 경우 event.preventDefault();를 호출하여 폼의 제출을 방지할 수 있게 만들었다. 
// 이렇게하면 type="submit" 버튼을 사용하여도 폼의 제출을 막을 수 있으며, 필요한 경우 JavaScript를 사용하여 유효성 검사를 수행할 수 있다.
</script>

</body>
</html>