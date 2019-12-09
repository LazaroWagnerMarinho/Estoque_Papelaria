angular.module("estoquePapelaria").factory("produtosAPI", function($http){

    var _getProdutos = function(){
        return $http.get("/estoque/listarProdutos");
    };

    var _postProduto = function(produto){
        return $http.post("/estoque/cadastrar", produto);
    }

    var _alterProdutos = function(produtos){
        return $http.put("estoque/alterar/",produtos);
    };

    var _deleteProdutos = function(id){
        return $http.delete("/estoque/deletar/"+id);
    };

    return {
        getProduto: _getProdutos,
        postProduto: _postProduto,
        deletaProduto: _deleteProdutos,
        alterarProduto: _alterProdutos

    };


});