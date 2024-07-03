CREATE TABLE classe (
    id SERIAL PRIMARY KEY,
    designacao VARCHAR(255),
    sigla VARCHAR(255),
    descricao TEXT
);

CREATE TABLE disciplina (
    id SERIAL PRIMARY KEY,
    codigo VARCHAR(255),
    designacao VARCHAR(255),
    classe_id INT NOT NULL,
    CONSTRAINT fk_classe FOREIGN KEY (classe_id) REFERENCES classe(id)
);

CREATE TABLE professor (
    id BIGSERIAL PRIMARY KEY,
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
    CONSTRAINT fk_nacionalidade FOREIGN KEY (nacionalidade_id) REFERENCES country(id)
);

CREATE TABLE turma (
    id SERIAL PRIMARY KEY,
    codigo VARCHAR(255),
    designacao VARCHAR(255),
    ano_lectivo VARCHAR(255),
    turno VARCHAR(255) CHECK (turno IN ('MANHA', 'TARDE', 'POSLABORAL')), 
    sala VARCHAR(255),
    classe_id BIGINT,
    CONSTRAINT fk_classe FOREIGN KEY (classe_id) REFERENCES classe(id)
);

CREATE TABLE fornecedores (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(255),
    email VARCHAR(255),
    telefone VARCHAR(255),
    endereco VARCHAR(255)
);

CREATE TABLE transporte (
    id BIGSERIAL PRIMARY KEY,
    rota VARCHAR(255),
    capacidade INT,
    motorista VARCHAR(255)
);

CREATE TABLE aluno_transporte (
    transporte_id BIGINT,
    aluno_id BIGINT,
    CONSTRAINT fk_transporte FOREIGN KEY (transporte_id) REFERENCES transporte(id),
    CONSTRAINT fk_aluno FOREIGN KEY (aluno_id) REFERENCES aluno(id),
    PRIMARY KEY (transporte_id, aluno_id)
);

CREATE TABLE categoria_conta (
    id BIGSERIAL PRIMARY KEY,
    conta VARCHAR(255),
    descricao TEXT
);

CREATE TABLE tipo_despesa (
    id BIGSERIAL PRIMARY KEY,
    descricao TEXT,
    observacao TEXT,
    activo BOOLEAN
);

CREATE TABLE tipo_receita (
    id BIGSERIAL PRIMARY KEY,
    descricao TEXT,
    observacao TEXT,
    activo BOOLEAN
);

CREATE TABLE contas_pagar (
    id BIGSERIAL PRIMARY KEY,
    fornecedor_id BIGINT,
    categoria_conta_id BIGINT,
    tipo_despesa_id BIGINT,
    valor NUMERIC(10, 2),
    data_vencimento DATE,
    data_pagamento DATE,
    descricao TEXT,
    status VARCHAR(255),
    CONSTRAINT fk_fornecedor FOREIGN KEY (fornecedor_id) REFERENCES fornecedores(id),
    CONSTRAINT fk_categoria_conta FOREIGN KEY (categoria_conta_id) REFERENCES categoria_conta(id),
    CONSTRAINT fk_tipo_despesa FOREIGN KEY (tipo_despesa_id) REFERENCES tipo_despesa(id)
);

CREATE TABLE contas_receber (
    id BIGSERIAL PRIMARY KEY,
    aluno_id BIGINT,
    categoria_conta_id BIGINT,
    tipo_receita_id BIGINT,
    numero_recibo VARCHAR(255),
    valor NUMERIC(10, 2),
    data_vencimento DATE,
    data_pagamento DATE,
    descricao TEXT,
    status VARCHAR(255),
    CONSTRAINT fk_aluno_contas_receber FOREIGN KEY (aluno_id) REFERENCES aluno(id),
    CONSTRAINT fk_categoria_conta_receber FOREIGN KEY (categoria_conta_id) REFERENCES categoria_conta(id),
    CONSTRAINT fk_tipo_receita FOREIGN KEY (tipo_receita_id) REFERENCES tipo_receita(id)
);

CREATE TABLE pagamentos (
    id BIGSERIAL PRIMARY KEY,
    aluno_id BIGINT,
    valor NUMERIC(10, 2),
    data_pagamento DATE,
    tipo_pagamento VARCHAR(255) CHECK (tipo_pagamento IN ('PROPINAS', 'MATRICULA', 'INSCRICAO', 'TRANSPORTE', 'ALIMENTACAO', 'ESTUDO_ORIENTADO')), 
    forma_pagamento VARCHAR(255) CHECK (forma_pagamento IN ('DINHEIRO', 'CARTAO_CREDITO', 'CARTAO_DEBITO', 'CHEQUE', 'TRANSFERENCIA_BANCARIA', 'POS')),  
    CONSTRAINT fk_aluno_pagamento FOREIGN KEY (aluno_id) REFERENCES aluno(id)
);

