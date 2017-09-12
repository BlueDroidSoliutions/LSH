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



<style>
#active{
    background-color: white;
    color: red;
}
</style>




            <div id="page-wrap">
                <div class="content">
                    <div class="wrapper">
                        <div class="left-sidebar">
                            <div class="top-part">
                                <h1>Video archive</h1>
                                <div class="search-form">
                                    
                                    
                                    
                                    <form name='search' action="${pageContext.request.contextPath}/search" method="POST">
                                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                                        <input type="text" placeholder="Search" name="string" />
                                        <button  name="submit" type="submit"  value="submit" class="btn">Search</button>
                                                                                          
                                    </form>
                                    
                                    
                                    
                                    
                                </div>
                                <div class="selected-filters">
                                    <span class="title">Filter:</span>
                                    <div class="filters-holder">



                                        <c:forEach items="${individualPar}" var="ip">
                                            <c:set var="iipp" value="${fn:split(ip, ',')}" />
                                            <a href="${pth}./video?${iipp[1]}" class="filter-tag">
                                                <span class="remove-filter">Remove</span>
                                                <span class="value">${iipp[0]}</span>
                                            </a>
                                        </c:forEach>


                                    </div>
                                </div>
                            </div>
                            <div class="filter-by">
                                <ul>
                                    <li>
                                        <a href="javascript:;"  class="current" data-tab="tab-1">Category</a>
                                    </li>
                                    <li>
                                        <a href="javascript:;" data-tab="tab-2">Room</a>
                                    </li>
                                    <li>
                                        <a href="javascript:;" data-tab="tab-3">Season</a>
                                    </li>
                                    <li>
                                        <a href="javascript:;" data-tab="tab-4">Duration</a>
                                    </li>
                                    <li>
                                        <a href="javascript:;" data-tab="tab-5">Date edited</a>
                                    </li>
                                    <li>
                                        <a href="javascript:;" data-tab="tab-6">Member</a>
                                    </li>
                                </ul>
                            </div>



                            <div class="category-list">




                                <div id="tab-1" class="filter-content current">
                                    <ul>
                                            <c:forEach items="${videoCategoryCountClips}" var="vccc">
                                                <li>
                                                    <a href="${pth}./video?8=${vccc.id}${params}${percent}">
                                                        <span class="name">${vccc.name}</span>
                                                        <span class="results">${vccc.numb}</span>
                                                    </a>
                                                </li>
                                            </c:forEach>
                                    </ul>
                                </div>






                                <div id="tab-2" class="filter-content">
                                    <ul>
                                        <c:forEach items="${videoRoom}" var="vRoom">
                                          <li>
                                            <a href="${pth}./video?4=${vRoom.id}${params}">
                                                ${vRoom.name}
                                            </a>
                                        </li>
                                        </c:forEach>
                                        
                                    </ul>
                                </div>
                                
                                
                                
                                
                                
                                
                                
                                <div id="tab-3" class="filter-content">
                                    <ul>
                                       
                                        
                                        
                                <c:forEach begin="1" end="${totalSeasons}" var="totS" varStatus="loopStatus">        
                                      <li>
                                            <a href="${pth}./video?5=${loopStatus.index}${params}${percent}">
                                                ${totS}
                                            </a>
                                        </li>   
                                </c:forEach>        
                                        
                                    </ul>
                                </div>
                                
                                
                                
                                
                                
                                
                                
                                
                                <div id="tab-4" class="filter-content">
                                    <ul>
                                                    <li><a href="${pth}./video?6=1${params}${percent}">Less than 5 min</a></li>
                                                    <li><a href="${pth}./video?6=2${params}${percent}">5 min to 15 min</a></li>
                                                    <li><a href="${pth}./video?6=3${params}${percent}">15 min to 30 min</a></li>
                                                    <li><a href="${pth}./video?6=4${params}${percent}">More than 30 min</a></li>
                                    </ul>
                                </div>	
                                
                                
                                
                                
                                <div id="tab-6" class="filter-content">
                                    <ul>
                                       <c:forEach items="${member}" var="mHouse">
                                          <li>
                                            <a href="${pth}./video?7=${mHouse.id}${params}${percent}">
                                                ${mHouse.name}
                                            </a>
                                        </li>
                                        </c:forEach>
                                    </ul>
                                </div>	
                                
                                
                                


                                                    <div id="tab-5" class="filter-content">
                                                        <div class="picker-wrapper">
                                                            <div data-toggle="datepicker" class="pickedDate"></div>
                                                        </div>

                                                        <c:set var="numberAsString" value="${filterDateExist}"></c:set>
                                                        <c:choose>
                                                            <c:when test="${!numberAsString.matches('[0-9]+')}">
                                                                <div class="btn-wrap">
                                                                <a href="javascript:;" class="btn-small">Choose date</a>
                                                            </div>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <p style="color:white">Remove Date from filters and try again</p>
                                                            </c:otherwise>
                                                        </c:choose>
                                                       



                                                    </div>	




                                
                                
                                
                                
                                
                            </div>
                        </div>
                        <div class="main-content">
                            <div class="video-sort">
                                <span class="title">Sort by:</span>
                                <div class="sort-options">
                                    <ul>

                                        <li>
                                            <a href="javascript:;">Name</a>
                                            <div class="option-block popularity">
                                                <a href="${pth}./video?2=1${paramsWithoutSort}${percent}" class="a-z">A-Z</a>
                                                <a href="${pth}./video?2=2${paramsWithoutSort}${percent}" class="z-a">Z-A</a>
                                            </div>
                                        </li>

                                        <li>
                                            <a href="${pth}./video?2=3${paramsWithoutSort}${percent}">Wish List</a>
                                        </li>

                                        <li>
                                            <a href="${pth}./video?2=4${paramsWithoutSort}${percent}">View</a>
                                        </li>

                                        <li>
                                            <a href="javascript:;">Popularity</a>
                                            <div class="option-block popularity">
                                                <a href="${pth}./video?2=6${paramsWithoutSort}${percent}" class="high-popularity">Most popular</a>
                                                <a href="${pth}./video?2=5${paramsWithoutSort}${percent}" class="low-popularity">Least popular</a>
                                            </div>
                                        </li>

                                        <li>
                                            <a href="javascript:;">Date</a>
                                            <div class="option-block popularity">
                                                <a href="${pth}./video?2=8${paramsWithoutSort}${percent}" class="newest">Newest first</a>
                                                <a href="${pth}./video?2=7${paramsWithoutSort}${percent}" class="oldest">Oldest first</a>
                                            </div>
                                        </li>






                                        <li>
                                            <a href="javascript:;">Duration</a>
                                            <div class="option-block duration">
                                                <ul>
                                                    <li><a href="${pth}./video?2=12${paramsWithoutSort}${percent}">Longest first</a></li>
                                                    <li><a href="${pth}./video?2=11${paramsWithoutSort}${percent}">shortest first</a></li>
                                                   
                                                </ul>
                                            </div>
                                        </li>
                                        
                                        
                                        
                                        <li>
										<a href="${pth}./video?2=0${paramsWithoutSort}${percent}">RESET SORT</a>
									</li>
                                        
                                        
                                        
