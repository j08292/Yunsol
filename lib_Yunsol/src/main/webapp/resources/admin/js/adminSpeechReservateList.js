$(".status").change(function(){
	var speech_num=$(this).attr('data-num');
	var speech_reserve_num=$(this).parent().attr('data-num');
	var status = $(this).find('option:selected').val();
	 $('.save_Status').click(function(){
		 location.href="updateReserve.do?speech_num="+speech_num+"&speech_reserve_num="+speech_reserve_num+"&status="+status;
		 alert('변경되었습니다.');
	 });   
});


$("#speechReserveSearch").change(function(){
	   if($(this).val()=="mem_id"){      
	      $("#selectbox").remove();
	      var output = '';
	      output +="<input type='text' size='16' name='keyword' id='textbox'>";
		  $("#output").append(output);
	   }else{
	      $("#textbox").remove();
	      var output = '';
			output +="<select name='keyword' id='selectbox'>";
			output +="<option value=''>선택하세요</option>";
			output +="<option value='0'>신청중</option>";
			output +="<option value='1'>신청 확정</option>";
			output +="<option value='2'>취소 신청</option>";
			output +="<option value='3'>취소 완료</option>";
			output +="</select>";
			$("#output").append(output);
	   }
});

function delete_event(speech_num,speech_reserve_num){
	if (confirm("정말 삭제하시겠습니까?") == true) {
		location.href = 'reservationDelete.do?speech_num='+speech_num+'&speech_reserve_num='+speech_reserve_num;
	}else{
		return;
	}
}