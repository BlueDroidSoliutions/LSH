<%-- 
    Document   : uploadStatus
    Created on : Jun 15, 2017, 9:26:46 PM
    Author     : roller
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>




<form method="POST" role="form" action="${pageContext.request.contextPath}/uploadMulti" enctype="multipart/form-data">

 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
 
    <style>
        .white{background-color: white;}
        .gray{background-color: graytext;}
    </style>
    
    <c:forEach begin="0" end="9" var="cfe" varStatus="loopStatus">
    
    
    <div class="${loopStatus.index % 2 == 0 ? 'white' : 'gray'}" style=" padding-bottom: 30px; padding-top: 10px;">
        
        <div style="display: inline-block; padding-left: 10px;">
            <input type="file" name="file" /> <br>
            <input type="text" name="name" placeholder="name"/>
            <input type="text" name="tag" placeholder="tag"/>
        </div>


        <div style="display: inline-block; padding-right: 30px;">
            <p>SEASON</p>
            <select name="season" multiple="true">
                <c:forEach begin="1" end="${totalSeasons}" var="s" >
                    <option value="${s}" style="width:55px;">${s}</option>
                </c:forEach>
            </select>
        </div>

         <div style="display: inline-block; padding-right: 30px;">
            <p>ROOM:</p>  
            <c:forEach items="${videoRoom}" var="vr">
                <input type="checkbox" name="videoRoom${cfe}${vr.id}" value="${vr.id}">${vr.name}</input> <br>
            </c:forEach>
        </div>


        <div style="display: inline-block; padding-right: 30px;">
            <p>CATEGORY</p>  
            <c:forEach items="${videoCategories}" var="vc">
                <input type="checkbox" name="category${cfe}${vc.id}" value="${vc.id}">${vc.name}</input> <br>
            </c:forEach>
        </div>

        
         <div style="display: inline-block; padding-right: 30px;">
            <p>MEMBER HOUSE</p>  
            <c:forEach items="${memberHouse}" var="mh">
                <input type="checkbox" name="memberHouse${cfe}${mh.id}" value="${mh.id}">${mh.name}</input> <br>
            </c:forEach>
        </div>

        
    </div>
    </c:forEach>
    
    
    
    
    
    <div style="background-color: red; padding: 50px;" > <input type="submit" value="Submit" /></div>
</form>