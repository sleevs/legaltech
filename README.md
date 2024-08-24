
Instrução para Iniciar a aplicação:


Caso não tenha banco de dados PostgresSQL configurado no seu ambiente 
inicialize o arquivo docker-compose.yaml com banco de dados PostgresSQL configurado com o seguinte comando :

- docker-compose up

  
A aplicação realiza a criação das tabelas do banco de dados
programaticamente no momento da inicialização mas existe um arquivo .sql com as tabelas utilizadas pela aplicação para análise. 

- mvn spring-boot:run


É possível acessar a documentação da API pelo endereço:

http://localhost:8080/swagger-ui/index.html
