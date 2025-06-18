CREATE TABLE acomodacoes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    descricao TEXT,
    endereco VARCHAR(255) NOT NULL,
    cidade VARCHAR(100) NOT NULL,
    estado VARCHAR(100) NOT NULL,
    tipo VARCHAR(100) NOT NULL,
    preco_por_noite DECIMAL(10,2) NOT NULL,
    quantidade_quartos INT NOT NULL,
    quantidade_banheiros INT NOT NULL,
    capacidade INT NOT NULL,
    wifi BOOLEAN,
    estacionamento BOOLEAN,
    animais_permitidos BOOLEAN,
    disponivel BOOLEAN
);

CREATE TABLE Anfitrioes (
     id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    telefone VARCHAR(20),
    email VARCHAR(100),
    estado VARCHAR(50),
    cidade_atuacao VARCHAR(100)
);