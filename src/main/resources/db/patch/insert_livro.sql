INSERT INTO pgd.tb_livro (id, titulo, sumario, resumo, isbn, numero_paginas, 
preco, data_publicacao, autor_id, categoria_id) 
VALUES (
    1,
    upper('livro 1'),
    upper('sumario livro 1'), 
    upper('resumo livro 1'),
    upper('isbn-0001'),
    200,
    29.90,
    now(),
    (SELECT id FROM pgd.tb_autor WHERE nome = upper('autor 1')), 
    (SELECT id FROM pgd.tb_categoria WHERE nome = upper('categoria 1'))
);
