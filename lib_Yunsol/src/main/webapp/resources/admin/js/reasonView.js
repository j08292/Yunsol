//차단 사유 목록
function selectData(mem_id){
	var count;
	//로딩 이미지 노출
	$('#loading').show();
	
	//목록 Ajax
	$.ajax({
		type:'post',
		data:{mem_id:mem_id},
		url:'reasonViewAjax.do',
		dataType:'json',
		cache:false,
		timeout:30000,
		success:function(data){
			//로딩 이미지 감추기
			$('#loading').hide();
			count = data.count;
			var list = data.list;
			
			if(count < 0 || list == null){
				alert('목록 호출 오류 발생');
			}else{
				var output = '';
				output += '<div class="alert alert-danger" id="reasonView_'+mem_id+'" style="width:90%; margin:0 auto;">';
				$(list).each(function(index,item){
					output += '<strong>차단일자</strong>: '+ item.penalty_regdate + ' ~ ' + item.penalty_blockcanceldate + '<br>';
					output += '<strong>차단사유</strong>: '+ item.penalty_reason + '<br><br>';
				});
				output += '</div>'
				//문서 객체에 추가
				$('#output_'+mem_id).append(output);		
				$('#reasonOpen_'+mem_id).hide();
				$('#reasonClose_'+mem_id).show();
			}
		},
		error:function(){
			//로딩 이미지 감추기
			$('#loading').hide();
			alert('네트워크 오류 발생!');
		}
	});
}
//사유 숨기기
function hideData(mem_id){
	$("#reasonView_"+mem_id).remove();
	$('#reasonOpen_'+mem_id).show();
	$('#reasonClose_'+mem_id).hide();
}