CREATE SCHEMA "GG" AUTHORIZATION postgres;

create table gender_tokens
(
tokenName varchar(100),
gender varchar(1)   -- M male F female
);

commit;


-- Drop table

-- DROP TABLE "GG".gender_tokens;

CREATE TABLE "GG".gender_tokens (
	ident int4 NOT NULL,
	tokenname varchar(100) NULL,
	gender varchar(1) NULL,
	CONSTRAINT gender_tokens_pkey PRIMARY KEY (ident)
);
-- Drop table

-- DROP TABLE "GG".gender_token_import;

CREATE TABLE "GG".gender_token_import (
	tokenname varchar(100) NULL,
	gender varchar(1) NULL,
	origin varchar(100) NULL
);


commit;

CREATE INDEX gender_tokens_tokenname_idx ON "GG".gender_tokens (tokenname);

commit;