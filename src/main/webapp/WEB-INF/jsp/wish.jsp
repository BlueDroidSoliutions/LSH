<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js ie6"> <![endif]-->
<!--[if IE 7]>         <html class="no-js ie7"> <![endif]-->
<!--[if IE 8]>         <html class="no-js ie8"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
        <link href="${location}favicon.ico" rel="icon" />
	<title>Your Wish</title>
	<meta name="description" content="">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="${location}/assets/css/lib/jcf.css">
	<link rel="stylesheet" href="${location}/assets/css/style.css">
	<script type="text/javascript" src="${location}/assets/scripts/libs/modernizr.2.8.3.min.js"></script>
</head>
<body class="page-wish">
	
    <%@include file="sign.jsp" %>
<div class="container full-screen-height">
<%@include file="menu.jsp" %>

		<div id="page-wrap">
			<div class="wish-container clearfix">
				<div class="box-left">
					<div class="form-holder clearfix">
						<h2 class="u-title">Your wish</h2>
						<p>
							Below is your wish form. You can choose any type of scenario, and every couple as well as any room in the house. Live Sex House administrators will rewiev Your idea and let You know if it is been accepted. If Your Idea reaches trending on our video archive, you will be <strong>rewarded by 1000$!</strong>
						</p>
						<form action="wish">
							<div class="clearfix">
								<div class="form-half">
									<span class="field-label">Participant 1</span>
									<select>
										<option value="Johny">Johny</option>
										<option value="Name2">Name 2</option>
										<option value="Name3">Name 3</option>
										<option value="Name4">Name 4</option>
										<option value="Name5">Name 4</option>
									</select>
								</div>
								<div class="form-half">
									<span class="field-label">Participant 2</span>
									<select>
										<option value="Johny">Johny</option>
										<option value="Name2">Name 2</option>
										<option value="Name3">Name 3</option>
										<option value="Name4">Name 4</option>
										<option value="Name5">Name 4</option>
									</select>
								</div>
							</div>
							<div class="form-full">
								<span class="field-label">Choose action/activity</span>
								<select>
									<option value="Action">Action</option>
									<option value="Action2">Action 2</option>
									<option value="Action3">Action 3</option>
									<option value="Action4">Action 4</option>
									<option value="Action5">Action 4</option>
								</select>
							</div>
							<div class="clearfix">
								<div class="form-half">
									<span class="field-label">Extra</span>
									<select>
										<option value="Extra">Extra</option>
										<option value="Extra2">Extra 2</option>
										<option value="Extra3">Extra 3</option>
										<option value="Extra4">Extra 4</option>
										<option value="Extra5">Extra 4</option>
									</select>
								</div>
								<div class="form-half">
									<span class="field-label">Location</span>
									<select>
										<option value="Location">Location 1</option>
										<option value="Location2">Location 2</option>
										<option value="Location3">Location 3</option>
										<option value="Location4">Location 4</option>
										<option value="Location5">Location 4</option>
									</select>
								</div>
							</div>
							<input type="submit" placeholder="Submit">
						</form>
					</div>
				</div>
				<div class="box-right">
					<div class="box-right-box"></div>
					<div class="box-right-box"></div>
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
