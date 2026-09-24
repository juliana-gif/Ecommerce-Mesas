-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(1, 'field-1');
-- insert into myentity (id, field) values(2, 'field-2');
-- insert into myentity (id, field) values(3, 'field-3');
-- alter sequence myentity_seq restart with 4;

insert into fornecedor (nome, cnpj) values('Fornecedor A', '12345678901234');
insert into mesa (material, modelo, fornecedor_id) values('Metalon', 'Treliça', 1);
insert into mesa (material, modelo, fornecedor_id) values('Pinus', 'Ripada', 1);
insert into mesa (material, modelo, fornecedor_id) values('Aço carbono', 'Sextavada',1 );
insert into mesa (material, modelo, fornecedor_id) values('Acrilico', 'Sinuosa', 1);