function block_message(mem_id){
	var penalty_reason = prompt("차단 사유를 입력하세요.");
	if(penalty_reason!=null){
		if(penalty_reason!=""){
			location.href="insertPenalty.do?mem_id="+mem_id+"&penalty_reason="+penalty_reason;
			alert('차단되었습니다.');
		}else{
			alert('차단사유는 필수입니다!');
			return;
		}
	}else{
		return;
	}
}

function blockcancel_event(mem_id){
	if (confirm(mem_id+"의 회원상태를 [정상]으로 변경하시겠습니까?") == true) {
		location.href = 'penaltyCancel.do?mem_id='+mem_id;
	}else{
		return;
	}
}