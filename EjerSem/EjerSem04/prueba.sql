CREATE TABLE estudiante(id INTEGER PRIMARY KEY ASC, num_cuenta INTEGER, apellido_paterno TEXT, apellido_materno TEXT, nombres TEXT, sexo TEXT, dia INTEGER, mes INTEGER, anio INTEGER);
CREATE TABLE carrera(id INTEGER PRIMARY KEY ASC, nombre_carrera TEXT, plan_estudios TEXT);
CREATE TABLE profesor(id INTEGER PRIMARY KEY ASC, num_trabajador INTEGER, apellido_paterno TEXT, apellido_materno TEXT, nombres TEXT, sexo TEXT, dia INTEGER, mes INTEGER, anio INTEGER);
CREATE TABLE salon(id INTEGER PRIMARY KEY ASC, num_salon INTEGER, horario TEXT);
CREATE TABLE materia(id INTEGER PRIMARY KEY ASC, nombre TEXT, semestre INTEGER, creditos INTEGER, plan_estudios TEXT);
CREATE TABLE estudiantes_carreras(id INTEGER PRIMARY KEY ASC, id_estudiantes INTEGER, id_carreras INTEGER);
CREATE TABLE estudiantes_salon(id INTEGER PRIMARY KEY ASC, id_estudiantes INTEGER, id_salon INTEGER);
CREATE TABLE estudiantes_materia(id INTEGER PRIMARY KEY ASC, id_estudiantes INTEGER, id_materia INTEGER);
CREATE TABLE salon_profesores(id INTEGER PRIMARY KEY ASC, id_profesores INTEGER, id_salon INTEGER);
CREATE TABLE salon_materia(id INTEGER PRIMARY KEY ASC, id_salon INTEGER, id_materia INTEGER);
