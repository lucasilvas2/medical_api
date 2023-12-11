-- Table: user
CREATE TABLE user
(
    ativo    BOOLEAN DEFAULT true,
    id       BIGINT NOT NULL AUTO_INCREMENT,
    email    VARCHAR(255),
    nome     VARCHAR(255),
    telefone VARCHAR(255),
    genero   ENUM ('MASCULINO', 'FEMININO', 'OUTROS'),
    PRIMARY KEY (id)
);

