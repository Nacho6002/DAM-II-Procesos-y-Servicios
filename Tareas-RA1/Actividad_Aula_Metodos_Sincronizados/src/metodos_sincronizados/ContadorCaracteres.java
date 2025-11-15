package metodos_sincronizados;

public class ContadorCaracteres {
    private int mayus;
    private int minus;
    private int nums;

    public synchronized void sumarMayus() {
        mayus++; // sumo mayúscula
    }
    
    public synchronized void sumarMinus() {
        minus++; // sumo minúscula
    }
    
    public synchronized void sumarNum() {
        nums++; // sumo número
    }
    
    public int getMayus() {
        return mayus;
    }
    public int getMinus() {
        return minus;
    }
    public int getNums() {
        return nums;
    }
}
