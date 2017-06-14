/*
 * In our application, we will be communicating with Server which in our example is Spring REST API based back-end. 
 * In AngularJS based applications, the preferred way to communicate with server is using AngularJS built-in $http Service. 
 * AngularJS $http service allows us to communicate with server endpoints using XHR [browser's XMLHttpRequest Object] API. 
 * 
 * The $http API is based on the deferred/promise APIs exposed by the $q service 
 * which is an implementation of Promise interface, based on Kris Kowal’s Q proposal, 
 * which is a standardized way of dealing with asynchronous calls in JavaScript.
 */

'use strict';
angular.module('myApp').factory('UserService', ['$http', '$q', function($http, $q){
												// $http, $q는 spring의 di와 동일하다.
	//var REST_SERVICE_URI = 'http://localhost:8080/1215_spring_angularjs_a/user/';
	var REST_SERVICE_URI = 'http://localhost:8080/dec_fifteen/user/';
			// uri vs url = information vs location //
			// user에 information이 들어 있다
			// RESTful 서비스는 명사로 주고 받는다.
	var factory = {
			fetchAllUsers: fetchAllUsers,
			createUser: createUser,
			updateUser: updateUser,
			deleteUser: deleteUser
	};
	
	return factory;
	
	/*function fetchAllUsers(){
		var deferred = $q.defer();	// 비동기로 작업을 가능하게 해준다
						// defer는 constructor라고 생각 
		$http.get(REST_SERVICE_URI)	// http = 데이터 송수신을 위해서 필요
			.then(
				function(response){
					deferred.resolve(response.data);
				},
				function(errResponse){
					console.error('Error while fetching Users');
					deferred.reject(errResponse);
				}
			);
		return deferred.promise;	// result of an action	// promise내에는  	resolve와 reject가 들어있다.
	} // function fetchAllUsers() 끝
*/    
	function fetchAllUsers() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching Users');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    
	function createUser(user){
		var deferred = $q.defer();
		$http.post(REST_SERVICE_URI, user)
			.then(
				function(response){
					deferred.resolve(response.data);
				},
				function(errResponse){
					console.error('사용자 등록 중 에러');
					deferred.reject(errResponse);
				}
			);
		return deferred.promise;
	}

	function updateUser(user, id){
		var deferred = $q.defer();
		$http.put(REST_SERVICE_URI+id, user)
			.then(
				function(response){
					deferred.resolve(response.data);
				},
				function(errResponse){
					console.error('사용자 수정 중 에러');
					deferred.reject(errResponse);
				}
			);
		return deferred.promise;
	}
	
	function deleteUser(id){
		var deferred = $q.defer();
		$http.delete(REST_SERVICE_URI+id)
			.then(
				function(response){
					deferred.resolve(response.data);
				},
				function(errResponse){
					console.error('사용자 삭제 중 에러');
					deferred.reject(errResponse);
				}
			);
		return deferred.promise;
	}	

}])
