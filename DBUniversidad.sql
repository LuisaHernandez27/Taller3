create database db_Universidad
go
use db_Universidad
go

create table tblFacultad(
codFacultad int identity(1,1) primary key,
descripcion varchar(50) not null
)

create table tblProgramaAcademico(

codPrograma int identity(1,1) primary key,
descripcion varchar(50) not null,
codFacultad int foreign key references tblFacultad(codFacultad)

)

create table tblEstudiante(
codEstudiante int identity(1,1) primary key,
nombreEstudiante varchar(50) not null,
apellidoEstudiante varchar(50) not null,
fechaNacimiento varchar(50) not null,
celuar varchar(11),
email varchar(150) not null,
estado varchar(20) not null
)

create table tblMatricula(

codEstudiante int,
codPrograma int,
primary key(codEstudiante, codPrograma),
foreign key(codEstudiante) references tblEstudiante(codEstudiante),
foreign key (codPrograma) references tblProgramaAcademico(codPrograma),

)

create table tblUsuario(
CodUsuario int identity(1,1) primary key,
codEstudiante int,
TipoUsuario varchar(7) not null,
NombreUsuario varchar(12)not null,
Contrasena varchar(12) not null,

)

 INSERT INTO tblUsuario(TipoUsuario,NombreUsuario,Contrasena)
  VALUES ('Admin','admin','admin');