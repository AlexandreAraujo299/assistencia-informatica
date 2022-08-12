CREATE TABLE cliente(
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(255) NOT NULL,
	email VARCHAR(255) NOT NULL,
	telefone VARCHAR(255) NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO cliente (nome, email, telefone) VALUES ('Alexandre', 'alexandre@email.com', '(16) 99797-9797');
INSERT INTO cliente (nome, email, telefone) VALUES ('Flor', 'flor@email.com', '(16) 99191-9191');
INSERT INTO cliente (nome, email, telefone) VALUES ('Gabriel', 'gabriel@email.com', '(16) 99292-9292');
INSERT INTO cliente (nome, email, telefone) VALUES ('Otavio', 'otavio@email.com', '(16) 93793-9393');
INSERT INTO cliente (nome, email, telefone) VALUES ('Bianca', 'bianca@email.com', '(16) 99494-9494');