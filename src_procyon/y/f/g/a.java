package y.f.g;

import java.util.*;
import java.awt.*;
import y.f.*;
import y.f.b.*;
import y.d.*;
import java.awt.geom.*;
import y.c.*;

class a
{
    private static double b;
    private double c;
    private double d;
    private double e;
    private double f;
    private double g;
    z a;
    
    public a() {
        this.c = 1.0;
        this.d = 0.0;
        this.e = Double.MAX_VALUE;
        this.f = 0.0;
        this.g = 30.0;
        this.a = new z();
    }
    
    public void a(final double g) {
        this.g = g;
    }
    
    public SortedSet a(final X x, final y y, final y y2, final A a, final Map map, final t t, final boolean b, final y.f.g.y y3, final A a2, final A a3) {
        final Rectangle a4 = x.a();
        final double minX = a4.getMinX();
        final double maxX = a4.getMaxX();
        final b a5 = this.a(x, y, a, map.get(y), t, y3, a2, a3);
        SortedSet<u> a6;
        if (b) {
            a6 = (SortedSet<u>)this.a.a(x, y2, y, a5, t, true);
        }
        else {
            a6 = new TreeSet<u>(u.a);
            a6.add(new u(new t(minX - (maxX - minX), a5.f().b()), new t(maxX + (maxX - minX), a5.f().b()), 0));
        }
        return a6;
    }
    
    public b a(final X x, final y y, final A a, final f f, final t t, final y.f.g.y y2, final A a2, final A a3) {
        final boolean d = y.f.g.d.d;
        final Rectangle a4 = x.a();
        final double minX = a4.getMinX();
        final double maxX = a4.getMaxX();
        final double minY = a4.getMinY();
        final double n = a4.getMaxY() - minY;
        final Rectangle2D a5 = ae.a(x, y.a());
        final double minY2 = a5.getMinY();
        if (a2.d(y.b())) {
            final c c = new c(x);
            final y.c.q b = y.b();
            final f f2 = c.f(b);
            final f g = c.g(b);
            if ((f2 == null || f2.size() == 0) && (g == null || g.size() == 0)) {
                f2.a(b.k());
                g.a(b.l());
            }
            double k = minY;
            boolean b2 = false;
            final e a6 = f2.a();
            while (true) {
                while (a6.f()) {
                    final y.c.d a7 = a6.a();
                    final double i = x.k(a7.c());
                    if (d) {
                        double j = i;
                        boolean b3 = false;
                        final e a8 = g.a();
                        while (true) {
                            while (a8.f()) {
                                final y.c.d a9 = a8.a();
                                final double l = x.k(a9.d());
                                if (d) {
                                    final q q = (q)a3.b(b);
                                    final double b4 = q.b();
                                    double n2 = 0.0;
                                    Label_0405: {
                                        if (b2 && b3) {
                                            n2 = j - k;
                                            if (!d) {
                                                break Label_0405;
                                            }
                                        }
                                        n2 = b4;
                                    }
                                    final double max = Math.max(b4, n2);
                                    final q q2 = new q(q.a(), max);
                                    a3.a(b, q2);
                                    x.a(b, q2);
                                    double n3 = 0.0;
                                    final r a10 = r.a(x.c(y.f.b.f.e).b(b));
                                    if (b2 && b3) {
                                        n3 = (j - k) / 2.0;
                                        if (!d) {
                                            return new b(minX - (maxX - minX), n3, (maxX - minX) * 3.0, max, new t(t.a(), n3));
                                        }
                                    }
                                    if (b2 && !b3) {
                                        n3 = k + q2.b() / 2.0 + this.g + a10.a;
                                        if (!d) {
                                            return new b(minX - (maxX - minX), n3, (maxX - minX) * 3.0, max, new t(t.a(), n3));
                                        }
                                    }
                                    if (!b2 && b3) {
                                        n3 = j - q2.b() / 2.0 - this.g - a10.c;
                                    }
                                    return new b(minX - (maxX - minX), n3, (maxX - minX) * 3.0, max, new t(t.a(), n3));
                                }
                                if (l < j) {
                                    j = x.k(a9.d());
                                    b3 = true;
                                    final double n4 = a5.getCenterY() - x.k(a9.c());
                                }
                                a8.g();
                                if (d) {
                                    break;
                                }
                            }
                            continue;
                        }
                    }
                    if (i > k) {
                        k = x.k(a7.c());
                        b2 = true;
                        final double n5 = a5.getCenterY() - x.k(a7.d());
                    }
                    a6.g();
                    if (d) {
                        break;
                    }
                }
                continue;
            }
        }
        final A t2 = x.t();
        final x a11 = y.a();
        while (a11.f()) {
            final y.c.q e = a11.e();
            t2.a(e, x.o(e).b() - minY2);
            a11.g();
            if (d) {
                break;
            }
        }
        final y.f.g.c[] array = new y.f.g.c[f.size()];
        int n6 = 0;
        final e a12 = f.a();
        while (true) {
            while (a12.f()) {
                final y.c.d a13 = a12.a();
                final int d2;
                final int n7 = d2 = (a.d(a13.c()) ? 1 : 0);
                if (d) {
                    int n8 = d2;
                    double n9 = 0.0;
                    double n10 = n;
                    double n11 = n;
                    int n12 = 0;
                    while (n12 < array.length) {
                        final y.f.g.c c2 = array[n12];
                        y.f.g.c c3 = null;
                    Label_0964:
                        while (c3 != null) {
                            final double b5 = array[n12].b();
                            int n13 = 0;
                            double n14 = n;
                            double n15 = n;
                            int n16 = 0;
                            while (n16 < array.length) {
                                c3 = array[n16];
                                if (d) {
                                    continue Label_0964;
                                }
                                if (c3 != null) {
                                    if (array[n16].b() >= b5 && array[n16].a() == y.f.g.c.b) {
                                        final double n17 = array[n16].b() - b5;
                                        if (n17 < n14) {
                                            n14 = n17;
                                        }
                                        ++n13;
                                    }
                                    if (array[n16].b() <= b5 && array[n16].a() == y.f.g.c.a) {
                                        final double n18 = b5 - array[n16].b();
                                        if (n18 < n15) {
                                            n15 = n18;
                                        }
                                        ++n13;
                                    }
                                }
                                ++n16;
                                if (d) {
                                    break;
                                }
                            }
                            if (n13 > n8) {
                                n8 = n13;
                                n9 = b5;
                                n11 = n15;
                                n10 = n14;
                                break;
                            }
                            break;
                        }
                        ++n12;
                        if (d) {
                            break;
                        }
                    }
                    final double n19 = n9 + a5.getHeight() / 2.0;
                    final b b6 = new b(minX - (maxX - minX), n19 - n11, (maxX - minX) * 3.0, n11 + n10, new t(t.a(), n19));
                    if (i.g) {
                        y.f.g.d.d = !d;
                    }
                    return b6;
                }
                if (n7 != 0) {
                    array[n6] = new y.f.g.c(x.k(a13.c()) + x.q(a13.c()) / 2.0 + this.g - t2.c(a13.d()), y.f.g.c.a);
                }
                if (a.d(a13.d())) {
                    array[n6] = new y.f.g.c(x.k(a13.d()) - x.q(a13.d()) / 2.0 - this.g - x.q(a13.c()) - t2.c(a13.c()), y.f.g.c.b);
                }
                ++n6;
                a12.g();
                if (d) {
                    break;
                }
            }
            x.a(t2);
            int d2 = 0;
            continue;
        }
    }
    
    static {
        a.b = 30.0;
    }
}
