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
        <p  style="color: white">${girl}</p>
        <p id="id1" style="background-color: red; color: white"></p>

        <script>
            var selectedGirl = '<c:out value="${privateG}"/>';
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
 

      function connect() {
        document.body.style.backgroundColor = 'black';
        socket = new SockJS('/www.livesexhouse.com/chat');
        stompClient = Stomp.over(socket);
        stompClient.connect('', '', function(frame) {
            
            // userName
          whoami = frame.headers['user-name'];
          
          
          console.log('Connected: ' + frame);
          
          
          // kada dobijemo poruku prikazuje se
          stompClient.subscribe('/user/queue/messages', function(message) {
            showMessage(JSON.parse(message.body));
          });
          
         // pretplacujemo se na kanal sa aktivnim userima i zovemo ovo kada ima apdejta
          stompClient.subscribe('/topic/active', function(activeMembers) {
            showActive(activeMembers);
            
            
          
             
          });
          
        });
       
      }
      
      
      function showActive(activeMembers) {
        renderActive(activeMembers.body);

        stompClient.send('/www.livesexhouse.com/activeUsers', {}, '');
      }
//      
      function renderActive(activeMembers) {
        var previouslySelected = $('.user-selected').text();
        var usersWithPendingMessages = new Object();
        $.each($('.pending-messages'), function(index, value) {
          usersWithPendingMessages[value.id.substring(5)] = true; // strip the user-
        });
        var members = $.parseJSON(activeMembers);
        var userDiv = $('<div>', {id: 'users'});
        $.each(members, function(index, value) {
          if (value === whoami) {
            return true;
          }
          var userLine = $('<div>', {id: 'user-' + value});
          userLine.addClass('user-entry');
          if (previouslySelected === value) {
            userLine.addClass('user-selected');
          }
          else {
            userLine.addClass('user-unselected');
          }
          var userNameDisplay = $('<span>');
          userNameDisplay.html(value);
          userLine.append(userNameDisplay);
          userLine.click(function() {
            var foo = this;
            $('.chat-container').hide();
            $('.user-entry').removeClass('user-selected');
            $('.user-entry').addClass('user-unselected');
            userLine.removeClass('user-unselected');
            userLine.removeClass('pending-messages');
            userLine.addClass('user-selected');
            userLine.children('.newmessage').remove();
            var chatWindow = getChatWindow(value);
            chatWindow.show();
          });
          if (value in usersWithPendingMessages) {
            userLine.append(newMessageIcon());
            userLine.addClass('pending-messages');
          }
          userDiv.append(userLine);
        });
        $('#userList').html(userDiv);
      }
//      
      function disconnect() {
        stompClient.disconnect();
        console.log("Disconnected");
      }
//
      function sendMessageTo(user) {
        var chatInput = '#input-chat-' + user;
        var message = $(chatInput).val();
        if (!message.length) {
          return;
        }
        stompClient.send("/www.livesexhouse.com/chat", {}, JSON.stringify({
          'recipient': user,
          'message' : message
        }));
        $(chatInput).val('');
        $(chatInput).focus();
      }
//      
      function getChatWindow(userName) {
          document.body.style.backgroundColor = 'black';
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
              sendMessageTo(user);
            }
          });
//          
          chatSubmit.click(function(event) {
            var user = event.currentTarget.id.substring(12); // gets rid of 'submit-chat-'
            sendMessageTo(user);
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
      function showMessage(message) {
        var chatWindowTarget = (message.recipient === whoami) ? message.sender : message.recipient;
        var chatContainer = getChatWindow(chatWindowTarget);
        var chatWindow = chatContainer.children('.chat');
        var userDisplay = $('<span>', {class: (message.sender === whoami ? 'chat-sender' : 'chat-recipient')});
        userDisplay.html(message.sender + ' says: ');
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