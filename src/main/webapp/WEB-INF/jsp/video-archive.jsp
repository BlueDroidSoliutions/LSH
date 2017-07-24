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
        <title>LiveSexHouse</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,700" rel="stylesheet">
        <link rel="stylesheet" href="${location}/assets/css/style.css">
        <script type="text/javascript" src="${location}/assets/scripts/libs/modernizr.2.8.3.min.js"></script>
        <script src="https://use.fontawesome.com/48b7d32ec9.js"></script>

    </head>
    <body>
        
<style>

    .pagination{
        display: inline-block;
    
    width: 100%;
    height: auto;
    background-color: transparent;
    color: white;
}
.pagination a{
    text-decoration: none;
    font-size: 15px;

}
.pagination li{
/*    display: inline-block;*/
    
    width: 30px;
    margin-left: -3px;
    transition: background-color .2s ease-in;
    -moz-transition: background-color .2s ease-in;
    -webkit-transition: background-color .2 ease-in;
    color: white;
}
.pagination li:hover{
    background-color: white;
    color: black;

}
.pagination ul{
    width: 400px;
    height: auto;
    text-align: center;
    margin: auto;
    color:white;
}
.active li{
    background-color: white;
    color: red;
}

</style>
<%@include file="sign.jsp" %>




        <div class="container full-screen-height">
            <%@include file="menu.jsp" %>
            <div id="page-wrap">
                <div class="content">
                    <div class="wrapper">
                        <div class="left-sidebar">
                            <div class="top-part">
                                <h1>Video archive</h1>
                                <div class="search-form">
                                    <form action="" method="post">
                                        <input type="text" placeholder="Search" />
                                        <button type="submit">Search</button>
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
                                                <a href="${pth}./video?8=${vccc.id}${params}">
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
                                            <a href="${pth}./video?5=${loopStatus.index}${params}">
                                                ${totS}
                                            </a>
                                        </li>   
                                </c:forEach>        
                                        
                                    </ul>
                                </div>
                                
                                
                                
                                
                                
                                
                                
                                
                                <div id="tab-4" class="filter-content">
                                    <ul>
                                                    <li><a href="${pth}./video?6=1${params}">Less than 5 min</a></li>
                                                    <li><a href="${pth}./video?6=2${params}">5 min to 15 min</a></li>
                                                    <li><a href="${pth}./video?6=3${params}">15 min to 30 min</a></li>
                                                    <li><a href="${pth}./video?6=4${params}">More than 30 min</a></li>
                                    </ul>
                                </div>	
                                
                                
                                
                                
                                <div id="tab-6" class="filter-content">
                                    <ul>
                                       <c:forEach items="${member}" var="mHouse">
                                          <li>
                                            <a href="${pth}./video?7=${mHouse.id}${params}">
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
                                                <a href="${pth}./video?2=1${paramsWithoutSort}" class="a-z">A-Z</a>
                                                <a href="${pth}./video?2=2${paramsWithoutSort}" class="z-a">Z-A</a>
                                            </div>
                                        </li>

                                        <li>
                                            <a href="${pth}./video?2=3${paramsWithoutSort}">Wish List</a>
                                        </li>

                                        <li>
                                            <a href="${pth}./video?2=4${paramsWithoutSort}">View</a>
                                        </li>

                                        <li>
                                            <a href="javascript:;">Popularity</a>
                                            <div class="option-block popularity">
                                                <a href="${pth}./video?2=6${paramsWithoutSort}" class="high-popularity">Most popular</a>
                                                <a href="${pth}./video?2=5${paramsWithoutSort}" class="low-popularity">Least popular</a>
                                            </div>
                                        </li>

                                        <li>
                                            <a href="javascript:;">Date</a>
                                            <div class="option-block popularity">
                                                <a href="${pth}./video?2=8${paramsWithoutSort}" class="newest">Newest first</a>
                                                <a href="${pth}./video?2=7${paramsWithoutSort}" class="oldest">Oldest first</a>
                                            </div>
                                        </li>






                                        <li>
                                            <a href="javascript:;">Duration</a>
                                            <div class="option-block duration">
                                                <ul>
                                                    <li><a href="${pth}./video?2=12${paramsWithoutSort}">Longest first</a></li>
                                                    <li><a href="${pth}./video?2=11${paramsWithoutSort}">shortest first</a></li>
                                                   
                                                </ul>
                                            </div>
                                        </li>
                                        
                                        
                                        
                                        <li>
										<a href="${pth}./video?2=0${paramsWithoutSort}">RESET SORT</a>
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
									<a href="www.custom-design.org">
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
        <script type="text/javascript" src="${location}/assets/scripts/libs/masonry.pkgd.min.js"></script>
        <script type="text/javascript" src="${location}/assets/scripts/libs/datepicker.min.js"></script>
        <script type="text/javascript" src="${location}/assets/scripts/main/default.js"></script>

        <!--[if lt IE 7]>
           <p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
       <![endif]-->
        
        
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
