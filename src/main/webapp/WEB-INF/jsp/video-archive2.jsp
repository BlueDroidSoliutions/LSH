
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
										blonde
									</span>
										<span class="filter-tag">
										<span class="remove-filter">Remove</span>
										blonde
									</span>
										<span class="filter-tag">
										<span class="remove-filter">Remove</span>
										example
									</span>
										<span class="filter-tag">
										<span class="remove-filter">Remove</span>
										example
									</span>
								</div>
							</div>
						</div>
						<div class="filter-by">
							<ul>
								<li class="active">
									<a href="javascript:;">Category</a>
								</li>
								<li>
									<a href="javascript:;">Participant</a>
								</li>
								<li>
									<a href="javascript:;">Duration</a>
								</li>
								<li>
									<a href="javascript:;">Season</a>
								</li>
								<li>
									<a href="javascript:;">Date edited</a>
								</li>
							</ul>
						</div>
						<div class="category-list">   
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
					</div>
					<div class="main-content">
						<div class="video-sort">
							<span class="title">Sort by:</span>
							<div class="sort-options">
								<ul>
                                                                    
                                                                    
                                                                    <li>
										<a href="javascript:;">Name<></a>
									</li>
                                                                    
                                                                    
									<li>
										<a href="javascript:;">Wish List></a>
									</li>
                                                                        
                                                                        <li>
										<a href="javascript:;">Views></a>
									</li>
                                                                        
                                                                         <li>
										<a href="javascript:;">Like<></a>
									</li>
                                                                        
                                                                        
                                                                        
									<li>
										<a href="javascript:;">Date</a>
									</li>
                                                                        
                                                                        <li>
                                                                            
										<a href="javascript:;">Season<></a>
									</li>
                                                                        
                                                                        
                                                                        
									<li>
										<a href="javascript:;">Duration<></a>
									</li>
                                                                        
                                                                        
                                                                        <li>
										<a href="${pth}./videos?2=0&&3=${dateFilter}&&4=${roomFilter}&&5=${seasonFilter}&&6=${durationFilter}&&7=${memberFilter}&&8=${categoryFilter}">RESET SORT<></a>
									</li>
                                                                        
                                                                     
                                                                        
                                                                        
                                                                        
									<li>
										<span class="collapse-sort">
                                                                                    Collapse
                                                                                </span>
									</li>
								</ul>
							</div>
						</div>
                                            
                                            
                                            
                                                                                       
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
                                            
                                            
                                            
                                            
                                            
						<div class="video-list">
							<ul class="clearfix">
                                                            
                                                            
                                                           


                                                 

                                             
                                                            
                                                            
                                                            
                                                            
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
	<script type="text/javascript" src="${location}/assets/scripts/main/default.js"></script>

 <!--[if lt IE 7]>
    <p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
<![endif]-->

</body>
</html>
