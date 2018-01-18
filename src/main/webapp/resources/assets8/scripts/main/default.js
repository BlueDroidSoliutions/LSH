$(document).ready(function () {

    // Custom select
    if ($("select" ).not('.vjs-modal-dialog select').length > 0) { 
        console.log('1');
       $("select").selectric();
    }


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
                    items: 4
                }
            }
        });
    }

    if ($("#r-slider").length) {

        var handlesSlider = document.getElementById('r-slider');

        noUiSlider.create(handlesSlider, {
            start: [ 50 ],
            connect: "lower",
            range: {
                'min': [  20 ],
                'max': [ 100 ]
            }
        });

        var inputFormat = document.getElementById('input-format');

        handlesSlider.noUiSlider.on('update', function( values, handle ) {
            inputFormat.value = values[handle];
        });

        inputFormat.addEventListener('change', function(){
            handlesSlider.noUiSlider.set(this.value);
        });
    }



    if ( $( ".chack" ).length ) {
       jcf.replaceAll();
    }

    if ( $( "#msform" ).length ) {
       jcf.replaceAll();
    }

    // Custom textarea scrollbar
    if ($('.textarea-scrollbar').length){
        $('.textarea-scrollbar').scrollbar();
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

        $('.more-rate a').click(function () {
            $('.more-rate a.active').removeClass('active');
            $(this).addClass('active').prevAll().addClass('active');
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

        if(text_remaining < 0){
            $('#textarea_feedback').addClass('alertMe');
        } else {
            $('#textarea_feedback').removeClass('alertMe');
        }
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

    if ($( ".scrollContent" ).length ) {
     
        $(".scrollContent").animate({ scrollTop: $('.scrollContent')[0].scrollHeight}, 1000);
     
    }
   

    function checkDOMChange()
    {
        // check for any new element being inserted here,
        // or a particular node being modified

        // call the function again after 100 milliseconds
        $(".scrollContent").animate({ scrollTop: $('.scrollContent')[0].scrollHeight}, 1000);
        setTimeout( checkDOMChange, 100 );
    }
});

$(window).resize(function () {

    iframeDimensions();

});

function iframeDimensions() {
    $('video').each(function () {
        var iWid = $(this).width();
        $(this).css('height', iWid * 0.56);
    });

     $('iframe').each(function () {
        var iFrame = $(this).width();
        $(this).css('height',  iFrame * 0.56);
    });
    // obavezno u CSS-u za iframe { width: 100% !important; }

    /*--------------------------------------------------------------
     ## Equal Height
     --------------------------------------------------------------*/
    // if ($(window).width() > 767) {
    //     var homeForm = $(".page-chat .video-view .main-info-list>li");

    //     var max = Math.max.apply(Math, homeForm.map(function () {
    //         return $(this).height();
    //     })
    //             );

    //     homeForm.each(function () {
    //         var paddingTopBottom = (max - $(this).height()) / 2;
    //         $(this).css({
    //             'padding-bottom': paddingTopBottom + 'px',
    //             'padding-top': paddingTopBottom + 'px'
    //         });
    //     });
    // }

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
            // $('.page-chat .video-view .main-info-list > li').first().css('width', '50%');
            // $('.page-chat .models-online').delay('5000').fadeOut('slow');
        } else {
            $('.page-chat').removeClass('private');
            // $('.page-chat .private-only').css('display', 'none');
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

    // $('.page-chat .models-online').delay('5000').fadeOut('slow');

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


    $('.filter-by a').click(function(e){
        var tab_id = $(this).attr('data-tab');

        $('.filter-by a').removeClass('current');
        $('.filter-content').removeClass('current');

        $(this).addClass('current');
        $("#"+tab_id).addClass('current');

        localStorage.setItem('activeTab', $(e.target).attr('data-tab'));
    })

    var activeTab = localStorage.getItem('activeTab');
    console.log(activeTab);

    if (activeTab) {
       $('a[data-tab="' + activeTab + '"]').trigger('click');
    }


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

    $('.video-item').each(function(index, element) {

        var isPaused = false;   // New variable
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
    if ($('#my_video_1').length > 0) { 
        var player = videojs('my_video_1');
        player.play();

        videojs("my_video_1", {}, function(){
            console.log('ready');
             $(".vjs-big-play-button").trigger('click');    
        });
    }
        

    $('.room-navigation a').click(function () {
        var linkValue = $(this).attr("data-link");
        console.log(linkValue);
        document.getElementById('my_video_1_html5_api').src = linkValue;
    });


    // LOGIN / SIGN IN
       // var loginChecker = false;
       // var signinChecker = false;
       // var emailTaken = false;
       // var usernameTaken = false;
       // var wrongPassword = false;
       // var wrongUsername = false;
       // var checkEmail = false;
       // var alredySigned = false;
       // var thanksReg = false;
       // var serverOff = false;
       // var emptyField = false;
//        
        var serverOffMsg = "server vill be.. bla bla bla";

     if (loginChecker == true) {
         $('.main-popup').addClass('active');
         $(' #sign-up').show();
     }
     if (signinChecker == true) {
         $('.main-popup').addClass('active');
         $(' #sign-in').show();
     }
     if (emailTaken == true) {
         $('.main-popup .inner-wrapper').prepend("<p>Email is taken by another account</p>");
         $('.main-popup').addClass('active');
         $(' #sign-up').show();
     }
     if (wrongPassword == true) {
         $('.main-popup .inner-wrapper').prepend("<p>Wrong username or password</p>")
     }
     if (wrongUsername == true) {
         $('.main-popup .inner-wrapper').prepend("<p>Wrong username or password</p>")
     }
     if (usernameTaken == true) {
         $('.main-popup .inner-wrapper').prepend("<p>This username is already taken by another user</p>");
         $('.main-popup').addClass('active');
         $(' #sign-up').show();
     }

     if (thanksReg == true) {
         $('.main-popup .inner-wrapper').prepend("<p>Thank you for verification, please </p>")
     }

     if (emptyField == true) {
         $('.main-popup .inner-wrapper').prepend("<p>Empty field </p>");
         $('.main-popup').addClass('active');
         $(' #sign-up').show();
     }


     if (checkEmail == true) {
         $('.main-popup').addClass('active');
         $('.main-popup .inner-wrapper').prepend("<p>Please check your E-Mail</p>");
         $(' #sign-in').show();
         $(' #sign-up').hide();
         $(' #showCreate').hide();
         $(' #dont').hide();
         $(' .inner-wrapper h2').hide();
         $(' #name').hide();
         $(' #password').hide();
         $(' .btn').hide();
     }


    if (serverOff == true) {
        $('.main-popup').addClass('active');
        $('.main-popup .popup-wrapper').prepend("<p>" + serverOffMsg + "</p>");
        $(' #sign-in').hide();
        $(' #sign-up').hide();
        
    }






    $('#login-btn').click(function () {
        $('.main-popup').addClass('active');
        if (alredySigned == true) {
            $('#sign-up').hide();
            $('#sign-in').show();
        } else if (checkEmail == true) {
            $('.main-popup').addClass('active');
            $(' #sign-in').show();
            $(' #sign-up').hide();
            $(' #showCreate').hide();
            $(' #dont').hide();
            $(' .inner-wrapper h2').hide();
            $(' #name').hide();
            $(' #password').hide();
            $(' .btn').hide();
        } else {
            $('#sign-up').show();
            $('#sign-in').hide();
        }
    });

    // Go from LOGIN to SIGN IN
    $('#showSignIn').click(function () {
        $('#sign-up').hide();
        $('#sign-in').show();
    });
    $('#showCreate').click(function () {
        $('#sign-up').show();
        $('#sign-in').hide();
    });


    $('.close-me').click(function () {
        $(this).parent().hide();
        $('.main-popup').removeClass('active');
    });




    $(".heroIner .button").click(function(){
        $('.modelHero').addClass('active');
        $('#msform').addClass('active');
    });



    //------------------ Models page 

    // Models wanted step form

    var current_fs, next_fs, previous_fs; //fieldsets
    var left, opacity, scale; //fieldset properties which we will animate
    var animating; //flag to prevent quick multi-click glitches

    $(".next").click(function(){
      
        if(animating) return false;
        animating = true;
        
        current_fs = $(this).parent();
        next_fs = $(this).parent().next();
        
        //activate next step on progressbar using the index of next_fs
        $("#progressbar li").eq($("fieldset").index(next_fs)).addClass("active");
        
        //show the next fieldset
        next_fs.show(); 
        //hide the current fieldset with style
        current_fs.animate({opacity: 0}, {
            step: function(now, mx) {
                //as the opacity of current_fs reduces to 0 - stored in "now"
                //1. scale current_fs down to 80%
                scale = 1 - (1 - now) * 0.2;
                //2. bring next_fs from the right(50%)
                left = (now * 50)+"%";
                //3. increase opacity of next_fs to 1 as it moves in
                opacity = 1 - now;
                current_fs.css({
            'transform': 'scale('+scale+')',
            'position': 'absolute'
          });
                next_fs.css({'left': left, 'opacity': opacity});
            }, 
            duration: 1500, 
            complete: function(){
                current_fs.hide();
                animating = false;
            }, 
            //this comes from the custom easing plugin
            easing: 'easeInOutBack'
        });
          $('html, body').animate({scrollTop:0}, 'slow');
    });

    $(".previous").click(function(){
        if(animating) return false;
        animating = true;
        
        current_fs = $(this).parent();
        previous_fs = $(this).parent().prev();
        
        //de-activate current step on progressbar
        $("#progressbar li").eq($("fieldset").index(current_fs)).removeClass("active");
        
        //show the previous fieldset
        previous_fs.show(); 
        //hide the current fieldset with style
        current_fs.animate({opacity: 0}, {
            step: function(now, mx) {
                //as the opacity of current_fs reduces to 0 - stored in "now"
                //1. scale previous_fs from 80% to 100%
                scale = 0.8 + (1 - now) * 0.2;
                //2. take current_fs to the right(50%) - from 0%
                left = ((1-now) * 50)+"%";
                //3. increase opacity of previous_fs to 1 as it moves in
                opacity = 1 - now;
                current_fs.css({'left': left});
                previous_fs.css({'transform': 'scale('+scale+')', 'opacity': opacity});
            }, 
            duration: 1500, 
            complete: function(){
                current_fs.hide();
                animating = false;
            }, 
            //this comes from the custom easing plugin
            easing: 'easeInOutBack'
        });
    });

    $(".submit").click(function(){
        return false;
    })

    $(function() {
        if ($('#thefiles').length > 0) { 
            $('#thefiles').FancyFileUpload({
                params : {
                    action : 'fileuploader'
                },
                maxfilesize : 1000000
            });

            $('#frontpage, #backpage, #snapshot, #snapshotID').FancyFileUpload({
                params : {
                    action : 'fileuploader'
                },
                maxfilesize : 1000000
            });
        }

    });       
}