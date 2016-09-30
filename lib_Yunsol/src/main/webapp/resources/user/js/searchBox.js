$(document).ready(function(){
	$(function() {
		$('#selectBox').change(function(){
//			alert($(this).val());
			location.href = $(this).val();
			var val = $('#selectBox option:selected').val();
			$('#selectBox').val('${pageContext.request.contextPath}/member/myOrder.do?rent_status=3');
		});
	});
});