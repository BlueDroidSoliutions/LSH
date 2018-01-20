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










    <div id="page-wrap">
        <div class="content">
            <div class="wrapper">
                <div class="livestream clearfix">
                    <div class="stream-rooms desktop-only">
                       <!--  <img src="${location}/assets/img/content/housemap.svg" alt="House Map" class="housemap"> -->
                        <div class="room-links">

                          
                                    
                                    <c:forEach items="${vr}" var="vr">
                                        <a href="javascript:;" data-id="${vr.name}">${vr.name}</a>
                                    </c:forEach>
                                    
                                    
                                    
                        </div>

                        <span class="selected-room">Entry</span>
                        <ul class="room-navigation">
                            
                            
                            <c:forEach items="${vr}" var="vr">
                                <li data-room="${vr.name}">
                                        <a href="javascript:;" data-link="${vr.link}"><span>${vr.name}</span></a>
                                        <ul>
                                            <li>
                                                <a href="javascript:;">Camera IP</a>
                                            </li>
                                            <li>
                                                <a href="javascript:;">Camera PTZ</a>
                                            </li>
                                        </ul>
                                    </li>
                            
                            </c:forEach>
                            
                            
                           
                            
                            
                            
                        </ul>
                    </div>
                    <div class="stream-main clearfix">
<!--                        <div class="stream-video">
                            <img src="${location}/assets/img/content/stream-preview.jpg" alt="Preview">
                            <a class="overlay" href="javascript:;"></a>
                        </div>-->
                            
                            
                            
                            
                            
                            
                              <div class="stream-video">
                                   <!--  <img src="assets/img/content/stream-preview.jpg" alt="Preview"> -->
                                   <div class="videoWrapper">
                                        <div class="overlay">
                                            <h2>Live stream</h2>
                                        </div>
                                        <video src="" id="my_video_1" class="video-js vjs-default-skin" controls autoplay data-setup='{ "aspectRatio":"16:9", "autoplay": true }'></video>

                                    </div>
                                    <a class="overlay" href="javascript:;"></a>
                                </div>
                                 <div class="stream-rooms mobile-only" >
                               <!--  <img src="assets/img/content/housemap.svg" alt="House Map" class="housemap"> -->
                               <div class="room-links">

                                   <c:forEach items="${vr}" var="vr">
                                       <a href="javascript:;" data-id="${vr.name}">${vr.name}</a>
                                   </c:forEach>
                                   
                                   
                                   
                                    
                                 
                                    
                                    
                                    
                                    
                               </div>
                              
                                <span class="selected-room">Entry</span>
                                <ul class="room-navigation">
                                    
                                    
                                    <c:forEach items="${vr}" var="vr">
                                         <li data-room="${vr.name}">
                                        <a href="javascript:;" data-link="${vr.link}"><span>${vr.name}</span></a>
                                        <ul>
                                            <li>
                                                <a href="javascript:;">Camera IP</a>
                                            </li>
                                            <li>
                                                <a href="javascript:;">Camera PTZ</a>
                                            </li>
                                        </ul>
                                    </li>
                                    </c:forEach>
                                    
                                   
                                    
                                    
                                    
                                    
                                    
                                </ul>
                            </div>
                            
                            
                            
                            
                            
                        <a href="./webcammember/${onlineMember}" class="sex-cam">Live Sex Cam <span>with housemates</span></a>
                        <div class="vote-section">
                            <div class="inner">
                                <div class="heading">
                                    <h3>Vote rate</h3>
                                    <p>Top 5</p>
                                </div>
                                <ul class="vote-list">
                                    
                                    
                                    
                                    
                                    
                                     <c:forEach items="${mh}" var="mh">
                                    
                                    <li>
                                        <span class="number-of-votes">${mh.vote}</span>
                                       <a href="./voteFromIndex/${mh.id}">
                                            <span class="vote"><span>Vote</span></span>
                                            <img src="${location}/assets/img/content/profile-s.png" alt="">
                                        </a>
                                        <span class="name">${mh.name}</span>
                                    </li>
                                     </c:forEach>
                                    
                                    
                                    
                                    
                                </ul>
                            </div>
                        </div>
                    </div>
                        
                        
                        
                        
                        
                        
                    <div class="stream-aside">
                        <div class="chat-section">
                            <div class="chat-box">
                                <div class="chat-box-middle">
                                    <div class="chat-content">
                                        <div class="fakeScroll" id="newP">
                                            <h3>Users Chat</h3>

                                        </div>
                                    </div>
                                </div>









                                <div class="chat-box-bottom">
                                    <input class="chat-input" id="input-chat" type="text" placeholder="Send a message..." onkeypress="handle(event)">
                                    <button id="submit-chat" type="submit" class="chat-submit" onclick="sendMessage()">Send</button>
                                </div>










                            </div>
                        </div>
                        <div class="live-web-chat">
                            <a href="./webcam">Live Now Web Chat <span>View all</span></a>
                            <img src="${location}/assets/img/content/live-chat.png" alt="live chat">
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="footer.jsp" %>
    </div>
