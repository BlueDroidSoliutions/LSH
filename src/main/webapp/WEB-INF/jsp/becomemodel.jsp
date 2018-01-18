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
            <div class="wrapper wanted-wrapper">
                <!-- multistep form -->
                <div id="wantedBlock">
                    <div class="modelHero">
<!--                        <div class="heroIner">
                            <h2>Fast, discretly, safe!</h2>
                            <p>
                                <span class="big">
                                    No Money Cap,
                                </span>
                                Remember we get payed
                                <span class="big">
                                    when <span class="yellow">you</span> get payed
                                </span>
                            </p>
                            <ul>
                                <li>
                                    <p>* country ban - <strong>you decide broadcat regions</strong></p>
                                </li>
                                <li>
                                    <p>* competitions - <strong>won extra gifts and travel arangements!</strong></p>
                                </li>
                                <li>
                                    <p>* statistic - <strong>know how much you exactly earned!</strong></p>
                                </li>
                            </ul>
                            <a href="javascript:;" class="button">Became a model <img src="${location}/assets/img/da.png" alt-""/></i></a>
                        </div>-->
                    </div>


                    <script>
                        function onSubmit(token) {
                            document.getElementById("msform").submit();
                        }
                    </script>
                    

                    <form id="msform" method="POST" action="${pageContext.request.contextPath}/modelpost" name="forma" accept-charset="UTF-8" enctype="multipart/form-data">
                        <input type="hidden"
                               name="${_csrf.parameterName}"
                               value="${_csrf.token}"/>

                        <!-- fieldsets -->
                        <fieldset>
                            <div class="topForm">
                                <h2 class="fs-title">Your details</h2>
                                <p class="fs-subtitle">
                                    Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. <br />
                                    Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.
                                </p>
                            </div>

                            <div class="model-f-wrap">
                                <div class="one-half">
                                    <label>E-mail </label>
                                    <input type="text" name="email" />
                                </div>
                                <div class="one-half rb">
                                    <label>Full name </label>
                                    <input type="text" name="fullname" />
                                </div>

                                <div class="one-half">
                                    <label>Region</label>
                                    <input type="text" name="region" />
                                </div>
                                <div class="one-half rb">
                                    <label>Country</label>
                                    <select name="country" id="">
<option value=""></option>
                                        <c:forEach items="${findCountry}" var="findCountry">
                                            <option value="${findCountry.id}">${findCountry.countryName}</option>
                                        </c:forEach>




                                    </select>
                                </div>

                                <div class="one-half">
                                    <label>Adress</label>
                                    <input type="text" name="Adress" />
                                </div>
                                <div class="one-half rb">
                                    <label>Telephone </label>
                                    <input type="text" name="telep" />
                                </div>

                                <div class="one-half">
                                    <label>Password</label>
                                    <input type="password" name="password" />

                                </div>
                                <div class="one-half rb accept-radio">
                                    <label for="acceptterms"> <input type="checkbox" name="acceptterms" id="acceptterms">I am over 18, </label><a href="javascript:;">I AGREE TO THE CODE OF CONDUCT</a>
                                </div>
                            </div>

                            <input type="button" name="next" class="next action-button" value="Next" />
                        </fieldset>

                        <fieldset>
                            <div class="topForm">
                                <h2 class="fs-title">Account information</h2>
                                <p class="fs-subtitle">
                                    Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. <br />
                                    Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.
                                </p>
                            </div>

                            <div class="model-f-wrap">
                                <div class="one-half">
                                    <label>Nick name </label>
                                    <input type="text" name="nick" />

                                </div>
                                <div class="one-half rb">
                                    <label>Gender <br>
                                        <select name="gender" id="gender">
                                             <option value=""></option>
                                            <option value="male">Male</option>
                                            <option value="female">Female</option>
                                            
                                        </select>
                                    </label>
                                </div>

                                <div class="one-half">
                                    <label>Age/ birthday<br>
                                        <input type="text" name="birthday" />
                                    </label>
                                </div>
                                <div class="one-half rb">
                                    <label>Sexual Preference<br>
                                        <select name="sex" id="gender">
                                            <option value=""></option>
                                            <option value="Bisexual">Bisexual</option>
                                            <option value="Streight">Streight</option>
                                            <option value="Gay">Gay</option>
                                        </select>
                                    </label>
                                </div>

                                <div class="full-cell">
                                    <legend class="field-label">Interested in</legend>


                                    <c:forEach items="${findInteres}" var="findInteres">

                                        <label class="chw">
                                            <input type="checkbox" name="interes" value="${findInteres.id}"/>${findInteres.interesName}
                                        </label>


                                    </c:forEach>





                                </div>

                                <div class="one-half">
                                    <label>Display name </label>
                                    <input type="text" name="displayName" />
                                </div>
                                <div class="one-half rb">
                                    <label>Zodiac</label>
                                    <select name="zodiac" id="zodiac">
                                        <option value="none">Select one</option>
                                        <option value="The Ram">Ram</option>
                                        <option value="The Scales">Scales</option>
                                        <option value="Bull">Bull</option>
                                        <option value="Scorpion">Scorpion</option>
                                        <option value="Twins">Twins</option>
                                        <option value="Archer">Archer</option>
                                        <option value="Crab">Crab</option>
                                        <option value="Goat">Goat</option>
                                        <option value="Lion">Lion</option>
                                        <option value="Water Bearer">Water Bearer</option>
                                        <option value="Virgin">Virgin</option>
                                        <option value="fish">Fish</option>
                                    </select>
                                </div>

                                <div class="one-half">
                                    <label>Language <br>
                                        <select name="language" id="gender2">

