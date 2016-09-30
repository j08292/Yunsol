/*==================================사용자 희망도서 신청==================================*/
//신청 완료시
function confirm_event(){
	var a="신청되었습니다.";
	var b="신청 내역은 마이페이지에서 확인 가능합니다.";
	var c="(확인을 누르시면 메인페이지로 이동합니다.)";
	
	if($('#wish_title').val() == ''){		
		return false;
	}else if($('#wish_writer').val() == ''){		
		return false;
	}else if($('#wish_publish').val() == ''){		
		return false;
	}else{
		alert(a +'\n'+ b +'\n'+ c);
	}
}