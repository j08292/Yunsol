function finish_event(marathon_page,mrt_status) {
	if(mrt_status == 1){
		location.href = 'finishMarathon.do?marathon_page='+marathon_page;
		alert('완주혜택이 신청되었습니다.');
	}else if(mrt_status==2){
		alert('이미 신청하였습니다.');
		return ;
	}else{
		alert('오류 발생!');
		return ;
	}
}