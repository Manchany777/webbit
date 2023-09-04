$(function(){
	// 선택한 이메일을 옆칸에 자동입력
	$('#emailSelect').change(function(){
		var email3 = $('#emailSelect').val();
		$('#email_2').val(email3);
		
		if(email3 == '직접입력') {
			$('#email2').val('');
		}
	});	
	
	
	// 유효성 검사
	$('#writeBtn').click(function(){
		// 초기화
		$('#nameDiv').empty();
		$('#idDiv').empty();
		$('#pwdDiv').empty();
		
		if($('#name').val()==''){
			$('#nameDiv').text('이름을 입력하세요.');
			$('#name').focus();
		} else if ($('#id').val()=='') {
			$('#idDiv').text('아이디를 입력하세요.');
			$('#id').focus();
		} else if ($('#pwd').val()=='') {
			$('#pwdDiv').text('비밀번호를 입력하세요.');
			$('#pwd').focus();
		} else if ($('#pwd').val() != $('#repwd').val()) {
			$('#pwdDiv').text('비밀번호가 맞지 않습니다.');
			$('#pwd').focus();
		} else if($('input[name="useCheckedId"]').val() != "idChecked") {
       		alert("중복체크를 해 주세요.");
    	} else {
			var checkedId = $('input[name="useCheckedId"]').val();
			
			if(checkedId != "idChecked") {
				// 중복 체크 상태 초기화
				alert("아이디 중복체크를 다시 수행해주세요.");
				$('#id').focus();
			}
			$('#memberWriteForm').submit();
		}
		
		// 중복체크 후 아이디 변경시 중복 체크 상태 초기화
		/*$("#id").change(function() {
		    document.getElementsByName("useCheckedId")[0].value = "idUnchecked";
 		});*/
		$("#id").on("input", function() {
		    document.getElementsByName("useCheckedId")[0].value = "idUnchecked";
 		});
	});
});