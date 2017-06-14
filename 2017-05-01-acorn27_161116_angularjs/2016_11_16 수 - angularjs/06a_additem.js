var app = angular.module("myShoppingList", []);
app.controller("myCtrl", function($scope) {
	 $scope.products = ["우유", "빵", "치즈"];
	 $scope.addItem = function () {
		  $scope.errortext = "";
		  if (!$scope.addMe) {return;}
		  if ($scope.products.indexOf($scope.addMe) == -1) {
				$scope.products.push($scope.addMe);
		  } else {
				$scope.errortext = "이미 쇼핑리스트에 있습니다.";
		  }
	 }
	 $scope.removeItem = function (x) {
		  $scope.errortext = "";
		  $scope.products.splice(x, 1);
	 }
});
