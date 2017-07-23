$(document).ready(function () {

    if ($(".owl-carousel").length) {

        $('.owl-carousel').owlCarousel({
            loop: true,
            margin: 12,
            nav: false,
            autoplay: true,
            autoplayTimeout: 3000,
            autoplayHoverPause: true,
            responsive: {
                0: {
                    items: 1
                },
                600: {
                    items: 3
                },
                1000: {
                    items: 5
                }
            }
        });
    }


    if ( $( ".chack" ).length ) {
       jcf.replaceAll();
    }

   

    if ($("#carousel").length) {
        
        $("#carousel .slides a").click(function (e) {
            e.preventDefault();
            $(this).attr("href").replace("watch?v=", "v/");
            $("#main_frame").attr("src", $(this).attr("href"));
        });

        $('#carousel').flexslider({
            animation: "slide",
            controlNav: false,
            animationLoop: false,
            slideshow: false,
            touch: true,
            direction: "vertical",
            itemHeight: 210
        });
    }

    if ($('body').hasClass('page-chat')) {
        //Chat slider
        $('.flexslider').flexslider({
            animation: "slide",
            controlNav: false,
            customDirectionNav: $(".custom-navigation a"),
            itemHeight: 210,
            margin: 30,
        });
    }

    // Mobile menu button 
    $('#menu-btn').click(function () {
        $(this).toggleClass('open');
        $('#page-wrap, .header').toggleClass('push');
        $('#main-nav').toggleClass('active');
    });

    // Submenu mobile button
    $('.submenu-btn').click(function () {
        $(this).toggleClass('active').next().toggleClass('opened');
    });

    // Show vote content
    if ($(".tabs").length) {
        $('.tabs li').click(function () {
            var tab_id = $(this).attr('data-tab');

            $('ul.tabs li').removeClass('current');
            $('.tab-content').removeClass('current');

            $(this).addClass('current');
            $("#" + tab_id).addClass('current');
            if (!$('body').hasClass('page-chat')) {
                $("html, body").delay(300).animate({scrollTop: $('#details-block').offset().top}, 300);
            }
        });
    }

    // Show BUY button on click 
    $('#token-section li').click(function () {
        $('#token-section li').removeClass('active');
        $(this).addClass('active');
    });

    // Custom select 
    if ($("select").length) {
        $('select').selectric();
    }

    // Open details block one view video page
    $(".bottom .show-more").click(function (e) {
        $(this).toggleClass('active');
        $('.more-details').slideToggle();
    })

    // add Ctive class on icons - view video page
    $(".ico-wrapper a").click(function (e) {
        $(this).addClass('active');
    })

    var text_max = 400;
    $('#textarea_feedback').html(text_max + ' characters remaining');

    $('#textarea').keyup(function () {
        var text_length = $('#textarea').val().length;
        var text_remaining = text_max - text_length;

        $('#textarea_feedback').html(text_remaining + ' characters remaining');
    });

    // Close token popup
    $('#showTokens').click(function () {
        $('#token-section').addClass('opened');
    });
    // Close token popup
    $('#close-me').click(function () {
        $('#token-section').removeClass('opened');
    });

    // $(document).on("click", function(e) {
    // 	if ($(e.target).is("#token-section") === false) {
    // 		$('#token-section li').removeClass('active');
    // 	}
    // });

    // Masonry on webcam page
    if ($('.webcam-videos').length) {
        $('.webcam-videos ul').masonry({
            itemSelector: '.webcam-video',
            columnWidth: '.webcam-video',
            percentPosition: true
        });
    }

    // Filters show / hide
    $('.filters-toggle').on('click', function () {
        $(this).siblings('.filters').stop().slideToggle(200);
    });

    var $stickyWrap = $('.sticky-wrap');
    if ($stickyWrap.length) {
        var stickyOffset = $stickyWrap.offset().top;
        $('html, body').css('height', 'auto'); // probaj ovo prebaciti u css, ja nisam hteo da pokidam neshto
        // ali height: 100% smeta za skrolovanje, uopshte ne radi. A mislim da ti height 100% ne treba...
        $(window).scroll(function () {
            var winScroll = $(window).scrollTop();
            if (winScroll >= stickyOffset) {
                $stickyWrap.addClass('fixed');
            } else {
                $stickyWrap.removeClass('fixed');
            }
        });
    }
    
    $('#user').on('click', function (event) {
        if(!$('body').hasClass('side-nav-open')) {
            $('body').addClass('side-nav-open');
        }
        event.preventDefault();
    });
    
    $('.side-nav .toggle-side-nav').on('click', function (event) {
        if($('body').hasClass('side-nav-open')) {
            $('body').removeClass('side-nav-open');
        }
        event.preventDefault();
    });

});

