package y.f.d;

import y.f.*;
import y.d.*;
import y.c.*;

class b implements g
{
    X a;
    boolean b;
    
    b(final X a, final boolean b) {
        this.b = b;
        this.a = a;
    }
    
    public void a(final Object o, final Object o2) {
        Q q = null;
        e e = null;
        if (o instanceof Q) {
            q = (Q)o;
        }
        else if (o instanceof e) {
            e = (e)o;
        }
        Label_0064: {
            if (o2 instanceof Q) {
                q = (Q)o2;
                if (y.f.d.a.f == 0) {
                    break Label_0064;
                }
            }
            if (o2 instanceof e) {
                e = (e)o2;
            }
        }
        if (q == null || e == null) {
            return;
        }
        if (this.b && e.l() instanceof d) {
            final d l = e.l();
            final c c = this.a.c(aF.c);
            final Object b = c.b(l);
            if (b != null && b.equals(c.b(this.a.a((C)q.e())))) {
                return;
            }
            final c c2 = this.a.c(aF.d);
            final Object b2 = c2.b(l);
            if (b2 != null && b2.equals(c2.b(this.a.a((C)q.e())))) {
                return;
            }
        }
        if (q.f() && q.e() instanceof C && this.a.a((C)q.e()) == e.l()) {
            return;
        }
        if (n.a(q.d(), e, 0.001)) {
            q.c(1.0);
        }
    }
}
