app.controller("estoquePapelariaCtrl", function($scope, $http, produtosAPI,$attrs){
           $scope.app = "Lista De Produtos";
           $scope.produtos =[];
           $scope.exibirSalvar = true;
           var carregarProdutos = function(){
                produtosAPI.getProduto().success(function(data, status){
                   $scope.produtos= data;
                }).error(function (data,status) {
                    $scope.message = "Nao foi possivel Cadastar o Produto!</p>" + data;
                });
           };

           $scope.adicionarProdutos = function(produto){
               produtosAPI.postProduto(produto).success(function(data){
                    delete $scope.produto;
                    $scope.produtoForm.$setPristine();
                    carregarProdutos();
               });

           };

           $scope.confimarAlteracaoDoProduto = function(id,produtos){
            var produto = preencherInfor();
                produtosAPI.alterarProduto(id,produto).success(function(data){
                    $scope.message = "Produto Alterado com sucesso!";
                    carregarProdutos();
                }).error(function (data,status) {
                  $scope.message = "Nao foi possivel Cadastar o Produto!</p>" + data
              });
           }

            $scope.deletarProdutos = function(id){
               produtosAPI.deletaProduto(id).success(function(data){
                    $scope.message = "deletado com Sucesso";
                    $scope.produtoForm.$setPristine();
               carregarProdutos();
               }).error(function (data,status) {
                   $scope.message = "Nao foi possivel Cadastar o Produto!</p>" + data
               });
            };

           $scope.ordenarPor = function(campo){
               $scope.ordenacao = campo;
               $scope.direcaoDaOrdenacao = !$scope.direcaoDaOrdenacao;
           };

           $scope.alterarProduto = function(produtos){
                $scope.produtoId = produtos.id;
               document.querySelector("from, #codBarra   ").value = produtos.codBarra;
               document.querySelector("from, #nomeProduto").value = produtos.nomeProduto;
               document.querySelector("from, #descricao  ").value = produtos.descricao;
               document.querySelector("from, #quantidade ").value = produtos.quantidade;
               document.querySelector("from, #categoria  ").value = produtos.categoria;
               $scope.exibirSalvar = false;
           };

            var preencherInfor = function(){
               codBarra = document.querySelector("from, #codBarra   ").value,
               nomeProduto = document.querySelector("from, #nomeProduto").value,
               descricao = document.querySelector("from, #descricao  ").value,
               quantidade = document.querySelector("from, #quantidade ").value,
               categoria = document.querySelector("from, #categoria  ").value,

            produtos={
                codBarra : codBarra,
                nomeProduto: nomeProduto,
                descricao: descricao,
                quantidade: quantidade,
                categoria: categoria
            }
                return produtos;
            }


        carregarProdutos()

        });