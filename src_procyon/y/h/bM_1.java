package y.h;

class bM implements Runnable
{
    private final bS a;
    
    bM(final bS a) {
        this.a = a;
    }
    
    public void run() {
        this.a.a();
    }
}
