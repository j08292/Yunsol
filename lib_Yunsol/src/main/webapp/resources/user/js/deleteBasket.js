//$(document).ready(function() {

//var basket = document.getElementById('delete-button');
//basket.addEventListener('click',function(event){
//$.ajax({
//url:'delete.do',
//type:'post',
//data:{basket_num:$('.basket_num').val()},
//dataType:'json',
//cache:false,
//timeout:30000,
//success:function(data){
//if(data.result=="deleteSuccess"){
//alert("삭제완료.");
//location.href=$('#delete-button').attr('href');
////location.href=$('#delete-button').attr('onclick');
////location.href="http://localhost:8080/lib_cih/book/basket.do"
//}else if(data.result == "noUserId"){
//alert("로그인을 해주세요.")
//location.href="http://localhost:8080/lib_cih/member/login.do";
//}
//},
//error : function() {
//alert('네트워크 오류 발생');
//}	
//});
//});
//});
$(document).ready(function() {
	console.log($('.delete-button').attr('name'));
	$('.delete-button').click(function(event){
		var value = $(this).attr('data-num');
		alert(value);
		$.ajax({
			url:'delete.do',
			type:'post',
			data:{basket_num:value},
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){
				if(data.result=="deleteSuccess"){
					alert("삭제완료.");
					location.href=$('#delete-button').attr('href');
				}else if(data.result == "noUserId"){
					alert("로그인을 해주세요.")
					location.href="http://localhost:8080/lib_cih/member/login.do";
				}
			},
			error : function() {
				alert('네트워크 오류 발생');
			}	
		});
		event.preventDefault();
	});

});	