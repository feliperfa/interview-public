CREATE TABLE transfers (
	id NUMBER(10) NOT NULL,
	source_id NUMBER(10) NOT NULL,
	target_id NUMBER(10) NOT NULL,
	amount NUMBER(20) NOT NULL,
	transfer_time TIMESTAMP NOT NULL,
	CONSTRAINT ID_PK PRIMARY KEY (id)
	CONSTRAINT source_id_fk FOREIGN KEY (source_id) REFERENCES (accounts.id)
	CONSTRAINT target_id_fk FOREIGN KEY (target_id) REFERENCES (accounts.id)
);