<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>


<head>
<title>with_Users</title>

<!--<script src="./resources/st2/sockjs-0.3.4.js"></script>-->
<!--<script src="./resources/st2/stomp.js"></script>-->
<!--<script src="./resources/st2/jquery-2.1.0.min.js"></script>-->


<script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.js"></script>
<script src="./resources/st2/sockjs.js"></script>
<script src="./resources/st2/jquery.js"></script>



<link href="./resources/st2/chat.css" rel="stylesheet" type="text/css">
</head>
<body>
    
    <p  style="color: white">User Name: ${userName}</p>
   
    
    
    
  
   
<!--    
    <button id="connBtn" onclick="connect()"> connect </button>
    <button id="getChatWin" onclick="getChatWindow()"> getChatWin </button>
    <button id="showActive" onclick="showActive()"> showActive </button>-->
    
    
  <script type="text/javascript">
      var stompClient = null;
      var socket = null;
      var whoami = null;
      var sentTo = null;
      var chanel = null;
      var choose = null;
 

    function connect() {
        document.body.style.backgroundColor = 'black';
        socket = new SockJS('/www.livesexhouse.com/group');
        stompClient = Stomp.over(socket);
        stompClient.connect('', '', function(frame) {
        whoami = frame.headers['user-name'];
          sentTo = whoami;
           chanel = '/www.livesexhouse.com/group';
          console.log('Connected: ' + frame);
          stompClient.subscribe('/queue/messages/'+whoami, function(message) {
            showMessage(JSON.parse(message.body));
          });
        });
      }
      
      
      function connectPrivate(user) {
         
        document.body.style.backgroundColor = 'black';
        socket = new SockJS('/www.livesexhouse.com/chat');
        stompClient = Stomp.over(socket);
        stompClient.connect('', '', function(frame) {
        whoami = frame.headers['user-name'];
          sentTo = user;
          chanel = '/www.livesexhouse.com/chat';
          console.log('Connected: ' + frame);
          stompClient.subscribe('/user/queue/messages/', function(message) {
            showMessage(JSON.parse(message.body));
          });
        });
      }

    
    
      
      function disconnect() {
        stompClient.disconnect();
        console.log("Disconnected");
      }
//
      function sendMessageTo(sentTo,chanel) {
        var chatInput = '#input-chat-' + sentTo;
        var message = $(chatInput).val();
        if (!message.length) {
          return;
        }
        stompClient.send(chanel, {}, JSON.stringify({
          'recipient': sentTo,
          'message' : message
        }));
        $(chatInput).val('');
        $(chatInput).focus();
      }
      
     
//      
      function getChatWindow(userName) {
          document.body.style.backgroundColor = 'gray';
        var existingChats = $('.chat-container');
        var elementId = 'chat-' + userName;
        var containerId = elementId + '-container';
        var selector = '#' + containerId;
        var inputId = 'input-' + elementId;
        if (!$(selector).length) {
          var chatContainer = $('<div>', {id: containerId, class: 'chat-container'});
          var chatWindow = $('<div>', {id: elementId, class: 'chat'});
          var chatInput = $('<textarea>', {id: inputId, type: 'text', class: 'chat-input', rows: '2', cols: '75', 
            placeholder: 'Enter a message.  Something deep and meaningful.  Something you can be proud of.'});
          var chatSubmit = $('<button>', {id: 'submit-' + elementId, type: 'submit', class: 'chat-submit'})
          chatSubmit.html('Send');
          
          chatInput.keypress(function(event) {
            if (event.which == 13) {
              var user = event.currentTarget.id.substring(11); // gets rid of 'input-chat-'
              event.preventDefault();
              
              sendMessageTo(user,chanel);
            }
          });
//          
          chatSubmit.click(function(event) {
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
        }
        return $(selector);
      }
//      


 function sendMessageInvite(sentTo,chanel,choose) {
        var chatInput = '#input-chat-' + sentTo;
        
        stompClient.send(chanel, {}, JSON.stringify({
          'recipient': sentTo,
          'message' : '*#$'+sentTo+'*#$' + '!*#' + choose
        }));
        $(chatInput).val('');
        $(chatInput).focus();
      }


      function showMessage(message) {
          // prvo se shvata koji chat prozor treba da se loduje zasnovano na poredjenju primaoca sa nasim usernamom.
//        var chatWindowTarget = (message.recipient === whoami) ? message.sender : message.recipient;




        if (message.message.indexOf('*$*'+whoami+'*$*') >= 0) { 
            
           
            
            var txt;
    if (confirm(message.message.substring(3+whoami.length+3,message.message.length + '.')+'\n Do you want to accept? ') === true) {
        
            var s = message.message;
            var pi = message.message.indexOf('"');
            var ai = s.indexOf('"', pi+1);
            
            var usr = s.substring(pi+1,ai);
           

           
           
           choose = 'y';
           
           stompClient.send(chanel, {}, JSON.stringify({
          'recipient': sentTo,
          'message' : '*#$'+usr+'*#$' + '!*#' + choose  }));
      
      stompClient.send(chanel, {}, JSON.stringify({
          'recipient': sentTo,
          'message' : 'disconectFromUser666'  }));
      
                 disconnect();
//           connectPrivate(usr);
    var openP = "http://localhost:8080/www.livesexhouse.com/chatWithUsersPrivate/"+usr;
           window.open(openP,"_self");
            
          } else {
               var s = message.message;
            var pi = message.message.indexOf('"');
            var ai = s.indexOf('"', pi+1);
            
            var usr = s.substring(pi+1,ai);
           
          choose = 'n';
          stompClient.send(chanel, {}, JSON.stringify({
          'recipient': sentTo,
          'message' : '*#$'+usr+'*#$' + '!*#' + choose  }));
        
          }
        
        
       
            
            
            
        }   else { 


        
        var chatWindowTarget = whoami ;
        var chatContainer = getChatWindow(chatWindowTarget);
        
        var chatWindow = chatContainer.children('.chat');
        // kreira se span sa novom porukom
        var userDisplay = $('<span>', {class: (message.sender === whoami ? 'chat-sender' : 'chat-recipient')});
        userDisplay.html(message.sender + ' says: ');
        alert(message.sender);
        var messageDisplay = $('<span>');
        messageDisplay.html(message.message);
        chatWindow.append(userDisplay).append(messageDisplay).append('<br/>');
        chatWindow.animate({ scrollTop: chatWindow[0].scrollHeight}, 1);
        if (message.sender !== whoami) {
          var sendingUser = $('#user-' + message.sender);
          if (!sendingUser.hasClass('user-selected') && !sendingUser.hasClass('pending-messages')) {
            sendingUser.append(newMessageIcon());
            sendingUser.addClass('pending-messages');
          }
        }
        
    }
      }
//      
      function newMessageIcon() {
        var newMessage = $('<span>', {class: 'newmessage'});
        newMessage.html('&#x2709;');
        return newMessage;
      }
      
      $(document).ready(function() {
        connect();
      });
  </script>
</body>
</html>