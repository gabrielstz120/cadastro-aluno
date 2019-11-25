create table cad_alunos (
 bigint id,
 varchar(150) nome,
 integer idade,
 varchar(100) escolaridade,
 varchar(100) cursando,
 varchar(150) nome_pai,
 varchar(150) nome_mae,
 varchar(255) endereco,
 timestamp nascimento,
 varchar(100) bairro,
 varchar(100) cidade,
 primary key (id)
);
create sequence seq_cad_alunos as bigint star with 1 increment by 1 minvalue 1; 