window.onload = function() {
}
var scrumUser = {};

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
			}).when("/listBoard", {
				templateUrl : "resources/features/listBoard.html",
				controller : "listBoardCtrl"
			}).otherwise({
				redirectTo : '/'
			})
		})

		.controller('indexController', function() {
		})

		.controller('listBoardCtrl', function($scope, $http, $location) {
			$scope.scrumUser = scrumUser;
			if ($scope.scrumUser.roleId.roleId == 2) {
				$scope.isScrumMaster = true;
			}
			$scope.addABoard = function() {
				$location.path('/addBoard');
			}
			$scope.listBoards = function() {
				$location.path('/listBoard');
			}
			$scope.home = function() {
				$location.path('/homePage');
			}
			$http.get('listBoards').then(
					function(response) {
						$scope.boards = response.data;
					}, function(response) {
						console.log(response);
					});
		})

		.controller('homeController', function($scope, $location) {
			$scope.scrumUser = scrumUser;
			if ($scope.scrumUser.roleId.roleId == 2) {
				$scope.isScrumMaster = true;
			}
			$scope.addABoard = function() {
				$location.path('/addBoard');
			}
			$scope.listBoards = function() {
				$location.path('/listBoard');
			}
			$scope.home = function() {
				$location.path('/homePage');
			}
		})

		.controller("loginCtrl", function($scope, $http, $location) {
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
				$http.post('login', data, config).then(
					function(response) {
						scrumUser = response.data;
						$scope.scrumUser = scrumUser;
						$location.path('/homePage');
					},
					function(response) {
						$scope.errorMessage = 'Incorrect username or password. Please try again.';
						scrumUser = response;
						console.log(response);
					});
			};
		})

		.controller("addBoardCtrl",	function($scope, $http, $location) {
			$scope.scrumUser = scrumUser;
			if ($scope.scrumUser.roleId.roleId == 2) {
				$scope.isScrumMaster = true;
			}
			$scope.addABoard = function() {
				$location.path('/addBoard');
			}
			$scope.listBoards = function() {
				$location.path('/listBoard');
			}
			$scope.home = function() {
				$location.path('/homePage');
			}
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
							$location.path('/homePage');
						}, function(response) {
							console.log(response);
						});
			};

		})
