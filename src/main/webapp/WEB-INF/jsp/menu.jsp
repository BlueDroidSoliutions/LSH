<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header class="header">
			<div class="wrapper">
				<a href="${path}./" id="logo">
					<img src="${location}/assets/img/content/LSH-logo.png" alt="Live Sex House logo" />
				</a>
				<a href="javascript:;" id="menu-btn">
					<span></span>
					<span></span>
					<span></span>
					<span></span>
				</a>
				<ul id="main-nav">
					<li><a href="javascript:;">Live streams</a></li>
					<li><a href="${path}./video">Video archive</a></li>
					<li><a href="javascript:;">Tokens</a></li>
					<li>
						<a href="javascript:;">Web cam</a>
						<a href="javascript:;" class="submenu-btn">
							<svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" version="1.1" viewBox="0 0 129 129" enable-background="new 0 0 129 129">
							  <g>
							    <path d="m121.3,34.6c-1.6-1.6-4.2-1.6-5.8,0l-51,51.1-51.1-51.1c-1.6-1.6-4.2-1.6-5.8,0-1.6,1.6-1.6,4.2 0,5.8l53.9,53.9c0.8,0.8 1.8,1.2 2.9,1.2 1,0 2.1-0.4 2.9-1.2l53.9-53.9c1.7-1.6 1.7-4.2 0.1-5.8z" fill="#FFFFFF"/>
							  </g>
							</svg>
						</a>
						<ul>
							<li><a href="javascript:;">Subitem</a></li>
							<li><a href="javascript:;">Subitem</a></li>
							<li><a href="javascript:;">Subitem</a></li>
							<li><a href="javascript:;">Subitem</a></li>
						</ul>
					</li>
					<li><a href="${path}./vote">Vote</a></li>
					<li><a href="${path}./contact">Contact</a></li>
                                       
                                        
                                        <c:choose>
                                             <c:when test="${not empty userName}">
                                                 <li><a href="${path}./logout">${userName} Logout</a></li>
                                             </c:when>
                                             <c:otherwise>
                                                 <li><a href="javascript:;" id="login-btn">Login/Join</a></li>
                                             </c:otherwise>
                                        </c:choose>
<!--                                        <li><a href="${path}./uploadMultiPage">um</a></li>-->
                                       
					
				</ul>
			</div>
		</header>