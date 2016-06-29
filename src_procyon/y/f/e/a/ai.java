package y.f.e.a;

import y.c.*;

public class ai implements am, ax
{
    private double a;
    private double b;
    private double c;
    private double d;
    private double e;
    private double f;
    private double g;
    private double h;
    
    public void a(final double e, final double f, final double c, final double d) {
        this.e = e;
        this.f = f;
        this.c = c;
        this.d = d;
        this.g = this.e + this.c / 2.0;
        this.h = this.f + this.d / 2.0;
    }
    
    public ai() {
        this.a = 0.5;
        this.b = 50.0;
        this.g = this.e + this.c / 2.0;
        this.h = this.f + this.d / 2.0;
    }
    
    public ai(final double n, final double n2, final double n3, final double n4, final double b) {
        this.a = 0.5;
        this.b = 50.0;
        this.g = this.e + this.c / 2.0;
        this.h = this.f + this.d / 2.0;
        this.a(n, n2, n3, n4);
        this.b = b;
    }
    
    public k a(final m m, final l l, final a a) {
        final boolean b = af.b;
        if (this.c <= 0.0 || this.d <= 0.0) {
            return a;
        }
        final k a2 = m.a();
        final double n = (this.c - 2.0 * this.b) / 2.0;
        final double n2 = (this.d - 2.0 * this.b) / 2.0;
        final double n3 = this.g - a2.d();
        final double n4 = this.h - a2.e();
        if (-n3 > n && -n4 > n2) {
            this.a(a2.d() - (this.g + n), a2.e() - (this.h + n2), a);
            return a;
        }
        if (n3 > n && -n4 > n2) {
            this.a(-a2.d() + (this.g - n), a2.e() - (this.h + n2), a);
            a.a(-a.d());
            return a;
        }
        if (n3 > n && n4 > n2) {
            this.a(-a2.d() + (this.g - n), -a2.e() + (this.h - n2), a);
            a.a(-a.d());
            a.b(-a.e());
            return a;
        }
        if (-n3 > n && n4 > n2) {
            this.a(a2.d() - (this.g + n), -a2.e() + (this.h - n2), a);
            a.b(-a.e());
            return a;
        }
        Label_0450: {
            if (n3 > 0.0) {
                if (n3 > n) {
                    a.a((n3 - n) / this.b);
                    return a;
                }
                a.a(0.0);
                if (!b) {
                    break Label_0450;
                }
            }
            if (-n3 > n) {
                a.a((n3 + n) / this.b);
                return a;
            }
            a.a(0.0);
        }
        if (n4 > 0.0) {
            if (n4 > n2) {
                a.b((n4 - n2) / this.b);
                return a;
            }
            a.b(0.0);
            if (!b) {
                return a;
            }
        }
        if (-n4 > n2) {
            a.b((n4 + n2) / this.b);
            return a;
        }
        a.b(0.0);
        return a;
    }
    
    private void a(final double n, final double n2, final a a) {
        final boolean b = af.b;
        double n3 = 0.0;
        double n4 = 0.0;
        final double n5 = this.b * this.a;
        Label_0192: {
            if (n - n5 >= n2) {
                n3 = -n / this.b;
                if (!b) {
                    break Label_0192;
                }
            }
            if (n2 - n5 >= n) {
                n4 = -n2 / this.b;
                if (!b) {
                    break Label_0192;
                }
            }
            if (n < n5 && n2 < n5 && Math.sqrt(n * n + n2 * n2) <= n5) {
                n3 = -n / this.b;
                n4 = -n2 / this.b;
                if (!b) {
                    break Label_0192;
                }
            }
            final double n6 = (n + n2) / 2.0 - Math.sqrt(n5 * n5 - (n - n2) * (n - n2) / 2.0) * 0.7071067811865476;
            final double n7 = (n6 + n5) / (this.b * n5);
            n3 = (n6 - n) * n7;
            n4 = (n6 - n2) * n7;
        }
        a.a(n3);
        a.b(n4);
    }
    
    public void a(final l l, final af af) {
        final boolean b = af.b;
        final double n = this.g - af.h();
        final double n2 = this.h - af.i();
        final x o = af.f().o();
        while (o.f()) {
            final ag c = af.c(o.e());
            c.a(c.b() + n);
            c.b(c.c() + n2);
            o.g();
            if (b) {
                break;
            }
        }
    }
}
