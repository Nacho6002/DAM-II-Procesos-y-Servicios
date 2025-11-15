package actividad;

import java.io.IOException;

public class LanzaValidador {

    public static void main(String[] args) {
        
        String[] argumentos = {"5"};
        String javaHome = System.getProperty("java.home");
        String javaBin = javaHome + "/bin/java"; 
        String classpath = System.getProperty("java.class.path");
        String className = ValidadorArgs.class.getName();
        
        ProcessBuilder pb = new ProcessBuilder(javaBin, "-cp", classpath, className);
        
        pb.command().addAll(java.util.Arrays.asList(argumentos));
        
        pb.inheritIO();
        
        try {
            Process p = pb.start();
            int exitValue = p.waitFor();
            
            System.out.println("Valor de Salida: " + exitValue);
            
            switch (exitValue) {
                case 0:
                    System.out.println("NÚMERO MAYOR O IGUAL QUE 0...");
                    break;
                case 1:
                    System.out.println("NO HAY ARGUMENTOS...");
                    break;
                case 2:
                    System.out.println("ES UNA CADENA...");
                    break;
                case 3:
                    System.out.println("NÚMERO MENOR QUE 0...");
                    break;
                default:
                    System.out.println("Valor de salida desconocido.");
            }
            
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
