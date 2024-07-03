CREATE TABLE pai (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(255),
    telefone VARCHAR(255),
    email VARCHAR(255),
    endereco VARCHAR(255)
);

CREATE TABLE mae (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(255),
    telefone VARCHAR(255),
    email VARCHAR(255),
    endereco VARCHAR(255)
);

CREATE TABLE country (
    id BIGSERIAL PRIMARY KEY,
    country_code VARCHAR(255),
    country_name VARCHAR(255)
);

CREATE TABLE aluno (
    id BIGSERIAL PRIMARY KEY,
    numero varchar(255),
    primeiro_nome VARCHAR(255),
    segundo_nome VARCHAR(255),
    apelido VARCHAR(255),
    genero VARCHAR(255) CHECK (genero IN ('MASCULINO', 'FEMININO')),  
    data_nascimento DATE,
    nacionalidade_id BIGINT,
    telefone VARCHAR(255),
    email VARCHAR(255),
    endereco VARCHAR(255),
    foto TEXT,
    pai_id BIGINT,
    mae_id BIGINT,
    CONSTRAINT fk_nacionalidade FOREIGN KEY (nacionalidade_id) REFERENCES country(id),
    CONSTRAINT fk_pai FOREIGN KEY (pai_id) REFERENCES pai(id),
    CONSTRAINT fk_mae FOREIGN KEY (mae_id) REFERENCES mae(id)
);

