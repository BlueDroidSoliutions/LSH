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
                <div class="sticky-wrap">
                    <div class="wrapper clearfix">
                        <div class="filters-wrap">
                            <span class="filters-toggle">Filter</span>
                            <div class="filters">
                                <ul>
                   <li class="filter">
                       <c:forEach items="${findInteres}" var="i">
                           <a href="./webcam?2=${i.id}" style="color:white">${i.interesName}</a>
                       </c:forEach>
                       </li>
                           <li class="filter">

                       <c:forEach items="${findHair}" var="h">
                           <a href="./webcam?3=${h.id}${interests}" style="color:white">${h.hairName}</a>
                       </c:forEach>
               </li>
                   <li class="filter">

                       <c:forEach items="${findLanguageSpoken}" var="l">
                           <a href="./webcam?4=${l.id}${interests}" style="color:white">${l.languageSpokenname}</a>
                       </c:forEach>
               </li>
                   <li class="filter">

                       <c:forEach items="${findBody}" var="b">
                           <a href="./webcam?5=${b.id}${interests}" style="color:white">${b.bodyName}</a>
                       </c:forEach>
               </li>
                   <li class="filter">

                       <c:forEach items="${findKinky}" var="k">
                           <a href="./webcam?6=${k.id}${interests}" style="color:white">${k.kinkyName}</a>
                       </c:forEach>
               </li>
                                </ul>
                            </div>
                        </div>
                        <div class="online-models">
                            <span>Models online:</span>
                            <strong>${onlineNow}</strong>
                        </div>

                        <c:choose>
                            <c:when test="${not empty userName}">
                                <div class="search-form">
                                        <form name='search' action="${pageContext.request.contextPath}/searchGWC" method="POST">
                                        <input type="hidden"   name="${_csrf.parameterName}"   value="${_csrf.token}"/>
                                        <input type="text" placeholder="Search" name="string" />
                                        <!--                                <button type="submit">Search</button>-->
                                        <input type="submit" value="submit" class="btn-submit" />
                                    </form>
                                </div>
                                        
                                       
                                 
                            </c:when>
                            <c:otherwise>

                            </c:otherwise>
                        </c:choose>



                    </div>
                </div>
                <div class="webcam-videos">
                    <ul class="clearfix">



                        <style>

                            .onlineG{
                                position: absolute;
                                background-color: greenyellow;
                                color: red;
                                padding: 5px;
                            } 
                        </style>


                        <li class="webcam-video" id="li001">
                            <a id="lnk" href="javascript:;">
                                <div class="thumbnail" id="tt">
                                    <img id="im" src="" alt="" />
                                </div>
                                <div class="webcam-info" id="st">
                                    <h4></h4>
                                    <span class="status" id="">Offline</span>
                                </div>
                            </a>
                        </li>



                        <c:forEach varStatus="gg" items="${girl}" var="g" >
                           
                            
                            <c:choose>
                                <c:when test="${gg.index==4 || gg.index == 13 || gg.index == 22}">
                                     <li class="webcam-video large-video" id="li${g.id}">
                                <a id="lnk${g.id}" href="./offline/${g.id}">
                                    <div class="thumbnail" id="tt${g.id}">
                                        <img id="im${g.id}" src="ext/GirlsImages/${g.name}.jpg" alt="" />
                                    </div>
                                    <div class="webcam-info" id="st${g.id}">
                                        <h4>${g.userName}</h4>
                                        <span class="status" id="sp${g.id}">Offline</span>
                                    </div>
                                </a>
                            </li>
                                </c:when>
                                <c:otherwise>
                                     <li class="webcam-video" id="li${g.id}">
                                <a id="lnk${g.id}" href="./offline/${g.id}">
                                    <div class="thumbnail" id="tt${g.id}">
                                        <img id="im${g.id}" src="ext/GirlsImages/${g.name}.jpg" alt="" />
                                    </div>
                                    <div class="webcam-info" id="st${g.id}">
                                        <h4>${g.userName}</h4>
                                        <span class="status" id="sp${g.id}">Offline</span>
                                    </div>
                                </a>
                            </li>
                                </c:otherwise>
                            </c:choose>

                           

                        </c:forEach>






                    </ul>
                </div>
                <div class="pagination">

                    <ul>${pagination}</ul>
                </div>
            </div>
        </div>

        <%@include file="footer.jsp" %>
    </div>

</div>




<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script type="text/javascript">window.jQuery || document.write("<script src='${location}/assets/scripts/main/jquery-1.8.3.min.js'>\x3C/script>")</script>

<script type="text/javascript" src="${location}/assets/scripts/main/default.js"></script>
<script type="text/javascript" src="${location}/assets/scripts/libs/jquery.flexslider-min.js"></script>
<script type="text/javascript" src="${location}/assets/scripts/libs/jQuery.fakeScroll.js"></script>
	<script type="text/javascript" src="${location}/assets/scripts/libs/jcf.js"></script>
	<script type="text/javascript" src="${location}/assets/scripts/libs/jcf.checkbox.js"></script>
	<script type="text/javascript" src="${location}/assets/scripts/libs/jcf.file.js"></script>






<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.0.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.js"></script>
<script src="./resources/st2/sockjs.js"></script>