</div>










<!--<script src="./resources/st2/jquery.js"></script>-->

<!--[if lt IE 7]>
   <p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
<![endif]-->







<script type="text/javascript">

                                        var stompClient = null;
                                        var socket = null;
                                        var whoami = "null";

                                           

                                        function connect() {
                                            socket = new SockJS('/www.livesexhouse.com/liveStream');
                                            stompClient = Stomp.over(socket);
                                            stompClient.connect('', '', function (frame) {
                                                whoami = frame.headers['user-name'];

                                                console.log('Connected: ' + frame);
                                                stompClient.subscribe('/queue/messages/ls', function (message) {
                                                    showMessage(JSON.parse(message.body));
                                                });
                                            });
                                        }

                                        function insertP(user, msg) {
                                            $("#newP h3:first-child").append("<p>" + user + ": " + msg + "</p>");
                                        }

                                        function disconnect() {
                                            stompClient.disconnect();
                                            console.log("Disconnected");
                                        }
//
                                        function sendMessage() {
                                            var chatInput = '#input-chat';
                                            var message = $(chatInput).val();
                                            if (!message.length) {
                                                return;
                                            }
                                            stompClient.send('/www.livesexhouse.com/liveStream', {}, JSON.stringify({
                                                'recipient': 'ls',
                                                'message': message
                                            }));
                                            $(chatInput).val('');
                                            $(chatInput).focus();
                                        }


                                        function getChatWindow() {

                                            var chatSubmit = $('<button>', {id: 'submit-chat', type: 'submit', class: 'chat-submit'})
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



                                        function showMessage(message) {

                                            if (message.sender === whoami) {
                                                insertP('me', message.message);
                                            } else {
                                                insertP(message.sender, message.message);
                                            }

                                        }


                                        $(document).ready(function () {
                                            connect();
                                        });
</script>





 <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
        <script type="text/javascript">window.jQuery || document.write("<script src='${location}/assets/scripts/main/jquery-1.8.3.min.js'>\x3C/script>")</script>
        <script type="text/javascript" src="${location}/assets/scripts/libs/jquery.flexslider-min.js"></script>
        <script type="text/javascript" src="${location}/assets/scripts/libs/jQuery.fakeScroll.js"></script>
        <script type="text/javascript" src="${location}/assets/scripts/libs/jcf.js"></script>
        <script type="text/javascript" src="${location}/assets/scripts/libs/jcf.range.js"></script>
        <script type="text/javascript" src="${location}/assets/scripts/main/default.js"></script>

        
<!--        <link href="http://vjs.zencdn.net/6.2.8/video-js.css" rel="stylesheet">
        <script type="text/javascript" src="http://vjs.zencdn.net/6.2.8/video.js"></script>
        <script type="text/javascript" src="${location}/assets/scripts/libs/videojs-contrib-hls.min.js"></script>-->

        

<script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.js"></script>
<script src="./resources/st2/sockjs.js"></script>
<!--
<script>
        var defaultCam = '<c:out value="${defaultCam}"/>';
</script>

        <script>
            jQuery(function ($) {

    if (Hls.isSupported()) {
      var linkValue = defaultCam;
      

      $('.room-navigation a').click(function () {
        linkValue = $(this).attr('data-link');
        console.log(linkValue);
      });

      var video = document.getElementById('my_video_1');
      var hls = new Hls();
      hls.loadSource(linkValue);
      hls.attachMedia(video);
      hls.on(Hls.Events.MANIFEST_PARSED, function () {
        video.play();
      });
      console.log('link:', linkValue);
    }

  });
        </script>
-->






</body>
</html>
