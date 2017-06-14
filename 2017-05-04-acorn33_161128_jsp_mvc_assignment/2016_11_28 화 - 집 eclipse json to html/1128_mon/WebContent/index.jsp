<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>AJAX with Struts2 using AngularJS</title>
	<script type="text/javascript" src="js/angular.min.js"></script>
	<script>
		var app = angular.module('myApp',[]);
		//function MyController($scope, $http){
		app.controller('MyController', function($scope, $http){
			$scope.getDataFromServer = function(){
				$http({
					method: 'GET',
					url: 'javaAngularJS'
					//url: 'AngularJsServlet'
				}).success(function(data, status, headers, config){
					$scope.person=data;
				}).error(function(data, status, headers, config){
					// called asynchronously if an error occurs
					// or server returns response with an error status
				});
			};
		});
	</script>		
</head>

<body ng-view>
	<div ng-app="myApp">
		<div ng-controller="MyController">
			<button ng-click="getDataFromServer()">Fetch data from server</button>
			<p>First Name: {{person.firstName}}</p>
			<p>Last Name: {{person.lastName}}</p>
		</div>
	</div>

</body>
</html>