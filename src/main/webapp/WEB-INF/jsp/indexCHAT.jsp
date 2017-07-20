<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<link rel="stylesheet" href="${location}/assets/css/style.css">
	<script type="text/javascript" src="${location}/assets/scripts/libs/modernizr.2.8.3.min.js"></script>
</head>
<body>
    
    
    
    <style>
        body {
    background-color: #f5f5f5;
}

#main-content {
    max-width: 940px;
    padding: 2em 3em;
    margin: 0 auto 20px;
    background-color: #fff;
    border: 1px solid #e5e5e5;
    -webkit-border-radius: 5px;
    -moz-border-radius: 5px;
    border-radius: 5px;
}
    </style>
    
    
    <script>
        $( document ).ready(function() {

   connect();
    
    });
    </script>
    
    
    <script>
        
    function connect() {
  socket = new SockJS('/chat');
  stompClient = Stomp.over(socket);
  stompClient.connect('', '', function(frame) {
    whoami = frame.headers['user-name'];
    console.log('Connected: ' + frame);
    stompClient.subscribe('/user/queue/messages', function(message) {
      showMessage(JSON.parse(message.body));
    });
    stompClient.subscribe('/topic/active', function(activeMembers) {
      showActive(activeMembers);
    });
  });
}
    
    
    
    
    
    
    
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


function newMessageIcon() {
  var newMessage = $('<span>', {class: 'newmessage'});
  newMessage.html('&#x2709;');
  return newMessage;
}




function getChatWindow(userName) {
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





function sendMessageTo(user) {
  var chatInput = '#input-chat-' + user;
  var message = $(chatInput).val();
  if (!message.length) {
    return;
  }
  stompClient.send("/app/chat", {}, JSON.stringify({
    'recipient': user,
    'message' : message
  }));
  $(chatInput).val('');
  $(chatInput).focus();
}




function showActive(activeMembers) {
  renderActive(activeMembers.body);
  stompClient.send('/www.livesexhouse.com/activeUsers', {}, '');
}

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


    
    
    </script>
    

    
    
    
    <div id="main-content" class="container">
    <div class="row">
        <div class="col-md-6">
            <form class="form-inline">
                <div class="form-group">
                    <label for="connect">WebSocket connection:</label>
                    <button id="connect" class="btn btn-default" type="submit">Connect</button>
                    <button id="disconnect" class="btn btn-default" type="submit" disabled="disabled">Disconnect
                    </button>
                </div>
            </form>
        </div>
        <div class="col-md-6">
            <form class="form-inline">
                <div class="form-group">
                    <label for="name">What is your name?</label>
                    <input type="text" id="name" class="form-control" placeholder="Your name here...">
                </div>
                <button id="send" class="btn btn-default" type="submit">Send</button>
            </form>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <table id="conversation" class="table table-striped">
                <thead>
                <tr>
                    <th>Greetings</th>
                </tr>
                </thead>
                <tbody id="greetings">
                </tbody>
            </table>
        </div>
    </div>
    </form>
</div>
    
    
    
    
    
</body>
</html>
