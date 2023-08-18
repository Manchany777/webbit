 //빈 객체 선언 (자바의 클래스 객체생성) (자바와 달리 변수를 가지고 바로 객체생성이 가능하다)
 var calc = {}
 
 //멤버변수 추가 (자바의 필드)
 calc.x = 0;
 calc.y = 0;
 
 //멤버함수 (자바의 메소드)
 calc.setValue = function(x, y) {
	 this.x = x;
	 this.y = y;
 }
 
 calc.plus = function(){
	 return this.x + this.y;
 }
 
 calc.minus = function(){
	 return this.x - this.y;
 }
 
 calc.result = function(){
	 var value1 = this.plus();
	 var value2 = this.minus();
	 
	 document.write("<p>덧셈 = " + value1 + "</p>"); // p태그 때문에 줄바꿈이 됨
	 document.write("<p>뺼셈 = " + value2 + "</p>");
 } 
 