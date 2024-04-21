-- LOCAL
INSERT INTO TB_LOCALS (id, name) VALUES ('b0625424-ad36-40e1-843a-c158b90ae753', 'Gaveta Organizadora')
INSERT INTO TB_LOCALS (id, name) VALUES ('1d776772-5611-4a0e-b502-d2885dc89d36', 'Estante')
INSERT INTO TB_LOCALS (id, name) VALUES ('6d613899-c0f0-4d8e-801a-b828e61914b4', 'Mostruário')

INSERT INTO tb_users (id, name, email, password) VALUES ('4cdd3af0-76f5-4b57-82ac-0a6c65c7045e', 'Davi', 'davimatosc@hotmail.com','$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG')
--INSERT INTO tb_users (id, name, address, email, cpf, password) VALUES ('4cdd3af0-76f5-4b57-82ac-0a6c65c7045e', 'Davi', 'Rua dos Prazeres Centro', 'davimatosc@hotmail.com','60727289365','12345')

INSERT INTO tb_role (id,authority) VALUES ('f027448b-3208-4828-b6c5-b3a1970dbb8b','ROLE_USUARIO');
INSERT INTO tb_role (id,authority) VALUES ('d103f299-de10-4025-9c30-0c96d334ae21','ROLE_LOJISTA');

INSERT INTO tb_user_role (user_id, role_id) VALUES ('4cdd3af0-76f5-4b57-82ac-0a6c65c7045e', 'd103f299-de10-4025-9c30-0c96d334ae21');


INSERT INTO tb_contacts (id, type, contact, preferential, user_id) VALUES ('d7bd149f-1e3c-403f-9318-b790cc910e0c', 2, '98984121438', true,'4cdd3af0-76f5-4b57-82ac-0a6c65c7045e')


INSERT INTO tb_parts (id, name, price, percentage_Sale, quantity, local_id) VALUES ('d196d1f5-2a52-41b6-8495-870f278df77c', 'FONTE 250W', 40.0, 0.4, 1,'1d776772-5611-4a0e-b502-d2885dc89d36')
INSERT INTO tb_parts (id, name, price, percentage_Sale, quantity, local_id) VALUES ('f47031e5-3cf5-4a55-9ae6-b1b800240c44', 'PLACA MÃE 1155',160.5,0.3, 2,'6d613899-c0f0-4d8e-801a-b828e61914b4')

INSERT INTO tb_devices (id, created_at, owner_id, type, brand, model, characteristics, obs) VALUES ('ec1bdcad-0ccd-4d8c-9b64-d157cb7abf37', '2023-12-19T00:00:00.000Z', '4cdd3af0-76f5-4b57-82ac-0a6c65c7045e', 1, 'vaio','H303MVE','Branco; rachado no canto esquerdo; marcas de uso','Foi manipulado por outro técnico')
INSERT INTO tb_devices (id, created_at, owner_id, type, brand, model, characteristics) VALUES ('1f7a13e9-3d87-4fc2-ba2a-877d414bdbec', '2023-12-19T00:00:00.000Z', '4cdd3af0-76f5-4b57-82ac-0a6c65c7045e', 1, 'ACER','ASPIRE5432','Preto; novo; sem marcas de uso')

INSERT INTO tb_jobs(id, created_at, description, type) VALUES ('534eb9d6-3ad6-4602-b10a-5310471e16b4', '2023-12-19T00:00:00.000Z', 'SE POSSÍVEL ENTREGAR EM 4 DIAS',0)


INSERT INTO tb_jobs_devices (job_id, device_id) VALUES ('534eb9d6-3ad6-4602-b10a-5310471e16b4','ec1bdcad-0ccd-4d8c-9b64-d157cb7abf37')
INSERT INTO tb_jobs_devices (job_id, device_id) VALUES ('534eb9d6-3ad6-4602-b10a-5310471e16b4','1f7a13e9-3d87-4fc2-ba2a-877d414bdbec')

INSERT INTO tb_tasks (id, created_At, type, job_id, device_id, description) VALUES ('4473710b-8f84-4186-8aa1-d94761cc30cd','2023-12-19T00:00:00.000Z', 1, '534eb9d6-3ad6-4602-b10a-5310471e16b4', 'ec1bdcad-0ccd-4d8c-9b64-d157cb7abf37', 'Manutenção da placa mãe')

INSERT INTO tb_tasks_parts(id, quantity, price, part_id, task_id) VALUES ('11daf151-2dc5-4960-8160-e57751b3b97b', 2, 30, 'd196d1f5-2a52-41b6-8495-870f278df77c','4473710b-8f84-4186-8aa1-d94761cc30cd')

--
--

--

--

--9a773374-56e1-490d-bba5-ff408d759a34

--e9e1558d-58a5-4162-97b5-acd399fd9f89

--160a45ec-8362-4aa9-9e60-238f50ecd668

--2e9a2f3f-d674-48f9-b3c0-9a1db0960eb6

--185da9e3-30c3-4da6-b587-19eea39aa3ee

--143c2ff0-e07f-4735-bd69-dd60d5efc5b0

--91e25d2b-5b07-4560-ac32-4f288570b4cb

--7801a6a6-9a2c-414b-b376-5679d566cbe4

--2577c035-7803-43d7-aaee-bd78f9ce1ee7

--ee3f292c-7c70-4001-b452-706dfd20c752

--bf5f26dc-423a-47a0-92b9-1e8abc0c7294