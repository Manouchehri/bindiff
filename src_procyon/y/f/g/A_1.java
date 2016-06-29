package y.f.g;

import y.f.b.*;
import y.g.*;
import y.f.c.*;
import java.awt.*;
import y.c.*;
import y.f.c.a.*;
import java.awt.geom.*;
import y.f.*;

class A
{
    private y.c.A a;
    private double[] b;
    private double[] c;
    private double[] d;
    private boolean[] e;
    private double[] f;
    private double g;
    
    A(final double g) {
        this.g = g;
    }
    
    public void a(final X x, final c c) {
        final boolean d = y.f.g.d.d;
        this.a = M.a();
        final Rectangle a = x.a();
        final y.c.A a2 = M.a();
        final D d2 = new D(a2, M.b());
        final x o = x.o();
        while (o.f()) {
            final q e = o.e();
            this.a.a(o.e(), -1);
            a2.a(e, new B(null, null, null));
            o.g();
            if (d) {
                i.g = !i.g;
                break;
            }
        }
        final F f = new F(d2);
        final y.c.c c2 = x.c(y.f.g.d.a);
        final I i = new I(x);
        final y y = new y();
        final x o2 = x.o();
        while (o2.f()) {
            final q e2 = o2.e();
            Label_0243: {
                if (c.d(e2)) {
                    i.a(e2);
                    if (!d) {
                        break Label_0243;
                    }
                }
                if (c2.d(e2)) {
                    y.add(e2);
                    i.a(e2);
                }
            }
            o2.g();
            if (d) {
                break;
            }
        }
        final y.c.e p2 = x.p();
        while (p2.f()) {
            final y.c.d a3 = p2.a();
            if (a3.e()) {
                i.a(a3);
            }
            p2.g();
            if (d) {
                break;
            }
        }
        final e e3 = new e();
        e3.a(30.0);
        e3.a(x, f, d2);
        i.a(y, true);
        final y.c.e p3 = x.p();
        while (true) {
            while (p3.f()) {
                final y.c.d a4 = p3.a();
                if (d) {
                    new m(new aj()).a(x, f, d2);
                    x.d_(N.t);
                    this.b = new double[f.b()];
                    this.c = new double[f.b()];
                    this.f = new double[f.b()];
                    this.d = new double[f.b()];
                    this.e = new boolean[f.b()];
                    int j = 0;
                Label_0764_Outer:
                    while (j < f.b()) {
                        final aQ a5 = f.a(j);
                        this.b[j] = a.getMaxY();
                        this.c[j] = a.getMinY();
                        int n = 0;
                        if (!d) {
                            final x a6 = a5.d().a();
                            while (true) {
                                while (a6.f()) {
                                    final q e4 = a6.e();
                                    this.f[j] = Math.max(this.f[j], x.q(e4));
                                    this.a.a(e4, j);
                                    final int d3 = c2.d(e4) ? 1 : 0;
                                    if (!d) {
                                        if (d3 == 0) {
                                            ++n;
                                            final double[] d4 = this.d;
                                            final int n2 = j;
                                            d4[n2] += x.k(e4);
                                            this.b[j] = Math.min(this.b[j], x.n(e4));
                                            this.c[j] = Math.max(this.c[j], x.n(e4) + x.q(e4));
                                            this.f[j] = Math.max(this.f[j], this.c[j] - this.b[j]);
                                        }
                                        a6.g();
                                        if (d) {
                                            break;
                                        }
                                        continue Label_0764_Outer;
                                    }
                                    else {
                                        if (d3 > 0) {
                                            this.e[j] = true;
                                            final double[] d5 = this.d;
                                            final int n3 = j;
                                            d5[n3] /= n;
                                        }
                                        ++j;
                                        if (d) {
                                            break Label_0764_Outer;
                                        }
                                        continue Label_0764_Outer;
                                    }
                                }
                                continue;
                            }
                        }
                        return;
                    }
                    i.f();
                    return;
                }
                if (a4.e()) {
                    i.a(a4);
                }
                p3.g();
                if (d) {
                    break;
                }
            }
            x.a(N.t, c2);
            continue;
        }
    }
    
    public int a(final q q) {
        return this.a.a(q);
    }
    
    public y.d.y a(final q q, final X x, final y.c.A a) {
        final boolean d = y.f.g.d.d;
        final int a2 = this.a.a(q);
        if (a2 < 0) {
            return null;
        }
        final Rectangle2D a3 = this.a(x, q, a);
        double minY = a3.getMinY();
        double minY2 = a3.getMinY();
        int i = a2 - 1;
        while (i >= 0) {
            if (this.e[i]) {
                minY = this.c[i] + this.g;
                minY2 = this.d[i];
                if (!d) {
                    break;
                }
            }
            --i;
            if (d) {
                break;
            }
        }
        double maxY = a3.getMaxY();
        double maxY2 = a3.getMaxY();
        double n = 0.0;
        int j = a2 + 1;
        while (true) {
            while (j < this.e.length) {
                final boolean b = this.e[j];
                if (!d) {
                    if (b) {
                        maxY = this.b[j] - this.g;
                        maxY2 = this.d[j];
                        if (!d) {
                            break;
                        }
                    }
                    n += this.f[j] + this.g;
                    ++j;
                    if (d) {
                        break;
                    }
                    continue;
                }
                else {
                    if (!b) {
                        minY -= n;
                        minY2 -= n;
                        maxY -= n;
                        maxY2 -= n;
                    }
                    if (maxY - minY > x.q(q)) {
                        return new y.d.y(a3.getX(), minY, a3.getWidth(), maxY - minY);
                    }
                    if (maxY2 - minY2 > x.q(q)) {
                        return new y.d.y(a3.getX(), minY2, a3.getWidth(), maxY2 - minY2);
                    }
                    return new y.d.y(a3.getX(), minY2 - (minY2 - maxY2 + x.q(q)) * 0.5, a3.getWidth(), x.q(q));
                }
            }
            continue;
        }
    }
    
    private Rectangle2D a(final X x, final q q, final y.c.c c) {
        final boolean d = y.f.g.d.d;
        final y.d.q r = x.r(q);
        boolean b = false;
        double min = Double.MAX_VALUE;
        double min2 = Double.MAX_VALUE;
        double max = -1.7976931348623157E308;
        double max2 = -1.7976931348623157E308;
        final x o = x.o();
        while (o.f()) {
            if (c == null || c.d(o.e())) {
                final am h = x.h(o.e());
                min = Math.min(min, h.getX());
                min2 = Math.min(min2, h.getY());
                max = Math.max(max, h.getX() + h.getWidth());
                max2 = Math.max(max2, h.getY() + h.getHeight());
                b = true;
            }
            o.g();
            if (d) {
                break;
            }
        }
        if (b) {
            return new Rectangle2D.Double(min - this.g - r.a() - 100.0, min2 - this.g - r.b() - 100.0, max - min + 2.0 * (this.g + 100.0 + r.a()), max2 - min2 + 2.0 * (this.g + 100.0 + r.b()));
        }
        return new Rectangle2D.Double(0.0, 0.0, r.a(), r.b());
    }
}
