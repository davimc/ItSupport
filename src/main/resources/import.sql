-- LOCAL
INSERT INTO TB_LOCALS (id, name) VALUES ('b0625424-ad36-40e1-843a-c158b90ae753', 'Gaveta Organizadora')
INSERT INTO TB_LOCALS (id, name) VALUES ('1d776772-5611-4a0e-b502-d2885dc89d36', 'Estante')
INSERT INTO TB_LOCALS (id, name) VALUES ('6d613899-c0f0-4d8e-801a-b828e61914b4', 'Mostruário')

INSERT INTO tb_users (id, name, endereco, cpf, password) VALUES ('4cdd3af0-76f5-4b57-82ac-0a6c65c7045e', 'Davi', 'Rua dos Prazeres Centro', '60727289365','12345')

INSERT INTO tb_contacts (id, type, contact, preferential, user_id) VALUES ('d7bd149f-1e3c-403f-9318-b790cc910e0c', 2, '98984121438', true,'4cdd3af0-76f5-4b57-82ac-0a6c65c7045e')


INSERT INTO tb_parts (id, name, price, percentage_Sale, quantity, local_id) VALUES ('d196d1f5-2a52-41b6-8495-870f278df77c', 'FONTE 250W', 40.0, 0.4, 1,'1d776772-5611-4a0e-b502-d2885dc89d36')
INSERT INTO tb_parts (id, name, price, percentage_Sale, quantity, local_id) VALUES ('f47031e5-3cf5-4a55-9ae6-b1b800240c44', 'PLACA MÃE 1155',160.5,0.3, 2,'6d613899-c0f0-4d8e-801a-b828e61914b4')



--INSERT INTO tb_audits (id, audit_date, obs, type) VALUES (, '2024-01-14T12:18:00.000Z', )
-- admin

--INSERT INTO tb_users(id, name, email, password) VALUES (,'davi@suportinf.com', '123456')
--INSERT INTO tb_audits(id, user_id, auditable_id, type, audit_Date) VALUES (,'4cdd3af0-76f5-4b57-82ac-0a6c65c7045e','d196d1f5-2a52-41b6-8495-870f278df77c',1,'2023-12-19T00:00:00.000Z')
--INSERT INTO tb_users(id, name, email, password) VALUES (, 'Miguel','miguel@suportinf.com', '123456')

--INSERT INTO tb_audits(id, user_id, auditable_id, type, audit_Date) VALUES (,'4cdd3af0-76f5-4b57-82ac-0a6c65c7045e','ec1bdcad-0ccd-4d8c-9b64-d157cb7abf37',1,'2023-12-19T00:00:00.000Z')
--INSERT INTO tb_users(id, name, email, password) VALUES ('ec1bdcad-0ccd-4d8c-9b64-d157cb7abf37', 'Murilo','murilo@suportinf.com', '123456')
-- AUDIT UPDATE
--INSERT INTO tb_audits(id, user_id, auditable_id, type, audit_Date) VALUES ('1f7a13e9-3d87-4fc2-ba2a-877d414bdbec','4cdd3af0-76f5-4b57-82ac-0a6c65c7045e','ec1bdcad-0ccd-4d8c-9b64-d157cb7abf37',2,'2024-01-01T00:00:00.000Z')

--INSERT INTO tb_parts (id,name, price, quantity) VALUES (,'memoria ram', 75.00,3);
--INSERT INTO tb_parts (id,name, price, quantity) VALUES (,'HD', 175.00,8);
--INSERT INTO tb_parts (id,name, price, quantity) VALUES (,'SSD', 300.00,20);

--INSERT INTO tb_services (id, created_At, created_by, customer_id, employee_id) VALUES (, , '4cdd3af0-76f5-4b57-82ac-0a6c65c7045e', 'd196d1f5-2a52-41b6-8495-870f278df77c','ec1bdcad-0ccd-4d8c-9b64-d157cb7abf37')
--INSERT INTO tb_services (id, created_At, created_by, customer_id, employee_id) VALUES (, '2023-12-20T00:00:00.000Z', '4cdd3af0-76f5-4b57-82ac-0a6c65c7045e', 'd196d1f5-2a52-41b6-8495-870f278df77c','ec1bdcad-0ccd-4d8c-9b64-d157cb7abf37')
--INSERT INTO tb_services (id, created_At, created_by, customer_id, employee_id) VALUES ('534eb9d6-3ad6-4602-b10a-5310471e16b4', '2023-12-21T00:00:00.000Z', '4cdd3af0-76f5-4b57-82ac-0a6c65c7045e', 'd196d1f5-2a52-41b6-8495-870f278df77c','ec1bdcad-0ccd-4d8c-9b64-d157cb7abf37')

