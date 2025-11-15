package Ejercicio_2;

import java.io.IOException;

public class JefeControlador {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("JEFE: Voy a contratar a un validador...");
		
		String numeroParaProbar = "5";
		
		try {
			 ProcessBuilder contrato = new ProcessBuilder("java", "-cp", "bin", "Ejercicio_2.EmpleadorValidador", numeroParaProbar);
			 
			 contrato.redirectErrorStream(true);
			 
			 System.out.println("JEFE: ¡Empleado, revisa esto: " + numeroParaProbar + "!");
			 Process empleado = contrato.start();
			 
			 int CodigoSalida = empleado.waitFor();
			 
			 System.out.println("JEFE: El empleado terminó y levantó la bandera: " + CodigoSalida);
			 
			 switch (CodigoSalida) {
			 case 0:
				 System.out.println("JEFE (Traducción): El número era válido. ¡Perfecto!");
                 break;
             case 1:
                 System.out.println("JEFE (Traducción): Olvidé darle el número.");
                 break;
             case 2:
                 System.out.println("JEFE (Traducción): El número era negativo.");
                 break;
             case 3:
                 System.out.println("JEFE (Traducción): Le di una letra en vez de un número.");
                 break;
             default:
                 System.out.println("JEFE (Traducción): El empleado me dio un código que no entiendo.");
			 }
			 
		}catch(IOException | InterruptedException e){
			System.err.println("JEFE: ¡Error! No pude ni contratar al empleado validador.");
            e.printStackTrace();
		}

	}

}
