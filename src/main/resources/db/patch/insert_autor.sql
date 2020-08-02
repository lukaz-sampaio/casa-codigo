INSERT INTO pgd.tb_autor (id, nome, email, descricao, data_cadastro)
VALUES (
    1,
    upper('autor 1'),
    upper('autor1@email.com'),
    upper('Descrição do autor 1'),
    now()
);
