'use strict';

angular
    .module('myApp')
    .factory('UserService', [
        '$http',
        '$q',
        function ($http, $q) {
            var REST_SERVICE_URI = 'http://localhost:8080/mydats/user/';
            var factory = {
                createUser: createUser,
                deleteUser: deleteUser,
                fetchAllUsers: fetchAllUsers,
                updateUser: updateUser
            };
            return factory;

            function fetchAllUsers() {
                var deferred = $q.defer();
                $http
                    .get(REST_SERVICE_URI)
                    .then(function (response) {
                        deferred.resolve(response.data);
                    }, function (errResponse) {
                        console.error('Error while fetching User');
                        deferred.reject(errResponse);
                    });
                return deferred.promise;
            }
            function createUser(user) {
                var deferred = $q.defer();
                $http.post(REST_SERVICE_URI, user)
                    .then(function (response) {
                        deferred.resolve(response.data);
                    }, function (errResponse) {
                        console.error('사용자 등록 에러');
                        deferred.reject(errResponse);
                    });
                return deferred.promise;
            }
            function updateUser(user, id) {
                var deferred = $q.defer();
                $http.put(REST_SERVICE_URI + id,user)
                    .then(function (response) {
                        deferred.resolve(response.data);
                    }, function (errResponse) {
                        console.error('업데이트 에러');
                        deferred.reject(errResponse);
                    });
                return deferred.promise;
            }
            function deleteUser(id) {
                var deferred = $q.defer();
                $http
                    .delete(REST_SERVICE_URI + id)
                    .then(function (response) {
                        deferred.resolve(response.data);
                    }, function (errResponse) {
                        console.error('사용자 삭제중 에러');
                        deferred.reject(errResponse);
                    });
                return deferred.promise;
            }
        }
    ]);