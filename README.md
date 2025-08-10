# 🛠️ ServiPlux: Sistema de Gestión de Órdenes de Servicio

![Spring Modulith](https://img.shields.io/badge/Spring%20Modulith-1.4.1-green)
![Java](https://img.shields.io/badge/Java-21-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.4-brightgreen)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-16-blue)
![Maven](https://img.shields.io/badge/Maven-3.8-red)
![Docker](https://img.shields.io/badge/Docker-ready-blue)

**ServiPlux** es una API REST diseñada para la gestión integral de órdenes de servicio técnico para la reparación de electrodomésticos de línea blanca. El sistema permite llevar un control completo del flujo de trabajo, desde la solicitud inicial del cliente hasta la finalización del servicio y la calificación del técnico.

## 🚀 Características Principales

* **Gestión de Clientes:** Administración de perfiles de clientes y sus solicitudes.
* **Gestión de Técnicos:** Control de técnicos, su asignación a servicios y su evaluación de desempeño.
* **Ciclo de Vida de la Orden de Servicio:** Manejo completo del flujo de una orden (solicitud, cotización, aprobación, ejecución, pago y finalización).
* **Inventario de Refacciones:** Módulo para el control de existencias de piezas de repuesto.
* **Reportes y Métricas:** Generación de dashboards y reportes para evaluar el rendimiento y premiar al "Técnico del Mes".

## 🏗️ Arquitectura del Proyecto

El proyecto está construido con una arquitectura modular utilizando **Spring Modulith**. Esta división en módulos permite un desarrollo, mantenimiento y escalabilidad más eficientes.

* `serviplux.shared`: Módulo con utilidades y clases compartidas.
* `serviplux.customer`: Módulo para la gestión de clientes.
* `serviplux.technician`: Módulo para la gestión de técnicos.
* `serviplux.serviceorder`: El núcleo del negocio, gestiona el ciclo de vida de las órdenes de servicio.
* `serviplux.inventory`: Controla el inventario de refacciones.
* `serviplux.reports`: Genera reportes y métricas de rendimiento.

## ⚙️ Tecnologías Utilizadas

* **Backend:**
    * **Java 21**
    * **Spring Boot 3.4.5:** Framework principal para la construcción de la API.
    * **Spring Modulith:** Para una arquitectura modular y desacoplada.
    * **Spring Data JPA / Hibernate:** Para la persistencia de datos.
    * **Lombok:** Para reducir el boilerplate del código.
* **Base de Datos:**
    * **PostgreSQL 16:** Base de datos relacional robusta.
* **Herramientas:**
    * **Maven:** Gestor de dependencias y construcción del proyecto.
    * **Docker & Docker Compose:** Para un entorno de desarrollo consistente y reproducible.

## 🚀 Cómo Empezar

### Prerrequisitos

Asegúrate de tener instalado:
* Java Development Kit (JDK) 21
* Maven
* Docker & Docker Compose

### 1. Clonar el Repositorio

```bash
git clone [https://github.com/jviera/serviplux.git](https://github.com/jviera/serviplux.git)
cd serviplux