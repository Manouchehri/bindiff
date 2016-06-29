package y.b;

final class j implements Runnable
{
    private final d a;
    private double b;
    
    public j(final d a) {
        this.a = a;
        this.b = 0.0;
    }
    
    public void a(final double b) {
        this.b = b;
    }
    
    public void run() {
        this.a.calcFrame(this.b);
    }
}
