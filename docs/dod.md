
# Definition of Done (DoD) — AgroValle Connect

Este documento define los criterios de calidad y finalización técnica que debe cumplir cada Historia de Usuario antes de considerarse completa y lista para ser integrada en la rama principal (`main`) del proyecto AgroValle Connect (UniAJC).

---

## ✅ Criterios de Aceptación Técnica (Definition of Done)

1. **Código Compilable y Sin Errores:**

   * El código fuente compila de forma exitosa mediante Maven (`BUILD SUCCESS` en Spring Boot) sin advertencias críticas de compilación.
2. **Estándar de Arquitectura y Patrones:**

   * Se respeta estrictamente la arquitectura de 4 capas (Controller, Service, Repository, Model).
   * Se aplican los principios de diseño orientados a objetos y los patrones GoF establecidos en el diseño del sistema.
3. **Persistencia y Base de Datos:**

   * Las entidades JPA están correctamente mapeadas con anotaciones de Spring y se sincronizan de forma limpia con la base de datos MySQL.
4. **Pruebas de Endpoints:**

   * Los endpoints creados en los controladores han sido probados localmente (vía Postman o Thunder Client), validando los códigos de respuesta HTTP correctos (200, 201, 400, 403, 404).
5. **Control de Versiones (Git & GitHub):**

   * El código se encuentra debidamente documentado con mensajes de commit descriptivos bajo el estándar de Conventional Commits (`feat:`, `fix:`, `docs:`).
   * Los cambios están sincronizados y respaldados en el repositorio remoto de GitHub.
