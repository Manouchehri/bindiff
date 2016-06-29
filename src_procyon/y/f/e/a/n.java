package y.f.e.a;

import y.f.*;
import y.f.b.*;
import y.d.*;
import java.util.*;
import y.g.*;
import y.f.e.*;
import y.c.*;

class n extends a
{
    public void c(final X x) {
        final boolean b = af.b;
        if (this.a() != null) {
            this.a().c(x);
        }
        final y.c.c c = x.c(f.e);
        final y.c.c c2 = x.c(as.a);
        if (y.f.b.c.c(x) || c2 == null) {
            return;
        }
        final r r = new r(5.0, 5.0, 5.0, 5.0);
        final c c3 = new c(x);
        final A t = x.t();
        final HashSet<q> set = new HashSet<q>();
        final y y = new y();
        final x o = x.o();
        do {
            Label_0123: {
                o.f();
            }
            boolean d = false;
            Label_0130:
            while (d) {
                final q e = o.e();
                Label_0246: {
                    if (c3.d(e) && c2.d(e)) {
                        if (!set.add(e)) {
                            break Label_0246;
                        }
                        y.add(e);
                        if (!b) {
                            break Label_0246;
                        }
                    }
                    q q = c3.a(e);
                    while (q != c3.b()) {
                        d = c2.d(q);
                        if (b) {
                            continue Label_0130;
                        }
                        if (d) {
                            break;
                        }
                        q = c3.a(q);
                        if (b) {
                            break;
                        }
                    }
                    t.a(e, q);
                }
                o.g();
                continue Label_0123;
            }
            break;
        } while (!b);
        final J j = new J(x, t);
        final x a = y.a();
        do {
            Label_0277: {
                a.f();
            }
            boolean d2 = false;
            Label_0284:
            while (d2) {
                final q e2 = a.e();
                j.c(e2);
                r r2 = r;
                if (!b) {
                    if (c != null) {
                        final r a2 = y.d.r.a(c.b(e2));
                        if (a2 != null) {
                            r2 = a2;
                        }
                    }
                    final double n = x.m(e2) + r2.b;
                    final double n2 = x.n(e2) + r2.a;
                    final double n3 = x.p(e2) - r2.b - r2.d;
                    final double n4 = x.q(e2) - r2.a - r2.c;
                    final I i = new I(x);
                    final y.c.c c4 = x.c(d.n);
                    if (c4 != null) {
                        final x o2 = x.o();
                        while (o2.f()) {
                            final q e3 = o2.e();
                            d2 = c4.d(e3);
                            if (b) {
                                continue Label_0284;
                            }
                            if (!d2) {
                                i.a(e3);
                            }
                            o2.g();
                            if (b) {
                                break;
                            }
                        }
                    }
                    y.f.j.a.a(x, n, n2, n3, n4);
                    if (c4 != null) {
                        i.f();
                    }
                    a.g();
                    continue Label_0277;
                }
                return;
            }
            break;
        } while (!b);
        j.b();
        x.a(t);
        c3.c();
    }
}
