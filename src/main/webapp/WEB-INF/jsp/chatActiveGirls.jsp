<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>


    <head>
        <title>active</title>
        <!--<script src="./resources/st2/sockjs-0.3.4.js"></script>-->
        <!--<script src="./resources/st2/stomp.js"></script>-->
        <!--<script src="./resources/st2/jquery-2.1.0.min.js"></script>-->


        <script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.js"></script>
        <script src="./resources/st2/sockjs.js"></script>
        <script src="./resources/st2/jquery.js"></script>



        <link href="./resources/st2/chat.css" rel="stylesheet" type="text/css">
    </head>
    <body>

        <p>User Name: ${userName}</p>


        <div>
            <div id="userList">
            </div>
        </div>

           
            <button id="insertP" onclick="insertP()"> insertP </button>
            <button id="deleteP" onclick="deleteP()"> deleteP </button>
       

        <script type="text/javascript">
            var stompClient = null;
            var socket = null;
            var whoami = null;
            var allNew = [];
            var allOld = [];
            var check = false;
            var eq = false;
            var started = false;

            function connect() {
                document.body.style.backgroundColor = 'white';
                socket = new SockJS('/www.livesexhouse.com/chat');
                stompClient = Stomp.over(socket);
                stompClient.connect('', '', function (frame) {

                  

                    // pretplacujemo se na kanal sa aktivnim userima i zovemo ovo kada ima apdejta
                    stompClient.subscribe('/topic/activeG', function (activeMembers) {
                        showActive(activeMembers);
                    });

                });

            }


            function showActive(activeMembers) {
                renderActive(activeMembers.body);

            }
            //      
            function renderActive(activeMembers) {


                var members = $.parseJSON(activeMembers);
                var userDiv = $('<div>', {id: 'users'});

                allNew = [];
                $.each(members, function (index, value) {
                    allNew.push(value);
                });


                if (check === false) {
                    $.each(members, function (index, value) {
                        allOld.push(value);
                    });
                    check = true;
                }

                eq = allNew.equals(allOld);
                
                if (!started) {
                    $.each(members, function (index, value) {
                        var userLine = $('<div>');
                        userLine.addClass('user-entry');
                        var userNameDisplay = $('<span>');
                        userNameDisplay.html("<a target='_blank' href='./activeGirl/" + value + "'>" + value + "</a>");
                        userLine.append(userNameDisplay);
                        userDiv.append(userLine);
                    });
                    $('#userList').html(userDiv);
                    started = true;
                }

                if (!eq) {
                    $.each(members, function (index, value) {
                        var userLine = $('<div>');
                        userLine.addClass('user-entry');
                        var userNameDisplay = $('<span>');
                        userNameDisplay.html("<a  target='_blank' href='./activeGirl/" + value + "'>" + value + "</a>");
                        userLine.append(userNameDisplay);
                        userDiv.append(userLine);
                    });
                    $('#userList').html(userDiv);
                    allOld = [];
                    check = false;
                }

            }
          

            $(document).ready(function () {
                connect();
            });




            if (Array.prototype.equals)
                console.warn("Overriding existing Array.prototype.equals. Possible causes: New API defines the method, there's a framework conflict or you've got double inclusions in your code.");
            // attach the .equals method to Array's prototype to call it on any array
            Array.prototype.equals = function (array) {
                // if the other array is a falsy value, return
                if (!array)
                    return false;

                // compare lengths - can save a lot of time 
                if (this.length != array.length)
                    return false;

                for (var i = 0, l = this.length; i < l; i++) {
                    // Check if we have nested arrays
                    if (this[i] instanceof Array && array[i] instanceof Array) {
                        // recurse into the nested arrays
                        if (!this[i].equals(array[i]))
                            return false;
                    } else if (this[i] != array[i]) {
                        // Warning - two different object instances will never be equal: {x:20} != {x:20}
                        return false;
                    }
                }
                return true;
            }
            // Hide method from for-in loops
            Object.defineProperty(Array.prototype, "equals", {enumerable: false});


        </script>
    </body>
</html>