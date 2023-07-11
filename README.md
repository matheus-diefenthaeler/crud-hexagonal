
# Arquitetura Hexagonal/Ports and Adapters

Projeto com intuito de por em prática como aplicar a arquitetura hexagonal em microsserviços utilizando Java, Spring Boot, MongoDB e Kafka.
## Documentação da API

#### Cria um cliente

```http
  POST http://localhost:8081/api/v1/customers
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `name`      | `string` | **Obrigatório**. O NOME do cliente |
| `zipCode`   | `string` | **Obrigatório**. O CEP do cliente  |
| `cpf`       | `string` | **Obrigatório**. O CPF do cliente  |



#### Retorna cliente por id

```http
  GET http://localhost:8081/api/v1/customers/{id}
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `id` | `string` | **Obrigatório**. A chave da sua API |


#### Remove cliente por id

```http
  DELETE http://localhost:8081/api/v1/customers/{id}
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `id` | `string` | **Obrigatório**. A chave da sua API |

#### Atualiza os dados de um cliente

```http
  PUT http://localhost:8081/api/v1/customers/{id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `name`      | `string` | **Não é Obrigatório**. O NOME do cliente |
| `zipCode`   | `string` | **Não é Obrigatório**. O CEP do cliente  |
| `cpf`       | `string` | **Não é Obrigatório**. O CPF do cliente  |


## Rodando localmente

Inicie os conteiners com a imagem do kakfa, zookeeper e o mongodb

```bash
  docker-compose up
```

Executar o Wiremock para retornar endereço

```bash
  java -jar wiremock-jre8-standalone-2.35.0.jar --port 8082
```

Acessar o conteiner do mongoDB

```bash
  docker exec -it <id conteiner> /bin/bash
```

Mostrar collections (tabelas)

```bash
  show collections
```

Recuperar os documentos

```bash
  db.<nome_tabela>.find()
```
