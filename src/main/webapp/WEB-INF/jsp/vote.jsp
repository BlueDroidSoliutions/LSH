
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>



<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js ie6"> <![endif]-->
<!--[if IE 7]>         <html class="no-js ie7"> <![endif]-->
<!--[if IE 8]>         <html class="no-js ie8"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->


<script type="text/javascript" src="${location}/assets/scripts/pages/vote.js"></script>


<c:choose>
    <c:when test="${not empty userName}">
    <%@include file="signed.jsp" %>
    </c:when>
    <c:otherwise>
    <%@include file="sign.jsp" %>
    </c:otherwise>
</c:choose>

		<div id="token-section">
			<div class="token-wrapper">
				<div class="inner">
					<a href="javascript:;" id="close-me">
						
					</a>
					<div class="top">
						<h2>Buy tokens</h2>
						<p>choose package for you</p>
					</div>
					<div class="top-list">
						<ul>
                            <c:forEach items="${pricePackages}" var="pricePackage">
                                <c:if test="${pricePackage.name != 'silver' && pricePackage.name != 'gold' && pricePackage.name != 'premium'}">
                                    <li>
                                        <div class="item-inner">
                                            <h3>${pricePackage.name}</h3>
                                            <p>${pricePackage.tokens} tokens</p>
                                            <span>${pricePackage.amount}$</span>
                                        </div>
                                        <a href="javascript:;" class="btn" onclick="buyTokens('${_csrf.token}', ${pricePackage.id})">Buy</a>
                                    </li>
                                </c:if>
                            </c:forEach>
						</ul>
					</div>
					<div class="bottom-list">
						<ul>
                            <c:forEach items="${pricePackages}" var="pricePackage">
                                <c:if test="${pricePackage.name == 'silver' || pricePackage.name == 'gold' || pricePackage.name == 'premium'}">
                                    <li class="${pricePackage.name}">
                                        <div class="item-inner">
                                            <img src="${location}/assets/img/${pricePackage.name}.png" alt="" />
                                            <p>${pricePackage.tokens} tokens</p>
                                            <span>${pricePackage.amount}$</span>
                                        </div>
                                        <a href="javascript:;" class="btn" onclick="buyTokens('${_csrf.token}', ${pricePackage.id})">Buy</a>
                                    </li>
                                </c:if>
                            </c:forEach>
						</ul>
					</div>
				</div>
			</div>
		</div>






		<div id="page-wrap">
			<div class="content">
				<div class="person-details" id="details-block">
                                    
                                    
                                     <c:choose>
                                    <c:when test="${idFromIndex != null}">
                                         <c:forEach items="${mh}" var="mh" >
                                         
                                             
					<div id="tab-${mh.id}" ${mh.id==idFromIndex ? 'class = "tab-content current"' : 'class = "tab-content"'}>
                                            
                                            
                                            
                                            
						<div class="tab-wrapper">
							<div class="img-block">
								<img src="./ext/ProfileMembers/${mh.id}.jpg" alt="">
							</div>

							<div class="description-block">
								<div class="top">
									<h2>
										<span>${mh.name}</span>
										<img src="${location}/assets/img/content/flag-en.png" alt="" />
									</h2>
									<a href="javascript:;" class="btn" id="showTokens">
										<img src="${location}/assets/img/content/token.png" alt="" />
										Buy tokens
									</a>
								</div>
								<div class="description">
									<p>
										${mh.txt}
									</p>
								</div>
								<div class="bottom">
									<ul>
										<li>
											<h3>${mh.rank}<sup>TH</sup></h3>
											<span>place</span>
										</li>
										<li>
											<h3>${mh.vote}</h3>
											<span>votes</span>
										</li>
										<li>
											<a href="./vote/${mh.id}" class="vote-btn">Vote</a>
										</li>
									</ul>
								</div>
							</div>

							<div class="gallery-block">
								<ul>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
								</ul>
							</div>
						</div>
					</div>
                                             </c:forEach>
                                    </c:when>
                                    <c:otherwise>
                                        <c:forEach items="${mh}" var="mh" varStatus="statuss">
                                         
					<div id="tab-${mh.id}" 
                                             ${statuss.first ? 'class = "tab-content current"' : 'class = "tab-content"'}
                                             >
						<div class="tab-wrapper">
							<div class="img-block">
								<img src="./ext/ProfileMembers/${mh.id}.jpg" alt="">
							</div>

							<div class="description-block">
								<div class="top">
									<h2>
										<span>${mh.name}</span>
										<img src="${location}/assets/img/content/flag-en.png" alt="" />
									</h2>
									<a href="javascript:;" class="btn" id="showTokens">
										<img src="${location}/assets/img/content/token.png" alt="" />
										Buy tokens
									</a>
								</div>
								<div class="description">
									<p>
										${mh.txt}
									</p>
								</div>
								<div class="bottom">
									<ul>
										<li>
											<h3>${mh.rank}<sup>TH</sup></h3>
											<span>place</span>
										</li>
										<li>
											<h3>${mh.vote}</h3>
											<span>votes</span>
										</li>
										<li>
											<a href="./vote/${mh.id}" class="vote-btn">Vote</a>
										</li>
									</ul>
								</div>
							</div>

							<div class="gallery-block">
								<ul>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
								</ul>
							</div>
						</div>
					</div>
                                             </c:forEach>
                                    </c:otherwise>
                                </c:choose>
                                    
                                                                  
                                      
				</div>

                          
                            
				<div class="people-list">
					<ul class="people tabs">
                                            
                                       
                                            <c:choose>
                                    <c:when test="${idFromIndex != null}">
                                         <c:forEach items="${mh}" var="mh" >
				<li  data-tab="tab-${mh.id}" ${mh.id==idFromIndex ? 'class = "tab-link current"' : 'class = "tab-link"'}>
							<div class="inner">
								<div class="img-wrapper">
									<div class="overlay">
										<span>Vote</span>
									</div>
									<img src="./ext/ProfileMembers/a${mh.id}.jpg" alt="">
								</div>
								<p>${mh.name}</p>
								<span class="total">${mh.vote}</span>
							</div>
						</li>
                                                </c:forEach>   

                                    </c:when>
                                    <c:otherwise>
                                        <c:forEach items="${mh}" var="mh" varStatus="status">
				<li  data-tab="tab-${mh.id}" ${status.first ? 'class = "tab-link current"' : 'class = "tab-link"'}>
							<div class="inner">
								<div class="img-wrapper">
									<div class="overlay">
										<span>Vote</span>
									</div>
									<img src="./ext/ProfileMembers/a${mh.id}.jpg" alt="">
								</div>
								<p>${mh.name}</p>
								<span class="total">${mh.vote}</span>
							</div>
						</li>
                                                </c:forEach>                                        
                                    </c:otherwise>
                                </c:choose>
                                            
                                     
					</ul>
				</div>
			</div>

			 <%@include file="footer.jsp" %>
		</div>
			
	</div>
        
        
       

	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
	<script type="text/javascript">window.jQuery || document.write("<script src='${bck}${location}/assets/scripts/main/jquery-1.8.3.min.js'>\x3C/script>");</script>
	<script type="text/javascript" src="${bck}${location}/assets/scripts/libs/owl.carousel.min.js"></script>
        <script type="text/javascript" src="${location}/assets/scripts/libs/jcf.js"></script>
	<script type="text/javascript" src="${bck}${location}/assets/scripts/main/default.js"></script>

</body>
</html>




