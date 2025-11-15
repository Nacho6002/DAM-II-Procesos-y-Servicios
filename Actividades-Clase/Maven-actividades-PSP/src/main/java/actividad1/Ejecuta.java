package actividad1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ejecuta {

	public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Error: Debe proporcionar al menos un comando para ejecutar");
            System.exit(1);
        }

        try {
            // Crear el array con el comando y sus argumentos
            ProcessBuilder pb = new ProcessBuilder(args);
            
            // Redirigir la salida de error al stream de salida estándar
            pb.redirectErrorStream(true);
            
            // Iniciar el proceso
            System.out.println("Ejecutando comando: " + String.join(" ", args));
            Process proceso = pb.start();
            
            // Leer la salida del proceso
            BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream())
            );
            
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
            
            // Esperar a que el proceso hijo termine
            int codigoSalida = proceso.waitFor();
            
            // Verificar si hubo algún error en la ejecución
            if (codigoSalida != 0) {
                System.err.println("El proceso hijo terminó con errores. Código de salida: " + codigoSalida);
            } else {
                System.out.println("El proceso hijo terminó correctamente");
            }
            
        } catch (Exception e) {
            System.err.println("Error al ejecutar el comando: " + e.getMessage());
            System.exit(1);
        }
    }

}
