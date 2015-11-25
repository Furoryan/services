
var angularStrutsApp = angular.module('angularStrutsApp', ['ngRoute']);

angularStrutsApp.config(['$routeProvider', '$locationProvider',
    function($routeProvider, $locationProvider) {

        $locationProvider.html5Mode(true).hashPrefix('!');

        $routeProvider.when('/cart', {
            templateUrl: 'partials/cart.html',
            controller: 'CartController'
        }).when('/articles', {
            templateUrl: 'partials/articles.html',
            controller: 'ArticlesController'
        }).otherwise({ redirectTo: '/articles' });
    }
]);
