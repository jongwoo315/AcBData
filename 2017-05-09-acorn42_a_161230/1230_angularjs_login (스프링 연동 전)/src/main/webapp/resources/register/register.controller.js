(function () {
    'use strict';

    angular
        .module('app')
        .controller('RegisterController', RegisterController);

    RegisterController.$inject = ['UserService', '$location', '$rootScope', 'FlashService'];
    function RegisterController(UserService, $location, $rootScope, FlashService) {
        var vm = this;

        vm.register = register;

        function register() {
        	//console.log(vm.user); 입력되기 전에도 등록한 값이 출력됨
            vm.dataLoading = true;
            UserService.Create(vm.user)
                .then(function (response) {
                    if (response.success) {
                        FlashService.Success('Registration successful', true);
                        $location.path('/login');
                    } else {
                        FlashService.Error(response.message);
                        vm.dataLoading = false;
                    }
                });
                console.log(vm.user);  //여기에는 id가 찍히지 않으
                //console.log(vm.users); //콘솔창: undefined
                //console.log(users);	   //콘솔창: 오류발생
                /*console.log(localStorage.users);*/
        }
    }

})();
