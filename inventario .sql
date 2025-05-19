-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 18-05-2025 a las 22:57:46
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `inventario`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categorias`
--

CREATE TABLE `categorias` (
  `id_categoria` int(11) NOT NULL,
  `nombre_categoria` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `categorias`
--

INSERT INTO `categorias` (`id_categoria`, `nombre_categoria`) VALUES
(1, 'Lácteos'),
(2, 'Bebida energizante'),
(3, 'Bebidas gasificadas'),
(4, 'Galletas saladas'),
(5, 'Galletas dulces'),
(6, 'Cereales'),
(7, 'Piqueos');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compra`
--

CREATE TABLE `compra` (
  `id_compra` int(11) NOT NULL,
  `id_proveedor` int(11) NOT NULL,
  `fecha_compra` date NOT NULL,
  `numero_documento` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `compra`
--

INSERT INTO `compra` (`id_compra`, `id_proveedor`, `fecha_compra`, `numero_documento`) VALUES
(1, 1, '2024-02-01', 1),
(2, 2, '2024-01-02', 2),
(3, 4, '2024-03-02', 2),
(5, 5, '2024-03-12', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entradas`
--

CREATE TABLE `entradas` (
  `id_entrada` int(11) NOT NULL,
  `id_compra` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `id_producto` int(11) NOT NULL,
  `tipo_unidad` varchar(20) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `costo_unit` decimal(8,2) NOT NULL,
  `fecha_vencimiento` date NOT NULL,
  `fecha_entrada` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `entradas`
--

INSERT INTO `entradas` (`id_entrada`, `id_compra`, `id_usuario`, `id_producto`, `tipo_unidad`, `cantidad`, `costo_unit`, `fecha_vencimiento`, `fecha_entrada`) VALUES
(1, 1, 1, 3, 'Pack', 10, 20.00, '2024-06-03', '2024-01-01'),
(2, 2, 2, 5, 'Pack', 8, 19.50, '2024-06-02', '2024-01-01'),
(3, 2, 2, 7, 'Saco', 5, 120.00, '2024-08-25', '2024-01-01'),
(4, 2, 2, 6, 'Bolsa', 8, 3.00, '2024-08-08', '2024-01-01'),
(5, 2, 2, 7, 'Saco', 6, 110.00, '2024-08-02', '2024-01-01'),
(6, 2, 2, 6, 'Bolsa', 5, 3.00, '2024-08-25', '2024-01-01'),
(7, 3, 2, 9, 'Tiras', 10, 10.00, '2024-08-03', '2024-01-01'),
(8, 2, 2, 9, 'Tiras', 2, 10.00, '2024-04-05', '2024-01-01'),
(9, 2, 2, 9, 'Tiras', 3, 10.00, '2024-08-08', '2024-01-01'),
(10, 2, 3, 9, 'Tiraz', 3, 10.00, '2024-08-09', '2024-01-01'),
(12, 3, 2, 7, 'Saco', 5, 30.00, '2024-09-05', '2024-01-05');

--
-- Disparadores `entradas`
--
DELIMITER $$
CREATE TRIGGER `after_insert_entrada` AFTER INSERT ON `entradas` FOR EACH ROW BEGIN
  INSERT INTO inventario (id_producto, producto, stock_actual)
  VALUES (
      NEW.id_producto,
      (SELECT nombre_producto FROM productos WHERE id_producto = NEW.id_producto),
      NEW.cantidad
  )
  ON DUPLICATE KEY UPDATE
      stock_actual = stock_actual + NEW.cantidad;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inventario`
--

CREATE TABLE `inventario` (
  `id_inventario` int(11) NOT NULL,
  `id_producto` int(11) NOT NULL,
  `producto` varchar(100) NOT NULL,
  `stock_actual` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `inventario`
--

INSERT INTO `inventario` (`id_inventario`, `id_producto`, `producto`, `stock_actual`) VALUES
(1, 7, 'Arroz Gourmet', 16),
(5, 6, 'Oreo', 13),
(9, 9, 'Papas Lays', 22);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `id_producto` int(11) NOT NULL,
  `nombre_producto` varchar(50) NOT NULL,
  `marca` varchar(50) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  `id_categoria` int(11) NOT NULL,
  `stock_minimo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`id_producto`, `nombre_producto`, `marca`, `descripcion`, `id_categoria`, `stock_minimo`) VALUES
(1, 'Yogurt Griego', 'Gloria', 'Bolsa de 800 g', 1, 8),
(3, 'Yogurt', 'Gloria', 'envase de 1 kg', 1, 0),
(5, 'Yogurt', 'Laive', 'Envase de 946 g', 1, 0),
(6, 'Oreo', 'Mondelez', 'bolsa x 8 unidades', 5, 4),
(7, 'Arroz', 'Gran chalan', 'Saco de arroz de 5 kg', 6, 6),
(9, 'Papas Lays', 'Pepsico', 'Tiras de 12 unidades', 7, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedor`
--

CREATE TABLE `proveedor` (
  `id_proveedor` int(11) NOT NULL,
  `nombre_comercial` varchar(30) NOT NULL,
  `ruc` varchar(11) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `telefono` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `proveedor`
--

INSERT INTO `proveedor` (`id_proveedor`, `nombre_comercial`, `ruc`, `direccion`, `telefono`) VALUES
(1, 'MarketPlace', '20389756218', 'Av. Proceres', '987235762'),
(2, 'AB PERU', '20983576758', 'Av. Amazonas', '973826372'),
(3, 'Vallesol', '20398765162', 'Av. Industrial', '932706471'),
(4, 'Frialsa', '20987656721', 'Jr. Arriola', '923675231'),
(5, 'Friac', '20389823981', 'Jr. Rosales', '987231872'),
(6, 'Agel', '20897634934', 'Av. Soles', '987345763');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `salidas`
--

CREATE TABLE `salidas` (
  `id_salida` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `id_producto` int(11) NOT NULL,
  `tipo_unidad` varchar(20) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `costo_unit` decimal(8,2) NOT NULL,
  `fecha_salida` date NOT NULL,
  `motivo_salida` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `salidas`
--

INSERT INTO `salidas` (`id_salida`, `id_usuario`, `id_producto`, `tipo_unidad`, `cantidad`, `costo_unit`, `fecha_salida`, `motivo_salida`) VALUES
(1, 2, 5, 'Pack', 1, 19.50, '2024-03-10', 'ventas'),
(2, 2, 3, 'Pack', 1, 20.00, '2024-03-02', 'ventas'),
(3, 3, 5, 'Pack', 1, 19.50, '2024-02-01', 'ventas'),
(14, 2, 6, 'Bolsa', 1, 3.00, '2024-04-02', 'ventas');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id_usuario` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `apellido` varchar(30) NOT NULL,
  `doc_identidad` varchar(9) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `telefono` varchar(15) NOT NULL,
  `correo` varchar(50) NOT NULL,
  `cargo` varchar(20) NOT NULL,
  `usuario` varchar(15) NOT NULL,
  `password` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id_usuario`, `nombre`, `apellido`, `doc_identidad`, `direccion`, `telefono`, `correo`, `cargo`, `usuario`, `password`) VALUES
(1, 'Patrick', 'Jane', '70151640', 'Av. Las Flores - SJL', '987123645', 'patrick@gmail.com', 'administrador', 'admi', 'trax'),
(2, 'Bom', 'Torrez', '70283467', 'Av. Canto Grande - SJL', '987623263', 'bob@gmail.com', 'encargado', 'enc', '123'),
(3, 'Juan', 'Torrez', '70875623', 'Av. Los Postes', '987653261', 'juan@gmail.com', 'encargado', 'juan', 'jo70'),
(4, 'Pepa', 'Orce', '70782651', 'Av. El Sol', '987526321', 'pepe@gmail.com', 'encargado', 'pepe', 'po70'),
(5, 'Gian', 'Ortiz', '70239887', 'Av. El Sol', '987123321', 'gian@gmail.com', 'encargado', 'gian', 'go70'),
(6, 'Pan', 'Orce', '70234598', 'Av. Lima', '987345762', 'pan@gmail.com', 'administrador', 'pan', 'po70');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categorias`
--
ALTER TABLE `categorias`
  ADD PRIMARY KEY (`id_categoria`);

--
-- Indices de la tabla `compra`
--
ALTER TABLE `compra`
  ADD PRIMARY KEY (`id_compra`),
  ADD KEY `id_proveedor` (`id_proveedor`);

--
-- Indices de la tabla `entradas`
--
ALTER TABLE `entradas`
  ADD PRIMARY KEY (`id_entrada`),
  ADD KEY `id_compra` (`id_compra`),
  ADD KEY `id_producto` (`id_producto`),
  ADD KEY `id_usuario` (`id_usuario`);

--
-- Indices de la tabla `inventario`
--
ALTER TABLE `inventario`
  ADD PRIMARY KEY (`id_inventario`),
  ADD UNIQUE KEY `id_producto` (`id_producto`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`id_producto`),
  ADD KEY `id_categoria` (`id_categoria`);

--
-- Indices de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  ADD PRIMARY KEY (`id_proveedor`);

--
-- Indices de la tabla `salidas`
--
ALTER TABLE `salidas`
  ADD PRIMARY KEY (`id_salida`),
  ADD KEY `id_producto` (`id_producto`),
  ADD KEY `id_usuario` (`id_usuario`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id_usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `categorias`
--
ALTER TABLE `categorias`
  MODIFY `id_categoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `compra`
--
ALTER TABLE `compra`
  MODIFY `id_compra` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `entradas`
--
ALTER TABLE `entradas`
  MODIFY `id_entrada` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `inventario`
--
ALTER TABLE `inventario`
  MODIFY `id_inventario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `id_producto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  MODIFY `id_proveedor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `salidas`
--
ALTER TABLE `salidas`
  MODIFY `id_salida` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `compra`
--
ALTER TABLE `compra`
  ADD CONSTRAINT `compra_ibfk_1` FOREIGN KEY (`id_proveedor`) REFERENCES `proveedor` (`id_proveedor`);

--
-- Filtros para la tabla `entradas`
--
ALTER TABLE `entradas`
  ADD CONSTRAINT `entradas_ibfk_1` FOREIGN KEY (`id_compra`) REFERENCES `compra` (`id_compra`),
  ADD CONSTRAINT `entradas_ibfk_2` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id_producto`),
  ADD CONSTRAINT `entradas_ibfk_3` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`);

--
-- Filtros para la tabla `inventario`
--
ALTER TABLE `inventario`
  ADD CONSTRAINT `inventario_ibfk_1` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id_producto`);

--
-- Filtros para la tabla `productos`
--
ALTER TABLE `productos`
  ADD CONSTRAINT `productos_ibfk_1` FOREIGN KEY (`id_categoria`) REFERENCES `categorias` (`id_categoria`);

--
-- Filtros para la tabla `salidas`
--
ALTER TABLE `salidas`
  ADD CONSTRAINT `salidas_ibfk_1` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id_producto`),
  ADD CONSTRAINT `salidas_ibfk_2` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
