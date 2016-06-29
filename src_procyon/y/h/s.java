package y.h;

import y.d.*;
import y.c.*;
import y.f.*;

public class s implements E
{
    private double a;
    private double b;
    private double c;
    private double d;
    private double e;
    private double f;
    
    public s() {
        this.a = 0.0;
        this.b = 0.5;
        this.c = 0.5;
        this.e = 0.0;
        this.f = 1.0;
    }
    
    public double a() {
        return this.f;
    }
    
    public double b() {
        return this.d;
    }
    
    public double d() {
        return this.b;
    }
    
    public double e() {
        return this.c;
    }
    
    public double f() {
        return this.a;
    }
    
    public void a(final double a) {
        this.a = a;
    }
    
    public Object c() {
        return new u(0.5, -1);
    }
    
    public n a(final q q, final I i, final am am, final am am2, Object c) {
        if (!(c instanceof u)) {
            c = this.c();
        }
        final u u = (u)c;
        final v v = new v(null);
        this.a(i, am, am2, u, v);
        return this.a(q.a, q.b, v);
    }
    
    private n a(final double n, final double n2, final v v) {
        final double n3 = v.c + this.b();
        final double sin = Math.sin(n3);
        final double n4 = -Math.cos(n3);
        final double n5 = n2 * (this.e() - 1.0);
        final double n6 = -n * this.d();
        return new n(v.a + sin * n5 - n4 * n6, v.b + n4 * n5 + sin * n6, n, n2, sin, n4);
    }
    
    protected y.d.v a(final I i, final am am, final am am2) {
        return ae.a(i, am, am2, this.e);
    }
    
    private void a(final I i, final am am, final am am2, final u u, final v v) {
        final boolean z = fj.z;
        final int b = u.b();
        final y.d.v a = this.a(i, am, am2);
        if (a.h() <= 0) {
            final y.d.t sourcePoint = i.getSourcePoint();
            final y.d.t targetPoint = i.getTargetPoint();
            final double n = sourcePoint.a * (1.0 - u.a()) + targetPoint.a * u.a();
            final double n2 = sourcePoint.b * (1.0 - u.a()) + targetPoint.b * u.a();
            final double n3 = targetPoint.a - sourcePoint.a;
            final double n4 = targetPoint.b - sourcePoint.b;
            final double sqrt = Math.sqrt(n3 * n3 + n4 * n4);
            double n5 = 0.0;
            double n6 = 0.0;
            Label_0173: {
                if (sqrt > 0.0) {
                    n5 = n3 / sqrt;
                    n6 = n4 / sqrt;
                    if (!z) {
                        break Label_0173;
                    }
                }
                n5 = 1.0;
                n6 = 0.0;
            }
            this.a(v, n, n2, n5, n6);
            if (!z) {
                return;
            }
        }
        Label_0466: {
            if (b < 0) {
                final double n7 = a.k() * u.a();
                final y.d.u b2 = a.b();
                y.d.t a2 = b2.a();
                double n8 = 0.0;
                b2.g();
                while (true) {
                    while (b2.f()) {
                        final y.d.t a3 = b2.a();
                        final double n9 = a3.a - a2.a;
                        final double n10 = a3.b - a2.b;
                        final double sqrt2 = Math.sqrt(n9 * n9 + n10 * n10);
                        if (!z) {
                            if (n8 + sqrt2 >= n7) {
                                final double n11 = (n7 - n8) / sqrt2;
                                final double n12 = a2.a * (1.0 - n11) + a3.a * n11;
                                final double n13 = a2.b * (1.0 - n11) + a3.b * n11;
                                double n14 = 0.0;
                                double n15 = 0.0;
                                Label_0405: {
                                    if (sqrt2 > 0.0) {
                                        n14 = n9 / sqrt2;
                                        n15 = n10 / sqrt2;
                                        if (!z) {
                                            break Label_0405;
                                        }
                                    }
                                    n14 = 1.0;
                                    n15 = 0.0;
                                }
                                this.a(v, n12, n13, n14, n15);
                                return;
                            }
                            a2 = a3;
                            n8 += sqrt2;
                            b2.g();
                            if (z) {
                                break;
                            }
                            continue;
                        }
                        else {
                            if (z) {
                                break Label_0466;
                            }
                            return;
                        }
                    }
                    this.a(v, a2.a, a2.b, 1.0, 0.0);
                    continue;
                }
            }
        }
        final m a4 = a.a(Math.min(b, a.h() - 2));
        final y.d.t c = a4.c();
        final y.d.t d = a4.d();
        final double n16 = c.a * (1.0 - u.a()) + d.a * u.a();
        final double n17 = c.b * (1.0 - u.a()) + d.b * u.a();
        final double n18 = d.a - c.a;
        final double n19 = d.b - c.b;
        final double sqrt3 = Math.sqrt(n18 * n18 + n19 * n19);
        double n20 = 0.0;
        double n21 = 0.0;
        Label_0627: {
            if (sqrt3 > 0.0) {
                n20 = n18 / sqrt3;
                n21 = n19 / sqrt3;
                if (!z) {
                    break Label_0627;
                }
            }
            n20 = 1.0;
            n21 = 0.0;
        }
        this.a(v, n16, n17, n20, n21);
    }
    
