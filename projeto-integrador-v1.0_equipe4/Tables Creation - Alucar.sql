create table endereco (
	endereco_id int,
    rua varchar(300),
    cidade varchar(30),
    cep varchar(12),
    estado char(2),
    pais varchar(20),
    PRIMARY KEY (`endereco_id`)
);

create table categoria (
	categoria_id int,
    nome varchar(50),
    url_img_modelo varchar(30),
    descricao varchar(1000),
    PRIMARY KEY (`categoria_id`)
); 

create table usuario (
	usuario_id int,
    nome varchar(100),
    email varchar(60),
    data_nascimento Date,
    cpf varchar(11),
    cnh varchar(13),
    telefone varchar(15),
    endereco_id int,
    PRIMARY KEY (`usuario_id`),
    INDEX `endereco_idx` (`endereco_id` ASC) VISIBLE,
    CONSTRAINT `endereco_id` FOREIGN KEY (`endereco_id`) REFERENCES `alucar`.`endereco`(`endereco_id`)
);

create table carro (
	carro_id int,
    nome varchar(50),
    url_img_modelo varchar(100),
    descricao varchar(1000),
    categoria_id int,
    PRIMARY KEY (`carro_id`),
    INDEX `categoria_idx` (`categoria_id` ASC) VISIBLE,
    CONSTRAINT `categoria_id` FOREIGN KEY (`categoria_id`) REFERENCES `alucar`.`categoria`(`categoria_id`)
);

create table pedido (
	pedido_id int,
    data_retirada Date,
    horario_retirada varchar(5),
    data_entrega Date,
    horario_entrega varchar(5),
    local_retirada varchar(30),
    local_entrega varchar(30),
    usuario_id int,
    carro_id int,
    PRIMARY KEY (`pedido_id`),
    INDEX `usuario_idx` (`usuario_id` ASC) VISIBLE,
    INDEX `carro_idx` (`carro_id` ASC) VISIBLE,
    CONSTRAINT `usuario_id` FOREIGN KEY (`usuario_id`) REFERENCES `alucar`.`usuario`(`usuario_id`),
    CONSTRAINT `carro_id` FOREIGN KEY (`carro_id`) REFERENCES `alucar`.`carro`(`carro_id`)
);
 