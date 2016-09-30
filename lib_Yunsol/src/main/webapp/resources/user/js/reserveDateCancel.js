$(document).ready(function() {
	$('#reserveDateCancel-button').click(function(){
		$.ajax({
			url:'reserveCancel.do',
			type:'post',
			data:{rent_num:$('#rent_num').val(),
				list_title:$('#list_title').val(),
				list_num:$('#list_num').val()
			},
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){
				if(data.result == "success"){
					alert('예약이 취소되었습니다.');
					history.go(0);
				}
			},
			error:function(data){
				if(data.result=="failure"){
					alert('네트워크 오류 발생.');
				}
			}
		});
	});
});