-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 31-05-2017 a las 16:03:03
-- Versión del servidor: 5.7.18-log
-- Versión de PHP: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `muebles_y_tendencias_sulive`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `carpinteria`
--

CREATE TABLE `carpinteria` (
  `id_carpinteria` int(30) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `telefono` int(30) NOT NULL,
  `nit` int(60) NOT NULL,
  `direccion` varchar(120) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `carpinteria`
--

INSERT INTO `carpinteria` (`id_carpinteria`, `nombre`, `telefono`, `nit`, `direccion`) VALUES
(2, 'Carpinteria Jose', 4281833, 968572213, 'Av. Salinas entre Calle Segunda N° 9687'),
(3, 'Los Tres Clavos', 4796855, 968785412, 'Av.  Blanco Galindo entre Calle Junin N° 3697'),
(4, 'Clavito', 4896755, 988774555, 'Av.  Lopez entre Calle Antezana N° 3680'),
(5, 'Maderero', 4789544, 978544552, 'Av. Simon Lopez entre Calle Antezana N° 7412'),
(8, 'El Maquetero 2', 4968574, 968741236, 'Av. Oquendo entre Av. Jordan N° 3698'),
(9, 'Bresca', 4369877, 936541254, 'Av. 16 De Julio entre Calle Rimon Rivero N° 36987');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `id_cliente` int(30) NOT NULL,
  `nombre_cliente` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `apellido_paterno` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `apellido_materno` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `ci` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `telefono` int(11) DEFAULT NULL,
  `direccion` varchar(120) COLLATE utf8_spanish_ci NOT NULL,
  `email` varchar(30) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`id_cliente`, `nombre_cliente`, `apellido_paterno`, `apellido_materno`, `ci`, `fecha_nacimiento`, `telefono`, `direccion`, `email`) VALUES
