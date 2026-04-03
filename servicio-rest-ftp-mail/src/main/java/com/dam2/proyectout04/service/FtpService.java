package com.dam2.proyectout04.service;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@Service
public class FtpService {

    // logger para enterarme de que pasa
    private static final Logger logger = LoggerFactory.getLogger(FtpService.class);

    @Value("${ftp.server}")
    private String server;

    @Value("${ftp.port}")
    private int port;

    @Value("${ftp.username}")
    private String user;

    @Value("${ftp.password}")
    private String pass;

    // metodo para subir un archivo al server
    public boolean subirFichero(MultipartFile file, String rutaDestino) {
        FTPClient ftpClient = new FTPClient();
        try {
            logger.info("Conectando a FTP para subir: " + file.getOriginalFilename());
            ftpClient.connect(server, port);
            ftpClient.login(user, pass);
            // modo pasivo clave para que no de problemas con docker
            ftpClient.enterLocalPassiveMode(); 
            // tipo binario para no romper pdfs ni imagenes
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE); 

            // si hay ruta destino la usamos si no el nombre normal
            String nombreRemoto = (rutaDestino != null && !rutaDestino.isEmpty()) ? rutaDestino : file.getOriginalFilename();

            InputStream inputStream = file.getInputStream();
            boolean hecho = ftpClient.storeFile(nombreRemoto, inputStream);
            inputStream.close();
            
            ftpClient.logout();
            ftpClient.disconnect();
            
            if(hecho) logger.info("Subida correcta a: " + nombreRemoto);
            else logger.error("Fallo al subir archivo FTP");
            
            return hecho;

        } catch (IOException ex) {
            logger.error("Error FTP Subir: " + ex.getMessage());
            return false;
        }
    }

    // para bajar cosas a tu propio pc
    public boolean descargarFichero(String rutaRemota, String rutaLocal) {
        FTPClient ftpClient = new FTPClient();
        try {
            logger.info("Bajando de FTP: " + rutaRemota + " -> A local: " + rutaLocal);
            ftpClient.connect(server, port);
            ftpClient.login(user, pass);
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

            // creamos el archivo en el pc
            File archivoDestino = new File(rutaLocal);
            OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(archivoDestino));
            
            // bajamos el archivo del ftp
            boolean exito = ftpClient.retrieveFile(rutaRemota, outputStream);
            outputStream.close();
            
            ftpClient.logout();
            ftpClient.disconnect();
            
            if (exito) {
                logger.info("Archivo guardado en disco correctamente.");
            } else {
                logger.error("No se pudo descargar (archivo no existe o error ruta).");
                // si falla borramos el archivo vacio que se creo en local
                if(archivoDestino.exists()) archivoDestino.delete();
            }
            return exito;

        } catch (IOException ex) {
            logger.error("Error FTP Descargar: " + ex.getMessage());
            return false;
        }
    }

    // para borrar el archivo del ftp
    public boolean borrarFichero(String rutaRemota) {
        FTPClient ftpClient = new FTPClient();
        try {
            logger.info("Intentando borrar en FTP: " + rutaRemota);
            ftpClient.connect(server, port);
            ftpClient.login(user, pass);
            ftpClient.enterLocalPassiveMode();

            boolean borrado = ftpClient.deleteFile(rutaRemota);
            
            ftpClient.logout();
            ftpClient.disconnect();
            
            if(borrado) logger.info("Archivo eliminado del FTP.");
            else logger.warn("No se pudo borrar (quizas no existe).");
            
            return borrado;

        } catch (IOException ex) {
            logger.error("Error FTP Borrar: " + ex.getMessage());
            return false;
        }
    }
}