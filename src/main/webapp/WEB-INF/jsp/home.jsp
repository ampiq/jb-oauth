<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<c:set var = "role" scope = "session" value = '<%= session.getAttribute("role") %>'/>
<s:eval expression="@environment.getProperty('google.appid')" var="appid"/>
<c:choose>
    <c:when test="${role == null}">
        <c:set var = "name" scope = "session" value = "user"/>
    </c:when>
    <c:otherwise>
        <c:set var = "name" scope = "session" value = '<%= session.getAttribute("name") %>'/>
    </c:otherwise>
</c:choose>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>Home Page </title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/login.css">
    <meta name="google-signin-scope" content="profile email">
    <meta name="google-signin-client_id" content="${appid}.apps.googleusercontent.com">
</head>
<body>
<div class="container-fluid">
    <div class="card card-login">
        <div class="card-body">
            <div class="row justify-content-center">
                <div class="col-lg-6 col-md-12">
                    <div class="padding bg-primary text-center align-items-center d-flex">
                        <div id="particles-js"></div>
                        <div class="w-100">
                            <div class="logo mb-4">
                                <img src="img/tc.png" alt="tc logo" class="img-fluid">
                            </div>
                            <h4 class="text-light mb-2">Welcome :)</h4>
                            <p class="lead text-light">Welcome <strong>${name}</strong>! This is a home page</p>
                            <c:choose>
                                <c:when test="${role != null}">
                                    <form action="logout" method="post">
                                        <button class="btn btn-block btn-icon btn-icon-logout mb-3">
                                            Sign out
                                        </button>
                                    </form>
                                </c:when>
                                <c:otherwise>
                                    <form action="signin" method="post">
                                        <button class="btn btn-block btn-icon btn-icon-signin mb-3">
                                            Sign in
                                        </button>
                                    <form>
                                </c:otherwise>
                            </c:choose>
                        </div>
                        <div class="help-links">
                            <ul>
                                <li><a href="https://www.jetbrains.com/legal/docs/teamcity/teamcity_hosted.html">Terms of Service</a></li>
                                <li><a href="https://www.jetbrains.com/legal/docs/privacy/privacy.html">Privacy Policy</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                    <div class="col-lg-6 col-md-12">
                        <div class="padding">
                            <c:choose>
                                <c:when test="${role == null}">
                                    <h2>Sign in</h2>
                                    <p class="lead">Before you get started, you must login or register if you don't already have an account.</p>
                                </c:when>
                                <c:otherwise>
                                    <h2>Already signed in</h2>
                                    <p class="lead">Try to logout now.</p
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
            </div>
        </div>
    </div>
</div>
<script src="js/particles.js"></script>
<script>
  particlesJS.load('particles-js', 'particlesjs-config.json', function() {
    console.log('callback - particles.js config loaded');
  });
</script>
</body>
</html>