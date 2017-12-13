myapp.controller("BlogController",function($scope,$http)
{
	$scope.blog={blogId:1004,blogName:"",blogContent:"",createDate:"",likes:0,username:"",status:"NA"};
	
	$http.get("http://localhost:8083/SocialCollRestController/getAllBlogs")
	.then(function(response)
	{
		$scope.blogdata=response.data;
	});
	
	$scope.insertBlog=function()
	{
		console.log('Entered into InsertBlog');
		$http.post('http://localhost:8083/SocialCollRestController/insertBlog',$scope.blog)
		.then(function(response)
				{
				console.log('Successful Blog Entered');
				});
	}
	
	
});
