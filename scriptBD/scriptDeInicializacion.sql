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

insert into pruebas (id, titulo, descripcion) values (1, "Prueba 1", "Esto es la prueba 1");
insert into pruebas (id, titulo, descripcion) values (2, "Prueba 2", "Esto es la prueba 2");
insert into pruebas (id, titulo, descripcion) values (3, "Prueba 3", "Esto es la prueba 3");

insert into preguntas (id, enunciado, idOpcionCorrecta, idTema) values (1, "¿(aca va la pregunta A)?", 1, 1);
insert into opcionesPreguntas (idOpcion, idPregunta, descripcion) values (1,1,"Verdadero");
insert into opcionesPreguntas (idOpcion, idPregunta, descripcion) values (2,1,"Falso");
 
insert into preguntas (id, enunciado, idOpcionCorrecta, idTema) values (2, "¿(aca va la pregunta B)?", 2, 1);
insert into opcionesPreguntas (idOpcion, idPregunta, descripcion) values (1,2,"Verdadero");
insert into opcionesPreguntas (idOpcion, idPregunta, descripcion) values (2,2,"Falso");

insert into preguntas (id, enunciado, idOpcionCorrecta, idTema) values (3, "¿(aca va la pregunta C)?", 4, 3);
insert into opcionesPreguntas (idOpcion, idPregunta, descripcion) values (1,3,"Opcion 1");
insert into opcionesPreguntas (idOpcion, idPregunta, descripcion) values (2,3,"Opcion 2");
insert into opcionesPreguntas (idOpcion, idPregunta, descripcion) values (3,3,"Opcion 3");
insert into opcionesPreguntas (idOpcion, idPregunta, descripcion) values (4,3,"Opcion 4");

insert into preguntas (id, enunciado, idOpcionCorrecta, idTema) values (4, "¿(aca va la pregunta D)?", 2, 6);
insert into opcionesPreguntas (idOpcion, idPregunta, descripcion) values (1,4,"Verdadero");
insert into opcionesPreguntas (idOpcion, idPregunta, descripcion) values (2,4,"Falso");

insert into preguntas (id, enunciado, idOpcionCorrecta, idTema) values (5, "¿(aca va la pregunta E)?", 3, 5);
insert into opcionesPreguntas (idOpcion, idPregunta, descripcion) values (1,5,"Opcion 1b");
insert into opcionesPreguntas (idOpcion, idPregunta, descripcion) values (2,5,"Opcion 2b");
insert into opcionesPreguntas (idOpcion, idPregunta, descripcion) values (3,5,"Opcion 3b");


insert into preguntas (id, enunciado, idOpcionCorrecta, idTema) values (6, "¿(aca va la pregunta F)?", 2, 2);
insert into opcionesPreguntas (idOpcion, idPregunta, descripcion) values (1,6,"Verdadero");
insert into opcionesPreguntas (idOpcion, idPregunta, descripcion) values (2,6,"Falso");

insert into preguntas (id, enunciado, idOpcionCorrecta, idTema) values (7, "¿(aca va la pregunta G)?", 1, 4);
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



    