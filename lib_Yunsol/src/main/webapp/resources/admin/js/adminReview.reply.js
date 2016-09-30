/*관리자 감상평 댓글 관리*/
//리스트 폼 초기화
function initAdminReplyList(review_num){
	location.href="detail.do?review_num="+review_num;
}

$(document).ready(function(){
	var cuttentPage;
	var count;
	var rowCount;

	//댓글목록
	function selectData(pageNum,review_num){
		currentPage = pageNum;

		if(pageNum == 1){
			$('#output').empty();
		}
		$('loading').show();


		//댓글목록
		$.ajax({
			type:'post',
			data:{pageNum:pageNum, review_num:review_num},
			url:'listReplyAjax.do',
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){
				//로딩이미지 감추기
				$('#loading').hide();
				count = data.count;
				rowCount = data.rowCount;
				var list = data.list;

				//count에 음수가 오면 오류가 났다는 의미
				if(count < 0 || list == null){
					alert('목록 호출 오류 발생');
				}else{
					$(list).each(function(index,item){
						var output = '';
						output += '<div class="item" id="i'+item.review_re_num+'">';
						output += '<h4>' + item.mem_id + '</h4>';
						output += '<div class="sub-item">';
						output += '<p>' + item.review_re_content + '</p>';
						output += '<div>' + item.review_re_regdate;													
						output += '<input type="button" data-num="'+item.review_re_num+'" data-id="'+item.mem_id+'" class="delete_button btn btn-xs btn-danger" value="삭제">';
						output += ' <hr size="1" noshade>';
						output += ' </div>';
						output += ' </div>';
						output += ' </div>';

						//문서 객체에 추가
						$('#output').append(output);
					});

					//paging button 처리
					if(currentPage>=Math.ceil(count/rowCount)){
						//다음 페이지가 없음
						$('.paging_button').hide();
					}else{
						//다음 페이지가 있음
						$('.paging_button').show();
					}
				}
			},
			error:function(){
				//로딩 이미지 감추기
				$('#loading').hide();
				alert('네트워크 오류 발생!');
			}
		});
	}

	//다음 댓글 보기 버튼 클릭시 데이터 추가(이벤트연결)
	$('.paging_button input').click(function(){
		var pageNum = currentPage + 1;
		selectData(pageNum, $('#review_num').val());
	});

	// 댓글 삭제
	$(document).on('click', '.delete_button', function(){
		// 댓글 번호
		var num = $(this).attr('data-num');
		//작성자 아이디
		var id = $(this).attr('data-id');
		
			$.ajax({
				type:'post',
				data:{review_re_num:num, mem_id:id},
				url:'deleteReplyAjax.do',
				dataType:'json',
				cache:false,
				timeout:30000,
				success:function(data){
					alert('삭제되었습니다!');
					//수정폼초기화					
					initAdminReplyList($('#review_num').val());				
				},
				error:function(){
					alert('네트워크 오류발생');
				}
			});		
	});
	//초기 데이터(목록) 호출
	selectData(1,$('#review_num').val());
});

//글 상세에서 부모글 삭제시 확인
function delete_event(review_num) {
	if (confirm("정말 삭제하시겠습니까?") == true) { //확인
		location.href='detailDelete.do?review_num='+ review_num;
	}else{
		return;
	}
}