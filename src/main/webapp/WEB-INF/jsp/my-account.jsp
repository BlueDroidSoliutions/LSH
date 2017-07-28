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
        <title>LiveSexHouse</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
    
        <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,700" rel="stylesheet">
        <link rel="stylesheet" href="${location}/assets/css/lib/fakeScroll.css">
        <link rel="stylesheet" href="${location}/assets/css/style.css">
        <script type="text/javascript" src="${location}/assets/scripts/libs/modernizr.2.8.3.min.js"></script>
    </head>
    <body>
        <div class="side-nav fakeScroll">
            <div class="head-section">
                <div class="top clearfix">
                    <h3>My Account</h3>
                    <a href="#toggle-side-nav" class="toggle-side-nav">
                        <span></span>
                        <span></span>
                        <span></span>
                    </a>
                </div>
                <div class="user clearfix">
                    <div class="info">
                        <span class="name">Heyman Oly</span>
                        <span class="membership">Regular</span>
                        <div class="tokens">
                            <span>
                                <svg version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
                                     width="26px" height="26px" viewBox="0 0 25.773 25.49" enable-background="new 0 0 25.773 25.49" xml:space="preserve">
                                <path fill="#FFFFFF" d="M18.52,7.865c0,1.13-2.541,2.047-5.677,2.047c-3.135,0-5.677-0.917-5.677-2.047s2.542-2.047,5.677-2.047
                                      C15.979,5.818,18.52,6.735,18.52,7.865"/>
                                <path fill="#FFFFFF" d="M7.166,10.718v2.605c0,0,5.528,3.213,11.354,0v-2.667C18.52,10.656,13.811,13.906,7.166,10.718"/>
                                <path fill="#FFFFFF" d="M7.166,15.557v2.604c0,0,5.528,3.213,11.354,0v-2.667C18.52,15.495,13.811,18.745,7.166,15.557"/>
                                <path fill="none" stroke="#FFFFFF" stroke-width="1.533" stroke-miterlimit="10" d="M12.864,1.07
                                      c6.449,0,11.676,5.227,11.676,11.675"/>
                                <path fill="none" stroke="#FFFFFF" stroke-width="1.533" stroke-miterlimit="10" d="M1.189,12.745
                                      c0-6.448,5.227-11.675,11.675-11.675"/>
                                <path fill="none" stroke="#FFFFFF" stroke-width="1.533" stroke-miterlimit="10" d="M12.864,24.42
                                      c-6.448,0-11.675-5.228-11.675-11.676"/>
                                <path fill="none" stroke="#FFFFFF" stroke-width="1.533" stroke-miterlimit="10" d="M24.54,12.745
                                      c0,6.448-5.228,11.676-11.676,11.676"/>
                                </svg>
                            </span>
                            <span class="number">258</span>
                        </div>
                    </div>
                    <div class="image">
                        <div class="img-wrapper">
                            <img src="${location}/assets/img/content/user-image.png" alt="">
                        </div>
                        <a href="#additional-links" class="additional-links">
                            <img src="${location}/assets/img/additional-links.png" alt="">
                        </a>
                    </div>
                </div>
            </div>
            <div class="actions">
                <div class="info-box">
                    <span class="icon"></span>
                    <div class="info-content">
                        <span class="title">Member status:</span>
                        <span>Regular</span>
                    </div>
                </div>
                <div class="info-box">
                    <span class="icon"></span>
                    <div class="info-content">
                        <span class="title">Member since:</span>
                        <span>12/22/2017</span>
                    </div>
                </div>
                <div class="info-box">
                    <span class="icon">
                        <svg version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
                             width="26px" height="26px" viewBox="0 0 25.773 25.49" enable-background="new 0 0 25.773 25.49" xml:space="preserve">
                        <path fill="#FFFFFF" d="M18.52,7.865c0,1.13-2.541,2.047-5.677,2.047c-3.135,0-5.677-0.917-5.677-2.047s2.542-2.047,5.677-2.047
                              C15.979,5.818,18.52,6.735,18.52,7.865"/>
                        <path fill="#FFFFFF" d="M7.166,10.718v2.605c0,0,5.528,3.213,11.354,0v-2.667C18.52,10.656,13.811,13.906,7.166,10.718"/>
                        <path fill="#FFFFFF" d="M7.166,15.557v2.604c0,0,5.528,3.213,11.354,0v-2.667C18.52,15.495,13.811,18.745,7.166,15.557"/>
                        <path fill="none" stroke="#FFFFFF" stroke-width="1.533" stroke-miterlimit="10" d="M12.864,1.07
                              c6.449,0,11.676,5.227,11.676,11.675"/>
                        <path fill="none" stroke="#FFFFFF" stroke-width="1.533" stroke-miterlimit="10" d="M1.189,12.745
                              c0-6.448,5.227-11.675,11.675-11.675"/>
                        <path fill="none" stroke="#FFFFFF" stroke-width="1.533" stroke-miterlimit="10" d="M12.864,24.42
                              c-6.448,0-11.675-5.228-11.675-11.676"/>
                        <path fill="none" stroke="#FFFFFF" stroke-width="1.533" stroke-miterlimit="10" d="M24.54,12.745
                              c0,6.448-5.228,11.676-11.676,11.676"/>
                        </svg>
                        <span>258</span>
                    </span>
                    <div class="info-content">
                        <span>Tokens 258</span>
                        <ul>
                            <li>
                                <a href="javascript:;">Buy</a>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="outline">
                    <div class="info-box">
                        <span class="icon">
                            <svg version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" width="23.583px" height="22.417px" viewBox="0 0 23.583 22.417" enable-background="new 0 0 23.583 22.417" xml:space="preserve">
                            <polygon fill="#fff" points="11.8,17.815 18.732,22 16.892,14.114 23.018,8.809 14.952,8.125 11.8,0.688 8.648,8.125 0.584,8.809 6.708,14.114 4.868,22 "></polygon>
                            </svg>
                        </span>
                        <div class="info-content">
                            <a href="javascript:;">My favourite models</a>
                        </div>
                    </div>
                    <div class="info-box">
                        <span class="icon">
                            <img src="${location}/assets/img/inner-star-icon.png" alt="">
                        </span>
                        <div class="info-content">
                            <a href="javascript:;">My favourite videos</a>
                        </div>
                    </div>
                    <div class="info-box">
                        <span class="icon">
                            <img src="${location}/assets/img/clock-spin-icon.png" alt="">
                        </span>
                        <div class="info-content">
                            <a href="javascript:;">View History</a>
                        </div>
                    </div>
                    <div class="info-box">
                        <span class="icon">
                            <svg version="1.1" id="like" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" width="24.75px" height="23px" viewBox="0 0 24.75 23" enable-background="new 0 0 24.75 23" xml:space="preserve">
                            <path fill="#FFFFFF" d="M8.727,21.818h9.818c0.905,0,1.68-0.545,2.007-1.331l3.295-7.691C23.945,12.545,24,12.284,24,12V9.916
                                  l-0.011-0.011L24,9.818c0-1.2-0.982-2.182-2.182-2.182h-6.884l1.036-4.985l0.033-0.349c0-0.447-0.185-0.862-0.48-1.156L14.367,0
                                  L7.178,7.189C6.785,7.582,6.545,8.127,6.545,8.727v10.909C6.545,20.836,7.527,21.818,8.727,21.818z M4.364,21.818V8.727H0l0,13.091
                                  H4.364z"></path>
                            </svg>
                        </span>
                        <div class="info-content">
                            <a href="javascript:;">Liked videos</a>
                        </div>
                    </div>
                </div>
                <div class="info-box">
                    <span class="icon">
                        <img src="${location}/assets/img/gear-icon.png" alt="">
                    </span>
                    <div class="info-content">
                        <span>Settings</span>
                        <ul>
                            <li>
                                <a href="javascript:;">Change password</a>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="info-box">
                    <span class="icon">
                        <img src="${location}/assets/img/logout-icon.png" alt="">
                    </span>
                    <div class="info-content">
                       <a href="javascript:;">Logout</a>
                    </div>
                </div>
                <div class="info-box">
                    <span class="icon">
                        <img src="${location}/assets/img/trashcan-icon.png" alt="">
                    </span>
                    <div class="info-content">
                       <a href="javascript:;" class="delete-account">Delete account</a>
                    </div>
                </div>
                <div class="vip-member">
                    <p><a href="javascript:;">Become a V.I.P. memeber</a></p>
                    <a href="javascript:;">
                         <img src="${location}/assets/img/vip-member-icon.png" alt="" />
                    </a>
                       
                </div>
            </div>
        </div>
                    
                    
      <%@include file="sign.jsp" %>