<!--                                        <li>
                                            <span class="collapse-sort">Collapse</span>
                                        </li>-->
                                    </ul>
                                </div>
                            </div>
                            <div class="video-list">
                                <ul class="clearfix">
                                    
                                    
                                    
                                    
                                    
                                  
                                   ${noVideoFound}
                                    
                                    
                                    
                                     <c:forEach items="${video}" var="video">
								<li class="video-item">
									<a href="./video/${video.id}">
										<div class="thumbnail">
                                                                                    
                         <c:forEach begin="1" end="5" var="cfe" varStatus="loopStatus">
                                                                                        
                               
                               <img src="./ext/slike/${video.id}_${cfe}.jpg" class="rollme" alt=""/>                                                         
                                                                                        
                         </c:forEach>
                                                                                    
											
                                                                                        
										</div>
										<div class="video-info">
											<div class="description">
												<h5>${video.name}</h5>
												<span class="views">${video.viewCount} views</span>
											</div>
											<span class="access-link">Access</span>
											<span class="video-duration">${video.duration}</span>
											<div class="video-thumbs">
												<span class="thumbs thumbs-down">
													<span class="icon"></span>
													<span class="counter">${video.voteDown}</span>
												</span>
												<span class="thumbs thumbs-up">
													<span class="icon"></span>
													<span class="counter">${video.voteUp}</span>
												</span>
											</div>
										</div>
									</a>
								</li>
                                                                </c:forEach>
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                </ul>
                            </div>
                            <div class="ads">
                                <a href="javascript:;">
                                    <img src="${location}/assets/img/o4.jpg" alt="" />
                                </a>
                                <a href="javascript:;">
                                    <img src="${location}/assets/img/o4.jpg" alt="" />
                                </a>
                            </div>
                        </div>
                        <div class="pagination">
                            
                            <ul>${pagination}</ul>
                        </div>
                    </div>
                </div>

               <%@include file="footer.jsp" %>
            </div>

        </div>


        
        <script type="text/javascript" src="${location}/assets/scripts/libs/datepicker.min.js"></script>
       <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
	<script type="text/javascript">window.jQuery || document.write("<script src='${location}/assets/scripts/main/jquery-1.8.3.min.js'>\x3C/script>")</script>
	<script type="text/javascript" src="${location}/assets/scripts/libs/masonry.pkgd.min.js"></script>
	<script type="text/javascript" src="${location}/assets/scripts/libs/datepicker.min.js"></script>
	<script type="text/javascript" src="${location}/assets/scripts/main/default.js"></script>
        <script type="text/javascript" src="${location}/assets/scripts/libs/jquery.flexslider-min.js"></script>
        <script type="text/javascript" src="${location}/assets/scripts/libs/jQuery.fakeScroll.js"></script>
        
        
        <c:set var="startD" value='${startDate}'/> 
        <script> var sd = '<c:out value="${startD}"/>'; </script>
        
       
    <script>
    if ( $( '[data-toggle="datepicker"]' ).length ) {

        var today = new Date();
        var dd = today.getDate();
        var mm = today.getMonth()+1; 
        var yyyy = today.getFullYear();

        if(dd<10) {
            dd = '0'+dd
        } 

        if(mm<10) {
            mm = '0'+mm
        }

        console.log(today);

        var today = $().datepicker('getDate', true);
        var firstVideo = $().datepicker('getDate', true);

       $('[data-toggle="datepicker"]').datepicker({
            inline: true,
            container: '.picker-wrapper',
            endDate: today, 
            startDate: sd
       });

    }

    $('.filter-tag').click(function(){
        var selectedFilter = $(this).find('.value').text();
//        alert(selectedFilter);
    });

    jQuery.fn.checkEmpty = function() {
       return !$.trim(this.html()).length;
    };
         
    $('.btn-small').click(function(e){

        if($(".pickedDate").checkEmpty()){
            console.log('empty'); 
            e.preventDefault();
        } else {
            console.log('full');    
            var selectedDate = $('.pickedDate').text();

            var pageUrl = window.location.href;
            var newUrl;
        } 

   if (pageUrl.indexOf('?') == -1) {
            newUrl = pageUrl + "?3=" + selectedDate;
        } else {
            newUrl = pageUrl + "&&3=" + selectedDate;
           
        }

   location.href = newUrl;

    });

        </script>
        

    </body>
</html>
