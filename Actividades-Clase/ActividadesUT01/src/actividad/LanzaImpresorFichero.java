package actividad;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class LanzaImpresorFichero {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduzca la cadena: ");
        String cadena = scanner.nextLine();
        scanner.close();

        String javaBin = System.getProperty("java.home") + "/bin/java";
        String classpath = System.getProperty("java.class.path");
        String className = ImprimeArgs.class.getName();

        ProcessBuilder pb;
        
        if (cadena.isEmpty()) {
             pb = new ProcessBuilder(javaBin, "-cp", classpath, className);
        } else {
             pb = new ProcessBuilder(javaBin, "-cp", classpath, className, cadena);
        }
        
        File fSalida = new File("salida.txt");
        pb.redirectOutput(fSalida); // 
        
        pb.redirectError(ProcessBuilder.Redirect.INHERIT); 

        try {
            Process p = pb.start();
            int exitValue = p.waitFor();

            System.out.println("Valor de Salida: " + exitValue);
            if (exitValue == 0) {
                System.out.println("FINAL CORRECTO. Revisa 'salida.txt'");
            } else {
                System.out.println("FINAL INCORRECTO. (La salida de error se vio en consola)");
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
