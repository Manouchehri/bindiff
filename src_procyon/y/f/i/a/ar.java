package y.f.i.a;

import y.f.c.a.*;
import y.d.*;
import y.c.*;
import java.util.*;

class ar extends K
{
    public void a(final Z z, final I i) {
        final int a = ab.a;
        super.a(z, i);
        final bk c = bk.c(z.a());
        if (c != null) {
            final D f = c.f();
            final D e = c.e();
            f.sort(new as(this));
            e.sort(new at(this));
            l l = null;
            int n = 0;
            int n2 = 0;
            final Iterator iterator = f.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                l j = null;
                double n3 = 0.0;
                double f2 = 0.0;
            Label_0094:
                while (true) {
                    Comparable comparable = null;
                    j = (l)comparable;
                    n3 = ((l != null) ? (l.h() + l.e()) : j.g());
                    f2 = j.f();
                    Comparable comparable2 = null;
                    for (final bt bt : e) {
                        comparable = comparable2;
                        if (a != 0) {
                            continue Label_0094;
                        }
                        final double n4 = (comparable != null) ? (((bt)comparable2).h() + ((bt)comparable2).e()) : bt.f();
                        final double g = bt.g();
                        this.b().a(new y(n3, n4, f2, g), new au(c.a(bt, j), n2, n, null));
                        bt.g(n4);
                        bt.d(g);
                        comparable2 = bt;
                        ++n;
                        if (a != 0) {
                            break;
                        }
                    }
                    break;
                }
                j.g(n3);
                j.d(f2);
                l = j;
                ++n2;
                n = 0;
                if (a != 0) {
                    break;
                }
            }
        }
    }
    
    public void b(final R r) {
        final int a = ab.a;
        for (final N n : this.b().e(r)) {
            if (n.b() instanceof au) {
                final au au = (au)n.b();
                r.a(T.e, y.f.i.a.au.a(au));
                r.a(T.f, new Integer(y.f.i.a.au.b(au)));
                r.a(T.g, new Integer(y.f.i.a.au.c(au)));
                if (a != 0) {
                    break;
                }
                continue;
            }
        }
    }
}
