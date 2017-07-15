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
	<link href="${location}/favicon.ico" rel="icon" />
	<title>Contact</title>
	<meta name="description" content="">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<link rel="stylesheet" href="${location}/assets/css/style.css">
	<script type="text/javascript" src="${location}/assets/scripts/libs/modernizr.2.8.3.min.js"></script>
</head>
<body>
	<div class="container full-screen-height">
		<header class="header">
			<div class="wrapper">
				<a href="${path}./index" id="logo">
					<img src="${location}/assets/img/content/LSH-logo.png" alt="Live Sex House logo" />
				</a>
				<a href="javascript:;" id="menu-btn">
					<span></span>
					<span></span>
					<span></span>
					<span></span>
				</a>
				<ul id="main-nav">
					<li><a href="javascript:;">Live streams</a></li>
					<li><a href="javascript:;">Video archive</a></li>
					<li><a href="javascript:;">Tokens</a></li>
					<li>
						<a href="javascript:;">Web cam</a>
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
					<li><a href="javascript:;"  class="active">Contact</a></li>
					<li><a href="javascript:;">Login/Join</a></li>
				</ul>
			</div>
		</header>
		<div id="page-wrap">
			<div class="content">
				<div class="wrapper">
					<!-- Form block -->
                                        
            <script src="https://www.google.com/recaptcha/api.js" async defer></script>                             
      <script>
       function onSubmit(token) {
         document.getElementById("formContact").submit();
       }
     </script>
                                        
     
     
     <form id="formContact" method="POST" action="${pageContext.request.contextPath}/contactpost" name="forma" accept-charset="UTF-8">
     <input type="hidden"
name="${_csrf.parameterName}"
value="${_csrf.token}"/>
                                        
					<div class="center-content">
						<div class="form-block">
							<h2 class="u-title">Contact us</h2>
							<div class="left">
								<div class="field-wrapper">
									<span class="field-label">Language</span>
                                                                        <select name="lng">
										<option value="english">English</option>
										<option value="lang2">Language 2</option>
										<option value="lang3">Language 3</option>
										<option value="lang4">Language 4</option>
										<option value="lang5">Language 4</option>
									</select>
                                                                        
                                                                        

                                                                      
                                                                        
								</div>
								<div class="field-wrapper">
									<span class="field-label">User group</span>
                                                                        <select name="user">
										<option value="Guest">Guest</option>
										<option value="Member">Member</option>
										<option value="Potential model">Potential model</option>
										<option value="Potential performer">Potential performer</option>
										<option value="Payment">Payment</option>
										<option value="Other">Other</option>
									</select>
								</div>
								<div class="field-wrapper">
									<span class="field-label">Email address*</span>
									<input id="mail" type="email" name="mail">
                                                                       
								</div>
								<div class="field-wrapper">
									<span class="field-label">Name*</span>
									<input id="name" type="text" name="name">
								</div>
								<p class="legend">*required fields</p>
							</div>
							<div class="right">
								<div class="field-wrapper">
									<span class="field-label">Subject</span>
                                                                        <input id="subject" type="text" name="subject">
								</div>
								
								<div class="field-wrapper">
									<span class="field-label">Message*</span>
									<textarea name="message-text" id="textarea" ></textarea>
									<p id="textarea_feedback"></p>
								</div>
							</div>
							<input type="submit" value="Send" class="btn-submit">
<!--                                                        <button type="submit" class="btn-submit g-recaptcha btn-submit" data-sitekey="6Lc9oCMUAAAAAJoWfarXmBDpH673bGYkGX6XrTWI" data-callback='onSubmit' >Send</button>-->
						</div>
					</div>
     
     
     
     </form>
     
     
     
				</div>
			</div>

			<footer class="footer">
				<div class="wrapper">
					<p>The site contains sexually explictit material. Enter only if you are at least 18 years old and agree to our cookie rools.</p>
					<p>Live Sex House - All Rights Reserved 2017.</p>
				</div>
			</footer>
		</div>
			
	</div>

	<!-- javascript -->
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
	<script type="text/javascript">window.jQuery || document.write("<script src='${location}/assets/scripts/main/jquery-1.8.3.min.js'>\x3C/script>")</script>
	<script type="text/javascript" src="${location}/assets/scripts/libs/jquery.selectric.js"></script>
	<script type="text/javascript" src="${location}/assets/scripts/main/default.js"></script>

 <!--[if lt IE 7]>
    <p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
<![endif]-->

</body>
</html>