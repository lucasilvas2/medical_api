-- Table: consulta
CREATE TABLE consulta
(
    ativo         BIT,
    doutor_id     BIGINT,
    id            BIGINT NOT NULL AUTO_INCREMENT,
    paciente_id   BIGINT,
    data_consulta VARCHAR(255),
    diagnostico   VARCHAR(255),
    status        ENUM ('PENDENTE', 'CONCLUIDA', 'CANCELADA'),
    PRIMARY KEY (id),
    CONSTRAINT FKs90dk2xd1ka1wlju5aw58i145 FOREIGN KEY (doutor_id) REFERENCES doutor (id),
    CONSTRAINT FK1oq22nlbbvpijm5n2t6vqi1is FOREIGN KEY (paciente_id) REFERENCES paciente (id)
);