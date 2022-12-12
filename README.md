# Cliente-API
## Projeto desenvolvido em Spring Boot
![](/gif/api-clientes.gif)
#
### Premissas:
#### 1. Adicionar clientes no sistema
#### 2. Visualizar dados clientes no sistema
#### 3. Atualizar dados de clientes
#### 4. Remover dados do usuários do sistema
#
### Tecnologias utilizadas:
#### 1. JPA
#### 2. Spring Boot
#### 3. Banco h2 (executado no modo cliente-servidor)
#
### Como testar em sua maquina ?
#### Requisitos:
##### - Possuir aplicativo Postman no computador
##### - IDE SpringToolSuite
#### Testar:
##### - Abrir o projeto na IDE
##### - Rodar o projeto Spring
##### - Abrir Postman no computador
##### - Abrir pelo navegador o Postaman
##### - Definir no Postman pelo navegador:
        - GET: localhost:8080/clientes - Buscar clientes cadastrados
        - GET: localhost:8080/clientes/id - Buscar cliente pelo id
        - POST: localhost:8080/clientes (requer corpo com dados do usuário) - Adicionar cliente
        - PATCH: localhost:8080/clientes/id (requer corpo com dados do usuário) - Atualiza um cliente cadastrado pelo id
        - DELETE: localhost:8080/clientes/id - Remove um cliente cadastrado pelo id
