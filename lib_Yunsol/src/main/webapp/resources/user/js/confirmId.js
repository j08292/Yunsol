$(document).ready(function() {
	var checkIdDuplicated = 0;

	// 아이디 중복 체크
	$('#confirmId').click(function() {
		if ($('#mem_id').val() == '') {
			alert('아이디를 입력하세요!');
			$('#mem_id').focus();
			return;
		}
		$('#id_signed').html(''); // 메시지 초기화
		$('#loading').show(); // 로딩 이미지 노출

		$.ajax({
			url : 'confirmId.do',
			type : 'post',
			data : {
				mem_id : $('#mem_id').val()
			},
			dataType : 'json',
			cache : false,
			timeout : 30000,
			success : function(data) {
				$('#loading').hide(); // 로딩 이미지 감추기

				if (data.result == 'idNotFound') {
					$('#id_signed').css('color', '#000000').text('등록가능ID');
					checkIdDuplicated = 1;
				} else if (data.result == 'idDuplicated') {
					$('#id_signed').css('color', 'red').text('중복된 ID');
					checkIdDuplicated = 0;
				} else {
					alert('아이디 중복 체크 오류 발생');
				}
			},
			error : function() {
				$('#loading').hide(); // 로딩 이미지 감추기
				alert('네트워크 오류 발생');
			}
		});
	});

	// 아이디 중복 안내 메시지 초기화 및 아이디 중복 값 초기화
	$('#register-form #mem_id').keyup(function() {
		checkIdDuplicated = 0;
		$('#id_signed').text('');
	});

	$('#register-form').submit(function() {
		if (checkIdDuplicated == 0) {
			alert('아이디 중복 체크 필수!');
			if ($('#mem_id').val() == '') {
				$('#mem_id').focus();
			} else {
				$('#confirmId').focus();
			}
			return false;
		}

	/*	if ($('#mem_passwd').val() == '') {
			alert('비밀번호를 입력하세요');
			$('#mem_passwd').focus();
			return false;
		}
		
		if($('#mem_passwd').length() <= 4 ){
			alert('비밀번호는 4자 이상 10자 이하로 설정해주십시오.')
			$('#mem_passwd').focus();
			return false;
		}
	

		if ($('#mem_passwd').val() != $('#check_passwd').val()) {
			alert('비밀번호화 비밀번호 확인이 불일치 합니다.');
			$('#check_passwd').val('').focus();
			return false;
		}

		if ($('#mem_name').val() == '') {
			alert('이름을 입력하세요');
			$('#mem_name').focus();
			return false;
		}

		if ($('#mem_cell').val() == '') {
			alert('전화번호 입력하세요');
			$('#mem_cell').focus();
			return false;
		}

		if ($('#mem_email').val() == '') {
			alert('이메일을 입력하세요');
			$('#mem_email').focus();
			return false;
		}

		if ($('#mem_address').val() == '') {
			alert('우편번호 입력하세요');
			$('#mem_address').focus();
			return false;
		}*/
	});

});
