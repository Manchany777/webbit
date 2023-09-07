<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
결과 = ${ requestScope.list } <br> <!-- 결과 = [호랑이, 사자, 기린, 코끼리, 타조, 코알라, 여우] -->

세번째 항목 = ${ requestScope.list[2] } <br><br> <!-- 세번째 항목 = 기린 -->

결과 list2 = ${ requestScope.list2 } <br> <!-- 결과 list2 = [com.jstl.PersonDTO@4f851d75, com.jstl.PersonDTO@6f208c8e, com.jstl.PersonDTO@76160d24] -->
이름 = ${ requestScope.list2[0].getName() } &emsp; 나이 = ${ requestScope.list2[0].getAge() } <br> <!-- 이름 = 홍길동   이름 = 25 -->
이름 = ${ requestScope.list2[1].getName() } &emsp; 나이 = ${ requestScope.list2[1].getAge() } <br> <!-- 이름 = 라이언   이름 = 23 -->
이름 = ${ requestScope.list2[2].getName() } &emsp; 나이 = ${ requestScope.list2[2].getAge() } <br> <!-- 이름 = 프로도   이름 = 30 -->
<br>

<h3>메소드명을 변수명처럼 사용 (단순출력)</h3> 
<!-- 주의 : 여기서의 name은 클래스 필드가 아닌 getName()이라는 메소드명을 바꾼 것 뿐이다. 착각주의 
증거로 PersonDTO.java의 @Getter를 삭제하면 이 코드는 에러가 뜰 것이다.
-->
이름 = ${ requestScope.list2[0].name } &emsp; 나이 = ${ requestScope.list2[0].age } <br>
이름 = ${ requestScope.list2[1].name } &emsp; 나이 = ${ requestScope.list2[1].age } <br> 
이름 = ${ requestScope.list2[2].name } &emsp; 나이 = ${ requestScope.list2[2].age } <br> 

<h3>forEach문</h3> 
<!-- 웹에서는 자바처럼 자료형이 없기때문에 확장형for문처럼 자료형을 적을 수가 없다. so, var에 변수명을 적어야 한다. -->
<c:forEach var="personDTO" items="${ list2 }"> <%-- for(PersonDTO personDTO : list2) { } --%>
	이름 = ${ personDTO.name } &emsp; 나이 = ${ personDTO.age } <br>
</c:forEach>
<h3>list2를 pageScope → requestScope → sessionScope → applicationScope 순서로 찾는다.</h3>
<!-- 따라서 items="${ requestScope.list2 }에서 requestScope를 생략해도 알아서 거슬러 올라가며 찾아준다. -->
</body>
</html>