CREATE TABLE pgd.tb_livro (
    id BIGSERIAL NOT NULL,
    data_publicacao DATE,
    isbn VARCHAR(255),
    numero_paginas INT4 NOT NULL CHECK (numero_paginas>=100),
    preco NUMERIC(19, 2) NOT NULL CHECK (preco>=20),
    resumo VARCHAR(500),
    sumario VARCHAR(255),
    titulo VARCHAR(255),
    autor_id int8 NOT NULL,
    categoria_id int8 NOT NULL,
    PRIMARY KEY (id)
);
    
ALTER TABLE IF EXISTS pgd.tb_livro 
   ADD CONSTRAINT tb_autor_livro_fk
   FOREIGN KEY (autor_id) 
   REFERENCES pgd.tb_autor;

ALTER TABLE IF EXISTS pgd.tb_livro 
   ADD CONSTRAINT tb_categoria_livro_fk 
   FOREIGN KEY (categoria_id) 
   REFERENCES pgd.tb_categoria;
