CREATE DATABASE contacts
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Hungarian_Hungary.1250'
    LC_CTYPE = 'Hungarian_Hungary.1250'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

GRANT ALL ON DATABASE contacts TO postgres;

GRANT TEMPORARY, CONNECT ON DATABASE contacts TO PUBLIC;

