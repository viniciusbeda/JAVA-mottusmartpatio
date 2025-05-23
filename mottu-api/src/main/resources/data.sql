-- Inserção de motos
INSERT INTO moto (placa, modelo, status) VALUES ('ABC1234', 'Honda CG 160', 'Ativa');
INSERT INTO moto (placa, modelo, status) VALUES ('XYZ5678', 'Yamaha Factor', 'Inativa');
INSERT INTO moto (placa, modelo, status) VALUES ('DEF9876', 'Suzuki Intruder', 'Em manutenção');

-- Inserção de manutenções
INSERT INTO manutencao (descricao, data, moto_id) VALUES ('Troca de óleo', '2025-05-01', 1);
INSERT INTO manutencao (descricao, data, moto_id) VALUES ('Revisão geral', '2025-05-10', 2);
INSERT INTO manutencao (descricao, data, moto_id) VALUES ('Substituição de pneu', '2025-05-15', 1);
