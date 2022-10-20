public class Filosofo extends Thread {
    private int id;
    private Recursos recursos;

    public Filosofo(int id, Recursos recursos) {
        super();
        this.id = id;
        this.recursos = recursos;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Filosofo " + this.id + " - Pensando");
                Thread.sleep(35);
                System.out.println("Filosofo " + this.id + " - Faminto");
                this.recursos.obter(this.id);
                System.out.println("Filosofo " + this.id + " - Comendo");
                Thread.sleep(20);
                this.recursos.liberar(this.id);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
