App.factory('AgenteService', function($http, API){
	return {
		list: function(){
			return $http.get(API+'agente');
		},
		create: function(item){
			return $http.post(API+'agente/cadastrar', item);
		},
		update: function(item, id){
			return $http.post(API+'agente/atualizar', item);	
		},
		deleta: function(id){
			return $http.post(API+'agente/deletar/'+id);
		}
	}
})