package Ejercicio_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class JefeInteractivo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// --- 1. El Jefe pregunta al USUARIO qué quiere hacer ---
        Scanner consolaDelJefe = new Scanner(System.in);
        System.out.print("JEFE: Escriba la palabra para el empleado: ");
        String palabraParaEmpleado = consolaDelJefe.nextLine();
        consolaDelJefe.close();

        try {
            String miClasspath = "bin"; // O "bin"

            // --- 2. Escribir el Contrato ---
            // Fíjate: ¡NO le pasamos la palabra aquí!
            ProcessBuilder contrato = new ProcessBuilder(
                "java",
                "-cp",
                miClasspath,
                "Ejercicio_3.EmpleadoInteractivo"
            );

            // --- 3. ¡A Trabajar! (`.start()`) ---
            Process empleado = contrato.start();

            // --- 4. ¡LA HABILIDAD NUEVA! El Jefe habla por el Walkie-Talkie ---
            // `proceso.getOutputStream()` es el walkie-talkie del Jefe
            // `try-with-resources` (el try con paréntesis) cierra el walkie automáticamente
            System.out.println("JEFE: Enviando orden '" + palabraParaEmpleado + "' al empleado...");
            try (PrintWriter walkieJefe = new PrintWriter(empleado.getOutputStream())) {
                walkieJefe.println(palabraParaEmpleado); // ¡Jefe hablando!
                // .println() envía la palabra Y un "salto de línea"
                // Esto es VITAL para que el .nextLine() del empleado se active.
            } // El walkie se cierra aquí. Esto le dice al empleado "¡cambio y corto!".

            

            // --- 5. El Jefe escucha la respuesta (Como en el Paso 1) ---
            // Escuchamos el altavoz NORMAL
            System.out.println("JEFE: Escuchando respuesta del altavoz NORMAL...");
            BufferedReader traductorNormal = new BufferedReader(new InputStreamReader(empleado.getInputStream()));
            String lineaNormal;
            while ((lineaNormal = traductorNormal.readLine()) != null) {
                System.out.println(lineaNormal); // Muestra la respuesta BUENA
            }

            // Escuchamos el altavoz de ERROR
            System.out.println("JEFE: Escuchando respuesta del altavoz de ERROR...");
            BufferedReader traductorError = new BufferedReader(new InputStreamReader(empleado.getErrorStream()));
            String lineaError;
            while ((lineaError = traductorError.readLine()) != null) {
                System.err.println(lineaError); // Muestra la respuesta MALA
            }
            
            // --- 6. Esperar a la bandera (Como en el Paso 2) ---
            int codigoSalida = empleado.waitFor();
            System.out.println("JEFE: El empleado terminó y levantó la bandera: " + codigoSalida);

        } catch (IOException | InterruptedException e) {
            System.err.println("JEFE: ¡Error! Falló la comunicación con el empleado.");
            e.printStackTrace();
        }
    }
}