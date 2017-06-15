'use strict';
(function () {
    //'use strict';

    angular.module('app', ['ngRoute', 'ngCookies']).config(config).run(run);
        
    config.$inject = ['$routeProvider', '$locationProvider'];
    function config($routeProvider, $locationProvider) {
        $routeProvider
            .when('/', {
                controller: 'HomeController',
                templateUrl: 'resources/home/home.view.html',
                controllerAs: 'vm'
            })
            .when('/login', {
                controller: 'LoginController',
                templateUrl: 'resources/login/login.view.html',
                controllerAs: 'vm'
            })
            .when('/register', {
                controller: 'RegisterController',
                templateUrl: 'resources/register/register.view.html',
                controllerAs: 'vm'
            })
            .otherwise({ redirectTo: '/login' });
    }
    
    run.$inject = ['$rootScope', '$location', '$cookies', '$http'];
    function run($rootScope, $location, $cookies, $http) {
        // keep user logged in after page refresh
        $rootScope.globals = $cookies.getObject('globals') || {};
        if ($rootScope.globals.currentUser) {
            $http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.globals.currentUser.authdata;
        }

        $rootScope.$on('$locationChangeStart', function (event, next, current) {
            // redirect to login page if not logged in and trying to access a restricted page
            var restrictedPage = $.inArray($location.path(), ['/login', '/register']) === -1;
            var loggedIn = $rootScope.globals.currentUser;
            if (restrictedPage && !loggedIn) {
                $location.path('/login');
            }
        });
    }

})();

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*(function(){	
	angular.module('app', ['ngRoute', 'ngCookies']).config(['$routeProvider', '$locationProvider', function($routeProvider, $locationProvider){
	    $routeProvider
	    .when('/', {
	        controller: 'HomeController',
	        templateUrl: 'resources/home/home.view.html',
	        controllerAs: 'vm'
	    })
	    .when('/login', {
	        controller: 'LoginController',
	        templateUrl: 'resources/login/login.view.html',
	        controllerAs: 'vm'
	    })
	    .when('/register', {
	        controller: 'RegisterController',
	        templateUrl: 'resources/register/register.view.html',
	        controllerAs: 'vm'
	    })
	    .otherwise({ redirectTo: '/login' });
	
	}]);
	
	angular.module('app', ['ngRoute', 'ngCookies']).config(['$routeProvider', '$locationProvider', function($routeProvider, $locationProvider){
	    function run($rootScope, $location, $cookies, $http) {
	        // keep user logged in after page refresh
	        $rootScope.globals = $cookies.getObject('globals') || {};
	        if ($rootScope.globals.currentUser) {
	            $http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.globals.currentUser.authdata;
	        }
	
	        $rootScope.$on('$locationChangeStart', function (event, next, current) {
	            // redirect to login page if not logged in and trying to access a restricted page
	            var restrictedPage = $.inArray($location.path(), ['/login', '/register']) === -1;
	            var loggedIn = $rootScope.globals.currentUser;
	            if (restrictedPage && !loggedIn) {
	                $location.path('/login');
	            }
	        });
	    }
	}])
	})
();*/
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*(function(){
	angular.module('app', ['ngRoute', 'ngCookies']).config(function($routeProvider, $locationProvider){
	    $routeProvider
	    .when('/', {
	        controller: 'HomeController',
	        templateUrl: 'resources/home/home.view.html',
	        controllerAs: 'vm'
	    })
	    .when('/login', {
	        controller: 'LoginController',
	        templateUrl: 'resources/login/login.view.html',
	        controllerAs: 'vm'
	    })
	    .when('/register', {
	        controller: 'RegisterController',
	        templateUrl: 'resources/register/register.view.html',
	        controllerAs: 'vm'
	    })
	    .otherwise({ redirectTo: '/login' });
	});
	angular.module('app', ['ngRoute', 'ngCookies']).config(function($routeProvider, $locationProvider){
	    function run($rootScope, $location, $cookies, $http) {
	        // keep user logged in after page refresh
	        $rootScope.globals = $cookies.getObject('globals') || {};
	        if ($rootScope.globals.currentUser) {
	            $http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.globals.currentUser.authdata;
	        }
	
	        $rootScope.$on('$locationChangeStart', function (event, next, current) {
	            // redirect to login page if not logged in and trying to access a restricted page
	            var restrictedPage = $.inArray($location.path(), ['/login', '/register']) === -1;
	            var loggedIn = $rootScope.globals.currentUser;
	            if (restrictedPage && !loggedIn) {
	                $location.path('/login');
	            }
	        });
	    }
	})
();*/

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*var abc = angular.module('app', ['ngRoute', 'ngCookies']);
abc.config(function($routeProvider, $locationProvider){
    $routeProvider
    .when('/', {
        controller: 'HomeController',
        templateUrl: 'resources/home/home.view.html',
        controllerAs: 'vm'
    })
    .when('/login', {
        controller: 'LoginController',
        templateUrl: 'resources/login/login.view.html',
        controllerAs: 'vm'
    })
    .when('/register', {
        controller: 'RegisterController',
        templateUrl: 'resources/register/register.view.html',
        controllerAs: 'vm'
    })
    .otherwise({ redirectTo: '/login' });
});
var ddd = angular.module('app', ['ngRoute', 'ngCookies']);
ddd.config(function($routeProvider, $locationProvider){
    function run($rootScope, $location, $cookies, $http) {
        // keep user logged in after page refresh
        $rootScope.globals = $cookies.getObject('globals') || {};
        if ($rootScope.globals.currentUser) {
            $http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.globals.currentUser.authdata;
        }

        $rootScope.$on('$locationChangeStart', function (event, next, current) {
            // redirect to login page if not logged in and trying to access a restricted page
            var restrictedPage = $.inArray($location.path(), ['/login', '/register']) === -1;
            var loggedIn = $rootScope.globals.currentUser;
            if (restrictedPage && !loggedIn) {
                $location.path('/login');
            }
        });
    }
});*/
