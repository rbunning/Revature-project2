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
			}).when("/addBoard", {
				templateUrl : "resources/features/addBoard.html",
				controller : "addBoardCtrl"
			}).when("/addStory", {
				templateUrl : "resources/features/addStory.html",
				controller : "addStoryCtrl"
			}).otherwise({
				redirectTo : '/'
			})
		})

		.controller('indexController', function() {
		})

		.controller('homeController', function($scope) {
			$scope.scrumUser = scrumUser;
			console.log("before test: "+scrumUser);
			console.log("test from homeCtrl: " + $scope.scrumUser);
			
		})

		.controller(
				"loginCtrl",
				function($scope, $http, $location) {
					$scope.submit = function() {
						var data = $.param({
							scrumUserUsername : $scope.username,
							scrumUserPassword : $scope.password
						});
						var config = {
							headers : {
								'Content-Type' : 'application/x-www-form-urlencoded;charset=utf-8;'
							}
						}
						$http
								.post('login', data, config)
								.then(
										function(response) {
											scrumUser = response.data;
											$location.path('/homePage');
										},
										function(response) {
											$scope.errorMessage = 'Incorrect username or password. Please try again.';
											scrumUser = response;
											console.log(response);
										});
					};

				})

		.controller(
				"addBoardCtrl",
				function($scope, $http, $location) {
					$scope.submit = function() {
						var data = $.param({
							boardName : $scope.boardname
						});
						var config = {
							headers : {
								'Content-Type' : 'application/x-www-form-urlencoded;charset=utf-8;'
							}
						}
						$http.post('newBoard', data, config).then(
								function(response) {
									scrumUser = response.data;
									console.log(scrumUser);
									$scope.scrumUser = scrumUser;
									$location.path('/homePage');
								}, function(response) {
									console.log(response);
								});
					};

				})

		.controller(
				"addStoryCtrl",
				function($scope, $http, $location) {
					$scope.submit = function() {
						var data = $.param({
							storyname = $scope.storyname,
							storydescription = $scope.storydescription,
							storyname = $scope.storyname
						});
						var config = {
							headers : {
								'Content-Type' : 'application/x-www-form-urlencoded;charset=utf-8;'
							}
						}
						$http.post('newStory', data, config).then(
								function(response) {
									$location.path('/homePage');
								}, function(response) {
									console.log(response);
								});
					};

				})
