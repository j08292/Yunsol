$(document).ready(function(){
	
	if($('#existing-radio').is(":checked") && !$('#new-radio').is(":checked")){
		$('#existing-panel').show();
		$('#new-panel').hide();
	}
	
	$('#new-radio').click(function(){
		if($('#new-radio').is(":checked") && !$('#existing-radio').is(":checked")){
			$('#new-panel').show();
			$('#existing-panel').hide();
		}
	});
	
	$('#existing-radio').click(function(){
		if($('#existing-radio').is(":checked") && !$('#new-radio').is(":checked")){
			$('#new-panel').hide();
			$('#existing-panel').show();
		}
	});
	
});