<div class="container full-screen-height">
<%@include file="menu.jsp" %>

            
            
            <div id="page-wrap">
                <div class="content">
                    <div class="wrapper">
                        <div class="sticky-wrap">
                            <div class="wrapper clearfix">
                                <div class="filters-wrap">
                                    <span class="filters-toggle">Filter</span>
                                    <div class="filters">
                                        <ul>
                                            <li class="filter">
                                                <a href="javascript:;">New model</a>
                                            </li>
                                            <li class="filter">
                                                <a href="javascript:;">Brunete</a>
                                            </li>
                                            <li class="filter">
                                                <a href="javascript:;">Mature</a>
                                            </li>
                                            <li class="filter">
                                                <a href="javascript:;">Blonde</a>
                                            </li>
                                            <li class="filter">
                                                <a href="javascript:;">Petit</a>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="online-models">
                                    <span>Models online:</span>
                                    <strong>258</strong>
                                </div>
                                <div class="search-form">
                                    <form action="" method="post">
                                        <input type="text" placeholder="Search" />
                                        <button type="submit">Search</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <div class="webcam-videos">
                            <ul class="clearfix">
                                <li class="webcam-video">
                                    <a href="javascript:;">
                                        <div class="thumbnail">
                                            <img src="${location}/assets/img/content/model-image.jpg" alt="" />
                                        </div>
                                        <div class="webcam-info">
                                            <h4>Name Name</h4>
                                            <span class="status">in private chat</span>
                                        </div>
                                    </a>
                                </li>
                                <li class="webcam-video">
                                    <a href="javascript:;">
                                        <div class="thumbnail">
                                            <img src="${location}/assets/img/content/model-image.jpg" alt="" />
                                        </div>
                                        <div class="webcam-info">
                                            <h4>Name Name</h4>
                                            <span class="status">in private chat</span>
                                        </div>
                                    </a>
                                </li>
                                <li class="webcam-video">
                                    <a href="javascript:;">
                                        <div class="thumbnail">
                                            <img src="${location}/assets/img/content/model-image.jpg" alt="" />
                                        </div>
                                        <div class="webcam-info">
                                            <h4>Name Name</h4>
                                            <span class="status">in private chat</span>
                                        </div>
                                    </a>
                                </li>
                                <li class="webcam-video">
                                    <a href="javascript:;">
                                        <div class="thumbnail">
                                            <img src="${location}/assets/img/content/model-image.jpg" alt="" />
                                        </div>
                                        <div class="webcam-info">
                                            <h4>Name Name</h4>
                                            <span class="status">in private chat</span>
                                        </div>
                                    </a>
                                </li>
                                <li class="webcam-video large-video">
                                    <a href="javascript:;">
                                        <div class="thumbnail">
                                            <img src="${location}/assets/img/content/model-image.jpg" alt="" />
                                        </div>
                                        <div class="webcam-info">
                                            <h4>Name Name</h4>
                                            <span class="status">in private chat</span>
                                        </div>
                                    </a>
                                </li>
                                <li class="webcam-video">
                                    <a href="javascript:;">
                                        <div class="thumbnail">
                                            <img src="${location}/assets/img/content/model-image.jpg" alt="" />
                                        </div>
                                        <div class="webcam-info">
                                            <h4>Name Name</h4>
                                            <span class="status">in private chat</span>
                                        </div>
                                    </a>
                                </li>
                                <li class="webcam-video">
                                    <a href="javascript:;">
                                        <div class="thumbnail">
                                            <img src="${location}/assets/img/content/model-image.jpg" alt="" />
                                        </div>
                                        <div class="webcam-info">
                                            <h4>Name Name</h4>
                                            <span class="status">in private chat</span>
                                        </div>
                                    </a>
                                </li>
                                <li class="webcam-video">
                                    <a href="javascript:;">
                                        <div class="thumbnail">
                                            <img src="${location}/assets/img/content/model-image.jpg" alt="" />
                                        </div>
                                        <div class="webcam-info">
                                            <h4>Name Name</h4>
                                            <span class="status">in private chat</span>
                                        </div>
                                    </a>
                                </li>
                                <li class="webcam-video">
                                    <a href="javascript:;">
                                        <div class="thumbnail">
                                            <img src="${location}/assets/img/content/model-image.jpg" alt="" />
                                        </div>
                                        <div class="webcam-info">
                                            <h4>Name Name</h4>
                                            <span class="status">in private chat</span>
                                        </div>
                                    </a>
                                </li>
                                <li class="webcam-video">
                                    <a href="javascript:;">
                                        <div class="thumbnail">
                                            <img src="${location}/assets/img/content/model-image.jpg" alt="" />
                                        </div>
                                        <div class="webcam-info">
                                            <h4>Name Name</h4>
                                            <span class="status">in private chat</span>
                                        </div>
                                    </a>
                                </li>
                                <li class="webcam-video">
                                    <a href="javascript:;">
                                        <div class="thumbnail">
                                            <img src="${location}/assets/img/content/model-image.jpg" alt="" />
                                        </div>
                                        <div class="webcam-info">
                                            <h4>Name Name</h4>
                                            <span class="status">in private chat</span>
                                        </div>
                                    </a>
                                </li>
                                <li class="webcam-video">
                                    <a href="javascript:;">
                                        <div class="thumbnail">
                                            <img src="${location}/assets/img/content/model-image.jpg" alt="" />
                                        </div>
                                        <div class="webcam-info">
                                            <h4>Name Name</h4>
                                            <span class="status">in private chat</span>
                                        </div>
                                    </a>
                                </li>
                                <li class="webcam-video">
                                    <a href="javascript:;">
                                        <div class="thumbnail">
                                            <img src="${location}/assets/img/content/model-image.jpg" alt="" />
                                        </div>
                                        <div class="webcam-info">
                                            <h4>Name Name</h4>
                                            <span class="status">in private chat</span>
                                        </div>
                                    </a>
                                </li>
                                <li class="webcam-video">
                                    <a href="javascript:;">
                                        <div class="thumbnail">
                                            <img src="${location}/assets/img/content/model-image.jpg" alt="" />
                                        </div>
                                        <div class="webcam-info">
                                            <h4>Name Name</h4>
                                            <span class="status">in private chat</span>
                                        </div>
                                    </a>
                                </li>
                                <li class="webcam-video large-video">
                                    <a href="javascript:;">
                                        <div class="thumbnail">
                                            <img src="${location}/assets/img/content/model-image.jpg" alt="" />
                                        </div>
                                        <div class="webcam-info">
                                            <h4>Name Name</h4>
                                            <span class="status">in private chat</span>
                                        </div>
                                    </a>
                                </li>
                                <li class="webcam-video">
                                    <a href="javascript:;">
                                        <div class="thumbnail">
                                            <img src="${location}/assets/img/content/model-image.jpg" alt="" />
                                        </div>
                                        <div class="webcam-info">
                                            <h4>Name Name</h4>
                                            <span class="status">in private chat</span>
                                        </div>
                                    </a>
                                </li>
                                <li class="webcam-video">
                                    <a href="javascript:;">
                                        <div class="thumbnail">
                                            <img src="${location}/assets/img/content/model-image.jpg" alt="" />
                                        </div>
                                        <div class="webcam-info">
                                            <h4>Name Name</h4>
                                            <span class="status">in private chat</span>
                                        </div>
                                    </a>
                                </li>
                                <li class="webcam-video">
                                    <a href="javascript:;">
                                        <div class="thumbnail">
                                            <img src="${location}/assets/img/content/model-image.jpg" alt="" />
                                        </div>
                                        <div class="webcam-info">
                                            <h4>Name Name</h4>
                                            <span class="status">in private chat</span>
                                        </div>
                                    </a>
                                </li>
                                <li class="webcam-video">
                                    <a href="javascript:;">
                                        <div class="thumbnail">
                                            <img src="${location}/assets/img/content/model-image.jpg" alt="" />
                                        </div>
                                        <div class="webcam-info">
                                            <h4>Name Name</h4>
                                            <span class="status">in private chat</span>
                                        </div>
                                    </a>
                                </li>
                                <li class="webcam-video">
                                    <a href="javascript:;">
                                        <div class="thumbnail">
                                            <img src="${location}/assets/img/content/model-image.jpg" alt="" />
                                        </div>
                                        <div class="webcam-info">
                                            <h4>Name Name</h4>
                                            <span class="status">in private chat</span>
                                        </div>
                                    </a>
                                </li>
                                <li class="webcam-video">
                                    <a href="javascript:;">
                                        <div class="thumbnail">
                                            <img src="${location}/assets/img/content/model-image.jpg" alt="" />
                                        </div>
                                        <div class="webcam-info">
                                            <h4>Name Name</h4>
                                            <span class="status">in private chat</span>
                                        </div>
                                    </a>
                                </li>
                                <li class="webcam-video">
                                    <a href="javascript:;">
                                        <div class="thumbnail">
                                            <img src="${location}/assets/img/content/model-image.jpg" alt="" />
                                        </div>
                                        <div class="webcam-info">
                                            <h4>Name Name</h4>
                                            <span class="status">in private chat</span>
                                        </div>
                                    </a>
                                </li>
                            </ul>
                        </div>
                        <div class="pagination">
                            <ul>
                                <li class="prev">
                                    <a href="javascript:;">Previous</a>
                                </li>
                                <li>
                                    <a href="javascript:;">1</a>
                                </li>
                                <li class="active">
                                    <a href="javascript:;">2</a>
                                </li>
                                <li>
                                    <a href="javascript:;">3</a>
                                </li>
                                <li>
                                    <a href="javascript:;">4</a>
                                </li>
                                <li>
                                    <a href="javascript:;">5</a>
                                </li>
                                <li class="next">
                                    <a href="javascript:;">Next</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>

                <footer class="footer">
                    <div class="wrapper">
                        <p>The site contains sexually explictit material. Enter only if you are at least 18 years old and agree to our cookie rools.</p>
                        <p>Live Sex House - All Rights Reserved 2017.</p>
                    </div>
                </footer>
            </div>

        </div>

        <!-- javascript -->
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
        <script type="text/javascript">window.jQuery || document.write("<script src='${location}/assets/scripts/main/jquery-1.8.3.min.js'>\x3C/script>")</script>
        <script type="text/javascript" src="${location}/assets/scripts/libs/masonry.pkgd.min.js"></script>
        <script type="text/javascript" src="${location}/assets/scripts/libs/jQuery.fakeScroll.js"></script>
        <script type="text/javascript" src="${location}/assets/scripts/main/default.js"></script>

        <!--[if lt IE 7]>
           <p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
       <![endif]-->

    </body>
</html>
