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
	<title>Participate</title>
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
					<div class="center-content">
						<div class="form-block participate-form">
							<h2 class="u-title">Become a participant</h2>
							<p>
								Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint <a href="javascript:;">occaecat cupidatat</a> non proident, sunt in culpa qui officia deserunt mollit anim id est laborum
							</p>
							<div class="one-third">
								<div class="field-wrapper">
									<span class="field-label">Your full name</span>
									<input id="fullName" type="text">
								</div>
								<div class="field-wrapper">
									<span class="field-label">Email address</span>
									<input id="emailAddress" type="email">
								</div>
								<div class="field-wrapper">
									<span class="field-label">Upload your photo</span>
									<input id="name" type="file">
								</div>
								<p class="legend">*required fields</p>
							</div>
							<div class="one-third">
								<div class="field-wrapper">
									<span class="field-label">Date of birth</span>
									<input id="subject" type="date">
								</div>
								<div class="field-wrapper">
									<span class="field-label">State of residence</span>
									<input id="state" type="text">
								</div>
								<div class="field-wrapper">
									<span class="field-label">City of residence</span>
									<input id="city" type="text">
								</div>
							</div>
							<div class="one-third">
								<div class="field-wrapper">
									<span class="field-label">Message*</span>
									<textarea name="message-text" id="textarea" ></textarea>
									<p id="textarea_feedback"></p>
									<label><input type="checkbox" name="checkbox" value="value">I am not a robot</label>
								</div>
							</div>
							<div class="bottom-form">
								<label><input type="checkbox" name="checkboxAccept" value="value">I accept </label><a href="javascript:;">terms and conditions</a>
								<input type="submit" value="Submit" class="btn-submit">
							</div>	
						</div>
					</div>
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
