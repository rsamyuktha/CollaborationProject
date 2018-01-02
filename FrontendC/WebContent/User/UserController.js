myapp.controller("UserController",function($scope,$http,$location)
{
$scope.user={ username:'',password:'',role:'',firstname:'',lastname:'',emailId:'',isonline:''};
$scope.registerUser=function()
{
	console.log('Entered into registered user');
	$http.post('http://localhost:8083/RestController/registerUser',$scope.user)
    .then(function(response)
{
     
    	console.log('successfully registered....');

});
}
$scope.login=function()
{
	console.log('login function..');
	$http.post('http://localhost:8083/RestController/registerUser',$scope.user)
    .then(function(response)
     
    {
       $scope.user=response.data;
       $location.path("/")
    		});
}
});
	
	
		