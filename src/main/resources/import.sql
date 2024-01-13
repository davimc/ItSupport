INSERT INTO tb_users(id,type, created_At, created_By, name, email, password) VALUES ('4cdd3af0-76f5-4b57-82ac-0a6c65c7045e','A','2023-12-19T00:00:00.000Z', null, 'Davi','davi@suportinf.com', '123456')
INSERT INTO tb_users(id,type, created_At, created_By, name, email, password) VALUES ('d196d1f5-2a52-41b6-8495-870f278df77c','C','2023-12-19T00:00:00.000Z', '4cdd3af0-76f5-4b57-82ac-0a6c65c7045e', 'Miguel','miguel@suportinf.com', '123456')
INSERT INTO tb_users(id,type, created_At, created_By, name, email, password) VALUES ('ec1bdcad-0ccd-4d8c-9b64-d157cb7abf37','E','2023-12-19T00:00:00.000Z', '4cdd3af0-76f5-4b57-82ac-0a6c65c7045e', 'Murilo','murilo@suportinf.com', '123456')

INSERT INTO tb_parts (id,name, price, quantity) VALUES ('b0625424-ad36-40e1-843a-c158b90ae753','memoria ram', 75.00,3);
INSERT INTO tb_parts (id,name, price, quantity) VALUES ('1d776772-5611-4a0e-b502-d2885dc89d36','HD', 175.00,8);
INSERT INTO tb_parts (id,name, price, quantity) VALUES ('6d613899-c0f0-4d8e-801a-b828e61914b4','SSD', 300.00,20);

INSERT INTO tb_services (id, created_At, created_by, customer_id, employee_id) VALUES ('d7bd149f-1e3c-403f-9318-b790cc910e0c', '2023-12-19T00:00:00.000Z', '4cdd3af0-76f5-4b57-82ac-0a6c65c7045e', 'd196d1f5-2a52-41b6-8495-870f278df77c','ec1bdcad-0ccd-4d8c-9b64-d157cb7abf37')
INSERT INTO tb_services (id, created_At, created_by, customer_id, employee_id) VALUES ('7a52a65a-4271-455a-a022-18b36305cafb', '2023-12-20T00:00:00.000Z', '4cdd3af0-76f5-4b57-82ac-0a6c65c7045e', 'd196d1f5-2a52-41b6-8495-870f278df77c','ec1bdcad-0ccd-4d8c-9b64-d157cb7abf37')
INSERT INTO tb_services (id, created_At, created_by, customer_id, employee_id) VALUES ('534eb9d6-3ad6-4602-b10a-5310471e16b4', '2023-12-21T00:00:00.000Z', '4cdd3af0-76f5-4b57-82ac-0a6c65c7045e', 'd196d1f5-2a52-41b6-8495-870f278df77c','ec1bdcad-0ccd-4d8c-9b64-d157cb7abf37')

