$(document).ready(function(){
	var currentPage;
	var count;
	var rowCount;
	
	//댓글목록
	function selectData(pageNum,qna_num){
		currentPage = pageNum;
		
		if(pageNum == 1){
			$('#output').empty();
			
		}
		$('loading').show();
		
		//댓글목록
		$.ajax({
			type:'post',
			data:{pageNum:pageNum, qna_num:qna_num},
			url:'qListReplyAjax.do',
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
						output += '<div class="item" id="i'+item.qna_re_num+'">';
						output += '<h4>' + item.mem_id + '</h4>';
						output += '<div class="sub-item">';
						output += '<p>' + item.qna_re_content + '</p>';
						output += '<div>' + item.qna_re_regdate;
						
						if($('#userId').val() && $('#userId').val()==item.mem_id){
							output += '<input type="button" data-num="'+item.qna_re_num+'" data-id="'+item.mem_id+'" class="modify_button btn btn-default btn-sm" value="수정">';
							output += '<input type="button" data-num="'+item.qna_re_num+'" data-id="'+item.mem_id+'" class="delete_button btn btn-default btn-sm" value="삭제">';
						}else{
							output += '<input type="button" value="수정" disabled="disabled">';
							output += '<input type="button" value="삭제" disabled="disabled">';
						}
						
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
		selectData(pageNum, $('#qna_num').val());
		
	});
	
	//댓글 등록
	$('#qre_form').submit(function(event){
		if($('#qna_re_content').val()==''){
			alert('내용을 입력하세요');
			$('#qna_re_content').focus();
			return false;
		}
		
		var data = $(this).serialize();
		
		
		//댓글 등록 ajax
		$.ajax({
			type:'post',
			data:data,
			url:'qWriteReplyAjax.do',
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){
				if(data.result=='logout'){
					alert('로그인해야 작성할 수 있습니다.');
				}else if(data.result=='success'){					
					//폼 초기화
					initForm();
					//수정폼 초기화
					initModifyForm();
					//댓글 작성이 성공하면 새로 삽입한 글을
					//포함해서 첫번째 페이지의 게시글들을 다시 
					//호출함
							//페이지 , 목록, 글번호
					selectData(1,$('#qna_num').val());
				}else{//에러발생
					alert('등록시 오류 발생2');
				}
			},
			error:function(){
				alert('네트워크 오류 발생3');//서버프로그램에서 오류발생
			}
		});//ajax부분
		//submit일어남
		//기본이벤트 제거
		event.preventDefault();
	});
	//댓글 작성 폼 초기화
	function initForm(){
		$('textarea').val('');
		$('#qre_first .letter-count').html('300/300');
	}
	
	//textarea에 내용 입력시 글자수 체크
	$('#qna_re_content, #mqna_re_content').keyup(function(){
		// 남은 글자수 구하기.
		var inputLength = $(this).val().length;
		
		if(inputLength > 300){
			$(this).val($(this).val().substring(0,300));
			if($(this).attr('id')=='qna_re_content'){
				//등록폼 글자수
				$('#qre_first .letter-count').text('0/300');
			}else{
				//수정폼 글자수
				$('#mqre_first .letter-count').text('0/300');
			}
		}else{//300자 안되면 더 입력 가능
			var remain = 300 - inputLength;
			remain += '/300';
			// 문서 객체 반영
			if($(this).attr('id')=='qna_re_content'){
				//등록폼 글자수
				$('#qre_first .letter-count').text(remain);
			}else{
				//수정폼 글자수
				$('#mqre_first .letter-count').text(remain);
			}
		}
	});
	
	//댓글 수정 버튼 클릭시 수정폼 노출(미래의 이벤트이므로 접근에 따라 다름 .on사용)
	$(document).on('click', '.modify_button', function(){
		// 댓글 번호
		var num = $(this).attr('data-num');
		// 작성자 아이디
		var id = $(this).attr('data-id');
		// 이전에 이미 수정하는 댓글이 있을 경우 수정버튼을 클릭하면
		// 숨긴 sub-item을 환원시키기 위함
		$('.sub-item').show();
		// 지금 클릭해서 수정하고자 하는 데이터는 감추기
		$('#i' + num + ' .sub-item').hide();
		
		// 수정폼에 데이터 셋팅
		$('#mqna_re_num').val(num);
		$('#muserId').val(id);
		$('#mqna_re_content').val($('#i'+num+' p').text());
		
		// 입력한 글자수 셋팅
		var inputLength = $('#mqna_re_content').val().length;
		var remain = 300-inputLength;
		remain += '/300';
		
		// 문서 객체에 반영
		$('#mqre_first .letter-count').text(remain);
		
		// 수정폼을 수정하고자하는 데이터가 있는 div에 노출
		$('#i' + num).append($('#mqre_form'));
	});
	
	// 수정폼에서 취소 버튼 클릭시 수정폼 초기화
	$('.re-reset').click(function(){
		initModifyForm();
	});
	
	//댓글 수정 폼 초기화
	function initModifyForm(){
		$('.sub-item').show();			
		//폼의 원래위치로 복원
		$('#modify_div').append($('#mqre_form'));
		$('#mqna_re_num').val('');
		$('#muserId').val('');
		$('#mqna_re_content').val('');
		$('#mqre_first .letter-count').text('300/300');
	}
	
	// 댓글 수정
	$('#mqre_form').submit(function(event){
		if($('#mqna_re_content').val()==''){
			alert('내용을 입력하세요');
			$('#mqna_re_content').focus();
			return false;
		}
		
		//폼에 입력한 데이터 반환
		var data = $(this).serialize();
	
		//수정
		$.ajax({
			type:'post',
			data:data,
			url:'qUpdateReplyAjax.do',
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){
				if(data.result=='logout'){
					alert('로그인해야 수정할 수 있습니다.');
				}else if(data.result=='wrongAccess'){
					alert('잘못된 접속입니다.');
				}else if(data.result == 'success'){						
					$('#i'+$('#mqna_re_num').val() + ' p').html($('#mqna_re_content').val());
					//수정폼 초기화
					initModifyForm();
				}else{
					alert('수정시 오류 발생');
				}
			},
			error:function(){
				alert('네트워크 오류 발생!');
			}
		});
		//기본이벤트 제거
		event.preventDefault();
		
	});
	
	// 댓글 삭제
	$(document).on('click', '.delete_button', function(){
		// 댓글 번호
		var num = $(this).attr('data-num');
		//작성자 아이디
		var id = $(this).attr('data-id');
		
		$.ajax({
			type:'post',
			data:{qna_re_num:num, mem_id:id},
			url:'qDeleteReplyAjax.do',
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){
				if(data.result=='logout'){
					alert('로그인해야 삭제할수있습니다.');
					
				}else if(data.result =='wrongAccess'){
					alert('잘못된 접속입니다.');
				}else if(data.result == 'success'){
					alert('삭제 완료!');
					//수정폼초기화
					initModifyForm();
					selectData(1,$('#qna_num').val());
					   
				}else{
					alert('삭제시 오류 발생');
				}
			},
		error:function(){
			alert('네트워크 오류발생');
		}
	});
	});
	
	//초기 데이터(목록) 호출
	selectData(1,$('#qna_num').val());
});






