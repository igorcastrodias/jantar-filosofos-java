import java.util.concurrent.Semaphore;

public class RecursosImpl implements Recursos {

    private int n = 0;
    private Semaphore[] garfo;

    

    public RecursosImpl(int n) {
        this.n = n;
        this.garfo = new Semaphore[n];
        for (int i = 0; i < n; i++) {
            this.garfo[i] = new Semaphore(1);
        }
    }

    @Override
    public void obter(int id) throws InterruptedException {
        if(id == (this.n-1)){ 
            this.garfo[(id+1) % this.n].acquire();
            this.garfo[id].acquire();
        } else {
            this.garfo[id].acquire();
            this.garfo[(id+1) % this.n].acquire();
        } 
    }

    @Override
    public void liberar(int id) {
        if(id == (this.n-1)){ 
            this.garfo[(id + 1) % this.n].release();
            this.garfo[id].release();
        } else {
            this.garfo[id].release();
            this.garfo[(id + 1) % this.n].release();
        }
    }
    
}
