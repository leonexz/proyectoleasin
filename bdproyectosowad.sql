-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 20-11-2021 a las 21:05:24
-- Versión del servidor: 10.4.21-MariaDB
-- Versión de PHP: 8.0.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bdproyectosowad`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_alquiler`
--

CREATE TABLE `tb_alquiler` (
  `id_alquiler` int(11) NOT NULL,
  `id_responsable` int(11) NOT NULL,
  `tiempo_prestamo` int(11) NOT NULL,
  `precio_alquiler` double NOT NULL,
  `cantidad_equipos` int(11) NOT NULL,
  `descuento` double NOT NULL DEFAULT 0,
  `estado` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tb_alquiler`
--

INSERT INTO `tb_alquiler` (`id_alquiler`, `id_responsable`, `tiempo_prestamo`, `precio_alquiler`, `cantidad_equipos`, `descuento`, `estado`) VALUES
(1, 5, 3, 3.4, 2, 0, 'Alquilado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_detalle`
--

CREATE TABLE `tb_detalle` (
  `id_alquiler` int(11) NOT NULL,
  `id_producto` varchar(8) NOT NULL,
  `fechaEntrega` datetime NOT NULL DEFAULT current_timestamp(),
  `fechaDevolucion` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tb_detalle`
--

INSERT INTO `tb_detalle` (`id_alquiler`, `id_producto`, `fechaEntrega`, `fechaDevolucion`) VALUES
(1, 'COD08', '2021-11-20 12:25:06', NULL),
(1, 'COD09', '2021-11-20 12:25:06', NULL);

--
-- Disparadores `tb_detalle`
--
DELIMITER $$
CREATE TRIGGER `AfterDetalleInsert` AFTER INSERT ON `tb_detalle` FOR EACH ROW BEGIN UPDATE tb_producto SET disponible=0 WHERE id_pro = NEW.id_producto; END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_distrito`
--

CREATE TABLE `tb_distrito` (
  `id_distrito` int(11) NOT NULL,
  `nom_distrito` varchar(35) NOT NULL,
  `id_provincia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tb_distrito`
--

INSERT INTO `tb_distrito` (`id_distrito`, `nom_distrito`, `id_provincia`) VALUES
(1, 'Barranca', 1),
(2, 'Paramonga', 1),
(3, 'Cajatambo', 2),
(4, 'Canta', 3),
(5, 'Huamantanga', 3),
(6, 'Santa Rosa de Quives', 3),
(7, 'Asia', 4),
(8, 'Chilca', 4),
(9, 'San Vicente de Cañete', 4),
(10, 'Pacaran', 4),
(11, 'Coayllo', 4),
(12, 'Lunahuana', 4),
(13, 'Mala', 4),
(14, 'Huaral', 5),
(15, 'Chancay', 5),
(16, 'Aucallama', 5),
(17, 'Matucana', 6),
(18, 'Antioquia', 6),
(19, 'San Mateo', 6),
(20, 'Huacho', 7),
(21, 'Sayán', 7),
(22, 'Ancón', 8),
(23, 'Ate', 8),
(24, 'Barranco', 8),
(25, 'Breña', 8),
(26, 'Carabayllo', 8),
(27, 'Chaclacayo', 8),
(28, 'Chorrillos', 8),
(29, 'Cieneguilla', 8),
(30, 'Comas', 8),
(31, 'El Agustino', 8),
(32, 'Independencia', 8),
(33, 'Jesus Maria', 8),
(34, 'La Molina', 8),
(35, 'La Victoria', 8),
(36, 'Lima', 8),
(37, 'Lince', 8),
(38, 'Los Olivos', 8),
(39, 'Lurigancho-Chosica', 8),
(40, 'Lurín', 8),
(41, 'Magdalena del Mar', 8),
(42, 'Miraflores', 8),
(43, 'Pachacamac', 8),
(44, 'Pucusana', 8),
(45, 'Pueblo Libre', 8),
(46, 'Puente Piedra', 8),
(47, 'Punta Hermosa', 8),
(48, 'Punta Negra', 8),
(49, 'Rímac', 8),
(50, 'San Bartolo', 8),
(51, 'San Borja', 8),
(52, 'San Isidro', 8),
(53, 'San Juan de Lurigancho', 8),
(54, 'San Juan de Miraflores', 8),
(55, 'San Luis', 8),
(56, 'San Martin de Porres', 8),
(57, 'San Miguel', 8),
(58, 'Santa Anita', 8),
(59, 'Santa María del Mar', 8),
(60, 'Santa Rosa', 8),
(61, 'Santiago de Surco', 8),
(62, 'Surquillo', 8),
(63, 'Villa El Salvador', 8),
(64, 'Villa Maria del Triunfo', 8),
(65, 'Oyón', 9);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_empresa`
--

CREATE TABLE `tb_empresa` (
  `id_empresa` varchar(9) NOT NULL,
  `razonSocial` varchar(100) NOT NULL,
  `ruc` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tb_empresa`
--

INSERT INTO `tb_empresa` (`id_empresa`, `razonSocial`, `ruc`) VALUES
('EMP01', 'Leasein - Alquiler y Leasing de Laptops en Perú', '20535850276'),
('EMP02', 'ASTRID & GASTON S.A.C.', '20251918628'),
('EMP03', 'ASOCIACION EDUCATIVA ARES | COLEGIOS TRILCE', '20516886782'),
('EMP04', 'SAN FERNANDO S.A.', '20100154308'),
('EMP05', 'UNIVERSIDAD PRIVADA DEL NORTE SAC', '20215276024'),
('EMP06', 'MOLITALIA S.A', '20100035121'),
('EMP07', 'Sodimac-Maestro', '20112273922'),
('EMP08', 'CINEPLEX SAC', '20429683581'),
('EMP09', 'Industria Alimentaria el Parrillero S.A.C. | El Parrillero', '20545387825'),
('EMP10', 'FERRETERIA COMERCIAL SAN JUAN S.A.C', '20250678780'),
('EMP11', 'COUNTRY CLUB SISICAYA S.A.C.', '20601881731'),
('EMP12', 'Universidad del Pacifico', '20109705129'),
('EMP13', 'UNIVERSIDAD PERUANA DE CIENCIAS APLICADAS S.A.C.', '20211614545'),
('EMP14', 'INSTITUTO CULTURAL PERUANO NORTEAMERICANO', '20122667660'),
('EMP15', 'ASOCIACION CULTURAL PERUANO BRITANICA', '20112844423'),
('EMP16', 'ZBUSS S.A.C.', '20602221505');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_marca`
--

CREATE TABLE `tb_marca` (
  `id_marca` int(11) NOT NULL,
  `tipo_marca` varchar(35) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tb_marca`
--

INSERT INTO `tb_marca` (`id_marca`, `tipo_marca`) VALUES
(5, 'ACER'),
(9, 'APPLE'),
(6, 'ASUS'),
(7, 'DELL'),
(3, 'HONOR'),
(8, 'HP'),
(1, 'LENOVO'),
(2, 'LG'),
(4, 'MSI');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_memoria_ram`
--

CREATE TABLE `tb_memoria_ram` (
  `id_memoria_RAM` int(11) NOT NULL,
  `tipo_memoria_RAM` varchar(35) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tb_memoria_ram`
--

INSERT INTO `tb_memoria_ram` (`id_memoria_RAM`, `tipo_memoria_RAM`) VALUES
(4, '12GB RAM'),
(2, '16GB RAM'),
(3, '4GB RAM'),
(1, '8GB RAM');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_modelo`
--

CREATE TABLE `tb_modelo` (
  `id_modelo` int(11) NOT NULL,
  `tipo_modelo` varchar(35) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tb_modelo`
--

INSERT INTO `tb_modelo` (`id_modelo`, `tipo_modelo`) VALUES
(2, '14Z900-G.AJ53B4'),
(18, '90NR01P1'),
(14, 'A515-51G-71ZR'),
(6, 'A515-54-31'),
(12, 'Aspare 5'),
(8, 'Bravo 15 B5DD'),
(15, 'DELL VOSTRO 14'),
(9, 'GET6 RAIDER 11UG'),
(17, 'HP CF3030LA'),
(1, 'IdeaPad 5'),
(4, 'KATANA GF66'),
(11, 'Latitude 3410'),
(22, 'MACBOOK AIR'),
(19, 'MGN63LA'),
(23, 'MGNA3E/A'),
(16, 'MSI GL75 Leopard'),
(20, 'MVVL2E/A'),
(21, 'MYDA2LA'),
(3, 'NBR_WAH9'),
(13, 'V15 IIL'),
(10, 'V9T2R'),
(7, 'X513EA-BQ550T'),
(5, 'YOGA Slim 9i');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_procesador`
--

CREATE TABLE `tb_procesador` (
  `id_procesador` int(11) NOT NULL,
  `tipo_procesador` varchar(35) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tb_procesador`
--

INSERT INTO `tb_procesador` (`id_procesador`, `tipo_procesador`) VALUES
(2, '1135G7 Intel'),
(9, 'AMD'),
(1, 'AMD Ryzen 5'),
(6, 'AMD Ryzen 5600H'),
(8, 'Intel 1.2Ghz'),
(10, 'Intel 2.6GHZ'),
(5, 'Intel Ci310110U'),
(7, 'Intel Core i3'),
(3, 'Intel Core i5'),
(4, 'Intel Core i7'),
(11, 'M1'),
(12, 'M1 Octa core');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_producto`
--

CREATE TABLE `tb_producto` (
  `id_pro` varchar(8) NOT NULL,
  `nom_pro` varchar(30) NOT NULL,
  `foto` varchar(400) NOT NULL,
  `sku` varchar(10) NOT NULL,
  `valor_referencial` decimal(10,2) NOT NULL,
  `color` varchar(20) NOT NULL,
  `id_modelo` int(11) NOT NULL,
  `id_marca` int(11) NOT NULL,
  `id_procesador` int(11) NOT NULL,
  `id_sistema_operativo` int(11) NOT NULL,
  `id_memoria_RAM` int(11) NOT NULL,
  `disponible` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tb_producto`
--

INSERT INTO `tb_producto` (`id_pro`, `nom_pro`, `foto`, `sku`, `valor_referencial`, `color`, `id_modelo`, `id_marca`, `id_procesador`, `id_sistema_operativo`, `id_memoria_RAM`, `disponible`) VALUES
('COD01', 'Lenovo IdeaPad', 'http://s3.amazonaws.com/imagenes-sellers-mercado-ripley/2021/05/04212628/814k8djJqeL._AC_SL1500_1.jpg', '120925', '1.10', 'Negro', 1, 1, 1, 1, 1, 0),
('COD02', 'Ultrabook LG', 'https://oechsle.vteximg.com.br/arquivos/ids/3637338-1000-1000/1849948_01.jpg?v=637559018873570000', '123791', '1.30', 'Plomo', 2, 2, 2, 2, 2, 0),
('COD03', 'MagicMook', 'https://mercury.vteximg.com.br/arquivos/ids/3382770-800-800/image-c4ce279dee3d465d9b2643ed06f4576e.jpg?v=637632570375630000', '124525', '1.50', 'Negro', 3, 3, 3, 3, 3, 0),
('COD04', 'MSI Katana GF66-11UE', 'https://hiraoka.com.pe/media/catalog/product/cache/a357cb11a228eb6f7f15c0ee1ff203af/j/8/j8-1.jpg', '125136', '1.70', 'Negro', 4, 4, 4, 1, 2, 0),
('COD05', 'Lenovo Yoga', 'http://www.perusmart.com/wp-content/uploads/Lenovo-Yoga-Slim-7i-Pro-1536x979.jpg', '124560', '1.90', 'Negro', 5, 1, 5, 1, 2, 0),
('COD06', 'DELL Latitude 3410', 'https://http2.mlstatic.com/D_NQ_NP_2X_988411-MPE44658398977_012021-F.webp', '224122', '3.00', 'Plomo Oscuro', 11, 7, 3, 2, 2, 0),
('COD07', 'Notebook Acer', 'https://http2.mlstatic.com/D_NQ_NP_2X_650343-MPE29024988357_122018-F.webp', '224530', '2.40', 'Negro', 14, 5, 4, 2, 4, 1),
('COD08', 'Gamin Asus', 'https://http2.mlstatic.com/D_NQ_NP_2X_912312-MPE42630813704_072020-F.webp', '224918', '1.60', 'Negro', 18, 6, 3, 2, 2, 0),
('COD09', 'HP Laptop 14', 'https://http2.mlstatic.com/D_NQ_NP_2X_963090-MPE46046694228_052021-F.webp', '224802', '1.80', 'Blanco', 17, 8, 7, 2, 1, 0),
('COD10', 'Macbook Air 13', 'https://hiraoka.com.pe/media/catalog/product/cache/a357cb11a228eb6f7f15c0ee1ff203af/a/i/air_m1_gold_front_1_1.jpg', '323543', '3.10', 'Oro', 23, 9, 11, 3, 4, 1),
('COD11', 'Macbook Pro 13', 'https://hiraoka.com.pe/media/catalog/product/cache/a357cb11a228eb6f7f15c0ee1ff203af/1/_/1_75.jpg', '324065', '3.45', 'Plata', 21, 9, 11, 3, 1, 1),
('COD12', 'Macbook Pro 16', 'https://hiraoka.com.pe/media/catalog/product/cache/a357cb11a228eb6f7f15c0ee1ff203af/1/_/1_271.jpg', '324818', '3.50', 'Plata', 20, 9, 12, 3, 2, 1),
('COD13', 'DELL Inspiron 3501', 'https://www.vimigt.com/web/image/product.template/142/image_1024?unique=e0a4e10', '124122', '2.90', 'Plateado', 10, 7, 3, 1, 1, 1),
('COD14', 'Lenovo V15', 'https://http2.mlstatic.com/D_NQ_NP_2X_958194-MPE46887189528_072021-F.webp', '224525', '2.60', 'Plomo Claro', 13, 1, 8, 2, 4, 1),
('COD15', 'Macbook Air 13', 'https://hiraoka.com.pe/media/catalog/product/cache/a357cb11a228eb6f7f15c0ee1ff203af/1/_/1_132.jpg', '323542', '3.40', 'Gris Espacial', 22, 9, 11, 3, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_provincia`
--

CREATE TABLE `tb_provincia` (
  `id_provincia` int(11) NOT NULL,
  `nom_provincia` varchar(100) NOT NULL,
  `id_region` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tb_provincia`
--

INSERT INTO `tb_provincia` (`id_provincia`, `nom_provincia`, `id_region`) VALUES
(1, 'Barranca', 1),
(2, 'Cajatambo', 1),
(3, 'Canta', 1),
(4, 'Cañete', 1),
(5, 'Huaral', 1),
(6, 'Huarochiri', 1),
(7, 'Huaura', 1),
(8, 'Lima', 1),
(9, 'Oyón', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_region`
--

CREATE TABLE `tb_region` (
  `id_region` int(11) NOT NULL,
  `nom_region` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tb_region`
--

INSERT INTO `tb_region` (`id_region`, `nom_region`) VALUES
(1, 'Lima');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_responsable`
--

CREATE TABLE `tb_responsable` (
  `id_responsable` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `apellido` varchar(100) NOT NULL,
  `dni` varchar(8) NOT NULL,
  `id_empresa` varchar(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tb_responsable`
--

INSERT INTO `tb_responsable` (`id_responsable`, `nombre`, `apellido`, `dni`, `id_empresa`) VALUES
(1, 'Victor Gonzalo', 'Rodriguez Ahuanari', '85241596', 'EMP01'),
(2, 'Jaime Alejandro', 'Ordonez Cossio', '74125896', 'EMP01'),
(3, 'Marco Antonio', 'Ruiz Navarro', '12341528', 'EMP01'),
(4, 'Katherine Yesenia', 'Santamaria Mendoza', '98523641', 'EMP01'),
(5, 'Carlos', 'Huanca Chavez', '08965007', 'EMP03'),
(6, 'Nilver', 'Huara Gomez', '41078523', 'EMP08'),
(7, 'Karolina', 'Vilca Polo', '36201400', 'EMP10'),
(8, 'Mora', 'Huertas Huertas', '74103969', 'EMP05'),
(9, 'Juan Carlos', 'Cardozo Mendez', '00147452', 'EMP02'),
(10, 'Eduardo', 'Saavedra Lopez', '70800963', 'EMP09'),
(11, 'Carlos Jose', 'Kipa Ore', '69312048', 'EMP04'),
(12, 'Vanessa', 'Gomez Urrutia', '00741032', 'EMP11');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_rol`
--

CREATE TABLE `tb_rol` (
  `id_rol` int(11) NOT NULL,
  `nom_rol` varchar(35) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tb_rol`
--

INSERT INTO `tb_rol` (`id_rol`, `nom_rol`) VALUES
(1, 'Administrador'),
(2, 'Usuario');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_sede`
--

CREATE TABLE `tb_sede` (
  `id_sede` int(11) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `id_distrito` int(11) NOT NULL,
  `id_empresa` varchar(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tb_sede`
--

INSERT INTO `tb_sede` (`id_sede`, `direccion`, `id_distrito`, `id_empresa`) VALUES
(1, 'Ca. Narciso de la Colina 481, Miraflores 15046', 42, 'EMP01'),
(2, 'Av. Paz Soldan 290, San Isidro 15073', 52, 'EMP02'),
(3, 'Jr, Asunción 825, Comas 15311', 30, 'EMP03'),
(4, 'Calle Almte. Guisse 964, Jesús María 15072', 33, 'EMP03'),
(5, 'Av. Tomas Valle 845, San Martín de Porres 15103', 56, 'EMP03'),
(6, 'Jr. Iquitos 347, Cercado de Lima 15106', 36, 'EMP04'),
(7, 'Av. Alfredo Mendiola 6062, Los Olivos', 38, 'EMP05'),
(8, 'Av. El Sol 461 San Juan de Lurigancho', 53, 'EMP05'),
(9, 'Av. Tingo María 1122', 25, 'EMP05'),
(10, 'Av. Guardia Peruana 890, Chorrillos', 28, 'EMP05'),
(11, 'Av. Andrés Belaunde cdra. 10 s/n, Comas', 30, 'EMP05'),
(12, 'Av. República de Venezuela 2850, Cercado de Lima 15081', 36, 'EMP06'),
(13, 'Centro Comercial Plaza Norte, Av. Tomas Valle, Independencia 15311', 32, 'EMP07'),
(14, 'Av. Angamos 1353, Surquillo 15048', 62, 'EMP07'),
(15, 'Centro Comercial Mega Plaza, Av Industrial 3515', 32, 'EMP07'),
(16, 'Av. Óscar R. Benavides 769, Cercado de Lima 15082', 36, 'EMP07'),
(17, 'Real Plaza, Av. Inca Garcilaso de la Vega 1007, Cercado de Lima 15001', 36, 'EMP08'),
(18, 'Av. Túpac Amaru 3840, Lima 15312', 30, 'EMP08'),
(19, 'Km. 20.5, Av. Alfredo Mendiola 7042, San Martín de Porres 15304', 56, 'EMP08'),
(20, 'Av. Carlos Izaguirre, Los Olivos 15301', 38, 'EMP08'),
(21, 'C. Francisco Masias 505', 52, 'EMP09'),
(22, 'Av. Defensores de Lima 607, San Juan de Miraflores 15804', 54, 'EMP10'),
(23, '112, 15586', 18, 'EMP11'),
(24, 'Jr. Gral, Jirón Luis Sánchez Cerro 2141 Lima, Jesús María 15072', 33, 'EMP12'),
(25, 'Prolongación Primavera 2390, Monterrico, Santiago de Surco', 61, 'EMP13'),
(26, 'Av. Gral. Salaverry 2255, San Isidro 15076', 52, 'EMP13'),
(27, 'Av. la Marina 2810, San Miguel 15087', 57, 'EMP13'),
(28, 'Av Alameda San Marcos 11, Chorrillos 15067', 28, 'EMP13'),
(29, 'Cl. Domingo Tristán y Moscoso esq. Cl. Manco Inca II, Urb. Los Próceres', 61, 'EMP14'),
(30, 'Av. La Marina 2469', 57, 'EMP14'),
(31, 'Av. Angamos Oeste 120 Miraflores', 42, 'EMP14'),
(32, 'Av. El Pacífico 477, Independencia', 32, 'EMP14'),
(33, 'Jr. Cuzco 446', 36, 'EMP14'),
(34, 'Av. Javier Prado Este 4625', 34, 'EMP14'),
(35, 'AV. JAVIER PRADO ESTE 4661', 61, 'EMP15'),
(36, 'AV. LA MARINA 2554 ', 57, 'EMP15'),
(37, 'AV. PRÓCERES DE LA INDEPENDENCIA 1531', 53, 'EMP15'),
(38, 'AV. CAMINOS DEL INCA 3581', 61, 'EMP15'),
(39, 'AV. AREQUIPA 3495', 52, 'EMP15'),
(40, 'AV. JAVIER PRADO ESTE 2726', 51, 'EMP15'),
(41, 'AV. BOLÍVAR 598', 45, 'EMP15'),
(42, 'JR. CAMANÁ 787', 36, 'EMP15'),
(43, 'MALECÓN BALTA 740', 42, 'EMP15'),
(44, 'Ca. Loreto 440, Rímac 15093', 49, 'EMP16');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_sistema_operativo`
--

CREATE TABLE `tb_sistema_operativo` (
  `id_sistema_operativo` int(11) NOT NULL,
  `tipo_sistema_operativo` varchar(35) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tb_sistema_operativo`
--

INSERT INTO `tb_sistema_operativo` (`id_sistema_operativo`, `tipo_sistema_operativo`) VALUES
(2, 'LINUX'),
(3, 'MAC OS'),
(1, 'WINDOWS 10');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_usuario`
--

CREATE TABLE `tb_usuario` (
  `id_usuario` int(11) NOT NULL,
  `nom_usu` varchar(10) NOT NULL,
  `contrasenha` varchar(8) NOT NULL,
  `id_rol` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tb_usuario`
--

INSERT INTO `tb_usuario` (`id_usuario`, `nom_usu`, `contrasenha`, `id_rol`) VALUES
(1, 'VicRod', '12345678', 1),
(2, 'JaimeOr', '12345678', 1),
(3, 'MarcR', '12345678', 1),
(4, 'KthSt', '12345678', 1),
(5, 'CarHnc', '12345678', 2),
(6, 'NlHrc', '12345678', 2),
(7, 'KaroVp', '12345678', 2),
(8, 'MoraHh', '12345678', 2),
(9, 'JcCM', '12345678', 2),
(10, 'EduSl', '12345678', 2),
(11, 'CarJosK', '12345678', 2),
(12, 'VaneGom', '12345678', 2);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tb_alquiler`
--
ALTER TABLE `tb_alquiler`
  ADD PRIMARY KEY (`id_alquiler`),
  ADD KEY `id_empresa` (`id_responsable`);

--
-- Indices de la tabla `tb_detalle`
--
ALTER TABLE `tb_detalle`
  ADD PRIMARY KEY (`id_alquiler`,`id_producto`),
  ADD KEY `id_producto` (`id_producto`);

--
-- Indices de la tabla `tb_distrito`
--
ALTER TABLE `tb_distrito`
  ADD PRIMARY KEY (`id_distrito`),
  ADD KEY `id_provincia` (`id_provincia`);

--
-- Indices de la tabla `tb_empresa`
--
ALTER TABLE `tb_empresa`
  ADD PRIMARY KEY (`id_empresa`);

--
-- Indices de la tabla `tb_marca`
--
ALTER TABLE `tb_marca`
  ADD PRIMARY KEY (`id_marca`),
  ADD UNIQUE KEY `tipo_marca` (`tipo_marca`);

--
-- Indices de la tabla `tb_memoria_ram`
--
ALTER TABLE `tb_memoria_ram`
  ADD PRIMARY KEY (`id_memoria_RAM`),
  ADD UNIQUE KEY `tipo_memoria_RAM` (`tipo_memoria_RAM`);

--
-- Indices de la tabla `tb_modelo`
--
ALTER TABLE `tb_modelo`
  ADD PRIMARY KEY (`id_modelo`),
  ADD UNIQUE KEY `tipo_modelo` (`tipo_modelo`);

--
-- Indices de la tabla `tb_procesador`
--
ALTER TABLE `tb_procesador`
  ADD PRIMARY KEY (`id_procesador`),
  ADD UNIQUE KEY `tipo_procesador` (`tipo_procesador`);

--
-- Indices de la tabla `tb_producto`
--
ALTER TABLE `tb_producto`
  ADD PRIMARY KEY (`id_pro`),
  ADD UNIQUE KEY `sku` (`sku`),
  ADD KEY `id_modelo` (`id_modelo`),
  ADD KEY `id_marca` (`id_marca`),
  ADD KEY `id_procesador` (`id_procesador`),
  ADD KEY `id_sistema_operativo` (`id_sistema_operativo`),
  ADD KEY `id_memoria_RAM` (`id_memoria_RAM`);

--
-- Indices de la tabla `tb_provincia`
--
ALTER TABLE `tb_provincia`
  ADD PRIMARY KEY (`id_provincia`),
  ADD KEY `id_region` (`id_region`);

--
-- Indices de la tabla `tb_region`
--
ALTER TABLE `tb_region`
  ADD PRIMARY KEY (`id_region`);

--
-- Indices de la tabla `tb_responsable`
--
ALTER TABLE `tb_responsable`
  ADD PRIMARY KEY (`id_responsable`),
  ADD KEY `id_empresa` (`id_empresa`);

--
-- Indices de la tabla `tb_rol`
--
ALTER TABLE `tb_rol`
  ADD PRIMARY KEY (`id_rol`);

--
-- Indices de la tabla `tb_sede`
--
ALTER TABLE `tb_sede`
  ADD PRIMARY KEY (`id_sede`),
  ADD KEY `id_distrito` (`id_distrito`),
  ADD KEY `id_empresa` (`id_empresa`);

--
-- Indices de la tabla `tb_sistema_operativo`
--
ALTER TABLE `tb_sistema_operativo`
  ADD PRIMARY KEY (`id_sistema_operativo`),
  ADD UNIQUE KEY `tipo_sistema_operativo` (`tipo_sistema_operativo`);

--
-- Indices de la tabla `tb_usuario`
--
ALTER TABLE `tb_usuario`
  ADD PRIMARY KEY (`id_usuario`),
  ADD UNIQUE KEY `nom_usu` (`nom_usu`),
  ADD KEY `id_rol` (`id_rol`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tb_alquiler`
--
ALTER TABLE `tb_alquiler`
  MODIFY `id_alquiler` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `tb_distrito`
--
ALTER TABLE `tb_distrito`
  MODIFY `id_distrito` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=66;

--
-- AUTO_INCREMENT de la tabla `tb_marca`
--
ALTER TABLE `tb_marca`
  MODIFY `id_marca` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `tb_memoria_ram`
--
ALTER TABLE `tb_memoria_ram`
  MODIFY `id_memoria_RAM` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `tb_modelo`
--
ALTER TABLE `tb_modelo`
  MODIFY `id_modelo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT de la tabla `tb_procesador`
--
ALTER TABLE `tb_procesador`
  MODIFY `id_procesador` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `tb_provincia`
--
ALTER TABLE `tb_provincia`
  MODIFY `id_provincia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `tb_region`
--
ALTER TABLE `tb_region`
  MODIFY `id_region` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `tb_responsable`
--
ALTER TABLE `tb_responsable`
  MODIFY `id_responsable` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `tb_rol`
--
ALTER TABLE `tb_rol`
  MODIFY `id_rol` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `tb_sede`
--
ALTER TABLE `tb_sede`
  MODIFY `id_sede` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;

--
-- AUTO_INCREMENT de la tabla `tb_sistema_operativo`
--
ALTER TABLE `tb_sistema_operativo`
  MODIFY `id_sistema_operativo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `tb_usuario`
--
ALTER TABLE `tb_usuario`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `tb_alquiler`
--
ALTER TABLE `tb_alquiler`
  ADD CONSTRAINT `tb_alquiler_FK` FOREIGN KEY (`id_responsable`) REFERENCES `tb_responsable` (`id_responsable`);

--
-- Filtros para la tabla `tb_detalle`
--
ALTER TABLE `tb_detalle`
  ADD CONSTRAINT `tb_detalle_FK` FOREIGN KEY (`id_producto`) REFERENCES `tb_producto` (`id_pro`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tb_detalle_FK_1` FOREIGN KEY (`id_alquiler`) REFERENCES `tb_alquiler` (`id_alquiler`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `tb_distrito`
--
ALTER TABLE `tb_distrito`
  ADD CONSTRAINT `tb_distrito_ibfk_1` FOREIGN KEY (`id_provincia`) REFERENCES `tb_provincia` (`id_provincia`);

--
-- Filtros para la tabla `tb_producto`
--
ALTER TABLE `tb_producto`
  ADD CONSTRAINT `tb_producto_ibfk_1` FOREIGN KEY (`id_modelo`) REFERENCES `tb_modelo` (`id_modelo`),
  ADD CONSTRAINT `tb_producto_ibfk_2` FOREIGN KEY (`id_marca`) REFERENCES `tb_marca` (`id_marca`),
  ADD CONSTRAINT `tb_producto_ibfk_3` FOREIGN KEY (`id_procesador`) REFERENCES `tb_procesador` (`id_procesador`),
  ADD CONSTRAINT `tb_producto_ibfk_4` FOREIGN KEY (`id_sistema_operativo`) REFERENCES `tb_sistema_operativo` (`id_sistema_operativo`),
  ADD CONSTRAINT `tb_producto_ibfk_5` FOREIGN KEY (`id_memoria_RAM`) REFERENCES `tb_memoria_ram` (`id_memoria_RAM`);

--
-- Filtros para la tabla `tb_provincia`
--
ALTER TABLE `tb_provincia`
  ADD CONSTRAINT `tb_provincia_ibfk_1` FOREIGN KEY (`id_region`) REFERENCES `tb_region` (`id_region`);

--
-- Filtros para la tabla `tb_responsable`
--
ALTER TABLE `tb_responsable`
  ADD CONSTRAINT `tb_responsable_ibfk_1` FOREIGN KEY (`id_empresa`) REFERENCES `tb_empresa` (`id_empresa`);

--
-- Filtros para la tabla `tb_sede`
--
ALTER TABLE `tb_sede`
  ADD CONSTRAINT `tb_sede_ibfk_1` FOREIGN KEY (`id_distrito`) REFERENCES `tb_distrito` (`id_distrito`),
  ADD CONSTRAINT `tb_sede_ibfk_2` FOREIGN KEY (`id_empresa`) REFERENCES `tb_empresa` (`id_empresa`);

--
-- Filtros para la tabla `tb_usuario`
--
ALTER TABLE `tb_usuario`
  ADD CONSTRAINT `tb_usuario_FK` FOREIGN KEY (`id_usuario`) REFERENCES `tb_responsable` (`id_responsable`),
  ADD CONSTRAINT `tb_usuario_ibfk_1` FOREIGN KEY (`id_rol`) REFERENCES `tb_rol` (`id_rol`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
