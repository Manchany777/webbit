$(function(){
	$('#boardWriteBtn').click(function(){
		$('#subjectDiv').empty();
		$('#contentDiv').empty();
		
		if($('#subject').val() == '') {
			$('#subjectDiv').text('제목 입력');
			$('#subject').focus();
		} else if ($('#content').val() == '') {
			$('#contentDiv').text('내용 입력');
			$('#content').focus();
		} else {
			// $('#boardWriteForm').submit();


// 파라미터값을 Javascript에 가져와서 사용하는 2가지 방식
// 1. 변수 선언 후 할당	
	// *name 속성 불러오기
			//var seq = $('input[name="seq"]').val();
            //var pg = $('input[name="pg"]').val();
	// *id 속성 불러오기
            //var seq = $('#seq').val();
            //var pg = $('#pg').val();
/*
location.href를 사용하여 페이지를 이동할 때 URL에 유효하지 않은 문자가 들어가면 문제가 발생할 수 있다.
location.href를 사용하여 페이지를 이동할 때 URL 파라미터를 문자열로 직접 구성하지 않고, 
JavaScript 변수를 사용하여 구성하도록 코드를 작성해야 한다.
*/		

			/*
			// 비동기로 처리
			$.ajax({
				type: 'post', // 여기다 쓰면 form 태그에 method="post" 라고 쓸 필요가 없어진다.
				url: '/boardMVC/board/boardUpdate.do', 
						// 여기다 쓰면 form 태그에 action="boardWrite.jsp" 라고 쓸 필요가 없어진다.
						// 이번엔 'boardWrite.do' 라고 쓰지 않는다.
				data: {
					'seq' : seq,
					'pg' : pg,
					'subject' : $('#subject').val(),
					'content' : $('#content').val()
				},
				success: function(){
					alert("수정하신 글을 반영하였습니다.");
					location.href='/boardMVC/board/boardView.do?seq='+seq+'&pg='+pg;
				},
				error: function(e){
					console.log(e);
				}
// Q. subject와 content는 따로 변수 선언을 하지 않았는데도 문제없이 작동하는데 이유?
// A. subject와 content는 JavaScript에서 이미 HTML 폼 요소의 값을 가져올 수 있는 변수로 선언되어 있습니다. 
// HTML 폼 요소의 값을 가져오는 방법은 JavaScript의 getElementById()나 jQuery의 $() 함수를 사용하여 요소를 선택하고, 
// 그 요소의 값을 가져오는 방식입니다. 따라서 $('#subject').val()와 $('#content').val()와 같이 요소를 선택하고  
// 값을 가져오는 코드가 사용되면, 해당 요소의 값을 가져올 수 있습니다.
// 반면에 seq와 pg 변수는 HTML 폼 요소의 값이 아니라, JavaScript 변수로 직접 지정한 것입니다. 
// 이렇게 직접 JavaScript 변수로 값을 설정하면 해당 변수에 원하는 값을 저장할 수 있습니다. 
// 이 경우에는 HTML 폼 요소와 관련이 없으며, JavaScript 코드 내에서 사용되는 변수로 취급됩니다.
// 따라서 seq와 pg 변수는 JavaScript 코드 내에서 선언하고 초기화한 변수이며, 
// $('#subject').val()와 $('#content').val()는 HTML 폼 요소의 값을 가져오는 방식으로 값을 사용합니다.
			});*/
	
//	2. HTML 폼 요소의 값을 직접 가져와서 사용	
			$.ajax({
				type: 'post',
				url: '/boardMVC/board/boardUpdate.do', 

				data: {
					'seq' : $('#seq').val(),
					'pg' : $('#pg').val(),
					'subject' : $('#subject').val(),
					'content' : $('#content').val()
				},
				success: function(){
					alert("수정하신 글을 반영하였습니다.");
					location.href='/boardMVC/board/boardView.do?seq='+$('#seq').val()+'&pg='+$('#pg').val();
				},
				error: function(e){
					console.log(e);
				}
// $('#seq').val();와 $('#pg').val();와 같은 방식으로 사용
// 참고) 1번처럼 변수를 중간에 선언하여 사용하는 경우는 가독성이나 코드 유지보수 측면에서 특별한 이유가 없는 한 권장되지 않습니다. 
// 2번과 같이 같이 직접 HTML 폼 요소의 값을 사용하는 것이 더 간단하고 명확한 방법입니다.				
			});
		}
	});
});