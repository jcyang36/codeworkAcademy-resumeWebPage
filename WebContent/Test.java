$(document).ready(function(){
	$('#myform').bootstrapValidator({
		fields:{
			firstName:{
				validators:{
					notEmpty:{
						message:'Please supply your first name'
					}
				}
			}
		}
	})
}
		
	
		)
		
		$('#myform').data('bootstrapValidator').resetForm();

            // Prevent form submission
            e.preventDefault();

            // Get the form instance
            var $form = $(e.target);

            // Get the BootstrapValidator instance
            var bv = $form.data('bootstrapValidator');

            // Use Ajax to submit form data
            $.post($form.attr('action'), $form.serialize(), function(result) {
                console.log(result);
            }, 'json');