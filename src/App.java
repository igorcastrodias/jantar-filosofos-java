public class App {

    private static final int QTDFILOSOFOS = 5;
    public static void main(String[] args) throws Exception {
        Recursos recursos = new RecursosImpl(QTDFILOSOFOS);
        for (int i = 0; i < QTDFILOSOFOS; i++) {
            new Filosofo(i, recursos).start();
        }

    }
}
