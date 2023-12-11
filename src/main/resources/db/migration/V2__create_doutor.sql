-- Table: doutor
CREATE TABLE doutor
(
    id            BIGINT NOT NULL AUTO_INCREMENT,
    user_id       BIGINT,
    especialidade VARCHAR(255),
    PRIMARY KEY (id),
    CONSTRAINT UK_iary6o11rn8qlh09vckmawnwr UNIQUE (user_id),
    CONSTRAINT FKk70ivmigxkggcv8g11rhw1qf9 FOREIGN KEY (user_id) REFERENCES user (id)
);
