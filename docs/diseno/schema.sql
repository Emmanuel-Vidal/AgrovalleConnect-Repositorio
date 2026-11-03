-- AgroValle Connect - Script DDL PostgreSQL (3FN)
-- Ubicación: docs/diseno/schema.sql

CREATE TABLE usuarios (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    cedula VARCHAR(20) UNIQUE NOT NULL,
    email VARCHAR(120) UNIQUE NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    rol VARCHAR(30) NOT NULL CHECK (rol IN ('AGRICULTOR', 'COMPRADOR', 'TRANSPORTISTA', 'ADMIN')),
    estado_verificacion VARCHAR(30) DEFAULT 'PENDIENTE_VERIFICACION' CHECK (estado_verificacion IN ('PENDIENTE_VERIFICACION', 'VERIFICADO', 'RECHAZADO')),
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE fincas (
    id SERIAL PRIMARY KEY,
    agricultor_id INT NOT NULL REFERENCES usuarios(id) ON DELETE CASCADE,
    nombre_finca VARCHAR(100) NOT NULL,
    municipio VARCHAR(100) NOT NULL,
    vereda VARCHAR(100),
    hectareas NUMERIC(8,2)
);

CREATE TABLE productos (
    id SERIAL PRIMARY KEY,
    finca_id INT NOT NULL REFERENCES fincas(id) ON DELETE CASCADE,
    tipo_cultivo VARCHAR(100) NOT NULL,
    cantidad_kg NUMERIC(10,2) NOT NULL CHECK (cantidad_kg > 0),
    precio_por_kg NUMERIC(12,2) NOT NULL CHECK (precio_por_kg > 0),
    fecha_cosecha DATE NOT NULL,
    estado VARCHAR(20) DEFAULT 'DISPONIBLE' CHECK (estado IN ('DISPONIBLE', 'RESERVADO', 'VENDIDO', 'CANCELADO')),
    fecha_publicacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE ordenes_compra (
    id SERIAL PRIMARY KEY,
    producto_id INT NOT NULL REFERENCES productos(id),
    comprador_id INT NOT NULL REFERENCES usuarios(id),
    cantidad_comprada_kg NUMERIC(10,2) NOT NULL CHECK (cantidad_comprada_kg > 0),
    monto_total NUMERIC(12,2) NOT NULL,
    estado_orden VARCHAR(30) DEFAULT 'PENDIENTE' CHECK (estado_orden IN ('PENDIENTE', 'EN_NEGOCIACION', 'PAGADO', 'CANCELADO')),
    fecha_orden TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE fletes_transporte (
    id SERIAL PRIMARY KEY,
    orden_id INT UNIQUE NOT NULL REFERENCES ordenes_compra(id),
    transportista_id INT REFERENCES usuarios(id),
    origen_municipio VARCHAR(100) NOT NULL,
    destino_municipio VARCHAR(100) NOT NULL,
    costo_flete NUMERIC(12,2) NOT NULL,
    estado_logistico VARCHAR(30) DEFAULT 'SOLICITADO' CHECK (estado_logistico IN ('SOLICITADO', 'ASIGNADO', 'EN_TRANSITO', 'CERCA_DESTINO', 'ENTREGADO')),
    fecha_asignacion TIMESTAMP
);

CREATE TABLE calificaciones (
    id SERIAL PRIMARY KEY,
    orden_id INT UNIQUE NOT NULL REFERENCES ordenes_compra(id),
    comprador_id INT NOT NULL REFERENCES usuarios(id),
    agricultor_id INT NOT NULL REFERENCES usuarios(id),
    puntuacion INT NOT NULL CHECK (puntuacion BETWEEN 1 AND 5),
    comentario TEXT,
    fecha_calificacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);