<option value=""></option>
                                            <c:forEach items="${findLanguage}" var="findLanguage">
                                                <option value="${findLanguage.id}">${findLanguage.languageName}</option>
                                            </c:forEach>


                                        </select>
                                    </label>
                                </div>
                                <div class="one-half rb">
                                    <label>body type <br>
                                        <select name="body" id="gender3">
<option value=""></option>
                                            <c:forEach items="${findBody}" var="findBody">
                                                <option value="${findBody.id}">${findBody.bodyName}</option>
                                            </c:forEach>


                                        </select>
                                    </label>
                                </div>

                                <div class="one-half">
                                    <label>Body decorations <br>
                                        <select name="decorations" id="gender4">
 <option value=""></option>

                                            <c:forEach items="${findDecoration}" var="findDecoration">
                                                <option value="${findDecoration.id}">${findDecoration.decorationName}</option>

                                            </c:forEach>


                                        </select>
                                    </label>
                                </div>
                                <div class="one-half">
                                    <label>Languages Spoken <br>
                                        <select name="lngSpoken" id="gender5">
<option value=""></option>

                                            <c:forEach items="${findLanguageSpoken}" var="findLanguageSpoken">
                                                <option value="${findLanguageSpoken.id}">${findLanguageSpoken.languageSpokenname}</option>
                                            </c:forEach>

                                        </select>
                                    </label>
                                </div>
                                <div class="topForm">
                                    <h2>Appearence</h2>
                                </div>
                                <div class="one-half">
                                    <label>Height</label>
                                    <input type="text" name="height" />
                                </div>
                                <div class="one-half rb">
                                    <label>Weight </label>
                                    <input type="text" name="weight" />
                                </div>

                                <div class="one-half">
                                    <label>Hair color<br>
                                        <select name="hairColor" id="gender6">
