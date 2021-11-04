// JavaScript Document
(function(){
    var link,toggleScrollToTopLink=function(){
        if($('body').scrollTop()>0||$('html').scrollTop()>0){
            link.fadeIn(1000);
        }else{
            link.fadeOut(1000);
        }
    };
    $(document).ready(function() {
        link=$('.scroll-to-top');
        $(window).scroll(toggleScrollToTopLink);
        toggleScrollToTopLink();
        link.on('click',function(){
            $('body').animate({scrollTop:0});
            $('html').animate({scrollTop:0});
        });
    });
})();