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
											<img src="${location}/assets/img/content/profile-s.png" alt="" />
										</div>
									</a>
									<span class="name">Christine</span>
								</li>
								<li>
									<span class="curent-state">87</span>
									<a href="javascript:;">
										<div class="img-wrapper">
											<div class="overlay">Vote</div>
											<img src="${location}/assets/img/content/profile-s.png" alt="" />
										</div>
									</a>
									<span class="name">Christine</span>
								</li>
								<li>
									<span class="curent-state">87</span>
									<a href="javascript:;">
										<div class="img-wrapper">
											<div class="overlay">Vote</div>
											<img src="${location}/assets/img/content/profile-s.png" alt="" />
										</div>
									</a>
									<span class="name">Christine</span>
								</li>
								<li>
									<span class="curent-state">87</span>
									<a href="javascript:;">
										<div class="img-wrapper">
											<div class="overlay">Vote</div>
											<img src="${location}/assets/img/content/profile-s.png" alt="" />
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
								<div class="overlay">
									<h2>Live stream</h2>
								</div>
								<iframe width="420" height="345" src="https://www.youtube.com/embed/LIMYj5mpMM4" frameborder="0" ></iframe>
							</div>
							<aside class="video-aside">
								<a href="javascript:;" class="one-half widget">
									<h3>Video <br/> archive</h3>
								</a>
								<a href="javascript:;" class="one-half widget img-bg"  style="background-image: url(${location}/assets/img/content/img-wanted.png);">
									<h3>Models <br/> wanted</h3>
									<img src="" alt="" />
								</a>
								<a href="javascript:;" class="full-width widget" style="background-image: url(${location}/assets/img/content/image1.png);">
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
							    	<img src="${location}/assets/img/content/slider-1.png" alt="" />
							    </div>
							    <div class="item"><img src="${location}/assets/img/content/slider-1.png" alt="" /></div>
							    <div class="item"><img src="${location}/assets/img/content/slider-1.png" alt="" /></div>
							    <div class="item"><img src="${location}/assets/img/content/slider-1.png" alt="" /></div>
							    <div class="item"><img src="${location}/assets/img/content/slider-1.png" alt="" /></div>
							    <div class="item"><img src="${location}/assets/img/content/slider-1.png" alt="" /></div>
							    <div class="item"><img src="${location}/assets/img/content/slider-1.png" alt="" /></div>
							    <div class="item"><img src="${location}/assets/img/content/slider-1.png" alt="" /></div>
							    <div class="item"><img src="${location}/assets/img/content/slider-1.png" alt="" /></div>
							    <div class="item"><img src="${location}/assets/img/content/slider-1.png" alt="" /></div>
							    <div class="item"><img src="${location}/assets/img/content/slider-1.png" alt="" /></div>
							    <div class="item"><img src="${location}/assets/img/content/slider-1.png" alt="" /></div>
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
        <script type="text/javascript" src="${location}/assets/scripts/libs/jquery.flexslider-min.js"></script>
        <script type="text/javascript" src="${location}/assets/scripts/libs/jQuery.fakeScroll.js"></script>
        <script type="text/javascript" src="${location}/assets/scripts/libs/jcf.js"></script>
        <script type="text/javascript" src="${location}/assets/scripts/libs/jcf.range.js"></script>
        <script type="text/javascript" src="${location}/assets/scripts/main/default.js"></script>
 <!--[if lt IE 7]>
    <p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
<![endif]-->

</body>
</html>
