insert into pais (nome) values ('Brasil');

insert into estado (nome, pais_id) values ('São Paulo', 1);

INSERT INTO `casadocodigo`.`autor` (`data_resgistro`, `descricao`, `email`, `nome`) VALUES ( now(), 'Autor de vários livros da casa do código', 'erick@gmail.com', 'Erick');

INSERT INTO `casadocodigo`.`categoria` (`nome`) VALUES ('Programação');

INSERT INTO `casadocodigo`.`livro` (`data_publicacao`, `isbn`, `numero_pagina`, `preco`, `resumo`, `sumario`, `titulo`, `autor_id`, `categoria_id`) VALUES ( now(), '121212', 101, 20.0, 'Livro design codigo', 'aaaaaaaaaaaaa', 'Código Limpo - Uncle Bob', 1, 1);
INSERT INTO `casadocodigo`.`livro` (`data_publicacao`, `isbn`, `numero_pagina`, `preco`, `resumo`, `sumario`, `titulo`, `autor_id`, `categoria_id`) VALUES ( now(), '121212', 200, 50.0, 'Livro Java', 'Livro Java', 'Livro de java muito bom', 1, 1);