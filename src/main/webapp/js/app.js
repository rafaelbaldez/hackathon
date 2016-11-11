var App = angular.module('App', [
'ngRoute',
'controllers',
'services'
]);

App.config(function($routeProvider){
	$routeProvider
	.when('/', {
		templateUrl: 'views/agente/agente.html',
		controller: 'AgenteCtrl'
	})

	.when('/create', {
		templateUrl: 'views/agente/cadastrarAgente.html',
		controller: 'AgenteCtrl'
	})

	.when('/editarAgente', {
		templateUrl: 'views/agente/editarAgente.html',
		controller: 'AgenteCtrl'
	})
	.when('/infracao', {
		templateUrl: 'views/infracao/infracao.html',
		controller: 'InfracaoCtrl'
	})
});

App.value('API', 'http://localhost:8081/primefaces-app/service/');