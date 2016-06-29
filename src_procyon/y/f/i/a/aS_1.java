package y.f.i.a;

import y.c.*;
import y.d.*;

class aS extends aT
{
    private w g;
    private double h;
    private double i;
    private final boolean j;
    private double k;
    private double l;
    private Object m;
    private y n;
    private int o;
    private final aN p;
    
    aS(final aN p6, final m m, final m i, final w g, final Object j, final int o) {
        super(g.c(), m.b() ? m : i, m.a() ? m : i);
        this.p = p6;
        this.o = o;
        this.g = g;
        final ai a = g.a(o);
        final ai a2 = g.a(o + 1);
        Label_0130: {
            if (a2.g()) {
                this.j = false;
                this.i = a.e();
                this.h = a2.e();
                if (ab.a == 0) {
                    break Label_0130;
                }
            }
            this.j = true;
            this.i = a2.e();
            this.h = a.e();
        }
        this.m = j;
        this.k = (g.b() ? 0.0 : this.m());
        this.n = this.l();
    }
    
    public boolean a() {
        return false;
    }
    
    public Object f() {
        return this.m;
    }
    
    public double b() {
        return this.h;
    }
    
    public double c() {
        return this.i;
    }
    
    public double d() {
        if (this.c == 3 || this.c == 1) {
            return this.h - this.k;
        }
        return this.h + this.k;
    }
    
    public double e() {
        if (this.c == 0 || this.c == 1) {
            return this.i - this.k;
        }
        return this.i + this.k;
    }
    
    public void a(final double l) {
        this.l = l;
    }
    
    private y l() {
        if (this.c == 3) {
            return new y(this.h - this.k, this.i, this.k, this.k);
        }
        if (this.c == 2) {
            return new y(this.h, this.i, this.k, this.k);
        }
        if (this.c == 0) {
            return new y(this.h, this.i - this.k, this.k, this.k);
        }
        return new y(this.h - this.k, this.i - this.k, this.k, this.k);
    }
    
    public y h() {
        return this.n;
    }
    
    private double m() {
        final int a = ab.a;
        final double g = this.a.g();
        final double g2 = this.b.g();
        double n = aN.a(this.p) * ((g < g2) ? g : g2);
        final R r = this.g.c[this.o];
        final R r2 = this.g.b[this.o];
        if (r != null) {
            final double abs = Math.abs(this.i - r.i());
            final double abs2 = Math.abs(this.i - r.k());
            double n2 = 0.0;
            Label_0152: {
                if (this.c == 3 || this.c == 2) {
                    n = Math.min(n, abs2);
                    n2 = abs;
                    if (a == 0) {
                        break Label_0152;
                    }
                }
                n = Math.min(n, abs);
                n2 = abs2;
            }
            double n3 = 0.0;
            Label_0203: {
                if (this.c == 1 || this.c == 3) {
                    n3 = Math.abs(this.h - r.h());
                    if (a == 0) {
                        break Label_0203;
                    }
                }
                n3 = Math.abs(this.h - r.j());
            }
            n = Math.min(n, n3 + n2);
        }
        if (r2 != null) {
            final double abs3 = Math.abs(this.h - r2.h());
            final double abs4 = Math.abs(this.h - r2.j());
            double n4 = 0.0;
            Label_0296: {
                if (this.c == 0 || this.c == 2) {
                    n = Math.min(n, abs4);
                    n4 = abs3;
                    if (a == 0) {
                        break Label_0296;
                    }
                }
                n = Math.min(n, abs3);
                n4 = abs4;
            }
            double n5 = 0.0;
            Label_0346: {
                if (this.c == 1 || this.c == 0) {
                    n5 = Math.abs(this.i - r2.i());
                    if (a == 0) {
                        break Label_0346;
                    }
                }
                n5 = Math.abs(this.i - r2.k());
            }
            n = Math.min(n, n5 + n4);
        }
        return n;
    }
    
    public D g() {
        final int a = ab.a;
        final D d = new D();
        if (this.l < 1.0E-6) {
            d.add(new t(this.h, this.i));
            return d;
        }
        final double a2 = this.b.c().a;
        final double b = this.a.c().b;
        double n = 0.0;
        double n2 = 0.0;
        Label_0348: {
            if (this.c == 2) {
                n = Math.min(this.b.c().b, this.b.d().b) + this.l;
                n2 = Math.min(this.a.c().a, this.a.d().a) + this.l;
                if (a == 0) {
                    break Label_0348;
                }
            }
            if (this.c == 3) {
                n = Math.min(this.b.c().b, this.b.d().b) + this.l;
                n2 = Math.max(this.a.c().a, this.a.d().a) - this.l;
                if (a == 0) {
                    break Label_0348;
                }
            }
            if (this.c == 1) {
                n = Math.max(this.b.c().b, this.b.d().b) - this.l;
                n2 = Math.max(this.a.c().a, this.a.d().a) - this.l;
                if (a == 0) {
                    break Label_0348;
                }
            }
            n = Math.max(this.b.c().b, this.b.d().b) - this.l;
            n2 = Math.min(this.a.c().a, this.a.d().a) + this.l;
        }
        if (this.j) {
            d.add(new t(a2, n));
            d.add(new t(n2, b));
            if (a == 0) {
                return d;
            }
        }
        d.add(new t(n2, b));
        d.add(new t(a2, n));
        return d;
    }
}
