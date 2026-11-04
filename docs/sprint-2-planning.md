
# Planificación del Sprint 2 — AgroValle Connect

Este documento detalla la planificación, el objetivo y la descomposición técnica de las tareas correspondientes al **Sprint 2** del proyecto AgroValle Connect para la Institución Universitaria Antonio José Camacho (UniAJC).

---

## 🎯 1. Objetivo del Sprint

Implementar los módulos de logística de transporte, coordinación de fletes entre agricultores y transportistas, y el sistema de reputación mediante calificaciones para cerrar el ciclo transaccional básico de la plataforma.

* **Duración del Sprint:** 2 semanas.
* **Capacidad Planeada:** **9 Story Points** (dentro del rango requerido de 8 a 10 puntos).

---

## 📋 2. Historias de Usuario Comprometidas en el Sprint 2

|       ID       | Historia de Usuario                     | Módulo                            | Prioridad |  Story Points  |
| :-------------: | :-------------------------------------- | :--------------------------------- | :-------: | :-------------: |
| **HU-06** | Solicitud de Transporte Logístico      | Logística / Fletes                |  SHOULD  |   **3**   |
| **HU-07** | Aceptación de Fletes por Transportista | Logística / Fletes                |  SHOULD  |   **3**   |
| **HU-08** | Calificación de Vendedores             | Reputación                        |  SHOULD  |   **3**   |
| **TOTAL** | **3 Historias Seleccionadas**     | **Logística & Reputación** |    —    | **9 pts** |

---

## 🛠️ 3. Descomposición Técnica de Tareas (Task Breakdown)

### 🔹 Tareas para HU-06: Solicitud de Transporte Logístico (3 pts)

1. **Modelado de Entidad:** Crear la clase `Flete.java` con los atributos (`id`, `origen`, `destino`, `pesoToneladas`, `costo`, `estado`).
2. **Capa de Persistencia:** Crear `FleteRepository.java`.
3. **Capa de Lógica (Service):** Implementar `FleteService.java` para calcular la tarifa del envío según el peso y la distancia municipal.
4. **Capa de Exposición (Controller):** Desarrollar `FleteController.java` con el endpoint POST `/api/v1/fletes/solicitar`.

### 🔹 Tareas para HU-07: Aceptación de Fletes por Transportista (3 pts)

1. **Actualización de Estado:** Agregar lógica en el servicio de fletes para permitir la transición de estado `PENDIENTE` a `ASIGNADO`.
2. **Asignación de Conductor:** Vincular el ID del usuario con rol `TRANSPORTISTA` a la solicitud de flete aceptada.
3. **Endpoint de Aceptación:** Exponer la ruta PUT `/api/v1/fletes/{id}/aceptar` para que el transportista tome el servicio.

### 🔹 Tareas para HU-08: Calificación de Vendedores (3 pts)

1. **Modelado de Entidad:** Crear la clase `Calificacion.java` con atributos (`id`, `idComprador`, `idAgricultor`, `estrellas` [1-5], `comentario`).
2. **Capa de Persistencia:** Crear `CalificacionRepository.java`.
3. **Capa de Lógica (Service):** Implementar la lógica para validar que la calificación solo ocurra tras un pedido entregado y calcular el promedio ponderado del agricultor.
4. **Capa de Exposición (Controller):** Exponer el endpoint POST `/api/v1/calificaciones`.

---

## ✅ 4. Criterios de Aceptación Técnicos del Sprint (Definition of Done)

* Las nuevas entidades de Fletes y Calificaciones se comunican correctamente con las tablas de la base de datos MySQL.
* Los endpoints del Sprint 2 responden de forma adecuada a las peticiones del cliente HTTP (Postman / Thunder Client).
* El código mantiene la arquitectura de 4 capas limpia y sin errores de compilación.
