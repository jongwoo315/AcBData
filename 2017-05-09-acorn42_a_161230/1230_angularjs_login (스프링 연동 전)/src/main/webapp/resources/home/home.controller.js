(function () {
    'use strict';

    angular
        .module('app')
        .controller('HomeController', HomeController);

    HomeController.$inject = ['UserService', '$rootScope'];
    function HomeController(UserService, $rootScope) {
        var vm = this;

        /*vm.user = {id:null, username:'' ,firstName:'' ,lastName:'' ,password:''};*/
        vm.user = null;
        vm.allUsers = [];
        vm.deleteUser = deleteUser;

        initController();

        function initController() {
            loadCurrentUser();
            loadAllUsers();
            //console.log(vm.user); //null값출력
            //console.log(users); //users not defined
            //console.log(vm.allUsers); // [] 출력
            //console.log(allUsers);
           console.log(localStorage.users); //전체 저장된 값들 출력!!	//찍히는 값은 register.view.html에서 ng-model 선언 순서
        }

        function loadCurrentUser() {
            UserService.GetByUsername($rootScope.globals.currentUser.username)
                .then(function (user) {
                    vm.user = user;
                });
        }

        function loadAllUsers() {
            UserService.GetAll()
                .then(function (users) {
                    vm.allUsers = users;
                });
        }

        function deleteUser(id) {
            UserService.Delete(id)
            .then(function () {
                loadAllUsers();
            });
        }
    }

})();
