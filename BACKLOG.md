
# Product Backlog — AgroValle Connect

Este documento contiene la especificación formal del Product Backlog para el sistema **AgroValle Connect**, estructurado bajo la metodología Agile/Scrum. Incluye **18 Historias de Usuario** priorizadas mediante la técnica **MoSCoW**, estimadas utilizando la escala de **Fibonacci** (Story Points) y documentadas en formato **BDD (Behavior-Driven Development)**.

---

## 📊 Matriz de Resumen del Backlog

|       ID       | Historia de Usuario                     | Épica / Módulo       | Priorización MoSCoW | Story Points (Fibonacci) |
| :-------------: | :-------------------------------------- | :--------------------- | :------------------: | :-----------------------: |
| **HU-01** | Registro de Agricultores                | Usuarios / Auth        |      MUST HAVE      |        **3**        |
| **HU-02** | Publicación de Productos               | Productos / Oferta     |      MUST HAVE      |        **3**        |
| **HU-03** | Visualización de Precios Regionales    | Mercado / Analytics    |      MUST HAVE      |        **3**        |
| **HU-04** | Búsqueda y Filtrado por Municipio      | Productos / Filtros    |      MUST HAVE      |        **3**        |
| **HU-05** | Modulación de Roles y Permisos         | Seguridad / Admin      |      MUST HAVE      |        **3**        |
| **HU-06** | Solicitud de Transporte Logístico      | Logística / Fletes    |     SHOULD HAVE     |        **3**        |
| **HU-07** | Aceptación de Fletes por Transportista | Logística / Fletes    |     SHOULD HAVE     |        **3**        |
| **HU-08** | Calificación de Vendedores             | Reputación            |     SHOULD HAVE     |        **3**        |
| **HU-09** | Negociación Directa de Precios         | Negociación           |     SHOULD HAVE     |        **3**        |
| **HU-10** | Alertas Climáticas para Cosechas       | Notificaciones         |      COULD HAVE      |        **3**        |
| **HU-11** | Chat de Negociación Directa            | Comunicación          |     SHOULD HAVE     |        **3**        |
| **HU-12** | Reporte Visual de Ventas                | Analytics / Dashboard  |      COULD HAVE      |        **3**        |
| **HU-13** | Verificación de Cédula y Documentos   | Seguridad / Admin      |      MUST HAVE      |        **3**        |
| **HU-14** | Estado del Envío en Tiempo Real        | Logística / Tracking  |     SHOULD HAVE     |        **3**        |
| **HU-15** | Cancelación de Publicaciones           | Productos / Inventario |     SHOULD HAVE     |        **3**        |
| **HU-16** | Historial de Transacciones e Impresión | Compras / Facturación |     SHOULD HAVE     |        **3**        |
| **HU-17** | Recuperación y Cambio de Contraseña   | Seguridad / Auth       |      MUST HAVE      |        **3**        |
| **HU-18** | Panel de Soporte y Reporte              | Soporte / Admin        |      COULD HAVE      |        **3**        |
| **TOTAL** | **18 Historias de Usuario**       | **Sistema Core** |          —          | **54 Story Points** |

---

## 📋 Historias de Usuario y Criterios de Aceptación BDD

### HU-01: Registro de Agricultores

* **Como** Agricultor,
* **Quiero** registrarme en la plataforma,
* **Para** ofrecer mis productos.
* **Priorización:** Must | **Estimación:** 3 Story Points
* **Escenario BDD:**
  * **Given** que el usuario ingresa a `/api/v1/auth/register`,
  * **When** envía un JSON con nombre, `ubicacion_valle` y cédula válida,
  * **Then** el sistema responde con un status 201 Created y el registro persiste en la base de datos PostgreSQL.

---

### HU-02: Publicación de Productos

* **Como** Agricultor,
* **Quiero** publicar mis cosechas,
* **Para** que sean visibles.
* **Priorización:** Must | **Estimación:** 3 Story Points
* **Escenario BDD:**
  * **Given** un agricultor autenticado con token JWT,
  * **When** publica un producto con tipo, cantidad y `fecha_cosecha`,
  * **Then** el sistema valida que la fecha no sea anterior a hoy y retorna un ID de producto único.

