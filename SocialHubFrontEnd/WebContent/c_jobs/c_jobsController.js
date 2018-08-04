myModule.controller("c_jobsController", function($location, $scope, $rootScope, $http, $route)
		{
			$scope.job = {'jobId':' ', 'jobDesignation':' ', 'company':' ', 'salary':' ', 'location':' ', 'jobDescription':' ','LastDateToApply':' '}
			
			
			$scope.jobData;
			
			$rootScope.applyJobData;
			
			$rootScope.jobInfo;
			
			$scope.applyJob={'applicationId':'0','company':'','jobDesignation':'','appliedDate':'','jobId':'','loginName':''}
			

			$scope.addJob=function()
			{
				$http.post('http://localhost:1567/SocialHubMiddleware/addJob',$scope.job)
				.then(function(response)
				{
					$location.path('/UserHome');
				});
			}
			
			function showJob()
			{
				$http.get('http://localhost:1567/SocialHubMiddleware/listJobs')
				.then(function(response)
				{
					$scope.jobData=response.data;
					console.log($scope.jobData);
					
				});
			}
			
			$rootScope.applyJobClicked=function(job)
			{
				$http.get('http://localhost:1567/SocialHubMiddleware/getJob/'+job.jobId)
				.then(function(response)
				{
					$rootScope.jobInfo=job;
					$rootScope.applyJobData=response.data;
					$location.path('/applyJobs');
				});
				
			}
			
			$scope.applyJobs=function()
			{
				console.log('Applying for jobs');
				$scope.applyJob.loginName=$rootScope.currentUser.loginname;
				$scope.applyJob.jobId=$rootScope.jobInfo.jobId;
				$scope.applyJob.company=$rootScope.jobInfo.company;
				$scope.applyJob.jobDesignation=$rootScope.jobInfo.jobDesignation;
				$http.post('http://localhost:1567/SocialHubMiddleware/applyJob',$scope.applyJob)
				.then(function(response)
				{
					console.log('Successful');
					$location.path('/showJob');	
				});
			}
			
			function listApplyJob()
			{
				console.log("Applied jobs displaying");
				$http.get('http://localhost:1567/SocialHubMiddleware/listAppliedJobs')
				.then(function(response)
						{
							$rootScope.listApplyJob = response.data;
						},
						function(response)
						{
							$rootScope.isalljobApplications = undefined;
						});
			}
			listApplyJob();
			showJob();
			
		});