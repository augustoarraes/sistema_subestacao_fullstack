--
-- PostgreSQL database dump
--

-- Dumped from database version 13.8
-- Dumped by pg_dump version 13.8

-- Started on 2025-04-16 00:37:12 UTC

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 3 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: -
--

--CREATE SCHEMA public;


--
-- TOC entry 3029 (class 0 OID 0)
-- Dependencies: 3
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: -
--

COMMENT ON SCHEMA public IS 'standard public schema';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 203 (class 1259 OID 24609)
-- Name: tb_rede_mt; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.tb_rede_mt (
    id_rede_mt integer NOT NULL,
    id_subestacao integer NOT NULL,
    codigo character varying(255) NOT NULL,
    nome character varying(255),
    tensao_nominal double precision
);


--
-- TOC entry 202 (class 1259 OID 24607)
-- Name: tb_rede_mt_id_rede_mt_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.tb_rede_mt_id_rede_mt_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 3030 (class 0 OID 0)
-- Dependencies: 202
-- Name: tb_rede_mt_id_rede_mt_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.tb_rede_mt_id_rede_mt_seq OWNED BY public.tb_rede_mt.id_rede_mt;


--
-- TOC entry 204 (class 1259 OID 24650)
-- Name: tb_rede_mt_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.tb_rede_mt_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 201 (class 1259 OID 24599)
-- Name: tb_subestacao; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.tb_subestacao (
    id_subestacao integer NOT NULL,
    codigo character varying(255) NOT NULL,
    nome character varying(255),
    latitude double precision NOT NULL,
    longitude double precision
);


--
-- TOC entry 200 (class 1259 OID 24597)
-- Name: tb_subestacao_id_subestacao_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.tb_subestacao_id_subestacao_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 3031 (class 0 OID 0)
-- Dependencies: 200
-- Name: tb_subestacao_id_subestacao_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.tb_subestacao_id_subestacao_seq OWNED BY public.tb_subestacao.id_subestacao;


--
-- TOC entry 205 (class 1259 OID 24652)
-- Name: tb_subestacao_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.tb_subestacao_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 2878 (class 2604 OID 24612)
-- Name: tb_rede_mt id_rede_mt; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_rede_mt ALTER COLUMN id_rede_mt SET DEFAULT nextval('public.tb_rede_mt_id_rede_mt_seq'::regclass);


--
-- TOC entry 2877 (class 2604 OID 24602)
-- Name: tb_subestacao id_subestacao; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_subestacao ALTER COLUMN id_subestacao SET DEFAULT nextval('public.tb_subestacao_id_subestacao_seq'::regclass);


--
-- TOC entry 3021 (class 0 OID 24609)
-- Dependencies: 203
-- Data for Name: tb_rede_mt; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO public.tb_rede_mt VALUES (2, 5, 'SBS004-MT001', 'Rede MT 1', 110);
INSERT INTO public.tb_rede_mt VALUES (3, 5, 'SBS004-MT002', 'Rede MT 2', 110);
INSERT INTO public.tb_rede_mt VALUES (4, 7, 'SBS005-MT001', 'Rede MT 1', 110);
INSERT INTO public.tb_rede_mt VALUES (5, 7, 'SBS005-MT002', 'Rede MT 2', 110);
INSERT INTO public.tb_rede_mt VALUES (6, 8, 'SBS006-MT001', 'Rede MT 1', 110);
INSERT INTO public.tb_rede_mt VALUES (7, 8, 'SBS006-MT002', 'Rede MT 2', 110);
INSERT INTO public.tb_rede_mt VALUES (8, 9, 'BS006-MT001', 'Rede MT 1', 110);
INSERT INTO public.tb_rede_mt VALUES (9, 9, 'BS006-MT002', 'Rede MT 2', 110);
INSERT INTO public.tb_rede_mt VALUES (10, 10, 'SBS007-MT001', 'Rede MT 1', 110);
INSERT INTO public.tb_rede_mt VALUES (11, 10, 'SBS007-MT002', 'Rede MT 2', 110);
INSERT INTO public.tb_rede_mt VALUES (13, 10, 'SBS007-MT003', 'Rede MT 2', 120);


--
-- TOC entry 3019 (class 0 OID 24599)
-- Dependencies: 201
-- Data for Name: tb_subestacao; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO public.tb_subestacao VALUES (1, 'AML', 'Subestação A', -23.2744134389987, -49.4702838173763);
INSERT INTO public.tb_subestacao VALUES (2, 'MKP', 'Subestação B', -22.6999266804592, -46.996111878849);
INSERT INTO public.tb_subestacao VALUES (3, 'ZFA', 'Subestação C', -23.0917377538889, -48.9241617522699);
INSERT INTO public.tb_subestacao VALUES (5, 'SBS004', 'Subestacao 4', -3.745, -38.523);
INSERT INTO public.tb_subestacao VALUES (7, 'SBS005', 'Subestacao 5', -3.745, -38.523);
INSERT INTO public.tb_subestacao VALUES (8, 'SBS006', 'Subestacao 6', -3.745, -38.523);
INSERT INTO public.tb_subestacao VALUES (9, 'BS006', 'Subestacao 6', -3.745, -38.523);
INSERT INTO public.tb_subestacao VALUES (10, 'SBS007', 'Subestacao 7 mesmo', -3.745, -38.523);


--
-- TOC entry 3032 (class 0 OID 0)
-- Dependencies: 202
-- Name: tb_rede_mt_id_rede_mt_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.tb_rede_mt_id_rede_mt_seq', 13, true);


--
-- TOC entry 3033 (class 0 OID 0)
-- Dependencies: 204
-- Name: tb_rede_mt_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.tb_rede_mt_seq', 51, true);


--
-- TOC entry 3034 (class 0 OID 0)
-- Dependencies: 200
-- Name: tb_subestacao_id_subestacao_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.tb_subestacao_id_subestacao_seq', 10, true);


--
-- TOC entry 3035 (class 0 OID 0)
-- Dependencies: 205
-- Name: tb_subestacao_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.tb_subestacao_seq', 1, true);


--
-- TOC entry 2884 (class 2606 OID 24623)
-- Name: tb_rede_mt tb_rede_mt_codigo_key; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_rede_mt
    ADD CONSTRAINT tb_rede_mt_codigo_key UNIQUE (codigo);


--
-- TOC entry 2886 (class 2606 OID 24614)
-- Name: tb_rede_mt tb_rede_mt_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_rede_mt
    ADD CONSTRAINT tb_rede_mt_pkey PRIMARY KEY (id_rede_mt);


--
-- TOC entry 2880 (class 2606 OID 24636)
-- Name: tb_subestacao tb_subestacao_codigo_key; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_subestacao
    ADD CONSTRAINT tb_subestacao_codigo_key UNIQUE (codigo);


--
-- TOC entry 2882 (class 2606 OID 24604)
-- Name: tb_subestacao tb_subestacao_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_subestacao
    ADD CONSTRAINT tb_subestacao_pkey PRIMARY KEY (id_subestacao);


--
-- TOC entry 2887 (class 2606 OID 24617)
-- Name: tb_rede_mt fk_subestacao_rede_mt; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_rede_mt
    ADD CONSTRAINT fk_subestacao_rede_mt FOREIGN KEY (id_subestacao) REFERENCES public.tb_subestacao(id_subestacao) ON DELETE CASCADE;


-- Completed on 2025-04-16 00:37:16 UTC

--
-- PostgreSQL database dump complete
--

