drop database IF EXISTS  taller2;
CREATE DATABASE taller2;
use taller2;

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

insert into pruebas (id, titulo, descripcion) values (1, "Prueba Prog", "Programación 1");
insert into pruebas (id, titulo, descripcion) values (2, "Prueba Prog 3", "Programacion 3");
insert into pruebas (id, titulo, descripcion) values (3, "Prueba Logica", "Logica");

insert into preguntas (id, enunciado, idOpcionCorrecta) values (1, "¿Existe  una opción en eclipse para genearar automaticamente los Getter And Setter?", 1);
insert into opcionesPreguntas (idOpcion, idPregunta, descripcion) values (1,1,"Verdadero");
insert into opcionesPreguntas (idOpcion, idPregunta, descripcion) values (2,1,"Falso");
 
insert into preguntas (id, enunciado, idOpcionCorrecta) values (2, "¿Un Cin y Cout son palabras del lenguaje C++?", 1);
insert into opcionesPreguntas (idOpcion, idPregunta, descripcion) values (1,2,"Verdadero");
insert into opcionesPreguntas (idOpcion, idPregunta, descripcion) values (2,2,"Falso");

insert into preguntas (id, enunciado, idOpcionCorrecta) values (3, "¿Java es un lenguaje de programación ... ?", 4);
insert into opcionesPreguntas (idOpcion, idPregunta, descripcion) values (1,3,"Atomico");
insert into opcionesPreguntas (idOpcion, idPregunta, descripcion) values (2,3,"Binario");
insert into opcionesPreguntas (idOpcion, idPregunta, descripcion) values (3,3,"Estadistico");
insert into opcionesPreguntas (idOpcion, idPregunta, descripcion) values (4,3,"Orientado a Objetos");

insert into preguntas (id, enunciado, idOpcionCorrecta) values (4, "¿Java es un lenguaje de programación copilado?", 1);
insert into opcionesPreguntas (idOpcion, idPregunta, descripcion) values (1,4,"Verdadero");
insert into opcionesPreguntas (idOpcion, idPregunta, descripcion) values (2,4,"Falso");

insert into preguntas (id, enunciado, idOpcionCorrecta) values (5, "¿Cual de estos no es una palabra reservada en Java?", 3);
insert into opcionesPreguntas (idOpcion, idPregunta, descripcion) values (1,5,"Sistem.out...");
insert into opcionesPreguntas (idOpcion, idPregunta, descripcion) values (2,5,"int");
insert into opcionesPreguntas (idOpcion, idPregunta, descripcion) values (3,5,"Varchar");

insert into preguntas (id, enunciado, idOpcionCorrecta) values (6, "¿(Los Punteros guardan una dirección en memoria)?", 1);
insert into opcionesPreguntas (idOpcion, idPregunta, descripcion) values (1,6,"Verdadero");
insert into opcionesPreguntas (idOpcion, idPregunta, descripcion) values (2,6,"Falso");

insert into preguntas (id, enunciado, idOpcionCorrecta) values (7, "¿(Se considera Tautologia cuando todos los valores son 1)?", 1);
insert into opcionesPreguntas (idOpcion, idPregunta, descripcion) values (1,7,"Verdadero");
insert into opcionesPreguntas (idOpcion, idPregunta, descripcion) values (2,7,"Falso");

insert into preguntas (id, enunciado, idOpcionCorrecta) values (8, "¿(La compuerta AND es similar a la conjunción)?", 1);
insert into opcionesPreguntas (idOpcion, idPregunta, descripcion) values (1,8,"Verdadero");
insert into opcionesPreguntas (idOpcion, idPregunta, descripcion) values (2,8,"Falso");

insert into preguntas (id, enunciado, idOpcionCorrecta) values (9, "¿(Indique cual es el opuesto de P)?", 1);
insert into opcionesPreguntas (idOpcion, idPregunta, descripcion) values (1,9,"q");
insert into opcionesPreguntas (idOpcion, idPregunta, descripcion) values (2,9,"P");
insert into opcionesPreguntas (idOpcion, idPregunta, descripcion) values (3,9,"q");

insert into pruebaPreguntas (idPrueba, idPregunta) values (1,1);
insert into pruebaPreguntas (idPrueba, idPregunta) values (1,2);
insert into pruebaPreguntas (idPrueba, idPregunta) values (1,3);
insert into pruebaPreguntas (idPrueba, idPregunta) values (1,4);

insert into pruebaPreguntas (idPrueba, idPregunta) values (2,1);
insert into pruebaPreguntas (idPrueba, idPregunta) values (2,6);
insert into pruebaPreguntas (idPrueba, idPregunta) values (2,4);

insert into pruebaPreguntas (idPrueba, idPregunta) values (3,7);
insert into pruebaPreguntas (idPrueba, idPregunta) values (3,8);
insert into pruebaPreguntas (idPrueba, idPregunta) values (3,9);

