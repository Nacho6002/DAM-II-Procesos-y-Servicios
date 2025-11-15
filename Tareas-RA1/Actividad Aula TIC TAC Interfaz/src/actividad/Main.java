package actividad;

public class Main {

    public static void main(String[] args) {

        Tic tareaTic = new Tic();
        Tac tareaTac = new Tac();
        
        Thread hiloTic = new Thread(tareaTic);
        Thread hiloTac = new Thread(tareaTac);
        
        hiloTic.start();
        hiloTac.start();
    }
}