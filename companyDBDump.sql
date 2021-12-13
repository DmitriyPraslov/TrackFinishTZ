--
-- PostgreSQL database dump
--

-- Dumped from database version 12.8
-- Dumped by pg_dump version 12.8

-- Started on 2021-12-13 17:08:44

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

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 203 (class 1259 OID 16534)
-- Name: Department; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Department" (
    "DepartmentID" integer NOT NULL,
    "DepartmentName" character varying NOT NULL,
    "StartWorkTime" integer NOT NULL,
    "SynchroWork" boolean NOT NULL,
    "ChangeWorkTimePermission" boolean NOT NULL
);


ALTER TABLE public."Department" OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 16556)
-- Name: Department_DepartmentID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Department_DepartmentID_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Department_DepartmentID_seq" OWNER TO postgres;

--
-- TOC entry 2840 (class 0 OID 0)
-- Dependencies: 206
-- Name: Department_DepartmentID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Department_DepartmentID_seq" OWNED BY public."Department"."DepartmentID";


--
-- TOC entry 202 (class 1259 OID 16531)
-- Name: Employee; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Employee" (
    "employeeID" integer NOT NULL,
    "firstName" character varying(30) NOT NULL,
    "lastName" character varying(40) NOT NULL,
    "departmentName" character varying(30) NOT NULL,
    "positionName" character varying(30) NOT NULL,
    salary integer NOT NULL,
    "startWorkTime" integer NOT NULL,
    "workFromHome" boolean NOT NULL
);


ALTER TABLE public."Employee" OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 16537)
-- Name: Employee_employeeID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Employee_employeeID_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Employee_employeeID_seq" OWNER TO postgres;

--
-- TOC entry 2841 (class 0 OID 0)
-- Dependencies: 204
-- Name: Employee_employeeID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Employee_employeeID_seq" OWNED BY public."Employee"."employeeID";


--
-- TOC entry 205 (class 1259 OID 16553)
-- Name: Role; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Role" (
    "positionID" integer NOT NULL,
    "positionName" character varying(40) NOT NULL,
    "changeWorkTimePermission" boolean NOT NULL
);


ALTER TABLE public."Role" OWNER TO postgres;

--
-- TOC entry 207 (class 1259 OID 16567)
-- Name: Role_positionID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Role_positionID_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Role_positionID_seq" OWNER TO postgres;

--
-- TOC entry 2842 (class 0 OID 0)
-- Dependencies: 207
-- Name: Role_positionID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Role_positionID_seq" OWNED BY public."Role"."positionID";


--
-- TOC entry 2701 (class 2604 OID 16558)
-- Name: Department DepartmentID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Department" ALTER COLUMN "DepartmentID" SET DEFAULT nextval('public."Department_DepartmentID_seq"'::regclass);


--
-- TOC entry 2700 (class 2604 OID 16539)
-- Name: Employee employeeID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Employee" ALTER COLUMN "employeeID" SET DEFAULT nextval('public."Employee_employeeID_seq"'::regclass);


--
-- TOC entry 2702 (class 2604 OID 16569)
-- Name: Role positionID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Role" ALTER COLUMN "positionID" SET DEFAULT nextval('public."Role_positionID_seq"'::regclass);


--
-- TOC entry 2706 (class 2606 OID 16566)
-- Name: Department Department_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Department"
    ADD CONSTRAINT "Department_pkey" PRIMARY KEY ("DepartmentID");


--
-- TOC entry 2704 (class 2606 OID 16544)
-- Name: Employee Employee_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Employee"
    ADD CONSTRAINT "Employee_pkey" PRIMARY KEY ("employeeID");


--
-- TOC entry 2708 (class 2606 OID 16574)
-- Name: Role Role_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Role"
    ADD CONSTRAINT "Role_pkey" PRIMARY KEY ("positionID");


-- Completed on 2021-12-13 17:08:44

--
-- PostgreSQL database dump complete
--

