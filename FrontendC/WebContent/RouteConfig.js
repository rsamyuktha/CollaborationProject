var myapp=angular.module("myApp",['ngRoute']);

myapp.config(function($routeProvider)
		{
			$routeProvider.when("#/",{templateUrl:"index.html"})
						  .when("/Blog",{templateUrl:"Blog/Blog.html"})
						  .when("/Forum",{templateUrl:"Forum/Forum.html"})
						   .when("/AdminBlog",{templateUrl:"Blog/AdminBlog.html"})
						    .when("/Register",{templateUrl:"User/Register.html"});
		});

