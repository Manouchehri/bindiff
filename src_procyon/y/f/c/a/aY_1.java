package y.f.c.a;

public class aY
{
    private double[] a;
    private double b;
    private double c;
    private byte d;
    private double e;
    
    public aY() {
        this.a = new double[] { 0.5, 0.5, 0.5, 0.5 };
        this.b = 0.5;
        this.c = 0.0;
        this.d = 2;
        this.e = 5.0;
    }
    
    public double a(final int n) {
        return this.a[n];
    }
    
    public void a(final double b) {
        if (b < 0.0 || b > 1.0) {
            throw new IllegalArgumentException();
        }
        this.b = b;
    }
    
    public double a() {
        return this.b;
    }
    
    public byte b() {
        return this.d;
    }
    
    public double c() {
        return this.c;
    }
    
    public double d() {
        return this.e;
    }
}
