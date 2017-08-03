<%-- 
    Document   : sign
    Created on : Jul 24, 2017, 11:56:10 AM
    Author     : roller
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

   <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
        <link href="${location}/favicon.ico" rel="icon" />
        <title>LiveSexHouse</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,700" rel="stylesheet">
        <link rel="stylesheet" href="${location}/assets/css/style.css">
        <link rel="stylesheet" href="${location}/assets/css/lib/fakeScroll.css">
        <script type="text/javascript" src="${location}/assets/scripts/libs/modernizr.2.8.3.min.js"></script>
        <script src="https://use.fontawesome.com/48b7d32ec9.js"></script>

    </head>
    <body>
        
        
<div class="main-popup">
    <div class="popup-wrapper">
        <div class="inner" id="sign-up">
            <a href="javascript:;" class="close-me"></a>
            <div class="inner-wrapper">

                <h2>Sign up</h2>
                <p>Already have an account? <a href="javascript:;" id="showSignIn">Sign in here</a></p>



                <script>
                    function onSubmit(token) {
                        document.getElementById("signup").submit();
                    }
                </script>
                
                
                <form id="signup" method="post" action="${pageContext.request.contextPath}${path}/signup" name="forma" accept-charset="UTF-8">

                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                    <input id="subject" type="text" name="subject">


                    <div>
                        <input type="text" id="name" name="username" placeholder="username">
                    </div>
                    <div>
                        <input type="password" id="password" name="password" placeholder="password">
                    </div>
                    <div>
                        <input type="email" id="mail" name="email" placeholder="email">
                    </div>
                    <label class="chack required-holder"><input type="checkbox" name="checkboxAccept" value="value">I am over 18. I accept <a href="javascript:;">terms and conditions</a></label>
                    <a href="javascript" class="support">Support contact</a>
                    <input type="submit" value="Send" class="btn">
                    <!--					    <button type="submit" class="btn">Submit</button>-->
                </form>









            </div>
        </div>
        <div class="inner" id="sign-in">
            <a href="javascript:;" class="close-me"></a>
            <div class="inner-wrapper">
                <h2>Sign in</h2>




                <form name='loginForm' action="${path}./login" method='POST'>
                    <div>
                        <input type="text" id="name" name="username" placeholder="username">
                    </div>
                    <div>
                        <input type="password" id="password" name="password" placeholder="password">
                    </div>
                    <button  name="submit" type="submit"  value="submit" class="btn">SIGN IN</button>

                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                </form>


            </div>
        </div>
    </div>
</div>
                
                
       <div class="container full-screen-height">          
                
                
                
                
<header class="header">
			<div class="wrapper">
				<a href="${path}./" id="logo">
					<img src="${location}/assets/img/content/LSH-logo.png" alt="Live Sex House logo" />
				</a>
				<a href="javascript:;" id="menu-btn">
					<span></span>
					<span></span>
					<span></span>
					<span></span>
				</a>
				<ul id="main-nav">
                                    <li><a href="${path}./">Home</a></li>
					<li><a href="${path}./live-stream">Live streams</a></li>
					<li><a href="${path}./video">Video archive</a></li>
					
					<li>
						<a href="${path}./webcam">Web cam</a>
						<a href="javascript:;" class="submenu-btn">
							<svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" version="1.1" viewBox="0 0 129 129" enable-background="new 0 0 129 129">
							  <g>
							    <path d="m121.3,34.6c-1.6-1.6-4.2-1.6-5.8,0l-51,51.1-51.1-51.1c-1.6-1.6-4.2-1.6-5.8,0-1.6,1.6-1.6,4.2 0,5.8l53.9,53.9c0.8,0.8 1.8,1.2 2.9,1.2 1,0 2.1-0.4 2.9-1.2l53.9-53.9c1.7-1.6 1.7-4.2 0.1-5.8z" fill="#FFFFFF"/>
							  </g>
							</svg>
						</a>
						<ul>
							<li><a href="javascript:;">Subitem</a></li>
							<li><a href="javascript:;">Subitem</a></li>
							<li><a href="javascript:;">Subitem</a></li>
							<li><a href="javascript:;">Subitem</a></li>
						</ul>
					</li>
					<li><a href="${path}./vote">Vote</a></li>
					<li><a href="${path}./contact">Contact</a></li>
                                       
                                        
                                        <c:choose>
                                             <c:when test="${not empty userName}">
                                                 <li><a href="${path}./logout">Logout ${userName}</a></li>
                                             </c:when>
                                             <c:otherwise>
                                                 <li><a href="javascript:;" id="login-btn">Login/Join</a></li>
                                             </c:otherwise>
                                        </c:choose>
                                       
					
				</ul>
			</div>
		</header>