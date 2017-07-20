<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
124 152

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



                                        <span class="filter-tag">
                                            <span class="remove-filter">Remove</span>
                                            <span class="value">blonde</span>
                                        </span>

                                        <span class="filter-tag">
                                            <span class="remove-filter">Remove</span>
                                            <span class="value">blonde</span>
                                        </span>

                                        <span class="filter-tag">
                                            <span class="remove-filter">Remove</span>
                                            <span class="value">example</span>
                                        </span>

                                        <span class="filter-tag">
                                            <span class="remove-filter">Remove</span>
                                            <span class="value">example</span>
                                        </span>



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
                                                <a href="${pth}./videos?8=${vccc.id}">
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
                                            <a href="javascript:;">
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
                                            <a href="javascript:;">
                                                ${totS}
                                            </a>
                                        </li>   
                                </c:forEach>        
                                        
                                    </ul>
                                </div>
                                
                                
                                
                                
                                
                                
                                
                                
                                <div id="tab-4" class="filter-content">
                                    <ul>
                                                    <li><a href="javascript:;">Less than 5min</a></li>
                                                    <li><a href="javascript:;">5min to 15min</a></li>
                                                    <li><a href="javascript:;">15min to 30min</a></li>
                                                    <li><a href="javascript:;">More than 30min</a></li>
                                    </ul>
                                </div>	
                                
                                
                                
                                
                                <div id="tab-6" class="filter-content">
                                    <ul>
                                       <c:forEach items="${memberHouse}" var="vRoom">
                                          <li>
                                            <a href="javascript:;">
                                                ${memberHouse.name}
                                            </a>
                                        </li>
                                        </c:forEach>
                                    </ul>
                                </div>	
                                
                                
                                
                                
                                
                                <div id="tab-5" class="filter-content">
                                    <div class="picker-wrapper">
                                        <div data-toggle="datepicker" class="pickedDate"></div>
                                    </div>
                                    <div class="btn-wrap">
                                        <a href="javascript:;" class="btn-small">Choose date</a>
                                    </div>
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
                                                <a href="javascript:;" class="a-z">A-Z</a>
                                                <a href="javascript:;" class="z-a">Z-A</a>
                                            </div>
                                        </li>

                                        <li>
                                            <a href="javascript:;">Wish List</a>
                                        </li>

                                        <li>
                                            <a href="javascript:;">View</a>
                                        </li>

                                        <li>
                                            <a href="javascript:;">Popularity</a>
                                            <div class="option-block popularity">
                                                <a href="javascript:;" class="high-popularity">Most popular</a>
                                                <a href="javascript:;" class="low-popularity">Least popular</a>
                                            </div>
                                        </li>

                                        <li>
                                            <a href="javascript:;">Date</a>
                                            <div class="option-block popularity">
                                                <a href="javascript:;" class="newest">Newest first</a>
                                                <a href="javascript:;" class="oldest">Oldest first</a>
                                            </div>
                                        </li>

                                        <li>
                                            <a href="javascript:;">Season</a>
                                            <div class="option-block popularity">



                                                <a href="javascript:;" class="newest">Newest first</a>
                                                <a href="javascript:;" class="oldest">Oldest first</a>



                                            </div>
                                        </li>




                                        <li>
                                            <a href="javascript:;">Duration</a>
                                            <div class="option-block duration">
                                                <ul>
                                                    <li><a href="javascript:;">Less than 5min</a></li>
                                                    <li><a href="javascript:;">5min to 15min</a></li>
                                                    <li><a href="javascript:;">15min to 30min</a></li>
                                                    <li><a href="javascript:;">More than 30min</a></li>
                                                </ul>
                                            </div>
                                        </li>
                                        
                                        
                                        
                                        <li>
										<a href="${pth}./videos?2=0&&3=${dateFilter}&&4=${roomFilter}&&5=${seasonFilter}&&6=${durationFilter}&&7=${memberFilter}&&8=${categoryFilter}">RESET SORT<></a>
									</li>
                                        
                                        
                                        
                                        <li>
                                            <span class="collapse-sort">Collapse</span>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                            <div class="video-list">
                                <ul class="clearfix">
                                    
                                    
                                    
                                    
                                    
                                    
                                    <li class="video-item">
                                        <a href="javascript:;">
                                            <div class="thumbnail">
                                                <img src="assets/img/content/01.jpg" class="rollme" alt=""/>
                                                <img src="assets/img/content/02.jpg" class="rollme" alt="" />
                                                <img src="assets/img/content/03.jpg" class="rollme" alt="" />
                                                <img src="assets/img/content/04.jpg" class="rollme" alt="" />
                                            </div>
                                            <div class="video-info">
                                                <div class="description">
                                                    <h5>Name name name</h5>
                                                    <span class="views">34.450 views</span>
                                                </div>
                                                <span class="access-link">Access</span>
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
                                        </a>
                                    </li>
                                   
                                    
                                    
                                    
                                     <c:forEach items="${video}" var="video">
								<li class="video-item">
									<a href="javascript:;">
										<div class="thumbnail">
                                                                                    
                         <c:forEach begin="1" end="5" var="cfe" varStatus="loopStatus">
                                                                                        
                               
                               <img src="./ext/slike/${video.id}_${cfe}.jpg" class="rollme" alt=""/>                                                         
                                                                                        
                         </c:forEach>
                                                                                    
											
                                                                                        
										</div>
										<div class="video-info">
											<div class="description">
												<h5>${video.name}</h5>
												<span class="views">${video.viewCount}</span>
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
                                    <img src="assets/img/o4.jpg" alt="" />
                                </a>
                                <a href="javascript:;">
                                    <img src="assets/img/o4.jpg" alt="" />
                                </a>
                            </div>
                        </div>
                        <div class="pagination">
                            <ul>
                                <li class="prev">
                                    <a href="javascript:;">Previous</a>
                                </li>
                                <li>
                                    <a href="javascript:;">1</a>
                                </li>
                                <li class="active">
                                    <a href="javascript:;">2</a>
                                </li>
                                <li>
                                    <a href="javascript:;">3</a>
                                </li>
                                <li>
                                    <a href="javascript:;">4</a>
                                </li>
                                <li>
                                    <a href="javascript:;">5</a>
                                </li>
                                <li class="next">
                                    <a href="javascript:;">Next</a>
                                </li>
                            </ul>
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
        <script type="text/javascript">window.jQuery || document.write("<script src='assets/scripts/main/jquery-1.8.3.min.js'>\x3C/script>")</script>
        <script type="text/javascript" src="assets/scripts/libs/masonry.pkgd.min.js"></script>
        <script type="text/javascript" src="assets/scripts/libs/datepicker.min.js"></script>
        <script type="text/javascript" src="assets/scripts/main/default.js"></script>

        <!--[if lt IE 7]>
           <p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
       <![endif]-->

    </body>
</html>
