create table clientes (
    id bigint not null auto_increment,
    nome varchar(150) not null,
    idade int not null,
    endereco varchar(150),
    email varchar(150) not null unique,

    primary key(id)
);

create table robos (
    id bigint not null auto_increment,
    nome varchar(150) not null,
    ip varchar(150) not null,
    endereco varchar(150) not null,

    primary key(id)
);

create table agendas (
    id bigint not null auto_increment,
    cliente bigint not null,
    robo bigint not null,
    data date not null,
    hora time not null,
    ativo tinyint not null,

    primary key(id),
    foreign key(cliente) references clientes(id),
    foreign key(robo) references robos(id)
);