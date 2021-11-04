$(document).ready(function(){
	
	var nav=$(".menu");
	var banner=$(".header").has('img');
	var pos=nav.position();
	$(window).scroll(function(){
		var windowpos=$(window).scrollTop();
		if(windowpos>=banner.outerHeight()){
			nav.addClass('fixed');
		}else{
			nav.removeClass('fixed');
		}
		});
	
	});// JavaScript Document