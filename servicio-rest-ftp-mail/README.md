# Servicio REST con FTP y Email
> Spring Boot · FTP · Docker · Email · Postman

Proyecto académico del módulo de **Programación de Servicios y Procesos** desarrollado con **Spring Boot**, integrando un servidor **FTP en Docker** y un servicio de **envío de correo electrónico**.

## Descripción
Este proyecto implementa una API REST que actúa como intermediaria para gestionar archivos en un servidor FTP y enviar notificaciones por correo electrónico.

La aplicación sigue una arquitectura en capas, separando el controlador REST de la lógica de negocio implementada en los servicios.

## Funcionalidades
- Subida de archivos al servidor FTP
- Descarga de archivos desde el servidor FTP
- Eliminación de archivos remotos
- Envío de correos electrónicos desde la API
- Pruebas de endpoints con Postman

## Tecnologías utilizadas
- Java
- Spring Boot
- Docker
- FTP (vsftpd)
- Spring Mail
- Postman
- Eclipse

## Arquitectura
El proyecto sigue una estructura básica en capas:
- **Controller**: gestión de peticiones HTTP
- **Service**: lógica de negocio para FTP y correo
- **App**: clase principal de arranque

## Estructura del proyecto
- `src/main/` → código fuente principal
- `docs/` → documentación del proyecto
- `postman/` → colección Postman para pruebas
- `pom.xml` → configuración de Maven

## Contenido incluido
- Código fuente Java
- Documentación PDF
- Colección Postman

## Notas
Proyecto realizado con fines académicos dentro del módulo de Programación de Servicios y Procesos.