<script>
    var stompClient = null;
    var socket = null;

    var allNewOnline = [];
    var allNewPrivate = [];

    var startedOnline = false;
    var startedPrivate = false;

    var startO = true;
    var startP = false;

    var inProcesO = false;
    var inProcesP = false;

    $("#li001").hide();


    function connect() {
        socket = new SockJS('/www.livesexhouse.com/chat');
        stompClient = Stomp.over(socket);
        stompClient.connect('', '', function (frame) {

            // pretplacujemo se na kanal sa aktivnim userima i zovemo ovo kada ima apdejta
            stompClient.subscribe('/topic/activeG', function (activeMembersOnline) {
                showActiveOnline(activeMembersOnline);
            });

            // pretplacujemo se na kanal sa aktivnim userima i zovemo ovo kada ima apdejta
            stompClient.subscribe('/topic/activeGP', function (activeMembersPrivate) {
                showActivePrivate(activeMembersPrivate);
            });
        });
    }


    function showActiveOnline(activeMembersOnline) {
        console.log('*********************');
        if ((startO) && (!inProcesO)) {
            renderActiveOnline(activeMembersOnline.body);
            console.log('renderActiveOnline Start');
        }
    }

    function showActivePrivate(activeMembersPrivate) {
        if ((startP) && (!inProcesP)) {
            renderActivePrivate(activeMembersPrivate.body);
            console.log('renderActivePrivate Start');
        }
    }

    function reorder(online, private) {
        console.log('reorder Start');
        for (i = 0; i < online.length; i++) {
            if (i === 0) {
                console.log('i==0');
                $("#li" + online[i]).insertAfter("#li001");
                o = online[i];
            } else {
                $("#li" + online[i]).insertAfter("#li" + o);
                o = online[i];
            }
        }

        for (i = 0; i < private.length; i++) {
            if (i === 0) {
                $("#li" + private[i]).insertAfter("#li" + o);
                p = private[i];
            } else {
                $("#li" + private[i]).insertAfter("#li" + p);
                p = private[i];
            }
        }

        if (startO) {
            startO = false;
            startP = true;
            inProcesO = false;
            inProcesP = false;
        } else {
            startO = true;
            startP = false;
            inProcesO = false;
            inProcesP = false;
        }


    }







    function removeItems(items) {
        for (i = 0; i < items.length; i++) {
            $("#og" + items[i]).remove();
            $("#sp" + items[i]).remove();
            $("#st" + items[i]).append('<span id="sp' + items[i] + '" style="color:#ccc;">Offline</span>');
            $('#lnk' + items[i]).attr('href', 'offline/' + items[i]);
        }
    }

    function insertOnlineStatus(actMem) {
        console.log('insertOnlineStatus Start');
        for (i = 0; i < actMem.length; i++) {
            $("#sp" + actMem[i]).remove();
            $("#tt" + actMem[i]).append('<p id="og' + actMem[i] + '" class="onlineG">ONLINE</p>');
            $("#st" + actMem[i]).append('<span id="sp' + actMem[i] + '" style="color:green;">available</span>');
            $('#lnk' + actMem[i]).attr('href', 'webcam/' + actMem[i]);

        }
    }

    function insertPrivateStatus(actMem) {
        for (i = 0; i < actMem.length; i++) {
            $("#sp" + actMem[i]).remove();
            $("#tt" + actMem[i]).append('<p id="og' + actMem[i] + '" class="onlineG">online</p>');
            $("#st" + actMem[i]).append('<span id="sp' + actMem[i] + '" style="color:red;">in private chat</span>');
            $('#lnk' + actMem[i]).attr('href', 'offline/' + actMem[i]);

        }
    }





    function renderActiveOnline(activeMembersOnline) {
        inProcesO = true;
        console.log('inProcesO = true;');
        var membersO = $.parseJSON(activeMembersOnline);
        if (!startedOnline) {
            startedOnline = true;
            console.log('startedOnline = true;');
            $.each(membersO, function (index, value) {
                allNewOnline.push(value);
            });
            insertOnlineStatus(allNewOnline);

            reorder(allNewOnline, allNewPrivate);
        } else {
            removeItems(allNewOnline);
            allNewOnline = [];
            $.each(membersO, function (index, value) {
                allNewOnline.push(value);
            });
            insertOnlineStatus(allNewOnline);

            reorder(allNewOnline, allNewPrivate);
        }
    }


    function renderActivePrivate(activeMembersPrivate) {
        inProcesP = true;
        var membersP = $.parseJSON(activeMembersPrivate);
        if (!startedPrivate) {
            startedPrivate = true;
            $.each(membersP, function (index, value) {
                allNewPrivate.push(value);
            });
            insertPrivateStatus(allNewPrivate);
            reorder(allNewOnline, allNewPrivate);
        } else {
            removeItems(allNewPrivate);
            allNewPrivate = [];
            $.each(membersP, function (index, value) {
                allNewPrivate.push(value);
            });
            insertPrivateStatus(allNewPrivate);
            reorder(allNewOnline, allNewPrivate);
        }
    }





    $(document).ready(function () {
        connect();
    });



    if (Array.prototype.eqOnlineuals)
        console.warn("Overriding existing Array.prototype.eqOnlineuals. Possible causes: New API defines the method, there's a framework conflict or you've got double inclusions in your code.");
    // attach the .eqOnlineuals method to Array's prototype to call it on any array
    Array.prototype.eqOnlineuals = function (array) {
        // if the other array is a falsy value, return
        if (!array)
            return false;

        // compare lengths - can save a lot of time 
        if (this.length !== array.length)
            return false;

        for (var i = 0, l = this.length; i < l; i++) {
            // Check if we have nested arrays
            if (this[i] instanceof Array && array[i] instanceof Array) {
                // recurse into the nested arrays
                if (!this[i].eqOnlineuals(array[i]))
                    return false;
            } else if (this[i] !== array[i]) {
                // Warning - two different object instances will never be eqOnlineual: {x:20} != {x:20}
                return false;
            }
        }
        return true;
    };
    // Hide method from for-in loops
    Object.defineProperty(Array.prototype, "eqOnlineuals", {enumerable: false});






</script>

</body>
</html>
