window.onload = function() {
}
var scrumUser = {}

angular
		.module('jabrApp', [ 'ngRoute' ])

		.config(function($routeProvider) {
			$routeProvider.when("/", {
				templateUrl : "resources/features/login.html",
				controller : "loginCtrl"
			}).when("/homePage", {
				templateUrl : "resources/features/homePage.html",
				controller : "homeController"
			}).otherwise({
				redirectTo : '/'
			})
		})

		.controller('indexController', function() {
		})

		.controller('homeController', function($scope) {
			$scope.scrumUser = scrumUser;
		})

		.controller(
				"loginCtrl",
				function($scope, $http, $location) {
					$scope.submit = function() {
						var data = $.param({
							username : $scope.username,
							password : $scope.password
						});
						var config = {
							headers : {
								'Content-Type' : 'application/x-www-form-urlencoded;charset=utf-8;'
							}
						}
						$http.post('login', data, config).then(
								function(response) {
									scrumUser = response.data;
									$location.path('/homePage');
								}, function(response) {
									scrumUser = response;
									console.log(response);
								});
					};

				});
