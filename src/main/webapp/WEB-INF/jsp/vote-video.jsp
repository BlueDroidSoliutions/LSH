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

		
		<div id="page-wrap" class="full-height-wrap">
			<div class="wrapper ">
				<div class="video-view-wrapper">
					
				</div>
					<div class="video-view">
						<!-- left blocl -->
						<div class="left-container">
							<div class="main-video-block">
								<iframe id="main_frame" src="https://www.youtube.com/embed/LIMYj5mpMM4" frameborder="0" ></iframe>
							</div>
							<div class="bottom">
								<div class="main-info">
									<ul class="main-info-list">
										<li class="name">
											<h3>Name of the video longer video title</h3>
										</li>
										<li class="duration">
											<div class="ico-wrapper">
												<a href="javascript:;">
													<svg version="1.1" id="fav" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
														 width="24.75px" height="23px" viewBox="0 0 24.75 23" enable-background="new 0 0 24.75 23" xml:space="preserve">
														<path fill="#C1272D" d="M12.645,18.485L20.126,23l-1.985-8.51l6.609-5.726l-8.704-0.738L12.645,0L9.243,8.026L0.539,8.764
														l6.609,5.726L5.164,23L12.645,18.485z"/>
													</svg>
												</a>
											</div>
											10:15
										</li>
										<li class="vote-down">
											<div class="ico-wrapper">
												<a href="javascript:;">
													<svg version="1.1" id="dislike" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
														 width="24.75px" height="23px" viewBox="0 0 24.75 23" enable-background="new 0 0 24.75 23" xml:space="preserve">
														<path fill="#FFFFFF" d="M15.273,0H5.455c-0.905,0-1.68,0.545-2.007,1.331L0.153,9.022C0.055,9.273,0,9.535,0,9.818v2.084
														l0.011,0.011L0,12c0,1.2,0.982,2.182,2.182,2.182h6.884l-1.036,4.985l-0.033,0.349c0,0.447,0.185,0.862,0.48,1.156l1.156,1.145
														l7.189-7.189c0.393-0.393,0.633-0.938,0.633-1.538V2.182C17.455,0.982,16.473,0,15.273,0z M19.636,0v13.091H24V0H19.636z"/>
													</svg>
												</a>
											</div>
											<span class="curent-votes">2</span>
										</li>
										<li class="vote-up">
											<div class="ico-wrapper">
												<a href="javascript:;">
													<svg version="1.1" id="like" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
														 width="24.75px" height="23px" viewBox="0 0 24.75 23" enable-background="new 0 0 24.75 23" xml:space="preserve">
														<path fill="#FFFFFF" d="M8.727,21.818h9.818c0.905,0,1.68-0.545,2.007-1.331l3.295-7.691C23.945,12.545,24,12.284,24,12V9.916
														l-0.011-0.011L24,9.818c0-1.2-0.982-2.182-2.182-2.182h-6.884l1.036-4.985l0.033-0.349c0-0.447-0.185-0.862-0.48-1.156L14.367,0
														L7.178,7.189C6.785,7.582,6.545,8.127,6.545,8.727v10.909C6.545,20.836,7.527,21.818,8.727,21.818z M4.364,21.818V8.727H0l0,13.091
														H4.364z"/>
													</svg>
												</a>
											</div>
											<span class="curent-votes">25</span>
										</li>
										<li class="categories">
											<span>Categories</span>
											<p>
												<a href="javascript:;">Bodo</a>,
										
												<a href="javascript:;">Blonde</a>,
											
												<a href="javascript:;">Shower</a>
											</p>
											
										</li>
										<li class="views">
											<span>Views</span>
											<span>21343</span>
										</li>
										<li class="tokens">
											<div class="ico-wrapper">
												<a href="javascript:;">
													<svg version="1.1" id="tokens" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
															 width="31.5px" height="29.699px" viewBox="0 0 31.5 29.699" enable-background="new 0 0 31.5 29.699" xml:space="preserve">
														<g>
															<g>
																<ellipse fill="#FFFFFF" cx="15.167" cy="8.761" rx="6.756" ry="2.436"/>
																<path fill="#FFFFFF" d="M8.411,12.156v3.1c0,0,6.579,3.824,13.511,0c0-1.409,0-3.174,0-3.174S16.319,15.95,8.411,12.156z"/>
																<path fill="#FFFFFF" d="M8.411,17.915v3.1c0,0,6.579,3.824,13.511,0c0-1.409,0-3.174,0-3.174S16.319,21.709,8.411,17.915z"/>
															</g>
															<circle fill="none" stroke="#FFFFFF" stroke-width="1.05" stroke-miterlimit="10" cx="15" cy="15.352" r="14"/>
														</g>
													</svg>
												</a>
											</div>
											<span>25</span>
											<a href="javascript:;" class="btn-small">Buy</a>
										</li>
										<li class="report">
											<div class="ico-wrapper">
												<a href="javascript:;">
													<svg version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
														 width="24.75px" height="23px" viewBox="0 0 24.75 23" enable-background="new 0 0 24.75 23" xml:space="preserve">
													<path fill="#FFFFFF" d="M15.831,2.588L15.314,0H3.667v22h2.588v-9.059h7.247l0.518,2.588h9.059V2.588H15.831z"/>
													</svg>
												</a>
											</div>
										</li>
									</ul>
								</div>
								<a href="javascript:;" class="show-more">
									<span class="visible">Show more</span>
									<span>Show less</span>
									<i class="ico"></i>
								</a>
								<div class="more-details">
									<ul>
										<li>
											<p>Tags:</p>
											<p>Date upload:</p>
										</li>
										<li>
											<p>Season:</p>
										</li>
										<li>
											<p>Categories:</p>
										</li>
									</ul>
								</div>	
								
							</div>
							<!-- <a href="javascript:;" class="o-bottom-container">
								<img src="${location}/assets/img/o2.jpg" alt="" />
							</a> -->
						</div>
						<!-- End of left block -->

						<!-- Right block -->
						<div class="right-container">
							<div id="carousel" class="flexslider">
								<ul class="slides">
									<li>
										<a href="https://www.youtube.com/embed/azwzZIZHXzk" >
											<div class="inner">
												<h4>Item name</h4>
												<span class="views">32,332323</span>
												<span class="duration">10:36</span>
											</div>
											<img src="${location}/assets/img/content/slider-1.png" />
										</a>
									</li>
									<li>
										<a href="https://www.youtube.com/embed/HOU4k7z7QjE" target="main_frame">
											<div class="inner">
												<h4>Item name</h4>
												<span class="views">32,332323</span>
												<span class="duration">10:36</span>
											</div>
											<img src="${location}/assets/img/content/slider-1.png" />
										</a>
									</li>
									<li>
										<a href="https://www.youtube.com/embed/azwzZIZHXzk" target="main_frame">
											<div class="inner">
												<h4>Item name</h4>
												<span class="views">32,332323</span>
												<span class="duration">10:36</span>
											</div>
											<img src="${location}/assets/img/content/slider-1.png" />
										</a>
									</li>
									<li>
										<a href="https://www.youtube.com/embed/HOU4k7z7QjE" target="main_frame">
											<div class="inner">
												<h4>Item name</h4>
												<span class="views">32,332323</span>
												<span class="duration">10:36</span>
											</div>
											<img src="${location}/assets/img/content/slider-1.png" />
										</a>
									</li>
									<li>
										<a href="https://www.youtube.com/embed/azwzZIZHXzk" target="main_frame">
											<div class="inner">
												<h4>Item name</h4>
												<span class="views">32,332323</span>
												<span class="duration">10:36</span>
											</div>
											<img src="${location}/assets/img/content/slider-1.png" />
										</a>
										
									</li>
									<li>
										<a href="https://www.youtube.com/embed/HOU4k7z7QjE" target="main_frame">
											<div class="inner">
												<h4>Item name</h4>
												<span class="views">32,332323</span>
												<span class="duration">10:36</span>
											</div>
											<img src="${location}/assets/img/content/slider-1.png" />
										</a>
									</li>
								</ul>
							</div>
							<a href="javascript:;" class="o-right-container">
								<img src="${location}/assets/img/o3.jpg" alt="" />
							</a>
						</div>
						<!-- End of right block -->
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

	<%@include file="jsScript.jsp" %>

</body>
</html>
