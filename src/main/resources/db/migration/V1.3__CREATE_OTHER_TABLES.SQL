CREATE TABLE matricula (
    id BIGSERIAL NOT NULL PRIMARY KEY,
    ano_lectivo INTEGER NOT NULL,
    aluno_id BIGINT,
    classe_id BIGINT,
    data_matricula DATE,
    status_matricula VARCHAR(255) CHECK (status_matricula IN ('ACTIVA', 'TRANCADA', 'CANCELADA', 'CONCLUIDA')),  
    CONSTRAINT fk_aluno FOREIGN KEY (aluno_id) REFERENCES aluno(id),
    CONSTRAINT fk_classe FOREIGN KEY (classe_id) REFERENCES classe(id)
);

CREATE TABLE inscricao (
    id BIGSERIAL PRIMARY KEY,
    data_inscricao DATE,
    ano_lectivo INT,
    aluno_id BIGINT,
    turma_id BIGINT,
    status_inscricao VARCHAR(255) CHECK (status_inscricao IN ('INSCRITA', 'PENDENTE', 'CANCELADA')), 
    CONSTRAINT fk_aluno_inscricao FOREIGN KEY (aluno_id) REFERENCES aluno(id),
    CONSTRAINT fk_turma_inscricao FOREIGN KEY (turma_id) REFERENCES turma(id)
);

CREATE TABLE frequencia (
    id BIGSERIAL PRIMARY KEY,
    ano_lectivo INTEGER,
    numero_faltas INTEGER,
    aluno_id BIGINT,
    turma_id BIGINT,
    professor_id BIGINT,
    disciplina_id BIGINT,
    nota NUMERIC(10, 2),
    CONSTRAINT fk_aluno_frequencia FOREIGN KEY (aluno_id) REFERENCES aluno(id),
    CONSTRAINT fk_turma_frequencia FOREIGN KEY (turma_id) REFERENCES turma(id),
    CONSTRAINT fk_professor_frequencia FOREIGN KEY (professor_id) REFERENCES professor(id),
    CONSTRAINT fk_disciplina_frequencia FOREIGN KEY (disciplina_id) REFERENCES disciplina(id)
);

CREATE TABLE avaliacao (
    id BIGSERIAL PRIMARY KEY,
    disciplina_id BIGINT,
    aluno_id BIGINT,
    professor_id BIGINT,
    turma_id BIGINT,
    classe_id BIGINT,
    ano_lectivo INT,
    nota NUMERIC(10, 2),
    tipo_avaliacao VARCHAR(255) CHECK (tipo_avaliacao IN ('ACP', 'ACS', 'TRABALHO')), 
    observacao TEXT,
    CONSTRAINT fk_disciplina_avaliacao FOREIGN KEY (disciplina_id) REFERENCES disciplina(id),
    CONSTRAINT fk_aluno_avaliacao FOREIGN KEY (aluno_id) REFERENCES aluno(id),
    CONSTRAINT fk_professor_avaliacao FOREIGN KEY (professor_id) REFERENCES professor(id),
    CONSTRAINT fk_turma_avaliacao FOREIGN KEY (turma_id) REFERENCES turma(id),
    CONSTRAINT fk_classe_avaliacao FOREIGN KEY (classe_id) REFERENCES classe(id)
);

CREATE TABLE tipo_documento (
    id BIGSERIAL PRIMARY KEY,
    descricao VARCHAR(255)
);

CREATE TABLE documento (
    id BIGSERIAL PRIMARY KEY,
    aluno_id BIGINT,
    tipo_documento_id BIGINT,
    data_emissao DATE,
    arquivo_digital TEXT,
    CONSTRAINT fk_aluno_documento FOREIGN KEY (aluno_id) REFERENCES aluno(id),
    CONSTRAINT fk_tipo_documento FOREIGN KEY (tipo_documento_id) REFERENCES tipo_documento(id)
);

CREATE TABLE turma_aluno (
    turma_id BIGINT,
    aluno_id BIGINT,
    CONSTRAINT fk_turma_aluno FOREIGN KEY (turma_id) REFERENCES turma(id),
    CONSTRAINT fk_aluno_turma FOREIGN KEY (aluno_id) REFERENCES aluno(id)
);

CREATE TABLE turma_professor (
    turma_id BIGINT,
    professor_id BIGINT,
    CONSTRAINT fk_turma_professor FOREIGN KEY (turma_id) REFERENCES turma(id),
    CONSTRAINT fk_professor_turma FOREIGN KEY (professor_id) REFERENCES professor(id)
);

