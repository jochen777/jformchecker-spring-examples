// Start of a js lib for formchecker.

FormCheckerAjax.prototype = {
    constructor: FormCheckerAjax,
    saveScore:function (theScoreToAdd)  {
        this.quizScores.push(theScoreToAdd)
    },


    processJson: function (data)  { 
	 highlightErrors(data.data);
	 setOkFields(data.okdata);
 
	    if (data.status == "success") {
	    	alert('ok');
	    } 
    } 
 
function highlightErrors(data) {
	for (var elemName in data) {
		var elemDiv = $('#form_'+elemName).parent().parent();
		resetCSSField(elemDiv);
		elemDiv.addClass( "has-error");
	}
}
function setOkFields(data) {
	for (var elemName in data) {
		var elemDiv = $('#form_'+elemName).parent().parent();
		resetCSSField(elemDiv);
		elemDiv.addClass( "has-success");
	}
}
function resetCSSField(field) {
	field.removeClass("has-error");
	field.removeClass("has-success");
}

// wait for the DOM to be loaded 
$(document).ready(function() { 
	
	var options = { 
	        success:       processJson,  // post-submit callback 
	 
	        url:       'ajax_receive',         // override for form's 'action' attribute 
	        dataType: 'json'
	    }; 
	
   $('#form_example').ajaxForm(options); 
   

}); 
}
