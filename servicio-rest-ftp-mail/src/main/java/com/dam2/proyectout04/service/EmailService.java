package com.dam2.proyectout04.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    // logger solo para saber si se envia bien o no
    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);

    @Autowired
    private JavaMailSender mailSender;
    
    // pillamos el remitente del application properties
    @Value("${spring.mail.username}")
    private String remitente;

    // mandamos el correo con los datos que nos pasan
    public void enviarCorreo(String destinatario, String asunto, String cuerpo) {
        try {
            logger.info("Enviando correo a: " + destinatario);
            
            SimpleMailMessage mensaje = new SimpleMailMessage();
            mensaje.setFrom(remitente);
            mensaje.setTo(destinatario);
            mensaje.setSubject(asunto);
            mensaje.setText(cuerpo);

            mailSender.send(mensaje);
            
            logger.info("Correo enviado con EXITO.");
        } catch (Exception e) {
            logger.error("FALLO al enviar correo: " + e.getMessage());
        }
    }
}