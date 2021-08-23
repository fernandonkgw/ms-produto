create table tb_product
(
    price       numeric(19, 2),
    name        varchar(255),
    enabled     boolean,
    id          bigint generated by default as identity
        constraint tb_product_pkey
            primary key,
    description varchar(255)
);