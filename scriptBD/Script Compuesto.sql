
drop database IF EXISTS  taller2;
CREATE DATABASE taller2;
use taller2;
-- esto crea un usuario para que se conecte la aplicacion
/* CREATE USER IF NOT EXISTS 'usrtaller'@'localhost' IDENTIFIED BY 'passusrtaller'; -*/

 GRANT ALL ON *.* TO 'usrtaller'@'localhost';

create table profesores (
	id int not null auto_increment primary key,
    nombre varchar(20),
    apellido varchar(20),
    direccion varchar(20),
    email varchar(30),
    fecha_nacimiento date
);

create table materias (
	idMateria int not null,
	descripcion varchar(30) not null,
	primary key (idMateria));
	
create table temas (
	idTema int not null,
	idMateria int not null,
	descripcion varchar(30) not null,
	primary key (idTema),
	foreign key (idMateria) references materias(idMateria));
    
create table pruebas (
	id int not null primary key,
    titulo varchar(20),
    descripcion varchar (50)
);

create table preguntas (
	id int not null  primary key,
    enunciado varchar(100) not null,
    idOpcionCorrecta int not null,
    idTema int not null,
    foreign key (idTema) references temas (idTema)
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

insert into materias (idMateria, descripcion) values (1,"Materia A");
insert into materias (idMateria, descripcion) values (2,"Materia B");
insert into materias (idMateria, descripcion) values (3,"Materia C");

insert into temas (idTema,idMateria, descripcion) values (1,1,"Tema 1 de materia A");
insert into temas (idTema,idMateria, descripcion) values (2,1,"Tema 2 de materia A");
insert into temas (idTema,idMateria, descripcion) values (3,1,"Tema 3 de materia A");

insert into temas (idTema,idMateria, descripcion) values (4,2,"Tema 4 de materia B");
insert into temas (idTema,idMateria, descripcion) values (5,2,"Tema 5 de materia B");
insert into temas (idTema,idMateria, descripcion) values (6,2,"Tema 6 de materia B");

insert into pruebas (id, titulo, descripcion) values (1, "Prueba Prog", "Programación 1");
insert into pruebas (id, titulo, descripcion) values (2, "Prueba Prog 3", "Programacion 3");
insert into pruebas (id, titulo, descripcion) values (3, "Prueba Logica", "Logica");

insert into preguntas (id, enunciado, idOpcionCorrecta, idTema) values (1, "¿Existe  una opción en eclipse para genearar automaticamente los Getter And Setter?", 1, 1);
insert into opcionesPreguntas (idOpcion, idPregunta, descripcion) values (1,1,"Verdadero");
insert into opcionesPreguntas (idOpcion, idPregunta, descripcion) values (2,1,"Falso");
 
insert into preguntas (id, enunciado, idOpcionCorrecta, idTema) values (2, "¿Un Cin y Cout son palabras del lenguaje C++?", 1, 1);
insert into opcionesPreguntas (idOpcion, idPregunta, descripcion) values (1,2,"Verdadero");
insert into opcionesPreguntas (idOpcion, idPregunta, descripcion) values (2,2,"Falso");

insert into preguntas (id, enunciado, idOpcionCorrecta, idTema) values (3, "¿Java es un lenguaje de programación ... ?", 4, 1);
insert into opcionesPreguntas (idOpcion, idPregunta, descripcion) values (1,3,"Atomico");
insert into opcionesPreguntas (idOpcion, idPregunta, descripcion) values (2,3,"Binario");
insert into opcionesPreguntas (idOpcion, idPregunta, descripcion) values (3,3,"Estadistico");
insert into opcionesPreguntas (idOpcion, idPregunta, descripcion) values (4,3,"Orientado a Objetos");

insert into preguntas (id, enunciado, idOpcionCorrecta, idTema) values (4, "¿Java es un lenguaje de programación copilado?", 1, 3);
insert into opcionesPreguntas (idOpcion, idPregunta, descripcion) values (1,4,"Verdadero");
insert into opcionesPreguntas (idOpcion, idPregunta, descripcion) values (2,4,"Falso");

insert into preguntas (id, enunciado, idOpcionCorrecta, idTema) values (5, "¿Cual de estos no es una palabra reservada en Java?", 3, 3);
insert into opcionesPreguntas (idOpcion, idPregunta, descripcion) values (1,5,"Sistem.out...");
insert into opcionesPreguntas (idOpcion, idPregunta, descripcion) values (2,5,"int");
insert into opcionesPreguntas (idOpcion, idPregunta, descripcion) values (3,5,"Varchar");

insert into preguntas (id, enunciado, idOpcionCorrecta, idTema) values (6, "¿(Los Punteros guardan una dirección en memoria)?", 1, 3);
insert into opcionesPreguntas (idOpcion, idPregunta, descripcion) values (1,6,"Verdadero");
insert into opcionesPreguntas (idOpcion, idPregunta, descripcion) values (2,6,"Falso");

insert into preguntas (id, enunciado, idOpcionCorrecta, idTema) values (7, "¿(Se considera Tautologia cuando todos los valores son 1)?", 1, 5);
insert into opcionesPreguntas (idOpcion, idPregunta, descripcion) values (1,7,"Verdadero");
insert into opcionesPreguntas (idOpcion, idPregunta, descripcion) values (2,7,"Falso");

insert into preguntas (id, enunciado, idOpcionCorrecta, idTema) values (8, "¿(La compuerta AND es similar a la conjunción)?", 1, 5);
insert into opcionesPreguntas (idOpcion, idPregunta, descripcion) values (1,8,"Verdadero");
insert into opcionesPreguntas (idOpcion, idPregunta, descripcion) values (2,8,"Falso");

insert into preguntas (id, enunciado, idOpcionCorrecta, idTema) values (9, "¿(Indique cual es el opuesto de P)?", 1, 5);
insert into opcionesPreguntas (idOpcion, idPregunta, descripcion) values (1,9,"q");
insert into opcionesPreguntas (idOpcion, idPregunta, descripcion) values (2,9,"P");
insert into opcionesPreguntas (idOpcion, idPregunta, descripcion) values (3,9,"q");

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


    