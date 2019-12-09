# EstoqueProduto

How to start the EstoqueProduto application
---

1. Run `mvn clean install` to build your application
1. Start application with `java -jar target/estoque.Produto-1.0-SNAPSHOT.jar server config.yml`
1. To check that your application is running enter url `http://localhost:8080`

Health Check
---

To see your applications health enter url `http://localhost:8081/healthcheck`

### Configuração do Banco MySql:

    #Criar Banco:

    Nome de Schema: estoque_papelaria;
    login: root;
    senha: 123456

### Build:

	mvn clean package


### Database creation:

	java -jar target/estoque.Produto-1.0.0.jar db migrate config.yml


### Run:

	java -jar target/estoque.Produto-1.0.0.jar server config.yml


### Open browser pointing at

	http://localhost:8080/papelaria