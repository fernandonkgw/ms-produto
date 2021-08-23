delete from tb_product;

alter sequence tb_product_id_seq restart with 1;

insert into tb_product (description, enabled, name, price) values ('smartphone', true, 'iphone', 999.99);
insert into tb_product (description, enabled, name, price) values ('notebook', true, 'asus', 1999.99);
insert into tb_product (description, enabled, name, price) values ('mouse', true, 'logitech 123', 999.99);
insert into tb_product (description, enabled, name, price) values ('teclado', false, 'keycron', 100.00);
