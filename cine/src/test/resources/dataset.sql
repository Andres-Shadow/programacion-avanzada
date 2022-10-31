
/** --------------------------------------CLIENTES-----------------------------------------------------**/
insert into cliente values (1,"BQF862","dominiquejavier5853@uniquindio.com","foto","Regina Esteban",100);
insert into cliente values (2,"CNX987","gabrielflorencia@uniquindio.org","foto","MacKensie Santos",23);
insert into cliente values (3,"FYS689","ezekielpea@yahoo.org","foto","Reed Francisco",77);
insert into cliente values (4,"WHK372","luneajose@google.com","foto","Alyssa Chichi",65);
insert into cliente values (5,"DEK244","lucysofia7864@google.com","foto","Rogan Diez",13);
insert into cliente values (6,"BYQ684","portermatilde8875@yahoo.org","foto","Nelle Jara",38);
insert into cliente values (7,"ATG266","brendavalentina@uniquindio.com","foto","Cailin Pastor",70);
insert into cliente values (8,"FAN619","omarrodriguez1187@outlook.com","foto","Jakeem Benjamin",50);
insert into cliente values (9,"WFA868","illanabentlee@hotmail.org","foto","Audrey Zuniga",22);
insert into cliente values (10,"XOA627","gagearaya5239@google.com","foto","Calvin Saez",24);
insert into cliente values (11,"RUU877","fitzgeraldfrancisco1116@yahoo.org","foto","Wanda Julieta",21);
insert into cliente values (12,"EYP885","chandadominguez@outlook.com","foto","Thaddeus Figueroa",75);
insert into cliente values (13,"FST855","graidengutierrez@yahoo.org","foto","Audrey Reyes",40);
insert into cliente values (14,"RHS477","theodoremedina@yahoo.com","foto","Ray Ramirez",17);
insert into cliente values (15,"SGR942","iolarubio@hotmail.educo","foto","Christine Muñoz",94);


/** --------------------------------------PELICULAS-----------------------------------------------------**/

insert into pelicula values (1,"PREVENTA","DRAMA","foto","desaparecida","reparto","sinopsis","trailer");
insert into pelicula values (2,"PREVENTA","TERROR","foto","la noche del demonio","reparto","sinopsis","trailer2");
insert into pelicula values (3,"PREVENTA","TERROR","foto","anabel","reparto","sinopsis","trailer3");
insert into pelicula values (4,"EMISION","ACCION","foto","los avengers","reparto","sinopsis","traile4");
insert into pelicula values (5,"PREVENTA","TERROR","foto","black phone","reparto","sinopsis","traile5");
insert into pelicula values (6,"EMISION","ANIMACION","foto","paranorman","reparto","sinopsis","traile6");
insert into pelicula values (7,"PREVENTA","DRAMA","foto","despues de ella","reparto","sinopsis","traile7");
insert into pelicula values (8,"PREVENTA","TERROR","foto","el conjuro","reparto","sinopsis","trailer8");
insert into pelicula values (9,"EMISION","ACCION","foto","escuadron suicida","reparto","sinopsis","trailer9");
insert into pelicula values (10,"EMISION","ROMANCE","foto","50 sombras mas oscuras","reparto","sinopsis","trailer10");

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
--insert into funcion values (5,3,1,); SI SE DESCOMENTA DEJA DE FUNCIONAR
insert into funcion values (6,9,7);
insert into funcion values (7,2,2);
insert into funcion values (8,4,5);
insert into funcion values (9,3,9);
insert into funcion values (10,2,3);

/** --------------------------------------CIUDADES-----------------------------------------------------**/

insert into ciudad values(1, "Armenia");
insert into ciudad values(2, "Pereira");
insert into ciudad values(3, "Manizales");
insert into ciudad values(4, "Cali");
insert into ciudad values(5, "Medellin");

/** --------------------------------------ADMINS-----------------------------------------------------**/
                /*    id - cedula -    nombre   -     tipo    - id supervisor* - correo - contraseña */
insert into administrativo values (1, "12345","password", "correo1@gmail.com","pepito", "ADMINISTRADOR_TEATRO", null );


/** --------------------------------------TEATROS-----------------------------------------------------**/
insert into teatro values (1, "direccion 1", "teatro 1", null, null);
insert into teatro values (2, "direccion 2", "teatro 2",null, null);
insert into teatro values (3, "direccion 3", "teatro 3", null, null);
insert into teatro values (4, "direccion 4", "teatro 4", null, null);
insert into teatro values (5, "direccion 5", "teatro 5", null, null);

/** --------------------------------------COMPRAS-----------------------------------------------------**/
insert into compra (id, valor, cliente_id) values (1, 12500, 1);
insert into compra (id, valor, cliente_id) values (2, 17000, 2);
insert into compra (id, valor, cliente_id) values (3, 15000, 2);
insert into compra (id, valor, cliente_id) values (4, 22500, 3);
insert into compra (id, valor, cliente_id) values (5, 36500, 4);

/** --------------------------------------CUPONES-----------------------------------------------------**/

/**  id - descripcion - estado - fecha_vencimiento - tipo - valor_descuento - compra_id **/

insert  into cupon values (1, "descripcion 1",true, "2022/12/1", "CUPON_TIPO_1", 0.10, null);

/** id - cantidad - cliente_id - cupon_id **/

insert into cupon_cliente values (1, 3, null, 1);

/** --------------------------------------CONFITERIA-----------------------------------------------------**/
insert into confiteria values (1, "img1.png", "crispetas", 32000 ,5);
insert into confiteria values (2, "img2.png", "hot-dog", 25000 ,6 );
insert into confiteria values (3, "img3.png", "gaseosa", 12000 ,7 );
insert into confiteria values (4, "img4.png", "chocolatina", 8000 ,8 );
insert into confiteria values (5, "img5.png", "refresco", 9000 ,9 );

/** --------------------------------------ENTRADA-----------------------------------------------------**/
/*  id - columna - fila - valor - cliente_id - funcion_id - teatro_sala_id - factura_id  */

insert into entrada values (1, 1, 3, 3000,null,null,null,null);


/** --------------------------------------FACTURA-----------------------------------------------------**/

/** id - fecha - valor completo **/

insert  into factura values (1, "2022/12/1", 30000 );

/** --------------------------------------HORARIO-----------------------------------------------------**/

/** id - dia - fin - hora-minutos - inicio **/

-- insert into horario values (1, "1", "2022/12/1", "2:30 - 5:30", "6");