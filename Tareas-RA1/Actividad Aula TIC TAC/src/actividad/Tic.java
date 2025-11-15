package actividad;

public class Tic extends Thread {

    @Override
    public void run() {
        while (true) {
            
           
            System.out.println("TIC");

            try {
                Thread.sleep(1000); 
                
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
