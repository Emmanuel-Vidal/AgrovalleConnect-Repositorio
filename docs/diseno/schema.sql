-- Creación de la Base de Datos
CREATE DATABASE IF NOT EXISTS agrovalle_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE agrovalle_db;

-- 1. Tabla de Usuarios
CREATE TABLE IF NOT EXISTS usuarios (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    cedula VARCHAR(20) NOT NULL UNIQUE,
    nombre VARCHAR(100) NOT NULL,
    correo VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    ubicacion_valle VARCHAR(100) NOT NULL,
    rol ENUM('AGRICULTOR', 'COMPRADOR', 'TRANSPORTISTA', 'ADMIN') NOT NULL,
    estado ENUM('PENDIENTE_VERIFICACION', 'VERIFICADO', 'BLOQUEADO') DEFAULT 'PENDIENTE_VERIFICACION',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 2. Tabla de Fincas (Asociada a Agricultores)
CREATE TABLE IF NOT EXISTS fincas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre_finca VARCHAR(100) NOT NULL,
    municipio VARCHAR(50) NOT NULL,
    vereda VARCHAR(100),
    hectareas DECIMAL(6,2) NOT NULL,
    agricultor_id BIGINT NOT NULL,
    FOREIGN KEY (agricultor_id) REFERENCES usuarios(id) ON DELETE CASCADE
);

-- 3. Tabla de Productos / Cosechas
CREATE TABLE IF NOT EXISTS productos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    tipo_cultivo VARCHAR(50) NOT NULL,
    cantidad_kg DECIMAL(10,2) NOT NULL,
    precio_kg DECIMAL(10,2) NOT NULL,
    fecha_cosecha DATE NOT NULL,
    estado ENUM('DISPONIBLE', 'RESERVADO', 'VENDIDO', 'CANCELADO') DEFAULT 'DISPONIBLE',
    finca_id BIGINT NOT NULL,
    FOREIGN KEY (finca_id) REFERENCES fincas(id) ON DELETE CASCADE
);

-- 4. Tabla de Órdenes de Compra
CREATE TABLE IF NOT EXISTS ordenes_compra (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    producto_id BIGINT NOT NULL,
    comprador_id BIGINT NOT NULL,
    cantidad_kg DECIMAL(10,2) NOT NULL,
    monto_total DECIMAL(12,2) NOT NULL,
    estado ENUM('PENDIENTE', 'EN_NEGOCIACION', 'PAGADO', 'ENTREGADO', 'CANCELADO') DEFAULT 'PENDIENTE',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (producto_id) REFERENCES productos(id),
    FOREIGN KEY (comprador_id) REFERENCES usuarios(id)
);

-- 5. Tabla de Fletes y Logística
CREATE TABLE IF NOT EXISTS fletes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    orden_id BIGINT NOT NULL,
    origen VARCHAR(100) NOT NULL,
    destino VARCHAR(100) NOT NULL,
    peso_toneladas DECIMAL(6,2) NOT NULL,
    costo DECIMAL(10,2) NOT NULL,
    estado ENUM('SOLICITADO', 'ASIGNADO', 'EN_TRANSITO', 'ENTregado') DEFAULT 'SOLICITADO',
    transportista_id BIGINT NULL,
    FOREIGN KEY (orden_id) REFERENCES ordenes_compra(id),
    FOREIGN KEY (transportista_id) REFERENCES usuarios(id)
);

-- 6. Tabla de Calificaciones y Reputación
CREATE TABLE IF NOT EXISTS calificaciones (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    orden_id BIGINT NOT NULL,
    comprador_id BIGINT NOT NULL,
    agricultor_id BIGINT NOT NULL,
    estrellas INT CHECK (estrellas BETWEEN 1 AND 5),
    comentario TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (orden_id) REFERENCES ordenes_compra(id),
    FOREIGN KEY (comprador_id) REFERENCES usuarios(id),
    FOREIGN KEY (agricultor_id) REFERENCES usuarios(id)
);