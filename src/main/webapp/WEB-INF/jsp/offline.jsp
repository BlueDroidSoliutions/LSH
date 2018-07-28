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


    <main class="page-offline">
			<div class="offline-container clearfix">
					<div class="employee-cover" href="javascript:;"><img src="${bck}${location}/assets/img/content/offline_big.jpg" alt=""></div>
				<div class="stat-wrapper">
					<div class="stats-bottom">
                                            
                                            <c:if test="${date != ''}">
                                                <p>Last broadcast: ${date}</p>
                                            </c:if>
						
                                                <c:if test="${high != ''}">
                                                    <p>Highest daily honorar: ${high}</p>
                                                </c:if>
						
                                                
                                                
                                                
<!--						<p class="schedule">Schedule:</p>
						<ul>
							<li class="clearfix"><span class="day">Monday</span><span class="time">8AM</span></li>
							<li class="clearfix"><span class="day">Monday</span><span class="time">8AM</span></li>
							<li class="clearfix"><span class="day">Monday</span><span class="time">8AM</span></li>
							<li class="clearfix"><span class="day">Monday</span><span class="time">8AM</span></li>
						</ul>-->
						<p class="views">Views: <span>${cg.views}</span></p>
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
										${cg.rate}
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
										${fav}
									</a>
								</li>
							</ul>
							<div class="txt-holder">
								<p>
									${cg.story}
								</p>
							</div>
						</div>
						<div class="major-info clearfix">
							<ul>
								<li class="clearfix"><span class="title">Preferences</span><span class="txt">Bisexual</span></li>
								<li class="clearfix"><span class="title">Age</span><span class="txt">${cg.age}</span></li>
                                                                <c:choose>
                                                                    <c:when test="${cg.gender == false}">
                                                                    <li class="clearfix"><span class="title">Gender</span><span class="txt">Female</span></li>
                                                                    </c:when>
                                                                    <c:otherwise>
                                                                        <li class="clearfix"><span class="title">Gender</span><span class="txt">Male</span></li>
                                                                    </c:otherwise>
                                                                </c:choose>
								
								<li class="clearfix"><span class="title">Measurements</span><span class="txt">${cg.measure}</span></li>
                                                                <li class="clearfix"><span class="title">Language</span><span class="txt">${cg.language}</span></li>
							</ul>
							<ul>
								<li class="clearfix"><span class="title">Height</span><span class="txt">${cg.height}</span></li>
								<li class="clearfix"><span class="title">Weight</span><span class="txt">${cg.weight}</span></li>
								<li class="clearfix"><span class="title">Hair</span><span class="txt">${cg.hair}</span></li>
								<li class="clearfix"><span class="title">Cup Size</span><span class="txt">${cg.breast}</span></li>
 <li class="clearfix"><span class="title">Other</span><span class="txt">${cg.body} ${cg.decoration} ${cg.pubicHair}</span></li>
							</ul>
						</div>
                                                                

                                                                <c:choose>
                                                                    <c:when test="${empty topFan}"></c:when>
                                                                    <c:otherwise>
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
                                                            
                                                            <c:forEach items="${topFan}" var="tf">
                                                                <li><img src="${bck}${location}/assets/img/content/user_img.jpg" alt=""><span>${tf.username}</span></li>
                                                            </c:forEach>
							</ul>
						</div>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                                
						
                                                                
                                                                
                                                                
					</div>
				</div>
				<div class="gallery-wrapper">
					<div class="gallery-holder clearfix">
						<a class="gallery-popup">
							<span>Watch me <br>in my gallery</span>
						</a>
						<img src="${bck}${location}/assets/img/content/offline_gallery.jpg" alt="">
						<img src="${bck}${location}/assets/img/content/offline_gallery.jpg" alt="">
						<img src="${bck}${location}/assets/img/content/offline_gallery.jpg" alt="">
						<img src="${bck}${location}/assets/img/content/offline_gallery.jpg" alt="">
					</div>
					<div class="gallery-bottom">
						<img src="${bck}${location}/assets/img/content/offline_big.jpg" alt="">
					</div>
				</div>
			</div>
		</main>

		 <%@include file="footer.jsp" %>
		<!-- </div> -->
			
	</div>

	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
	<script type="text/javascript">window.jQuery || document.write("<script src='${bck}${location}/assets/scripts/main/jquery-1.8.3.min.js'>\x3C/script>")</script>
	<script type="text/javascript" src="${bck}${location}/assets/scripts/libs/owl.carousel.min.js"></script>
	<script type="text/javascript" src="${bck}${location}/assets/scripts/main/default.js"></script>

</body>
</html>
