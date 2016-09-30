/*==================================관리자 공지사항 관리==================================*/
//공지사항 삭제 처리시 확인
function delete_event(notice_num) {
	if (confirm("정말 삭제하시겠습니까?") == true) { //확인
		location.href='delete.do?notice_num='+notice_num;
	}else{
		return;
	}
}