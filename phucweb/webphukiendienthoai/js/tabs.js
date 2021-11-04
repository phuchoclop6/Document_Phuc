// JavaScript Document
$(function(){
	$('.tabs_panel .tabs li').on('click',function(){
		$('.tabs_panel li.active').removeClass('active');
			$(this).addClass('active'); 
                
           
		var paneltoshow=$(this).attr('rel');
		$('.tabs_panel .panel.active').slideUp(300,function(){
			$(this).removeClass('active');
			$('#'+paneltoshow).slideDown(300,function(){
				$(this).addClass('active');
				});
			
		});
	
	});
	});