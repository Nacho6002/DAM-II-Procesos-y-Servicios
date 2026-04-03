<h1 align="center">📡 Servicio REST con FTP y Email</h1>

<p align="center">
  API backend desarrollada con <strong>Spring Boot</strong> para integrar operaciones FTP y envío de correo electrónico.
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java" />
  <img src="https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white" alt="Spring Boot" />
  <img src="https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white" alt="Docker" />
  <img src="https://img.shields.io/badge/FTP-vsftpd-2563eb?style=for-the-badge" alt="FTP" />
  <img src="https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white" alt="Postman" />
  <img src="https://img.shields.io/badge/Estado-Finalizado-success?style=for-the-badge" alt="Estado" />
</p>

---

## 🧩 Descripción

Este proyecto implementa una **API REST** que actúa como intermediaria para gestionar archivos en un servidor **FTP** y enviar notificaciones por correo electrónico.

La aplicación sigue una arquitectura en capas, separando el controlador REST de la lógica de negocio implementada en los servicios, con el objetivo de mantener un diseño más limpio, modular y fácil de ampliar.

---

## ✨ Funcionalidades

- Subida de archivos al servidor FTP
- Descarga de archivos desde el servidor FTP
- Eliminación de archivos remotos
- Envío de correos electrónicos desde la API
- Pruebas de endpoints con Postman

---

## 🛠️ Tecnologías utilizadas

- **Java**
- **Spring Boot**
- **Docker**
- **FTP (vsftpd)**
- **Spring Mail**
- **Postman**
- **Eclipse**

---

## 🧠 Arquitectura

El proyecto sigue una estructura básica en capas:

- **Controller** → gestión de peticiones HTTP
- **Service** → lógica de negocio para FTP y correo
- **App** → clase principal de arranque

Este enfoque permite desacoplar la entrada de peticiones del trabajo real con FTP y email, haciendo el proyecto más mantenible.

---

## 📂 Estructura del proyecto

- `src/main/` → código fuente principal
- `docs/` → documentación del proyecto
- `postman/` → colección Postman para pruebas
- `pom.xml` → configuración de Maven

---

## 📚 Contenido incluido

- Código fuente Java
- Documentación PDF
- Colección Postman
- Configuración del proyecto backend

---

## 🔐 Nota importante

Antes de publicar o compartir este proyecto, conviene revisar que la colección de Postman y los archivos de configuración no incluyan datos personales, correos reales o rutas locales innecesarias.

---

## 📌 Estado del proyecto

Proyecto realizado con fines académicos dentro del módulo de **Programación de Servicios y Procesos**.

---

## 👤 Autor

**Ignacio Daniel Villacis Quishpe**
