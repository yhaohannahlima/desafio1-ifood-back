Drop table if exists cliente cascade;

create table cliente (
 id serial not null primary key,
 nome varchar(50),
 latitude double precision not null,
 longitude double precision not null	
);

Drop table if exists entregador cascade;
create table entregador(
	
	id serial not null primary key,
	nome varchar(50) not null,
	cpf varchar(11) unique,
	senha TEXT not null,
	email varchar(30),
	telefone varchar(11)
);
Drop table if exists pedido cascade;
create table pedido (
 id serial not null primary key,
 idCliente int not null,
 idEntregador int,
 dataPedido date not null,
 status varchar(20) not null,
 foreign key (idCliente) references cliente(id),
 foreign key(idEntregador) references entregador(id)		
);

Drop table if exists rastreamento cascade;
create table rastreamento(
	
	id serial not null primary key,
	latitude double precision,
	longitude double precision,
	tempo timestamp,
	idPedido int not null,
	foreign key(idPedido) references pedido(id)
	
)
/*criacao de um novo campo na tabela pedido */
alter table pedido add column descricao varchar(100) not null;

