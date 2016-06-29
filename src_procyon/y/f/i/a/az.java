package y.f.i.a;

import y.d.*;
import y.f.*;
import y.c.*;
import java.util.*;

class az extends K
{
    public void a(final Z z, final I i) {
        final int a = ab.a;
        super.a(z, i);
        final X a2 = z.a();
        final double l = z.c().l();
        if (l > 0.0) {
            final x o = a2.o();
            while (o.f()) {
                final q e = o.e();
                final y s = a2.s(e);
                this.b().a(new y(s.c() - l, s.d() - l, s.a() + 2.0 * l, s.b() + 2.0 * l), new aB(e, null));
                o.g();
                if (a != 0) {
                    break;
                }
            }
        }
    }
    
    public void b(final R r) {
        final int a = ab.a;
        final List e = this.b().e(r);
        final List d = this.b().d(r);
        final ArrayList<q> list = new ArrayList<q>();
        int i = 0;
        while (i < e.size()) {
            final N n = e.get(i);
            final Object b = n.b();
            if (a != 0) {
                return;
            }
            if (b instanceof aB) {
                final q a2 = aB.a((aB)n.b());
                if (!d.contains(a2)) {
                    list.add(a2);
                }
            }
            ++i;
            if (a != 0) {
                break;
            }
        }
        r.a(T.b, list);
    }
}
