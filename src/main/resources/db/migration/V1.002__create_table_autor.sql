CREATE TABLE IF NOT EXISTS pgd.tb_autor1 (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(80) NOT NULL,
    email VARCHAR(60) NOT NULL,
    descricao VARCHAR(400) NOT NULL,
    data_cadastro TIMESTAMP
);
