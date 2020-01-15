
-- Pacientes

INSERT INTO tb_paciente (nome, sexo, data_nascimento, data_registro, cpf, ativo, rua, numero, distrito, cidade, estado, cep) VALUES ('Maria Silva', 'FEMININO', '1990-11-03', '2017-06-10', '123.152.855-78', true, 'Rua A', 4, 'Bairro A', 'Cidade A', 'Estado A', '11111-111');
INSERT INTO tb_paciente (nome, sexo, data_nascimento, data_registro, cpf, ativo, rua, numero, distrito, cidade, estado, cep) VALUES ('Marcos Augusto', 'MASCULINO', '1985-07-17', '2012-08-10', '183.132.825-99', true, 'Rua B', 5, 'Bairro B', 'Cidade B', 'Estado B', '22222-222');
INSERT INTO tb_paciente (nome, sexo, data_nascimento, data_registro, cpf, ativo, rua, numero, distrito, cidade, estado, cep) VALUES ('Jorge Araujo', 'MASCULINO', '1980-11-25', '2000-10-15', '173.252.827-45', true, 'Rua C', 6, 'Bairro C', 'Cidade C', 'Estado C', '33333-333');
INSERT INTO tb_paciente (nome, sexo, data_nascimento, data_registro, cpf, ativo, rua, numero, distrito, cidade, estado, cep) VALUES ('Fabio Moraes', 'MASCULINO', '1982-12-18', '2011-06-09', '123.152.855-87', true, 'Rua D', 7, 'Bairro D', 'Cidade D', 'Estado D', '44444-444');
INSERT INTO tb_paciente (nome, sexo, data_nascimento, data_registro, cpf, ativo, rua, numero, distrito, cidade, estado, cep) VALUES ('João Cesar Silva', 'MASCULINO', '1975-04-09', '1999-03-04', '163.952.875-23', true, 'Rua E', 8, 'Bairro E', 'Cidade E', 'Estado E', '55555-555');
INSERT INTO tb_paciente (nome, sexo, data_nascimento, data_registro, cpf, ativo, rua, numero, distrito, cidade, estado, cep) VALUES ('Silvia Garcia', 'FEMININO', '2000-11-26', '2015-11-26', '423.188.475-97', true, 'Rua F', 9, 'Bairro F', 'Cidade F', 'Estado F', '66666-666');
INSERT INTO tb_paciente (nome, sexo, data_nascimento, data_registro, cpf, ativo, rua, numero, distrito, cidade, estado, cep) VALUES ('Marta Oliveira', 'FEMININO', '1995-05-06', '2013-10-30', '172.952.655-08', true, 'Rua G', 10, 'Bairro G', 'Cidade G', 'Estado G', '77777-777');
INSERT INTO tb_paciente (nome, sexo, data_nascimento, data_registro, cpf, ativo, rua, numero, distrito, cidade, estado, cep) VALUES ('Silvana Mendes', 'FEMININO', '1991-08-28', '2014-07-22', '188.199.755-04', true, 'Rua H', 11, 'Bairro H', 'Cidade H', 'Estado H', '88888-888');
INSERT INTO tb_paciente (nome, sexo, data_nascimento, data_registro, cpf, ativo, rua, numero, distrito, cidade, estado, cep) VALUES ('Dora Torres', 'FEMININO', '2001-03-07', '2017-02-01', '199.152.855-02', true, 'Rua I', 12, 'Bairro I', 'Cidade I', 'Estado I', '99999-999');
INSERT INTO tb_paciente (nome, sexo, data_nascimento, data_registro, cpf, ativo, rua, numero, distrito, cidade, estado, cep) VALUES ('Vivian Kepler', 'FEMININO', '2002-09-20', '2017-01-31', '183.152.855-01', false, 'Rua J', 12, 'Bairro J', 'Cidade J', 'Estado J', '00000-000');
INSERT INTO tb_paciente (nome, sexo, data_nascimento, data_registro, cpf, ativo, rua, numero, distrito, cidade, estado, cep) VALUES ('Julio Fonseca', 'MASCULINO', '1986-09-11', '2000-01-27', '783.152.435-05', false, 'Rua k', 13, 'Bairro k', 'Cidade k', 'Estado k', '00800-090');


-- Especialidades


INSERT INTO tb_especialidade (nome) VALUES ('Clínico Geral');
INSERT INTO tb_especialidade (nome) VALUES ('Cardiologista');
INSERT INTO tb_especialidade (nome) VALUES ('Dermatologista');
INSERT INTO tb_especialidade (nome) VALUES ('Endrocrinologista');
INSERT INTO tb_especialidade (nome) VALUES ('Oftalmologista');


-- Médicos


