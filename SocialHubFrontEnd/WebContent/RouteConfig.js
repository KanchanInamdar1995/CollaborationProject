var myModule=angular.module("MyModule",['ngRoute']);

myModule.config(function ($routeProvider)
		{
		
		alert('I am in Route Config');
		$routeProvider.when("/",{templateUrl:"/index.html"})
					 .when("/login",{templateUrl:"c_user/Login.html"})
					 .when("/register",{templateUrl:"c_user/Register.html"})
		             .when("/contactus",{templateUrl:"c_pages/ContactUs.html"})
		             .when("/aboutus",{templateUrl:"c_pages/AboutUs.html"})
					 .when("/UserHome",{templateUrl:"c_pages/UserHome.html"})
					 .when("/addBlog",{templateUrl:"c_blog/AddBlog.html"})
					 .when("/showBlog",{templateUrl:"c_blog/ShowBlog.html"})
					 .when("/adminBlog",{templateUrl:"c_blog/AdminBlog.html"})
					 .when("/blogComment",{templateUrl:"c_blog/BlogComment.html"});
					 
		});