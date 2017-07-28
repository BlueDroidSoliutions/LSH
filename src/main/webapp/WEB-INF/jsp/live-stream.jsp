<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js ie6"> <![endif]-->
<!--[if IE 7]>         <html class="no-js ie7"> <![endif]-->
<!--[if IE 8]>         <html class="no-js ie8"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
        <link href="${location}favicon.ico" rel="icon" />
        <title>LiveStream</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,700" rel="stylesheet">
        <link rel="stylesheet" href="${location}/assets/css/lib/jcf.css">
        <link rel="stylesheet" href="${location}/assets/css/lib/fakeScroll.css">
        <link rel="stylesheet" href="${location}/assets/css/style.css">
        <script type="text/javascript" src="${location}/assets/scripts/libs/modernizr.2.8.3.min.js"></script>
    </head>
    <body>
       <%@include file="sign.jsp" %>
<div class="container full-screen-height">
<%@include file="menu.jsp" %>

            <div id="page-wrap">
                <div class="content">
                    <div class="wrapper">
                        <div class="livestream clearfix">
                            <div class="stream-rooms">
                               <!--  <img src="${location}/assets/img/content/housemap.svg" alt="House Map" class="housemap"> -->
                               <div class="room-links">

                                    <a href="javascript:;" data-id="kitchen">Kitchen</a>
                                    <a href="javascript:;" data-id="gym">Gym</a>
                                    <a href="javascript:;" data-id="buffet">Buffet</a>
                                    <a href="javascript:;" data-id="entry">Entry</a>
                                    <a href="javascript:;" data-id="sauna">Sauna</a>
                                    <a href="javascript:;" data-id="shower">Shower</a>
                                    <a href="javascript:;" data-id="bedroom">Bedroom</a>
                               </div>
                              
                                <span class="selected-room">Entry</span>
                                <ul class="room-navigation">
                                    <li data-room="kitchen">
                                        <a href="javascript:;"><span>Kitchen</span></a>
                                        <ul>
                                            <li>
                                                <a href="javascript:;">Camera IP</a>
                                            </li>
                                            <li>
                                                <a href="javascript:;">Camera PTZ</a>
                                            </li>
                                        </ul>
                                    </li>
                                    <li data-room="gym">
                                        <a href="javascript:;"><span>Gym</span></a>
                                        <ul>
                                            <li>
                                                <a href="javascript:;">Camera IP</a>
                                            </li>
                                            <li>
                                                <a href="javascript:;">Camera PTZ</a>
                                            </li>
                                        </ul>
                                    </li>
                                    <li data-room="buffet">
                                        <a href="javascript:;"><span>Buffet</span></a>
                                        <ul>
                                            <li>
                                                <a href="javascript:;">Camera IP</a>
                                            </li>
                                            <li>
                                                <a href="javascript:;">Camera PTZ</a>
                                            </li>
                                        </ul>
                                    </li>
                                    <li data-room="entry">
                                        <a href="javascript:;"><span>Entry</span></a>
                                        <ul>
                                            <li>
                                                <a href="javascript:;">Camera IP</a>
                                            </li>
                                            <li>
                                                <a href="javascript:;">Camera PTZ</a>
                                            </li>
                                        </ul>
                                    </li>
                                    <li data-room="sauna">
                                        <a href="javascript:;"><span>Sauna</span></a>
                                        <ul>
                                            <li>
                                                <a href="javascript:;">Camera IP</a>
                                            </li>
                                            <li>
                                                <a href="javascript:;">Camera PTZ</a>
                                            </li>
                                        </ul>
                                    </li>
                                    <li data-room="shower">
                                        <a href="javascript:;"><span>Shower</span></a>
                                        <ul>
                                            <li>
                                                <a href="javascript:;">Camera IP</a>
                                            </li>
                                            <li>
                                                <a href="javascript:;">Camera PTZ</a>
                                            </li>
                                        </ul>
                                    </li>
                                    <li data-room="bedroom">
                                        <a href="javascript:;"><span>Bedroom</span></a>
                                        <ul>
                                            <li>
                                                <a href="javascript:;">Camera IP</a>
                                            </li>
                                            <li>
                                                <a href="javascript:;">Camera PTZ</a>
                                            </li>
                                        </ul>
                                    </li>
                                </ul>
                            </div>
                            <div class="stream-main clearfix">
                                <div class="stream-video">
                                    <img src="${location}/assets/img/content/stream-preview.jpg" alt="Preview">
                                    <a class="overlay" href="javascript:;"></a>
                                </div>
                                <a href="javascript:;" class="sex-cam">Live Sex Cam <span>with housemates</span></a>
                                <div class="vote-section">
                                    <div class="inner">
                                        <div class="heading">
                                            <h3>Vote rate</h3>
                                            <p>Top 4</p>
                                        </div>
                                        <ul class="vote-list">
                                            <li>
                                                <span class="number-of-votes">87</span>
                                                <a href="javascript:;">
                                                    <span class="vote"><span>Vote</span></span>
                                                    <img src="${location}/assets/img/content/profile-s.png" alt="">
                                                </a>
                                                <span class="name">Christine</span>
                                            </li>
                                            <li>
                                                <span class="number-of-votes">87</span>
                                                <a href="javascript:;">
                                                    <span class="vote"><span>Vote</span></span>
                                                    <img src="${location}/assets/img/content/profile-s.png" alt="">
                                                </a>
                                                <span class="name">Christine</span>
                                            </li>
                                            <li>
                                                <span class="number-of-votes">87</span>
                                                <a href="javascript:;">
                                                    <span class="vote"><span>Vote</span></span>
                                                    <img src="${location}/assets/img/content/profile-s.png" alt="">
                                                </a>
                                                <span class="name">Christine</span>
                                            </li>
                                            <li>
                                                <span class="number-of-votes">87</span>
                                                <a href="javascript:;">
                                                    <span class="vote"><span>Vote</span></span>
                                                    <img src="${location}/assets/img/content/profile-s.png" alt="">
                                                </a>
                                                <span class="name">Christine</span>
                                            </li>
                                            <li>
                                                <span class="number-of-votes">87</span>
                                                <a href="javascript:;">
                                                    <span class="vote"><span>Vote</span></span>
                                                    <img src="${location}/assets/img/content/profile-s.png" alt="">
                                                </a>
                                                <span class="name">Christine</span>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div class="stream-aside">
                                <div class="chat-section">
                                    <div class="chat-box">
                                        <div class="chat-box-middle">
                                            <div class="chat-content">
                                                <div class="fakeScroll">
                                                    <h3>Users Chat</h3>
                                                    <p>Person one :Text chat lorem ipsum</p>
                                                    <p>Person two : Lorem ipsum dolor amet sum hogno akverila bilde opsum ivei.</p>
                                                    <p>Person Tree: LAMEEE</p>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="chat-box-bottom">
                                            <input type="text" placeholder="Send a message...">
                                            <a href="javascript:;">Send</a>
                                        </div>
                                    </div>
                                </div>
                                <div class="live-web-chat">
                                    <a href="javascript:;">Live Now Web Chat <span>View all</span></a>
                                    <img src="${location}/assets/img/content/live-chat.png" alt="live chat">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <footer class="footer">
                    <div class="wrapper">
                        <div class="banner">
                            <img src="${location}/assets/img/o2.jpg" alt="">
                        </div>
                        <p>The site contains sexually explictit material. Enter only if you are at least 18 years old and agree to our cookie rools.</p>
                        <p>Live Sex House - All Rights Reserved 2017.</p>
                    </div>
                </footer>
            </div>
        </div>


        <!-- javascript -->
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
        <script type="text/javascript">window.jQuery || document.write("<script src='${location}/assets/scripts/main/jquery-1.8.3.min.js'>\x3C/script>")</script>
        <script type="text/javascript" src="${location}/assets/scripts/libs/jquery.flexslider-min.js"></script>
        <script type="text/javascript" src="${location}/assets/scripts/libs/jQuery.fakeScroll.js"></script>
        <script type="text/javascript" src="${location}/assets/scripts/libs/jcf.js"></script>
        <script type="text/javascript" src="${location}/assets/scripts/libs/jcf.range.js"></script>
        <script type="text/javascript" src="${location}/assets/scripts/main/default.js"></script>

        <!--[if lt IE 7]>
           <p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
       <![endif]-->

    </body>
</html>
