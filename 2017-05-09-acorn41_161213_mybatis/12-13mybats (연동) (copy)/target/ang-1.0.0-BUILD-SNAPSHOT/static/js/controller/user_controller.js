'use strict';

angular.module('myApp').controller('UserController',['$scope','UserService',function($scope, UserService) {
					var self = this;
					self.user = {id:null,username:'',address:'',email:''};
					self.users = [];

					self.submit = submit;
					self.edit = edit;
					self.remove = remove;
					self.reset = reset;

					fetchAllUsers();

					function fetchAllUsers() {
						UserService.fetchAllUsers().then(function(d) {
							self.users = d;
						}, function(errResponse) {
							console.error('사용자 표시중 에러');
						});
					}
					function createUser(user) {
						UserService.createUser(user)
						.then(fetchAllUsers,
								function(errResponse) {
									console.error('사용자 생성중 에러');
								});
					}
					function updateUser(user,id) {
						UserService.updateUser(user,id).then(fetchAllUsers,
								function(errResponse) {
									console.error('업데이트중 에러');
								});
					}
					function deleteUser(id) {
						UserService.deleteUser(id).then(fetchAllUsers,
								function(errResponse) {
									console.error('사용자 삭제 중 에러');
								});
					}
					function submit() {
						if (self.user.id === null) {
							console.log('새 사용자 저장', self.user);
							createUser(self.user);
						} else {
							updateUser(self.user, self.user.id);
							console.log('아이디로 사용자 저장', self.user.id);
						}
						reset();
					}
					function edit(id) {
						console.log('id 수정 됨', id);
						for (var i = 0; i < self.users.length; i++) {
							if (self.users[i].id === id) {
								self.user = angular.copy(self.users[i]);
								break;
							}
						}
					}
					function remove(id) {
						console.log('id 삭제 됨', id);
						if (self.user.id === id) {

							reset();
						}
						deleteUser(id);
					}
					function reset(){
						self.user = {id:null, username:'', address:'', email:''};
						$scope.myForm.$setPristine();
					}
				} ])