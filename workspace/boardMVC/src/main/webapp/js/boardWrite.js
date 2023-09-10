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
			
			// 비동기로 처리
			$.ajax({
				type: 'post', // 여기다 쓰면 form 태그에 method="post" 라고 쓸 필요가 없어진다.
				url: '/boardMVC/board/boardWrite.do', 
						// 여기다 쓰면 form 태그에 action="boardWrite.jsp" 라고 쓸 필요가 없어진다.
						// 이번엔 'boardWrite.do' 라고 쓰지 않는다.
				data: {
					'subject' : $('#subject').val(),
					'content' : $('#content').val()
				},
				success: function(){
					alert("작성하신 글을 저장하였습니다.");
					location.href='/boardMVC/board/BoardList.do?pg=1';
				},
				error: function(e){
					console.log(e);
				}
			});
		}
	});
});