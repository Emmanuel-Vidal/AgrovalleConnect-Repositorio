# AgroValle Connect 🌾

[![Java](https://img.shields.io/badge/Java-17-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot](<https://img.shields.io/badge/Spring%20Boot-3.2.x-green.svg>)](https://spring.io/projects/spring-boot)
[![MySQL](https://img.shields.io/badge/MySQL-8.0-blue.svg)](https://www.mysql.com/)
[![License](https://img.shields.io/badge/License-Academic-lightgrey.svg)]()

> Plataforma tecnológica orientada a optimizar la cadena de comercialización agrícola en el Departamento del Valle del Cauca, conectando de forma directa a agricultores, compradores y transportistas para eliminar intermediarios y garantizar un comercio justo.

---

## 👥 Datos Académicos e Integrantes

* **Institución:** Institución Universitaria Antonio José Camacho (UniAJC)
* **Facultad / Programa:** Facultad de Ingeniería | Ingeniería de Sistemas
* **Asignatura:** Ingeniería de Software
* **Docente:** Paola Andrea Bedoya
* **Estudiantes / Desarrolladores:** Emmanuel Vidal Moreno, Micael David Robayo 

---

## 🛠️ Stack Tecnológico

* **Lenguaje de Programación:** Java 17
* **Framework Backend:** Spring Boot (Spring Data JPA, Spring Web)
* **Base de Datos:** MySQL (Esquema relacional con DDL optimizado)
* **Gestor de Dependencias:** Apache Maven
* **Metodología Agil:** Scrum (Backlog de 18 Historias de Usuario con BDD, MoSCoW y Fibonacci)

---

## 📊 Diagrama de Arquitectura (Mermaid)

```mermaid

graph TD
    Client[Cliente / Postman / Frontend] -->|Peticiones HTTP REST| Controller[Capa Controller / Presentación]
    Controller -->|Delegación de negocio| Service[Capa Service / Lógica de Negocio]
    Service -->|Consultas y Persistencia| Repository[Capa Repository / JPA Interfaces]
    Repository -->|Mapeo ORM| Database[(Base de Datos MySQL)]
```

## 📂 Estructura Oficial del Repositorio


<img width="542" height="312" alt="image" src="https://github.com/user-attachments/assets/ed58e772-c9a7-4dc5-ae4f-07ee6578f31c" />
