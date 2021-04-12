<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<c:set var = "role" scope = "session" value = '<%= session.getAttribute("role") %>'/>
<c:set var = "name" scope = "session" value = '<%= session.getAttribute("name") %>'/>
<s:eval expression="@environment.getProperty('google.appid')" var="appid"/>
<!DOCTYPE html>
<html>
<head>
    <title>Sign  in</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <meta name="google-signin-scope" content="profile email">
    <meta name="google-signin-client_id" content="${appid}.apps.googleusercontent.com">
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/login.css">
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
                            <c:choose>
                                <c:when test="${role != null}">
                                    <h4 class="text-light mb-2">Hello :)</h4>
                                    <p class="lead text-light">You are already signed in as <strong>${name}</strong></p>
                                    <form action="home" method="post">
                                        <button id="homeButton" class="btn btn-block btn-icon btn-icon-back mb-3">
                                            Home
                                        </button>
                                    </form>
                                </c:when>
                                <c:otherwise>
                                    <h4 class="text-light mb-2">Welcome :)</h4>
                                    <p class="lead text-light">Sign in below</p>
                                    <button id="googleButton" class="btn btn-block btn-icon btn-icon-google mb-3">
                                        Login With Google
                                    </button>
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
                                    <p class="lead">We currently don't have another signing methods.
                                        Just try to login with your google account.
                                        If you don't have a Google Account but do have an email address, you can create a Google account using that email address.
                                        If you don't have an email address, you can create one with Gmail,
                                        at <a href="https://accounts.google.com/SignUp">https://accounts.google.com/SignUp</a>
                                        If you're already using a Google product such as Gmail, for example, then you have a Google Account.
                                        If you're not sure you've signed up for any Google products, you can check by visiting
                                        the <a href="https://accounts.google.com/signin/v2/usernamerecovery">Google Accounts password change page</a>.
                                        Enter any email address you think you might've used to create a Google Account.</p>
                                </c:when>
                                <c:otherwise>
                                    <h2>You are welcome! Now let's visit home page</h2>
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

<script type="text/javascript">
  document.getElementById("googleButton").onclick = function () {
    location.href = "https://accounts.google.com/o/oauth2/v2/auth/oauthchooseaccount?redirect_uri=http%3A%2F%2Flocalhost%3A8080%2Foauth&prompt=consent&response_type=code&client_id=${appid}.apps.googleusercontent.com&scope=email%20openid%20openid%20https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.profile";
  };
</script>
</body>
</html>