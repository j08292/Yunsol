function blockcancel_event(mem_id){
	if (confirm(mem_id+"의 회원상태를 [정상]으로 변경하시겠습니까?") == true) {
		location.href = 'penaltyCancel.do?mem_id='+mem_id;
	}else{
		return;
	}
}