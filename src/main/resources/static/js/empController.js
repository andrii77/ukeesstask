codingApp.controller('empController', function($scope, $rootScope, $http) {
		
	$scope.department = {
			dptID: 0,
			dpName:"Tech"
	}
	$scope.empl = {
			empID: 0,
			empName: "Rogers",
			empActive: "YES",
            department: $scope.department
			
	}
	
	$scope.searchString = "";
	$scope.employees = [];	
	$scope.context = "all";
	$scope.pages = [
	                   {page : "previous"},
	                   {page : 1},
	                   {page : 2},
	                   {page : 3},
	                   {page : 4},
	                   {page : 5},
	                   {page : "next"}
	               ];	

	$scope.defaultPage =
		{
			page : 0
		}
    
	$scope.getEmp = function(x) {	

		if(x.page == "next"){			
			for(var i=1; i<$scope.pages.length-1; i++){
				$scope.pages[i].page = $scope.pages[i].page + 1;
			}
		}
		else if(x.page == "previous" ){	
			
			if($scope.pages[1].page!=1){
				for(var i=1; i<$scope.pages.length-1; i++){
					$scope.pages[i].page = $scope.pages[i].page - 1;
				}
			}
		}
		else{
			if($scope.context == "all"){
				loc_url = /employee/+(x.page-1);
				$http.get(loc_url).then(function(response) {
					$scope.employees = response.data.content;		 
				});		
			}
			else{
				searchString = $scope.searchString;
				$http({
					method : 'GET',
					url : '/employee/search/'+searchString+"/"+(x.page-1),
				}).then(function(response) {
					$scope.employees = response.data.content;		 
				});
			}
		}
	};
	
	$scope.getEmpD = function() {	
		 
		 $http.get("/employee/0").then(function(response) {
			$scope.employees = response.data.content;		 
		 });		
	};
	   
     $scope.success = function() {
     };

     $scope._error = function() {
       
     };
    
     
     $scope.search = function(searchString) {
    	 
    	 $scope.searchString = searchString;
    	 $scope.context = "search";
    	 
    	 
         $http({
             method : 'GET',
             url : '/employee/search/'+searchString+"/0",
         }).then(function(response) {
			$scope.employees = response.data.content;		 
		 });		
     };
     
     $scope.saveEmpForUpdate = function(emp) {
    	 
    	 $scope.empl = angular.copy(emp);
    	
    	 
     }
     
     $scope.updateEmp = function() {
    	 console.log($scope.empl.department.dpName);
    	 if($scope.empl.department.dpName == "Tech"){
    		 $scope.empl.department.dptID = 1;
    	 }
    	 else if($scope.empl.department.dpName == "Finance"){
    		 $scope.empl.department.dptID = 2;
    	 }
    	 else{
    		 $scope.empl.department.dptID = 3;
    	 }
    	 console.log($scope.empl.department.dptID);
         $http({
             method : 'PUT',
             url : 'employee',
             data : angular.toJson($scope.empl),
             headers : {
                 'Content-Type' : 'application/json'
             }
          
         }).then($scope.success(), $scope._error());
     };
     
 	$scope.deleteEmp = function(emp) {
		 $http({
            method : 'DELETE',
            url : '/employee/'+emp.empID
        }).then($scope.success(), $scope._error());
    };
	
});

codingApp.config(function($routeProvider) {
    $routeProvider
    .when("/update", {
        templateUrl : "update"
    })
    .when("/empty", {
        templateUrl : "empty"
    });
});
