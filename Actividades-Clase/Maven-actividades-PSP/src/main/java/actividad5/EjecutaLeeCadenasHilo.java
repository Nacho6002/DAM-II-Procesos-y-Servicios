package actividad5;

import java.io.*;

public class EjecutaLeeCadenasHilo {

	public static void main(String[] args) {
		
        try {
        	String classPath = "target/classes";
        	
            // Ejecuta el programa LectorDeCadenas
            ProcessBuilder pb = new ProcessBuilder("java", "-cp", classPath, "actividad5.LeeCadenas");
            

            Process proceso = pb.start();

            // Flujo para enviar datos al proceso
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(proceso.getOutputStream()));

            // Flujo para leer la salida del proceso
            BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
            BufferedReader consola = new BufferedReader(new InputStreamReader(System.in));

            // Hilo para mostrar la salida del proceso en tiempo real
            Thread salidaProceso = new Thread(new Runnable() {
                @Override
                public void run() {
                    String linea;
                    try {
                        while ((linea = reader.readLine()) != null) {
                            System.out.println(linea);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                };
            });
            salidaProceso.start();

            // Enviar lo que el usuario escriba a la entrada del proceso
            String entrada;
            while ((entrada = consola.readLine()) != null) {
                writer.write(entrada + "\n");
                writer.flush();
                if (entrada.equals("*")) {
                    break;
                }
            }

            writer.close();
            salidaProceso.join(); // Espera a que termine el hilo de lectura
            proceso.waitFor();    // Espera a que termine el proceso

            System.out.println("El programa LectorDeCadenas ha terminado.");

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
