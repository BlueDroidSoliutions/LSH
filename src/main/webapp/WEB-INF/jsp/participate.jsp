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
								<h2 class="u-title">Become a participant</h2>
								<p>
									Becoming a paricipant in the Live sex house. If youu click on “ I agree with term and conditions” button. Becoming a paricipant in the Live sex house. If youu click on “ I agree with term and conditions” button. Becoming a paricipant in the Live sex house. If youu click on “ I agree with term and conditions” button. <a href="javascript:;">Suport contact</a>
								</p>
							</div>
							<div class="form-holder">
                                                            
                                                            
<form method="POST" role="form" action="${pageContext.request.contextPath}/uploadMulti" enctype="multipart/form-data">

 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
 
 
                                                            
                                                            
                                                            
								<div class="clearfix">
									<div class="one-third clearfix">
										<div class="field-wrapper">
											<span class="field-label">Your full name</span>
											<input name="name" id="fullName" type="text">
										</div>
										<div class="field-wrapper required-holder">
											<span class="field-label">Email address</span>
											<input id="emailAddress" type="email">
											<span class="required-f  r-email">Required<br>field</span>
										</div>
										<div class="field-wrapper">
											<span class="field-label">Upload your photo</span>
											<input id="name" type="file">
										</div>
									</div>
									<div class="one-third clearfix">
										<div class="field-wrapper">
											<span class="field-label">Date of birth</span>
											<input id="subject" type="date">
										</div>
										<div class="field-wrapper">
											<span class="field-label">State of residence</span>
											<input id="state" type="text">
										</div>
										<div class="field-wrapper">
											<span class="field-label">City of residence</span>
											<input id="city" type="text">
										</div>
									</div>
									<div class="one-third textarea-holder clearfix">
										<div class="field-wrapper">
											<span class="field-label">Message*</span>
											<textarea name="message-text" placeholder="Why would you like to become a LiveSeHouse participant?" id="textarea" ></textarea>
											<p id="textarea_feedback"></p>
											<label class="chack required-holder"><input type="checkbox" name="checkbox" value="value">I am not a robot</label>
										</div>
									</div>
								</div>
								<div class="bottom-form">
									<label class="chack required-holder"><input type="checkbox" name="checkboxAccept" value="value">I accept <a href="javascript:;">terms and conditions</a><span class="required-f r-terms">Required<br>field</span></label>
									<input type="submit" value="Submit" class="btn-submit">
								</div>	
 
 </form>
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
