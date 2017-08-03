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
                        <div class="sticky-wrap">
                            <div class="wrapper clearfix">
                                <div class="filters-wrap">
                                    <span class="filters-toggle">Filter</span>
                                    <div class="filters">
                                        <ul>
                                            <li class="filter">
                                                <a href="javascript:;">New model</a>
                                            </li>
                                            <li class="filter">
                                                <a href="javascript:;">Brunete</a>
                                            </li>
                                            <li class="filter">
                                                <a href="javascript:;">Mature</a>
                                            </li>
                                            <li class="filter">
                                                <a href="javascript:;">Blonde</a>
                                            </li>
                                            <li class="filter">
                                                <a href="javascript:;">Petit</a>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="online-models">
                                    <span>Models online:</span>
                                    <strong>258</strong>
                                </div>
                                <div class="search-form">
                                    <form action="" method="post">
                                        <input type="text" placeholder="Search" />
                                        <button type="submit">Search</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <div class="webcam-videos">
                            <ul class="clearfix">
                                <li class="webcam-video">
                                    <a href="javascript:;">
                                        <div class="thumbnail">
                                            <img src="${location}/assets/img/content/model-image.jpg" alt="" />
                                        </div>
                                        <div class="webcam-info">
                                            <h4>Name Name</h4>
                                            <span class="status">in private chat</span>
                                        </div>
                                    </a>
                                </li>
                                <li class="webcam-video">
                                    <a href="javascript:;">
                                        <div class="thumbnail">
                                            <img src="${location}/assets/img/content/model-image.jpg" alt="" />
                                        </div>
                                        <div class="webcam-info">
                                            <h4>Name Name</h4>
                                            <span class="status">in private chat</span>
                                        </div>
                                    </a>
                                </li>
                                <li class="webcam-video">
                                    <a href="javascript:;">
                                        <div class="thumbnail">
                                            <img src="${location}/assets/img/content/model-image.jpg" alt="" />
                                        </div>
                                        <div class="webcam-info">
                                            <h4>Name Name</h4>
                                            <span class="status">in private chat</span>
                                        </div>
                                    </a>
                                </li>
                                <li class="webcam-video">
                                    <a href="javascript:;">
                                        <div class="thumbnail">
                                            <img src="${location}/assets/img/content/model-image.jpg" alt="" />
                                        </div>
                                        <div class="webcam-info">
                                            <h4>Name Name</h4>
                                            <span class="status">in private chat</span>
                                        </div>
                                    </a>
                                </li>
                                <li class="webcam-video large-video">
                                    <a href="javascript:;">
                                        <div class="thumbnail">
                                            <img src="${location}/assets/img/content/model-image.jpg" alt="" />
                                        </div>
                                        <div class="webcam-info">
                                            <h4>Name Name</h4>
                                            <span class="status">in private chat</span>
                                        </div>
                                    </a>
                                </li>
                                <li class="webcam-video">
                                    <a href="javascript:;">
                                        <div class="thumbnail">
                                            <img src="${location}/assets/img/content/model-image.jpg" alt="" />
                                        </div>
                                        <div class="webcam-info">
                                            <h4>Name Name</h4>
                                            <span class="status">in private chat</span>
                                        </div>
                                    </a>
                                </li>
                                <li class="webcam-video">
                                    <a href="javascript:;">
                                        <div class="thumbnail">
                                            <img src="${location}/assets/img/content/model-image.jpg" alt="" />
                                        </div>
                                        <div class="webcam-info">
                                            <h4>Name Name</h4>
                                            <span class="status">in private chat</span>
                                        </div>
                                    </a>
                                </li>
                                <li class="webcam-video">
                                    <a href="javascript:;">
                                        <div class="thumbnail">
                                            <img src="${location}/assets/img/content/model-image.jpg" alt="" />
                                        </div>
                                        <div class="webcam-info">
                                            <h4>Name Name</h4>
                                            <span class="status">in private chat</span>
                                        </div>
                                    </a>
                                </li>
                                <li class="webcam-video">
                                    <a href="javascript:;">
                                        <div class="thumbnail">
                                            <img src="${location}/assets/img/content/model-image.jpg" alt="" />
                                        </div>
                                        <div class="webcam-info">
                                            <h4>Name Name</h4>
                                            <span class="status">in private chat</span>
                                        </div>
                                    </a>
                                </li>
                                <li class="webcam-video">
                                    <a href="javascript:;">
                                        <div class="thumbnail">
                                            <img src="${location}/assets/img/content/model-image.jpg" alt="" />
                                        </div>
                                        <div class="webcam-info">
                                            <h4>Name Name</h4>
                                            <span class="status">in private chat</span>
                                        </div>
                                    </a>
                                </li>
                                <li class="webcam-video">
                                    <a href="javascript:;">
                                        <div class="thumbnail">
                                            <img src="${location}/assets/img/content/model-image.jpg" alt="" />
                                        </div>
                                        <div class="webcam-info">
                                            <h4>Name Name</h4>
                                            <span class="status">in private chat</span>
                                        </div>
                                    </a>
                                </li>
                                <li class="webcam-video">
                                    <a href="javascript:;">
                                        <div class="thumbnail">
                                            <img src="${location}/assets/img/content/model-image.jpg" alt="" />
                                        </div>
                                        <div class="webcam-info">
                                            <h4>Name Name</h4>
                                            <span class="status">in private chat</span>
                                        </div>
                                    </a>
                                </li>
                                <li class="webcam-video">
                                    <a href="javascript:;">
                                        <div class="thumbnail">
                                            <img src="${location}/assets/img/content/model-image.jpg" alt="" />
                                        </div>
                                        <div class="webcam-info">
                                            <h4>Name Name</h4>
                                            <span class="status">in private chat</span>
                                        </div>
                                    </a>
                                </li>
                                <li class="webcam-video">
                                    <a href="javascript:;">
                                        <div class="thumbnail">
                                            <img src="${location}/assets/img/content/model-image.jpg" alt="" />
                                        </div>
                                        <div class="webcam-info">
                                            <h4>Name Name</h4>
                                            <span class="status">in private chat</span>
                                        </div>
                                    </a>
                                </li>
                                <li class="webcam-video large-video">
                                    <a href="javascript:;">
                                        <div class="thumbnail">
                                            <img src="${location}/assets/img/content/model-image.jpg" alt="" />
                                        </div>
                                        <div class="webcam-info">
                                            <h4>Name Name</h4>
                                            <span class="status">in private chat</span>
                                        </div>
                                    </a>
                                </li>
                                <li class="webcam-video">
                                    <a href="javascript:;">
                                        <div class="thumbnail">
                                            <img src="${location}/assets/img/content/model-image.jpg" alt="" />
                                        </div>
                                        <div class="webcam-info">
                                            <h4>Name Name</h4>
                                            <span class="status">in private chat</span>
                                        </div>
                                    </a>
                                </li>
                                <li class="webcam-video">
                                    <a href="javascript:;">
                                        <div class="thumbnail">
                                            <img src="${location}/assets/img/content/model-image.jpg" alt="" />
                                        </div>
                                        <div class="webcam-info">
                                            <h4>Name Name</h4>
                                            <span class="status">in private chat</span>
                                        </div>
                                    </a>
                                </li>
                                <li class="webcam-video">
                                    <a href="javascript:;">
                                        <div class="thumbnail">
                                            <img src="${location}/assets/img/content/model-image.jpg" alt="" />
                                        </div>
                                        <div class="webcam-info">
                                            <h4>Name Name</h4>
                                            <span class="status">in private chat</span>
                                        </div>
                                    </a>
                                </li>
                                <li class="webcam-video">
                                    <a href="javascript:;">
                                        <div class="thumbnail">
                                            <img src="${location}/assets/img/content/model-image.jpg" alt="" />
                                        </div>
                                        <div class="webcam-info">
                                            <h4>Name Name</h4>
                                            <span class="status">in private chat</span>
                                        </div>
                                    </a>
                                </li>
                                <li class="webcam-video">
                                    <a href="javascript:;">
                                        <div class="thumbnail">
                                            <img src="${location}/assets/img/content/model-image.jpg" alt="" />
                                        </div>
                                        <div class="webcam-info">
                                            <h4>Name Name</h4>
                                            <span class="status">in private chat</span>
                                        </div>
                                    </a>
                                </li>
                                <li class="webcam-video">
                                    <a href="javascript:;">
                                        <div class="thumbnail">
                                            <img src="${location}/assets/img/content/model-image.jpg" alt="" />
                                        </div>
                                        <div class="webcam-info">
                                            <h4>Name Name</h4>
                                            <span class="status">in private chat</span>
                                        </div>
                                    </a>
                                </li>
                                <li class="webcam-video">
                                    <a href="javascript:;">
                                        <div class="thumbnail">
                                            <img src="${location}/assets/img/content/model-image.jpg" alt="" />
                                        </div>
                                        <div class="webcam-info">
                                            <h4>Name Name</h4>
                                            <span class="status">in private chat</span>
                                        </div>
                                    </a>
                                </li>
                            </ul>
                        </div>
                        <div class="pagination">
                            <ul>
                                <li class="prev">
                                    <a href="javascript:;">Previous</a>
                                </li>
                                <li>
                                    <a href="javascript:;">1</a>
                                </li>
                                <li class="active">
                                    <a href="javascript:;">2</a>
                                </li>
                                <li>
                                    <a href="javascript:;">3</a>
                                </li>
                                <li>
                                    <a href="javascript:;">4</a>
                                </li>
                                <li>
                                    <a href="javascript:;">5</a>
                                </li>
                                <li class="next">
                                    <a href="javascript:;">Next</a>
                                </li>
                            </ul>
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

      <%@include file="jsScript.jsp" %>

    </body>
</html>
