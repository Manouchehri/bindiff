package y.f;

import y.d.*;

public class Q implements o
{
    private n a;
    private Object b;
    private R c;
    private boolean d;
    private double e;
    private double f;
    private double g;
    private boolean h;
    
    public Q(final t t, final q q, final Object b, final R c, final boolean h) {
        this.d = false;
        this.e = 0.0;
        this.f = 0.0;
        this.g = 0.0;
        this.h = false;
        this.a = new n(t.a, t.b + q.b, q.a, q.b);
        this.b = b;
        this.c = c;
        this.h = h;
    }
    
    public Q(final n a, final Object b, final R c, final boolean h) {
        this.d = false;
        this.e = 0.0;
        this.f = 0.0;
        this.g = 0.0;
        this.h = false;
        this.a = a;
        this.b = b;
        this.c = c;
        this.h = h;
    }
    
    public Q(final n n, final Object o, final R r) {
        this(n, o, r, false);
    }
    
    public double a() {
        return this.g;
    }
    
    public void a(final double g) {
        if (g < 0.0 || g > 1.0) {
            throw new IllegalArgumentException("Value does not lie in interval [0,1]");
        }
        this.g = g;
    }
    
    public Object b() {
        return this.b;
    }
    
    public t c() {
        final y a = a(this.a);
        if (a != null) {
            return a.e();
        }
        return this.a.h().e();
    }
    
    public y h() {
        final y a = a(this.a);
        if (a != null) {
            return a;
        }
        return this.a.h();
    }
    
    public n d() {
        return this.a;
    }
    
    private static y a(final n n) {
        final boolean j = X.j;
        if (n.g() == 0.0 && n.i() == -1.0) {
            final double n2 = n.b();
            final double n3 = n.c() - n.f();
            final double n4 = n.f();
            final double n5 = n.e();
            if (!j) {
                return new y(n2, n3, n5, n4);
            }
        }
        if (n.g() == 0.0 && n.i() == 1.0) {
            final double n2 = n.b() - n.e();
            final double n3 = n.c();
            final double n4 = n.f();
            final double n5 = n.e();
            if (!j) {
                return new y(n2, n3, n5, n4);
            }
        }
        if (n.g() == 1.0 && n.i() == 0.0) {
            final double n2 = n.b();
            final double n3 = n.c();
            final double n4 = n.e();
            final double n5 = n.f();
            if (!j) {
                return new y(n2, n3, n5, n4);
            }
        }
        if (n.g() == -1.0 && n.i() == 0.0) {
            final double n2 = n.b() - n.e();
            final double n3 = n.c() - n.f();
            final double n4 = n.e();
            final double n5 = n.f();
            if (!j) {
                return new y(n2, n3, n5, n4);
            }
        }
        return null;
    }
    
    public R e() {
        return this.c;
    }
    
    public boolean f() {
        return this.h;
    }
    
    public void g() {
        this.c.setModelParameter(this.b);
        this.d = true;
    }
    
    public void b(final double e) {
        this.e = e;
    }
    
    public void c(final double f) {
        this.f = f;
    }
    
    public double i() {
        return this.e;
    }
    
    public double j() {
        return this.f;
    }
    
    public double k() {
        return this.e + this.f;
    }
    
    public Object l() {
        return this.b;
    }
    
    public String toString() {
        return "Label: " + this.c.toString() + " Location: " + this.c().toString();
    }
}
