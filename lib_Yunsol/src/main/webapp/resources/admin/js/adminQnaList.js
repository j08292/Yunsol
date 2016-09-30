//리스트 폼 초기화
function initAdminList(){
	location.href="list.do";
}

//체크박스 폼 초기화
function initCheck(){
	$("input[name=qna_num]:checkbox").attr("checked", false);
}

//관리자 목록에서 상세보기 클릭시 체크박스 초기화
$('.detail_btn').click(function(){
	initCheck();
});

//글목록 - 체크박스
function ajaxQnaDelete(){
	var allData = '';

	if($("input[name=qna_num]:checkbox:checked").length == 0){
		alert('삭제 할 게시물을 선택하십시오.');
		return;	
	}else{
		if (confirm("정말 삭제하시겠습니까?") == true) { //확인
			$.ajax({
				url:"delete.do",
				type:'GET',
				data: $("input[name='qna_num']:checked").serialize(),
				success:function(data){
					alert($("input[name=qna_num]:checkbox:checked").length + "개 삭제 완료!");
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

$("#qnaSearch").change(function(){
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
			output +="<option value='답변대기'>답변대기</option>";
			output +="<option value='답변완료'>답변완료</option>";
			output +="</select>";
			$("#output").append(output);
	   }
});

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
