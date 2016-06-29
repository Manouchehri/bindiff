package y.f.i.a;

import y.c.*;
import java.util.*;

class bO
{
    D a;
    Set b;
    M c;
    double d;
    private final bN e;
    
    bO(final bN e, final w w) {
        this.e = e;
        this.a = new D();
        this.b = new HashSet();
        this.a.add(w);
        this.b.add(w);
        this.c = w.a(e.b).c();
        e.c.add(this.c);
    }
    
    bO(final bN e, final bO bo, final bO bo2, final M c) {
        this.e = e;
        this.a = new D(bo.a);
        this.b = new HashSet(bo.b);
        this.a(bo2.a);
        this.c = c;
        e.c.add(this.c);
    }
    
    public void a(final w w) {
        if (this.b.add(w)) {
            this.a.add(w);
        }
    }
    
    public void a(final D d) {
        final int a = ab.a;
        final Iterator iterator = d.iterator();
        while (iterator.hasNext()) {
            this.a(iterator.next());
            if (a != 0) {
                break;
            }
        }
    }
    
    public void a(final bO bo) {
        this.a.a(bo.a);
        this.b.addAll(bo.b);
    }
    
    public double a() {
        return this.d;
    }
    
    private void b() {
        final int a = ab.a;
        final double n = (this.e.a.size() / this.a.size() - 1.0) * 5.0;
        final double n2 = (bN.a(this.e).a().c().k() == null || bN.a(this.e).a().c().k().a(this.c, this.e.d)) ? 0.0 : 1.0;
        double n3 = 0.0;
        final Iterator iterator = this.a.iterator();
        while (iterator.hasNext()) {
            final ai a2 = iterator.next().a(this.e.b);
            final M c = a2.c();
            if (c.d() != 0.0) {
                final byte d = a2.d();
                if (a != 0) {
                    return;
                }
                if (d == -1) {
                    n3 += this.c.b(c.a()) / c.d();
                    if (a == 0) {
                        continue;
                    }
                }
                if (d != 1) {
                    continue;
                }
                n3 += this.c.b(c.b()) / c.d();
                if (a != 0) {
                    break;
                }
                continue;
            }
        }
        this.d = n + n2 + n3 / this.a.size();
    }
    
    public boolean b(final D d) {
        this.a.removeAll(d);
        if (this.a.size() == 0) {
            return true;
        }
        this.b.removeAll(d);
        this.b();
        return false;
    }
    
    static void b(final bO bo) {
        bo.b();
    }
}
