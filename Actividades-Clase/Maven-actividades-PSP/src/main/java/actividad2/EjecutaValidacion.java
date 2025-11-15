package actividad2;

public class EjecutaValidacion {

	public static void main(String[] args) {
		
        try {
        	String classPath = "target/classes";
        	
            // Preparar el comando con los argumentos recibidos
            String[] comando = new String[args.length + 4];
            comando[0] = "java";
            comando[1] =  "-cp";
            comando[2] = classPath;
            comando[3] = "actividad2.ValidaArgumentos";
            
            // Copiar los argumentos recibidos
            System.arraycopy(args, 0, comando, 4, args.length);
            //System.out.println("Comando: " + comando[0] + " " + comando[1] + " " + comando[2] + " " + comando[3]+ " " + comando[4]+ " " + comando[5]);                
            // Crear y ejecutar el proceso
            ProcessBuilder pb = new ProcessBuilder(comando);
            Process proceso = pb.start();
            
            // Esperar a que termine y obtener el código de salida
            int codigoSalida = proceso.waitFor();
            
            // Mostrar el resultado según el código de salida
            System.out.println("Valor de Salida: " + codigoSalida);
            
            switch (codigoSalida) {
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
                    System.out.println("ERROR DESCONOCIDO...");
            }
            
        } catch (Exception e) {
            System.err.println("Error al ejecutar el programa: " + e.getMessage());
            System.exit(1);
        }
    }

}
