<%-- 
    Document   : sign
    Created on : Jul 24, 2017, 11:56:10 AM
    Author     : roller
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="main-popup">
		<div class="popup-wrapper">
			<div class="inner" id="sign-up">
				<a href="javascript:;" class="close-me"></a>
				<div class="inner-wrapper">
					
					<h2>Sign up</h2>
					<p>Already have an account? <a href="javascript:;" id="showSignIn">Sign in here</a></p>
					
                                        
                                        
                                        <script>
       function onSubmit(token) {
         document.getElementById("signup").submit();
       }
     </script>
                                         <form id="signup" method="POST" action="${pageContext.request.contextPath}/signup" name="forma" accept-charset="UTF-8">
     <input type="hidden"
name="${_csrf.parameterName}"
value="${_csrf.token}"/>
                                        <input id="subject" type="text" name="subject">
                                        
                                        <form action="" method="post">
					    <div>
					        <input type="text" id="name" name="username" placeholder="username">
					    </div>
					    <div>
					        <input type="password" id="password" name="password" placeholder="password">
					    </div>
					    <div>
					        <input type="email" id="mail" name="email" placeholder="email">
					    </div>
					   <label class="chack required-holder"><input type="checkbox" name="checkboxAccept" value="value">I am over 18. I accept <a href="javascript:;">terms and conditions</a></label>
					   <a href="javascript" class="support">Support contact</a>
                                           <input type="submit" value="Send" class="btn">
<!--					    <button type="submit" class="btn">Submit</button>-->
					</form>
                                        
                                        
                                        
                                        
                                        
                                        
                                        
                                        
                                        
				</div>
			</div>
			<div class="inner" id="sign-in">
				<a href="javascript:;" class="close-me"></a>
				<div class="inner-wrapper">
					<h2>Sign in</h2>
                                        
                                        
                                        
                                        
                                        
                                        
                                        
					<form name='loginForm' action="<c:url value='./login' />" method='POST'>
					    <div>
					        <input type="text" id="name" name="username" placeholder="username">
					    </div>
					    <div>
					        <input type="password" id="password" name="password" placeholder="password">
					    </div>
					    <button  name="submit" type="submit"  value="submit" class="btn">SIGN IN</button>
                                            
                                             <input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
					</form>
                                        
                                        
                                        
                                        
                                        
                                        
                                        
                                        
				</div>
			</div>
		</div>
	</div>