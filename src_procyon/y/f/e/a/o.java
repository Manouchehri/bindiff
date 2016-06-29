package y.f.e.a;

public class o implements aw
{
    protected double a;
    protected double b;
    protected int c;
    protected long d;
    private double e;
    
    public o() {
        this(0.03, 0.02);
        this.d = 30000L;
    }
    
    public o(final double a, final double b) {
        this.c = Integer.MAX_VALUE;
        this.d = 30000L;
        this.a = a;
        this.b = b;
    }
    
    public void a(final double a) {
        this.a = a;
    }
    
    public void b(final double b) {
        this.b = b;
    }
    
    public void a(final long d) {
        if (d == 0L) {
            this.d = Long.MAX_VALUE;
            if (!af.b) {
                return;
            }
        }
        this.d = d;
    }
    
    public double a(final l l) {
        if (this.b(l)) {
            return 1.0;
        }
        if (l.c() < 1) {
            this.e = 0.0;
        }
        final double n = 1.0 - this.a;
        final w b = l.b();
        final double n2 = (1.0 - b.c()) / n * 0.4 + (1.0 - (b.c() + b.d())) / (1.0 - (this.a + this.b)) * 0.5 + (1.0 - b.d()) / (1.0 - this.b) * 0.1;
        final double n3 = n2 * n2;
        double n4 = 0.0;
        if (this.c > 0 && this.c < Integer.MAX_VALUE) {
            n4 = l.c() / this.c;
        }
        final double max = Math.max(n3, n4);
        double n5 = 0.0;
        if (this.d > 0L && this.d < Long.MAX_VALUE) {
            n5 = l.e() / this.d;
        }
        this.e = this.e * 0.6 + Math.max(max, n5) * 0.4;
        double e = this.e;
        if (e < 0.0) {
            e = 0.0;
        }
        if (e > 1.0) {
            e = 0.9999999;
        }
        return e;
    }
    
    public boolean b(final l l) {
        return l.b().f().e() < 2 || l.e() > this.d || l.c() >= this.c || (l.b().c() < this.a && l.b().d() < this.b);
    }
}
