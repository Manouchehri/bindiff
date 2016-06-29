package y.f.k;

import y.c.*;

class F
{
    private int a;
    private E b;
    private y c;
    private double d;
    private double e;
    private double f;
    private double g;
    
    F(final int a, final E b) {
        this.c = new y();
        this.b = b;
        this.a = a;
    }
    
    void a(final q q, final P p3, final l l) {
        this.c.add(q);
        final T t = new T(l.a(), this.b.a().a((Object)q));
        final double n = t.d() + t.a() * this.g;
        final double e = n - p3.g();
        final double f = p3.d() - n;
        if (e > this.e) {
            this.e = e;
        }
        if (f > this.f) {
            this.f = f;
        }
    }
    
    void a(final q q, final x x, final l l, final double n, final double n2) {
        final P p5 = new P(l, x.f(q));
        final T t = new T(l.a(), this.b.a().a((Object)q));
        final double n3 = t.d() + t.a() * this.g;
        final double e = n3 - p5.g() + n;
        final double f = p5.d() - n3 + n2;
        if (e > this.e) {
            this.e = e;
        }
        if (f > this.f) {
            this.f = f;
        }
    }
    
    public double a() {
        return this.f;
    }
    
    public double b() {
        return this.e;
    }
    
    int c() {
        return this.a;
    }
    
    E d() {
        return this.b;
    }
    
    F e() {
        return E.a(this.d(), this.a + 1);
    }
    
    public void a(final double d) {
        this.d = d;
    }
    
    public void b(final double g) {
        this.g = g;
    }
}
