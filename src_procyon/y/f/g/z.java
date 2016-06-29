package y.f.g;

import y.d.*;
import y.f.b.*;
import y.f.*;
import java.util.*;
import java.awt.geom.*;
import y.c.*;

class z
{
    public SortedSet a(final X x, final y y, final y y2, final b b, final t t, final boolean b2) {
        final boolean d = y.f.g.d.d;
        final TreeSet<u> set = new TreeSet<u>(u.a);
        final c c = new c(x);
        final Rectangle2D a = ae.a(x, y2.a());
        final Rectangle2D a2 = ae.a(x, y.a());
        final HashSet<Double> set2 = new HashSet<Double>();
        final HashSet<Double> set3 = new HashSet<Double>();
        final double n = a2.getMinX() - x.f() * a.getWidth();
        final double n2 = a2.getMaxX() + x.f() * a.getWidth();
        final double n3 = a2.getMinY() - x.f() * a.getHeight();
        final double n4 = a2.getMaxY() + x.f() * a.getHeight();
        boolean b3 = false;
        final x a3 = y2.a();
        do {
            Label_0150: {
                a3.f();
            }
            boolean add = false;
            Label_0157:
            while (add) {
                final q e = a3.e();
                if (!d) {
                    final x a4 = y.a();
                    while (a4.f()) {
                        final q e2 = a4.e();
                        final double n5 = x.k(e2) - x.k(e);
                        add = set2.add(new Double(n5));
                        if (d) {
                            continue Label_0157;
                        }
                        if (add) {
                            final double n6 = a.getCenterY() + n5;
                            if (n6 >= b.d() && n6 <= b.d() + b.b()) {
                                int n7 = 0;
                                Label_0316: {
                                    if (b2) {
                                        n7 = (int)Math.abs(x.k(e2) - t.b());
                                        if (!d) {
                                            break Label_0316;
                                        }
                                    }
                                    n7 = (int)t.a(x.l(e2), t);
                                }
                                b3 = true;
                                set.add(new u(new t(n, n6), new t(n2, n6), n7));
                            }
                        }
                        final double n8 = x.j(e2) - x.j(e);
                        if (set3.add(new Double(n8))) {
                            final double n9 = a.getCenterX() + n8;
                            if (n9 >= b.c() && n9 <= b.c() + b.a()) {
                                set.add(new u(new t(n9, n3), new t(n9, n4), (int)t.a(x.l(e2), t)));
                            }
                        }
                        a4.g();
                        if (d) {
                            break;
                        }
                    }
                    a3.g();
                    continue Label_0150;
                }
                return set;
            }
            break;
        } while (!d);
        if (!b3 && b2) {
            final double b4 = b.f().b();
            set.add(new u(new t(n, b4), new t(n2, b4), (int)Math.abs(b4 - t.b())));
        }
        c.c();
        return set;
    }
}
