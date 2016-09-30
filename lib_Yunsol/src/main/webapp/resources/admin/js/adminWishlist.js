/*==================================관리자 희망 도서==================================*/
//관리자 희망도서 진행상태 변경
$(".status").change(function(){
	//alert($(this).attr('data-num')+', ' +$(this).find('option:selected').val());
	var wish_num=$(this).attr('data-num');
	var wish_status=$(this).find('option:selected').val();
	$('.status_button').click(function(){
		location.href="updateStatus.do?wish_num="+wish_num+"&wish_status="+wish_status;
		alert('변경되었습니다.');
	});
});

//관리자 희망도서 목록 검색창 변경
$("#wishlistSearch").change(function(){	
	if($(this).val()=="wish_title"){
		$("#selectbox").remove();
		var output = '';
		output +='<input type="text" name="keyword" size="16" id="textbox">';
		$("#output").append(output);
	}else{		
		$("#textbox").remove();
		var output = '';
		output +='<select name="keyword" id="selectbox" style="width:150px;">';
		output +='<option value="">선택하세요</option>';
		output +='<option value="0">신청중</option>';
		output +='<option value="1">처리중</option>';
		output +='<option value="2">취소됨</option>';
		output +='<option value="3">소장중</option>';
		output +='</select>';
		$("#output").append(output);
	}
});