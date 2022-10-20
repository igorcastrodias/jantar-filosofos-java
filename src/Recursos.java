public interface Recursos {
    public void obter(int id) throws InterruptedException;
    public void liberar(int id);
}