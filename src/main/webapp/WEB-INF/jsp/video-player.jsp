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
	<link href=".${location}/favicon.ico" rel="icon" />
	<title>LiveSexHouse</title>
	<meta name="description" content="">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<link href="https://fonts.googleapis.com/css?family=Roboto:300,400,700" rel="stylesheet">
	<link rel="stylesheet" href=".${location}/assets/css/lib/jcf.css">
	<link rel="stylesheet" href=".${location}/assets/css/style.css">
	<script type="text/javascript" src=".${location}/assets/scripts/libs/modernizr.2.8.3.min.js"></script>
</head>
<body>
	
            <%@include file="sign_1.jsp" %>




        <div class="container full-screen-height">
            <%@include file="menu_1.jsp" %>
            
            
		<div id="page-wrap">
			<div class="content">
				<div class="wrapper">
					<div class="sidebar vote-block">
						<div class="inner">
							<h3>Vote rate</h3>
							<p>Top 4</p>
							<ul class="vote-list">
								<li>
									<span class="curent-state">87</span>
									<a href="javascript:;">
										<div class="img-wrapper">
											<div class="overlay">Vote</div>
											<img src=".${location}/assets/img/content/profile-s.png" alt="" />
										</div>
									</a>
									<span class="name">Christine</span>
								</li>
								<li>
									<span class="curent-state">87</span>
									<a href="javascript:;">
										<div class="img-wrapper">
											<div class="overlay">Vote</div>
											<img src=".${location}/assets/img/content/profile-s.png" alt="" />
										</div>
									</a>
									<span class="name">Christine</span>
								</li>
								<li>
									<span class="curent-state">87</span>
									<a href="javascript:;">
										<div class="img-wrapper">
											<div class="overlay">Vote</div>
											<img src=".${location}/assets/img/content/profile-s.png" alt="" />
										</div>
									</a>
									<span class="name">Christine</span>
								</li>
								<li>
									<span class="curent-state">87</span>
									<a href="javascript:;">
										<div class="img-wrapper">
											<div class="overlay">Vote</div>
											<img src=".${location}/assets/img/content/profile-s.png" alt="" />
										</div>
									</a>
									<span class="name">Christine</span>
								</li>
							</ul>
						</div>
						
						<a href="javascript:;" class="sidebar-btn">Participate</a>
						<a href="javascript:;" class="sidebar-btn">Your wish</a>
					</div>
					<div class="main-block">
						<div class="main-top">
							<div class="videoWrapper">
<!--								<div class="overlay">
									<h2>Live stream</h2>
								</div>-->
								 <video id="my_video_1" class="video-js vjs-default-skin" width="640px" height="267px"
      controls preload="none" poster='http://video-js.zencoder.com/oceans-clip.jpg'
      data-setup='{ "aspectRatio":"640:267","autoplay": true  }'>
    <source src="../ext/video/${video.id}.mp4" type='video/mp4' />
<!--    <source src="https://vjs.zencdn.net/v/oceans.mp4" type='video/mp4' />-->
  </video>

							</div>
							<aside class="video-aside">
								<a href="javascript:;" class="one-half widget">
									<h3>Video <br/> archive</h3>
								</a>
								<a href="javascript:;" class="one-half widget img-bg"  style="background-image: url(.${location}/assets/img/content/img-wanted.png);">
									<h3>Models <br/> wanted</h3>
									<img src="" alt="" />
								</a>
								<a href="javascript:;" class="full-width widget" style="background-image: url(.${location}/assets/img/content/image1.png);">
									<img src="" alt="" />
								</a>
							</aside>
						</div>
							
						<div class="main-bottom">
							<div class="hero">
								<h2>Online now - Web cam</h2>
								<a href="webcam.html">View all</a>
								<a href="javascript:;" class="token-img">
									<img src="" alt="" />
								</a>
							</div>
							<div class="owl-carousel">
							    <div class="item">
							    	<img src=".${location}/assets/img/content/slider-1.png" alt="" />
							    </div>
							    <div class="item"><img src=".${location}/assets/img/content/slider-1.png" alt="" /></div>
							    <div class="item"><img src=".${location}/assets/img/content/slider-1.png" alt="" /></div>
							    <div class="item"><img src=".${location}/assets/img/content/slider-1.png" alt="" /></div>
							    <div class="item"><img src=".${location}/assets/img/content/slider-1.png" alt="" /></div>
							    <div class="item"><img src=".${location}/assets/img/content/slider-1.png" alt="" /></div>
							    <div class="item"><img src=".${location}/assets/img/content/slider-1.png" alt="" /></div>
							    <div class="item"><img src=".${location}/assets/img/content/slider-1.png" alt="" /></div>
							    <div class="item"><img src=".${location}/assets/img/content/slider-1.png" alt="" /></div>
							    <div class="item"><img src=".${location}/assets/img/content/slider-1.png" alt="" /></div>
							    <div class="item"><img src=".${location}/assets/img/content/slider-1.png" alt="" /></div>
							    <div class="item"><img src=".${location}/assets/img/content/slider-1.png" alt="" /></div>
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
	<script type="text/javascript">window.jQuery || document.write("<script src='.${location}/assets/scripts/main/jquery-1.8.3.min.js'>\x3C/script>")</script>
	<script type="text/javascript" src=".${location}/assets/scripts/libs/owl.carousel.min.js"></script>
	<script type="text/javascript" src=".${location}/assets/scripts/libs/jcf.js"></script>
	<script type="text/javascript" src=".${location}/assets/scripts/libs/jcf.checkbox.js"></script>

	<link href="//vjs.zencdn.net/5.19/video-js.min.css" rel="stylesheet">
	<script src="//vjs.zencdn.net/5.19/video.min.js"></script>
	
	<script>
		$(function(){
  var $refreshButton = $('#refresh');
  var $results = $('#css_result');
  
  function refresh(){
    var css = $('style.cp-pen-styles').text();
    $results.html(css);
  }

  refresh();
  $refreshButton.click(refresh);
  
  // Select all the contents when clicked
  $results.click(function(){
    $(this).select();
  });
});

		
	</script>

	<script type="text/javascript" src=".${location}/assets/scripts/main/default.js"></script>

 <!--[if lt IE 7]>
    <p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
<![endif]-->

</body>
</html>
