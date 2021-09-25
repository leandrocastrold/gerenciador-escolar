# Gerenciador escolar MVC, com Thymeleaf, MongoDB e Spring Security

## Projeto no Ar
Clique AQUI pra acessar a versão em produção desse projeto. Foram utilizados o **AWS Beanstalk** (*deploy*) e banco de dados **MongoDB Atlas**. 

Esse projeto consiste em uma aplicação *MVC*, que utiliza **Thymeleaf** (*views*), autenticação com **Spring Security** e banco de dados *NoSQL* (**MongoDB**).

## Tecnologias utilizadas:

* Java 11
* Thymeleaf 
* MongoDB
* Spring Security

## Configuração

#### Banco de dados
Altere o campo `spring.data.mongodb.uri`, com a *URI* do seu banco **MongoDB** no arquivo *application.properties*.

#### Login
Altere o arquivo *WebSecurityConfig.java* para mudar as credenciais de acesso ao sistema.

#### Execução
Gerar arquivo *.jar*: `mvn clean package`.

Rodar a applicação pelo *jar*:
`java -jar target/[NOME_ARQUIVO]`  

