<%-- 
    Document   : uploadStatus
    Created on : Jun 15, 2017, 9:26:46 PM
    Author     : roller
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>


<html>
<body>
<h1>UPLOAD STATUS</h1>
<div style="background-color: green; color: white;"> ${message} </div>


<style>
    .red{
        background-color: red;
        color: white;
    }
</style>





<div class="red">
${messageFailSaveHdd}
${messageFailGrab}
${messageFailSaveDB}
${messageFailSaveNameDB}
${messageFailM2mDB}
${messageFailM2mInDB}
${failSaveRenameMsg}
</div>






</body>
</html>