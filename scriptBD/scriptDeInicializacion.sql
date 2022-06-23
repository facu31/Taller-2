drop database IF EXISTS  taller2;
CREATE DATABASE taller2;
use taller2;
-- esto crea un usuario para que se conecte la aplicacion
CREATE USER IF NOT EXISTS 'usrtaller'@'localhost' IDENTIFIED BY 'passusrtaller';
GRANT ALL ON *.* TO 'usrtaller'@'localhost';

create table profesores (
	id int not null auto_increment primary key,
    nombre varchar(20),
    apellido varchar(20),
    direccion varchar(20),
    email varchar(30),
    fecha_nacimiento date
);
    