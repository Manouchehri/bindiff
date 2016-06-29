package y.f.i.a;

import y.d.*;

public class P
{
    private final M a;
    private final double b;
    private final boolean c;
    
    P(final double n, final double n2, final double n3, final double n4) {
        if (Math.abs(n2 - n4) < 1.0E-6 && Math.abs(n - n3) < 1.0E-6) {
            throw new IllegalStateException("Not able to calculate the orientation.");
        }
        this.c = (Math.abs(n - n3) < 1.0E-6);
        this.a = (this.c ? new M(n2, n4) : new M(n, n3));
        this.b = (this.c ? n : n2);
    }
    
    public P(final double n, final double n2, final double n3, final boolean b) {
        this(new M(n, n2), n3, b);
    }
    
    public P(final M a, final double b, final boolean c) {
        if (a == null) {
            throw new IllegalArgumentException("range must not be null");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public boolean a() {
        return this.c;
    }
    
    public double b() {
        return this.a.a();
    }
    
    public double c() {
        return this.a.b();
    }
    
    public double d() {
        return this.a.b() - this.a.a();
    }
    
    public M e() {
        return this.a;
    }
    
    public double f() {
        return this.b;
    }
    
    public double a(final P p) {
        if (this.c != p.c) {
            return this.e().b(p.f()) + p.e().b(this.f());
        }
        return this.e().b(p.e()) + Math.abs(this.f() - p.f());
    }
    
    public boolean b(final P p) {
        return this.a(p, 0.0);
    }
    
    public boolean a(final P p2, final double n) {
        if (this.c != p2.c) {
            throw new IllegalArgumentException("orthogonal intervals have different orientation");
        }
        return this.a.a(p2.a, n);
    }
    
    public boolean c(final P p) {
        if (this.c != p.c) {
            throw new IllegalArgumentException("orthogonal intervals have different orientation");
        }
        return this.a.c(p.a);
    }
    
    public boolean d(final P p) {
        if (this.c != p.c) {
            throw new IllegalArgumentException("orthogonal intervals have different orientation");
        }
        return this.a.d(p.a);
    }
    
    public static P a(final P p2, final P p3) {
        if (p2.c != p3.c) {
            throw new IllegalArgumentException("orthogonal intervals have different orientation");
        }
        final M a = M.a(p2.a, p3.a);
        if (a != null) {
            return new P(a.a(), a.b(), p3.b, p3.a());
        }
        return null;
    }
    
    public String toString() {
        return "OrthogonalInterval{range=" + this.a + ", location=" + this.b + ", isVertical=" + this.c + '}';
    }
    
    private double g() {
        return this.c ? this.c() : this.b;
    }
    
    private double h() {
        return this.c ? this.b : this.c();
    }
    
    private double i() {
        return this.c ? this.b() : this.b;
    }
    
    private double j() {
        return this.c ? this.b : this.b();
    }
    
    static boolean a(final y y, final P p2) {
        final double j = p2.j();
        final double i = p2.i();
        final double h = p2.h();
        final double g = p2.g();
        return y.a(j, i) || y.a(h, g);
    }
}