---

### HU-03: Visualización de Precios Regionales

* **Como** Usuario,
* **Quiero** ver los precios promedio del Valle,
* **Para** negociar mejor.
* **Priorización:** Must | **Estimación:** 3 Story Points
* **Escenario BDD:**
  * **Given** que existen 50 transacciones de "Café" en las últimas 24 horas,
  * **When** solicito el precio promedio de "Café",
  * **Then** el sistema calcula la media aritmética y despliega el valor exacto en pesos colombianos.

---

### HU-04: Búsqueda y Filtrado por Municipio

* **Como** Comprador,
* **Quiero** filtrar los productos por municipio,
* **Para** reducir costos de transporte.
* **Priorización:** Must | **Estimación:** 3 Story Points
* **Escenario BDD:**
  * **Given** que existen productos publicados en diferentes municipios del Valle,
  * **When** el comprador selecciona el municipio "Palmira" en el filtro,
  * **Then** el sistema muestra únicamente las cosechas disponibles en "Palmira".

---

### HU-05: Modulación de Roles y Permisos

* **Como** Administrador,
* **Quiero** asignar roles,
* **Para** restringir el acceso a funciones del sistema.
* **Priorización:** Must | **Estimación:** 3 Story Points
* **Escenario BDD:**
  * **Given** un usuario autenticado con rol "Comprador",
  * **When** intenta ingresar a la ruta de administración `/api/v1/admin/users`,
  * **Then** el sistema bloquea el acceso con código HTTP 403 Forbidden.

---

### HU-06: Solicitud de Transporte Logístico

* **Como** Agricultor,
* **Quiero** cotizar transporte,
* **Para** enviar mi cosecha al comprador.
* **Priorización:** Should | **Estimación:** 3 Story Points
* **Escenario BDD:**
  * **Given** una venta confirmada entre origen "Candelaria" y destino "Cali",
  * **When** el agricultor solicita el cálculo de flete ingresando el peso en toneladas,
  * **Then** el sistema calcula la tarifa y muestra el costo exacto del envío.

---

### HU-07: Aceptación de Fletes por Transportista

* **Como** Transportista,
* **Quiero** aceptar solicitudes de transporte,
* **Para** gestionar la entrega.
* **Priorización:** Should | **Estimación:** 3 Story Points
* **Escenario BDD:**
  * **Given** una lista de solicitudes de transporte en estado "Pendiente",
  * **When** el transportista presiona "Aceptar Flete",
  * **Then** el sistema asigna el envío al transportista y le entrega la dirección de recogida.

---

### HU-08: Calificación de Vendedores

* **Como** Comprador,
* **Quiero** calificar al agricultor,
* **Para** generar confianza en la comunidad.
* **Priorización:** Should | **Estimación:** 3 Story Points
* **Escenario BDD:**
  * **Given** un pedido completado y entregado con éxito,
  * **When** el comprador envía una nota de 1 a 5 estrellas con un comentario,
  * **Then** el sistema guarda la calificación y actualiza el promedio del agricultor.

---

### HU-09: Negociación Directa de Precios

* **Como** Comprador,
* **Quiero** enviar una propuesta de compra,
* **Para** negociar un lote completo.
* **Priorización:** Should | **Estimación:** 3 Story Points
* **Escenario BDD:**
  * **Given** un producto publicado con un precio base de $3.000 / kg,
  * **When** el comprador propone un valor de $2.600 / kg por todo el lote,
  * **Then** el sistema crea una contraoferta y notifica al agricultor para su aprobación.

---

### HU-10: Alertas Climáticas para Cosechas

* **Como** Agricultor,
* **Quiero** recibir alertas del clima,
* **Para** proteger mis cultivos a tiempo.
* **Priorización:** Could | **Estimación:** 3 Story Points
* **Escenario BDD:**
  * **Given** que el servicio meteorológico detecta lluvias fuertes en "Dagua",
  * **When** el sistema procesa el reporte del tiempo,
  * **Then** envía una alerta a los agricultores registrados en ese municipio.

