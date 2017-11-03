window.onload = function() {
}
var scrumUser = {};
var boardStuff = {};

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
			}).when("/boardDetail", {
				templateUrl : "resources/features/boardDetails.html",
				controller : "boardDetailsCtrl"
			}).when("/boardInfo", {
				templateUrl : "resources/features/fragments/boardInfo.html",
				controller : "boardInfoCtrl"
			}).when("/boardDropDown", {
				template: "",
				controller : "boardDropDownCtrl"
			}).otherwise({
				redirectTo : '/'
			})
		})

		.controller('indexController', function() {
		})

		.controller('navbarController', function($scope, $http, $location) {
			$scope.scrumUser = scrumUser;
			if ($scope.scrumUser.roleId.roleId == 2) {
				$scope.isScrumMaster = true;
			}
			$scope.boardDropDown = function() {
				$location.path('/boardDropDown');
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
			$scope.logout = function() {
				$location.path('/');
			}
			$scope.boardDetails = function(boardId) {
				$location.path('/boardDetail');
			}
			$scope.boardInfo = function() {
				$location.path('/boardInfo')
			}
			$http.get('listBoards').then(function(response) {
				$scope.boards = response.data;
			}, function(response) {
				console.log(response);
			});
		})

		.controller('boardInfoCtrl', function($scope, $http, $location) {
			$scope.scrumUser = scrumUser;
			$http.get('listBoards').then(function(response) {
				$scope.boards = response.data;
			}, function(response) {
				console.log(response);
			});
		})
		
		.controller('boardDropDownCtrl', function($scope, $http, $location) {
			$scope.scrumUser = scrumUser;
			$http.get('listBoards').then(function(response) {
				$scope.boards = response.data;
			}, function(response) {
				console.log(response);
			});
		})

		.controller(
				'boardDetailsCtrl',
				function($scope, $http, $location) {
					$scope.scrumUser = scrumUser;
					var data = $.param({
						boardId : '2' // $scope.boardid
					});
					var config = {
						headers : {
							'Content-Type' : 'application/x-www-form-urlencoded;charset=utf-8;'
						}
					}
					// need a separate call to get user list - not part of board
					// to prevent JSON infinite recursion
					// $http.post('boardUsers', data, config).then(
					// function(response) {
					// $scope.users = response.data;
					// }, function(response) {
					// console.log(response);
					// });
					// gets all the details for this board except users
					$http.post('boardDetails', data, config).then(
							function(response) {
								$scope.boardDetail = response.data;
								boardStuff = response.data;
							}, function(response) {
								console.log(response);
							});
				})

		.controller('listBoardCtrl', function($scope, $http, $location) {
			$scope.scrumUser = scrumUser;
			$http.get('listBoards').then(function(response) {
				$scope.boards = response.data;
			}, function(response) {
				console.log(response);
			});
		})

		.controller('homeController', function($scope, $location) {
			$scope.scrumUser = scrumUser;
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

		.controller(
				"addBoardCtrl",
				function($scope, $http, $location) {
					$scope.scrumUser = scrumUser;
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
