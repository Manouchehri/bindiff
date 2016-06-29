package y.h;

import y.d.*;

class ew
{
    private boolean a;
    private boolean b;
    private t c;
    private double d;
    private double e;
    
    public ew(final t c, final boolean a, final boolean b, final double d, final double e) {
        this.c = c;
        this.a = a;
        this.b = b;
        this.d = d;
        this.e = e;
    }
    
    public ew(final t t, final double n, final double n2) {
        this(t, false, false, n, n2);
    }
    
    public boolean a() {
        return this.b;
    }
    
    public boolean b() {
        return this.a;
    }
    
    public double c() {
        return this.d;
    }
    
    public double d() {
        return this.e;
    }
    
    public t a(final double n, final double n2) {
        return new t(this.a(n), this.b(n2));
    }
    
    public z a(final double n, final double n2, final double n3) {
        double b = b(this.a(n2), n);
        if (this.b() && Math.abs(b) > 0.0) {
            b = Double.MAX_VALUE;
        }
        double b2 = b(this.b(n3), n);
        if (this.a() && Math.abs(b2) > 0.0) {
            b2 = Double.MAX_VALUE;
        }
        return new z(b, b2);
    }
    
    public double b(final double n, final double n2, final double n3) {
        final z a = this.a(n, n2, n3);
        return Math.max(Math.abs(a.a()), Math.abs(a.b()));
    }
    
    public double c(final double n, final double n2, final double n3) {
        final z a = this.a(n, n2, n3);
        return Math.min(Math.abs(a.a()), Math.abs(a.b()));
    }
    
    public final double a(final double n) {
        if (this.b()) {
            return this.c.a;
        }
        return this.c.a + n;
    }
    
    public final double b(final double n) {
        if (this.a()) {
            return this.c.b;
        }
        return this.c.b + n;
    }
    
    private static double b(final double n, final double n2) {
        return Math.floor(n / n2 + 0.5) * n2 - n;
    }
}
