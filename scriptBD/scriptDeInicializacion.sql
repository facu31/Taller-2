drop database IF EXISTS  taller2;
CREATE DATABASE taller2;
use taller2;
-- esto crea un usuario para que se conecte la aplicacion
CREATE USER IF NOT EXISTS 'usrtaller'@'localhost' IDENTIFIED BY 'passusrtaller';
/* GRANT ALL ON *.* TO 'usrtaller'@'localhost'; */

create table profesores (
	id int not null auto_increment primary key,
    nombre varchar(20),
    apellido varchar(20),
    direccion varchar(20),
    email varchar(30),
    fecha_nacimiento date
);

create table pruebas (
	id int not null primary key,
    titulo varchar(20),
    descripcion varchar (50)
);

create table preguntas (
	id int not null  primary key,
    enunciado varchar(100) not null,
    idOpcionCorrecta int not null
);

create table pruebaPreguntas (
	idPrueba int not null,
    idPregunta int not null,
    primary key (idPrueba, idPregunta),
    foreign key (idPrueba) references pruebas(id),
    foreign key (idPregunta) references preguntas(id)
);

create table opcionesPreguntas (
	idOpcion int not null,
	idPregunta int not null,
    descripcion varchar(30) not null,
    primary key (idPregunta, idOpcion),
    foreign key (idPregunta) references preguntas(id)
);

insert into pruebas (id, titulo, descripcion) values (1, "Prueba 1", "Esto es la prueba 1");
insert into pruebas (id, titulo, descripcion) values (2, "Prueba 2", "Esto es la prueba 2");
insert into pruebas (id, titulo, descripcion) values (3, "Prueba 3", "Esto es la prueba 3");

insert into preguntas (id, enunciado, idOpcionCorrecta) values (1, "¿(aca va la pregunta A)?", 1);
insert into opcionesPreguntas (idOpcion, idPregunta, descripcion) values (1,1,"Verdadero");
insert into opcionesPreguntas (idOpcion, idPregunta, descripcion) values (2,1,"Falso");
 
insert into preguntas (id, enunciado, idOpcionCorrecta) values (2, "¿(aca va la pregunta B)?", 1);
insert into opcionesPreguntas (idOpcion, idPregunta, descripcion) values (1,2,"Verdadero");
insert into opcionesPreguntas (idOpcion, idPregunta, descripcion) values (2,2,"Falso");

insert into preguntas (id, enunciado, idOpcionCorrecta) values (3, "¿(aca va la pregunta C)?", 4);
insert into opcionesPreguntas (idOpcion, idPregunta, descripcion) values (1,3,"Opcion 1");
insert into opcionesPreguntas (idOpcion, idPregunta, descripcion) values (2,3,"Opcion 2");
insert into opcionesPreguntas (idOpcion, idPregunta, descripcion) values (3,3,"Opcion 3");
insert into opcionesPreguntas (idOpcion, idPregunta, descripcion) values (4,3,"Opcion 4");

insert into preguntas (id, enunciado, idOpcionCorrecta) values (4, "¿(aca va la pregunta D)?", 1);
insert into opcionesPreguntas (idOpcion, idPregunta, descripcion) values (1,4,"Verdadero");
insert into opcionesPreguntas (idOpcion, idPregunta, descripcion) values (2,4,"Falso");

insert into preguntas (id, enunciado, idOpcionCorrecta) values (5, "¿(aca va la pregunta E)?", 2);
insert into opcionesPreguntas (idOpcion, idPregunta, descripcion) values (1,5,"Opcion 1b");
insert into opcionesPreguntas (idOpcion, idPregunta, descripcion) values (2,5,"Opcion 2b");
insert into opcionesPreguntas (idOpcion, idPregunta, descripcion) values (3,5,"Opcion 3b");


insert into preguntas (id, enunciado, idOpcionCorrecta) values (6, "¿(aca va la pregunta F)?", 1);
insert into opcionesPreguntas (idOpcion, idPregunta, descripcion) values (1,6,"Verdadero");
insert into opcionesPreguntas (idOpcion, idPregunta, descripcion) values (2,6,"Falso");

insert into preguntas (id, enunciado, idOpcionCorrecta) values (7, "¿(aca va la pregunta G)?", 2);
insert into opcionesPreguntas (idOpcion, idPregunta, descripcion) values (1,7,"Verdadero");
insert into opcionesPreguntas (idOpcion, idPregunta, descripcion) values (2,7,"Falso");

insert into pruebaPreguntas (idPrueba, idPregunta) values (1,1);
insert into pruebaPreguntas (idPrueba, idPregunta) values (1,2);
insert into pruebaPreguntas (idPrueba, idPregunta) values (1,6);
insert into pruebaPreguntas (idPrueba, idPregunta) values (1,7);

insert into pruebaPreguntas (idPrueba, idPregunta) values (2,1);
insert into pruebaPreguntas (idPrueba, idPregunta) values (2,6);
insert into pruebaPreguntas (idPrueba, idPregunta) values (2,7);

insert into pruebaPreguntas (idPrueba, idPregunta) values (3,3);
insert into pruebaPreguntas (idPrueba, idPregunta) values (3,4);
insert into pruebaPreguntas (idPrueba, idPregunta) values (3,5);



    