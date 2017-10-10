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
                                                            
                                                             <c:forEach items="${mh}" var="mh">
                                                                <li>
									<span class="curent-state">${mh.vote}</span>
									<a href="./voteFromIndex/${mh.id}">
										<div class="img-wrapper">
											<div class="overlay">Vote</div>
											<img src="${location}/assets/img/content/profile-s.png" alt="" />
										</div>
									</a>
									<span class="name">${mh.name}</span>
								</li>
                                                            </c:forEach>
                                                            
                                                            
                                                            
								
							</ul>
						</div>
						
						<a href="./participate" class="sidebar-btn">Participate</a>
						<a href="./wish" class="sidebar-btn">Your wish</a>
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
								<a href="./video" class="one-half widget">
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
								<a href="./webcam">View all</a>
								<a href="javascript:;" class="token-img">
									<img src="" alt="" />
								</a>
							</div>
                                                    
                                                    
                                                    <style>
                                                        .onlineGirl{position: absolute; padding-top: 10px; padding-left: 5px; color: greenyellow;}
                                                        #i001{display: none;}
                                                    </style>

                                                    <div class="owl-carousel">
                                                        
                                                    
                                                       
                                                        
                                                        <c:forEach items="${girl}" var="girl" varStatus="status">
                                                        
                                                            <c:if test="${statuss.first}">
                                                                <script>
                                                                    var first = 
                                                                </script>
                                                            </c:if>
                                                            
                                                            <div class="item" id="i${girl.id}" >
                                                            <p class="onlineGirl">ONLINE</p> 
                                                            <a href="javascript:;">  <img src="ext/girlImg/${girl.name}.jpg" alt="" /> </a>
                                                            </div>
                                                                
                                                         </c:forEach>       
                                                                
                                                        
                                                    </div>

  
                                                            
						</div>
					</div>
				</div>
			</div>

			 <%@include file="footer.jsp" %>
		</div>
			
	</div>

	<!-- javascript -->

        
        
        
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
	<script type="text/javascript">window.jQuery || document.write("<script src='assets/scripts/main/jquery-1.8.3.min.js'>\x3C/script>")</script>
	<script type="text/javascript" src="${location}/assets/scripts/libs/owl.carousel.min.js"></script>
	<script type="text/javascript" src="${location}/assets/scripts/libs/jcf.js"></script>
	<script type="text/javascript" src="${location}/assets/scripts/libs/jcf.checkbox.js"></script>
	<script type="text/javascript" src="${location}/assets/scripts/libs/jQuery.fakeScroll.js"></script>
	<script type="text/javascript" src="${location}/assets/scripts/main/default.js"></script>
        
        
        
 <!--[if lt IE 7]>
    <p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
<![endif]-->

</body>
</html>
