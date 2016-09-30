/*==================================관리자 감상평 관리==================================*/
//리스트 폼 초기화
function initAdminList(){
	location.href="list.do";
}

//체크박스 폼 초기화
function initCheck(){
	$("input[name=review_num]:checkbox").attr("checked", false);
}

//관리자 목록에서 상세보기 클릭시 체크박스 초기화
$('.detail_btn').click(function(){
	initCheck();
});

//글목록 - 체크박스
function ajaxReviewDelete(){
	var allData = '';

	if($("input[name=review_num]:checkbox:checked").length == 0){
		alert('삭제 할 게시물을 선택하십시오.');
		return;	
	}else{
		if (confirm("정말 삭제하시겠습니까?") == true) { //확인
			$.ajax({
				url:"delete.do",
				type:'GET',
				data: $("input[name='review_num']:checked").serialize(),
				success:function(data){
					alert($("input[name=review_num]:checkbox:checked").length + "개 삭제 완료!");
					//window.opener.location.reload();
					//self.close();
					initAdminList();
				},
				error:function(){			
					alert('네트워크 오류 발생!');//서버프로그램에서 오류발생
					//self.close();
				}
			});			
		}else {
			return;
		}
	}	
}

//전체선택 체크박스 클릭
$("#allCheck").click(function(){	
	if($("#allCheck").prop("checked")){//allCheck가 체크된상태일경우
		//해당화면에 전체 checkbox들을 체크해준다
		$("input[type=checkbox]").prop("checked",true);		
	}else {//allCheck가 해제된 경우
		//해당화면에 모든 checkbox들의 체크를해제시킨다.
		$("input[type=checkbox]").prop("checked",false);
	}
})

/*
//전체선택
$("#check_all").click(function() {
	$("input[name=box]:checkbox").attr("checked", true);
});
//전체해제
$("#uncheck_all").click(function() {
	$("input[name=box]:checkbox").attr("checked", false);
});
//선택된 갯수
$("#count_check").click(function() {
	alert($("input[name=box]:checkbox:checked").length);
});*/
