<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="get" action="personResult.jsp">
<table border="1" cellpadding="5" cellspacing="0" align="center">
    <tr>
        <th align="center">이름</td>
        <td>
        	<input type="text" name="name" maxlenght="10" placeholder="이름 입력" />
        </td>
    </tr>
    <tr>
        <th align="center">성별</td>
        <td>
        	<div style="border: 2px solid gray;">
			<input type="radio" name="gender" id="gender_m" value="0" checked />
			<label for="gender_m">남자</label>
			<input type="radio" name="gender" id="gender_f" value="1" />
			<label for="gender_f">여자</label>
		</div>
        </td>
    </tr>
    <tr>
        <th align="center">색깔</td>
        <td>
        	<div style="width: 200px;">
        	<select name="color" id="color"> 
				<option value="red" selected="selected">빨강</option>
				<option value="green">초록</option>
				<option value="blue">파랑</option>
				<option value="magenta">보라</option>
				<option value="cyan">하늘</option>
			</select>
			</div>
        </td>
    </tr>
    <tr>
        <th align="center">취미</td>
        <td>
        	<input type="checkbox" name="hobby" id="hobby1" value="독서" />
			<label for="hobby1">독서</label>
			<input type="checkbox" name="hobby" id="hobby2" value="영화" />
			<label for="hobby2">영화</label>
			<input type="checkbox" name="hobby" id="hobby3" value="음악" />
			<label for="hobby3">음악</label>
			<input type="checkbox" name="hobby" id="hobby4" value="게임" />
			<label for="hobby4">게임</label>
			<input type="checkbox" name="hobby" id="hobby5" value="쇼핑" />
			<label for="hobby5">쇼핑</label>
        </td>
    </tr>
    <tr>
        <th align="center">과목</td>
        <td>
        	<select name="subject" id="subject" multiple size="5">
				<option value="java" selected="selected">JAVA</option>
				<option value="servlet">Servlet</option>
				<option value="jsp">JSP</option>
				<option value="spring">SPRING</option>
			</select>
        </td>
    </tr>
    <tr>
	    <td colspan="2" align="center">
	    	<input type="submit" value="SEND" />
	        <input type="reset" value="CANCLE" />
	    </td>
    </tr>
</table>
</form>
</body>
</html>