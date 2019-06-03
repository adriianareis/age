create database teste;

use teste;

create table exame (
	id int primary key identity(1,1),
	[data] datetime,
	medico varchar(max),
	paciente varchar(max),
	tipo varchar(max),
	endereco varchar(max)
);

insert into exame ([data], medico, paciente, tipo, endereco) values
(getdate(), 'Adriana', 'Pedro', 'Radiografia', 'Av. Ana Costa, 20'),
(getdate(), 'João', 'Gustavo', 'Tomografia', 'Av. Conselheiro Nébias, 40'),
(getdate(), 'Marcio', 'Roberto', 'Radiografia', 'Av. Ana Costa, 20'),
(getdate(), 'Maria', 'Giovana', 'Mamografia', 'Av. Pedro Lessa, 60'),
(getdate(), 'Gisele', 'Byanka', 'Ultra-Sonografia', 'Av. Pedro Lessa, 70'),
(getdate(), 'Alberto', 'José', 'Radiografia', 'Av. Ana Costa, 20');
