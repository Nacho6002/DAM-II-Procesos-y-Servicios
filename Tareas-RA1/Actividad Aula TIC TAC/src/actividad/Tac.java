package actividad;

public class Tac extends Thread {

    @Override
    public void run() {
        while (true) {
            System.out.println("TAC");
            try {
                Thread.sleep(1000); 

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
