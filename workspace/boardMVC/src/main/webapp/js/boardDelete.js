$(function(){
	$('#boardDeleteBtn').click(function(){
		var confirmed = confirm("글을 삭제하시겠습니까?\n삭제를 취소하시려면 '취소' 버튼을 눌러주세요.");
		
		if(confirmed) {
			$.ajax({
			type: 'post',
			url: '/boardMVC/board/boardDelete.do', 
			data: {
				'seq' : $('#seq').val(),
				'pg' : $('#pg').val()
			},
			success: function(){
				alert("글을 삭제하였습니다.");
				location.href='/boardMVC/board/BoardList.do?pg='+$('#pg').val();
			},
			error: function(e){
				console.log(e);
			}			
		});
		} else {
			alert("삭제를 취소하였습니다");
		}
	});
});