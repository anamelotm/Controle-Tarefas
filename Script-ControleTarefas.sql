create database agenda_tarefas;

use agenda_tarefas;

create table colaborador(
	idColaborador int auto_increment not null primary key,
	nomeColaborador varchar(30) not null
);

create table tarefa(
	idTarefa int auto_increment not null,
	idColaborador int not null,
	descrTarefa varchar(50),
	dataHoraInicio timestamp,
	dataHoraFim timestamp not null,
	statusTarefa varchar(15),
	prioridadeTarefa varchar(15),
	primary key (idTarefa, idColaborador)
);

desc tarefa;
desc colaborador;
select * from colaborador c ;
select * from tarefa;

alter table tarefa add constraint fk_tarefa_colaborador foreign key (idColaborador) references colaborador(idColaborador);

alter table tarefa change descrTarefa descrTarefa varchar(50) not null;

select idColaborador, nomeColaborador from colaborador c ;
select idColaborador, nomeColaborador from colaborador where idColaborador = 1;

insert into colaborador values(1, "Joao");
insert into tarefa(idTarefa, idColaborador, descrTarefa, dataHoraInicio, dataHoraFim) values(null,1,"blablabla",'2021-10-12 11:00','2021-10-20 12:00');

update tarefa set descrTarefa = "Alterado", dataHoraFim = '2021-10-30 11:00' where idTarefa = 1;

select idTarefa, idColaborador, descrTarefa, dataHoraInicio, dataHoraFim, statusTarefa, prioridadeTarefa from tarefa;
drop table colaborador ;
drop table tarefa;
delete from tarefa where idTarefa = 2;