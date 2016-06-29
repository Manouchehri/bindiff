package y.b;

final class k implements Runnable
{
    private final d a;
    
    public k(final d a) {
        this.a = a;
    }
    
    public void run() {
        this.a.initAnimation();
    }
}
