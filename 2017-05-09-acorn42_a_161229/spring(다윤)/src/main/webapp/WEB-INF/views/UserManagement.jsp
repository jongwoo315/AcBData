<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>AngularJS</title>
 
<style>
.username.ng-valid {
	background-color: lightgreen;
}

.username.ng-dirty.ng-invalid-required {
	background-color: red;
}

.username.ng-dirty.ng-invalid-minlength {
	background-color: yellow;
}

.email.ng-valid {
	background-color: lightgreen;
}

.email.ng-dirty.ng-invalid-required {
	background-color: red;
}

.email.ng-dirty.ng-invalid-email {
	background-color: yellow;
}
</style>
 
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
<body ng-app="myApp" class="ng-cloak">
	
	<div class="generic-container" ng-controller="userController as ctrl">
		<div class="panel panel-default">
			<div class="panel-heading">
				<span class="lead">User Registration Form</span>
			</div>
			<div class="formcontainer">
				<form ng-submit="ctrl.join()" name="myForm" class="form-horizontal">
					<input type="hidden" ng-model="ctrl.user.id">
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="id">ID</label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.user.id" id="id" class="id form-control input-sm"
									placeholder="ID" required>
							</div>
						</div>
					</div>
					
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="pw">Password</label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.user.pw" id="pw" class="pw form-control input-sm"
									placeholder="Password" required>
							</div>
						</div>
					</div>
					
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="name">NAME</label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.user.name" id="name" class="name form-control input-sm"
									placeholder="Name" required>
							</div>
						</div>
					</div>	
					
					<div class="row">
						<div class="form-actions floatRight">
							<input type="submit" value="JOIN" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
							<button ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset</button>
						</div>
					</div>
					
				</form>
			</div>
		</div>
		
		<div class="panel panel-default">
			<div class="panel-heading"><span class="lead">List of Users</span></div>
			<div class="tablecontainer">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>NO</th>
							<th>ID</th>
							<th>NAME</th>
							<th>REGDATE</th>
							<th width="20%"></th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="u in ctrl.users">
							<td><span ng-bind="u.no"></span></td>
							<td><span ng-bind="u.id"></span></td>
							<td><span ng-bind="u.name"></span></td>
							<td><span ng-bind="u.regDate"></span></td>
							<td>
								<button ng-click="ctrl.edit(u.id)" class="btn btn-success custom-width">Edit</button>
								<button ng-click="ctrl.remove(u.id)" class="btn btn-danger custom-width">Remove</button>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
	<script src="<c:url value='/static/js/app.js' />"></script>
	<script src="<c:url value='/static/js/service/userService.js' />"></script>
	<script src="<c:url value='/static/js/controller/userController.js' />"></script>
</body>
</html>