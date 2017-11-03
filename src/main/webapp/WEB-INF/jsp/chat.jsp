<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>



<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js ie6"> <![endif]-->
<!--[if IE 7]>         <html class="no-js ie7"> <![endif]-->
<!--[if IE 8]>         <html class="no-js ie8"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->





    <c:choose>
        <c:when test="${not empty userName}">
            <%@include file="signed.jsp" %>
        </c:when>
        <c:otherwise>
            <%@include file="sign.jsp" %>
        </c:otherwise>
    </c:choose>

    <script>
        var selectedGirl = '<c:out value="${g.id}"/>';
    </script>

    <p style="font-size: 30px;  color: white;">${user.username} + ${g.userName}  >>> timeGr : ${timeGr} >>> timePr : ${timePr} </p>
    

    <div id="page-wrap" class="page-chat">
        <div class="wrapper ">

            <div class="models-online">
                <p>
                    Models<br>online:
                </p>
                <p class="big">${onlineNow}</p>
                <p>Filters:</p>
                <ul>
                    <li>Blonde</li>
                    <li>Milf</li>
                </ul>
            </div>
            <!-- <div class="video-view-wrapper">
                    
            </div> -->
            <div class="video-view">
                <!-- left blocl -->
                <div class="left-container">
                    <div class="main-video-block">

                        
                                <p style="color:white; font-size:100px;" id="test8"></p>


                        <video id="my_video_1" class="video-js vjs-default-skin" controls autoplay data-setup='{ "aspectRatio":"16:9", "autoplay": true }'> <source id="ttt222" src=""  type='video/mp43' />  </video>


                        <!--                        <div class="overflow-box private-only">
                                                    <p>In private chat now</p>
                                                </div>-->
                        <ul class="iframe-menu">
                            <li>
                                <svg id="Layer_1" data-name="Layer 1" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24.86 21.96" ><defs><style>.cls-1{fill:#fff;}.cls-2{fill:none;stroke:#fff;stroke-miterlimit:10;stroke-width:1.16px;}</style></defs><title>profile info</title><path class="cls-1" d="M14,13.8V15H0V13.8c0-2.33,4.67-3.61,7-3.61S14,11.47,14,13.8Z" transform="translate(0 -1)"/><circle class="cls-1" cx="6.98" cy="3.49" r="3.49"/><circle class="cls-1" cx="6.98" cy="3.49" r="3.49"/><rect class="cls-1" x="15" y="12" width="2" height="7"/><rect class="cls-1" x="15" y="8" width="2" height="2"/><circle class="cls-2" cx="15.99" cy="13.09" r="8.29"/></svg>
                                </a>
                            </li>
                            <li>
                                <a href="javascript:;">
                                    <svg version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
                                         width="19.833px" height="18.696px" viewBox="-9 -11.708 19.833 18.696" enable-background="new -9 -11.708 19.833 18.696"
                                         xml:space="preserve">
                                    <path fill="#FFFFFF" d="M5.749-2.012c0-1.77-1.02-3.29-2.5-4.03v2.21L5.7-1.382C5.729-1.582,5.749-1.791,5.749-2.012 M8.249-2.012
                                          c0,0.939-0.199,1.82-0.539,2.641l1.51,1.51c0.66-1.24,1.029-2.65,1.029-4.15c0-4.28-2.989-7.86-7-8.77v2.06
                                          C6.14-7.862,8.249-5.182,8.249-2.012 M-6.48-11.012l-1.27,1.27l4.73,4.73h-4.73v6h4l5,5v-6.73l4.25,4.25
                                          c-0.67,0.521-1.42,0.931-2.25,1.181v2.06C4.63,6.438,5.88,5.799,6.94,4.938l2.039,2.05l1.27-1.27l-9-9L-6.48-11.012z M1.249-10.012
                                          l-2.09,2.09l2.09,2.09V-10.012z"/>
                                    </svg>
                                </a>
                            </li>
                            <li>
                                <a href="javascript:;">
                                    <svg version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="	0px" width="19.833px" height="18.696px" viewBox="-9 -11.708 19.833 18.696" enable-background="new -9 -11.708 				19.833 18.696" xml:space="preserve">
                                    <path fill="#FFFFFF" d="M-5.69,0.283h-2.643V6.89h6.607V4.248H-5.69V0.283z M-8.333-5.003h2.643v-3.964h3.964v-2.643h-6.607V-5.003z
                                          M7.524,4.248H3.56V6.89h6.607V0.283H7.524V4.248z M3.56-11.61v2.643h3.965v3.964h2.643v-6.607H3.56z"/>
                                    </svg>
                                </a>
                            </li>
                            <li class="private-only">
                                <a href="javascript:;">
                                    <svg version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
                                         width="23.583px" height="22.417px" viewBox="0 0 23.583 22.417" enable-background="new 0 0 23.583 22.417" xml:space="preserve">
                                    <polygon fill="#C1282D" points="11.8,17.815 18.732,22 16.892,14.114 23.018,8.809 14.952,8.125 11.8,0.688 8.648,8.125 
                                             0.584,8.809 6.708,14.114 4.868,22 "/>
                                    </svg>
                                </a>
                            </li>
                        </ul>
                        <div class="video-tabs">
                            <div class="tip-popup">
                                <form name="registrationForm">
                                    <output name="ageOutputName" id="ageOutputId">1</output>
                                    <input type="range" name="ageInputName" id="ageInputId" value="1" min="1" step="1"	max="100" oninput="ageOutputId.value = ageInputId.value">
                                    <a href="javascript:;" onclick="tip()">Tip</a>
                                </form>
                            </div>
                            <div class="video-tab pr" id="tabPr"><a href="javascript:;" onclick="invitePrivate()" id="inv">PRIVATE</a></div>
                            <div class="video-tab gr" id="tabGr"><a href="javascript:;" onclick="inviteGroup()" id="gr">Group chat</a></div>
                            <div class="video-tab tip-btn">
                                <a href="javascript:;">


                                    TIP ME 
                                    <span><svg id="Layer_1" data-name="Layer 1" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24.88 24.88"><defs>
                                        <style>.cls-1{fill:#fff;}.cls-2{fill:none;stroke:#fff;stroke-miterlimit:10;stroke-width:1.53px;}</style>
                                        </defs><title>token</title><ellipse class="cls-1" cx="12.42" cy="7.56" rx="5.68" ry="2.05"/><path class="cls-1" d="M7.3,10.47v2.6a12.19,12.19,0,0,0,11.35,0V10.41S13.95,13.66,7.3,10.47Z" transform="translate(-0.56 -0.06)"/><path class="cls-1" d="M7.3,15.31v2.6a12.19,12.19,0,0,0,11.35,0V15.25S13.95,18.5,7.3,15.31Z" transform="translate(-0.56 -0.06)"/><circle class="cls-2" cx="12.44" cy="12.44" r="11.68"/></svg>
                                    </span>
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="bottom">
                        <div class="main-info">
                            <ul class="main-info-list">
                                <li class="user-name">
                                    <img src="${bck}${location}/assets/img/content/profile-s.png" alt="user_image">
                                    <p>
                                        I am lorem ipsum dolor amet sit um busi avec. Doram pedi lero ub aba apotrice.
                                    </p>
                                </li>
                                <li class="info private-only">
                                    Info
                                    <div class="ico-wrapper">
                                        <a href="javascript:;">
                                            <svg version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
                                                 width="24.583px" height="24.125px" viewBox="0 0 24.583 24.125" enable-background="new 0 0 24.583 24.125" xml:space="preserve">
                                            <path fill="#FFFFFF" d="M23.313,10.204h-1.707v7.686H10.505v1.707c0,0.47,0.386,0.854,0.854,0.854h9.392l3.416,3.416V11.059
                                                  C24.167,10.589,23.783,10.204,23.313,10.204"/>
                                            <path fill="#FFFFFF" d="M19.443,14.208V1.653c0-0.768-0.569-1.395-1.266-1.395H1.705c-0.697,0-1.268,0.627-1.268,1.395v18.135
                                                  l5.068-4.186h12.672C18.874,15.603,19.443,14.975,19.443,14.208"/>
                                            <rect x="8.873" y="5.072" fill="#421312" width="3" height="9"/>
                                            <rect x="8.873" y="2.072" fill="#421312" width="3" height="2"/>
                                            </svg>
                                        </a>
                                    </div>
                                </li>
                                <li class="become-fan">
                                    <a href="../addtofan/${g.id}">
                                        Become <br />a fan
                                    </a>
                                </li>
                                <li class="vote">
                                    <div class="ico-wrapper">
                                        <a href="javascript:;">
                                            <svg version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
                                                 width="21.375px" height="19.875px" viewBox="0 0 21.375 19.875" enable-background="new 0 0 21.375 19.875" xml:space="preserve">
                                            <path fill="#F3F3F3" d="M10.75,19.3L9.3,17.98c-5.149-4.67-8.55-7.75-8.55-11.53c0-3.08,2.42-5.5,5.5-5.5c1.74,0,3.41,0.81,4.5,2.09
                                                  c1.09-1.28,2.76-2.09,4.5-2.09c3.08,0,5.5,2.42,5.5,5.5c0,3.78-3.4,6.86-8.55,11.54L10.75,19.3z"/>
                                            </svg>
                                        </a>
                                    </div>
                                    <span class="private-only">4.7</span>
                                    <div class="more-rate more-box-holder">
                                        <p>Rate model:</p>
                                        <a href="javascript:;"><svg version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
                                                                    width="21.375px" height="19.875px" viewBox="0 0 21.375 19.875" enable-background="new 0 0 21.375 19.875" xml:space="preserve">
                                            <path fill="#F3F3F3" d="M10.75,19.3L9.3,17.98c-5.149-4.67-8.55-7.75-8.55-11.53c0-3.08,2.42-5.5,5.5-5.5c1.74,0,3.41,0.81,4.5,2.09
                                                  c1.09-1.28,2.76-2.09,4.5-2.09c3.08,0,5.5,2.42,5.5,5.5c0,3.78-3.4,6.86-8.55,11.54L10.75,19.3z"/>
                                            </svg></a>
                                        <a href="javascript:;"><svg version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
                                                                    width="21.375px" height="19.875px" viewBox="0 0 21.375 19.875" enable-background="new 0 0 21.375 19.875" xml:space="preserve">
                                            <path fill="#F3F3F3" d="M10.75,19.3L9.3,17.98c-5.149-4.67-8.55-7.75-8.55-11.53c0-3.08,2.42-5.5,5.5-5.5c1.74,0,3.41,0.81,4.5,2.09
                                                  c1.09-1.28,2.76-2.09,4.5-2.09c3.08,0,5.5,2.42,5.5,5.5c0,3.78-3.4,6.86-8.55,11.54L10.75,19.3z"/>
                                            </svg></a>
                                        <a href="javascript:;"><svg version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
                                                                    width="21.375px" height="19.875px" viewBox="0 0 21.375 19.875" enable-background="new 0 0 21.375 19.875" xml:space="preserve">
                                            <path fill="#F3F3F3" d="M10.75,19.3L9.3,17.98c-5.149-4.67-8.55-7.75-8.55-11.53c0-3.08,2.42-5.5,5.5-5.5c1.74,0,3.41,0.81,4.5,2.09
                                                  c1.09-1.28,2.76-2.09,4.5-2.09c3.08,0,5.5,2.42,5.5,5.5c0,3.78-3.4,6.86-8.55,11.54L10.75,19.3z"/>
                                            </svg></a>
                                        <a href="javascript:;"><svg version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
                                                                    width="21.375px" height="19.875px" viewBox="0 0 21.375 19.875" enable-background="new 0 0 21.375 19.875" xml:space="preserve">
                                            <path fill="#F3F3F3" d="M10.75,19.3L9.3,17.98c-5.149-4.67-8.55-7.75-8.55-11.53c0-3.08,2.42-5.5,5.5-5.5c1.74,0,3.41,0.81,4.5,2.09
                                                  c1.09-1.28,2.76-2.09,4.5-2.09c3.08,0,5.5,2.42,5.5,5.5c0,3.78-3.4,6.86-8.55,11.54L10.75,19.3z"/>
                                            </svg></a>
                                        <a href="javascript:;"><svg version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
                                                                    width="21.375px" height="19.875px" viewBox="0 0 21.375 19.875" enable-background="new 0 0 21.375 19.875" xml:space="preserve">
                                            <path fill="#F3F3F3" d="M10.75,19.3L9.3,17.98c-5.149-4.67-8.55-7.75-8.55-11.53c0-3.08,2.42-5.5,5.5-5.5c1.74,0,3.41,0.81,4.5,2.09
                                                  c1.09-1.28,2.76-2.09,4.5-2.09c3.08,0,5.5,2.42,5.5,5.5c0,3.78-3.4,6.86-8.55,11.54L10.75,19.3z"/>
                                            </svg></a>
                                        <a href="javascript:;">4.7</a>
                                    </div>	
                                </li>
                                <li class="genre">
                                    Gender
                                    <span class="list-big-title">Female</span>
                                </li>
                                <li class="age">
                                    Age
                                    <span class="list-big-title">25</span>
                                </li>

                                <li class="preferences">
                                    Preferences
                                    <span class="list-big-title">Bisexual</span>
                                <li class="tokens">
                                    <span class="bay-tok">
                                        Buy <br>
                                        Tokens
                                    </span>
                                    <div class="ico-wrapper">
                                        <a href="javascript:;">
                                            <svg version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
                                                 width="30.98px" height="32.02px" viewBox="0 0 30.98 32.02" enable-background="new 0 0 30.98 32.02" xml:space="preserve">
                                            <path fill="#FFFFFF" d="M16,3.417c0,1.476-3.316,2.67-7.406,2.67s-7.405-1.194-7.405-2.67c0-1.475,3.315-2.67,7.405-2.67
                                                  S16,1.943,16,3.417"/>
                                            <path fill="#FFFFFF" d="M1.189,7.14v3.397c0,0,7.212,4.192,14.811,0V7.059C16,7.059,9.858,11.299,1.189,7.14"/>
                                            <path fill="#FFFFFF" d="M1.189,13.453v3.398c0,0,7.212,4.191,14.811,0v-3.479C16,13.372,9.858,17.612,1.189,13.453"/>
                                            <path fill="none" stroke="#FFFFFF" stroke-width="2" stroke-miterlimit="10" d="M19.699,11.038c5.426,0,9.823,4.398,9.823,9.823"/>
                                            <path fill="none" stroke="#FFFFFF" stroke-width="2" stroke-miterlimit="10" d="M9.877,20.86c0-5.424,4.397-9.823,9.822-9.823"/>
                                            <path fill="none" stroke="#FFFFFF" stroke-width="2" stroke-miterlimit="10" d="M19.699,30.684c-5.424,0-9.822-4.398-9.822-9.824"/>
                                            <path fill="none" stroke="#FFFFFF" stroke-width="2" stroke-miterlimit="10" d="M29.522,20.86c0,5.426-4.397,9.824-9.823,9.824"/>
                                            <line fill="none" stroke="#FFFFFF" stroke-width="3" stroke-miterlimit="10" x1="19.689" y1="14.702" x2="19.689" y2="25.702"/>
                                            <line fill="none" stroke="#FFFFFF" stroke-width="3" stroke-miterlimit="10" x1="25.189" y1="20.202" x2="14.189" y2="20.202"/>
                                            </svg>
                                        </a>
                                    </div>
                                </li>
                            </ul>
                        </div>
                        <a href="javascript:;" class="show-more">
                            <span class="visible">Show more</span>
                            <span>Show less</span>
                            <i class="ico"></i>
                        </a>
                        <!-- <div class="more-info more-box-holder">
                                <p>In Private Chat, I'm willing to perform:</p>
                                <p><strong>
                                        Anal sex, Cameltoe, Close up, Dancing, Dildo, Fingering, Live orgasm, Oil, Roleplay, Squirt, Striptease, Shaved, Piercing, Tattoo
                                </strong></p>
                                <p>Special places:</p>
                                <p><strong>Office</strong></p>
                                <div class="fans">
                                        <svg version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
                                                 width="23.583px" height="22.417px" viewBox="0 0 23.583 22.417" enable-background="new 0 0 23.583 22.417" xml:space="preserve">
                                        <polygon fill="#C1282D" points="11.8,17.815 18.732,22 16.892,14.114 23.018,8.809 14.952,8.125 11.8,0.688 8.648,8.125 
                                                0.584,8.809 6.708,14.114 4.868,22 "/>
                                        </svg>
                                        <span>
                                                fans: <br>
                                                526
                                        </span>
                                </div>
                        </div> -->

                        <div class="more-details more-info more-box-holder">
                            <p>In Private Chat, I'm willing to perform:</p>
                            <p><strong>
                                    Anal sex, Cameltoe, Close up, Dancing, Dildo, Fingering, Live orgasm, Oil, Roleplay, Squirt, Striptease, Shaved, Piercing, Tattoo
                                </strong></p>
                            <p>Special places:</p>
                            <p><strong>Office</strong></p>
                            <div class="fans">
                                <svg version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
                                     width="23.583px" height="22.417px" viewBox="0 0 23.583 22.417" enable-background="new 0 0 23.583 22.417" xml:space="preserve">
                                <polygon fill="#C1282D" points="11.8,17.815 18.732,22 16.892,14.114 23.018,8.809 14.952,8.125 11.8,0.688 8.648,8.125 
                                         0.584,8.809 6.708,14.114 4.868,22 "/>
                                </svg>
                                <span>
                                    fans: <br>
                                    526
                                </span>
                            </div>
                        </div>	

                    </div>
                    <a href="javascript:;" class="o-bottom-container">
                        <img src="${bck}${location}/assets/img/o2.jpg" alt="" />
                    </a>
                </div>
                <!-- End of left block -->

                <!-- Right block -->
                <div class="right-container">
                    <div class="top">
                        <!--                        <ul class="tabs clearfix">
                                                    <li class="tab-link current" data-tab="tab-1">Chat</li>
                                                    <li class="tab-link" data-tab="tab-2">Users</li>
                                                </ul>-->
                        <div class="chat-box">
                            <!--                            <div class="chat-box-top">
                                                            <p>Highest tip : User 334</p>
                                                            <p>Latest tip recieved : User 344</p>
                                                        </div>-->
                            <div class="chat-box-middle">
                                <div class="fakeScroll">
                                    <div id="tab-1" class="tab-content current">
                                        <!--                                        <div class="chat-popup">
                                                                                    <a href="javascript:;" class="close-btn">
                                                                                        <svg version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
                                                                                             width="18.5px" height="17.75px" viewBox="-9 -11.708 18.5 17.75" enable-background="new -9 -11.708 18.5 17.75"
                                                                                             xml:space="preserve">
                                                                                        <line fill="none" stroke="#FBED21" stroke-width="1.956" stroke-linecap="round" stroke-miterlimit="10" x1="-3.74" y1="-6.949" x2="4.24" y2="1.032"/>
                                                                                        <line fill="none" stroke="#FBED21" stroke-width="1.956" stroke-linecap="round" stroke-miterlimit="10" x1="4.24" y1="-6.949" x2="-3.74" y2="1.032"/>
                                                                                        <path fill="none" stroke="#FBED21" stroke-width="0.561" stroke-miterlimit="10" d="M0.25-11.246c4.577,0,8.288,3.711,8.288,8.288"
                                                                                              />
                                                                                        <path fill="none" stroke="#FBED21" stroke-width="0.561" stroke-miterlimit="10" d="M-8.038-2.958c0-4.577,3.711-8.288,8.288-8.288"
                                                                                              />
                                                                                        <path fill="none" stroke="#FBED21" stroke-width="0.561" stroke-miterlimit="10" d="M0.25,5.33c-4.577,0-8.288-3.712-8.288-8.288"/>
                                                                                        <path fill="none" stroke="#FBED21" stroke-width="0.561" stroke-miterlimit="10" d="M8.538-2.958c0,4.576-3.711,8.288-8.288,8.288"
                                                                                              />
                                                                                        </svg>
                                                                                    </a>
                                                                                    <span>
                                                                                        <svg version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
                                                                                             width="46.083px" height="45.25px" viewBox="-9 -11.708 46.083 45.25" enable-background="new -9 -11.708 46.083 45.25"
                                                                                             xml:space="preserve">
                                                                                        <polygon fill="#FFFFFF" points="26.834,5.016 26.66,19.425 19.447,23.089 19.559,13.937 22.848,11.42 22.896,7.368 16.99,10.745 
                                                                                                 16.908,17.511 13.959,18.825 11.043,17.438 11.125,10.674 5.304,7.154 5.255,11.206 8.482,13.802 8.37,22.954 1.249,19.116 
                                                                                                 1.424,4.707 14.037,-2.496 "/>
                                                                                        <path fill="none" stroke="#FFFFFF" stroke-width="1.303" stroke-miterlimit="10" d="M14.043-10.655
                                                                                              c11.912,0,21.568,9.657,21.568,21.57"/>
                                                                                        <path fill="none" stroke="#FFFFFF" stroke-width="1.303" stroke-miterlimit="10" d="M-7.528,10.915
                                                                                              c0-11.913,9.657-21.57,21.571-21.57"/>
                                                                                        <path fill="none" stroke="#FFFFFF" stroke-width="1.303" stroke-miterlimit="10" d="M14.043,32.485
                                                                                              c-11.914,0-21.571-9.656-21.571-21.57"/>
                                                                                        <path fill="none" stroke="#FFFFFF" stroke-width="1.303" stroke-miterlimit="10" d="M35.611,10.915
                                                                                              c0,11.914-9.656,21.57-21.568,21.57"/>
                                                                                        </svg>
                                                                                    </span>
                                                                                    <p>
                                                                                        You have now become knight.Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore.
                                                                                    </p>
                                                                                </div>-->
                                        <div class="chat-content" id="newP">
                                            <!--                                            <p><span class="person-name">Person one :</span> Text chat lorem ipsum</p>
                                                                                        <p><span class="person-name">Person two :</span> Lorem ipsum dolor amet sum hogno akverila bilde opsum ivei.</p>
                                                                                        <p><span class="person-name">Person one :</span> Text chat lorem ipsum</p>
                                                                                        <p><span class="person-name">Person two :</span> Lorem ipsum dolor amet sum hogno akverila bilde opsum ivei.</p>
                                                                                        <p><span class="person-name">Person one :</span> Text chat lorem ipsum</p>
                                                                                        <p><span class="person-name">Person two :</span> Lorem ipsum dolor amet sum hogno akverila bilde opsum ivei.</p>-->
                                            
                                            
                                            
                                            
                                            
                                        </div>
                                    </div>
                                </div>
                                <div class="fakeScroll">
                                    <div id="tab-2" class="tab-content">
                                        <ul>
                                            <li>
                                                <div class="tab-single"><img src="${bck}${location}/assets/img/content/profile-s.png" alt=""></div>
                                                <div class="tab-single"><p>User 344</p></div>
                                                <div class="tab-single">
                                                    <svg version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
                                                         width="18.188px" height="21.438px" viewBox="0 0 18.188 21.438" enable-background="new 0 0 18.188 21.438" xml:space="preserve">
                                                    <path fill="#FFFFFF" d="M17.563,4.203v5.611c0,5.192-3.674,10.045-8.5,11.223c-4.826-1.178-8.5-6.031-8.5-11.223V4.203l8.5-3.74
                                                          L17.563,4.203z"/>
                                                    </svg>
                                                </div>
                                                <div class="tab-single">
                                                    <svg version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
                                                         width="33.5px" height="33.417px" viewBox="0 0 33.5 33.417" enable-background="new 0 0 33.5 33.417" xml:space="preserve">
                                                    <polygon fill="#E6E6E5" points="16.875,22.747 24.431,27.307 22.426,18.711 29.102,12.93 20.311,12.184 16.875,4.078 13.439,12.184 
                                                             4.648,12.93 11.325,18.711 9.32,27.307 "/>
                                                    <text transform="matrix(1 0 0 1 12.2769 21.6899)" fill="#5E5E5E" font-family="'Roboto-Black'" font-size="12.482">V</text>
                                                    <path fill="none" stroke="#F6EB16" stroke-width="1.04" stroke-miterlimit="10" d="M16.875,1.499
                                                          c8.566,0,15.512,6.945,15.512,15.512"/>
                                                    <path fill="none" stroke="#F6EB16" stroke-width="1.04" stroke-miterlimit="10" d="M1.364,17.01c0-8.566,6.945-15.512,15.512-15.512
                                                          "/>
                                                    <path fill="none" stroke="#F6EB16" stroke-width="1.04" stroke-miterlimit="10" d="M16.875,32.52
                                                          c-8.566,0-15.512-6.945-15.512-15.51"/>
                                                    <path fill="none" stroke="#F6EB16" stroke-width="1.04" stroke-miterlimit="10" d="M32.387,17.01c0,8.564-6.945,15.51-15.512,15.51"
                                                          />
                                                    </svg>
                                                </div>
                                                <div class="tab-single">
                                                    </svg>
                                                </div>
                                            </li>
                                            <li>
                                                <div class="tab-single"><img src="${bck}${location}/assets/img/content/profile-s.png" alt=""></div>
                                                <div class="tab-single"><p>User 344</p></div>
                                                <div class="tab-single">
                                                    <svg version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
                                                         width="18.188px" height="21.438px" viewBox="0 0 18.188 21.438" enable-background="new 0 0 18.188 21.438" xml:space="preserve">
                                                    <path fill="#FFFFFF" d="M17.563,4.203v5.611c0,5.192-3.674,10.045-8.5,11.223c-4.826-1.178-8.5-6.031-8.5-11.223V4.203l8.5-3.74
                                                          L17.563,4.203z"/>
                                                    </svg>
                                                </div>
                                                <div class="tab-single">

                                                </div>
                                                <div class="tab-single">
                                                    <svg version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
                                                         width="33.5px" height="33.417px" viewBox="0 0 33.5 33.417" enable-background="new 0 0 33.5 33.417" xml:space="preserve">
                                                    <polygon fill="#E6E6E5" points="16.875,22.747 24.431,27.307 22.426,18.711 29.102,12.93 20.311,12.184 16.875,4.078 13.439,12.184 
                                                             4.648,12.93 11.325,18.711 9.32,27.307 "/>
                                                    <text transform="matrix(1 0 0 1 12.2769 21.6899)" fill="#5E5E5E" font-family="'Roboto-Black'" font-size="12.482"></text>
                                                    <path fill="none" stroke="#F6EB16" stroke-width="1.04" stroke-miterlimit="10" d="M16.875,1.499
                                                          c8.566,0,15.512,6.945,15.512,15.512"/>
                                                    <path fill="none" stroke="#F6EB16" stroke-width="1.04" stroke-miterlimit="10" d="M1.364,17.01c0-8.566,6.945-15.512,15.512-15.512
                                                          "/>
                                                    <path fill="none" stroke="#F6EB16" stroke-width="1.04" stroke-miterlimit="10" d="M16.875,32.52
                                                          c-8.566,0-15.512-6.945-15.512-15.51"/>
                                                    <path fill="none" stroke="#F6EB16" stroke-width="1.04" stroke-miterlimit="10" d="M32.387,17.01c0,8.564-6.945,15.51-15.512,15.51"
                                                          />
                                                    </svg>
                                                </div>
                                            </li>
                                            <li>
                                                <div class="tab-single"><img src="${bck}${location}/assets/img/content/profile-s.png" alt=""></div>
                                                <div class="tab-single"><p>User 344</p></div>
                                                <div class="tab-single">
                                                    <svg version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
                                                         width="18.188px" height="21.438px" viewBox="0 0 18.188 21.438" enable-background="new 0 0 18.188 21.438" xml:space="preserve">
                                                    <path fill="#FFFFFF" d="M17.563,4.203v5.611c0,5.192-3.674,10.045-8.5,11.223c-4.826-1.178-8.5-6.031-8.5-11.223V4.203l8.5-3.74
                                                          L17.563,4.203z"/>
                                                    </svg>
                                                </div>
                                                <div class="tab-single">
                                                    <svg version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
                                                         width="33.5px" height="33.417px" viewBox="0 0 33.5 33.417" enable-background="new 0 0 33.5 33.417" xml:space="preserve">
                                                    <polygon fill="#E6E6E5" points="16.875,22.747 24.431,27.307 22.426,18.711 29.102,12.93 20.311,12.184 16.875,4.078 13.439,12.184 
                                                             4.648,12.93 11.325,18.711 9.32,27.307 "/>
                                                    <text transform="matrix(1 0 0 1 12.2769 21.6899)" fill="#5E5E5E" font-family="'Roboto-Black'" font-size="12.482"></text>
                                                    <path fill="none" stroke="#F6EB16" stroke-width="1.04" stroke-miterlimit="10" d="M16.875,1.499
                                                          c8.566,0,15.512,6.945,15.512,15.512"/>
                                                    <path fill="none" stroke="#F6EB16" stroke-width="1.04" stroke-miterlimit="10" d="M1.364,17.01c0-8.566,6.945-15.512,15.512-15.512
                                                          "/>
                                                    <path fill="none" stroke="#F6EB16" stroke-width="1.04" stroke-miterlimit="10" d="M16.875,32.52
                                                          c-8.566,0-15.512-6.945-15.512-15.51"/>
                                                    <path fill="none" stroke="#F6EB16" stroke-width="1.04" stroke-miterlimit="10" d="M32.387,17.01c0,8.564-6.945,15.51-15.512,15.51"
                                                          />
                                                    </svg>
                                                </div>
                                                <div class="tab-single">
                                                    <svg version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
                                                         width="33.5px" height="33.417px" viewBox="0 0 33.5 33.417" enable-background="new 0 0 33.5 33.417" xml:space="preserve">
                                                    <polygon fill="#E6E6E5" points="16.875,22.747 24.431,27.307 22.426,18.711 29.102,12.93 20.311,12.184 16.875,4.078 13.439,12.184 
                                                             4.648,12.93 11.325,18.711 9.32,27.307 "/>
                                                    <text transform="matrix(1 0 0 1 12.2769 21.6899)" fill="#5E5E5E" font-family="'Roboto-Black'" font-size="12.482"></text>
                                                    <path fill="none" stroke="#F6EB16" stroke-width="1.04" stroke-miterlimit="10" d="M16.875,1.499
                                                          c8.566,0,15.512,6.945,15.512,15.512"/>
                                                    <path fill="none" stroke="#F6EB16" stroke-width="1.04" stroke-miterlimit="10" d="M1.364,17.01c0-8.566,6.945-15.512,15.512-15.512
                                                          "/>
                                                    <path fill="none" stroke="#F6EB16" stroke-width="1.04" stroke-miterlimit="10" d="M16.875,32.52
                                                          c-8.566,0-15.512-6.945-15.512-15.51"/>
                                                    <path fill="none" stroke="#F6EB16" stroke-width="1.04" stroke-miterlimit="10" d="M32.387,17.01c0,8.564-6.945,15.51-15.512,15.51"
                                                          />
                                                    </svg>
                                                </div>
                                            </li>
                                            <li>
                                                <div class="tab-single"><img src="${bck}${location}/assets/img/content/profile-s.png" alt=""></div>
                                                <div class="tab-single"><p>User 344</p></div>
                                                <div class="tab-single">
                                                    <svg version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
                                                         width="18.188px" height="21.438px" viewBox="0 0 18.188 21.438" enable-background="new 0 0 18.188 21.438" xml:space="preserve">
                                                    <path fill="#FFFFFF" d="M17.563,4.203v5.611c0,5.192-3.674,10.045-8.5,11.223c-4.826-1.178-8.5-6.031-8.5-11.223V4.203l8.5-3.74
                                                          L17.563,4.203z"/>
                                                    </svg>
                                                </div>
                                                <div class="tab-single">
                                                    <svg version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
                                                         width="33.5px" height="33.417px" viewBox="0 0 33.5 33.417" enable-background="new 0 0 33.5 33.417" xml:space="preserve">
                                                    <polygon fill="#E6E6E5" points="16.875,22.747 24.431,27.307 22.426,18.711 29.102,12.93 20.311,12.184 16.875,4.078 13.439,12.184 
                                                             4.648,12.93 11.325,18.711 9.32,27.307 "/>
                                                    <text transform="matrix(1 0 0 1 12.2769 21.6899)" fill="#5E5E5E" font-family="'Roboto-Black'" font-size="12.482"></text>
                                                    <path fill="none" stroke="#F6EB16" stroke-width="1.04" stroke-miterlimit="10" d="M16.875,1.499
                                                          c8.566,0,15.512,6.945,15.512,15.512"/>
                                                    <path fill="none" stroke="#F6EB16" stroke-width="1.04" stroke-miterlimit="10" d="M1.364,17.01c0-8.566,6.945-15.512,15.512-15.512
                                                          "/>
                                                    <path fill="none" stroke="#F6EB16" stroke-width="1.04" stroke-miterlimit="10" d="M16.875,32.52
                                                          c-8.566,0-15.512-6.945-15.512-15.51"/>
                                                    <path fill="none" stroke="#F6EB16" stroke-width="1.04" stroke-miterlimit="10" d="M32.387,17.01c0,8.564-6.945,15.51-15.512,15.51"
                                                          />
                                                    </svg>
                                                </div>
                                                <div class="tab-single">
                                                    <svg version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
                                                         width="33.5px" height="33.417px" viewBox="0 0 33.5 33.417" enable-background="new 0 0 33.5 33.417" xml:space="preserve">
                                                    <polygon fill="#E6E6E5" points="16.875,22.747 24.431,27.307 22.426,18.711 29.102,12.93 20.311,12.184 16.875,4.078 13.439,12.184 
                                                             4.648,12.93 11.325,18.711 9.32,27.307 "/>
                                                    <text transform="matrix(1 0 0 1 12.2769 21.6899)" fill="#5E5E5E" font-family="'Roboto-Black'" font-size="12.482"></text>
                                                    <path fill="none" stroke="#F6EB16" stroke-width="1.04" stroke-miterlimit="10" d="M16.875,1.499
                                                          c8.566,0,15.512,6.945,15.512,15.512"/>
                                                    <path fill="none" stroke="#F6EB16" stroke-width="1.04" stroke-miterlimit="10" d="M1.364,17.01c0-8.566,6.945-15.512,15.512-15.512
                                                          "/>
                                                    <path fill="none" stroke="#F6EB16" stroke-width="1.04" stroke-miterlimit="10" d="M16.875,32.52
                                                          c-8.566,0-15.512-6.945-15.512-15.51"/>
                                                    <path fill="none" stroke="#F6EB16" stroke-width="1.04" stroke-miterlimit="10" d="M32.387,17.01c0,8.564-6.945,15.51-15.512,15.51"
                                                          />
                                                    </svg>
                                                </div>
                                            </li>
                                            <li>
                                                <div class="tab-single"><img src="${bck}${location}/assets/img/content/profile-s.png" alt=""></div>
                                                <div class="tab-single"><p>User 344</p></div>
                                                <div class="tab-single">
                                                    <svg version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
                                                         width="18.188px" height="21.438px" viewBox="0 0 18.188 21.438" enable-background="new 0 0 18.188 21.438" xml:space="preserve">
                                                    <path fill="#FFFFFF" d="M17.563,4.203v5.611c0,5.192-3.674,10.045-8.5,11.223c-4.826-1.178-8.5-6.031-8.5-11.223V4.203l8.5-3.74
                                                          L17.563,4.203z"/>
                                                    </svg>
                                                </div>
                                                <div class="tab-single">
                                                    <svg version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
                                                         width="33.5px" height="33.417px" viewBox="0 0 33.5 33.417" enable-background="new 0 0 33.5 33.417" xml:space="preserve">
                                                    <polygon fill="#E6E6E5" points="16.875,22.747 24.431,27.307 22.426,18.711 29.102,12.93 20.311,12.184 16.875,4.078 13.439,12.184 
                                                             4.648,12.93 11.325,18.711 9.32,27.307 "/>
                                                    <text transform="matrix(1 0 0 1 12.2769 21.6899)" fill="#5E5E5E" font-family="'Roboto-Black'" font-size="12.482"></text>
                                                    <path fill="none" stroke="#F6EB16" stroke-width="1.04" stroke-miterlimit="10" d="M16.875,1.499
                                                          c8.566,0,15.512,6.945,15.512,15.512"/>
                                                    <path fill="none" stroke="#F6EB16" stroke-width="1.04" stroke-miterlimit="10" d="M1.364,17.01c0-8.566,6.945-15.512,15.512-15.512
                                                          "/>
                                                    <path fill="none" stroke="#F6EB16" stroke-width="1.04" stroke-miterlimit="10" d="M16.875,32.52
                                                          c-8.566,0-15.512-6.945-15.512-15.51"/>
                                                    <path fill="none" stroke="#F6EB16" stroke-width="1.04" stroke-miterlimit="10" d="M32.387,17.01c0,8.564-6.945,15.51-15.512,15.51"
                                                          />
                                                    </svg>
                                                </div>
                                                <div class="tab-single">
                                                    <svg version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
                                                         width="33.5px" height="33.417px" viewBox="0 0 33.5 33.417" enable-background="new 0 0 33.5 33.417" xml:space="preserve">
                                                    <polygon fill="#E6E6E5" points="16.875,22.747 24.431,27.307 22.426,18.711 29.102,12.93 20.311,12.184 16.875,4.078 13.439,12.184 
                                                             4.648,12.93 11.325,18.711 9.32,27.307 "/>
                                                    <text transform="matrix(1 0 0 1 12.2769 21.6899)" fill="#5E5E5E" font-family="'Roboto-Black'" font-size="12.482"></text>
                                                    <path fill="none" stroke="#F6EB16" stroke-width="1.04" stroke-miterlimit="10" d="M16.875,1.499
                                                          c8.566,0,15.512,6.945,15.512,15.512"/>
                                                    <path fill="none" stroke="#F6EB16" stroke-width="1.04" stroke-miterlimit="10" d="M1.364,17.01c0-8.566,6.945-15.512,15.512-15.512
                                                          "/>
                                                    <path fill="none" stroke="#F6EB16" stroke-width="1.04" stroke-miterlimit="10" d="M16.875,32.52
                                                          c-8.566,0-15.512-6.945-15.512-15.51"/>
                                                    <path fill="none" stroke="#F6EB16" stroke-width="1.04" stroke-miterlimit="10" d="M32.387,17.01c0,8.564-6.945,15.51-15.512,15.51"
                                                          />
                                                    </svg>
                                                </div>
                                            </li>
                                            <li>
                                                <div class="tab-single"><img src="${bck}${location}/assets/img/content/profile-s.png" alt=""></div>
                                                <div class="tab-single"><p>User 344</p></div>
                                                <div class="tab-single">
                                                    <svg version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
                                                         width="18.188px" height="21.438px" viewBox="0 0 18.188 21.438" enable-background="new 0 0 18.188 21.438" xml:space="preserve">
                                                    <path fill="#FFFFFF" d="M17.563,4.203v5.611c0,5.192-3.674,10.045-8.5,11.223c-4.826-1.178-8.5-6.031-8.5-11.223V4.203l8.5-3.74
                                                          L17.563,4.203z"/>
                                                    </svg>
                                                </div>
                                                <div class="tab-single">
                                                    <svg version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
                                                         width="33.5px" height="33.417px" viewBox="0 0 33.5 33.417" enable-background="new 0 0 33.5 33.417" xml:space="preserve">
                                                    <polygon fill="#E6E6E5" points="16.875,22.747 24.431,27.307 22.426,18.711 29.102,12.93 20.311,12.184 16.875,4.078 13.439,12.184 
                                                             4.648,12.93 11.325,18.711 9.32,27.307 "/>
                                                    <text transform="matrix(1 0 0 1 12.2769 21.6899)" fill="#5E5E5E" font-family="'Roboto-Black'" font-size="12.482"></text>
                                                    <path fill="none" stroke="#F6EB16" stroke-width="1.04" stroke-miterlimit="10" d="M16.875,1.499
                                                          c8.566,0,15.512,6.945,15.512,15.512"/>
                                                    <path fill="none" stroke="#F6EB16" stroke-width="1.04" stroke-miterlimit="10" d="M1.364,17.01c0-8.566,6.945-15.512,15.512-15.512
                                                          "/>
                                                    <path fill="none" stroke="#F6EB16" stroke-width="1.04" stroke-miterlimit="10" d="M16.875,32.52
                                                          c-8.566,0-15.512-6.945-15.512-15.51"/>
                                                    <path fill="none" stroke="#F6EB16" stroke-width="1.04" stroke-miterlimit="10" d="M32.387,17.01c0,8.564-6.945,15.51-15.512,15.51"
                                                          />
                                                    </svg>
                                                </div>
                                                <div class="tab-single">
                                                    <svg version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
                                                         width="33.5px" height="33.417px" viewBox="0 0 33.5 33.417" enable-background="new 0 0 33.5 33.417" xml:space="preserve">
                                                    <polygon fill="#E6E6E5" points="16.875,22.747 24.431,27.307 22.426,18.711 29.102,12.93 20.311,12.184 16.875,4.078 13.439,12.184 
                                                             4.648,12.93 11.325,18.711 9.32,27.307 "/>
                                                    <text transform="matrix(1 0 0 1 12.2769 21.6899)" fill="#5E5E5E" font-family="'Roboto-Black'" font-size="12.482"></text>
                                                    <path fill="none" stroke="#F6EB16" stroke-width="1.04" stroke-miterlimit="10" d="M16.875,1.499
                                                          c8.566,0,15.512,6.945,15.512,15.512"/>
                                                    <path fill="none" stroke="#F6EB16" stroke-width="1.04" stroke-miterlimit="10" d="M1.364,17.01c0-8.566,6.945-15.512,15.512-15.512
                                                          "/>
                                                    <path fill="none" stroke="#F6EB16" stroke-width="1.04" stroke-miterlimit="10" d="M16.875,32.52
                                                          c-8.566,0-15.512-6.945-15.512-15.51"/>
                                                    <path fill="none" stroke="#F6EB16" stroke-width="1.04" stroke-miterlimit="10" d="M32.387,17.01c0,8.564-6.945,15.51-15.512,15.51"
                                                          />
                                                    </svg>
                                                </div>
                                            </li>
                                            <li>
                                                <div class="tab-single"><img src="${bck}${location}/assets/img/content/profile-s.png" alt=""></div>
                                                <div class="tab-single"><p>User 344</p></div>
                                                <div class="tab-single">
                                                    <svg version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
                                                         width="18.188px" height="21.438px" viewBox="0 0 18.188 21.438" enable-background="new 0 0 18.188 21.438" xml:space="preserve">
                                                    <path fill="#FFFFFF" d="M17.563,4.203v5.611c0,5.192-3.674,10.045-8.5,11.223c-4.826-1.178-8.5-6.031-8.5-11.223V4.203l8.5-3.74
                                                          L17.563,4.203z"/>
                                                    </svg>
                                                </div>
                                                <div class="tab-single">
                                                    <svg version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
                                                         width="33.5px" height="33.417px" viewBox="0 0 33.5 33.417" enable-background="new 0 0 33.5 33.417" xml:space="preserve">
                                                    <polygon fill="#E6E6E5" points="16.875,22.747 24.431,27.307 22.426,18.711 29.102,12.93 20.311,12.184 16.875,4.078 13.439,12.184 
                                                             4.648,12.93 11.325,18.711 9.32,27.307 "/>
                                                    <text transform="matrix(1 0 0 1 12.2769 21.6899)" fill="#5E5E5E" font-family="'Roboto-Black'" font-size="12.482"></text>
                                                    <path fill="none" stroke="#F6EB16" stroke-width="1.04" stroke-miterlimit="10" d="M16.875,1.499
                                                          c8.566,0,15.512,6.945,15.512,15.512"/>
                                                    <path fill="none" stroke="#F6EB16" stroke-width="1.04" stroke-miterlimit="10" d="M1.364,17.01c0-8.566,6.945-15.512,15.512-15.512
                                                          "/>
                                                    <path fill="none" stroke="#F6EB16" stroke-width="1.04" stroke-miterlimit="10" d="M16.875,32.52
                                                          c-8.566,0-15.512-6.945-15.512-15.51"/>
                                                    <path fill="none" stroke="#F6EB16" stroke-width="1.04" stroke-miterlimit="10" d="M32.387,17.01c0,8.564-6.945,15.51-15.512,15.51"
                                                          />
                                                    </svg>
                                                </div>
                                                <div class="tab-single">
                                                    <svg version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
                                                         width="33.5px" height="33.417px" viewBox="0 0 33.5 33.417" enable-background="new 0 0 33.5 33.417" xml:space="preserve">
                                                    <polygon fill="#E6E6E5" points="16.875,22.747 24.431,27.307 22.426,18.711 29.102,12.93 20.311,12.184 16.875,4.078 13.439,12.184 
                                                             4.648,12.93 11.325,18.711 9.32,27.307 "/>
                                                    <text transform="matrix(1 0 0 1 12.2769 21.6899)" fill="#5E5E5E" font-family="'Roboto-Black'" font-size="12.482"></text>
                                                    <path fill="none" stroke="#F6EB16" stroke-width="1.04" stroke-miterlimit="10" d="M16.875,1.499
                                                          c8.566,0,15.512,6.945,15.512,15.512"/>
                                                    <path fill="none" stroke="#F6EB16" stroke-width="1.04" stroke-miterlimit="10" d="M1.364,17.01c0-8.566,6.945-15.512,15.512-15.512
                                                          "/>
                                                    <path fill="none" stroke="#F6EB16" stroke-width="1.04" stroke-miterlimit="10" d="M16.875,32.52
                                                          c-8.566,0-15.512-6.945-15.512-15.51"/>
                                                    <path fill="none" stroke="#F6EB16" stroke-width="1.04" stroke-miterlimit="10" d="M32.387,17.01c0,8.564-6.945,15.51-15.512,15.51"
                                                          />
                                                    </svg>
                                                </div>
                                            </li>
                                            <li>
                                                <div class="tab-single"><img src="${bck}${location}/assets/img/content/profile-s.png" alt=""></div>
                                                <div class="tab-single"><p>User 344</p></div>
                                                <div class="tab-single">
                                                    <svg version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
                                                         width="18.188px" height="21.438px" viewBox="0 0 18.188 21.438" enable-background="new 0 0 18.188 21.438" xml:space="preserve">
                                                    <path fill="#FFFFFF" d="M17.563,4.203v5.611c0,5.192-3.674,10.045-8.5,11.223c-4.826-1.178-8.5-6.031-8.5-11.223V4.203l8.5-3.74
                                                          L17.563,4.203z"/>
                                                    </svg>
                                                </div>
                                                <div class="tab-single">
                                                    <svg version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
                                                         width="33.5px" height="33.417px" viewBox="0 0 33.5 33.417" enable-background="new 0 0 33.5 33.417" xml:space="preserve">
                                                    <polygon fill="#E6E6E5" points="16.875,22.747 24.431,27.307 22.426,18.711 29.102,12.93 20.311,12.184 16.875,4.078 13.439,12.184 
                                                             4.648,12.93 11.325,18.711 9.32,27.307 "/>
                                                    <text transform="matrix(1 0 0 1 12.2769 21.6899)" fill="#5E5E5E" font-family="'Roboto-Black'" font-size="12.482"></text>
                                                    <path fill="none" stroke="#F6EB16" stroke-width="1.04" stroke-miterlimit="10" d="M16.875,1.499
                                                          c8.566,0,15.512,6.945,15.512,15.512"/>
                                                    <path fill="none" stroke="#F6EB16" stroke-width="1.04" stroke-miterlimit="10" d="M1.364,17.01c0-8.566,6.945-15.512,15.512-15.512
                                                          "/>
                                                    <path fill="none" stroke="#F6EB16" stroke-width="1.04" stroke-miterlimit="10" d="M16.875,32.52
                                                          c-8.566,0-15.512-6.945-15.512-15.51"/>
                                                    <path fill="none" stroke="#F6EB16" stroke-width="1.04" stroke-miterlimit="10" d="M32.387,17.01c0,8.564-6.945,15.51-15.512,15.51"
                                                          />
                                                    </svg>
                                                </div>
                                                <div class="tab-single">
                                                    <svg version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
                                                         width="33.5px" height="33.417px" viewBox="0 0 33.5 33.417" enable-background="new 0 0 33.5 33.417" xml:space="preserve">
                                                    <polygon fill="#E6E6E5" points="16.875,22.747 24.431,27.307 22.426,18.711 29.102,12.93 20.311,12.184 16.875,4.078 13.439,12.184 
                                                             4.648,12.93 11.325,18.711 9.32,27.307 "/>
                                                    <text transform="matrix(1 0 0 1 12.2769 21.6899)" fill="#5E5E5E" font-family="'Roboto-Black'" font-size="12.482"></text>
                                                    <path fill="none" stroke="#F6EB16" stroke-width="1.04" stroke-miterlimit="10" d="M16.875,1.499
                                                          c8.566,0,15.512,6.945,15.512,15.512"/>
                                                    <path fill="none" stroke="#F6EB16" stroke-width="1.04" stroke-miterlimit="10" d="M1.364,17.01c0-8.566,6.945-15.512,15.512-15.512
                                                          "/>
                                                    <path fill="none" stroke="#F6EB16" stroke-width="1.04" stroke-miterlimit="10" d="M16.875,32.52
                                                          c-8.566,0-15.512-6.945-15.512-15.51"/>
                                                    <path fill="none" stroke="#F6EB16" stroke-width="1.04" stroke-miterlimit="10" d="M32.387,17.01c0,8.564-6.945,15.51-15.512,15.51"
                                                          />
                                                    </svg>
                                                </div>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>




                            <div class="chat-box-bottom">
                                <input class="chat-input" id="input-chat" type="text" placeholder="Send a message..." onkeypress="handle(event)">
                                <button id="submit-chat" type="submit" class="chat-submit" onclick="sendMessage()">Send</button>
                            </div>




                        </div>
                    </div>
                                             
                                    
                                    
                    <div class="right-bottom">
                        <h3>Next model</h3>
                        <div class="flexslider">
                            <div class="custom-navigation custom-navigation-left">
                                <a href="#" class="flex-prev">
                                    <img src="${bck}${location}/assets/img/arrow_left.png" alt="" />
                                </a>
                            </div>
                                
                                
                               
                                
                                
                            <ul class="slides">
                                
                                <c:forEach items="${girlsOnline}" var="g">
                                     <li>
                                         <a href="../webcam/${g.id}">
                                    <img src="../ext/girlImg/${g.name}.jpg" />
                                         </a>
                                </li>
                                </c:forEach>
                                
                                
                               
                                
                            </ul>
                            <div class="custom-navigation custom-navigation-right">
                                <a href="#" class="flex-next">
                                    <img src="${bck}${location}/assets/img/arrow_right.png" alt="" />
                                </a>
                            </div>
                        </div>
                    </div>
                    <!-- End of right block -->
                </div>
            </div>



            <%@include file="footer.jsp" %>
        </div>

    </div>

    <!-- javascript -->

    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    <script type="text/javascript">window.jQuery || document.write("<script src='${bck}${location}/assets/scripts/main/jquery-1.8.3.min.js'>\x3C/script>");</script>
    <script type="text/javascript" src="${bck}${location}/assets/scripts/libs/jquery.flexslider-min.js"></script>
    <script type="text/javascript" src="${bck}${location}/assets/scripts/libs/jQuery.fakeScroll.js"></script>
    <script type="text/javascript" src="${bck}${location}/assets/scripts/libs/jcf.js"></script>
    <script type="text/javascript" src="${bck}${location}/assets/scripts/libs/jcf.range.js"></script>
    <script type="text/javascript" src="${bck}${location}/assets/scripts/main/default.js"></script>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.js"></script>
    <script src="../resources/st2/sockjs.js"></script>

    <!--[if lt IE 7]>
       <p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
   <![endif]-->



    <script>
                                    var selectedGirl = '<c:out value="${g.id}"/>';
                                    var inviteGirl = '<c:out value="${g.name}"/>';
                                    var whoami = '<c:out value="${userName}"/>';
                                    var whoamiId = '<c:out value="${u.id}"/>';
                                    var lnk = '<c:out value="${g.lnk}"/>';
                                    var status = '<c:out value="${status}"/>';
                                    var timeGr = '<c:out value="${timeGr}"/>';
                                    var timePr = '<c:out value="${timePr}"/>';

    </script>
    <script>
                                                var notice1 = '<div class="notice-box"> <p>  User ';
                                                var notice2 = ' is now  <span class="svg-notice"><svg version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" width="26.75px" height="18.542px" viewBox="0.667 0 26.75 18.542" enable-background="new 0.667 0 26.75 18.542" xml:space="preserve"> <path fill="#FFFFFF" d="M24.126,6.357c-0.183-0.369-0.335-0.592-0.405-0.84c-0.212-0.73,0.047-1.326,0.694-1.676 c0.642-0.347,1.29-0.256,1.788,0.314c0.49,0.563,0.629,1.307,0.078,1.787c-0.754,0.658-0.859,1.502-1.073,2.346 c-0.34,1.339-0.701,2.675-0.993,4.023c-0.181,0.834-0.559,1.207-1.471,1.207c-5.834-0.011-11.667,0.021-17.5,0.068  c-0.876,0.007-1.32-0.313-1.503-1.181C3.45,11.023,3.062,9.66,2.726,8.286c-0.209-0.851-0.328-1.685-1.098-2.33 c-0.56-0.47-0.441-1.218,0.05-1.785C2.204,3.57,2.874,3.479,3.543,3.886c0.635,0.384,0.955,1.044,0.58,1.69 c-0.414,0.713-0.096,1.053,0.369,1.47c0.466,0.417,0.87,0.905,1.347,1.308c1.127,0.953,2.678,0.912,3.635-0.209 c1.111-1.302,2.11-2.699,3.119-4.082c0.128-0.176,0.082-0.537,0.016-0.785c-0.191-0.694-0.151-1.312,0.46-1.777 c0.565-0.43,1.163-0.438,1.736-0.018c0.616,0.453,0.659,1.064,0.502,1.77c-0.066,0.295-0.033,0.709,0.133,0.943 c0.869,1.24,1.77,2.463,2.711,3.649c1.174,1.481,2.822,1.563,4.197,0.255C22.941,7.533,23.52,6.952,24.126,6.357"/>  <path fill="#FFFFFF" d="M13.926,18.19c-2.862,0-5.726,0.004-8.589-0.002c-1.135-0.002-1.252-0.147-1.256-1.461 c-0.005-1.49,0.115-1.666,1.269-1.666c5.759-0.008,11.518,0.008,17.275-0.016c0.949-0.004,1.338,0.369,1.241,1.297 c-0.024,0.229-0.019,0.463-0.001,0.689c0.068,0.845-0.297,1.178-1.153,1.17C19.785,18.172,16.855,18.19,13.926,18.19"/> </svg> </span> king of the room.  </p>  </div>'
                                                
                                                
                                            </script>

    <!--    <div class="video-tab" id="tabPr"><a href="javascript:;" onclick="invitePrivate()" id="inv">PRIVATE</a></div>
        <div class="video-tab" id="tabGr"><a href="javascript:;" onclick="inviteGroup()" id="gr">Group chat</a></div>
    -->

    <script type="text/javascript">


        var stompClient = null;
        var socket = null;
        var stompClient2 = null;
        var socket2 = null;
        var stompClient3 = null;
        var socket3 = null;
        var sentToUser = null;
        var channel = null;
        var girlAccepted = false;
        var groupAccepted = false;
        var inviteGirlB = false;
        var privateStarted = false;
        var groupStarted = false;
        var inviteI = false;
        var inviteGirlBGroup = false;
        var girlSentInvite = false;
        var acceptedGroupInvitation = false;
        var iSentInvitationGroup = false;
        var grStarted = false;

        var socketToken = null;
        var stompToken = null;

        var again = false;

        var girlAcceptedGroupFromMe = false;

        var groupAlredyStarted = false;
        
        var iAcceptedGroup = false;
        
        var grStrt = false;
        var newBool = false;
        
        var nowPrivateGirl = false;


        function timeSetup(){
            
           
            
            if(timeGr < 301){
                    $('a#gr').css("color", 'gray');
                   grOff();
                   inviteGirlBGroup = true;
                    setTimeout(function () {
                                    inviteGirlBGroup = false;
                                     alert('now you can invite this girl to group chat again');
                                    $('a#gr').css("color", 'white');
                                        grOn();
                                 }, (300000-(timeGr*100)));
      
                    
            }
            
            if(timePr < 301){
                $('a#inv').css("color", 'gray');
                   prOff();
                   inviteGirlB = true;
                setTimeout(function () {
                                alert('now you can invite this girl to private chat again');
                                inviteGirlB = false;
                                $('a#inv').css("color", 'white');
                                prOn();
                            }, (300000-(timePr*100)));
//                            changeTime 300000
            }
            
            
            
            
        }


        function connectPublic() {
            channel = '/www.livesexhouse.com/public';
            sentToUser = selectedGirl;
            socket = new SockJS('/www.livesexhouse.com/public');
            stompClient = Stomp.over(socket);
            if(status === '2' ){
                insertService("YOU ARE IN PUBLIC CHAT WITH " + inviteGirl);
            }
            
            stompClient.connect('', '', function (frame) {
                console.log('Connected: ' + frame);
                stompClient.subscribe('/queue/messages/' + selectedGirl, function (message) {
                    showMessage(JSON.parse(message.body));
//                    insertService("________________________1_____" + (JSON.parse(message.body).message));

                });
            });
        }

        function connectPrivate() {
            socketToken = new SockJS('/www.livesexhouse.com/token');
            stompToken = Stomp.over(socketToken);
            inviteI = true;
            channel = null;
            channel = '/www.livesexhouse.com/private';
            $("#newP").empty();
            sentToUser = inviteGirl;
            insertService("YOU ARE IN PRIVATE CHAT WITH " + inviteGirl);
            socket = new SockJS('/www.livesexhouse.com/private');
            stompClient = Stomp.over(socket);
            stompClient.connect('', '', function (frame) {
                console.log('Connected: ' + frame);
                stompClient.subscribe('/user/queue/messages', function (message) {
                    showMessage(JSON.parse(message.body));
//                    insertService("________________________2_____" + (JSON.parse(message.body).message));
                });
            });
        }

        function connectGroup() {
            socketToken = new SockJS('/www.livesexhouse.com/token');
            stompToken = Stomp.over(socketToken);
            inviteI = true;
            channel = null;
            channel = '/www.livesexhouse.com/group';
            $("#newP").empty();
            sentToUser = inviteGirl;
            grStrt = true;
            grStarted = true;
            insertService("YOU ARE IN GROUP CHAT WITH " + inviteGirl);
            socket = new SockJS('/www.livesexhouse.com/group');
            stompClient = Stomp.over(socket);
            stompClient.connect('', '', function (frame) {
                console.log('Connected: ' + frame);
                stompClient.subscribe('/user/queue/messages', function (message) {
                    showMessageGroup(JSON.parse(message.body));
                    // napravi drugi show funkciju da se vidi samo od devojke a tamo stavi ko salje: pa poruku da se ne vidi ako posalje uljez
//                    insertService("________________________3_____" + (JSON.parse(message.body).message));
                });
            });
        }

        function connectService() {
            socket2 = new SockJS('/www.livesexhouse.com/service');
            socket3 = new SockJS('/www.livesexhouse.com/service');
            stompClient2 = Stomp.over(socket2);
            stompClient2.connect('', '', function (frame) {
                console.log('Connected: ' + frame);
                stompClient2.subscribe('/user/queue/messages', function (message) {
                    showMessageService(JSON.parse(message.body));
//                    insertService("________________________4_____" + (JSON.parse(message.body).message));
                });
            });
            stompClient3 = Stomp.over(socket3);
            stompClient3.connect('', '', function (frame) {
                console.log('Connected: ' + frame);
                stompClient3.subscribe('/queue/messages/' + inviteGirl, function (message) {
                    showMessageService(JSON.parse(message.body));
//                    insertService("________________________5_____" + (JSON.parse(message.body).message));
                });
            });
        }


        function disconnectPublic() {
            stompClient.disconnect();
            stompClient = null;
            sentToUser = null;
            socket = null;
        }
        function disconnectPrivate() {
            stompClient.disconnect();
            stompClient = null;
            sentToUser = null;
            socket = null;
            inviteI = false;
            stompClient = null;
            socket = null;
            stompClient2 = null;
            socket2 = null;
            stompClient3 = null;
            socket3 = null;
            sentToUser = null;
            channel = null;
            girlAccepted = false;
            groupAccepted = false;
            inviteGirlB = false;
            privateStarted = false;
            groupStarted = false;
            inviteI = false;
            inviteGirlBGroup = false;
            girlSentInvite = false;
            acceptedGroupInvitation = false;
            iSentInvitationGroup = false;
            grStarted = false;
            connectPublic();
            connectService();
            socketToken = null;
            stompToken = null;

        }
        function disconnectGroup() {
            stompClient.disconnect();
            stompClient = null;
            socket = null;
            stompClient2 = null;
            socket2 = null;
            stompClient3 = null;
            socket3 = null;
            sentToUser = null;
            channel = null;
            girlAccepted = false;
            groupAccepted = false;
            inviteGirlB = false;
            privateStarted = false;
            groupStarted = false;
            inviteI = false;
            inviteGirlBGroup = false;
            girlSentInvite = false;
            acceptedGroupInvitation = false;
            iSentInvitationGroup = false;
            grStarted = false;
            connectPublic();
            connectService();
            socketToken = null;
            stompToken = null;
        }



        function showMessageGroup(message) {

 if (message.message.indexOf('scrpt&$@Injection$!@') >= 0) {
                if (message.sender === whoami) {
                    window.location.replace("../logout");
                } else {
                    
                }
                
                
            } else {


            if (message.message.indexOf('nemateDovoljnoKesa###@@@') >= 0) {
                if (message.sender === whoami) {

                    window.location.replace("../webcam");
                    alert("U don't have enought tokens");

                }
            } 
            else if (message.message.indexOf('Girl#(^Leave@@^((Group$$&))') >= 0) {
                if (message.sender === inviteGirl) {
                    alert('Girl leave group chat');
                    location.reload();
                }

            } 
            else if (message.message.indexOf('@#$&#@$6no*$%*$22') >= 0) {
               

            } 
        
        
        else {
                if (message.sender === inviteGirl) {
                    insertService(message.message);
                }
            }


            }


        }




        function showMessage(message) {
            
            
            if (message.message.indexOf('scrpt&$@Injection$!@') >= 0) {
                if (message.sender === whoami) {
                    window.location.replace("../logout");
                } else {
                    
                }
                
                
            } else {
            
            
            
            if (privateStarted) {
                if (message.sender === whoami) {

                    if (message.message.indexOf('&#@%he5re@+^') >= 0) {

                    } else {
                        insertP('me', message.message);
                    }

                }
                if (message.sender === inviteGirl) {
                    insertP(message.sender, message.message);
                }
            } else {
                if (message.sender === whoami) {
                    insertP('me', message.message);
                } else {

                    if (message.sender === inviteGirl) {

                        insertP(message.sender, message.message);

                    } else {
                        insertP(message.sender, message.message);
                    }

                }
            }
        }
            
            
            
            
            
        }



        function showMessageService(message) {
            
            
            if (message.message.indexOf('scrpt&$@Injection$!@') >= 0) {
                if (message.sender === whoami) {
                    window.location.replace("../logout");
                } else {
                    
                }
                
                
            } else { 
            
            if (message.message.indexOf('@#$&#@$6no*$%*$22') >= 0 && grStarted) {
                if(message.sender === inviteGirl){
                        alert('private chat is not available now');
                        prOff();
//                        $('a#inv').text('girl not accepted');
                        setTimeout(function () {
                            $('a#inv').text('private');
                            prOn();
//                            alert('t1');
                        }, 300000);
//                        changeTime 300000
                    }
                }
            
            
            if (grStarted) {
            if (message.message.indexOf('Are you sure you want to invite this girl to private chat') >= 0) {
                
                 if (message.sender === whoami) {
                      if (confirm(message.message) === true) {
                                inviteGirlB = true;
newBool = true;
                                stompClient.send('/www.livesexhouse.com/service', {}, JSON.stringify({
                                    'recipient': inviteGirl,
                                    'message': "invitePrivate"
                                }));
                                $('a#inv').text('please wait..');
                                
                            } else {
                            }
                 }
                 
                 
            } 
        }
            
            
if (message.message.indexOf('The girl is in private mode') >= 0 && grStrt && !inviteGirlB && !newBool) {
    alert('The girl is in private mode');
    location.reload();
}
            
            
            
            


if (message.message.indexOf('##%Girl*$&Reset') >= 0) {
                if (message.sender === inviteGirl) {
                   location.reload();
                }

            }




            if (message.message.indexOf('I accepted invitation from you.') >= 0) {
                if (message.sender === inviteGirl) {
                    alert('Girl accepted group invitation from you, please wait for other users..');
                    girlAcceptedGroupFromMe = true;
                    stompClient.send('/www.livesexhouse.com/service', {}, JSON.stringify({
                        'recipient': inviteGirl,
                        'message': "acceptGroupFromUser"
                    }));
                    $('a#gr').text('please wait..');
                    iAcceptedGroup = true;
                }

            }



            if (message.message.indexOf('@@#$#$&ut$^@%Of*%@Ussers#@#%#*!^') >= 0 && grStarted) {
                if (message.sender === inviteGirl) {
                    alert('group chat is closed, not enought users in group');
                    location.reload();
                }

            }

            if (message.message.indexOf('Girl#(^Leave@@^((Group$$&))') >= 0) {
                if (message.sender === inviteGirl) {
                    alert('group chat is closed, girl leave');
                    location.reload();
                }

            }
            
            if (message.message.indexOf('@Girl_#(^Leave@@^((Group$$&))__') >= 0) {
                if (message.sender === inviteGirl) {
                    alert('group chat is closed, girl leave');
                    location.reload();
                }

            }


            if (message.message.indexOf('@@#$&ut$^Of*%@Ussers##*#@%$!^') >= 0 && grStarted) {
                if (message.sender === inviteGirl) {
                    alert('group chat is closed, not enought users in group');
                    location.reload();
                }
            }


            if (message.sender === inviteGirl) {
                if (message.message.indexOf('tt$ii^pp^*') >= 0) {
                    insertService(message.message.substring(9));
                }
                
                 if (message.message.indexOf('tt$ii^pp^King') >= 0) {
                    
                    var newKing = message.message.substring(14);
                    insertKing(message.message.substring(14));
                    
                    
                }
                
                
                if (message.message.indexOf('Group chat not available now') >= 0) {
                    alert("Group chat not available now");
                    $('a#gr').text('group chat');
                    $('a#gr').css("color", 'gray');
                    
                   grOff();

                    
                    setTimeout(function () {
//                                    alert('now you can invite this girl to group chat again');
                                    inviteGirlBGroup = false;
                                    $('a#gr').css("color", 'white');
//                                    alert('t5');
                                        grOn();
                                }, 300000);
//                                changeTime 300000
                    
                    
                    
                    
                }


            }


            if (message.sender === whoami) {
                if (message.message.indexOf('&#@%he5re@+^') >= 0) {

                    stompToken.send('/www.livesexhouse.com/token', {}, JSON.stringify({
                        'recipient': whoami,
                        'message': message.message
                    }));

                }
            }


            if (message.sender === inviteGirl) {
                if (message.message.indexOf('You do not have enough tokens, try a smaller amount') >= 0) {
                    alert('You do not have enough tokens, try a smaller amount');
                }
            }




if (message.sender === inviteGirl) {
                    if (message.message.indexOf('yes%%#*^Private##%&(') >= 0) {
                                               $('a#inv').text('girl accepted');
                        setTimeout(function () {
                            $('a#inv').text('leave private');
                        }, 2000);
                        privateStarted = true;
                        disconnectPublic();
                        connectPrivate();
                        girlAccepted = true;
                        groupAccepted = false;
                        openVideo();
                        
                    }
                }


            if (!grStarted) {


                if (message.sender === inviteGirl) {
                    if (message.message.indexOf('yes%%#*^Private##%&(') >= 0) {
                                               $('a#inv').text('girl accepted');
                        setTimeout(function () {
                            $('a#inv').text('leave private');
                        }, 2000);
                        privateStarted = true;
                        disconnectPublic();
                        connectPrivate();
                        girlAccepted = true;
                        groupAccepted = false;
                        openVideo();
                        
                    }
                    if (message.message.indexOf('@#$&#@$6no*$%*$22') >= 0) {
                        alert('private chat is not available now');
//                        $('a#inv').text('girl not accepted');
$('a#inv').css("color", 'gray');
$('a#inv').text('private');
prOff();
                        setTimeout(function () {
                            
                             $('a#inv').css("color", 'white');
                            
                            prOn();
                            
                            inviteGirlB = false;
                            
                            
                        }, 300000);
//                        changeTime 300000
                    }
                    if (message.message.indexOf('noGroup') >= 0) {
//                        alert('sss noGroup');
                        $('a#gr').text('girl not accepted');
                        setTimeout(function () {
                            $('a#gr').text('group chat');
                            alert('t3');
                        }, 2000);
                    }
                    if (message.message.indexOf('leaveGroup') >= 0) {
                        alert('girl leave your group chat');
                        disconnectGroup();
                        connectPublic();
                        $("#newP").empty();
if(status !== 3 || status !== 4){
                insertService("YOU ARE IN PUBLIC CHAT WITH " + inviteGirl);
            }
                    }
                    if (message.message.indexOf('lea%(vePri()@#vate') >= 0) {
                        alert('girl leave your private chat');
                        location.reload();

                        
                    }

                    if (message.message.indexOf('groupChatIsReady') >= 0) {
                        blink = false;
                        // krece grupni
                        if(iAcceptedGroup){
                        $('a#gr').text('leave group');

                        disconnectPublic();
                        connectGroup();}
                    else {
                        setTimeout(function () {
                                location.reload();
                                
                            }, 1000);
                        
                    }
                        
                    }


                    if (message.message.indexOf('Users for group chat ') >= 0) {
                        insertService(message.message);
                    }



                }

                if (message.sender === whoami) {

                    if (message.message.indexOf('nemateDovoljnoKesa###@@@') >= 0) {
                        window.location.replace("../webcam");
                        alert("U don't have enought tokens");
                    }








                    if (message.message.indexOf('accepted your invitation for group chat, please wait for other users') >= 0) {

                        insertService(message.message);

                    }



                    if (message.message.indexOf('You do not have enough tokens') >= 0) {
                        alert("You do not have enough tokens");
                        $('a#gr').text('buy tokens');
                    }




                    if (message.message.indexOf('Are you sure you want to invite this girl to private chat') >= 0) {
                       
                        if (!inviteGirlB) {
                            if (confirm(message.message) === true) {
                                inviteGirlB = true;
                                stompClient.send('/www.livesexhouse.com/service', {}, JSON.stringify({
                                    'recipient': inviteGirl,
                                    'message': "invitePrivate"
                                }));
                                $('a#inv').text('please wait..');
                                
                            } else {
                            }
                        } else {
                            alert('you must wait 5 minutes');
                            
                        }
                    }






                    if (message.message.indexOf('Are you sure you want to invite this girl to group chat?') >= 0) {
                        if (groupAlredyStarted && !inviteGirlBGroup) {
                            var msgOrigin = message.message;
                            var newMsg = msgOrigin.replace("Are you sure you want to invite this girl to group chat?", "Are you sure you want to join this group chat?");
                            if (confirm(newMsg) === true) {
                                inviteGirlBGroup = true;
                                stompClient.send('/www.livesexhouse.com/service', {}, JSON.stringify({
                                    'recipient': inviteGirl,
                                    'message': "acceptGroupFromUser"
                                }));
                                $('a#gr').text('Leave group');
                                iAcceptedGroup = true;
//                                alert('poceo');
                            } else {
                            }
                        } 
                        
                        
                      else if (!inviteGirlBGroup && !groupAlredyStarted) {
                            if (confirm(message.message) === true) {
                                inviteGirlBGroup = true;

                                stompClient.send('/www.livesexhouse.com/service', {}, JSON.stringify({
                                    'recipient': inviteGirl,
                                    'message': "inviteGroupFromUser"
                                }));
                                $('a#gr').text('please wait..');

                            } else {
                            }
                        }
                        
                    
                    else {
                            if (!inviteGirlBGroup) {
                            } else {
                                alert('you must wait 5 minutes');
                                
                            }
                        }
                    }















                    if (message.message.indexOf('Are you sure you want to join this group chat?') >= 0) {

                        if (confirm(message.message) === true) {
                            inviteGirlBGroup = true;
                            acceptedGroupInvitation = true;
                            stompClient.send('/www.livesexhouse.com/service', {}, JSON.stringify({
                                'recipient': inviteGirl,
                                'message': "acceptGroupFromUser"
                            }));
                            $('a#gr').text('please wait..');
                            iAcceptedGroup = true;


                        } else {
                        }
                    }





                }






                if (message.sender === inviteGirl && inviteI === false && !inviteGirlB) {
                    if (message.message.indexOf('The girl is in private mode') >= 0) {
                        alert('The girl is in private mode');
                        window.location.replace("../webcam");
                    }
                }


                if (message.sender === inviteGirl && inviteI === false) {
                    if (message.message.indexOf('The girl is in group mode') >= 0) {
                        alert('The girl is in group mode');
//                    window.location.replace("../webcam");
                    }
                }

                if (message.sender === inviteGirl && inviteGirlBGroup === false) {
                    if (message.message.indexOf('want group chat, to accept click join group chat') >= 0) {
                        $('a#gr').text('Join group');
//                        $("a#gr").css("color", "greenyellow");
initBlink();
                        girlSentInvite = true;
                        insertServiceGreen(message.message);
                        setInterval();
                    }
                }

                if (message.sender === inviteGirl && inviteGirlBGroup === true && !girlAcceptedGroupFromMe) {
                    if (message.message.indexOf('want group chat, to accept click join group chat') >= 0) {
                        inviteGirlB = false;
                        $('a#gr').text('Join group');
                        girlSentInvite = true;
                        again = true;
                        insertServiceGreen(message.message);
                        initBlink();
                    }
                }


            }
            }
        }
var blink = true;

 
function initBlink()
{
    var state = false;
    setInterval(function()
        {
            if(blink){
            state = !state;
            var color = (state?'#920000':'#F00');
            $("#tabGr").css("background-color", color);}
        else {
            $("#tabGr").css("background-color", color);
            }
        }, 500);
}



        function invitePrivate() {
            if (privateStarted) {
                if (confirm('Are you sure to leave this private chat') === true) {
                    stompClient.send('/www.livesexhouse.com/service', {}, JSON.stringify({
                        'recipient': inviteGirl,
                        'message': "leave*#^Private@#&$"
                    }));
                    location.reload();
                    privateStarted = false;
                    inviteGirlB = false;
                    $('a#inv').text('private');
                    disconnectPrivate();
                    connectPublic();
                    $("#newP").empty();

                    insertService("YOU ARE IN PUBLIC CHAT WITH " + inviteGirl);
                } else {
                }
            } else {
                stompClient.send('/www.livesexhouse.com/service', {}, JSON.stringify({
                    'recipient': selectedGirl,
                    'message': "invitePrivatePrice"
                }));
            }

        }


        function inviteGroup() {
            if (groupStarted || grStarted) {
                if (confirm('Are you sure to leave this group chat?') === true) {
                    stompClient.send('/www.livesexhouse.com/service', {}, JSON.stringify({
                        'recipient': inviteGirl,
                        'message': "leave#$^Group#$%^From&#!User"
                    }));
                    groupStarted = false;
                    inviteGirlBGroup = false;
                    $('a#inv').text('private');
                    disconnectPrivate();

                    $("#newP").empty();

                    insertService("YOU ARE IN PUBLIC CHAT WITH " + inviteGirl);
                    location.reload();
                } else {
                }
            } else if (girlSentInvite && !acceptedGroupInvitation) {
                //ako je poslala zahtev za joinGroup
                stompClient.send('/www.livesexhouse.com/service', {}, JSON.stringify({
                    'recipient': inviteGirl,
                    'message': "inviteGroupPriceJoin"
                }));


            } else if (!acceptedGroupInvitation) {
                stompClient.send('/www.livesexhouse.com/service', {}, JSON.stringify({
                    'recipient': inviteGirl,
                    'message': "inviteGroupPrice"
                }));
            } else if (again) {
//                alert('ooo');
                stompClient.send('/www.livesexhouse.com/service', {}, JSON.stringify({
                    'recipient': inviteGirl,
                    'message': "inviteGroupPriceJoin"
                }));



            }

        }






        function sendMessage() {
            var chatInput = '#input-chat';
            
            
            var message = $(chatInput).val();
            if (!message.length) {
                return;
            }
            stompClient.send(channel, {}, JSON.stringify({
                'recipient': sentToUser,
                'message': message
            }));
            if (grStarted) {
                insertP("me", message);
            }
            $(chatInput).val('');
            $(chatInput).focus();
        }



        function tip() {
            var e = $("input[name=ageInputName]").val();
            $('.tip-popup').removeClass('tip-open');
            stompClient.send('/www.livesexhouse.com/service', {}, JSON.stringify({
                'recipient': selectedGirl,
                'message': "tt$ii^pp* " + e
            }));

        }

        function getChatWindow() {
            var chatSubmit = $('<button>', {id: 'submit-chat', type: 'submit', class: 'chat-submit'});
            chatSubmit.html('Send');
            chatSubmit.click(function (event) {
                sendMessage();

            });
        }

        function handle(e) {
            if (e.keyCode === 13) {
                e.preventDefault();
                sendMessage();

            }
        }



        function insertP(user, msg) {
            $("#newP").append("<p>" + user + ": " + msg + "</p>");
        }

        function insertService(msg) {
            $("#newP").append("<p>" + msg + "</p>");
        }
        
        function insertServiceGreen(msg) {
            $("#newP").append('<p style="color:greenyellow; text-transform: uppercase;">' + msg + "</p>");
        }

        function insertKing(user){
            $("#newP").append(notice1 + user + notice2);
        }


        function ttt111() {
            var video = document.getElementById('my_video_1');
            var source = document.getElementById('ttt222');
            video.pause();
            source.setAttribute('src', lnk);
            video.load();
            video.play();
        }


        function closeVideo() {
            var video = document.getElementById('my_video_1');
            var source = document.getElementById('ttt222');
            video.pause();
            source.setAttribute('src', "");
            video.load();
            video.play();
            $('p#test8').text('>>>> video OFF');
        }

        function openVideo() {
            var video = document.getElementById('my_video_1');
            var source = document.getElementById('ttt222');
            video.pause();
            source.setAttribute('src', lnk);
            video.load();
            video.play();
            $('p#test8').text('>>>> video ON');
        }



function grOn() {
    var elem = $('.page-chat .video-tabs .gr');

elem.hover(function () {
    $(this).css("background-color","#f00");
}, function () {
    $(this).css("background-color","#920000");
});
}

function grOff() {
    var elem = $('.page-chat .video-tabs .gr');

elem.hover(function () {
    $(this).css("background-color","#920000");
}, function () {
    $(this).css("background-color","#920000");
});
}

function prOn() {
    var elem = $('.page-chat .video-tabs .pr');

elem.hover(function () {
    $(this).css("background-color","#f00");
}, function () {
    $(this).css("background-color","#920000");
});
}

function prOff() {
    var elem = $('.page-chat .video-tabs .pr');

elem.hover(function () {
    $(this).css("background-color","#920000");
}, function () {
    $(this).css("background-color","#920000");
});
}




        function videoStatus() {
            






            if (status === '3') {
                $('a#gr').text('join group');
                groupAlredyStarted = true;
                insertService("Girl is in group chat , to join her group click 'JOIN GROUP'" );
                closeVideo();
                initBlink();
            }
            
            if (status === '2') {
                
//                insertService("Girl is in group chat , to join her group click 'JOIN GROUP'" );
                openVideo();
            }
            
            if (status === '4') {
                
//                insertService("Girl is in group chat , to join her group click 'JOIN GROUP'" );
                closeVideo();
                
            }
            
            
            
            
        }







        $(document).ready(function () {


            connectPublic();
            connectService();
            videoStatus();
              $('#input-chat').bind("paste",function(e) {
      e.preventDefault();
  });
            
            timeSetup();


        });


    </script>


    
    
    
    
</body>
</html>
