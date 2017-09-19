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

		<div id="token-section">
			<div class="token-wrapper">
				<div class="inner">
					<a href="javascript:;" id="close-me">
						
					</a>
					<div class="top">
						<h2>Buy tokens</h2>
						<p>choose package for you</p>
					</div>
					<div class="top-list">
						<ul>
							<li>
								<div class="item-inner">
									<h3>Entry</h3>
									<p>100 tokens</p>
									<span>10$</span>
								</div>
								<a href="javascript:;" class="btn">Buy</a>
							</li>
							<li>
								<div class="item-inner">
									<h3>Basic</h3>
									<p>100 tokens</p>
									<span>10$</span>
								</div>
								<a href="javascript:;" class="btn">Buy</a>
							</li>
							<li>
								<div class="item-inner">
									<h3>Fan</h3>
									<p>500 tokens</p>
									<span>48$</span>
								</div>
								<a href="javascript:;" class="btn">Buy</a>
							</li>
							<li>
								<div class="item-inner">
									<h3>Advance</h3>
									<p>500 tokens</p>
									<span>48$</span>
								</div>
								<a href="javascript:;" class="btn">Buy</a>
							</li>
						</ul>
					</div>
					<div class="bottom-list">
						<ul>
							<li class="silver">
								<div class="item-inner">
									<img src="${location}/assets/img/silver.png" alt="" />
									<p>10 tokens</p>
									<span>10$</span>
								</div>
								<a href="javascript:;" class="btn">Buy</a>
							</li>
							<li class="gold">
								<div class="item-inner">
									<img src="${location}/assets/img/gold.png" alt="" />
									<p>50 tokens</p>
									<span>48$</span>
								</div>
								<a href="javascript:;" class="btn">Buy</a>
							</li>
							<li class="premium">
								<div class="item-inner">
									<img src="${location}/assets/img/platinum.png" alt="" />
									<p>100 tokens</p>
									<span>78$</span>
								</div>
								<a href="javascript:;" class="btn">Buy</a>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div id="page-wrap">
			<div class="content">
				<div class="person-details" id="details-block">
					<div id="tab-1" class="tab-content current">
						<div class="tab-wrapper">
							<div class="img-block">
								<img src="${location}/assets/img/content/profile.jpg" alt="">
							</div>

							<div class="description-block">
								<div class="top">
									<h2>
										<span>Helena</span>
										<img src="${location}/assets/img/content/flag-en.png" alt="" />
									</h2>
									<a href="javascript:;" class="btn" id="showTokens">
										<img src="${location}/assets/img/content/token.png" alt="" />
										Buy tokens
									</a>
								</div>
								<div class="description">
									<p>
										Lorem ipsum dolor sit amet, veri libris accommodare an sed, movet dicam dicunt cu sit. Duo eu nisl adhuc dissentiet, nam at invidunt definitionem, ei his ipsum sanctus dolorum. Duo mutat volutpat ex, cu percipitur accommodare est. Sit cu accumsan abhorreant contentiones, commodo veritus imperdiet mel in. Mea te commodo legimus, sit te tale nemore, te eam quas reprimique. Sea integre invenire ei.
									</p>
								</div>
								<div class="bottom">
									<ul>
										<li>
											<h3>4<sup>TH</sup></h3>
											<span>place</span>
										</li>
										<li>
											<h3>1256</h3>
											<span>votes</span>
										</li>
										<li>
											<a href="javascript:;" class="vote-btn">Vote</a>
										</li>
									</ul>
								</div>
							</div>

							<div class="gallery-block">
								<ul>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
								</ul>
							</div>
						</div>
					</div>
					<div id="tab-2" class="tab-content">
						<div class="tab-wrapper">
							<div class="img-block">
								<img src="${location}/assets/img/content/profile.jpg" alt="">
							</div>

							<div class="description-block">
								<div class="top">
									<h2>
										<span>Helena</span>
										<img src="${location}/assets/img/content/flag-en.png" alt="" />
									</h2>
									<a href="javascript:;" class="btn">
										<img src="${location}/assets/img/content/token.png" alt="" />
										Buy tokens
									</a>
								</div>
								<div class="description">
									<p>
										Lorem ipsum dolor sit amet, veri libris accommodare an sed, movet dicam dicunt cu sit. Duo eu nisl adhuc dissentiet, nam at invidunt definitionem, ei his ipsum sanctus dolorum. Duo mutat volutpat ex, cu percipitur accommodare est. Sit cu accumsan abhorreant contentiones, commodo veritus imperdiet mel in. Mea te commodo legimus, sit te tale nemore, te eam quas reprimique it te tale nemore, te eam quas reprimique. Sea integre invenire ei.
									</p>
								</div>
								<div class="bottom">
									<ul>
										<li>
											<h3>4</h3>
											<span>place</span>
										</li>
										<li>
											<h3>1256</h3>
											<span>votes</span>
										</li>
										<li>
											<a href="javascript:;" class="vote-btn">Vote</a>
										</li>
									</ul>
								</div>
							</div>

							<div class="gallery-block">
								<ul>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
								</ul>
							</div>
						</div>
					</div>
					<div id="tab-3" class="tab-content">
						<div class="tab-wrapper">
							<div class="img-block">
								<img src="${location}/assets/img/content/profile.jpg" alt="">
							</div>

							<div class="description-block">
								<div class="top">
									<h2>
										<span>Helena</span>
										<img src="${location}/assets/img/content/flag-en.png" alt="" />
									</h2>
									<a href="javascript:;" class="btn">
										<img src="${location}/assets/img/content/token.png" alt="" />
										Buy tokens
									</a>
								</div>
								<div class="description">
									<p>
										Lorem ipsum dolor sit amet, veri libris accommodare an sed, movet dicam dicunt cu sit. Duo eu nisl adhuc dissentiet, nam at invidunt definitionem, ei his ipsum sanctus dolorum. Duo mutat volutpat ex, cu percipitur accommodare est. Sit cu accumsan abhorreant contentiones, commodo veritus imperdiet mel in. Mea te commodo legimus, sit te tale nemore, te eam quas reprimique. Sea integre invenire ei.
									</p>
								</div>
								<div class="bottom">
									<ul>
										<li>
											<h3>4</h3>
											<span>place</span>
										</li>
										<li>
											<h3>1256</h3>
											<span>votes</span>
										</li>
										<li>
											<a href="javascript:;" class="vote-btn">Vote</a>
										</li>
									</ul>
								</div>
							</div>

							<div class="gallery-block">
								<ul>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
								</ul>
							</div>
						</div>
					</div>
					<div id="tab-4" class="tab-content">
						<div class="tab-wrapper">
							<div class="img-block">
								<img src="${location}/assets/img/content/profile.jpg" alt="">
							</div>

							<div class="description-block">
								<div class="top">
									<h2>
										<span>Helena</span>
										<img src="${location}/assets/img/content/flag-en.png" alt="" />
									</h2>
									<a href="javascript:;" class="btn">
										<img src="${location}/assets/img/content/token.png" alt="" />
										Buy tokens
									</a>
								</div>
								<div class="description">
									<p>
										Lorem ipsum dolor sit amet, veri libris accommodare an sed, movet dicam dicunt cu sit. Duo eu nisl adhuc dissentiet, nam at invidunt definitionem, ei his ipsum sanctus dolorum. Duo mutat volutpat ex, cu percipitur accommodare est. Sit cu accumsan abhorreant contentiones, commodo veritus imperdiet mel in. Mea te commodo legimus, sit te tale nemore, te eam quas reprimique. Sea integre invenire ei.
									</p>
								</div>
								<div class="bottom">
									<ul>
										<li>
											<h3>4</h3>
											<span>place</span>
										</li>
										<li>
											<h3>1256</h3>
											<span>votes</span>
										</li>
										<li>
											<a href="javascript:;" class="vote-btn">Vote</a>
										</li>
									</ul>
								</div>
							</div>

							<div class="gallery-block">
								<ul>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
								</ul>
							</div>
						</div>
					</div>
					<div id="tab-5" class="tab-content">
						<div class="tab-wrapper">
							<div class="img-block">
								<img src="${location}/assets/img/content/profile.jpg" alt="">
							</div>

							<div class="description-block">
								<div class="top">
									<h2>
										<span>Helena</span>
										<img src="${location}/assets/img/content/flag-en.png" alt="" />
									</h2>
									<a href="javascript:;" class="btn">
										<img src="${location}/assets/img/content/token.png" alt="" />
										Buy tokens
									</a>
								</div>
								<div class="description">
									<p>
										Lorem ipsum dolor sit amet, veri libris accommodare an sed, movet dicam dicunt cu sit. Duo eu nisl adhuc dissentiet, nam at invidunt definitionem, ei his ipsum sanctus dolorum. Duo mutat volutpat ex, cu percipitur accommodare est. Sit cu accumsan abhorreant contentiones, commodo veritus imperdiet mel in. Mea te commodo legimus, sit te tale nemore, te eam quas reprimique. Sea integre invenire ei.
									</p>
								</div>
								<div class="bottom">
									<ul>
										<li>
											<h3>4</h3>
											<span>place</span>
										</li>
										<li>
											<h3>1256</h3>
											<span>votes</span>
										</li>
										<li>
											<a href="javascript:;" class="vote-btn">Vote</a>
										</li>
									</ul>
								</div>
							</div>

							<div class="gallery-block">
								<ul>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
								</ul>
							</div>
						</div>
					</div>
					<div id="tab-6" class="tab-content">
						<div class="tab-wrapper">
							<div class="img-block">
								<img src="${location}/assets/img/content/profile.jpg" alt="">
							</div>

							<div class="description-block">
								<div class="top">
									<h2>
										<span>Danka</span>
										<img src="${location}/assets/img/content/flag-en.png" alt="" />
									</h2>
									<a href="javascript:;" class="btn">
										<img src="${location}/assets/img/content/token.png" alt="" />
										Buy tokens
									</a>
								</div>
								<div class="description">
									<p>
										Lorem ipsum dolor sit amet, veri libris accommodare an sed, movet dicam dicunt cu sit. Duo eu nisl adhuc dissentiet, nam at invidunt definitionem, ei his ipsum sanctus dolorum. Duo mutat volutpat ex, cu percipitur accommodare est. Sit cu accumsan abhorreant contentiones, commodo veritus imperdiet mel in. Mea te commodo legimus, sit te tale nemore, te eam quas reprimique. Sea integre invenire ei.
									</p>
								</div>
								<div class="bottom">
									<ul>
										<li>
											<h3>4</h3>
											<span>place</span>
										</li>
										<li>
											<h3>1256</h3>
											<span>votes</span>
										</li>
										<li>
											<a href="javascript:;" class="vote-btn">Vote</a>
										</li>
									</ul>
								</div>
							</div>

							<div class="gallery-block">
								<ul>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
								</ul>
							</div>
						</div>
					</div>
					<div id="tab-7" class="tab-content">
						<div class="tab-wrapper">
							<div class="img-block">
								<img src="${location}/assets/img/content/profile.jpg" alt="">
							</div>

							<div class="description-block">
								<div class="top">
									<h2>
										<span>Ivana</span>
										<img src="${location}/assets/img/content/flag-en.png" alt="" />
									</h2>
									<a href="javascript:;" class="btn">
										<img src="${location}/assets/img/content/token.png" alt="" />
										Buy tokens
									</a>
								</div>
								<div class="description">
									<p>
										Lorem ipsum dolor sit amet, veri libris accommodare an sed, movet dicam dicunt cu sit. Duo eu nisl adhuc dissentiet, nam at invidunt definitionem, ei his ipsum sanctus dolorum. Duo mutat volutpat ex, cu percipitur accommodare est. Sit cu accumsan abhorreant contentiones, commodo veritus imperdiet mel in. Mea te commodo legimus, sit te tale nemore, te eam quas reprimique. Sea integre invenire ei.
									</p>
								</div>
								<div class="bottom">
									<ul>
										<li>
											<h3>4</h3>
											<span>place</span>
										</li>
										<li>
											<h3>1256</h3>
											<span>votes</span>
										</li>
										<li>
											<a href="javascript:;" class="vote-btn">Vote</a>
										</li>
									</ul>
								</div>
							</div>

							<div class="gallery-block">
								<ul>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
								</ul>
							</div>
						</div>
					</div>
					<div id="tab-8" class="tab-content">
						<div class="tab-wrapper">
							<div class="img-block">
								<img src="${location}/assets/img/content/profile.jpg" alt="">
							</div>

							<div class="description-block">
								<div class="top">
									<h2>
										<span>Jasmina</span>
										<img src="${location}/assets/img/content/flag-en.png" alt="" />
									</h2>
									<a href="javascript:;" class="btn">
										<img src="${location}/assets/img/content/token.png" alt="" />
										Buy tokens
									</a>
								</div>
								<div class="description">
									<p>
										Lorem ipsum dolor sit amet, veri libris accommodare an sed, movet dicam dicunt cu sit. Duo eu nisl adhuc dissentiet, nam at invidunt definitionem, ei his ipsum sanctus dolorum. Duo mutat volutpat ex, cu percipitur accommodare est. Sit cu accumsan abhorreant contentiones, commodo veritus imperdiet mel in. Mea te commodo legimus, sit te tale nemore, te eam quas reprimique. Sea integre invenire ei.
									</p>
								</div>
								<div class="bottom">
									<ul>
										<li>
											<h3>4</h3>
											<span>place</span>
										</li>
										<li>
											<h3>1256</h3>
											<span>votes</span>
										</li>
										<li>
											<a href="javascript:;" class="vote-btn">Vote</a>
										</li>
									</ul>
								</div>
							</div>

							<div class="gallery-block">
								<ul>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
								</ul>
							</div>
						</div>
					</div>
					<div id="tab-9" class="tab-content">
						<div class="tab-wrapper">
							<div class="img-block">
								<img src="${location}/assets/img/content/profile.jpg" alt="">
							</div>

							<div class="description-block">
								<div class="top">
									<h2>
										<span>Nada</span>
										<img src="${location}/assets/img/content/flag-en.png" alt="" />
									</h2>
									<a href="javascript:;" class="btn">
										<img src="${location}/assets/img/content/token.png" alt="" />
										Buy tokens
									</a>
								</div>
								<div class="description">
									<p>
										Lorem ipsum dolor sit amet, veri libris accommodare an sed, movet dicam dicunt cu sit. Duo eu nisl adhuc dissentiet, nam at invidunt definitionem, ei his ipsum sanctus dolorum. Duo mutat volutpat ex, cu percipitur accommodare est. Sit cu accumsan abhorreant contentiones, commodo veritus imperdiet mel in. Mea te commodo legimus, sit te tale nemore, te eam quas reprimique. Sea integre invenire ei.
									</p>
								</div>
								<div class="bottom">
									<ul>
										<li>
											<h3>4</h3>
											<span>place</span>
										</li>
										<li>
											<h3>1256</h3>
											<span>votes</span>
										</li>
										<li>
											<a href="javascript:;" class="vote-btn">Vote</a>
										</li>
									</ul>
								</div>
							</div>

							<div class="gallery-block">
								<ul>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
								</ul>
							</div>
						</div>
					</div>
					<div id="tab-10" class="tab-content">
						<div class="tab-wrapper">
							<div class="img-block">
								<img src="${location}/assets/img/content/profile.jpg" alt="">
							</div>

							<div class="description-block">
								<div class="top">
									<h2>
										<span>Anita</span>
										<img src="${location}/assets/img/content/flag-en.png" alt="" />
									</h2>
									<a href="javascript:;" class="btn">
										<img src="${location}/assets/img/content/token.png" alt="" />
										Buy tokens
									</a>
								</div>
								<div class="description">
									<p>
										Lorem ipsum dolor sit amet, veri libris accommodare an sed, movet dicam dicunt cu sit. Duo eu nisl adhuc dissentiet, nam at invidunt definitionem, ei his ipsum sanctus dolorum. Duo mutat volutpat ex, cu percipitur accommodare est. Sit cu accumsan abhorreant contentiones, commodo veritus imperdiet mel in. Mea te commodo legimus, sit te tale nemore, te eam quas reprimique. Sea integre invenire ei.
									</p>
								</div>
								<div class="bottom">
									<ul>
										<li>
											<h3>4</h3>
											<span>place</span>
										</li>
										<li>
											<h3>1256</h3>
											<span>votes</span>
										</li>
										<li>
											<a href="javascript:;" class="vote-btn">Vote</a>
										</li>
									</ul>
								</div>
							</div>

							<div class="gallery-block">
								<ul>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
								</ul>
							</div>
						</div>
					</div>
					<div id="tab-11" class="tab-content">
						<div class="tab-wrapper">
							<div class="img-block">
								<img src="${location}/assets/img/content/profile.jpg" alt="">
							</div>

							<div class="description-block">
								<div class="top">
									<h2>
										<span>Smiljka</span>
										<img src="${location}/assets/img/content/flag-en.png" alt="" />
									</h2>
									<a href="javascript:;" class="btn">
										<img src="${location}/assets/img/content/token.png" alt="" />
										Buy tokens
									</a>
								</div>
								<div class="description">
									<p>
										Lorem ipsum dolor sit amet, veri libris accommodare an sed, movet dicam dicunt cu sit. Duo eu nisl adhuc dissentiet, nam at invidunt definitionem, ei his ipsum sanctus dolorum. Duo mutat volutpat ex, cu percipitur accommodare est. Sit cu accumsan abhorreant contentiones, commodo veritus imperdiet mel in. Mea te commodo legimus, sit te tale nemore, te eam quas reprimique. Sea integre invenire ei.
									</p>
								</div>
								<div class="bottom">
									<ul>
										<li>
											<h3>4</h3>
											<span>place</span>
										</li>
										<li>
											<h3>1256</h3>
											<span>votes</span>
										</li>
										<li>
											<a href="javascript:;" class="vote-btn">Vote</a>
										</li>
									</ul>
								</div>
							</div>

							<div class="gallery-block">
								<ul>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
								</ul>
							</div>
						</div>
					</div>
					<div id="tab-12" class="tab-content">
						<div class="tab-wrapper">
							<div class="img-block">
								<img src="${location}/assets/img/content/profile.jpg" alt="">
							</div>

							<div class="description-block">
								<div class="top">
									<h2>
										<span>Gordana</span>
										<img src="${location}/assets/img/content/flag-en.png" alt="" />
									</h2>
									<a href="javascript:;" class="btn">
										<img src="${location}/assets/img/content/token.png" alt="" />
										Buy tokens
									</a>
								</div>
								<div class="description">
									<p>
										Lorem ipsum dolor sit amet, veri libris accommodare an sed, movet dicam dicunt cu sit. Duo eu nisl adhuc dissentiet, nam at invidunt definitionem, ei his ipsum sanctus dolorum. Duo mutat volutpat ex, cu percipitur accommodare est. Sit cu accumsan abhorreant contentiones, commodo veritus imperdiet mel in. Mea te commodo legimus, sit te tale nemore, te eam quas reprimique. Sea integre invenire ei.
									</p>
								</div>
								<div class="bottom">
									<ul>
										<li>
											<h3>4</h3>
											<span>place</span>
										</li>
										<li>
											<h3>1256</h3>
											<span>votes</span>
										</li>
										<li>
											<a href="javascript:;" class="vote-btn">Vote</a>
										</li>
									</ul>
								</div>
							</div>

							<div class="gallery-block">
								<ul>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
								</ul>
							</div>
						</div>
					</div>
					<div id="tab-13" class="tab-content">
						<div class="tab-wrapper">
							<div class="img-block">
								<img src="${location}/assets/img/content/profile.jpg" alt="">
							</div>

							<div class="description-block">
								<div class="top">
									<h2>
										<span>Mirela</span>
										<img src="${location}/assets/img/content/flag-en.png" alt="" />
									</h2>
									<a href="javascript:;" class="btn">
										<img src="${location}/assets/img/content/token.png" alt="" />
										Buy tokens
									</a>
								</div>
								<div class="description">
									<p>
										Lorem ipsum dolor sit amet, veri libris accommodare an sed, movet dicam dicunt cu sit. Duo eu nisl adhuc dissentiet, nam at invidunt definitionem, ei his ipsum sanctus dolorum. Duo mutat volutpat ex, cu percipitur accommodare est. Sit cu accumsan abhorreant contentiones, commodo veritus imperdiet mel in. Mea te commodo legimus, sit te tale nemore, te eam quas reprimique. Sea integre invenire ei.
									</p>
								</div>
								<div class="bottom">
									<ul>
										<li>
											<h3>4</h3>
											<span>place</span>
										</li>
										<li>
											<h3>1256</h3>
											<span>votes</span>
										</li>
										<li>
											<a href="javascript:;" class="vote-btn">Vote</a>
										</li>
									</ul>
								</div>
							</div>

							<div class="gallery-block">
								<ul>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
								</ul>
							</div>
						</div>
					</div>
					<div id="tab-14" class="tab-content">
						<div class="tab-wrapper">
							<div class="img-block">
								<img src="${location}/assets/img/content/profile.jpg" alt="">
							</div>

							<div class="description-block">
								<div class="top">
									<h2>
										<span>Rada</span>
										<img src="${location}/assets/img/content/flag-en.png" alt="" />
									</h2>
									<a href="javascript:;" class="btn">
										<img src="${location}/assets/img/content/token.png" alt="" />
										Buy tokens
									</a>
								</div>
								<div class="description">
									<p>
										Lorem ipsum dolor sit amet, veri libris accommodare an sed, movet dicam dicunt cu sit. Duo eu nisl adhuc dissentiet, nam at invidunt definitionem, ei his ipsum sanctus dolorum. Duo mutat volutpat ex, cu percipitur accommodare est. Sit cu accumsan abhorreant contentiones, commodo veritus imperdiet mel in. Mea te commodo legimus, sit te tale nemore, te eam quas reprimique. Sea integre invenire ei.
									</p>
								</div>
								<div class="bottom">
									<ul>
										<li>
											<h3>4</h3>
											<span>place</span>
										</li>
										<li>
											<h3>1256</h3>
											<span>votes</span>
										</li>
										<li>
											<a href="javascript:;" class="vote-btn">Vote</a>
										</li>
									</ul>
								</div>
							</div>

							<div class="gallery-block">
								<ul>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
								</ul>
							</div>
						</div>
					</div>
					<div id="tab-15" class="tab-content">
						<div class="tab-wrapper">
							<div class="img-block">
								<img src="${location}/assets/img/content/profile.jpg" alt="">
							</div>

							<div class="description-block">
								<div class="top">
									<h2>
										<span>Ivana</span>
										<img src="${location}/assets/img/content/flag-en.png" alt="" />
									</h2>
									<a href="javascript:;" class="btn">
										<img src="${location}/assets/img/content/token.png" alt="" />
										Buy tokens
									</a>
								</div>
								<div class="description">
									<p>
										Lorem ipsum dolor sit amet, veri libris accommodare an sed, movet dicam dicunt cu sit. Duo eu nisl adhuc dissentiet, nam at invidunt definitionem, ei his ipsum sanctus dolorum. Duo mutat volutpat ex, cu percipitur accommodare est. Sit cu accumsan abhorreant contentiones, commodo veritus imperdiet mel in. Mea te commodo legimus, sit te tale nemore, te eam quas reprimique. Sea integre invenire ei.
									</p>
								</div>
								<div class="bottom">
									<ul>
										<li>
											<h3>4</h3>
											<span>place</span>
										</li>
										<li>
											<h3>1256</h3>
											<span>votes</span>
										</li>
										<li>
											<a href="javascript:;" class="vote-btn">Vote</a>
										</li>
									</ul>
								</div>
							</div>

							<div class="gallery-block">
								<ul>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
								</ul>
							</div>
						</div>
					</div>
					<div id="tab-16" class="tab-content">
						<div class="tab-wrapper">
							<div class="img-block">
								<img src="${location}/assets/img/content/profile.jpg" alt="">
							</div>

							<div class="description-block">
								<div class="top">
									<h2>
										<span>Zorana</span>
										<img src="${location}/assets/img/content/flag-en.png" alt="" />
									</h2>
									<a href="javascript:;" class="btn">
										<img src="${location}/assets/img/content/token.png" alt="" />
										Buy tokens
									</a>
								</div>
								<div class="description">
									<p>
										Lorem ipsum dolor sit amet, veri libris accommodare an sed, movet dicam dicunt cu sit. Duo eu nisl adhuc dissentiet, nam at invidunt definitionem, ei his ipsum sanctus dolorum. Duo mutat volutpat ex, cu percipitur accommodare est. Sit cu accumsan abhorreant contentiones, commodo veritus imperdiet mel in. Mea te commodo legimus, sit te tale nemore, te eam quas reprimique. Sea integre invenire ei.
									</p>
								</div>
								<div class="bottom">
									<ul>
										<li>
											<h3>4</h3>
											<span>place</span>
										</li>
										<li>
											<h3>1256</h3>
											<span>votes</span>
										</li>
										<li>
											<a href="javascript:;" class="vote-btn">Vote</a>
										</li>
									</ul>
								</div>
							</div>

							<div class="gallery-block">
								<ul>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
								</ul>
							</div>
						</div>
					</div>
					<div id="tab-17" class="tab-content">
						<div class="tab-wrapper">
							<div class="img-block">
								<img src="${location}/assets/img/content/profile.jpg" alt="">
							</div>

							<div class="description-block">
								<div class="top">
									<h2>
										<span>Milica</span>
										<img src="${location}/assets/img/content/flag-en.png" alt="" />
									</h2>
									<a href="javascript:;" class="btn">
										<img src="${location}/assets/img/content/token.png" alt="" />
										Buy tokens
									</a>
								</div>
								<div class="description">
									<p>
										Lorem ipsum dolor sit amet, veri libris accommodare an sed, movet dicam dicunt cu sit. Duo eu nisl adhuc dissentiet, nam at invidunt definitionem, ei his ipsum sanctus dolorum. Duo mutat volutpat ex, cu percipitur accommodare est. Sit cu accumsan abhorreant contentiones, commodo veritus imperdiet mel in. Mea te commodo legimus, sit te tale nemore, te eam quas reprimique. Sea integre invenire ei.
									</p>
								</div>
								<div class="bottom">
									<ul>
										<li>
											<h3>4</h3>
											<span>place</span>
										</li>
										<li>
											<h3>1256</h3>
											<span>votes</span>
										</li>
										<li>
											<a href="javascript:;" class="vote-btn">Vote</a>
										</li>
									</ul>
								</div>
							</div>

							<div class="gallery-block">
								<ul>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
								</ul>
							</div>
						</div>
					</div>
					<div id="tab-18" class="tab-content">
						<div class="tab-wrapper">
							<div class="img-block">
								<img src="${location}/assets/img/content/profile.jpg" alt="">
							</div>

							<div class="description-block">
								<div class="top">
									<h2>
										<span>Jelena</span>
										<img src="${location}/assets/img/content/flag-en.png" alt="" />
									</h2>
									<a href="javascript:;" class="btn">
										<img src="${location}/assets/img/content/token.png" alt="" />
										Buy tokens
									</a>
								</div>
								<div class="description">
									<p>
										Lorem ipsum dolor sit amet, veri libris accommodare an sed, movet dicam dicunt cu sit. Duo eu nisl adhuc dissentiet, nam at invidunt definitionem, ei his ipsum sanctus dolorum. Duo mutat volutpat ex, cu percipitur accommodare est. Sit cu accumsan abhorreant contentiones, commodo veritus imperdiet mel in. Mea te commodo legimus, sit te tale nemore, te eam quas reprimique. Sea integre invenire ei.
									</p>
								</div>
								<div class="bottom">
									<ul>
										<li>
											<h3>4</h3>
											<span>place</span>
										</li>
										<li>
											<h3>1256</h3>
											<span>votes</span>
										</li>
										<li>
											<a href="javascript:;" class="vote-btn">Vote</a>
										</li>
									</ul>
								</div>
							</div>

							<div class="gallery-block">
								<ul>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
											<span>Watch me in video archive</span>
										</a>
									</li>
								</ul>
							</div>
						</div>
					</div>

				</div>

				<div class="people-list">
					<ul class="people tabs">
						<li class="tab-link current" data-tab="tab-1">
							<div class="inner">
								<div class="img-wrapper">
									<div class="overlay">
										<span>Vote</span>
									</div>
									<img src="${location}/assets/img/content/profile-s.png" alt="" />
								</div>
								<p>Johanes</p>
								<span class="total">1372</span>
							</div>

						</li>
						<li class="tab-link" data-tab="tab-2">
							<div class="inner">
								<div class="img-wrapper">
									<div class="overlay">
										<span>Vote</span>
									</div>
									<img src="${location}/assets/img/content/profile-s.png" alt="" />
								</div>
								<p>Johanes</p>
								<span class="total">1372</span>
							</div>
						</li>
						<li class="tab-link" data-tab="tab-3">
							<div class="inner">
								<div class="img-wrapper">
									<div class="overlay">
										<span>Vote</span>
									</div>
									<img src="${location}/assets/img/content/profile-s.png" alt="" />
								</div>
								<p>Johanes</p>
								<span class="total">1372</span>
							</div>
						</li>
						<li class="tab-link" data-tab="tab-4">
							<div class="inner">
								<div class="img-wrapper">
									<div class="overlay">
										<span>Vote</span>
									</div>
									<img src="${location}/assets/img/content/profile-s.png" alt="" />
								</div>
								<p>Johanes</p>
								<span class="total">1372</span>
							</div>
						</li>
						<li class="tab-link" data-tab="tab-5">
							<div class="inner">
								<div class="img-wrapper">
									<div class="overlay">
										<span>Vote</span>
									</div>
									<img src="${location}/assets/img/content/profile-s.png" alt="" />
								</div>
								<p>Johanes</p>
								<span class="total">1372</span>
							</div>
						</li>
						<li class="tab-link" data-tab="tab-6">
							<div class="inner">
								<div class="img-wrapper">
									<div class="overlay">
										<span>Vote</span>
									</div>
									<img src="${location}/assets/img/content/profile-s.png" alt="" />
								</div>
								<p>Johanes</p>
								<span class="total">1372</span>
							</div>
						</li>
						<li class="tab-link" data-tab="tab-7">
							<div class="inner">
								<div class="img-wrapper">
									<div class="overlay">
										<span>Vote</span>
									</div>
									<img src="${location}/assets/img/content/profile-s.png" alt="" />
								</div>
								<p>Johanes</p>
								<span class="total">1372</span>
							</div>
						</li>
						<li class="tab-link" data-tab="tab-8">
							<div class="inner">
								<div class="img-wrapper">
									<div class="overlay">
										<span>Vote</span>
									</div>
									<img src="${location}/assets/img/content/profile-s.png" alt="" />
								</div>
								<p>Johanes</p>
								<span class="total">1372</span>
							</div>
						</li>
						<li class="tab-link" data-tab="tab-9">
							<div class="inner">
								<div class="img-wrapper">
									<div class="overlay">
										<span>Vote</span>
									</div>
									<img src="${location}/assets/img/content/profile-s.png" alt="" />
								</div>
								<p>Johanes</p>
								<span class="total">1372</span>
							</div>
						</li>
						<li class="tab-link" data-tab="tab-10">
							<div class="inner">
								<div class="img-wrapper">
									<div class="overlay">
										<span>Vote</span>
									</div>
									<img src="${location}/assets/img/content/profile-s.png" alt="" />
								</div>
								<p>Johanes</p>
								<span class="total">1372</span>
							</div>
						</li>
						<li class="tab-link" data-tab="tab-11">
							<div class="inner">
								<div class="img-wrapper">
									<div class="overlay">
										<span>Vote</span>
									</div>
									<img src="${location}/assets/img/content/profile-s.png" alt="" />
								</div>
								<p>Johanes</p>
								<span class="total">1372</span>
							</div>
						</li>
						<li class="tab-link" data-tab="tab-12">
							<div class="inner">
								<div class="img-wrapper">
									<div class="overlay">
										<span>Vote</span>
									</div>
									<img src="${location}/assets/img/content/profile-s.png" alt="" />
								</div>
								<p>Johanes</p>
								<span class="total">1372</span>
							</div>
						</li>
						<li class="tab-link" data-tab="tab-13">
							<div class="inner">
								<div class="img-wrapper">
									<div class="overlay">
										<span>Vote</span>
									</div>
									<img src="${location}/assets/img/content/profile-s.png" alt="" />
								</div>
								<p>Johanes</p>
								<span class="total">1372</span>
							</div>
						</li>
						<li class="tab-link" data-tab="tab-14">
							<div class="inner">
								<div class="img-wrapper">
									<div class="overlay">
										<span>Vote</span>
									</div>
									<img src="${location}/assets/img/content/profile-s.png" alt="" />
								</div>
								<p>Johanes</p>
								<span class="total">1372</span>
							</div>
						</li>
						<li class="tab-link" data-tab="tab-15">
							<div class="inner">
								<div class="img-wrapper">
									<div class="overlay">
										<span>Vote</span>
									</div>
									<img src="${location}/assets/img/content/profile-s.png" alt="" />
								</div>
								<p>Johanes</p>
								<span class="total">1372</span>
							</div>
						</li>
						<li class="tab-link" data-tab="tab-16">
							<div class="inner">
								<div class="img-wrapper">
									<div class="overlay">
										<span>Vote</span>
									</div>
									<img src="${location}/assets/img/content/profile-s.png" alt="" />
								</div>
								<p>Johanes</p>
								<span class="total">1372</span>
							</div>
						</li>
						<li class="tab-link" data-tab="tab-17">
							<div class="inner">
								<div class="img-wrapper">
									<div class="overlay">
										<span>Vote</span>
									</div>
									<img src="${location}/assets/img/content/profile-s.png" alt="" />
								</div>
								<p>Johanes</p>
								<span class="total">1372</span>
							</div>
						</li>
						<li class="tab-link" data-tab="tab-18">
							<div class="inner">
								<div class="img-wrapper">
									<div class="overlay">
										<span>Vote</span>
									</div>
									<img src="${location}/assets/img/content/profile-s.png" alt="" />
								</div>
								<p>Johanes</p>
								<span class="total">1372</span>
							</div>
						</li>
					</ul>
				</div>
			</div>

			 <%@include file="footer.jsp" %>
		</div>
			
	</div>

	<%@include file="jsScript.jsp" %>

</body>
</html>
