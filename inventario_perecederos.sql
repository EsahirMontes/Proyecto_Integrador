CREATE TABLE categoria (
  id_categoria INT PRIMARY KEY AUTO_INCREMENT,
  nombre_categoria VARCHAR(100),
  descripcion_categoria TEXT
);

CREATE TABLE productos (
  id_producto INT PRIMARY KEY AUTO_INCREMENT,
  codigo VARCHAR(100),
  nombre_producto VARCHAR(150),
  descripcion TEXT,
  precio DOUBLE,
  stockActual INT,
  stockMinimo INT,
  fechaVencimiento DATE,
  idCategoria INT,
  FOREIGN KEY (idCategoria) REFERENCES categoria(id_categoria)
);

CREATE TABLE usuarios (
  id_usuario INT PRIMARY KEY AUTO_INCREMENT,
  usuario VARCHAR(100),
  contrasena VARCHAR(100),
  nombre VARCHAR(150),
  rol VARCHAR(50)
);

CREATE TABLE proveedores (
  id_proveedor INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(150),
  direccion VARCHAR(200),
  telefono VARCHAR(15),
  ruc VARCHAR(11)
);

CREATE TABLE cliente (
  id_cliente INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(150),
  direccion VARCHAR(200),
  telefono VARCHAR(15),
  ruc VARCHAR(11)
);

CREATE TABLE movimientos (
  id INT PRIMARY KEY AUTO_INCREMENT,
  producto_id INT,
  tipo VARCHAR(50),
  cantidad INT,
  fecha DATE,
  usuario_id INT,
  proveedor_id INT NULL,
  cliente_id INT NULL,
  precio_unitario DECIMAL(10,2),
  observacion TEXT,
  FOREIGN KEY (producto_id) REFERENCES productos(id_producto),
  FOREIGN KEY (usuario_id) REFERENCES usuarios(id_usuario),
  FOREIGN KEY (proveedor_id) REFERENCES proveedores(id_proveedor),
  FOREIGN KEY (cliente_id) REFERENCES cliente(id_cliente)
);

CREATE TABLE bitacora (
  id INT PRIMARY KEY AUTO_INCREMENT,
  usuario_id INT,
  accion TEXT,
  fecha DATETIME,
  FOREIGN KEY (usuario_id) REFERENCES usuarios(id_usuario)
);

CREATE TABLE notificaciones (
  id INT PRIMARY KEY AUTO_INCREMENT,
  usuario_id INT,
  mensaje TEXT,
  leido BOOLEAN,
  fecha DATETIME,
  FOREIGN KEY (usuario_id) REFERENCES usuarios(id_usuario)
);

CREATE TABLE alertas_stock (
  id INT PRIMARY KEY AUTO_INCREMENT,
  producto_id INT,
  tipo_alerta VARCHAR(100),
  mensaje TEXT,
  fecha DATETIME,
  FOREIGN KEY (producto_id) REFERENCES productos(id_producto)
);