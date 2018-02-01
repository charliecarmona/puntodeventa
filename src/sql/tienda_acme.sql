create database punto_venta;
use punto_venta;


create table clientes(
	id_cliente int(4) not null primary key AUTO_INCREMENT,
	nombre varchar(20) not null,
	ap_paterno varchar(20) not null,
	ap_materno varchar(20) not null,
	telefono int(15) not null,
	e_mail varchar(40) not null,
	RFC varchar(15) not null,
	calle varchar(20) not null,
	no int(5) not null,
	colonia varchar(20) not null,
	ciudad varchar(20) not null,
	estado varchar(20) not null
	)ENGINE=innoDB DEFAULT CHARSET=utf8;


create table ventas(
	id_vetas int(4) not null primary key AUTO_INCREMENT,
	fecha date not null,
	id_cliente int(4) not null,
	subtotal decimal(7,2) not null,
	iva decimal(6,2) not null,
	total decimal(7,2) not null,
	FOREIGN KEY (id_cliente) REFERENCES clientes (id_cliente)
	)ENGINE=innoDB DEFAULT CHARSET=utf8;

create table productos(
	id_producto int(4) not null  primary key AUTO_INCREMENT,
	producto varchar(30) not null,
	descripcion varchar(140) not null,
	precio_compra decimal(7,2) not null,
	precio_venta decimal(7,2) not null,
	existencias int(8)
	)ENGINE=innoDB DEFAULT CHARSET=utf8;

create table detalle_ventas(
	id_detalle_venta int(4) not null primary key AUTO_INCREMENT,
	id_vetas int(4) not null,
	id_producto int(4) not null,
	cantidad int(5) not null,
	tatal_producto int(7) not null,
	precio decimal(7,2) not null,
	FOREIGN KEY (id_vetas) REFERENCES ventas (id_vetas),
	FOREIGN KEY (id_producto) REFERENCES productos (id_producto)
	)ENGINE=innoDB DEFAULT CHARSET=utf8;

create table proveedores(
	id_proveedor int(4) not null primary key AUTO_INCREMENT,
	nombre varchar(30) not null,
	rfc varchar(15) not null,
	calle varchar(20) not null,
	No int(5) not null,
	colonia varchar(20) not null,
	ciudad varchar(20) not null,
	estado varchar(20) not null,
	nombre_contacto varchar(70) not null,
	telefono int(15) not null,
	e_mail varchar(40) not null
	)ENGINE=innoDB DEFAULT CHARSET=utf8;


create table compras(
	id_compra int(4) not null primary key AUTO_INCREMENT,
	fecha date not null,
	id_proveedor int(4) not null,
	subtotal decimal(7,2) not null,
	iva decimal(6,2) not null,
	total decimal(7,2) not null,
	FOREIGN KEY (id_proveedor) REFERENCES proveedores (id_proveedor)
	)ENGINE=innoDB DEFAULT CHARSET=utf8;


create table detalle_compras(
	id_detalle_compra int(4) not null primary key AUTO_INCREMENT,
	id_compra int(4) not null,
	id_producto int(4) not null,
	cantidad int(5) not null,
	total_producto int(7) not null,
	FOREIGN KEY (id_compra) REFERENCES compras (id_compra),
	FOREIGN KEY (id_producto) REFERENCES productos (id_producto)
	)ENGINE=innoDB DEFAULT CHARSET=utf8;



CREATE TABLE `usuarios` (
  `id_usuarios` mediumint(8) primary key NOT NULL,
  `nombre` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `usuario` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `contrasena` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `nivel` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `estado` varchar(20) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;


INSERT INTO usuarios(id_usuarios,nombre,usuario,contrasena,nivel,estado) VALUES (1,'carlos','carlotike',MD5('12345'),'administrador','activo');
INSERT INTO usuarios(id_usuarios,nombre,usuario,contrasena,nivel,estado) VALUES (2,'predro','panchito89',MD5('12345'),'gerente','activo');
INSERT INTO usuarios (id_usuarios,nombre,usuario,contraseña,nivel,estado) values (3,'fernando','daniels',MD5('1446'),'vendedor','inactivo');