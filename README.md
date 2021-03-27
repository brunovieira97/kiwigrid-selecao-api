# Kiwigrid - Seleção Dev Java

Este repositório contém o código da API do desafio de seleção da Kiwigrid para dev Java.

O propósito do desafio é entregar uma API de CRUD de vendas sem fazer uso de qualquer componente do projeto Spring, ou seja, utilizando ferramentas "novas".

Optei por desenvolver utilizando o framework Quarkus, junto de Hibernate com Panache e RestEasy.

## Requisitos

### Obrigatórios

 - [ ] CRUD de Vendedor
	- Possui Nome e Matrícula
	- Busca é feita por Matrícula
 - [ ] CUD de Produto
	- Possui Nome e Preço
	- Sem busca necessária
 - [ ] Cadastro de Venda
	- Definida por Vendedor + Lista de Produtos + Valor Total
 - [ ] Endpoints de Estatísticas
	- [ ] Lista dos Vendedores por maior número de vendas
	- [ ] Lista dos Vendedores por valor de vendas
	- [ ] Lista de Produtos mais vendidos

### Opcionais

 - [ ] Dockerfile para gerar imagem Docker e executar a aplicação
 - [ ] Diagrama com arquitetura para alta carga de acessos nos endpoints de Estatísticas
 - Qualquer outro entregável que seja considerado necessário

## Entregáveis

 - Repositório GitHub
	- Código-fonte
	- Instruções de execução
	- Exemplos de chamadas para a API