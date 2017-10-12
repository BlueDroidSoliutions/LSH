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


<!-- javascript -->
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script type="text/javascript">window.jQuery || document.write("<script src='${location}/assets/scripts/main/jquery-1.8.3.min.js'>\x3C/script>")</script>
<script type="text/javascript" src="${location}/assets/scripts/libs/jquery.flexslider-min.js"></script>
<script type="text/javascript" src="${location}/assets/scripts/libs/jQuery.fakeScroll.js"></script>
<script type="text/javascript" src="${location}/assets/scripts/libs/jcf.js"></script>
<script type="text/javascript" src="${location}/assets/scripts/libs/jcf.range.js"></script>
<script type="text/javascript" src="${location}/assets/scripts/main/default.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.js"></script>
<script src="./resources/st2/sockjs.js"></script>
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









</body>
</html>
