INSERT INTO tb_users(type, created_At, created_By, name, email, password) VALUES ('A','2023-12-19', null, 'Davi','davi@suportinf.com', '123456')
INSERT INTO tb_users(type, created_At, created_By, name, email, password) VALUES ('C','2023-12-19', 1, 'Miguel','miguel@suportinf.com', '123456')
INSERT INTO tb_users(type, created_At, created_By, name, email, password) VALUES ('E','2023-12-19', 1, 'Murilo','murilo@suportinf.com', '123456')

INSERT INTO tb_parts (name, price, quantity) VALUES ('memoria ram', 75.00,3);
INSERT INTO tb_parts (name, price, quantity) VALUES ('HD', 175.00,8);
INSERT INTO tb_parts (name, price, quantity) VALUES ('SSD', 300.00,20);

INSERT INTO tb_services (id, created_At, created_by, customer_id, employee_id) VALUES (1, '2023-12-19', 1, 2,3)
INSERT INTO tb_services (id, created_At, created_by, customer_id, employee_id) VALUES (2, '2023-12-20', 1, 2,3)
INSERT INTO tb_services (id, created_At, created_by, customer_id, employee_id) VALUES (3, '2023-12-21', 1, 2,3)

INSERT INTO tb_authorizations (id,created_at, answered_at, is_accept, service_id) VALUES (1,'2023-12-19','2023-12-23T00:00:00.000Z','true',2)
INSERT INTO tb_authorizations (id,created_at, answered_at, is_accept, service_id) VALUES (2,'2023-12-19','2023-12-23T00:00:00.000Z','false',2)
INSERT INTO tb_authorizations (id,created_at, service_id) VALUES (3,'2023-12-19',3)

