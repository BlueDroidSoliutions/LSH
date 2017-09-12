<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>


    <head>
        <title>with_Girl</title>
        <!--<script src="./resources/st2/sockjs-0.3.4.js"></script>-->
        <!--<script src="./resources/st2/stomp.js"></script>-->
        <!--<script src="./resources/st2/jquery-2.1.0.min.js"></script>-->


        <script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.js"></script>
        <script src="./resources/st2/sockjs.js"></script>
        <script src="./resources/st2/jquery.js"></script>



        <link href="./resources/st2/chat.css" rel="stylesheet" type="text/css">
    </head>
    <body>

        <p style="color: white">User Name: ${userName}</p>
        <p  style="color: white">Girl name: ${girl}</p>
        <p id="id1" style="background-color: red; color: white"></p>

        <script>
            var selectedGirl = '<c:out value="${girl}"/>';
        </script>

        <button id="invite" onclick="invite()"> invite </button>

        <!--    <button id="connBtn" onclick="connect()"> connect </button>
            <button id="getChatWin" onclick="getChatWindow()"> getChatWin </button>
            <button id="showActive" onclick="showActive()"> showActive </button>
            <button id="showMessage" onclick="showMessage(selectedGirl)"> showMessage </button>-->


        <script type="text/javascript">
            var stompClient = null;
            var socket = null;
            var whoami = null;
            var me = false;


            function connect() {
                document.body.style.backgroundColor = 'black';
                socket = new SockJS('/www.livesexhouse.com/group');
                stompClient = Stomp.over(socket);
                stompClient.connect('', '', function (frame) {
                   sentTo = selectedGirl;
                    chanel = '/www.livesexhouse.com/group';
                    whoami = frame.headers['user-name'];
                    console.log('Connected: ' + frame);
                    stompClient.subscribe('/queue/messages/' + selectedGirl, function (message) {
                        showMessage(JSON.parse(message.body));
                    });
                });
            }

