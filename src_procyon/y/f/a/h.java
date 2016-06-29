package y.f.a;

import java.util.*;
import y.f.*;
import y.c.*;

class h extends a
{
    ad a;
    private boolean b;
    
    void a(final boolean b) {
        this.b = b;
    }
    
    public h(final ad a) {
        this.b = false;
        this.a = a;
    }
    
    public void c(final X x) {
        final int u = f.u;
        final y.c.h u2 = x.u();
        final y.c.f f = new y.c.f();
        final c c = x.c(y.f.a.a.o);
        if (c != null) {
            final HashMap<Object, q> hashMap = new HashMap<Object, q>();
            final x o = x.o();
            while (o.f()) {
                final q e = o.e();
                final Object b = c.b(e);
                Label_0158: {
                    if (b != null) {
                        if (hashMap.containsKey(b)) {
                            final q q = hashMap.get(b);
                            if (e.c(q) != null) {
                                break Label_0158;
                            }
                            final d a = x.a(e, q);
                            u2.a(a, true);
                            f.add(a);
                            if (u == 0) {
                                break Label_0158;
                            }
                        }
                        hashMap.put(b, e);
                    }
                }
                o.g();
                if (u != 0) {
                    break;
                }
            }
        }
        final ah a2 = this.a();
        this.a.a(new i(this, u2, a2));
        this.a.c(x);
        final e a3 = f.a();
        while (a3.f()) {
            x.a(a3.a());
            a3.g();
            if (u != 0) {
                return;
            }
            if (u != 0) {
                break;
            }
        }
        x.a(u2);
        this.a.a(a2);
    }
    
    static boolean a(final h h) {
        return h.b;
    }
}
