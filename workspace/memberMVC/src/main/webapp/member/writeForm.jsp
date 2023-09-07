<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table {
	border-collapse: collapse;
}
h3 { text-align: center; }
#memberWriteForm div {
	font-size: 8pt;
	font-weight: bold;
	color: red;
}
</style>
</head>
<body>
<form id="memberWriteForm" method="post" action="">
<h3>회원가입</h3>
<table border="1" cellpadding="5" cellspacing="0" align="center" style="border: 2px solid gray;">
    <tr>
        <th align="center" style="border: 2px solid gray;">이름</td>
        <td style="border: 2px solid gray;">
        	<input type="text" name="name" id="name" maxlength="10" placeholder="이름 입력" />
        	<div id="nameDiv"></div>
        </td>
    </tr>
    <tr>
        <th align="center" style="border: 2px solid gray;">아이디</td>
        <td style="border: 2px solid gray;">
        	<input type="text" name="id" id="id" maxlength="10" placeholder="아이디 입력" style="width: 250px;" />
        	<input type="button" value="중복체크" onclick="checkID()">
        	<input type="hidden" name="useCheckedId" value="idUnchecked" />
        	<div id="idDiv"></div>
        </td>
    </tr>
    <tr>
        <th align="center" style="border: 2px solid gray;">비밀번호</td>
        <td style="border: 2px solid gray;">
        	<input type="password" name="pwd" id="pwd" maxlength="10" style="width: 300px;" />
        	<div id="pwdDiv"></div>
        </td>
    </tr>
    <tr>
        <th align="center" style="border: 2px solid gray;">재확인</td>
        <td style="border: 2px solid gray;">
        	<input type="password" id="repwd" maxlength="10"  style="width: 300px;" />
        </td>
    </tr>
    <tr>
        <th align="center" style="border: 2px solid gray;">성별</td>
        <td style="border: 2px solid gray;">
			<input type="radio" name="gender" id="gender_m" value="0" checked />
			<label for="gender_m">남자</label>
			<input type="radio" name="gender" id="gender_f" value="1" />
			<label for="gender_f">여자</label>
        </td>
    </tr>
    <tr>
        <th align="center" style="border: 2px solid gray;">이메일</td>
        <td style="border: 2px solid gray;">
        	<input type="email" name="email1" id="email1" maxlength="10" style="width: 100px;" 
        		pattern="^[a-zA-Z0-9]" />
        	 @ 
        	<input type="email" name="email2" id="email2" maxlength="10" style="width: 100px;" 
        		pattern="[@][a-zA-Z0-9]+[.]+[a-zA-Z]+[.]*[a-zA-Z]*"/>
        	<select name="email3" id="emailSelect" style="width: 100px;"> 
       			<option value="">직접입력</option>
				<option value="naver.com">naver.com</option>
				<option value="google.com">google.com</option>
				<option value="nate.com">nate.com</option>
			</select>
        </td>
    </tr>
    <tr>
        <th align="center" style="border: 2px solid gray;">휴대폰</td>
        <td style="border: 2px solid gray;">
        	<select name="tel1" id="phone_1" style="width: 60px;"> 
        		<optgroup label="선택">
					<option value="010" selected="selected">010</option>
					<option value="011">011</option>
					<option value="019">019</option>
				</optgroup>
			</select>
			 -
			<input type="tel" name="tel2" id="phone_2" maxlenght="10" style="width: 60px;"/>
			 - 
			<input type="tel" name="tel3" id="phone_3" maxlenght="10" style="width: 60px;" />
        </td>
    </tr>
    <tr>
        <th align="center" style="border: 2px solid gray;">주소</td>
        <td style="border: 2px solid gray;">
        	<input type="text" name="zipcode" id="zipcode" maxlenght="10" readonly/>
        	<input type="button" value="우편번호검색" id="checkPostBtn" /><br>
        	<input type="text" name="addr1" id="addr1" maxlenght="10" placeholder="주소" style="width: 97%;" /><br>
        	<input type="text" name="addr2" id="addr2" maxlenght="10" placeholder="상세주소" style="width: 97%;" />
        </td>
    </tr>
    <tr>
	    <th colspan="2"> <!-- th로 하면 자동으로 가운데 정렬이 되기때문에 굳이  align="center" 안써도 된다. -->
	   		<button type="button" id="writeBtn">회원가입</button>
	    	<!-- <input type="submit" value="회원가입" /> --> <!-- 어떤 방식으로 하든 상관x -->
	        <input type="reset" value="다시작성" />
	    </th>
    </tr>
</table>
</form>

<script type="text/javascript">
function checkID(){
	// 해당 태그의 속성값을 가져오는 두 가지 방식이 있다.
	//var id = document.폼이름.name속성명.value; // name을 가져오는 방식
	//var id = document.getElementById("id명").value; // id를 가져오는 방식
	
	var id = document.getElementById("id").value;
	
	if(id == "")
		document.getElementById("idDiv").innerText = "먼저 아이디를 입력하세요.";
	else
		window.open("checkId.jsp?id="+id+"&useCheckedId=idChecked", "checkId", "width=300 height=150 top=200 left=400 scrollbars=no toolbar=no menubar=no status=no location=no");  // 두번째 인자값 - 새창 무한증식 방지(이름자체는 아무거나 넣어도 무방)

};    			 // "checkId.jsp?변수=값"   // 내가 적은 아이디가 중복체크 페이지로 값을 넘길 수 있도록
</script>


<!-- 스크립트도 위에서 아래로 흐르기때문에 순서를 지켜줘야 한다. 더 우선순위가 높은 것을 위에다 둬야 함 -->
<!-- 유효성 검사 및 이메일 자동입력 -->
<script type="text/javascript" src="http://code.jquery.com/jquery-3.7.0.min.js"></script>
<script src="http://localhost:8080/memberJSP/js/write.js"></script>

<!-- 우편번호 검색 -->
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="http://localhost:8080/memberJSP/js/post.js"></script>
</body>
</html>