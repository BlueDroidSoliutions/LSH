<%-- 
    Document   : sign
    Created on : Jul 24, 2017, 11:56:10 AM
    Author     : roller
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
    <link href="${bck}${location}/favicon.ico" rel="icon" />
    <title>LiveSexHouse</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,700" rel="stylesheet">
    <link rel="stylesheet" href="${bck}${location}/assets/css/lib/jcf.css">
    <link rel="stylesheet" href="${bck}${location}/assets/css/lib/fakeScroll.css">
    <link href="${bck}${location}/assets/css/nouislider.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${bck}${location}/assets/css/style.css">
    <script type="text/javascript" src="${bck}${location}/assets/scripts/libs/modernizr.2.8.3.min.js"></script>
    <script src="https://use.fontawesome.com/48b7d32ec9.js"></script>

</head>
<body>

    <script>
        var loginChecker = false;
        var signinChecker = false;
        var emailTaken = false;
        var usernameTaken = false;
        var wrongPassword = false;
        var wrongUsername = false;
        var checkEmail = false;
        var alredySigned = false;
        var thanksReg = false;
        var serverOff = false;
        var emptyField = false;

        var serverOffMsg = '<c:out value="${serverOffMsg}"/>';



    </script>

    <c:if test="${alredySigned == true || user.enabled == 0}">
        <script>  alredySigned = true;</script>
    </c:if>

    <c:if test="${serverOff == true}">
        <script>  serverOff = true;</script>
    </c:if>


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
                    <span class="name">${user.username}</span>
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
                        <span class="number"> ${user.tokens}</span>
                    </div>
                </div>
                <div class="image">
                    <div class="img-wrapper">
                        <img src="${bck}${location}/assets/img/content/user-image.png" alt="">
                    </div>
                    <a href="#additional-links" class="additional-links">
                        <img src="${bck}${location}/assets/img/additional-links.png" alt="">
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
                    <span>${user.memberfrom}</span>
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
                    <span>${user.tokens}</span>
                </span>
                <div class="info-content">
                    <span>Tokens ${user.tokens}</span>
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
                        <a href="${bck}./userFan">My favourite models</a>
                    </div>
                </div>
                <div class="info-box">
                    <span class="icon">
                        <img src="${bck}${location}/assets/img/inner-star-icon.png" alt="">
                    </span>
                    <div class="info-content">
                        <a href="${bck}./userFav">My favourite videos</a>
                    </div>
                </div>
                <div class="info-box">
                    <span class="icon">
                        <img src="${bck}${location}/assets/img/clock-spin-icon.png" alt="">
                    </span>
                    <div class="info-content">
                        <a href="">View History</a>
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
                        <a href="${bck}./userLike">Liked videos</a>
                    </div>
                </div>
            </div>
            <div class="info-box">
                <span class="icon">
                    <img src="${bck}${location}/assets/img/gear-icon.png" alt="">
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
                    <img src="${bck}${location}/assets/img/logout-icon.png" alt="">
                </span>
                <div class="info-content">
                    <a href="${bck}./logout">Logout</a>
                </div>
            </div>
            <div class="info-box">
                <span class="icon">
                    <img src="${bck}${location}/assets/img/trashcan-icon.png" alt="">
                </span>
                <div class="info-content">
                    <a href="${bck}./delete" class="delete-account">Delete account</a>
                </div>
            </div>
            <c:if test="
                  <%--!user.isVipMember--%>
                  ">
                <!--	                                                <div class="vip-member">
                                                                            <p><a href="javascript:;" onclick="buyVipMembership('${_csrf.token}')">Become a V.I.P. memeber</a></p>
                                                                            <a href="javascript:;" onclick="buyVipMembership('${_csrf.token}')">
                                                                                <img src="${bck}${location}/assets/img/vip-member-icon.png" alt="" />
                                                                            </a>
                                                                        </div>-->
            </c:if>
        </div>
    </div>

    <div class="container full-screen-height">













        <header class="header">
            <div class="wrapper">
                <a href="${bck}./" id="logo">
                    <img src="${bck}${location}/assets/img/content/LSH-logo.png" alt="Live Sex House logo" />
                </a>
                <a href="javascript:;" id="menu-btn">
                    <span></span>
                    <span></span>
                    <span></span>
                    <span></span>
                </a>
                <ul id="main-nav">
                    <li><a href="${bck}./">Home</a></li>
                    <li><a href="${bck}./live-stream">Live streams</a></li>
                    <li><a href="${bck}./video">Video archive</a></li>

                    <li>
                        <a href="${bck}./webcam">Web cam</a>
                        <a href="javascript:;" class="submenu-btn">
                            <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" version="1.1" viewBox="0 0 129 129" enable-background="new 0 0 129 129">
                            <g>
                            <path d="m121.3,34.6c-1.6-1.6-4.2-1.6-5.8,0l-51,51.1-51.1-51.1c-1.6-1.6-4.2-1.6-5.8,0-1.6,1.6-1.6,4.2 0,5.8l53.9,53.9c0.8,0.8 1.8,1.2 2.9,1.2 1,0 2.1-0.4 2.9-1.2l53.9-53.9c1.7-1.6 1.7-4.2 0.1-5.8z" fill="#FFFFFF"/>
                            </g>
                            </svg>
                        </a>
                        <!--                                                            <ul>
                                                                                        <li><a href="javascript:;">Subitem</a></li>
                                                                                        <li><a href="javascript:;">Subitem</a></li>
                                                                                        <li><a href="javascript:;">Subitem</a></li>
                                                                                        <li><a href="javascript:;">Subitem</a></li>
                                                                                    </ul>-->
                    </li>
                    <li><a href="${bck}./vote">Vote</a></li>
                    <li><a href="${bck}./contact">Contact</a></li>
                    <li><a href="javascript:;" id="user">${user.username}<strong> ${user.tokens}</strong></a></li>


                </ul>
            </div>
        </header>