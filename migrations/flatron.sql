CREATE DATABASE `flatron` /* !40100 DEFAULT CHARACTER SET latin1 */;

#tabla Clientes
CREATE TABLE flatron.Cliente (
codigo int not null auto_increment primary key,
nombre nvarchar(255),
apellido nvarchar(255),
cuit nvarchar(13), #ver tipo de dato
email nvarchar(255),
celular nvarchar(255),
direccion nvarchar(255),
localidad nvarchar(255),
provincia nvarchar(255)
);

#tabla Proveedores
CREATE TABLE flatron.Proveedor (
codigo int not null auto_increment primary key,
nombre nvarchar(255),
apellido nvarchar(255),
razonSocial nvarchar(255),
email nvarchar(255),
telefono nvarchar(255),  #ver tipo de dato
cuit nvarchar(13), #ver tipo de dato
direccion nvarchar(255),
localidad nvarchar(255),
provincia nvarchar(255)
);

#tabla Unidad de medidas
CREATE TABLE flatron.UnidadMedida (
codigo  int not null auto_increment primary key,
nombre nvarchar(255)
);

#tabla Compras
CREATE TABLE flatron.Compra(
codigo int not null auto_increment primary key,
numero_comprobante nvarchar(255),
fecha datetime,
codigo_proveedor int,
total int, #ver tipo
constraint FkProveedor_Compra FOREIGN KEY(codigo_proveedor) REFERENCES flatron.Proveedor(codigo)
);

#tabla Productos
CREATE TABLE flatron.Producto (
codigo int not null auto_increment primary key,
marca nvarchar(255),
nombre nvarchar(255),
costo double,
ganancia double, #vertipo
stock double,
stock_minimo double,
rubro nvarchar(255),
codigo_unidadMedida int,
constraint FkUnidadMedida_Producto FOREIGN KEY (codigo_unidadMedida) REFERENCES flatron.UnidadMedida(codigo)
);

#tabla Detalle de compras
CREATE TABLE flatron.DetalleCompra (
codigo int not null auto_increment primary key,
cantidad double,
importe double,
codigo_compra int,
codigo_producto int,
constraint FkCompra_DetalleCompra FOREIGN KEY (codigo_compra) REFERENCES flatron.Compra(codigo),
constraint FkProducto_DetalleCompra FOREIGN KEY (codigo_producto) REFERENCES flatron.Producto(codigo)
);

#tabla ventas
CREATE TABLE flatron.Venta (
codigo int not null auto_increment primary key,
numero_comprobante nvarchar(255),
fecha datetime,
total double,
descuento double,
codigo_cliente int,
constraint FkCliente_Venta FOREIGN KEY (codigo_cliente) REFERENCES flatron.Cliente(codigo)
);

#tabla Detalle de ventas
CREATE TABLE flatron.DetalleVenta (
codigo int not null auto_increment primary key,
cantidad double,
importe double,
codigo_venta int,
codigo_producto int,
constraint FkVenta_DetalleVenta FOREIGN KEY (codigo_venta) REFERENCES flatron.Venta(codigo),
constraint FkProducto_DetalleVenta FOREIGN KEY (codigo_producto) REFERENCES flatron.Producto(codigo)
);