$(window).load(function () {

    iframeDimensions();

});

$(window).resize(function () {

    iframeDimensions();

});

function iframeDimensions() {
    $('iframe').each(function () {
        var iWid = $(this).width();
        $(this).css('height', iWid * 0.56);
    });
    // obavezno u CSS-u za iframe { width: 100% !important; }

    /*--------------------------------------------------------------
     ## Equal Height
     --------------------------------------------------------------*/
    if ($(window).width() > 767) {
        var homeForm = $(".page-chat .video-view .main-info-list>li");

        var max = Math.max.apply(Math, homeForm.map(function () {
            return $(this).height();
        })
                );

        homeForm.each(function () {
            var paddingTopBottom = (max - $(this).height()) / 2;
            $(this).css({
                'padding-bottom': paddingTopBottom + 'px',
                'padding-top': paddingTopBottom + 'px'
            });
        });
    }

    // Tip popup
    $('.tip-btn').on('click', function (e) {
        $('.video-tabs').find('.tip-popup').toggleClass('tip-open');
    });

    $(document).mouseup(function (e) {
        var container = $('.tip-popup');
        if (!container.is(e.target) && container.has(e.target).length === 0) {
            $('.tip-popup').removeClass('tip-open');
        }
    });

    $(".tip-popup").on('blur', function () {
        $(this).fadeOut(300);
    });

    if ($(window).width() < 992) {
        $(".page-chat .bottom li.vote").on('click', function (e) {
            $(this).toggleClass('active');
            $('.more-rate').slideToggle('slow');
        });
    }

    // Open rate block one view video page
    //    if (!$(".page-chat .bottom li.vote").hasClass('active')) {
    //     $(".page-chat .bottom li.vote").mouseenter(function(e) {
    //        $(this).addClass('active');
    //        $('.more-rate').stop().slideDown('slow');
    //     });
    // }

    //    $(".page-chat .bottom li.vote").mouseleave(function(e) {
    //    	setTimeout(function() {
    //     $(this).removeClass('active');
    //        $('.more-rate').stop().slideUp('slow');
    //     }, 3000);
    //    });

    // if ($(".page-chat .bottom li.info").hasClass('active')) {
    // 	$(".page-chat .bottom li.vote").mouseenter(function(e) {
    //    	$(".page-chat .bottom li.vote").removeClass('active');
    //    	$('.more-rate').delay(0).slideUp();
    // });
    // }

    // tabs chat/user
    $(".page-chat .right-container .tab-link").on('click', function (e) {
        if ($(".page-chat .right-container .tab-link").first().hasClass('current')) {
            $('.page-chat').addClass('private');
            $('.page-chat .private-only').css('display', 'block');
            $('.page-chat .video-view .main-info-list > li').first().css('width', '50%');
            $('.page-chat .models-online').delay('5000').fadeOut('slow');
        } else {
            $('.page-chat').removeClass('private');
            $('.page-chat .private-only').css('display', 'none');
        }
    });

    $(".page-chat .right-container .tab-link").first().on('click', function (e) {
        if ($(".page-chat .right-container .tab-link").first().hasClass('current')) {
            $('.page-chat .overflow-box').fadeOut('slow').delay('5000');
        }
    });

    $('.chat-box .chat-popup .close-btn').on('click', function (event) {
        $('.chat-box .chat-popup').fadeOut('slow');
    });

    $('.page-chat .models-online').delay('5000').fadeOut('slow');

    // JCF
    if ($('body').hasClass('page-chat') || $('body').hasClass('page-participate')) {
        $(function () {
            jcf.replaceAll();
        });
    }


    // Fake scroll
    if ($('body').hasClass('page-chat')) {
        $('.fakeScroll').fakeScroll();
    }
    if ( $( ".fakeScroll" ).length ) {
     
        $('.fakeScroll').fakeScroll();
     
    }

    // Datepicker
        

    

    $('.filter-tag').click(function(){
        var selectedFilter = $(this).find('.value').text();
        alert(selectedFilter);
    });

    jQuery.fn.checkEmpty = function() {
       return !$.trim(this.html()).length;
    };
         
    $('.btn-small').click(function(e){


        if($(".pickedDate").checkEmpty()){
           
            console.log('empty'); 
            e.preventDefault();
        } else {
            console.log('full');    
            var selectedDate = $('.pickedDate').text();
            alert(selectedDate);

        }      

    });




    $('.filter-by a').click(function(){
        var tab_id = $(this).attr('data-tab');

        $('.filter-by a').removeClass('current');
        $('.filter-content').removeClass('current');

        $(this).addClass('current');
        $("#"+tab_id).addClass('current');
    })

    $(".sort-options > ul > li ").click(function (e) {
        if( $(this).hasClass('active-btn') ){
              $(this).toggleClass('active-btn').find('.option-block.active ').slideUp().removeClass('active');
        } else {
            $(".sort-options > ul > li.active-btn").removeClass('active-btn');
            $('.option-block.active ').slideUp().removeClass('active');
            $(this).toggleClass('active-btn').find('.option-block ').slideToggle().toggleClass('active');
        }
      
       $('[data-toggle="datepicker"]').focus();
    });

    $(document).mouseup(function(e) 
    {
        var container = $(".sort-options");

        // if the target of the click isn't the container nor a descendant of the container
        if (!container.is(e.target) && container.has(e.target).length === 0) 
        {
            $(".sort-options > ul > li.active-btn").removeClass('active-btn');
            $('.option-block.active ').slideUp().removeClass('active');
        }
    });

    // Check screen size
    function screenClass() {
        if($(window).innerWidth() > 1024) {
            $('body').addClass('big-screen').removeClass('small-screen');
        } else {
            $('body').addClass('small-screen').removeClass('big-screen');
        }
    }

    screenClass();

    // And recheck when window gets resized.
    $(window).bind('resize',function(){
        screenClass();
    });


    $('.video-item').each(function(index, element) {

        var isPaused = true;   // New variable
        var initialFadeIn = 300;
        var itemInterval = 800;
        var fadeTime = 300;
        var numberOfItems = $(this).find('.rollme').length;
        var currentItem = 0;
        var target =  $(this).find('.rollme');

        target.mouseenter(function () { // Mouse over slider, pause
           
        }).mouseleave(function () { // mouse out of slider, unpause
           
        });


       target.hover(function() {
            isPaused = false;
        }, function(){
             isPaused = true;
        });

        target.eq(currentItem).fadeIn(initialFadeIn);

        var infiniteLoop = setInterval(function () {
            if (!isPaused) { // only run if not paused
                target.eq(currentItem).fadeOut(fadeTime);
                if (currentItem == numberOfItems - 1) {
                    currentItem = 0;
                } else {
                    currentItem++;
                }
               target.eq(currentItem).fadeIn(fadeTime);
            }
        }, itemInterval);

    });


    // LOGIN / SIGN IN
    var loginChecker = true;
    var signinChecker = false;

    if (loginChecker == true){
       $('.main-popup').addClass('active');
        $(' #sign-up').show();
    }
    if (signinChecker == true){
        $('.main-popup').addClass('active');
        $(' #sign-in').show();
    }
    $('#login-btn').click(function(){
        $('.main-popup').addClass('active');
        $(' #sign-up').show();
    });
   
    // Go from LOGIN to SIGN IN
    $('#showSignIn').click(function(){
        $('#sign-up').hide();
        $('#sign-in').show();
    });
    $('.close-me').click(function(){
        $(this).parent().hide();
        $('.main-popup').removeClass('active');
    });

    // TEST links 
    var roomItems = $('.room-navigation > li');

    $(".room-links a").click(function () {
        var theID  = $(this).data("id");
        var selectedRoom = $(this).text();

        $('.selected-room').text(selectedRoom);

        roomItems.removeClass('active');
        roomItems.filter(function() {
            return $(this).data('room') === theID;
        }).addClass('active');

    });
}