    void a(final v v, final double n, final double n2, final double n3, final double n4) {
        final double f = this.f();
        v.a = n - n4 * f;
        v.b = n2 + n3 * f;
        v.c = this.a(n3, n4);
    }
    
    protected double a(final double n, final double n2) {
        return Math.atan2(n2, n);
    }
    
    public D a(final C c, final I i, final am am, final am am2) {
        final boolean z = fj.z;
        final D d = new D();
        final n orientedBox = c.getOrientedBox();
        final v v = new v(null);
        final y.d.v a = this.a(i, am, am2);
        int n = 0;
        final double a2 = this.a();
        final double e = orientedBox.e();
        final double f = orientedBox.f();
        final n n2 = new n(0.0, 0.0, e, f);
        n2.a(-this.b());
        final double a3 = n2.h().a();
        final y.d.s j = a.j();
        while (true) {
            while (j.f()) {
                final y.d.t c2 = j.a().c();
                final y.d.t d2 = j.a().d();
                final double g = j.a().g();
                final double n3 = dcmpl(g, 0.1);
                if (z) {
                    if (n3 != 0) {
                        final u u = (u)this.c();
                        this.a(i, am, am2, u, v);
                        d.add(new Q(this.a(e, f, v), u, c, false));
                    }
                    return d;
                }
                Label_0492: {
                    if (n3 > 0) {
                        final double n4 = d2.a - c2.a;
                        final double n5 = d2.b - c2.b;
                        this.a(v, c2.a, c2.b, n4 / g, n5 / g);
                        d.add(new Q(this.a(e, f, v), new u(0.0, n), c, false));
                        final int min = Math.min(100, (int)Math.floor(a2 * g / a3));
                        double n7;
                        final double n6 = n7 = ((min == 0) ? 1.0 : (1.0 / min));
                        int k = 0;
                        while (true) {
                            while (k < min - 1) {
                                this.a(v, c2.a * (1.0 - n7) + d2.a * n7, c2.b * (1.0 - n7) + d2.b * n7, n4 / g, n5 / g);
                                final u u2 = new u(n7, n);
                                d.add(new Q(this.a(e, f, v), u2, c, false));
                                n7 += n6;
                                ++k;
                                if (z) {
                                    d.add(new Q(this.a(e, f, v), u2, c, false));
                                    break Label_0492;
                                }
                                if (z) {
                                    break;
                                }
                            }
                            this.a(v, d2.a, d2.b, n4 / g, n5 / g);
                            final u u2 = new u(1.0, n);
                            continue;
                        }
                    }
                }
                j.g();
                ++n;
                if (z) {
                    break;
                }
            }
            d.isEmpty();
            continue;
        }
    }
    
    public Object a(final n n, final I i, final am am, final am am2) {
        return this.c();
    }
}