INSERT INTO tb_medico (nome, sexo, cd_especialidade, data_registro, data_demissao, crm, ativo, rua, numero, distrito, cidade, estado, cep) VALUES ('Angélica Araujo', 'FEMININO', 1, '2000-08-10', null, '12888', true, 'Rua A', 15, 'Bairro A', 'Cidade A', 'Estado A', '11111-111');
INSERT INTO tb_medico (nome, sexo, cd_especialidade, data_registro, data_demissao, crm, ativo, rua, numero, distrito, cidade, estado, cep) VALUES ('Junior Fontes', 'MASCULINO', 1, '2012-01-10', '2016-07-16', '92998', true, 'Rua B', 16, 'Bairro B', 'Cidade B', 'Estado B', '22222-222');
INSERT INTO tb_medico (nome, sexo, cd_especialidade, data_registro, data_demissao, crm, ativo, rua, numero, distrito, cidade, estado, cep) VALUES ('Mario Oliveira', 'MASCULINO', 2, '2000-11-10', null, '82888', true, 'Rua C', 17, 'Bairro C', 'Cidade C', 'Estado C', '33333-333');
INSERT INTO tb_medico (nome, sexo, cd_especialidade, data_registro, data_demissao, crm, ativo, rua, numero, distrito, cidade, estado, cep) VALUES ('Fabio Mattos', 'MASCULINO', 3, '2011-08-09', null, '22989', true, 'Rua D', 18, 'Bairro D', 'Cidade D', 'Estado D', '44444-444');
INSERT INTO tb_medico (nome, sexo, cd_especialidade, data_registro, data_demissao, crm, ativo, rua, numero, distrito, cidade, estado, cep) VALUES ('João Augusto', 'MASCULINO', 4, '1999-01-04', null, '72778', true, 'Rua E', 19, 'Bairro E', 'Cidade E', 'Estado E', '55555-555');
INSERT INTO tb_medico (nome, sexo, cd_especialidade, data_registro, data_demissao, crm, ativo, rua, numero, distrito, cidade, estado, cep) VALUES ('Silviana Santos', 'FEMININO', 5, '2015-01-26', null, '62799', true, 'Rua F', 20, 'Bairro F', 'Cidade F', 'Estado F', '66666-666');


-- Consultas


INSERT INTO tb_consulta (cd_medico, cd_paciente, status_consulta, valor, data_hora_consulta, descricao) VALUES (1, 1,'REALIZADA' , 50.0, '2017-05-29 10:30:00', 'Resfriado Forte.');
INSERT INTO tb_consulta (cd_medico, cd_paciente, status_consulta, valor, data_hora_consulta, descricao) VALUES (1, 10,'REALIZADA' , 50.0, '2017-05-29 10:30:00', 'Febre Alta.');
INSERT INTO tb_consulta (cd_medico, cd_paciente, status_consulta, valor, data_hora_consulta, descricao) VALUES (4, 6,'CANCELADA' , 90.0, '2015-06-26 14:15:00', 'Manchas na Pele.');
INSERT INTO tb_consulta (cd_medico, cd_paciente, status_consulta, valor, data_hora_consulta, descricao) VALUES (2, 3,'CANCELADA' , 50.0, '2015-05-12 14:15:00', 'Resultado de Exames.');
INSERT INTO tb_consulta (cd_medico, cd_paciente, status_consulta, valor, data_hora_consulta, descricao) VALUES (2, 3,'REALIZADA' , 50.0, '2016-05-22 14:30:00', 'Resultado de Exames.');
INSERT INTO tb_consulta (cd_medico, cd_paciente, status_consulta, valor, data_hora_consulta, descricao) VALUES (3, 4,'PENDENTE' , 150.0, '2017-12-26 10:30:00', 'Palpitações.');
INSERT INTO tb_consulta (cd_medico, cd_paciente, status_consulta, valor, data_hora_consulta, descricao) VALUES (6, 1,'PENDENTE' , 120.0, '2017-10-06 14:30:00', 'Solicitação de Exames.');
INSERT INTO tb_consulta (cd_medico, cd_paciente, status_consulta, valor, data_hora_consulta, descricao) VALUES (1, 5,'PENDENTE' , 50.0, '2017-08-18 09:45:00', 'Solicitar Exames de Rotina.');
INSERT INTO tb_consulta (cd_medico, cd_paciente, status_consulta, valor, data_hora_consulta, descricao) VALUES (5, 5,'PENDENTE' , 150.0, '2017-09-19 16:00:00', 'Tratamento Tireoide');
INSERT INTO tb_consulta (cd_medico, cd_paciente, status_consulta, valor, data_hora_consulta, descricao) VALUES (1, 7,'PENDENTE' , 50.0, '2017-12-10 17:15:00', 'Consulta de Rotina');