package y.f.c;

import y.c.*;
import y.f.*;
import java.util.*;
import y.d.*;

class ay extends a
{
    private byte a;
    
    ay() {
        this.a = 0;
    }
    
    public void c(final X x) {
        final boolean i = y.f.c.a.i;
        if (this.a() instanceof c) {
            this.a = ((c)this.a()).h();
        }
        final y.c.c c = x.c(ax.a);
        final y.c.c c2 = x.c(ax.b);
        if (c == null && c2 == null) {
            this.a().c(x);
            if (!i) {
                return;
            }
        }
        final y.c.c c3 = x.c(aF.a);
        final y.c.c c4 = x.c(aF.b);
        final h u = x.u();
        x.a(aF.a, u);
        final h u2 = x.u();
        x.a(aF.b, u2);
        final e p = x.p();
        while (true) {
            while (p.f()) {
                final d a = p.a();
                u.a(a, this.a(a, true, c3, u2, c, c2, x));
                u2.a(a, this.a(a, false, c3, u2, c, c2, x));
                p.g();
                if (i) {
                    Label_0240: {
                        if (c3 != null) {
                            x.a(aF.a, c3);
                            if (!i) {
                                break Label_0240;
                            }
                        }
                        x.d_(aF.a);
                    }
                    x.a(u);
                    Label_0272: {
                        if (c4 != null) {
                            x.a(aF.b, c4);
                            if (!i) {
                                break Label_0272;
                            }
                        }
                        x.d_(aF.b);
                    }
                    x.a(u2);
                    return;
                }
                if (i) {
                    break;
                }
            }
            this.a().c(x);
            continue;
        }
    }
    
    private aE a(final d d, final boolean b, final y.c.c c, final y.c.c c2, final y.c.c c3, final y.c.c c4, final X x) {
        aE ae = null;
        if (b && c != null) {
            ae = (aE)c.b(d);
        }
        else if (!b && c2 != null) {
            ae = (aE)c2.b(d);
        }
        if (ae == null) {
            if (b && c3 != null) {
                final Collection collection = (Collection)c3.b(d);
                if (collection == null || collection.size() != 1) {
                    return ae;
                }
                final ax ax = collection.iterator().next();
                if (ax.b()) {
                    x.a(d, new t(ax.c(this.a), ax.d(this.a)));
                }
                ae = ax.a(this.a);
                if (!y.f.c.a.i) {
                    return ae;
                }
            }
            if (!b && c4 != null) {
                final Collection collection2 = (Collection)c4.b(d);
                if (collection2 != null && collection2.size() == 1) {
                    final ax ax2 = collection2.iterator().next();
                    if (ax2.b()) {
                        x.b(d, new t(ax2.c(this.a), ax2.d(this.a)));
                    }
                    ae = ax2.a(this.a);
                }
            }
        }
        return ae;
    }
}
