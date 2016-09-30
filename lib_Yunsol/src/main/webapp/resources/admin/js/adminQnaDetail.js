function delete_event(qna_num) {
	if (confirm("정말 삭제하시겠습니까?") == true) { //확인
			location.href = 'detailDelete.do?qna_num='+qna_num;
	} else {
		return;
	}
}