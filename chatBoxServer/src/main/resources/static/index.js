var app = angular.module('myapp', []);
app.controller('ctrl', function($scope, $http,$timeout) {

	$scope.urlCurrent = "http://"+window.location.host;
				console.log($scope.urlCurrent);
				
				
	// get List my Friend
	$scope.myFriend = [];
	$http.get($scope.urlCurrent+"/api/list-Friend")
		.then(function(response) {
			$scope.myFriend = response.data;

			console.log("lenght: "+$scope.myFriend.length);
			//$scope.myFriend.forEach(element => {
			//	console.log(element);
			//});
			for(var i = 0;i<$scope.myFriend.length;i++){
			
			console.log("FriendWith: "+$scope.myFriend[i].id);
			
			
		}
		console.log($scope.myMessage)

		});
		
	//function get List Friend to reload each 3secons
	$scope.getMyListFriend = function getmyListFriend(){
		$http.get($scope.urlCurrent+"/api/list-Friend")
		.then(function(response) {
			$scope.myFriend = response.data;

			console.log("lenght: "+$scope.myFriend.length);
			//$scope.myFriend.forEach(element => {
			//	console.log(element);
			//});
			for(var i = 0;i<$scope.myFriend.length;i++){
			
			console.log("FriendWith: "+$scope.myFriend[i].id);
			
			
		}
		console.log($scope.myMessage)

		});
	}	
	
	//get All Friend @reuturn Customer my Friend
	$scope.myCustomer= [];
	$http.get($scope.urlCurrent+"/api/myCustomer")
		.then(function(response) {
			$scope.myCustomer = response.data;


		});
		
		
	//Open Message Between your and my friend
	$scope.idActive = 0;
	$scope.myMessage = [];
	$scope.idClick;
	$scope.click = function click(id) {
		$scope.idClick = id;
		$scope.idActive = id;
		console.log(id)
		$http({
			method: "GET",
			url: $scope.urlCurrent+"/api/listMy-Message?id=" + id,
			data: id
		}).then(function mySuccess(response) {
			$scope.myMessage = response.data;
			//$scope.myMessage.forEach(element => {
				//console.log(element);
			//});
			
		}, function myError(response) {
			$scope.myWelcome = response.statusText;
		});
		
	}
	
	//send message
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
	
	
	//Get List Friend
	$scope.allFriend= [];
	$http.get($scope.urlCurrent+"/api/friendList")
		.then(function(response) {
			$scope.allFriend = response.data;
		});
	
	
	//send request Make Friend
	
	
	
	//auto reload page to update data
	$scope.reload1 = function reload(){
		
		if($scope.idClick != null){
			$scope.click($scope.idClick);
			console.log('update');
			$timeout($scope.reload1,3000);
			
			$scope.getMyListFriend();
		}else{
			console.log('reloadt');
			$timeout($scope.reload1,3000);
			$scope.getMyListFriend();
		}
	}
	$timeout($scope.reload1,3000);

});


