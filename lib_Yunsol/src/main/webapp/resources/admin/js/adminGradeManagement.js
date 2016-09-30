/*==================================관리자 한줄평 관리==================================*/
//리스트 폼 초기화
function initAdminList(){
	location.href="list.do";
}

//체크박스 폼 초기화
function initCheck(){
	$("input[name=grade_num]:checkbox").attr("checked", false);
}

//글목록 - 체크박스
function ajaxGradeDelete(){
	var allData = '';

	if($("input[name=grade_num]:checkbox:checked").length == 0){
		alert('삭제 할 게시물을 선택하십시오.');
		return;	
	}else{
		if (confirm("정말 삭제하시겠습니까?") == true) { //확인
			$.ajax({
				url:"delete.do",
				type:'GET',
				data: $("input[name='grade_num']:checked").serialize(),
				success:function(data){
					alert($("input[name=grade_num]:checkbox:checked").length + "개 삭제 완료!");					
					initAdminList();
				},
				error:function(){			
					alert('네트워크 오류 발생!');//서버프로그램에서 오류발생
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

//한줄평 내용 더보기
function adminGradeView(grade_num){
	var count;
	//로딩 이미지 노출
	$('#loading').show();

	//목록 Ajax
	$.ajax({
		type:'post',
		data:{grade_num:grade_num},
		url:'adminGradeViewAjax.do',
		dataType:'json',
		cache:false,
		timeout:30000,
		success:function(data){
			//로딩 이미지 감추기
			$('#loading').hide();
			$('#shortContent_'+grade_num).hide();
			var content = data.content;			
			var output = '';
			output += '<span>'+content+'</span>';
			//문서 객체에 추가
			$('#output_'+grade_num).append(output);
		},
		error:function(){
			//로딩 이미지 감추기
			$('#loading').hide();
			alert('네트워크 오류 발생!');
		}
	});
}