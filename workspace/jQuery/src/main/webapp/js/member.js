$(function(){
	// alert("js파일 연결 체크")
	$('#join').submit(function(){ // submit을 누르면 id가 join인 태그의 action으로 해당 함수를 보낸다는 의미 (현시점에선 submit누르면 네이버로 넘어감)
		$('#juminnoDiv').empty();  // 만약 주민번호를 입력하시오 메시지가 뜬 후 주민번호 값을 입력하면 경고 메시지가 사라져야 한다. 
								   // 그럴때 해당 id내용을 비워주기 위해 쓰는 메소드
		
		var user_id = $('input[name="user_id"]').val();
		if(!user_id){
			alert("아이디를 입력하세요.");
			$('input[name=user_id]').focus(); // focus() - 커서가 들어가서 깜박깜박 거리게 하라는 의미
			return false;
		}
		
		var user_pw = $('input[name="user_pw"]').val();
		if(user_pw == '') {  // 유효성 검사를 하는 여러가지 방식 (위의 아이디처럼 해도 되고, 이렇게 해도 되고)
			alert("비밀번호를 입력하세요.")
			$('input[name="user_pw"]').focus();
			return false;
		}
		
		var juminno = $('input[name="juminno"]').val();
		if(!juminno) {
			// alert("주민번호를 입력하세요.");   // alert창을 쓰는건 bad program
			$('#juminnoDiv').text('주민번호를 입력하세요');  // 요즘 대세는 바로 이렇게 하단에 텍스트로 보여주는 것이다.
			$('input[name="juminno"]').focus();
			return false;
		}
		
		if(!$('input[name="gender"]').is(':checked')) { // is() 메소드 : 만약 선택한 요소($(' '))가 
														// 해당 요소(is(''))나 상태를 가지고 있다면 true, 아니면 false반환
			// input 타입이 radio이면 반드시 checked를 써야함 (그 옆의 콜론(:)은 :hover와 같은 것)   (*맨하단의 추가정보 참고)
			alert("성별을 입력하세요.");
			
			// radio는 배열로 값을 가져옴 (gender[0] = "남자", gender[1] = "여자")
			// 현재문서.form명.
			// 1번째 방식--------------------------------------------------
			// document.form1.gender[1].checked = true; // 현재 여자의 방(1번째 요소)에다 checked 하라는 것
			// 만약 성별 체크를 안하고 회원가입 버튼을 누르면 경고 메시지와 함께 여자쪽에 라디오버튼이 체크되어있게 함
			// 위에건 순수 자바스크립트 방식 <-> 아래건 똑같은 내용이지만 제이쿼리 방식
			// 2번째 방식--------------------------------------------------
			// $('input[name="gender"]:eq(1)').attr('checked', true) // .attr() = attribute, 해당 값에다 속성을 주겠다는 것
			// 3번째 방식--------------------------------------------------
			$('input[name="gender"]:eq(1)').prop('checked', true) // 들어가는 값이 문자열 일때는 attr과 똑같이 먹힌다. 
																  // (but, 명백히 다르다. 정확히 뭐가 다른지는 추후에 다룰 예정)
			return false;
		}
		
		var email = $('input[name="email"]').val();
		if(!email) {
			alert("이메일을 입력하세요")
			$('input[name="email"]').focus();
			return false;
		}
		
		var url = $('input[name="url"]').val();
		if(url == '') {  // http://주소값 -> 이렇게 해야 넘어감
			alert("URL을 입력하세요.")
			$('input[name="url"]').focus();
			return false;
		}
		
		var phone = $('input[name="phone"]').val();
		if(!phone) {
			alert("전화번호를 입력하세요.")
			$('input[name="phone"]').focus();
			return false;
		}
		
		if(!$('input[name="hobby"]').is(':checked')) {  // checkbox도 radio와 방식이 동일함
			alert("취미을 선택하세요.");
			$('input[name="hobby"]:eq(2)').attr('checked', true)
			return false;
		}
					// 그냥 한 칸 띄우면 후손, 자식이면 >으로 표시
		if($('select[name="job"] > option:selected').index() < 1) {  // .index() = 0번째 요소 (select는 아무말 없으면 무조건 첫번째거 선택함)
																	 // index()가 1보다 작으면 {} 구문 실행
			alert("직업을 선택하세요.");
			$('select[name="job"] > option:eq(1)').attr('selected', true)
			return false;
		}
		
		// 입력한 내용을 화면에 출력
		var gender = $('input[name="gender"]:checked').val(); // 선택된 값을 가져오기 (gender라는 이름을 가진 input 태그 중 checked된 값을 가져와라)
		
		//선택한 값들을 가져온다. 배열
		var hobby = $('input[name="hobby"]:checked');
		var hobby_val = '';				// hobby요소를 가져올 빈 배열 생성
		hobby.each(function(){ 			// hobby.each(function(){}); -> 각각의 요소(축구,농구,야구)들을 배열에서 꺼내옴
			hobby_val += $(this).val()  // 이 this는 checked된 hobby변수를 뜻함
										//    -> 배열명은 요소의 값이 아닌 주소를 가지고 있기때문에 $(hobby).val()이라고 쓰면 안된다.
		});  
		
		var job = $('select[name="job"] > option:selected').val();
		
		var result = '<ul>';
		result += '<li> 아이디 : ' + user_id + '</li>'
		result += '<li> 비밀번호 : ' + user_pw + '</li>'
		result += '<li> 주민번호 : ' + juminno + '</li>'
		result += '<li> 성별 : ' + gender + '</li>'
		result += '<li> 이메일 : ' + email + '</li>'
		result += '<li> 홈페이지 : ' + url + '</li>'
		result += '<li> 핸드폰 : ' + phone + '</li>'
		result += '<li> 취미 : ' + hobby_val + '</li>'
		result += '<li> 직업 : ' + job + '</li>'
		result += '</ui>';
		
		$('body').html(result);  // 위의 출력값을 body태그에 붙여서 출력
		
		return false; // join의 action으로 넘어가지 못하겠끔 처리
	});
});

// 태그 옆에 붙여서 CSS 선택자로 활용할 수 있는 메소드는 대표적으로 이런게 있다.
// :hover :eq{1} :gt(0)
// 앞의 두 개는 이전에 언급했고 :gt()는 '>'메소드이다.
// 예를들어 'li:gt(2)' 라면 문서 내의 모든 <li> 요소 중에서 인덱스가 2보다 큰(3번째 이상인) 요소들을 고르는 것이다.
// .gt() 메소드는 0부터 시작하므로, :gt(2)는 3번째 요소부터 선택되는 것을 의미한다.