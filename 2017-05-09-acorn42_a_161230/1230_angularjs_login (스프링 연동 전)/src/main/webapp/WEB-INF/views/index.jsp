<!DOCTYPE html>
<html ng-app="app">
<head>
    <meta charset="utf-8" />
    <title>AngularJS User Registration and Login Example</title>
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" />
    <link href="resources/app-content/app.css" rel="stylesheet" />
</head>
<body>
    <div class="jumbotron">
        <div class="container">
            <div class="col-sm-8 col-sm-offset-2">
                <div ng-class="{ 'alert': flash, 'alert-success': flash.type === 'success', 'alert-danger': flash.type === 'error' }" ng-if="flash" ng-bind="flash.message"></div>
                <div ng-view></div>
            </div>
        </div>
    </div>
    <div class="credits text-center">
        <p>
            <a href="http://jasonwatmore.com/post/2015/03/10/angularjs-user-registration-and-login-example-tutorial">AngularJS User Registration and Login Example</a>
        </p>
        <p>
            <a href="http://jasonwatmore.com">JasonWatmore.com</a>
        </p>
    </div>

    <!-- <script src="//code.jquery.com/jquery-3.1.1.min.js"></script>
    <script src="//code.angularjs.org/1.6.0/angular.min.js"></script>
    <script src="//code.angularjs.org/1.6.0/angular-route.min.js"></script>
    <script src="//code.angularjs.org/1.6.0/angular-cookies.min.js"></script> -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.6.1/angular.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.6.1/angular-route.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.6.1/angular-cookies.min.js"></script>



    <%-- <script src="<c:url value='/resources/app.js'/>"></script> --%>
    <script src="resources/app.js"></script>
    <script src="resources/app-services/authentication.service.js"></script>
    <script src="resources/app-services/flash.service.js"></script>
    <!-- <script src="/resources/app-services/flash.service.js"></script> -->

    <!-- Real user service that uses an api -->
    <!-- <script src="app-services/user.service.js"></script> -->

    <!-- Fake user service for demo that uses local storage -->
    <script src="resources/app-services/user.service.local-storage.js"></script>

    <script src="resources/home/home.controller.js"></script>
    <script src="resources/login/login.controller.js"></script>
    <script src="resources/register/register.controller.js"></script>
</body>
</html>