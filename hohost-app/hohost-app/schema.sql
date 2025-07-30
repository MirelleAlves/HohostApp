CREATE TABLE acomodacao (
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
    disponivel BOOLEAN,
    FOREIGN KEY (anfitriao_id) REFERENCES anfitriao(id)
);

CREATE TABLE anfitriao (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    telefone VARCHAR(20),
    email VARCHAR(100),
    estado VARCHAR(50),
    cidade_atuacao VARCHAR(100)
);

CREATE TABLE cliente (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    telefone VARCHAR(20),
    email VARCHAR(100),
    cpf VARCHAR(11)
);

CREATE TABLE reserva (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  cliente_id BIGINT,
  acomodacao_id BIGINT,
  data_entrada VARCHAR(20),
  data_saida VARCHAR(20),
  forma_pagamento VARCHAR(50),
  status VARCHAR(20),
  FOREIGN KEY (cliente_id) REFERENCES cliente(id),
  FOREIGN KEY (acomodacao_id) REFERENCES acomodacao(id)
);