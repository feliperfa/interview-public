CREATE TABLE accounts (
	id NUMBER(10) NOT NULL,
	first_name VARCHAR(20) NOT NULL,
	last_name VARCHAR(20) NOT NULL,
	balance NUMBER(20) NOT NULL,
	CONSTRAINT ID_PK PRIMARY KEY (id)
);