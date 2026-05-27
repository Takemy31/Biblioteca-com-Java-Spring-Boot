# Projeto Biblioteca com Java Spring Boot

Aluno: Lucas Bezerra da Silva

Ferramenta: Java Spring Boot

Descrição: Um sistema web simples de biblioteca desenvolvido em Java Spring Boot, contendo CRUD completo e relacionamento 1:N entre Autor e Livro.

# Antes de executar o projeto, você precisa ter instalado:
Java JDK 17+

Maven

MySQL

# Clonando o Projeto

# 1. Clonar o repositório
git clone https://github.com/Takemy31/Biblioteca-com-Java-Spring-Boot

# 2. Entrar na pasta do projeto
cd library

# 3. Configurando o Banco de Dados
Crie um banco no MySQL:

CREATE DATABASE biblioteca;

# 4. Configuração do application.properties
No arquivo veja as especificações do seu banco e altere oque for necessario:
src/main/resources/application.properties


spring.datasource.url=jdbc:mysql://localhost:3306/biblioteca

spring.datasource.username=root

spring.datasource.password=SUA_SENHA


spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# 5. Instalando Dependências
O Maven instalará automaticamente as dependências do projeto.
Mas se quiser baixar manualmente pelo terminal

Abra o terminal na pasta do projeto e execute:

mvn clean install

# 6. Executar o sistema
No terminal na pasta do projeto execute:

mvn spring-boot:run

ou

./mvnw spring-boot:run
