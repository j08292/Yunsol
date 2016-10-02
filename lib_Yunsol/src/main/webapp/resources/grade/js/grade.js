//별점
var starRating = function(){
	var $star = $('.star-input'),
	$result = $star.find('output>b');
	$(document).on('focusin', '.star-input>.input', function(){
		$(this).addClass('focus');
	})
	.on('focusout', '.star-input>.input',function(){
		var $this = $(this);
		setTimeout(function(){
			if($this.find(':focus').length === 0){
				$this.removeClass('focus');
			}
		}, 100);
	})

	.on('change', '.star-input :radio', function(){
		$('#star_point').text($(this).next().text());
	})
	.on('mouseover', '.star-input label', function(){
		$result.text($(this).text());
	})
	.on('mouseleave', '.star-input>.input', function(){
		var $checked = $star.find(":checked");
		if($checked.length === 0){
			$result.text("0");
		}else{
			$result.text($checked.next().text());
		}
	});
};
starRating();

$(document).ready(function(){
	var currentPage;
	var count;
	var rowCount;
	//댓글목록
	function selectData(pageNum,list_num){
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
			data:{pageNum:pageNum,list_num:list_num},
			url:'listGradeAjax.do',
			datatype:'json',
			cache:false,
			timeout:30000,
			success:function(data){
				//로딩이미지 감추기
				$('#loading').hide();
				count = data.count;
				rowCount = data.rowCount;
				var list = data.list;

				if(count < 0 || list == null){
					alert('목록 호출 오류 발생');
				}else{
					$(list).each(function(index,item){
						var output = '';
						output += '<div class="item" id="i'+item.grade_num+'">';
						output += '<h4>' + item.mem_id + '</h4>';
						output += '<div class="sub-item">';
						output += '<p>' +'<img src="../resources/grade/images/'+item.grade_star+'.PNG"> ' + item.grade_content + '</p>';

						output += '<div>' + item.grade_regdate; 

						if($('#mem_id').val() && $('#mem_id').val()==item.mem_id){
							output += ' <input type="button" data-num="'+item.grade_num+'" data-id="'+item.mem_id+'" class="delete_button" value="삭제">';
						}/*else{
							output += ' <input type="button" value="삭제" disabled="disable">';
						}*/
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
				alert('목록생성시 네트워크 오류 발생');
			}
		});
	}

	//다음 댓글 보기 버튼 클릭시 데이터 추가
	$('.paging_button input').click(function(){
		var pageNum = currentPage + 1;
		selectData(pageNum,$('#list_num').val());
	});

	//댓글 등록
	$('#grade_form').submit(function(event){
		if($('#grade_content').val()==''){
			alert('내용을 입력하세요');
			$('#grade_content').focus();
			return false;
		}

		var data = $(this).serialize();

		//댓글 등록 ajax
		$.ajax({
			type:'post',
			data:data,
			url:'writeGradeAjax.do',
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
					selectData(1,$('#list_num').val());
				}else if(data.result=='alreadyWrite'){
					alert('이미 한줄평을 등록하셨습니다.')
				}else{
					alert('등록시 오류 발생!');
				}
			},
			error:function(){
				alert('댓글 등록 네트워크 오류발생');
			}
		});
		//기본 이벤트 제거
		event.preventDefault();
	});
	//댓글 작성 폼 초기화
	function initForm(){
		$('textarea').val('');
		$('#grade_first .letter-count').html('140/140');
	}

	//textarea에 내용 입력시 글자수 체크
	$('#grade_content').keyup(function(){
		//남은 글자수 구하기
		var inputLength = $(this).val().length;

		if(inputLength > 140){
			$(this).val($(this).val().substring(0,140));
			if($(this).attr('mem_id')=='grade_content'){
				//등록폼 글자수
				$('#grade_first .letter-count').text('0/140');
			}
		}else{ //140자 안되면 더 입력 가능
			var remain = 140 - inputLength;
			remain += '/140';
			//문서 객체 반영
			if($(this).attr('id')=='grade_content'){
				//등록폼 글자수
				$('#grade_first .letter-count').text(remain);
			}
		}
	});
	//댓글 수정 폼 초기화
	function initModifyForm(){
		$('.sub-item').show();


	}

	// 댓글 삭제
	$(document).on('click', '.delete_button', function(){
		// 댓글 번호
		var grade_num = $(this).attr('data-num');
		//작성자 아이디
		var mem_id = $(this).attr('data-id');

		$.ajax({
			type:'post',
			data:{grade_num:grade_num, mem_id:mem_id},
			url:'deleteGradeAjax.do',
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
					selectData(1,$('#list_num').val());

				}else{
					alert('삭제시 오류 발생');
				}
			},
			error:function(){
				alert('댓글 삭제 네트워크 오류발생');
			}
		});
	});

	//초기 데이터(목록) 호출
	selectData(1,$('#list_num').val());
});
