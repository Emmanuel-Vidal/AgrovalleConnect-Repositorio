
# Planificación del Sprint 1 — AgroValle Connect

Este documento detalla la planificación, el objetivo y la descomposición técnica de las tareas correspondientes al **Sprint 1** del proyecto AgroValle Connect para la Institución Universitaria Antonio José Camacho (UniAJC).

---

## 🎯 1. Objetivo del Sprint

Establecer la infraestructura base del backend en Spring Boot, configurar la persistencia relacional con MySQL y desarrollar el núcleo de autenticación, registro de agricultores y publicación inicial de cosechas para garantizar la operatividad de los módulos principales.

* **Duración del Sprint:** 2 semanas.
* **Capacidad Planeada:** **9 Story Points** (dentro del rango requerido de 8 a 10 puntos).

---

## 📋 2. Historias de Usuario Comprometidas en el Sprint 1

|       ID       | Historia de Usuario                 | Módulo                | Prioridad |  Story Points  |
| :-------------: | :---------------------------------- | :--------------------- | :-------: | :-------------: |
| **HU-01** | Registro de Agricultores            | Usuarios / Auth        |   MUST   |   **3**   |
| **HU-02** | Publicación de Productos           | Productos              |   MUST   |   **3**   |
| **HU-04** | Búsqueda y Filtrado por Municipio  | Productos              |   MUST   |   **3**   |
| **TOTAL** | **3 Historias Seleccionadas** | **Core Backend** |    —    | **9 pts** |

---

## 🛠️ 3. Descomposición Técnica de Tareas (Task Breakdown)

### 🔹 Tareas para HU-01: Registro de Agricultores (3 pts)

1. **Modelado de Entidad:** Crear la clase `Usuario.java` con anotaciones JPA (`@Entity`, `@Table`) y atributos (`id`, `cedula`, `nombre`, `ubicacionValle`, `rol`).
2. **Capa de Persistencia:** Crear la interfaz `UsuarioRepository.java` extendiendo de `JpaRepository`.
3. **Capa de Lógica (Service):** Implementar `UsuarioService.java` para validar la unicidad de la cédula y encriptar credenciales.
4. **Capa de Exposición (Controller):** Desarrollar `UsuarioController.java` con el endpoint POST `/api/v1/auth/register` retornando código 201.

### 🔹 Tareas para HU-02: Publicación de Productos (3 pts)

1. **Modelado de Entidad:** Crear la clase `Producto.java` vinculada por llave foránea al agricultor (`id_agricultor`).
2. **Capa de Persistencia:** Crear `ProductoRepository.java`.
3. **Capa de Lógica (Service):** Implementar `ProductoService.java` agregando la validación de que la `fecha_cosecha` no sea anterior a la fecha actual.
4. **Capa de Exposición (Controller):** Desarrollar `ProductoController.java` con el endpoint POST para la creación de la oferta.

### 🔹 Tareas para HU-04: Búsqueda y Filtrado por Municipio (3 pts)

1. **Consulta Personalizada:** Añadir método `findByMunicipio(String municipio)` en `ProductoRepository`.
2. **Lógica de Filtrado:** Implementar en el servicio la consulta desacoplada para listar cosechas filtradas.
3. **Endpoint de Consulta:** Exponer en `ProductoController` la ruta GET con parámetros de filtrado geográfico.

---

## ✅ 4. Criterios de Aceptación Técnicos del Sprint (Definition of Done)

* El código compila sin errores (`BUILD SUCCESS` en Maven / Spring Boot).
* Las entidades se mapean correctamente y generan las tablas en MySQL.
* Las pruebas de los endpoints responden con los códigos HTTP esperados (200, 201, 400).
