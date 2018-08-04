myModule.controller('LogoutController', function($scope,$location){
  $scope.logout = function(){
      $location.path('/');
  }
});