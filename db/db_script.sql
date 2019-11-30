create database company;

create table roles (
	id serial primary key,
	role varchar(8) not null
);

create table users (
	id serial primary key,
	name varchar(10) not null,
	password varchar(10) not null,
	role int references roles(id)
);

create table countries (
	id serial primary key,
	name varchar(25) not null
);

create table suppliers (
	id serial primary key,
	name varchar(20) not null,
	country int references countries(id)
);

create table price_reductions (
	id serial primary key,
	reduced_price decimal not null,
	start_date date not null,
	end_date date not null
);

create type state as enum ('Active', 'Discontinued');

create table items (
	id serial primary key,
	description varchar(20) not null,
	price numeric(20, 2) not null,
	state state not null default 'Active',	
	creation_date TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP	
);

create table items_suppliers (
	item_id int references items(id) not null,
	supplier_id int references suppliers(id) not null,
	PRIMARY KEY(item_id, supplier_id)
);

create table items_price_reductions (
	item_id int references items(id) not null,
	price_reductions_id int references price_reductions(id) not null,
	PRIMARY KEY(item_id, price_reductions_id)
);
