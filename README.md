![Logo](https://imagensfree.com.br/wp-content/uploads/2021/11/entregador-ifood-png-bicicleta-300x276.png)


<h1 align="center">
     <a href="#" alt="Desafio-iFood"> Desafio-iFood-Back - Equipe Traceback (6) </a>
</h1>

![Badge em Desenvolvimento](http://img.shields.io/static/v1?label=STATUS&message=EM%20DESENVOLVIMENTO&color=GREEN&style=for-the-badge)


Tópicos
=================
<!--ts-->
   * [Sobre o projeto](#-sobre-o-projeto)
   * [Informações Gerais](#-informações-gerais)
   * [Pré-requisitos](#pré-requisitos)
   * [Editar a aplicação ou rodar localmente](#-editar-a-aplicação-ou-rodar-localmente)
   * [Tecnologias](#-tecnologias)
   * [Time de desenvolvimento](#-time-de-desenvolvimento)


## 💻 Sobre o projeto

Este projeto tem por objetivo criar um “Track History” dos pedidos realizados pelos entregadores do iFood. Serão guardadas as informações de telemetria do pedido, da hora que o entregador aceitar a entrega até que chegue ao cliente.  Se dará a cada intervalo de tempo, no caso de falha de comunicação, estas informações ficarão temporariamente armazenadas no app, e assim que existir novamente sinal uma lista de posições será enviada para o servidor. 

Em resumo, o processo se dará através:

- entregador se conecta no sistema (estilo web app), e faz seu login;
- verifica em uma lista os pedidos em "aberto" e escolhe um destes para fazer a entrega;
- após a confirmação de aceite do pedido,  o entregador passa a ser monitorado através da telemetria (latitude e longitude) até completar a entrega.
- quando finalizar a "entrega" o entregador avisa via sistema que fará o fechamento do pedido.  Há também a possibilidade de cancelar o pedido.


## ⚙️ Informações Gerais
O sistema guardará estas informações para poder exibir relatórios do histórico de entrega baseado nesta telemetria armazenada, sendo a persistência dos dados feito num SGBD Postgres.

O que foi implementado durante o projeto:
1) endpoint login entregador (email e senha);
2) endpoint lista dos pedidos abertos;
3) endpoint alocação pedido;
4) endpoint finalização pedido;
5) endpoint cancelamento pedido;
6) endpoint recuperação do track history do pedido.

Ainda falta implementar:
1) X;
2) Y;
3) Z.

## Pré-requisitos

Antes de começar, você vai precisar ter instalado em sua máquina as seguintes ferramentas:
[Git](https://git-scm.com) e X, y, z.


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
* Eclipse
* Trello
* Notion

---

## 🦸 Time de desenvolvimento

⚙️**Bianca Padilha** - [GitHub](https://github.com/Padilha27) [Linkedin]() 

⚙️**Yhaohannah Lima** - [GitHub](https://github.com/Pam18) [Linkedin]()

⚙️**Eduardo Gomes** - [GitHub](https://github.com/Eduardo377) [Linkedin](https://www.linkedin.com/in/eduardogomes377/)

⚙️**Franklin Percicotte** - [GitHub](https://github.com/frankpercicotte) [Linkedin]()

⚙️**Guilherme Campos** - [GitHub](https://github.com/GuilhermeFelipeCampos) [Linkedin]()

---
