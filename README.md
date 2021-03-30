# Kiwigrid - Seleção Dev Java

Este repositório contém o código da API do desafio de seleção da Kiwigrid para dev Java.

O propósito do desafio é entregar uma API de CRUD de vendas sem fazer uso de qualquer componente do projeto Spring, ou seja, utilizando ferramentas "novas".

Optei por desenvolver utilizando o framework Quarkus, junto de Hibernate com Panache e RestEasy.

## Executando

```sh
# gerar imagem docker a partir do dockerfile
docker build -t kiwigrid-api:latest .

# criar container para a imagem, expondo a porta 8080
docker run -d -p8080:8080 --name api kiwigrid-api:latest
```

## Exemplos de Requests

Abaixo, alguns exemplos pontuais de consumo da API desenvolvida. Para uma documentação mais completa, é possível utilizar a [collection do Postman](kiwigrid.json), que exportei e adicionei ao repositório.

### Cadastrar Vendedor

```http
POST /api/vendedores HTTP/1.1
Host: localhost:8080
Content-Length: 60

{
    "matricula": "12346",
    "nome": "João da Silva"
}
```

### Listar Vendedores

```http
GET /api/vendedores HTTP/1.1
Host: localhost:8080
```

### Cadastrar Produto

```http
POST /api/produtos HTTP/1.1
Host: localhost:8080
Content-Length: 59

{
    "nome": "Produto de Exemplo",
    "preco": 10.00
}
```

### Listar Produtos

```http
GET /api/produtos HTTP/1.1
Host: localhost:8080
```

### Cadastrar Venda
```http
POST /api/vendas HTTP/1.1
Host: localhost:8080
Content-Length: 193

{
    "vendedor": {
        "id": 4
    },
    "produtos": [
        {
            "produto": {
                "id": 3
            },
            "quantidade": 10
        }
    ]
}
```

### Listar Vendas

```http
GET /api/vendas HTTP/1.1
Host: localhost:8080
```

## Requisitos

### Obrigatórios

 - [x] CRUD de Vendedor
	- Possui Nome e Matrícula
	- Busca é feita por Matrícula
 - [x] CRUD de Produto
	- Possui Nome e Preço
	- Sem busca necessária
 - [x] Cadastro de Venda
	- Definida por Vendedor + Lista de Produtos + Valor Total
 - [x] Endpoints de Estatísticas
	- [x] Lista dos Vendedores por maior número de vendas
	- [x] Lista dos Vendedores por valor de vendas
	- [x] Lista de Produtos mais vendidos

### Opcionais

 - [x] Dockerfile para gerar imagem Docker e executar a aplicação
 - [ ] Diagrama com arquitetura para alta carga de acessos nos endpoints de Estatísticas
 - Qualquer outro entregável que seja considerado necessário

## Entregáveis

 - Repositório GitHub
	- Código-fonte
	- Instruções de execução
	- Exemplos de chamadas para a API
