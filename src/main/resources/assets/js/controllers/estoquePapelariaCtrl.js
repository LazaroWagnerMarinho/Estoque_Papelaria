app.controller("estoquePapelariaCtrl", function($scope, $http, produtosAPI,$attrs){
           $scope.app = "Lista De Produtos";
           $scope.produtos =[];
           $scope.exibirBtnSalvar = true;

           var carregarProdutos = function(){
                limparTodosCampos();
                produtosAPI.getProduto().success(function(data, status){
                   $scope.produtos= data;
                }).error(function (data,status) {
                    $scope.message = "Nao foi possivel Cadastar o Produto!</p>" + data;
                });
           };

           $scope.adicionarProdutos = function(produto){
               produtosAPI.postProduto(produto).success(function(data){
                    $scope.message = "Produto cadastrado com Sucesso!"
                    $scope.produtoForm.$setPristine();
                    carregarProdutos();
               }).error(function (data){
                    $scope.message = "Não foi possível salvar novo produto!"
               });

           };

           $scope.confimarAlteracaoDoProduto = function(id){
            var produto = preencherInfor(id);
                produtosAPI.alterarProduto(produto).success(function(data){
                    $scope.message = "Produto Alterado com sucesso!";
                    $scope.produtoForm.$setPristine();
                    carregarProdutos();
                }).error(function (data,status) {
                  $scope.message = "Nao foi possivel alterar o produto!</p>" + data
              });
           }

            $scope.deletarProdutos = function(id){
               produtosAPI.deletaProduto(id).success(function(data){
                    $scope.message = "Produto deletado com Sucesso";
                    $scope.produtoForm.$setPristine();
                    carregarProdutos();
               carregarProdutos();
               }).error(function (data,status) {
                   $scope.message = "Não foi possivel deletar o produto!</p>" + data
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
               $scope.exibirBtnSalvar = false;
           };

            var preencherInfor = function(id){
               codBarra =    document.querySelector("from, #codBarra   ").value,
               nomeProduto = document.querySelector("from, #nomeProduto").value,
               descricao =   document.querySelector("from, #descricao  ").value,
               quantidade =  document.querySelector("from, #quantidade ").value,
               categoria =   document.querySelector("from, #categoria  ").value,

            produtos={
                id: id,
                codBarra : codBarra,
                nomeProduto: nomeProduto,
                descricao: descricao,
                quantidade: quantidade,
                categoria: categoria
            }
                return produtos;
            }

            var limparTodosCampos = function(){
                document.querySelector("from, #codBarra   ").value ="";
                document.querySelector("from, #nomeProduto").value ="";
                document.querySelector("from, #descricao  ").value ="";
                document.querySelector("from, #quantidade ").value ="";
                document.querySelector("from, #categoria  ").value ="";
            }

        carregarProdutos()

        });