INSERT INTO tb_users(type, created_At, created_By, name, email, password) VALUES ('A','2023-12-19', 1, 'Davi','davi@suportinf.com', '123456')

INSERT INTO tb_parts (name, price, quantity) VALUES ('memoria ram', 75.00,3);
INSERT INTO tb_parts (name, price, quantity) VALUES ('HD', 175.00,8);
INSERT INTO tb_parts (name, price, quantity) VALUES ('SSD', 300.00,20);

INSERT INTO tb_authorizations (id,created_at, answered_at, is_accept) VALUES (1,'2023-12-19','2023-12-23T00:00:00.000Z','true')
INSERT INTO tb_authorizations (id,created_at, answered_at, is_accept) VALUES (2,'2023-12-19','2023-12-23T00:00:00.000Z','false')
INSERT INTO tb_authorizations (id,created_at) VALUES (3,'2023-12-19')

