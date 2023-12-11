-- Table: paciente
CREATE TABLE paciente
(
    id              BIGINT NOT NULL AUTO_INCREMENT,
    user_id         BIGINT,
    data_nascimento VARCHAR(255),
    PRIMARY KEY (id),
    CONSTRAINT UK_cfx9202owbt6hvuga6yh9h8ho UNIQUE (user_id),
    CONSTRAINT FKexc4qoa9m3l7rwbet09jnoko6 FOREIGN KEY (user_id) REFERENCES user (id)
);
