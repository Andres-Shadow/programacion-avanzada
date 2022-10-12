
/** --------------------------------------CLIENTES-----------------------------------------------------**/
insert into cliente values (1,"BQF862","dominiquejavier5853@uniquindio.com","foto","Regina Esteban",100,"3481 126 7185");
insert into cliente values (2,"CNX987","gabrielflorencia@uniquindio.org","foto","MacKensie Santos",23,"3786 899 7525");
insert into cliente values (3,"FYS689","ezekielpea@yahoo.org","foto","Reed Francisco",77,"3493 867 2253");
insert into cliente values (4,"WHK372","luneajose@google.com","foto","Alyssa Chichi",65,"3147 234 1109");
insert into cliente values (5,"DEK244","lucysofia7864@google.com","foto","Rogan Diez",13,"3493 608 5407");
insert into cliente values (6,"BYQ684","portermatilde8875@yahoo.org","foto","Nelle Jara",38,"3778 541 8240");
insert into cliente values (7,"ATG266","brendavalentina@uniquindio.com","foto","Cailin Pastor",70,"3517 728 4015");
insert into cliente values (8,"FAN619","omarrodriguez1187@outlook.com","foto","Jakeem Benjamin",50,"3636 638 3555");
insert into cliente values (9,"WFA868","illanabentlee@hotmail.org","foto","Audrey Zuniga",22,"3482 878 8555");
insert into cliente values (10,"XOA627","gagearaya5239@google.com","foto","Calvin Saez",24,"3322 373 3399");
insert into cliente values (11,"RUU877","fitzgeraldfrancisco1116@yahoo.org","foto","Wanda Julieta",21,"3876 877 1267");
insert into cliente values (12,"EYP885","chandadominguez@outlook.com","foto","Thaddeus Figueroa",75,"3461 433 7636");
insert into cliente values (13,"FST855","graidengutierrez@yahoo.org","foto","Audrey Reyes",38,"3515 913 7664");
insert into cliente values (14,"RHS477","theodoremedina@yahoo.com","foto","Ray Ramirez",17,"3313 334 3877");
insert into cliente values (15,"SGR942","iolarubio@hotmail.educo","foto","Christine Muñoz",94,"3875 544 2467");


/** --------------------------------------PELICULAS-----------------------------------------------------**/

insert into pelicula values (1,"PREVENTA","DRAMA","foto","name","reparto","sinopsis","trailer");
insert into pelicula values (2,"PREVENTA","TERROR","foto","name","reparto","sinopsis","trailer");
insert into pelicula values (3,"PREVENTA","TERROR","foto","name","reparto","sinopsis","trailer");
insert into pelicula values (4,"EMISION","ACCION","foto","name","reparto","sinopsis","trailer");
insert into pelicula values (5,"PREVENTA","TERROR","foto","name","reparto","sinopsis","trailer");
insert into pelicula values (6,"EMISION","ANIMACION","foto","name","reparto","sinopsis","trailer");
insert into pelicula values (7,"PREVENTA","DRAMA","foto","name","reparto","sinopsis","trailer");
insert into pelicula values (8,"PREVENTA","TERROR","foto","name","reparto","sinopsis","trailer");
insert into pelicula values (9,"EMISION","ACCION","foto","name","reparto","sinopsis","trailer");
insert into pelicula values (10,"EMISION","ROMANCE","foto","name","reparto","sinopsis","trailer");

/** --------------------------------------SALAS-----------------------------------------------------**/

insert into sala values (1,80,66);
insert into sala values (2,80,60);
insert into sala values (3,80,51);
insert into sala values (4,100,53);
insert into sala values (5,100,53);
insert into sala values (6,100,55);
insert into sala values (7,80,55);
insert into sala values (8,80,56);
insert into sala values (9,80,69);
insert into sala values (10,100,57);
insert into sala values (11,100,74);
insert into sala values (12,100,73);
insert into sala values (13,80,68);
insert into sala values (14,80,66);
insert into sala values (15,80,58);

/** --------------------------------------FUNCIONES-----------------------------------------------------**/

insert into funcion values (1,4,11);
insert into funcion values (2,2,10);
insert into funcion values (3,8,4);
insert into funcion values (4,6,12);
insert into funcion values (5,3,1,);
insert into funcion values (6,9,7);
insert into funcion values (7,2,2);
insert into funcion values (8,4,5);
insert into funcion values (9,3,9);
insert into funcion values (10,2,3);

/** --------------------------------------CIUDADES-----------------------------------------------------**/

insert into ciudad values(1, "Armenia");
insert into ciudad values(2, "Pereira");
insert into ciudad values(3, "Manizales");

/** --------------------------------------ADMINS-----------------------------------------------------**/

insert into administrativo values (1, "12345","pepe torres", "admin teatro","1" );




insert into teatro values (1, "direccion 1", "teatro 1", 1, 1);

insert into compra (id, valor, cliente_id) values (1, 12500, 1);

insert into cupon (id, descripcion, fecha_vencimiento, valor_descuento) values (1, "descripcion 1","2020/02/05", 150000);

insert into cupon_cliente values (1, 1, 1, 1,1);

