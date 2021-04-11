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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://apis.google.com/js/platform.js?onload=onLoad" async defer></script>

    <c:if test="${role == null}">
        <script>
          function onLoad() {
            console.log('appid: ' + "<c:out value="${appid}"/>");
            gapi.load('auth2', function() {
              auth2 = gapi.auth2.init({
                client_id: '<c:out value="${appid}"/>.apps.googleusercontent.com',
                cookiepolicy: 'single_host_origin',
                scope: 'profile email'
              });
              element = document.getElementById('googleButton');
              auth2.attachClickHandler(element, {}, onSignIn, () => console.log('smth'));
            });
          }


          function onSignIn() {
            var googleUser = gapi.auth2.getAuthInstance().currentUser.get();
            var id_token = googleUser.getAuthResponse().id_token;
            console.log("ID Token: " + id_token);

            var redirectUrl = 'signin';

            var form = $('<form name="idToken" id="idTokenId" action="' + redirectUrl + '" method="post">' +
                '<input type="text" name="idToken" value="' + googleUser.getAuthResponse().id_token + '" />' +
                '</form>');
            $('body').append(form);
            form.submit();
          }
        </script>
    </c:if>

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
                                <img src="img/tc.png" alt="kodinger logo" class="img-fluid">
                            </div>
                            <c:choose>
                                <c:when test="${role != null}">
                                    <h4 class="text-light mb-2">Hello :)</h4>
                                    <p class="lead text-light">You are already signed in as <strong>${name}</strong></p>
                                    <form action="home" method="post">
                                        <button class="btn btn-block btn-icon btn-icon-back mb-3">
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
</body>
</html>