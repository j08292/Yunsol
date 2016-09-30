$(document).ready(function(){

//회원 정보 수정 유효성 체크
	$('#update-form').submit(function(){		
		if($('#mem_name').val()==''){
			alert('이름을 입력하세요');
			$('#mem_name').focus();
			return false;
		}
		if($('#mem_passwd').val()==''){
			alert('비밀번호를 입력하세요');
			$('#mem_passwd').focus();
			return false;
		}
/*		if($('#check_passwd').val()==''){
			alert('비밀번호 확인을 입력하세요');
			$('#check-passwd').focus();
			return false;
		}
		if($('#mem_passwd').val()!=$('#check_passwd').val()){
			alert('비밀번호화 비밀번호 확인이 불일치 합니다.');
			$('#check_passwd').val('').focus();
			return false;
		}
		*/
		if($('#mem_email').val()==''){
			alert('이메일을 입력하세요');
			$('#mem_email').focus();
			return false;
		}
		if($('#mem_cell').val()==''){
			alert('전화번호 입력하세요');
			$('#mem_cell').focus();
			return false;
		}
		if($('#mem_address').val()==''){
			alert('우편번호 입력하세요');
			$('#mem_address').focus();
			return false;
		}
		
	});


	//로그인 유효성 체크
	$('#login-form').submit(function(){
		if($('#mem_id').val()==''){
			alert('아이디를 입력하세요');
			$('#mem_id').focus();
			return false;
		}
		if($('#mem_passwd').val()==''){
			alert('비밀번호를 입력하세요');
			$('#mem_passwd').focus();
			return false;
		}
		
	});
	
	//회원탈퇴 유효성 체크
	$('#delete-form').submit(function(){
		if($('#mem_passwd').val()==''){
			alert('비밀번호를 입력하세요');
			$('#mem_passwd').focus();
			return false;
		}
		if($('#check_passwd').val()==''){
			alert('비밀번호 확인을 입력하세요');
			$('#check_passwd').focus();
			return false;
		}
		if($('#mem_passwd').val()!=$('#check_passwd').val()){
			alert('비밀번호화 비밀번호 확인이 불일치 합니다.');
			$('#check_passwd').val('').focus();
			return false;
		}
		
	});
	
});