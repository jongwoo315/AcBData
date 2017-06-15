'use strict'
 
angular.module('myApp').factory('userService', ['$http', '$q', function($http, $q) {
	
	var REST_SERVICE_URI = "http://localhost:8080/web/join";
	
	var factory = {
			insertUser:insertUser,
			deleteUser:deleteUser,
			selectAllUser:selectAllUser,
			updateUser:updateUser
	};
	
	return factory;
	
	function selectAllUser() {
		var deferred = $q.defer();
		$http.get(REST_SERVICE_URI).then(function(response){
			deferred.resolve(response.data);
		}, function(errResponse) {
			console.error("selectAllUser Service Error");
			deferred.reject(errResponse);
		});
		
		return deferred.promise;
	}
	
	function insertUser(user) {
		var deferred = $q.defer();
		$http.post(REST_SERVICE_URI).then(function(response){
			deferred.resolve(response.date);
		}, function(errResponse) {
			console.error("insertUser Service Error");
			deferred.reject(errResponse);
		});
		
		return deferred.promise;
	}
	
	function updateUser(user, id) {
		var deferred = $q.defer();
		$http.post(REST_SERVICE_URI+id, user).then(function(response){
			deferred.resolve(response.date);
		}, function(errResponse) {
			console.error("updateUser Service Error");
			deferred.reject(errResponse);
		});
		
		return deferred.promise;
	}
	
	function deleteUser(id) {
		var deferred = $q.defer();
		$http.delete(REST_SERVICE_URI+id).then(function(response){
			deferred.resolve(response.data);
		}, function(errResponse) {
			console.error("deleteUser Service Error");
			deferred.reject(errResponse);
		});
		
		return deferred.promise;
		 
	}
}]);