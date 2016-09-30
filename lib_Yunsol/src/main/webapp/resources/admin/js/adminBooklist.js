/*==================================관리자 도서 목록==================================*/
//관리자 도서 등록시 이미지 미리보기
var ImagePreview = (function loadImageFile() {
	if (window.FileReader) {
		var ImagePre; 
		var ImgReader = new window.FileReader();
		var fileType = /^(?:image\/bmp|image\/gif|image\/jpeg|image\/png|image\/x\-xwindowdump|image\/x\-portable\-bitmap)$/i; 

		ImgReader.onload = function (Event) {
			if (!ImagePre) {
				var newPreview = document.getElementById("imagePreview");
				ImagePre = new Image();
				ImagePre.style.width = "200px";
				//ImagePre.style.height = "140px";
				newPreview.appendChild(ImagePre);
			}
			ImagePre.src = Event.target.result;
		};

		return function () {
			var img = document.getElementById("upload").files;

			if (!fileType.test(img[0].type)) { 
				alert("이미지 파일을 업로드 하세요"); 
				return; 
			}
			ImgReader.readAsDataURL(img[0]);
		}
	}
	document.getElementById("imagePreview").src = document.getElementById("upload").value;
})();

//관리자 도서목록 호출시 마우스오버-미리보기
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

//관리자 도서 목록 검색창 변경
$("#booklistSearch").change(function(){	
	if($(this).val()=="list_status"){
		$("#textbox").remove();
		var output = '';
		output +='<select name="keyword" id="selectbox" style="width:150px;">';
		output +='<option value="">선택하세요</option>';
		output +='<option value="0">대출가능</option>';
		output +='<option value="1">대출정지</option>';
		output +='</select>';
		$("#output").append(output);
	}else{
		$("#textbox").remove();
		$("#selectbox").remove();
		var output = '';
		output +='<input type="text" name="keyword" size="16" id="textbox">';
		$("#output").append(output);		
	}
});

//대출정지 처리시 확인  
function rentStop_event(list_num,list_title){
	if (confirm("정말 ["+list_title+"] 을/를 대출정지 처리하시겠습니까?") == true) {
		location.href='updateStatus.do?list_num='+list_num+'&list_status=1';
	}else{
		return;
	}
}