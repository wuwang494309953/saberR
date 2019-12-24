FROM mysql:5.7
COPY ./saber_authr.sql /docker-entrypoint-initdb.d