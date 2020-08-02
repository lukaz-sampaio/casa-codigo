CREATE TABLE IF NOT EXISTS pgd.tb_livro (
    id SERIAL PRIMARY KEY,
    data_publicacao DATE,
    isbn VARCHAR(255),
    numero_paginas INT4 NOT NULL CHECK (NUMERO_PAGINAS>=100),
    preco NUMERIC(19, 2) CHECK (PRECO>=20),
    resumo VARCHAR(500),
    sumario VARCHAR(255),
    titulo VARCHAR(255),
    autor_id INT8 REFERENCES pgd.tb_autor (id) NOT NULL,
    categoria_id INT8 REFERENCES pgd.tb_categoria (id) NOT NULL
);
