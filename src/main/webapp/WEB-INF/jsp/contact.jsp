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
                                        
            <script src="https://www.google.com/recaptcha/api.js" async defer></script>                             
      <script>
       function onSubmit(token) {
         document.getElementById("formContact").submit();
       }
     </script>
                                        
     
     
     <form id="formContact" method="POST" action="${pageContext.request.contextPath}/contactpost" name="forma" accept-charset="UTF-8">
     <input type="hidden"
name="${_csrf.parameterName}"
value="${_csrf.token}"/>
                                        
					<div class="center-content">
						<div class="form-block">
							<h2 class="u-title">Contact us</h2>
							<div class="left">
								<div class="field-wrapper">
									<span class="field-label">Language</span>
                                                                        <select name="lng">
										<option value="english">English</option>
										<option value="lang2">Language 2</option>
										<option value="lang3">Language 3</option>
										<option value="lang4">Language 4</option>
										<option value="lang5">Language 4</option>
									</select>
                                                                        
                                                                        

                                                                      
                                                                        
								</div>
								<div class="field-wrapper">
									<span class="field-label">User group</span>
                                                                        <select name="user">
										<option value="Guest">Guest</option>
										<option value="Member">Member</option>
										<option value="Potential model">Potential model</option>
										<option value="Potential performer">Potential performer</option>
										<option value="Payment">Payment</option>
										<option value="Other">Other</option>
									</select>
								</div>
								<div class="field-wrapper">
									<span class="field-label">Email address*</span>
									<input id="mail" type="email" name="mail">
                                                                       
								</div>
								<div class="field-wrapper">
									<span class="field-label">Name*</span>
									<input id="name" type="text" name="name">
								</div>
								<p class="legend">*required fields</p>
							</div>
							<div class="right">
								<div class="field-wrapper">
									<span class="field-label">Subject</span>
                                                                        <input id="subject" type="text" name="subject">
								</div>
								
								<div class="field-wrapper">
									<span class="field-label">Message*</span>
									<textarea name="message-text" id="textarea" ></textarea>
									<p id="textarea_feedback"></p>
								</div>
							</div>
							<input type="submit" value="Send" class="btn-submit">
<!--                                                        <button type="submit" class="btn-submit g-recaptcha btn-submit" data-sitekey="6Lc9oCMUAAAAAJoWfarXmBDpH673bGYkGX6XrTWI" data-callback='onSubmit' >Send</button>-->
						</div>
					</div>
     
     
     
     </form>
     
     
     
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
	<script type="text/javascript" src="${location}/assets/scripts/libs/jquery.selectric.js"></script>
	<script type="text/javascript" src="${location}/assets/scripts/main/default.js"></script>

 <!--[if lt IE 7]>
    <p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
<![endif]-->

</body>
</html>
