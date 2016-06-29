package y.b;

final class i implements Runnable
{
    private final d a;
    
    public i(final d a) {
        this.a = a;
    }
    
    public void run() {
        this.a.disposeAnimation();
    }
}
