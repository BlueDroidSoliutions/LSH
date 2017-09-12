<%-- 
    Document   : changepass
    Created on : Aug 18, 2017, 3:45:43 PM
    Author     : roller
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        
        
         <form id="signup" method="post" action="${pageContext.request.contextPath}${path}/signup" name="forma" accept-charset="UTF-8">

                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                    <input id="subject" type="text" name="subject">


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
        
        
    </body>
</html>
