$(document).ready(function(){
	$('#reserve-button').click(function(){
		$.ajax({
			url:'reserveBook.do',
			type:'post',
			data:{list_title:$('#list_title').val(), list_num:$('#list_num').val()},
			dataType:'json',
			timeout:30000,
			success:function(data){
				if(data.result=="success"){
					alert("예약되었습니다.");
					history.go(0);
				}else if(data.result=="fail"){
					alert("예약 허용인원 초과했습니다.");
				}else if(data.result=="duplicated"){
					alert("이미 대여한 책입니다.");
				}else if(data.result == "noUserId"){
					alert("로그인을 해주세요.")
					location.href="http://localhost:8080/lib_cih/member/login.do";
				}
			},
			error:function(data) {
				if(data.result=="failure"){
				alert('네트워크 오류 발생.');
				}
			}	
		})
	});
});