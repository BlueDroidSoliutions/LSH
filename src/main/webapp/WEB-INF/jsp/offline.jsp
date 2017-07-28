<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js ie6"> <![endif]-->
<!--[if IE 7]>         <html class="no-js ie7"> <![endif]-->
<!--[if IE 8]>         <html class="no-js ie8"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
        <link href="${location}favicon.ico" rel="icon" />
	<title>Offline</title>
	<meta name="description" content="">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<link href="https://fonts.googleapis.com/css?family=Roboto:300,400,700" rel="stylesheet">
	<link rel="stylesheet" href="${location}/assets/css/style.css">
	<script type="text/javascript" src="${location}/assets/scripts/libs/modernizr.2.8.3.min.js"></script>
</head>
<body class="page-offline">
	
    <%@include file="sign.jsp" %>
<div class="container full-screen-height">
<%@include file="menu.jsp" %>


		<main>
			<div class="offline-container clearfix">
					<div class="employee-cover" href="javascript:;"><img src="${location}/assets/img/content/offline_big.jpg" alt=""></div>
				<div class="stat-wrapper">
					<div class="stats-bottom">
						<p>Last broadcast:</p>
						<p>Highest daily honorar</p>
						<p class="schedule">Schedule:</p>
						<ul>
							<li class="clearfix"><span class="day">Monday</span><span class="time">8AM</span></li>
							<li class="clearfix"><span class="day">Monday</span><span class="time">8AM</span></li>
							<li class="clearfix"><span class="day">Monday</span><span class="time">8AM</span></li>
							<li class="clearfix"><span class="day">Monday</span><span class="time">8AM</span></li>
						</ul>
						<p class="views">Views: <span>8522</span></p>
					</div>
				</div>
				<div class="employee-wrapper">
					<h2>Name Nickname</h2>
					<div class="employee-box">
						<div class="employee-top">
							<ul class="employee-info">
								<li class="tips-btn">
									<a href="javascript:;">
										TIP me
									</a>
									<span>
										<svg version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
												 width="25.773px" height="25.49px" viewBox="0 0 25.773 25.49" enable-background="new 0 0 25.773 25.49" xml:space="preserve">
											<path fill="#FFFFFF" d="M18.52,7.865c0,1.13-2.541,2.047-5.677,2.047c-3.135,0-5.677-0.917-5.677-2.047s2.542-2.047,5.677-2.047
												C15.979,5.818,18.52,6.735,18.52,7.865"/>
											<path fill="#FFFFFF" d="M7.166,10.718v2.605c0,0,5.528,3.213,11.354,0v-2.667C18.52,10.656,13.811,13.906,7.166,10.718"/>
											<path fill="#FFFFFF" d="M7.166,15.557v2.604c0,0,5.528,3.213,11.354,0v-2.667C18.52,15.495,13.811,18.745,7.166,15.557"/>
											<path fill="none" stroke="#FFFFFF" stroke-width="1.533" stroke-miterlimit="10" d="M12.864,1.07
												c6.449,0,11.676,5.227,11.676,11.675"/>
											<path fill="none" stroke="#FFFFFF" stroke-width="1.533" stroke-miterlimit="10" d="M1.189,12.745
												c0-6.448,5.227-11.675,11.675-11.675"/>
											<path fill="none" stroke="#FFFFFF" stroke-width="1.533" stroke-miterlimit="10" d="M12.864,24.42
												c-6.448,0-11.675-5.228-11.675-11.676"/>
											<path fill="none" stroke="#FFFFFF" stroke-width="1.533" stroke-miterlimit="10" d="M24.54,12.745
												c0,6.448-5.228,11.676-11.676,11.676"/>
										</svg>
									</span>
								</li>
								<li>
									<a href="javascript:;">
										<span>
											<svg version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
													 width="21.375px" height="19.875px" viewBox="0 0 21.375 19.875" enable-background="new 0 0 21.375 19.875" xml:space="preserve">
												<path fill="#F3F3F3" d="M10.75,19.3L9.3,17.98c-5.149-4.67-8.55-7.75-8.55-11.53c0-3.08,2.42-5.5,5.5-5.5c1.74,0,3.41,0.81,4.5,2.09
												c1.09-1.28,2.76-2.09,4.5-2.09c3.08,0,5.5,2.42,5.5,5.5c0,3.78-3.4,6.86-8.55,11.54L10.75,19.3z"/>
											</svg>
										</span>
										4.7
									</a>
								</li>
								<li>
									<a href="javascript:;">
										<span>
											<svg version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
												 width="23.583px" height="22.417px" viewBox="0 0 23.583 22.417" enable-background="new 0 0 23.583 22.417" xml:space="preserve">
												<polygon fill="#fff" points="11.8,17.815 18.732,22 16.892,14.114 23.018,8.809 14.952,8.125 11.8,0.688 8.648,8.125 
													0.584,8.809 6.708,14.114 4.868,22 "/>
											</svg>
										</span>
										526
									</a>
								</li>
							</ul>
							<div class="txt-holder">
								<p>
									I am lorem ipsud dolor amet sit um busi avec. Doram pedi lero ub aba apotrice. I am lorem ipsud dolor  amet sit um busi avec. Doram pedi lero ub aba apotrice.I am lorem ipsud dolor amet sit um busi avec. Doram pedi lero ub aba apotrice. I am lorem ipsud dolor  amet sit um busi avec. Doram pedi lero ub aba apotrice.
								</p>
							</div>
						</div>
						<div class="major-info clearfix">
							<ul>
								<li class="clearfix"><span class="title">Preferences</span><span class="txt">Bisexual</span></li>
								<li class="clearfix"><span class="title">Age</span><span class="txt">23</span></li>
								<li class="clearfix"><span class="title">Gender</span><span class="txt">Female</span></li>
								<li class="clearfix"><span class="title">Gender</span><span class="txt">Female</span></li>
							</ul>
							<ul>
								<li class="clearfix"><span class="title">Gender</span><span class="txt">Female</span></li>
								<li class="clearfix"><span class="title">Gender</span><span class="txt">Female</span></li>
								<li class="clearfix"><span class="title">Gender</span><span class="txt">Female</span></li>
								<li class="clearfix"><span class="title">Gender</span><span class="txt">Female</span></li>
							</ul>
						</div>
						<div class="top-fans">
							<p>
								<span>
									<svg version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
										 width="23.583px" height="22.417px" viewBox="0 0 23.583 22.417" enable-background="new 0 0 23.583 22.417" xml:space="preserve">
										<polygon fill="#fff" points="11.8,17.815 18.732,22 16.892,14.114 23.018,8.809 14.952,8.125 11.8,0.688 8.648,8.125 
											0.584,8.809 6.708,14.114 4.868,22 "/>
									</svg>
								</span>
								Top fans:
							</p>
							<ul>
								<li><img src="${location}/assets/img/content/user_img.jpg" alt=""><span>User 343</span></li>
								<li><img src="${location}/assets/img/content/user_img.jpg" alt=""><span>User 343</span></li>
								<li><img src="${location}/assets/img/content/user_img.jpg" alt=""><span>User 343</span></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="gallery-wrapper">
					<div class="gallery-holder clearfix">
						<a class="gallery-popup">
							<span>Watch me <br>in my gallery</span>
						</a>
						<img src="${location}/assets/img/content/offline_gallery.jpg" alt="">
						<img src="${location}/assets/img/content/offline_gallery.jpg" alt="">
						<img src="${location}/assets/img/content/offline_gallery.jpg" alt="">
						<img src="${location}/assets/img/content/offline_gallery.jpg" alt="">
					</div>
					<div class="gallery-bottom">
						<img src="${location}/assets/img/content/offline_big.jpg" alt="">
					</div>
				</div>
			</div>
		</main>

		<footer class="footer">
			<div class="wrapper">
				<p>The site contains sexually explictit material. Enter only if you are at least 18 years old and agree to our cookie rools.</p>
				<p>Live Sex House - All Rights Reserved 2017.</p>
			</div>
		</footer>
		<!-- </div> -->
			
	</div>

	<!-- javascript -->
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
	<script type="text/javascript">window.jQuery || document.write("<script src='${location}/assets/scripts/main/jquery-1.8.3.min.js'>\x3C/script>")</script>
	<script type="text/javascript" src="${location}/assets/scripts/libs/owl.carousel.min.js"></script>
	<script type="text/javascript" src="${location}/assets/scripts/main/default.js"></script>

 <!--[if lt IE 7]>
    <p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
<![endif]-->

</body>
</html>
