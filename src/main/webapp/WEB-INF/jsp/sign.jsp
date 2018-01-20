<%-- 
    Document   : sign
    Created on : Jul 24, 2017, 11:56:10 AM
    Author     : roller
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
    <link href="${bck}${location}/favicon.ico" rel="icon" />
    <title>LiveSexHouse</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,700" rel="stylesheet">
    <link rel="stylesheet" href="${bck}${location}/assets/css/lib/jcf.css">
    <link rel="stylesheet" href="${bck}${location}/assets/css/lib/fakeScroll.css">
    <!--<link href="${bck}${location}/assets/css/nouislider.min.css" rel="stylesheet">-->
    <link rel="stylesheet" href="${bck}${location}/assets/css/style.css">
    <script type="text/javascript" src="${bck}${location}/assets/scripts/libs/modernizr.2.8.3.min.js"></script>
    <script src="https://use.fontawesome.com/48b7d32ec9.js"></script>

</head>
<body>

    <script>
        var loginChecker = false;
        var signinChecker = false;
        var emailTaken = false;
        var usernameTaken = false;
        var wrongPassword = false;
        var wrongUsername = false;
        var checkEmail = false;
        var alredySigned = false;
        var thanksReg = false;
        var serverOff = false;
        var emptyField = false;
        
        var serverOffMsg = '<c:out value="${serverOffMsg}"/>';
        
        
        
    </script>

    <c:if test="${serverOff == true}">
        <script>  serverOff = true;  </script>
    </c:if>
    
    
   
<!--    prvo se pojavljuje SIGN IN-->
    <c:if test="${alredySigned == true}">
        <script>  alredySigned = true;  </script>
    </c:if>
            
<!--        ako nije dobra sifra ide poruka sa losom sifrom i automatski se pojavljuje SIGN IN    -->
    <c:if test="${loginError == true}">
        <script>  wrongPassword = true;   signinChecker = true;  </script>
    </c:if>

<!--        ako treba konfirmacija , na svakoj strani se pojavljuje check e mail i ne moze se logovati-->
    <c:if test="${checkEmail == true}">
        <script>  checkEmail = true;  </script>
    </c:if>

<!--        ako treba da se automatski pojavi SIGNIN-->
    <c:if test="${signinChecker == true}">
        <script>  signinChecker = true;  </script>
    </c:if>
        
        
<!--        ako je verifikovan ima SIGN IN i emailChecker je false i ne proverava se ni jedan drugi kuki-->
    <c:if test="${trustedUser == true}">
        <script>  alredySigned = true;  checkEmail = false; </script>
    </c:if>  
        
<!--    ako se tek verifikovao-->
    <c:if test="${thanksReg == true}">
        <script>  thanksReg = true;  </script>
    </c:if>      

        <!--    ako prazno polje -->
    <c:if test="${emptyField == true}">
        <script>  emptyField = true;  </script>
    </c:if>
        
        <!--    ako zauzet email -->
    <c:if test="${emailTaken == true}">
        <script>  emailTaken = true;  </script>
    </c:if>
        
        <!--    ako je zauzet username -->
    <c:if test="${usernameTaken == true}">
        <script>  usernameTaken = true;  </script>
    </c:if>
        
        
        

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





                    <form id="signup" method="post" action="${pageContext.request.contextPath}${path}/signup" name="forma" accept-charset="UTF-8">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

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
                    <form name='loginForm' action="${bck}./login" method='POST'>
                        <div>
                            <input type="text" id="name" name="username" placeholder="username">
                        </div>
                        <div>
                            <input type="password" id="password" name="password" placeholder="password">
                        </div>
                        <button  name="submit" type="submit"  value="submit" class="btn">SIGN IN</button>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                    </form>
                    <p id="dont" style="padding-top: 20px;">Don't have an account? </p><a href="javascript:;" id="showCreate">Create here</a>

                </div>
            </div>





        </div>
    </div>


    <div class="container full-screen-height">          




        <header class="header">
            <div class="wrapper">
                <a href="${bck}./" id="logo">
                    <img src="${bck}${location}/assets/img/content/LSH-logo.png" alt="Live Sex House logo" />
                </a>
                <a href="javascript:;" id="menu-btn">
                    <span></span>
                    <span></span>
                    <span></span>
                    <span></span>
                </a>
                <ul id="main-nav">
                    <li><a href="${bck}./">Home</a></li>
                    <li><a href="${bck}./live-stream">Live streams</a></li>
                    <li><a href="${bck}./video">Video archive</a></li>

                    <li>
                        <a href="${bck}./webcam">Web cam</a>
                        <a href="javascript:;" class="submenu-btn">
                            <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" version="1.1" viewBox="0 0 129 129" enable-background="new 0 0 129 129">
                            <g>
                            <path d="m121.3,34.6c-1.6-1.6-4.2-1.6-5.8,0l-51,51.1-51.1-51.1c-1.6-1.6-4.2-1.6-5.8,0-1.6,1.6-1.6,4.2 0,5.8l53.9,53.9c0.8,0.8 1.8,1.2 2.9,1.2 1,0 2.1-0.4 2.9-1.2l53.9-53.9c1.7-1.6 1.7-4.2 0.1-5.8z" fill="#FFFFFF"/>
                            </g>
                            </svg>
                        </a>
<!--                        <ul>
                            <li><a href="javascript:;">Subitem</a></li>
                            <li><a href="javascript:;">Subitem</a></li>
                            <li><a href="javascript:;">Subitem</a></li>
                            <li><a href="javascript:;">Subitem</a></li>
                        </ul>-->
                    </li>
                    <li><a href="${bck}./vote">Vote</a></li>
                    <li><a href="${bck}./contact">Contact</a></li>


                    <c:choose>
                        <c:when test="${not empty userName}">
                            <li><a href="${bck}./logout">Logout ${userName}</a></li>
                            </c:when>
                            <c:otherwise>
                            <li><a href="javascript:;" id="login-btn">Login/Join</a></li>
                            </c:otherwise>
                        </c:choose>


                </ul>
            </div>
        </header>