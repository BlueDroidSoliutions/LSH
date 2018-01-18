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
					<!-- Form block -->
					<div class="center-content">
						<div class="form-block participate-form">
							<div class="txt-holder">
								<h2 class="u-title">Status</h2>
								 <p>Some fields are empty, please fill all fields.</p>
							</div>
							<div class="form-holder">
                                                            
                                                           
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
	<script type="text/javascript">window.jQuery || document.write("<script src='${location}/assets/scripts/main/jquery-1.8.3.min.js'>\x3C/script>")</script>
	<script type="text/javascript" src="${location}/assets/scripts/libs/jquery.selectric.js"></script>
	<script type="text/javascript" src="${location}/assets/scripts/libs/jcf.js"></script>
	<script type="text/javascript" src="${location}/assets/scripts/libs/jcf.checkbox.js"></script>
	<script type="text/javascript" src="${location}/assets/scripts/libs/jcf.file.js"></script>
	<script type="text/javascript" src="${location}/assets/scripts/main/default.js"></script>

 <!--[if lt IE 7]>
    <p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
<![endif]-->

</body>
</html>
