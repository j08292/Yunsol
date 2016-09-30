$("#speechSearch").change(function(){
	   if($(this).val()=="speech_date"){      
		   $("#textbox").remove();
		      var output = '';
				output +="<input type='text' size='16' name='keyword' id='datepicker'>";
				$("#output").append(output);
	   }else{
		   $("#selectbox").remove();
		      var output = '';
		      output +="<input type='text' size='16' name='keyword' id='textbox'>";
			  $("#output").append(output);
	     
	   }
});
$(document).ready(function(){
	$(function(){
		$('#datepicker').datepicker({
			showMonthAfterYear:true, //'default : 월 년'을 '년 월'로 바꿈
			changeYear:true, //년도 선택할 수 있게
			changeMonth:true,
			dateFormat:'yy-mm-dd',
			monthNamesShort:['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
			dayNamesMin:['일','월','화','수','목','금','토']
		});
	});
});