CREATE TABLE public.supplier (
	id serial NOT NULL GENERATED ALWAYS AS IDENTITY,
	cnpj varchar(14) NOT NULL,
	legal_name varchar(100) NOT NULL,
	commercial_name varchar(100) NOT NULL,
	CONSTRAINT supplier_pk PRIMARY KEY (id)
);