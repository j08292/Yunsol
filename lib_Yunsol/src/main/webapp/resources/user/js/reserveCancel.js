$(document).ready(function() {
	$('.reserveCancel-button').click(function(event){
		var rent = $(this).attr('data-num');
		var list = $(this).attr('data-num1');
		alert(rent);
		alert(list);
		
		$.ajax({
			url:'reserveCancel.do',
			type:'post',
			data:{rent_num:rent, list_num:list},
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){
				if(data.result == "success"){
					alert('예약이 취소되었습니다.');
					location.href=$('.reserveCancel-button').attr('href');
				}else if(data.result == "fail"){
					alert("예약취소를 실패했습니다.");
					history.go(0);
				}
				
			},
			error:function(){
					alert('네트워크 오류 발생.');
			}
		});
		event.preventDefault();
	});
});