window.onload = function() {
}
var scrumUser = {};
var boardNumber = 2;

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
			}).when("/addTask", {
				templateUrl : "resources/features/addTask.html",
				controller : "addTaskCtrl"
			}).when("/addStory", {
				templateUrl : "resources/features/addStory.html",
				controller : "addStoryCtrl"
			}).when("/logs", {
				templateUrl : "resources/features/logs.html",
				controller : "logsCtrl"
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
				template : "",
				controller : "boardDropDownCtrl"
			}).when("/addAUser", {
				templateUrl : "resources/features/addUser.html",
				controller : "addUserCtrl"
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
			$scope.addABoard = function() {
				$location.path('/addBoard');
			}
			$scope.addAStory = function() {
				$location.path('/addStory');
			}
			$scope.listLogs = function() {
				$location.path('/logs');
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
				boardNumber = boardId;
				$location.path('/boardDetail');
			}
			$scope.addUser = function(boardId) {
				boardNumber = boardId;
				$location.path('/addAUser');
			}
			$http.get('listBoards').then(function(response) {
				$scope.boards = response.data;
			}, function(response) {
				console.log(response);
			});
		})

		.controller('logsCtrl', function($scope, $http, $location) {
			$scope.scrumUser = scrumUser;
			$http.get('allLogs').then(function(response) {
				$scope.logs = response.data;
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

		.controller('boardDetailsCtrl', function($scope, $http, $location) {
			$scope.scrumUser = scrumUser;
			var data = $.param({
				boardId : boardNumber
			});
			var config = {
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded;charset=utf-8;'
				}
			}
			//gets all the details for this board except users
			$http.post('boardDetails', data, config).then(
					function(response) {
						$scope.boardDetail = response.data;
					}, function(response) {
						console.log(response);
					});
					var config = {
						headers : {
							'Content-Type' : 'application/x-www-form-urlencoded;charset=utf-8;'
						}
					}
						// need a separate call to get user list - not part of board
					// to prevent JSON infinite recursion
					$http.get('boardUsers').then(function(response) {
						$scope.boardUsers = response.data;
					}, function(response) {
						console.log(response);
					});
					$http.get('allUsers').then(function(response) {
						$scope.allUsers = response.data;
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
		
		.controller('addStoryCtrl', function($scope, $http, $location) {
			$scope.scrumUser = scrumUser;
			$http.get('listBoards').then(function(response) {
				$scope.boards = response.data;
			}, function(response) {
				console.log(response);
			});
			$http.get('listLanes').then(function(response) {
				$scope.lanes = response.data;
			}, function(response) {
				console.log(response);
			});
			$scope.submit = function() {
				var data = $.param({
					boardId : $scope.storyboard,
					laneTypeId : $scope.storylane,
					storyName : $scope.storyname,
					storyPoints : $scope.storypoint,
					storyDesc : $scope.storydescription
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

		.controller(
				"addUserCtrl",
				function($scope, $http, $location) {
					$scope.scrumUser = scrumUser;
					var data = $.param({
						boardId : boardNumber
					});
					var config = {
						headers : {
							'Content-Type' : 'application/x-www-form-urlencoded;charset=utf-8;'
						}
					}
					// gets all the details for this board except users
					$http.post('boardDetails', data, config).then(
							function(response) {
								$scope.boardDetail = response.data;
							}, function(response) {
								console.log(response);
							});
					// need a separate call to get user list - not part of board
					// to prevent JSON infinite recursion
					$http.get('boardUsers').then(function(response) {
						$scope.boardUsers = response.data;
					}, function(response) {
						console.log(response);
					});
					$http.get('usersNotOnBoard').then(function(response) {
						$scope.allUsers = response.data;
					}, function(response) {
						console.log(response);
					});
					$scope.addTheUser = function(userId) {
						var data = $.param({
							scrumUserId : userId
						});
						var config = {
							headers : {
								'Content-Type' : 'application/x-www-form-urlencoded;charset=utf-8;'
							}
						}
						$http.post('newUser', data, config).then(
								function(response) {
									$location.path('/boardDetail');
								}, function(response) {
									console.log(response);
								});
					};
				})
		.controller(
				"addTaskCtrl",
				function($scope, $http, $location) {
					$scope.scrumUser = scrumUser;
					$scope.addTask = function() {
						var data = $.param({
							description : $scope.taskDescription
							
							
						});
						var config = {
							headers : {
								'Content-Type' : 'application/x-www-form-urlencoded;charset=utf-8;'
							}
						}
						$http.post('newTask', data, config).then(
								function(response) {
									$location.path('/homePage');
								}, function(response) {
									console.log(response);
								});
					};

				})
