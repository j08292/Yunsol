//관리자 이벤트 리스트 마우스오버-미리보기
$(document).on("mouseover",".adminListImage",function(e){ //마우스 오버시
	var xOffset = 10;
	var yOffset = 30;
	$("body").append("<p id='preview'><img src='"+ $(this).attr("src") +"' width='200px' /></p>"); //보여줄 이미지를 선언                       
	$("#preview")
	.css("top",(e.pageY - xOffset) + "px")
	.css("left",(e.pageX + yOffset) + "px")
	.fadeIn("fast"); //미리보기 화면 설정 셋팅
});

$(document).on("mouseout",".adminListImage",function(){ //마우스 아웃시
	$("#preview").remove();
});


function del_event(event_num){
	if (confirm("정말 삭제하시겠습니까?") == true) {
		location.href = 'delete.do?event_num='+event_num;
	}else{
		return;
	}
}