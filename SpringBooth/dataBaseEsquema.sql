

CREATE TABLE public.customer
(
    code bigint NOT NULL,
    card_id character varying(255) COLLATE pg_catalog."default",
    first_name character varying(255) COLLATE pg_catalog."default",
    last_name character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT customer_pkey PRIMARY KEY (code)
)

TABLESPACE pg_default;

ALTER TABLE public.customer
    OWNER to postgres;



------
-- Table: public.device

-- DROP TABLE public.device;

CREATE TABLE public.device
(
    code bigint NOT NULL,
    device_type character varying(255) COLLATE pg_catalog."default",
    price numeric(19,2),
    description character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT device_pkey PRIMARY KEY (code)
)

TABLESPACE pg_default;

ALTER TABLE public.device
    OWNER to postgres;

    -----


    -- Table: public.intelligent_service

-- DROP TABLE public.intelligent_service;

CREATE TABLE public.intelligent_service
(
    code bigint NOT NULL,
    name character varying(255) COLLATE pg_catalog."default",
    price numeric(19,2),
    CONSTRAINT intelligent_service_pkey PRIMARY KEY (code),
    CONSTRAINT uk364rgrdefg8np3pu9hqppum49 UNIQUE (name)

)

TABLESPACE pg_default;

ALTER TABLE public.intelligent_service
    OWNER to postgres;

    ---------------------



    -- Table: public.customer_device

-- DROP TABLE public.customer_device;

CREATE TABLE public.customer_device
(
    id bigint NOT NULL,
    price numeric(19,2),
    code bigint,
    code_device bigint,
    description character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT customer_device_pkey PRIMARY KEY (id),
    CONSTRAINT ukknuxl2uvppxgmcde6d9i8w435 UNIQUE (description)
,
    CONSTRAINT fkfl1ltksorbagmb15tyund0ruw FOREIGN KEY (code_device)
        REFERENCES public.device (code) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT fkncc9obdubjrne1h5shh6ldjth FOREIGN KEY (code)
        REFERENCES public.customer (code) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE public.customer_device
    OWNER to postgres;


    ------------------

    -- Table: public.customer_device_service

-- DROP TABLE public.customer_device_service;

CREATE TABLE public.customer_device_service
(
    code bigint NOT NULL,
    price numeric(19,2),
    customer_device_id bigint,
    intelligent_service_code bigint,
    CONSTRAINT customer_device_service_pkey PRIMARY KEY (code),
    CONSTRAINT fk1iwsfivslhkh95wtbvee4dcjx FOREIGN KEY (intelligent_service_code)
        REFERENCES public.intelligent_service (code) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT fkphp6yex2cv257lbxkohwoq46f FOREIGN KEY (customer_device_id)
        REFERENCES public.customer_device (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE public.customer_device_service
    OWNER to postgres;

-----Secuencias


CREATE SEQUENCE public.customer_code_seq
    INCREMENT 1
    START 2
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.customer_code_seq
    OWNER TO postgres;


-- SEQUENCE: public.customer_device_id_seq

-- DROP SEQUENCE public.customer_device_id_seq;

CREATE SEQUENCE public.customer_device_id_seq
    INCREMENT 1
    START 7
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.customer_device_id_seq
    OWNER TO postgres;



    -- SEQUENCE: public.customer_device_service_code_seq

-- DROP SEQUENCE public.customer_device_service_code_seq;

CREATE SEQUENCE public.customer_device_service_code_seq
    INCREMENT 1
    START 50
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.customer_device_service_code_seq
    OWNER TO postgres;
