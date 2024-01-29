CREATE DATABASE AJMInv;

USE AJMInv;

CREATE TABLE USUARIOS (
idUsuario INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
nombres VARCHAR(80) NOT NULL,
edad INT NOT NULL,
rol CHAR(10) NOT NULL,
imagen BLOB NOT NULL,
fechadeNac date
);

CREATE TABLE PROVEEDORES (
idProveedor INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
nombre VARCHAR(100) NOT NULL,
email TEXT NOT NULL,
numero INT(9) NOT NULL,
ruc INT(15) NOT NULL
);

CREATE TABLE PRODUCTOS (
idProducto INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
nombre VARCHAR(50) NOT NULL,
cantidad INT NOT NULL,
proveedorId INT NOT NULL,
precio INT NOT NULL,
imagen BLOB NOT NULL,
fechadeIngre DATETIME,
FOREIGN KEY (proveedorID) REFERENCES PROVEEDORES(idProveedor)
);

CREATE TABLE user(
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
username VARCHAR(255) NOT NULL,
lastname VARCHAR(255) NOT NULL,
firstname VARCHAR(255) NOT NULL,
country VARCHAR(255) NOT NULL,
password VARCHAR(255) NOT NULL,
role VARCHAR(255) NOT NULL
);

DROP TABLE PROVEEDORES;

INSERT INTO PROVEEDORES (nombre, email, numero, ruc) VALUES
('Proveedor1', 'proveedor1@example.com', 123456789, 1234),
('Proveedor2', 'proveedor2@example.com', 987654321, 9876),
('Proveedor3', 'proveedor3@example.com', 456789123, 45645),
('Proveedor4', 'proveedor4@example.com', 789123456, 789678),
('Proveedor5', 'proveedor5@example.com', 654321987, 6543765);

INSERT INTO USUARIOS (nombres, edad, rol, imagen, fechadeNac) VALUES
('Juan Pérez', 25, 'Usuario', 'contenido_binario_de_la_imagen', '1999-05-15'),
('María Rodríguez', 30, 'Admin', 'contenido_binario_de_la_imagen', '1992-11-22'),
('Pedro Gómez', 22, 'Moderador', 'contenido_binario_de_la_imagen', '2000-08-10'),
('Ana García', 28, 'Usuario', 'contenido_binario_de_la_imagen', '1994-03-30');

INSERT INTO PRODUCTOS (nombre, cantidad, proveedorId, precio, imagen, fechadeIngre)
VALUES
    ('Producto1', 10, 1, 20, 'imagen1.jpg', '2024-01-28 12:00:00'),
    ('Producto2', 5, 2, 15, 'imagen2.jpg', '2024-01-28 13:30:00'),
    ('Producto3', 8, 3, 25, 'imagen3.jpg', '2024-01-28 15:45:00');
