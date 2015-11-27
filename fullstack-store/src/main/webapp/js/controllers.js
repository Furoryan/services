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
    $scope.quantity = 1;

    var a = {};
    $scope.addArticleToCart = function(article){
        localStorage.setItem(article.id, $scope.quantity)
        console.log(localStorage);
        //a[article.id] = $scope.quantity;
        //cartContent.push(article);
    }

	var articles = $scope.articles = [];

    console.log(localStorage);


});

angularStrutsApp.controller('CartController', function ($scope) {
    $scope.articlesInCart = [];

    for(var i = 0; i<localStorage.length; i++){
        $scope.articlesInCart.push(localStorage.getItem(localStorage.key(i)));
    }
    console.log($scope.articlesInCart);

    $scope.calculateTotalPrice = function(){
        var totalPrice;
        for(var i=0; i<localStorage.length; i++){
            console.log(localStorage.getItem(localStorage.key(i).price));
            totalPrice+=localStorage.getItem(localStorage.key(i).price);
        }
        console.log(totalPrice);
        return totalPrice;
    }

    $scope.cleanCart = function(){
        localStorage.clear();
    }

    $scope.removeArticle = function(article){
        localStorage.removeItem(article.id);
    }

    $scope.pay = function(){
        console.log("jambnn");
        for(var i=0; i < localStorage.length; i++){
            console.log(localStorage.getItem(localStorage.key(i)));
        }
    }

    $scope.calculateTotalPrice();
});
