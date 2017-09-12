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
<h1>Liked Videos</h1>                               
                             
                            </div>
                         



                        </div>
                        <div class="main-content">
                            
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