(1, 'Pedrito', 'Miranda', 'Sandoval', '3654214', '1990-05-15', 4857899, 'Av. Junin entre Calle Calama N° 3698', 'pedritomiranda@gmail.com'),
(2, 'Pablito', 'Sanabria', 'Arequipa', '3645129', '1977-02-02', 4857899, 'Av. Segunda entre Calle Aroma y Av. Muyurina N° 3698', 'pablitosanabria@gmail.com'),
(3, 'Ernesto', 'Palomares', 'Rios', '3698741', NULL, NULL, 'Av. Enrique Unzueta entre Calle tercera N° 3612', NULL),
(4, 'Hans', 'Maiyer', 'Castro', '3654152', '2005-05-01', 4693855, 'Av. Segunda entre Calle Cuarta N° 3697', 'hanssolo@gmail.com'),
(5, 'Pamela', 'Oblitos', 'Gutierrez', '21479685', '2004-05-04', 496257, 'Av.  Quinta entre Calle Cuarta N° 1234', 'pamelaoblitos@gmail.com'),
(6, 'Paola Andrea', 'Fuentes', 'Orellana', '1478963', NULL, NULL, 'Av. Colombia entre Calle Junin N° 47896', NULL),
(8, 'March', 'Bubie', 'Simpson', '369787', '2003-05-04', 4968574, 'Av. Calama entre Calle Antofagasta N° 3698', 'march@hotmail.com'),
(9, 'Marioly', 'Hock', 'Shu', '3698741', NULL, NULL, 'Av. Pulacayo entre Av. Republica N° 69874', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mueble`
--

CREATE TABLE `mueble` (
  `id_mueble` int(30) NOT NULL,
  `nombre` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `id_carpinteria` int(30) NOT NULL,
  `id_tipo_material` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido`
--

CREATE TABLE `pedido` (
  `id_pedido` int(30) NOT NULL,
  `cantidad` int(30) NOT NULL,
  `fecha_pedido` date NOT NULL,
  `fecha_entrega` date NOT NULL,
  `descripcion_pedido` text COLLATE utf8_spanish_ci NOT NULL,
  `id_personal` int(30) NOT NULL,
  `id_cliente` int(30) NOT NULL,
  `id_mueble` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido_fabricacion`
--

CREATE TABLE `pedido_fabricacion` (
  `id_pedido_fabricacion` int(30) NOT NULL,
  `precio` int(11) NOT NULL,
  `fecha_entrega` date NOT NULL,
  `fecha_tentativa` date NOT NULL,
  `entregado` tinyint(1) NOT NULL,
  `descripcion` text NOT NULL,
  `id_carpinteria` int(30) NOT NULL,
  `id_personal` int(30) NOT NULL,
  `id_mueble` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `personal`
--

CREATE TABLE `personal` (
  `id_personal` int(30) NOT NULL,
  `nombre` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `apellido_paterno` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `apellido_materno` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `ci` int(11) NOT NULL,
  `direccion` varchar(120) COLLATE utf8_spanish_ci NOT NULL,
  `telefono` int(11) NOT NULL,
  `email` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `sueldo` float NOT NULL,
  `fecha_inicio_actividades` date NOT NULL,
  `id_tipo_personal` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `personal`
--

INSERT INTO `personal` (`id_personal`, `nombre`, `apellido_paterno`, `apellido_materno`, `fecha_nacimiento`, `ci`, `direccion`, `telefono`, `email`, `sueldo`, `fecha_inicio_actividades`, `id_tipo_personal`) VALUES
(1, 'Alejandro', 'Machaca', 'Luna', '1995-12-12', 8829291, 'Av. Flora Salinas entre Av. Calancha N° 1452', 4281834, 'alejandromachaca@outlook.es', 2000, '2005-02-01', 1),
(2, 'Pedro', 'Molinedo', 'Ramirez', '2013-05-30', 48965412, 'Av. Libertador entre Calle Valderrama Salinas N° 789456', 4281833, 'pedromolinedo@gmail.com', 1800, '2012-05-05', 4),
(3, 'Willian', 'Ferreira', 'Benz', '2014-05-16', 9685131, 'Av. Simon Lopez entre Calle Salinas N° 9789', 4789635, 'willianferreira@hotmail.com', 3000, '2015-08-11', 3),
(4, 'Corolina', 'Padilla', 'Melgar', '1995-11-11', 3659841, 'Av. Circunvalacion entre Calle Tomas Frias N° 96358', 4587963, 'carolinapadilla@hotmail.com', 2000, '2017-05-11', 2),
(5, 'Ramiro', 'Castillo', 'Sandoval', '2017-05-06', 1235895, 'Av. Peru entre Calle Lanza N° 9687', 4789635, 'ramirocastillo@gmail.com', 1800, '2017-02-09', 4),
(6, 'Gabriela', 'Navarro', 'Luna', '1987-05-15', 9685741, 'Av. Punata entre Calle Lanza N° 8679240', 4968577, 'gabrielaluna@gmail.com', 2000, '2017-05-05', 2),
(7, 'Flora', 'Luna', 'Panuni', '1992-05-02', 6968574, 'Av. Riverana entre Calle Junin N° 4578', 4281833, 'floraluna@gmail.com', 40000, '2017-02-02', 3),
(8, 'Abel', 'Guevara', 'Olivera', '2005-05-01', 9635478, 'Av.Simon Lopez entre Calle Miranda N° 9689', 4487953, 'abelguevara@gmail.com', 1800, '2015-05-03', 3),
(9, 'Loan', 'Melgar', 'Hock', '1983-03-18', 968741, 'Av. Republica entre Calle Honduras N° 4563', 4782566, 'loan@gmail.com', 2000, '2017-05-06', 2),
(10, 'Alex', 'Romero', 'Valdivia', '1983-05-25', 2547896, 'Av. Pulacayo entre Calle Sandoval N° 3698', 4798523, 'alexromero@hotmail.com', 1800, '2016-05-06', 4),
(11, 'Bladimir', 'Simon', 'Choque', '2012-05-10', 3246654, 'Av. Libertador entre Calle Junin N° 9687', 4968387, 'bladimirsimon@gmail.com', 1800, '2017-05-10', 4),
(12, 'Jhon', 'Castillo', 'Colla', '2014-05-04', 9687412, 'Av.Simon Lopez entre Av. Beijin N° 7896', 4859632, 'jhoncastillo@gmail.com', 2000, '2014-05-10', 4),
(16, 'Mauricio', 'Prieto', 'Gonzalez', '1987-05-05', 21134569, 'Av. Calancha entre Calle Riverena N° 4321', 4202829, 'mauricioprieto', 2000, '2015-05-02', 4),
(17, 'Pablito', 'Sandoval', 'Martinez', '1989-05-07', 3321210, 'Av.Blanco Galindo entre Calle Ramon Rivero N° 3257', 4930288, 'pablitosandoval@gmail.com', 1800, '2017-05-06', 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_material`
--

CREATE TABLE `tipo_material` (
  `id_tipo_material` int(30) NOT NULL,
  `tipo_material` varchar(30) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_personal`
--

CREATE TABLE `tipo_personal` (
  `id_tipo_personal` int(30) NOT NULL,
  `tipo_personal` varchar(30) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `tipo_personal`
--

INSERT INTO `tipo_personal` (`id_tipo_personal`, `tipo_personal`) VALUES
(1, 'Administrador/a'),
(2, 'Secretaria/o'),
(3, 'Diseñador/a'),
(4, 'Acomodador');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `carpinteria`
--
ALTER TABLE `carpinteria`
  ADD PRIMARY KEY (`id_carpinteria`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id_cliente`);

--
-- Indices de la tabla `mueble`
--
ALTER TABLE `mueble`
  ADD PRIMARY KEY (`id_mueble`);

--
-- Indices de la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`id_pedido`);

--
-- Indices de la tabla `pedido_fabricacion`
--
ALTER TABLE `pedido_fabricacion`
  ADD PRIMARY KEY (`id_pedido_fabricacion`);

--
-- Indices de la tabla `personal`
--
ALTER TABLE `personal`
  ADD PRIMARY KEY (`id_personal`);

--
-- Indices de la tabla `tipo_material`
--
ALTER TABLE `tipo_material`
  ADD PRIMARY KEY (`id_tipo_material`);

--
-- Indices de la tabla `tipo_personal`
--
ALTER TABLE `tipo_personal`
  ADD PRIMARY KEY (`id_tipo_personal`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `carpinteria`
--
ALTER TABLE `carpinteria`
  MODIFY `id_carpinteria` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id_cliente` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT de la tabla `mueble`
--
ALTER TABLE `mueble`
  MODIFY `id_mueble` int(30) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `pedido`
--
ALTER TABLE `pedido`
  MODIFY `id_pedido` int(30) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `pedido_fabricacion`
--
ALTER TABLE `pedido_fabricacion`
  MODIFY `id_pedido_fabricacion` int(30) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `personal`
--
ALTER TABLE `personal`
  MODIFY `id_personal` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
--
-- AUTO_INCREMENT de la tabla `tipo_material`
--
ALTER TABLE `tipo_material`
  MODIFY `id_tipo_material` int(30) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `tipo_personal`
--
ALTER TABLE `tipo_personal`
  MODIFY `id_tipo_personal` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