<option value=""></option>
                                            <c:forEach items="${findHair}" var="findHair">
                                                <option value="${findHair.id}">${findHair.hairName}</option>
                                            </c:forEach>

                                        </select>
                                    </label>
                                </div>
                                <div class="one-half rb">
                                    <label>Eye Color<br>
                                        <select name="eyes" id="gender7">
                                            <option value=""></option>
                                            <option value="Blue">Blue</option>
                                            <option value="Black">Black</option>
                                            <option value="Brown">Brown</option>
                                        </select>
                                    </label>
                                </div>

                                <div class="one-half">
                                    <label>Ethnicity<br>
                                        <select name="ethnicity" id="gender8">
                                            <option value=""></option>
                                            <option value="White">White</option>
                                            <option value="Black">Black</option>
                                            <option value="Yellow">Yellow</option>
                                        </select>
                                    </label>
                                </div>
                                <div class="one-half rb">
                                    <label>Cup Size<br>
                                        <select name="cupSize" id="gender9">
                                            <option value=""></option>
                                            <option value="DD/A">DD/A</option>
                                            <option value="DD/E">DD/E</option>
                                            <option value="DD/F">DD/F</option>
                                        </select>
                                    </label>
                                </div>
                                <div class="one-half">
                                    <label>Pubic Hair<br>
                                        <select name="pubicHair" id="gender10">
                                            <option value=""></option>
                                            <option value="Bald">Bald</option>
                                            <option value="Long">Long</option>
                                            <option value="Short">Short</option>
                                        </select>
                                    </label>
                                </div>

                                <div class="one-half rb">
                                    <label>Measurements </label>
                                    <input type="text" class="one-third" name="mes1">
                                    <input type="text" class="one-third mid" name="mes2">
                                    <input type="text" class="one-third" name="mes3">
                                </div>

                                <div class="full-cell">
                                    <legend class="field-label">Kinky Attributes</legend>


                                    <c:forEach items="${findKinky}" var="findKinky">
                                        <label class="chw">
                                            <input type="checkbox" name="kinky" value="${findKinky.id}" />${findKinky.kinkyName}
                                        </label>
                                    </c:forEach>







                                </div>

                                <div class="full-third">
                                    <div>
                                        <h3 class="label">Audio</h3>
                                        <label class="chw">
                                            <input type="radio" name="Audio" value="1" />Yes
                                        </label>
                                        <label class="chw">
                                            <input type="radio" name="Audio" value="0" />No
                                        </label>
                                    </div>
                                    <div>
                                        <h3 class="label">High Definition Video</h3>
                                        <label class="chw">
                                            <input type="radio" name="hdVideo" value="1" />Yes
                                        </label>
                                        <label class="chw">
                                            <input type="radio" name="hdVideo" value="0" />No
                                        </label>
                                    </div>
                                    <div>
                                        <h3 class="label"> Confidential Phone Service</h3>
                                        <label class="chw">
                                            <input type="radio" name="phoneService" value="1" />Yes
                                        </label>
                                        <label class="chw">
                                            <input type="radio" name="phoneService" value="0" />No
                                        </label>
                                    </div>
                                </div>
                            </div>
                            <input type="button" name="next" class="next action-button" value="Next" />
                        </fieldset>

                        <fieldset>
                            <div class="topForm">
                                <h2 class="fs-title">We need some title here</h2>
                                <p class="fs-subtitle">
                                    Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. <br />
                                    Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.
                                </p>
                            </div>
                            <div class="model-f-wrap">
                                <div class="full-cell">
                                    <h3 class="field-label">About me</h3>
                                    <textarea name="about" maxlength="2048" id="about" cols="30" rows="10"></textarea>
                                </div>
                                <div class="full-cell">
                                    <h3 class="field-label">Upload pictures</h3>
                                    <div class="upload multiple">
                                        <input  type="file" name="files" id="idd1"/>
                                       
                                    </div>
                                </div>

                                <div class="full-cell">
                                    <legend class="field-label">Blocked countries</legend>


                                    <c:forEach items="${findBlockedCountry}" var="findBlockedCountry">
                                        <label class="chw">
                                            <input type="checkbox" name="blockedCountry" value="${findBlockedCountry.id}" />${findBlockedCountry.blockedCountryname}
                                        </label>
                                    </c:forEach>



                                </div>

                                <div class="full-cell">
                                    <legend class="field-label">Blocked region - US</legend>


                                    <c:forEach items="${findBlockedRegion}" var="findBlockedRegion">
                                        <label class="chw">
                                            <input type="checkbox" name="blockedRegion" value="${findBlockedRegion.id}" />${findBlockedRegion.blockedRegionname}
                                        </label>
                                    </c:forEach>

                                </div>

                                <div class="full-cell">
                                    <div class="one-half">
                                        <legend class="field-label">Group show</legend>
                                        <label class="chw">
                                            <input type="radio" name="groupShow" value="1" />Yes
                                        </label>
                                        <label class="chw">
                                            <input type="radio" name="groupShow" value="0" />No
                                        </label>
                                    </div>
                                    <div class="one-half rb">
                                        <legend class="field-label">Private shows</legend>
                                        <label class="chw">
                                            <input type="radio" name="privateShow" value="1" />Yes
                                        </label>
                                        <label class="chw">
                                            <input type="radio" name="privateShow" value="0" />No
                                        </label>
                                    </div>
                                </div>
                            </div>
                            <input type="button" name="next" class="next action-button" value="Next" />
                        </fieldset>

                        <fieldset>
                            <div class="topForm">
                                <h2 class="fs-title">Your documents</h2>
                                <p class="fs-subtitle">
                                    Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. <br />
                                    Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.
                                </p>
                            </div>
                            <div class="model-f-wrap">
                                <div id="uploadme">
                                    <div class="one-half frontpage">
                                        <input type="file" name="files" id="idd2" />
                                    </div>

                                    <div class="one-half rb backpage">
                                        <input  type="file" name="files" id="idd3" />
                                    </div>

                                    <div class="one-half snapshot">
                                        <input type="file" name="files"id="idd4" />
                                    </div>
                                    <div class="one-half snapshotID">
                                        <input  type="file" name="files"id="idd5" />
                                    </div>
                                </div>

                                <div class="one-half small">
                                    <label>ID expire date</label>
                                    <input type="text" name="idExpire" />
                                </div>
                                <div class="one-half rb">
                                    <label class="field-label">Permanent ID</label>
                                    <label class="chw">
                                        <input type="radio" name="permanentID" value="1" />Yes
                                    </label>
                                    <label class="chw">
                                        <input type="radio" name="permanentID" value="0" />No
                                    </label>
                                </div>
                            </div>

                            <!--  <input type="button" name="previous" class="previous action-button" value="Previous" /> -->
                           <!--<input type="submit" value = "Send" name="submit" class="submit action-button" />-->
                           <input type="submit" value="Send" class="btn-submit" class="submit action-button" id="btnSbmt6"> 
                       </fieldset>
 <!--<input type="submit" value = "Send" name="submit" class="submit action-button" >-->
 
                        <!-- progressbar -->
                        <div class="progress-wrap">
                            <ul id="progressbar">
                                <li class="active"></li>
                                <li></li>
                                <li></li>
                                <li></li>
                            </ul>
                        </div>
                    </form>

                </div>


            </div>
        </div>

        <%@include file="footer.jsp" %>
    </div>

