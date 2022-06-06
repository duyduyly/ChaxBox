var app = angular.module('myapp', []);
app.controller('ctrl', function($scope, $http,$timeout) {

	$scope.urlCurrent = "http://"+window.location.host;
				console.log($scope.urlCurrent);
	$http.get($scope.urlCurrent+"/api/list-Friend")
		.then(function(response) {
			$scope.myFriend = response.data;

			$scope.myFriend.forEach(element => {
				console.log(element);
			});


		});
		
	$scope.myMessage = [];
	$scope.idClick;
	$scope.click = function click(id) {
		$scope.idClick = id;
		console.log(id)
		$http({
			method: "GET",
			url: $scope.urlCurrent+"/api/listMy-Message?id=" + id,
			data: id
		}).then(function mySuccess(response) {
			$scope.myMessage = response.data;
			$scope.myMessage.forEach(element => {
				console.log(element);
			});

		}, function myError(response) {
			$scope.myWelcome = response.statusText;
		});
		
	}

	$scope.message;
	$scope.sendMessage = function send(message) {
		$http({
			method: "POST",
			url: $scope.urlCurrent+"/api/Send-Message",
			data: message
		}).then(function mySuccess(response) {
			$scope.myMessage = response.data;

			console.log($scope.myMessage);
			

		}, function myError(response) {
			$scope.myWelcome = response.statusText;
		});
		$scope.message = ''
	}
	
	$scope.reload1 = function reload(){
		
		
		if($scope.idClick != null){
			$scope.click($scope.idClick);
			console.log('update');
			$timeout($scope.reload1,3000);
		}else{
			console.log('reloadt');
			$timeout($scope.reload1,3000);
		}
	}
	$timeout($scope.reload1,3000);

});


