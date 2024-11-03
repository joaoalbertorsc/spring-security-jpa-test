---
# Spring Boot + Spring Security com Autenticação JPA e PostgresSQL

Este projeto é uma aplicação Spring Boot com autenticação e autorização usando Spring Security e JPA com PostgresSQL como banco de dados. O objetivo é demonstrar como configurar o Spring Security para autenticar usuários com base em credenciais armazenadas em um banco de dados PostgresSQL.

## Tecnologias Utilizadas
- **Java 11+**
- **Spring Boot**
- **Spring Security**
- **Spring Data JPA**
- **MySQL**
- **Hibernate**

## Funcionalidades
- **Autenticação e autorização com Spring Security**: Usuários e permissões são definidos no banco de dados.
- **Integração com PostgresSQL**: Spring Data JPA acessa o banco de dados para autenticação.
- **UserDetailsService personalizado**: Serviço customizado para carregar dados de usuário diretamente do banco de dados.

## Estrutura do Projeto
1. **Dependências**: Inclui `Spring Web`, `Spring Security`, `Spring Data JPA` e o conector `PostgresSQL` para facilitar a configuração e a conexão com o banco de dados PostgresSQL.
2. **Configuração de Segurança**: A classe `SecurityConfiguration` define as configurações de autenticação e autorização.
3. **Serviço de Usuário**: A implementação de `UserDetailsService` recupera dados do banco de dados e retorna uma instância `UserDetails`.
4. **Model e Repository**:
   - **Entidade MyUser**: Representa a tabela de usuários no banco de dados, mapeando os campos para atributos.
   - **UserRepository**: Interface para operações CRUD, incluindo a busca de usuários por `username`.

## Configuração do Banco de Dados

### PostgresSQL
1. Configure uma instância PostgresSQL local com uma tabela de usuários contendo colunas como `username`, `password` e `roles`.
2. Atualize o arquivo `application.properties` para conectar ao banco de dados PostgresSQL:
    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:3306/seu_database
    spring.datasource.username=seu_usuario
    spring.datasource.password=sua_senha
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    ```

### Tabela `user`
A tabela `user` deve ter os seguintes campos:
- `id`: ID único para cada usuário.
- `username`: Nome de usuário para login.
- `password`: Senha do usuário (criptografada).
- `roles`: Lista de permissões separada por vírgulas.

## Configuração de Segurança

A configuração de segurança define quais endpoints requerem autenticação. A classe `SecurityConfiguration` configura:
- **Autenticação**: O `UserDetailsService` personalizado busca dados do usuário no banco de dados.
- **Autorização**: Define as permissões de acesso para os endpoints.

## Classe `UserDetailsService` Customizada

A implementação `MyUserDetailService` da interface `UserDetailsService` utiliza o `UserRepository` para carregar o usuário com base no `username`. A classe mapeia os dados do usuário para um objeto `UserDetails`, necessário para a autenticação no Spring Security.

## Executando o Projeto
1. **Clonar o repositório** e importar o projeto como um projeto Maven.
2. **Configurar o banco de dados** conforme descrito acima.
3. **Executar o projeto** com o comando:
    ```bash
    mvn spring-boot:run
    ```
4. Acesse o projeto em `http://localhost:8080`.

## Observações
- Para fins de desenvolvimento, o encoder de senha está configurado como `NoOpPasswordEncoder`, mas, em produção, use um encoder seguro, como o `BCryptPasswordEncoder`.
- Certifique-se de configurar corretamente o banco de dados e as permissões para o usuário do PostgresSQL.
--- 
