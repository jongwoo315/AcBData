'use strict'
 
angular.module('myApp').controller('userController', ['$scope', 'userService', function($scope, userService) {
	
	var self = this;
	
	self.user = {
			no:null,
			id:'',
			pw:'',
			name:'',
			regDate:''
	}
	
	self.users = [];
	self.join = join;
	self.edit = edit;
	self.remove = remove;
	self.reset = reset;
	
	selectAllUser();
	
	function selectAllUser() {
		userService.selectAllUser().then(function(d){
			self.users = d;
		}, function(errResponse) {
			console.error("selectAllUser Controller Error")
		});
	}
	
	function insertUser(user) {
		userService.insertUser(user).then(selectAllUser, function(errResponse){
			console.error("insertUser Contoller Error");
		});
	}
	
	function updateUser(user, id) {
		userService.updateUser(user, id).then(fetchAllUser, function(errResponse){
			console.error("updateUser Controller Error");
		});
	}
	
	function deleteUser(id) {
		userService.deleteUser(id).then(selectAllUser, function(errResponse){
			console.error("deleteUser Controller Error");
		});
	}
	
	function join() {
		console.log("join Controller.js", self.user);
		insertUser(self.user);
		
		reset();
	}
	
	function edit(id) {
		console.log("edit Controller.js", id);
		
		for(var i=0; i<self.users.length; i++) {
			if(self.users[i].id===id) {
				self.user = angular.copy(self.users[i]);
				break;
			}
		}
		
		
	}
	
	function remove(id) {
		console.log("removce Controller.js", id);
		
		if(self.user.id==id) {
			reset();
		}
		
		deleteUser(id);
	}
	
	function reset() {
		self.user = {
				no:null,
				id:'',
				pw:'',
				name:''
		};
		
		$scope.myForm.$setPristine();
	}
}]);