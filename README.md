![Logo](https://imagensfree.com.br/wp-content/uploads/2021/11/entregador-ifood-png-bicicleta-300x276.png)


<h1 align="center">
     Desafio-iFood-Back - Equipe Traceback (6) 
</h1>

![Badge em Desenvolvimento](http://img.shields.io/static/v1?label=STATUS&message=FINALIZADO&color=GREEN&style=for-the-badge)


Tópicos
=================
<!--ts-->
   * [Sobre o projeto](#-sobre-o-projeto)
   * [Informações Gerais](#-informações-gerais)
   * [API endpoints](#-API-endpoints)
      * [Login](#login)
      * [Pedido](#Pedido)
      * [Entregador](#Entregador)
      * [Rastreamento](#Rastreamento )
   * [Pré-requisitos](#pré-requisitos)
   * [Editar a aplicação ou rodar localmente](#-editar-a-aplicação-ou-rodar-localmente)
   * [Tecnologias](#-tecnologias)
   * [Time de desenvolvimento](#-time-de-desenvolvimento)


## 💻 Sobre o projeto

Este projeto tem por objetivo criar um “Track History” dos pedidos realizados pelos entregadores. Serão guardadas as informações de telemetria do pedido, da hora que o entregador aceitar a entrega até que chegue ao cliente.  Se dará a cada intervalo de tempo, no caso de falha de comunicação, estas informações ficarão temporariamente armazenadas no app, e assim que existir novamente sinal uma lista de posições será enviada para o servidor. 

Em resumo, o processo se dará através:

- entregador se conecta no sistema (estilo web app), e faz seu login;
- verifica em uma lista os pedidos em "aberto" e escolhe um destes para fazer a entrega;
- após a confirmação de aceite do pedido,  o entregador passa a ser monitorado através da telemetria (latitude e longitude) até completar a entrega.
- quando finalizar a "entrega" o entregador avisa via sistema que fará o fechamento do pedido.  Há também a possibilidade de cancelar o pedido.

link para o repositório de Front: https://github.com/Pam18/desafio1-ifood-front.git

## ⚙️ Informações Gerais
O sistema guardará estas informações para poder exibir relatórios do histórico de entrega baseado nesta telemetria armazenada, sendo a persistência dos dados feito num SGBD Postgres.

O que foi implementado durante o projeto:
1) endpoint login entregador (email e senha);
2) endpoint lista dos pedidos abertos;
3) endpoint alocação pedido;
4) endpoint finalização pedido;
5) endpoint cancelamento pedido;
6) endpoint recuperação do track history do pedido.

# API endpoints

## Login
`POST` (/login) <br/>
{<br/>
email:email,<br/>
senha: senha<br/>
} <br/>

Retorno: TOKEN entregador <br/>
ou<br/>
Mensagem de erro: 404 - Não autorizado!<br/>

## Pedido
`GET` (/pedidos) - Lista todos os pedidos do banco.<br/>
Retorno: status 200 (ok) - Lista todos os pedidos.<br/>
<br/>
`GET` (/pedidos/abertos) - Lista todos os pedidos com status "aberto".<br/>
Retorno:  status 200 (ok) - Lista todos os pedidos com status "aberto". <br/>
<br/>
`PUT` (/pedidos/aceitar/{idPedido}) - Altera o status do pedido de "aberto" para "transito".<br/>
Retorno:  status 200 (ok). <br/>
ou<br/>
Mensagem de erro: 400 - Este pedido já está alocado!<br/>
<br/>
`PUT` (/pedidos/finalizar/{idPedido}) - Altera o status do pedido de "transito" para "finalizado".<br/>
Retorno:  status 200 (ok). <br/>
ou<br/>
Mensagem de erro: 409 - Não foi possível finalizar o pedido.<br/>
<br/>
`PUT` (/pedidos/cancelar/{idPedido}) - Altera o status do pedido de "transito" para "cancelado".<br/>
Retorno:  status 200 (ok). <br/>
ou<br/>
Mensagem de erro: 409 - Não foi possível cancelar o pedido.<br/>
<br/>


## Entregador
`GET` (/entregadores/{idEntregador}) - Lista todas as rotas de cada pedido do entregador.<br/>
Retorno: status 200 (ok) - Lista as rotas do entregador.<br/>
ou<br/>
Mensagem de erro: 404 - Entregador não foi encontrado!.<br/>
<br/>

## Rastreamento
`POST` (/rastreamento) - Grava as rotas referentes ao pedido.<br/>
Retorno: status 201 (created).<br/>
ou<br/>
Mensagem de erro: 400 (Bad Request).<br/>
<br/>
___

## Pré-requisitos

Antes de começar, você vai precisar ter instalado em sua máquina as seguintes ferramentas:
[Git](https://git-scm.com),Java 17(Spring Boot), PostgreSQL.


## :octocat:  Editar a aplicação ou rodar localmente

```bash

# Clone este repositório em sua máquina  
$ git clone https://github.com/Pam18/desafio1-ifood-back.git

```
---

## 🛠 Tecnologias

As seguintes linguagens/tecnologias foram usadas na construção do projeto:

* Java 17
* Spring Boot


## 🛠 Ferramentas
* Trello: https://trello.com/b/vpS2rAnJ/desafio
* Notion: https://www.notion.so/
---

## 🦸 Time de desenvolvimento

⚙️**Bianca Padilha** - [GitHub](https://github.com/Padilha27) [Linkedin](https://www.linkedin.com/in/bianca-padilha-070772174/) 

⚙️**Yhaohannah Lima** - [GitHub](https://github.com/Pam18) [Linkedin](https://www.linkedin.com/in/yhaohannah-lima-954690216/)

⚙️**Eduardo Gomes** - [GitHub](https://github.com/Eduardo377) [Linkedin](https://www.linkedin.com/in/eduardogomes377/)

⚙️**Franklin Percicotte** - [GitHub](https://github.com/frankpercicotte) [Linkedin](https://www.linkedin.com/in/franklinpercicotte/)

⚙️**Guilherme Campos** - [GitHub](https://github.com/GuilhermeFelipeCampos) [Linkedin](https://www.linkedin.com/in/guilhermefelipecampos/)

---
