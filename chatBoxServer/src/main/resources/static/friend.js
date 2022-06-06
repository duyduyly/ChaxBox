/**
 * 
 */
 var app = angular.module('myapp', []);
app.controller('ctrl', function($scope, $http,$timeout) {

	$scope.urlCurrent = "http://"+window.location.host;
	console.log($scope.urlCurrent);
				
	
	//Get List Friend
	$scope.allFriend= [];
	$http.get($scope.urlCurrent+"/api/friendList")
		.then(function(response) {
			$scope.allFriend = response.data;
		});
	
	$scope.getAllFrined = function getFriend(){
		$http.get($scope.urlCurrent+"/api/friendList")
		.then(function(response) {
			$scope.allFriend = response.data;
		});
	}
	
	//post
	//send request Make Friend
	$scope.makeFriend = function send(id) {
		$http({
			method: "POST",
			url: $scope.urlCurrent+"/api/makeFriend",
			data: id
		}).then(function mySuccess(response) {
			$scope.myMessage = response.data;

			console.log($scope.myMessage);
			
		}, function myError(response) {
			$scope.myWelcome = response.statusText;
		});
	
	}
	
	
	
	//auto reload page to update data
	$scope.reload1 = function reload(){
		
			console.log('reloadt');
			$timeout($scope.reload1,3000);
			$scope.getAllFrined();
	}
	$timeout($scope.reload1,3000);

});


