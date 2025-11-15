package actividad;

public class Main {

    public static void main(String[] args) {

        Tic hiloTic = new Tic();
        Tac hiloTac = new Tac();
        
        
        hiloTic.start();
        hiloTac.start();
    }
}


//No se sale el Tic Tac en orden va variando el orden de salida