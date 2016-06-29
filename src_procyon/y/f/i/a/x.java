package y.f.i.a;

public class x
{
    private double a;
    private double b;
    private double c;
    private double d;
    private byte e;
    private ad f;
    
    public x() {
        this.a = 5.0;
        this.b = 10.0;
        this.c = 3.0;
        this.d = 3.0;
        this.e = 0;
        this.f = new ad();
    }
    
    public double a() {
        return this.a;
    }
    
    public double b() {
        return this.b;
    }
    
    public double c() {
        return this.c;
    }
    
    public void a(final double n) {
        this.c = ((n < 0.0) ? 3.0 : n);
    }
    
    public double d() {
        return this.d;
    }
    
    public byte e() {
        return this.e;
    }
    
    public void a(final byte e) {
        switch (e) {
            case 0:
            case 1:
            case 2:
            case 3: {
                this.e = e;
                if (ab.a != 0) {
                    break;
                }
                return;
            }
        }
        this.e = 0;
    }
    
    public ad f() {
        return this.f;
    }
    
    public void a(final ad f) {
        if (f == null) {
            throw new IllegalArgumentException("penaltySettings must not be null");
        }
        this.f = f;
    }
}
