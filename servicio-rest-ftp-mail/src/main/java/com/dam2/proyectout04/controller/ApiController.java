package com.dam2.proyectout04.controller;

import com.dam2.proyectout04.service.EmailService;
import com.dam2.proyectout04.service.FtpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ApiController {

    // logger para ver que pasa en la consola
    private static final Logger logger = LoggerFactory.getLogger(ApiController.class);

    @Autowired
    private FtpService ftpService;

    @Autowired
    private EmailService emailService;

    // subir el archivo al servidor
    @PostMapping("/upload-file")
    public ResponseEntity<String> uploadFile(
            @RequestParam("file") MultipartFile file,
            @RequestParam(value = "uploadPath", required = false) String uploadPath) {
        
        logger.info(">>> API: Recibida petición para subir archivo: " + file.getOriginalFilename());
        
        // si nos pasan ruta especifica la usamos si no el nombre original
        String destino = (uploadPath != null && !uploadPath.isEmpty()) ? uploadPath : file.getOriginalFilename();
        
        boolean exito = ftpService.subirFichero(file, destino);
        
        if (exito) {
            return ResponseEntity.ok("Archivo subido correctamente al servidor FTP.");
        } else {
            return ResponseEntity.status(500).body("Error al subir el archivo.");
        }
    }

    // descargar archivo en tu la pc tal cual como los ejemplos del pdf profe
    @PostMapping("/download-file")
    public ResponseEntity<String> downloadFile(
            @RequestParam("remoteFilePath") String remoteFilePath,
            @RequestParam("localPath") String localPath) {
        
        logger.info(">>> API: Recibida petición descarga. Remoto: " + remoteFilePath + " -> Local: " + localPath);
        
        boolean exito = ftpService.descargarFichero(remoteFilePath, localPath);
        
        if (exito) {
            return ResponseEntity.ok("Archivo descargado correctamente en: " + localPath);
        } else {
            return ResponseEntity.status(404).body("No se pudo descargar el archivo (Verifica que exista o la ruta local).");
        }
    }

    // borrar archivo del servidor por si acaso
    @DeleteMapping("/delete-file")
    public ResponseEntity<String> deleteFile(@RequestParam("remoteFilePath") String remoteFilePath) {
        
        logger.info(">>> API: Recibida petición para eliminar: " + remoteFilePath);
        
        boolean exito = ftpService.borrarFichero(remoteFilePath);
        
        if (exito) {
            return ResponseEntity.ok("Archivo eliminado correctamente del FTP.");
        } else {
            return ResponseEntity.status(404).body("No se pudo eliminar el archivo (quizás no existe).");
        }
    }

    // mandar correo usando el servicio
    @PostMapping("/send-email")
    public ResponseEntity<String> sendEmail(
            @RequestParam("to") String to,
            @RequestParam("subject") String subject,
            @RequestParam("body") String body) {
        
        logger.info(">>> API: Recibida petición enviar correo a: " + to);
        emailService.enviarCorreo(to, subject, body);
        
        return ResponseEntity.ok("Correo enviado (o en cola de envío).");
    }
}