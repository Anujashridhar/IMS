
$(document).ready(function () {
	
	// add and remove button
	$(document).on('click', '.btn-add', function(e)
		    {debugger;
		    	 alert("nitin"); 
		        e.preventDefault();
				
		        var controlForm = $('.controls form:first'),
		            currentEntry = $(this).parents('.entry:first'),
		            newEntry = $(currentEntry.clone()).appendTo(controlForm);
		        newEntry.find('input').val('');
		        controlForm.find('.entry:not(:last) .btn-add')
		            .removeClass('btn-add').addClass('btn-remove fa fa-close')
		            .removeClass('btn-success').addClass('btn-danger')
		            .html('<span class="glyphicon glyphicon-minus"></span>');
		    }).on('click', '.btn-remove', function(e)
		    {
				$(this).parents('.entry:first').remove();

				e.preventDefault();
				return false;
			});
	
    //Initialize tooltips
    $('.nav-tabs > li a[title]').tooltip();
    
    ///according menu
    $('a[data-toggle="tab"]').on('show.bs.tab', function (e) {

        var $target = $(e.target);
    
        if ($target.parent().hasClass('disabled')) {
            return false;
        }
    });

    $(".next-step").click(function (e) {

        var $active = $('.wizard .nav-tabs li.active');
        $active.next().removeClass('disabled');
        nextTab($active);

    });
    $(".prev-step").click(function (e) {

        var $active = $('.wizard .nav-tabs li.active');
        prevTab($active);

    });
});

function nextTab(elem) {
    $(elem).next().find('a[data-toggle="tab"]').click();
}
function prevTab(elem) {
    $(elem).prev().find('a[data-toggle="tab"]').click();
}
	// tab
	 //Add Inactive Class To All Accordion Headers
    $('.accordion-header').toggleClass('inactive-header');
	
	//Set The Accordion Content Width
	var contentwidth = $('.accordion-header').width();
	$('.accordion-content').css({});
	
	//Open The First Accordion Section When Page Loads
	$('.accordion-header').first().toggleClass('active-header').toggleClass('inactive-header');
	$('.accordion-content').first().slideDown().toggleClass('open-content');
	
	// The Accordion Effect
	$('.accordion-header').click(function () {
		if($(this).is('.inactive-header')) {
			$('.active-header').toggleClass('active-header').toggleClass('inactive-header').next().slideToggle().toggleClass('open-content');
			$(this).toggleClass('active-header').toggleClass('inactive-header');
			$(this).next().slideToggle().toggleClass('open-content');
		}
		
		else {
			$(this).toggleClass('active-header').toggleClass('inactive-header');
			$(this).next().slideToggle().toggleClass('open-content');
		}
	});
	var room = 1;
	function education_fields() {
	 
	    room++;
	    var objTo = document.getElementById('education_fields')
	    var divtest = document.createElement("div");
		divtest.setAttribute("class", "form-group removeclass"+room);
		var rdiv = 'removeclass'+room;
	    divtest.innerHTML = '<div class="col-sm-2 nopadding" id="submenu_div_'+room+'">'
	    							+'<div class="form-group">'
	    							+'<input type="text" class="form-control" id="degreename" name="degreename" value="" placeholder="Certificate / Degree Name">'
	    							+'</div></div>'
	    							+'<div class="col-sm-2 nopadding">'
	    							+'<div class="form-group">'
	    							+'<input type="text" class="form-control" id="Rollno" name="Rollno" value="" placeholder="Roll no">'
	    							+'</div></div>'
	    							+'<div class="col-sm-2 nopadding">'
	    							+'<div class="form-group">'
	    							+'<input type="text" class="form-control" id="Passingyear" name="passingyear" value="" placeholder="Passing Year">'
	    							+'</div></div>'
	    							+'<div class="col-sm-2 nopadding">'
	    							+'<div class="form-group">'
	    							+'<input type="text" class="form-control" id="markobtained" name="markobtained" value="" placeholder="Mark Obtained">'
	    							+'</div></div>'
	    							+'<div class="col-sm-2 nopadding"><div class="form-group">'
	    							+'<input type="text" class="form-control" id="percentage" name="percentage" value="" placeholder="%age / CGPA">'
	    							+'</div></div>'
	    							+'<div class="col-sm-2 nopadding"><div class="form-group"><div class="input-group"><div class="form-group">'
	    							+'<input type="text" class="form-control" id="board" name="board" value="" placeholder="Board">'
	    							+'</div>'
	    							+'<div class="input-group-btn"> '
	    							+'<button class="btn btn-danger" type="button" id="'+room+'" onclick="remove_education_fields('+ room +');">'
	    							+'<span class="glyphicon glyphicon-minus" aria-hidden="true"></span> </button>'
	    							+'</div></div></div></div><div class="clear"></div>';
		//divtest.innerHTML = '<div class="col-sm-2 nopadding"><div class="form-group"><input type="text" class="form-control" id="degreename" name="degreename" value="" placeholder="Certificate / Degree Name"></div></div><div class="col-sm-2 nopadding"><div class="form-group"><input type="text" class="form-control" id="Rollno" name="Rollno" value="" placeholder="Roll no"></div></div><div class="col-sm-2 nopadding"><div class="form-group"><input type="text" class="form-control" id="Passingyear" name="passingyear" value="" placeholder="Passing Year"></div></div><div class="col-sm-2 nopadding"> <div class="form-group"><input type="text" class="form-control" id="markobtained" name="markobtained" value="" placeholder="Mark Obtained"></div></div><div class="col-sm-2 nopadding"><div class="form-group"><input type="text" class="form-control" id="percentage" name="percentage" value="" placeholder="%age / CGPA"></div><div class="col-sm-2 nopadding"><div class="form-group"><div class="input-group"><div class="form-group"><input type="text" class="form-control" id="board" name="board" value="" placeholder="Board"></div><div class="input-group-btn"><button class="btn btn-success" type="button"  onclick="education_fields();"> <span class="glyphicon glyphicon-plus" aria-hidden="true"></span> </button></div></div></div></div>';
	    objTo.appendChild(divtest)
	}
	   function remove_education_fields(rid){
		   $('.removeclass'+rid).remove();
	   }

	//return false;
	


