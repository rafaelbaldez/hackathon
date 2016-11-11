App.factory('InfracaoService', function($http, API){
	return {
		list: function(){
			return $http.get(API+'infracao');
		},
		create: function(item){
			return $http.post(API+'infracao/cadastrar', item);
		},
		update: function(item, id){
			return $http.post(API+'infracao/atualizar', item);	
		},
		deleta: function(id){
			return $http.post(API+'infracao/deletar/'+id);
		}
	}
})