</div>

<!-- javascript -->
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script type="text/javascript">window.jQuery || document.write("<script src='${location}/assets/scripts/main/jquery-1.8.3.min.js'>\x3C/script>")</script>
<script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
<script type="text/javascript" src="${location}/assets/scripts/libs/jquery.selectric.js"></script>
<script type="text/javascript" src="${location}/assets/scripts/libs/jcf.js"></script>
<script type="text/javascript" src="${location}/assets/scripts/libs/jcf.radio.js"></script>
<script type="text/javascript" src="${location}/assets/scripts/libs/jcf.checkbox.js"></script>
<script type="text/javascript" src="${location}/assets/scripts/libs/masonry.pkgd.min.js"></script>
<script type="text/javascript" src="${location}/assets/scripts/libs/jQuery.fakeScroll.js"></script>

<!-- File upload -->
<script type="text/javascript" src="${location}/assets/scripts/fancy-file-uploader/jquery.ui.widget.js"></script>
<link rel="stylesheet" href="${location}/assets/scripts/fancy-file-uploader/fancy_fileupload.css" type="text/css" media="all" />
<script type="text/javascript" src="${location}/assets/scripts/fancy-file-uploader/jquery.fileupload.js"></script>
<script type="text/javascript" src="${location}/assets/scripts/fancy-file-uploader/jquery.iframe-transport.js"></script>
<script type="text/javascript" src="${location}/assets/scripts/fancy-file-uploader/jquery.fancy-fileupload.js"></script>
<!-- File upload END -->

<script type="text/javascript" src="${location}/assets/scripts/main/default.js"></script>

<!--[if lt IE 7]>
   <p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
<![endif]-->

</body>
</html>