---

### HU-11: Chat de Negociación Directa

* **Como** Agricultor,
* **Quiero** chatear con el comprador,
* **Para** acordar la entrega.
* **Priorización:** Should | **Estimación:** 3 Story Points
* **Escenario BDD:**
  * **Given** una compra en proceso entre un agricultor y un comprador,
  * **When** uno de los dos envía un mensaje en el chat,
  * **Then** el sistema entrega el mensaje al instante en la pantalla del otro usuario.

---

### HU-12: Reporte Visual de Ventas

* **Como** Agricultor,
* **Quiero** ver gráficos de mis ventas,
* **Para** saber cuánto he ganado.
* **Priorización:** Could | **Estimación:** 3 Story Points
* **Escenario BDD:**
  * **Given** un agricultor con ventas realizadas en los últimos 3 meses,
  * **When** ingresa a su panel de estadísticas,
  * **Then** el sistema dibuja un gráfico con el total de dinero e ingresos por mes.

---

### HU-13: Verificación de Cédula y Documentos

* **Como** Administrador,
* **Quiero** revisar los documentos del agricultor,
* **Para** habilitar su cuenta.
* **Priorización:** Must | **Estimación:** 3 Story Points
* **Escenario BDD:**
  * **Given** una cuenta de agricultor en estado "Pendiente",
  * **When** el administrador revisa y aprueba la cédula del usuario,
  * **Then** la cuenta pasa a estado "Verificado" y ya puede publicar productos.

---

### HU-14: Estado del Envío en Tiempo Real

* **Como** Comprador,
* **Quiero** saber dónde viene mi pedido,
* **Para** recibirlo a tiempo.
* **Priorización:** Should | **Estimación:** 3 Story Points
* **Escenario BDD:**
  * **Given** un producto en camino con estado "En Tránsito",
  * **When** el transportista marca la opción "Cerca al destino",
  * **Then** el sistema manda una notificación al comprador avisando la llegada.

---

### HU-15: Cancelación de Publicaciones

* **Como** Agricultor,
* **Quiero** retirar un producto si se dañó o si ya lo vendí por fuera,
* **Para** actualizar mi oferta.
* **Priorización:** Should | **Estimación:** 3 Story Points
* **Escenario BDD:**
  * **Given** un producto publicado sin compras pendientes,
  * **When** el agricultor presiona "Retirar Publicación",
  * **Then** el sistema quita la oferta del catálogo y nadie más la puede ver.

---

### HU-16: Historial de Transacciones e Impresión de Recibos

* **Como** Comprador,
* **Quiero** ver el historial de mis compras,
* **Para** descargar los recibos de pago.
* **Priorización:** Should | **Estimación:** 3 Story Points
* **Escenario BDD:**
  * **Given** un comprador autenticado en la plataforma,
  * **When** ingresa a la sección de "Mis Compras" y presiona "Descargar Recibo",
  * **Then** el sistema genera un documento PDF con el detalle de la transacción.

---

### HU-17: Recuperación y Cambio de Contraseña

* **Como** Usuario,
* **Quiero** restablecer mi contraseña por correo si la olvido,
* **Para** no perder el acceso.
* **Priorización:** Must | **Estimación:** 3 Story Points
* **Escenario BDD:**
  * **Given** un usuario que no recuerda su clave de acceso,
  * **When** ingresa su correo en la opción "Olvidé mi contraseña",
  * **Then** el sistema envía un enlace seguro con un token temporal para restablecerla.

---

### HU-18: Panel de Soporte y Reporte de Problemas

* **Como** Usuario,
* **Quiero** enviar reportes de soporte cuando tenga inconvenientes con un pedido,
* **Para** recibir ayuda rápida.
* **Priorización:** Could | **Estimación:** 3 Story Points
* **Escenario BDD:**
  * **Given** un usuario que experimenta un problema con un envío o pago,
  * **When** completa el formulario de soporte con el asunto y la evidencia,
  * **Then** el sistema genera un ticket de atención y lo asigna al equipo administrador.
