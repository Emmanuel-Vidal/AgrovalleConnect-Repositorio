

##  Modelo Entidad-Relación

```mermaid
erDiagram
    USUARIO ||--o{ FINCA : posee
    FINCA ||--o{ PRODUCTO : cultiva
    USUARIO ||--o{ ORDEN_COMPRA : realiza
    PRODUCTO ||--o{ ORDEN_COMPRA : incluye
    ORDEN_COMPRA ||--o| FLETE : requiere
    USUARIO ||--o{ FLETE : transporta
    ORDEN_COMPRA ||--o{ CALIFICACION : genera

    USUARIO {
        bigint id PK
        string cedula UK
        string nombre
        string correo UK
        string password
        string ubicacion_valle
        enum rol
        enum estado
    }

    FINCA {
        bigint id PK
        string nombre_finca
        string municipio
        string vereda
        decimal hectareas
        bigint agricultor_id FK
    }

    PRODUCTO {
        bigint id PK
        string tipo_cultivo
        decimal cantidad_kg
        decimal precio_kg
        date fecha_cosecha
        enum estado
        bigint finca_id FK
    }

    ORDEN_COMPRA {
        bigint id PK
        bigint producto_id FK
        bigint comprador_id FK
        decimal cantidad_kg
        decimal monto_total
        enum estado
        timestamp created_at
    }

    FLETE {
        bigint id PK
        bigint orden_id FK
        string origen
        string destino
        decimal peso_toneladas
        decimal costo
        enum estado
        bigint transportista_id FK
    }

    CALIFICACION {
        bigint id PK
        bigint orden_id FK
        bigint comprador_id FK
        bigint agricultor_id FK
        int estrellas
        text comentario
        timestamp created_at
    }