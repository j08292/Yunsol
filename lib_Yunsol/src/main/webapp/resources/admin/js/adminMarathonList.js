$("#marathonSearch").change(function(){
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
			output +="<option value='1'>발송처리</option>";
			output +="</select>";
			$("#output").append(output);
	   }
});

function check_event(marathon_num){
	if (confirm("상태를 변경하시겠습니까?") == true) {
		location.href = 'updateStatus.do?marathon_status=1&marathon_num='+marathon_num;
	}else{
		return;
	}
}
function cancel_event(marathon_num){
	if (confirm("정말 취소하시겠습니까?") == true) {
		location.href = 'updateStatus.do?marathon_status=0&marathon_num='+marathon_num;
	}else{
		return;
	}
}