function connectPrivate() {
                document.body.style.backgroundColor = 'black';
                socket = new SockJS('/www.livesexhouse.com/group');
                stompClient = Stomp.over(socket);
                stompClient.connect('', '', function (frame) {
                   sentTo = selectedGirl;
                    chanel = '/www.livesexhouse.com/chat';
                    whoami = frame.headers['user-name'];
                    console.log('Connected: ' + frame);
                    stompClient.subscribe('/user/queue/messages/', function (message) {
                        showMessage(JSON.parse(message.body));
                    });
                });
            }



            function invite() {

                stompClient.subscribe('/queue/messages/' + whoami, function (messageI) {
                    showMessageInvite(JSON.parse(messageI.body));
                });

                insertText('please wait..');

                var message = '*$*' + selectedGirl + '*$* user with username: "' + whoami + '" want private chat';

                stompClient.send("/www.livesexhouse.com/group", {}, JSON.stringify({
                    'recipient': selectedGirl,
                    'message': message
                }));
me= true;
            }

            function insertText(txt) {
                document.getElementById('id1').innerHTML = txt;
            }




            function showMessageInvite(message) {
                //        var chatWindowTarget = selectedGirl;
                //        var chatContainer = getChatWindow(chatWindowTarget);
                //        var chatWindow = chatContainer.children('.chat');
                //        var userDisplay = $('<span>', {class: (message.sender === whoami ? 'chat-sender' : 'chat-recipient')});
                //        userDisplay.html(message.sender + ' says: ');
                //        var messageDisplay = $('<span>');
                //        messageDisplay.html(message.message);
                //        chatWindow.append(userDisplay).append(messageDisplay).append('<br/>');
                //        chatWindow.animate({ scrollTop: chatWindow[0].scrollHeight}, 1);
                //        if (message.sender !== whoami) {
                //          var sendingUser = $('#user-' + message.sender);
                //          if (!sendingUser.hasClass('user-selected') && !sendingUser.hasClass('pending-messages')) {
                //            sendingUser.append(newMessageIcon());
                //            sendingUser.addClass('pending-messages');
                //          }
                //        }

//                alert("please wait, girl thinking..");



            }



            function disconnect() {
                stompClient.disconnect();
                console.log("Disconnected");
            }
            //
            function sendMessageTo(selectedGirl,chanel) {
                var chatInput = '#input-chat-' + selectedGirl;
                var message = $(chatInput).val();
                if (!message.length) {
                    return;
                }
                stompClient.send(chanel, {}, JSON.stringify({
                    'recipient': selectedGirl,
                    'message': message
                }));
                $(chatInput).val('');
                $(chatInput).focus();
                insertText('');
            }
            //      
            function getChatWindow(userName) {

                var existingChats = $('.chat-container');


                var elementId = 'chat-' + userName;
                console.log('chat ' + userName);


                var containerId = elementId + '-container';
                console.log('elementId ' + elementId);


                var selector = '#' + containerId;
                console.log('containerId ' + containerId);


                var inputId = 'input-' + elementId;
                //        if (!$(selector).length) {
                var chatContainer = $('<div>', {id: containerId, class: 'chat-container'});
                var chatWindow = $('<div>', {id: elementId, class: 'chat'});
                var chatInput = $('<textarea>', {id: inputId, type: 'text', class: 'chat-input', rows: '2', cols: '75',
                    placeholder: 'Enter a message.  Something deep and meaningful.  Something you can be proud of.'});
                var chatSubmit = $('<button>', {id: 'submit-' + elementId, type: 'submit', class: 'chat-submit'})
                chatSubmit.html('Send');

                chatInput.keypress(function (event) {
                    if (event.which == 13) {
                        var user = event.currentTarget.id.substring(11); // gets rid of 'input-chat-'
                        event.preventDefault();
                        sendMessageTo(userName,chanel);
                    }
                });
                //          
                chatSubmit.click(function (event) {
                    var user = event.currentTarget.id.substring(12); // gets rid of 'submit-chat-'
                    sendMessageTo(user,chanel);
                });

                chatContainer.append(chatWindow);
                chatContainer.append(chatInput);
                chatContainer.append(chatSubmit);

                if (existingChats.length) {
                    chatContainer.hide();
                }

                $('body').append(chatContainer);
                //        }

                return $(selector);
            }
            //      
            function showMessage(message) {



                if (typeof message !== 'object') {

                    var chatWindowTarget = selectedGirl;
                    var chatContainer = getChatWindow(chatWindowTarget);
                    var chatWindow = chatContainer.children('.chat');
                    var userDisplay = $('<span>', {class: (message.sender === whoami ? 'chat-sender' : 'chat-recipient')});
                    userDisplay.html(message.sender + ' says: ');
                    var messageDisplay = $('<span>');
                    messageDisplay.html(message.message);
                    chatWindow.append(userDisplay).append(messageDisplay).append('<br/>');
                    chatWindow.animate({scrollTop: chatWindow[0].scrollHeight}, 1);
                    if (message.sender !== whoami) {
                        var sendingUser = $('#user-' + message.sender);
                        if (!sendingUser.hasClass('user-selected') && !sendingUser.hasClass('pending-messages')) {
                            sendingUser.append(newMessageIcon());
                            sendingUser.addClass('pending-messages');
                        }
                    }


                } else {




                        if(message.message.indexOf('*#$') >= 0){
                            var s = message.message;
                            var pi = message.message.indexOf('*#$');
                            var ai = s.indexOf('*#$', pi + 1);

                            var usr = s.substring(pi+3, ai);
                            
                            if(usr===whoami){
                                
                                
                                
                               
                                
                                if(message.message.substring(message.message.indexOf('!*#')+3,message.message.length)==='y'){
                                    insertText('');
                                insertText('now your chat is private');
                                
                                disconnect();
                                var openP = "http://localhost:8080/www.livesexhouse.com/chatWithGirlPrivate/"+selectedGirl;
                                 window.open(openP,"_self");
                                
                                
                                } else if (message.message.substring(message.message.indexOf('!*#')+3,message.message.length)==='n') {
                                    insertText('');
                                    insertText('girl not accept your request');
                                }
                                
                            }
                            
                            
                        }
                        
                        
                        
                    
                    if ((message.message.indexOf('*$*' + selectedGirl + '*$*') < 0) && (message.message.indexOf('*#$') < 0) 
                            && (message.message.indexOf('disconectFromUser666') < 0)
                            ) {

                        var chatWindowTarget = selectedGirl;
                        var chatContainer = getChatWindow(chatWindowTarget);
                        var chatWindow = chatContainer.children('.chat');
                        var userDisplay = $('<span>', {class: (message.sender === whoami ? 'chat-sender' : 'chat-recipient')});
                        userDisplay.html(message.sender + ' says: ');
                        var messageDisplay = $('<span>');
                        messageDisplay.html(message.message);
                        chatWindow.append(userDisplay).append(messageDisplay).append('<br/>');
                        chatWindow.animate({scrollTop: chatWindow[0].scrollHeight}, 1);
                        if (message.sender !== whoami) {
                            var sendingUser = $('#user-' + message.sender);
                            if (!sendingUser.hasClass('user-selected') && !sendingUser.hasClass('pending-messages')) {
                                sendingUser.append(newMessageIcon());
                                sendingUser.addClass('pending-messages');
                            }
                        }

                    }  
                    
//                    alert(message.message.indexOf('disconectFromUser666') >= 0);
                    
                    
                    
                    
                    if((message.message.indexOf('disconectFromUser66') >= 0) && (me===false)){
                        
                        
                        alert('girl is now in private chat, please look for another girl');
                        var openP = "http://localhost:8080/www.livesexhouse.com/chatActiveGirls";
           window.open(openP,"_self");
           disconect();
                    }
                       



                }
            }
            //      
            function newMessageIcon() {
                var newMessage = $('<span>', {class: 'newmessage'});
                newMessage.html('&#x2709;');
                return newMessage;
            }

            $(document).ready(function () {
                connect();
                showMessage(selectedGirl);
            });
        </script>
    </body>
</html>