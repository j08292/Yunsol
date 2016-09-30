$(document).ready(function(){
	var currentPage;
	var count;
	var rowCount;
	//댓글목록
	function selectData(pageNum,event_num){
		currentPage = pageNum;
		
		if(pageNum == 1){
			//처음 호출시는 해당 ID의 div의 내부 내용을 제거
			$('#output').empty();
		}
		//로딩 이미지 노출
		$('loading').show();
		
		//댓글 목록 Ajax
		$.ajax({
			type:'post',
			data:{pageNum:pageNum,event_num:event_num},
			url:'listReplyAjax.do',
			datatype:'json',
			cache:false,
			timeout:30000,
			success:function(data){
				//로딩이미지 감추기
				$('#lodaing').hide();
				count = data.count;
				rowCount = data.rowCount;
				var list = data.list;
				
				if(count < 0 || list == null){
					alert('목록 호출 오류 발생');
				}else{
					$(list).each(function(index,item){
						var output = '';
						output += '<div class="item" id="i'+item.event_re_num+'">';
						output += '<h4>' + item.mem_id + '</h4>';
						output += '<div class="sub-item">';
						output += '<p>' + item.event_re_content + '</p>';
						output += '<div>' + item.event_re_date;
						
						if($('#userId').val() && $('#userId').val()==item.mem_id){
							output += ' <input type="button" data-num="'+item.event_re_num+'" data-id="'+item.mem_id+'" class="modify_button" value="수정">';
							output += ' <input type="button" data-num="'+item.event_re_num+'" data-id="'+item.mem_id+'" class="delete_button" value="삭제">';
						}else{
							output += ' <input type="button" value="수정" disabled="disable">';
							output += ' <input type="button" value="삭제" disabled="disable">';
						}
						output += '<hr size="1" noshade>';
						output += '</div>';
						output += '</div>';
						output += '</div>';
						
						//문서 객체에 추가
						$('#output').append(output);
					});
					
					//paging button처리
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
				alert('네트워크 오류 발생');
			}
		});
	}
	
	//다음 댓글 보기 버튼 클릭시 데이터 추가
	$('.paging_button input').click(function(){
		var pageNum = currentPage + 1;
		selectData(pageNum,$('#event_num').val());
	});
	
	//댓글 등록
	$('#re_form').submit(function(event){
		if($('#event_re_content').val()==''){
			alert('내용을 입력하세요');
			$('#event_re_content').focus();
			return false;
		}
		
		var data = $(this).serialize();
		
		//댓글 등록 ajax
		$.ajax({
			type:'post',
			data:data,
			url:'writeReplyAjax.do',
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){
				if(data.result=='logout'){
					alert('로그인해야 작성할 수 있습니다.');
				}else if(data.result=='success'){
					//폼 초기화
					initForm();
					//수정 폼 초기화
					initModifyForm();
					//댓글 작성이 성공하면 새로 삽입한 글을 포함해서
					//첫번째 페이지의 게시글들을 다시 호출
					selectData(1,$('#event_num').val());
				}else{
					alert('등록시 오류 발생!');
				}
			},
			error:function(){
				alert('네트워크 오류발생');
			}
		});
		//기본 이벤트 제거
		event.preventDefault();
	});
	//댓글 작성 폼 초기화
	function initForm(){
		$('textarea').val('');
		$('#re_first .letter-count').html('1000/1000');
	}
	
	//textarea에 내용 입력시 글자수 체크
	$('#event_re_content, #mre_content').keyup(function(){
		//남은 글자수 구하기
		var inputLength = $(this).val().length;
		
		if(inputLength > 1000){
			$(this).val($(this).val().substring(0,1000));
			if($(this).attr('id')=='event_re_content'){
				//등록폼 글자수
				$('#re_first .letter-count').text('0/1000');
			}else{
				//수정폼 글자수
				$('#mre_first .letter-count').text('0/1000');
			}
		}else{ //1000자 안되면 더 입력 가능
			var remain = 1000 - inputLength;
			remain += '/1000';
			//문서 객체 반영
			if($(this).attr('id')=='event_re_content'){
				//등록폼 글자수
				$('#re_first .letter-count').text(remain);
			}else{
				//수정폼 글자수
				$('#mre_first .letter-count').text(remain);
			}
		}
	});
	
	//댓글 수정 버튼 클릭시 수정폼 노출(미래의 이벤트이므로 접근에 따라 다름  .on사용)
	$(document).on('click', '.modify_button', function(){
		//댓글번호
		var event_re_num = $(this).attr('data-num');
		//작성자 아이디
		var mem_id = $(this).attr('data-id');
		//이전에 이미 수정하는 댓글이 있을 경우 수정버튼을 클릭하면 숨긴 sub-item을 환원시키기 위함
		$('.sub-item').show();
		//지금 클릭해서 수정하고자 하는 데이터는 감추기
		$('#i' + event_re_num + ' .sub-item').hide();

		//수정폼에 데이터 셋팅
		$('#mre_no').val(event_re_num);
		$('#muserId').val(mem_id);
		$('#mre_content').val($('#i'+event_re_num+' p').text());
		
		//입력한 글자수 셋팅
		var inputLength = $('#mre_content').val().length;
		var remain = 1000-inputLength;
		remain += '/1000';
		
		//문서 객체에 반영
		$('#mre_first .letter-count').text(remain);
		
		//수정폼을 수정하고자하는 데이터가 있는 div에 노출
		$('#i' + event_re_num).append($('#mre_form'));
	});
		
		
		//수정폼에서 취소 버튼 클릭시 수정폼 초기화
		$('.re-reset').click(function(){
			initModifyForm();
		});
		
		//댓글 수정 폼 초기화
		function initModifyForm(){
			$('.sub-item').show();
		
			//수정폼에 데이터 셋팅
			$('#modify_div').append($('#mre_form'));
			$('#mre_no').val('');
			$('#muserId').val('');
			$('#mre_content').val('');
			$('#mre_first .letter-count').text('1000/1000');
		}
		 
		//댓글 수정
		$('#mre_form').submit(function(event){
			if($('#mre_content').val()==''){
				alert('내용을 입력하세요');
				$('#mre_content').focus();
				return false;
			}
			 
			//폼에 입력한 데이터 반환
			var data = $(this).serialize();
			
			//수정
			$.ajax({
				type:'post',
				data:data,
				url:'updateReplyAjax.do',
				dataType:'json',
				cache:false,
				timeout:30000,
				success:function(data){
					if(data.result=='logout'){
						alert('로그인해야 수정할 수 있습니다.');	
					}else if(data.result=='wrongAccess'){
						alert('잘못된 접속입니다.');
					}else if(data.result == 'success'){
						$('#i'+$('#mre_no').val() + ' p').html($('#mre_content').val());
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
			var event_re_num = $(this).attr('data-num');
			//작성자 아이디
			var mem_id = $(this).attr('data-id');
			
			$.ajax({
				type:'post',
				data:{event_re_num:event_re_num, mem_id:mem_id},
				url:'deleteReplyAjax.do',
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
						selectData(1,$('#event_num').val());
						   
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
		selectData(1,$('#event_num').val());
		
	

});