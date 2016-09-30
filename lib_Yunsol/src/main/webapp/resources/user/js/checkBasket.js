//$(document).ready(function() {
//	
//function formSubmit(){
//	document.getElementById("detail-form").submit();
//}
//	var checkNum = 0;
//	$('#checkbasket-button').click(function(event){
//		$.ajax({
//			url:'checkBasket.do',
//			type:'post',
//			data:{list_num:$('#list_num').val()},
//			dataType:'json',
//			cache:false,
//			timeout:30000,
//			success:function(data){
//				if(data.result=="duplicated"){
//					alert("이미 장바구니에 추가했습니다.");
//					location.href=$('#checkbasket-button').attr('href');
////					history.go(1);
//				}else if(data.result == "notFound"){
//					alert("대여가능한 책입니다.")
////					location.href=$('#checkbasket-button').attr('href');
//					location.href=$('#checkbasket-button').attr('onclick');
//				}else if(data.result == "noUserId"){
//					alert("로그인을 해주세요.")
//					location.href="http://localhost:8080/lib_cih/member/login.do";
//				}
//			},
//			error : function(data) {
//				if(data.result=="failure"){
//				alert('네트워크 오류 발생.');
//				}
//			}	
//		});
//		event.preventDefault();
//	});
//
//
//	$('#unmanned-button').click(function(event){
//		$.ajax({
//			url:'checkUnmanned.do',
//			type:'post',
//			data:{list_num:$('#list_num').val()},
//			dataType:'json',
//			cache:false,
//			timeout:30000,
//			success:function(data){
//				if(data.result == "unmanned"){
//					alert("무인대여가 가능한 책입니다.")
//					location.href=$('#unmanned-button').attr('onclick');
//				}else if(data.result == "noUserId"){
//					alert("로그인을 해주세요.")
//					location.href="http://localhost:8080/lib_cih/member/login.do";
//				}
//			},
//			error : function(data) {
//				if(data.result=="failure"){
//				alert('네트워크 오류 발생.');
//				}
//			}	
//			
//		});
//	});
//
//
//});