App.controller('InfracaoCtrl', function($scope, InfracaoService, $route,$routeParams,$location,EnvioService){
	$scope.infracao = [];
	$scope.infracaoEditar = {};

	$scope.notFound = false;
	InfracaoService.list().then(function(data){
		$scope.infracao = data.data;
		if(data.data.length == 0){
			$scope.notFound = true;
		}
	},function(data){
		console.log("data", data);
	});
	$scope.infracaoEditar = EnvioService.getParametro();
	
	$scope.deletar = function(id){
		InfracaoService.deleta(id).then(function(data){
			console.log(data);
			$route.reload();
		});	
	}
	
	$scope.editar = function(item){
		$scope.infracaoEditar = {};
		EnvioService.addParametro(item);
		$location.path('/editarInfracao');
	}
	
	$scope.atualizar = function(item){
		AgenteService.update(item).then(function(data){
				$location.path('/infracao');
			});
	}
	$scope.cadastrar = function(agente){
		var data = {
			nome: agente.nome,
			dtContratacao : agente.dtContratacao,
			tempoServico : agente.tempoServico
		};

		InfracaoService.create(data).then(function(data){
			$location.path('/');
		});
	}
	
});