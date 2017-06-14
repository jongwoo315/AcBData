
var mainApp=angular.module("mainApp",['ngRoute']); /* angular.js module */

mainApp.config(['$routeProvider',function($routeProvider){ /* router 1.CRUD 2.VIEW */
	   $routeProvider
	   .when('/Student_info',{
	      templateUrl: 'Student_info.html',
	      controller: 'StudentController'
	   }).
	   when('/viewScore_info',{
	      templateUrl: 'viewScore_info.html',
	      controller: 'ScoreController'
	   }).
	   otherwise({
	      redirectTo: 'Student_info'
	   });
}]);

mainApp.controller('StudentController', function($scope, $http){ /* CRUD(입력,수정,삭제)영역을 위한 컨트롤러 */
      $http({ /* Oracle DB로 부터 데이터를 가져온다. */
            method : 'GET',
            url : 'selectProcess_Jsontype',
            headers : {'Content-Type' : 'application/json'}
         }).success(function(data, status, headers, config){
            $scope.scores = data;
         }).error(function(data, status, headers, config){
         });

      $scope.input_reset = function(){ /* 리셋 버튼을 클릭하면 -> 입력창 : 이름, 국어, 영어, 수학 초기화시킨다 */
      	$scope.user.name=""; $scope.user.kor_score=""; $scope.user.eng_score=""; $scope.user.math_score="";
      }

      $scope.setSelected = function(idx){ /* DB에서 불러온 각 행과 연동되어 클릭한 행에 대한 정보를 담고 있으며, 편집 가능한 모달을 열어준다. */
	      $scope.selected = [];
	      angular.copy($scope.scores[idx], $scope.selected);
	      $('#editModal').modal();
	      $scope.pass=1234;

	      $scope.update_student = function() { /* update에 대한 함수이다. */
	         if($scope.pass!=$scope.password){ /* password 일치여부 확인 */
	               alert("Wrong Password!! please check again");
	               return;
	         };
	         $http({ /* updateProcess로 비동기식 데이터 전송 */
	          method : 'POST',
	          url : 'updateProcess',
	          data : $.param({
	             id : $scope.selected.id,
	             name : $scope.selected.name,
	              kor_score : $scope.selected.kor_score,
	              eng_score : $scope.selected.eng_score,
	              math_score : $scope.selected.math_score
	         }),
	         headers : {'Content-Type' : 'application/x-www-form-urlencoded; charset= UTF-8'}
	         }).success(function(data){
	          	console.log(data)
	         }).error(function(data){
  	          	console.log(data)
	         });
	         console.log("POST done");

	         $http({ /* 데이터 불러온다 ===>따라서 화면이 리프레쉬 되지 않으면서 자료가 수정 된다.  */
	           method : 'GET',
	           url : 'selectProcess_Jsontype',
	           headers : {'Content-Type' : 'application/json'}
	         }).success(function(data, status, headers, config){
	           $scope.scores = data;
	         }).error(function(data, status, headers, config){
	         });

	         $scope.password=""; /* 비밀번호 치는 창 초기화 안해줄시에 모달 다시 오픈했을때 그대로 남아있다. */
	         $('#editModal').modal('hide'); /* 모달 숨김 이펙트 */
	      };//update

         $scope.delete_student = function() { /* delete에 대한 함수이다. */
             if($scope.pass!=$scope.password){ /* password 일치여부 확인 */
                     alert("Wrong Password!! please check again");
                     return;
                  };
             $http({ /* deleteProcess로 비동기식 데이터 전송 */
                method : 'POST',
                url : 'deleteProcess',
                data : $.param({
                   id : $scope.selected.id,
                }),
                headers : {'Content-Type' : 'application/x-www-form-urlencoded; charset= UTF-8'}
             }).success(function(data){
                console.log(data)
             }).error(function(data){
                console.log(data)
             });
             console.log("POST done");

            $http({ /* 데이터 불러온다 ===>따라서 화면이 리프레쉬 되지 않으면서 자료가 삭제 된다. */
                   method : 'GET',
                   url : 'selectProcess_Jsontype',
                   headers : {'Content-Type' : 'application/json'}
                }).success(function(data, status, headers, config){
                   $scope.scores = data;
                }).error(function(data, status, headers, config){
                });

            $scope.password="";
            $('#editModal').modal('hide');
         }; //delete
      }; //getselected

      $scope.user = [];
      $scope.insert_student = function() {
         $http({
            method : 'POST',
            url : 'registerProcess',
            data : $.param({
                name : $scope.user.name,
                kor_score : $scope.user.kor_score,
                eng_score : $scope.user.eng_score,
                math_score : $scope.user.math_score
            }),
            headers : {'Content-Type' : 'application/x-www-form-urlencoded; charset= UTF-8'}
         }).success(function(data){
            console.log(data)
         }).error(function(data){
            console.log(data)
         });
         console.log("POST done");
         $http({
                method : 'GET',
                url : 'selectProcess_Jsontype',
                headers : {'Content-Type' : 'application/json'}
             }).success(function(data, status, headers, config){
                $scope.scores = data;
             }).error(function(data, status, headers, config){
             });
            $scope.input_reset();
      };
}); // StudentController

mainApp.controller('ScoreController',function($scope, $http){ /* VIEW 영역을 위한 컨트롤러 */
	   $http({
	      	method : 'GET',
	         url : 'selectProcess_Jsontype',
	         headers : {'Content-Type' : 'application/json'}
	      }).success(function(data, status, headers, config){
	         $scope.scores = data;
	      }).error(function(data, status, headers, config){
	      });
    	$scope.sortType = 'id';
    	$scope.sortReverse = false;
});
