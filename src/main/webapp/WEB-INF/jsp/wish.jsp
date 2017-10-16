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

    <div id="page-wrap" class="page-wish">
        <div class="wish-container clearfix">
            <div class="box-left">
                <div class="form-holder clearfix">
                    <h2 class="u-title">Your wish</h2>


                    <c:choose>
                        <c:when test="${not empty userName}">
                            <p>
                                Below is your wish form. You can choose any type of scenario, and every couple as well as any room in the house. Live Sex House administrators will rewiev Your idea and let You know if it is been accepted. If Your Idea reaches trending on our video archive, you will be <strong>rewarded by 1000$!</strong>
                            </p>
                            <form id="formWish" method="POST" action="${pageContext.request.contextPath}/formWish" name="forma" accept-charset="UTF-8">
     <input type="hidden"
name="${_csrf.parameterName}"
value="${_csrf.token}"/>
                                <div class="clearfix">
                                    <div class="form-half">
                                        <span class="field-label">Participant 1</span>
                                        <select name="participant1">
                                            <c:forEach items="${participant}" var="participant">
                                                <option value="${participant.name}" >${participant.name}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="form-half">
                                        <span class="field-label">Participant 2</span>
                                        <select name="participant2">
                                            <c:forEach items="${participant}" var="participant">
                                                <option value="${participant.name}">${participant.name}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-full">
                                    <span class="field-label">Choose action/activity</span>
                                    <select name="action">
                                        <c:forEach items="${action}" var="action">
                                            <option value="${action.action}">${action.action}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="clearfix">
                                    <div class="form-half">
                                        <span class="field-label">Extra</span>
                                        <select name="extra">
                                            <c:forEach items="${extra}" var="extra">
                                                <option value="${extra.extra}">${extra.extra}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="form-half">
                                        <span class="field-label">Location</span>
                                        <select name="location">
                                            <c:forEach items="${videoRoom}" var="videoRoom">
                                                <option value="${videoRoom.name}">${videoRoom.name}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <input type="submit" value="Submit" class="btn-submit" placeholder="Submit">
                            </form>
                        </c:when>
                        <c:otherwise>
                            <p>You must be loged in</p>

                        </c:otherwise>
                    </c:choose>









                </div>
            </div>
            <div class="box-right">
                <div class="box-right-box"></div>
                <div class="box-right-box"></div>
            </div>
        </div>
    </div>

    <%@include file="footer.jsp" %>

</div>

</div>

<!-- javascript -->
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script type="text/javascript">window.jQuery || document.write("<script src='./resources/assets/scripts/main/jquery-1.8.3.min.js'>\x3C/script>");</script>
<script type="text/javascript" src="./resources/assets/scripts/libs/jquery.selectric.js"></script>
<script type="text/javascript" src="./resources/assets/scripts/main/default.js"></script>

<!--[if lt IE 7]>
   <p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
<![endif]-->
</body>
</html>
