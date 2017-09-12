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
			<div class="content" style="padding-bottom: 50px;">
                            <div class="wrapper" style="color:white;" id="ttt">
                                    
                                <style>
                                    h3{padding-top: 30px; padding-bottom: 5px;}
                                    #ttt p {padding-top: 20px;}
                                </style>
                                    
                                <h1 style="font-size:50px; text-align: center;">2257</h1>
                                <p>
                                   In compliance with U.S.C. Title 18, Sections 2257 and 2257A and related regulations, all performers, models, actors, actresses and other persons who appear in any visual depiction of actual or simulated sexually explicit conduct appearing on or otherwise contained on this website are or were 18 years of age or older at the time of the creation of such depictions. Records required to be maintained pursuant to U.S.C. Title 18, Sections 2257 and 2257A are located at and maintained by:
</p>
<p>
Costudian of records:
</p>
<p>
Brogårdsgatan 17
</br>
57432 Vetlanda
</br>
Swerige
</br>
Sweeden                 
</p>                                                    
                                                        
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
