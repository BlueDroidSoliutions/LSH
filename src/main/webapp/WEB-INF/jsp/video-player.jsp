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
			<div class="wrapper">
				<div class="video-view-wrapper">
					
				</div>
					<div class="video-view">
						<!-- left blocl -->
						<div class="left-container">
							<div class="main-video-block">
								<video id="my_video_1" class="video-js vjs-default-skin" width="640px" height="267px"
								      controls preload="none"
								      data-setup='{ "aspectRatio":"640:267", "playbackRates": [1, 1.5, 2] }'>
			  <source src="../ext/video/${video.id}.mp4" type='video/mp4' 
              <!--<source src="http://192.168.1.7:1935/live/myStream_360p/manifest.mpd" type='video/mp4'-->
                      
                      
                                                                           
  </video>
							</div>
							<div class="bottom">
								<div class="main-info">
									<ul class="main-info-list">
										<li class="name">
											<h3>${video.name}</h3>
										</li>
										<li class="duration">
											<div class="ico-wrapper">
												<a href="../addtofav/${video.id}">
													<svg version="1.1" id="fav" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
														 width="24.75px" height="23px" viewBox="0 0 24.75 23" enable-background="new 0 0 24.75 23" xml:space="preserve">
														<path fill="#C1272D" d="M12.645,18.485L20.126,23l-1.985-8.51l6.609-5.726l-8.704-0.738L12.645,0L9.243,8.026L0.539,8.764
														l6.609,5.726L5.164,23L12.645,18.485z"/>
													</svg>
												</a>
											</div>
											${video.duration}
										</li>
										<li class="vote-down">
											<div class="ico-wrapper">
												<a href="../voteDown/${video.id}">
													<svg version="1.1" id="dislike" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
														 width="24.75px" height="23px" viewBox="0 0 24.75 23" enable-background="new 0 0 24.75 23" xml:space="preserve">
														<path fill="#FFFFFF" d="M15.273,0H5.455c-0.905,0-1.68,0.545-2.007,1.331L0.153,9.022C0.055,9.273,0,9.535,0,9.818v2.084
														l0.011,0.011L0,12c0,1.2,0.982,2.182,2.182,2.182h6.884l-1.036,4.985l-0.033,0.349c0,0.447,0.185,0.862,0.48,1.156l1.156,1.145
														l7.189-7.189c0.393-0.393,0.633-0.938,0.633-1.538V2.182C17.455,0.982,16.473,0,15.273,0z M19.636,0v13.091H24V0H19.636z"/>
													</svg>
												</a>
											</div>
											<span class="curent-votes">${video.voteDown}</span>
										</li>
										<li class="vote-up">
											<div class="ico-wrapper">
												<a href="../voteUp/${video.id}">
													<svg version="1.1" id="like" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
														 width="24.75px" height="23px" viewBox="0 0 24.75 23" enable-background="new 0 0 24.75 23" xml:space="preserve">
														<path fill="#FFFFFF" d="M8.727,21.818h9.818c0.905,0,1.68-0.545,2.007-1.331l3.295-7.691C23.945,12.545,24,12.284,24,12V9.916
														l-0.011-0.011L24,9.818c0-1.2-0.982-2.182-2.182-2.182h-6.884l1.036-4.985l0.033-0.349c0-0.447-0.185-0.862-0.48-1.156L14.367,0
														L7.178,7.189C6.785,7.582,6.545,8.127,6.545,8.727v10.909C6.545,20.836,7.527,21.818,8.727,21.818z M4.364,21.818V8.727H0l0,13.091
														H4.364z"/>
													</svg>
												</a>
											</div>
											<span class="curent-votes">${video.voteUp}</span>
										</li>
										<li class="categories">
											<span>Categories</span>
											<p>
												<c:forEach items="${videoCat}" var="vc">
                                                                                            ${vc.name}
                                                                                        </c:forEach>
											</p>
											
										</li>
										<li class="views">
											<span>Views</span>
											<span>${video.viewCount}</span>
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
											<p>Tags: ${video.tag}</p>
											<p>Date upload: ${video.uploadDate}</p>
										</li>
										<li>
											<p>Season: ${season}</p>
										</li>
										<li>
                                                                                    <p>Categories: 
                                                                                        <c:forEach items="${videoCat}" var="vc">
                                                                                            ${vc.name}
                                                                                        </c:forEach></p>
										</li>
									</ul>
								</div>	
								
							</div>
							<!-- <a href="javascript:;" class="o-bottom-container">
								<img src="assets/img/o2.jpg" alt="" />
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
												<div class="video-info">
													<div class="description">
														<h5>Name name name</h5>
													</div>
													<span class="video-duration">10:36</span>
													<div class="video-thumbs">
														<span class="thumbs thumbs-down">
															<span class="icon"></span>
															<span class="counter">2</span>
														</span>
														<span class="thumbs thumbs-up">
															<span class="icon"></span>
															<span class="counter">25</span>
														</span>
													</div>
												</div>
											</div>
											<img src=".${location}/assets/img/content/slider-1.png" />
										</a>
									</li>
									<li>
										<a href="https://www.youtube.com/embed/HOU4k7z7QjE" target="main_frame">
											<div class="inner">
												<div class="video-info">
													<div class="description">
														<h5>Name name name</h5>
													</div>
													<span class="video-duration">10:36</span>
													<div class="video-thumbs">
														<span class="thumbs thumbs-down">
															<span class="icon"></span>
															<span class="counter">2</span>
														</span>
														<span class="thumbs thumbs-up">
															<span class="icon"></span>
															<span class="counter">25</span>
														</span>
													</div>
												</div>
											</div>
											<img src=".${location}/assets/img/content/slider-1.png" />
										</a>
									</li>
									<li>
										<a href="https://www.youtube.com/embed/azwzZIZHXzk" target="main_frame">
											<div class="inner">
												<div class="video-info">
													<div class="description">
														<h5>Name name name</h5>
													</div>
													<span class="video-duration">10:36</span>
													<div class="video-thumbs">
														<span class="thumbs thumbs-down">
															<span class="icon"></span>
															<span class="counter">2</span>
														</span>
														<span class="thumbs thumbs-up">
															<span class="icon"></span>
															<span class="counter">25</span>
														</span>
													</div>
												</div>
											</div>
											<img src=".${location}/assets/img/content/slider-1.png" />
										</a>
									</li>
									<li>
										<a href="https://www.youtube.com/embed/HOU4k7z7QjE" target="main_frame">
											<div class="inner">
												<div class="video-info">
													<div class="description">
														<h5>Name name name</h5>
													</div>
													<span class="video-duration">10:36</span>
													<div class="video-thumbs">
														<span class="thumbs thumbs-down">
															<span class="icon"></span>
															<span class="counter">2</span>
														</span>
														<span class="thumbs thumbs-up">
															<span class="icon"></span>
															<span class="counter">25</span>
														</span>
													</div>
												</div>
											</div>
											<img src=".${location}/assets/img/content/slider-1.png" />
										</a>
									</li>
									<li>
										<a href="https://www.youtube.com/embed/azwzZIZHXzk" target="main_frame">
											<div class="inner">
												<div class="video-info">
													<div class="description">
														<h5>Name name name</h5>
													</div>
													<span class="video-duration">10:36</span>
													<div class="video-thumbs">
														<span class="thumbs thumbs-down">
															<span class="icon"></span>
															<span class="counter">2</span>
														</span>
														<span class="thumbs thumbs-up">
															<span class="icon"></span>
															<span class="counter">25</span>
														</span>
													</div>
												</div>
											</div>
											<img src=".${location}/assets/img/content/slider-1.png" />
										</a>
										
									</li>
									<li>
										<a href="https://www.youtube.com/embed/HOU4k7z7QjE" target="main_frame">
											<div class="inner">
												<div class="video-info">
													<div class="description">
														<h5>Name name name</h5>
													</div>
													<span class="video-duration">10:36</span>
													<div class="video-thumbs">
														<span class="thumbs thumbs-down">
															<span class="icon"></span>
															<span class="counter">2</span>
														</span>
														<span class="thumbs thumbs-up">
															<span class="icon"></span>
															<span class="counter">25</span>
														</span>
													</div>
												</div>
											</div>
											<img src=".${location}/assets/img/content/slider-1.png" />
										</a>
									</li>
								</ul>
							</div>
							<a href="javascript:;" class="o-right-container">
								<img src="../resources/assets/img/o3.jpg" alt="" />
							</a>
						</div>
						<!-- End of right block -->
					</div>
			</div>
				

			 <%@include file="footer.jsp" %>
		</div>
			
	</div>

	<!-- javascript -->
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
	<script type="text/javascript">window.jQuery || document.write("<script src='../resources/assets/scripts/main/jquery-1.8.3.min.js'>\x3C/script>")</script>
	<script type="text/javascript" src="../resources/assets/scripts/libs/jquery.flexslider-min.js"></script>
	<script type="text/javascript" src="../resources/assets/scripts/libs/jQuery.fakeScroll.js"></script>
	
	<script type="text/javascript" src="../resources/assets/scripts/libs/jcf.js"></script>
	<script type="text/javascript" src="../resources/assets/scripts/libs/jcf.checkbox.js"></script>
	

	<script type="text/javascript" src="../resources/assets/scripts/main/default.js"></script>

	<link href="//vjs.zencdn.net/5.19/video-js.min.css" rel="stylesheet">
	<script src="//vjs.zencdn.net/5.19/video.min.js"></script>

 <!--[if lt IE 7]>
    <p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
<![endif]-->

</body>
</html>
