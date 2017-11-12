$('#firstfieldsetbutton').click(function() {
	$('#firstfieldset').fadeOut();
	$('#secondfieldset').fadeIn();

});

$('#secondfieldsetbutton').click(function() {
	$('#secondfieldset').fadeOut();
	$('#firstfieldset').fadeIn();

});

$('#skipcard').click(function() {
	$('#secondfieldset').fadeOut();
	$('#firstfieldset').fadeIn();
});

$('#submitform').click(function() {
	$('#secondfieldset').fadeOut();
	$('#firstfieldset').fadeIn();
});

$('.nav-options').click(function() {
		$('.nav-options').removeClass("navOpt-Selected");
	  $( this ).addClass( "navOpt-Selected" );
});

$('#visa').click(function() {
	$("#mc").css("border-color","transparent");
	$('#visa').css("border","solid 3px #0c99d1");
});

$('#mc').click(function() {
	$("#visa").css("border-color","transparent");
	$('#mc').css("border","solid 3px #0c99d1");
});