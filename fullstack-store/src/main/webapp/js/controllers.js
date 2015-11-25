angularStrutsApp.controller('AppController', function ($scope) {  });

angularStrutsApp.controller('ArticlesController', function ($scope, $http, DataService) {
	this.init = function() {
		DataService.getArticles().then(function(data) {
			$scope.articles = data.data.articles;
		}, function(data) {
			console.log('Could not receive project names.')
		});
	};

	this.init();

	var articles = $scope.articles = [];


});

angularStrutsApp.controller('CartController', function ($scope, $http, DataService) {
	var cartContent = [];

	$scope.addArticleToCart = function(article){
		if(article){
			console.table(article);
			cartContent.push(article);
		}
	}

    $scope.calculateTotalPrice = function(){
        var totalPrice;
        for(a in cartContent){
            totalPrice += a.quantity;
        }

        return totalPrice;
    }


});
