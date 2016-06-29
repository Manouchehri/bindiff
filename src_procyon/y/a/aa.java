package y.a;

import java.util.*;
import y.c.*;

class aa extends i
{
    Map a;
    Map b;
    
    public aa(final i i) {
        final boolean a = y.a.h.a;
        this.b = new HashMap();
        this.a = new HashMap();
        final x o = i.o();
        while (true) {
            while (o.f()) {
                final q d = this.d();
                this.b.put(d, o.e());
                final i j = this;
                if (a) {
                    final e p = j.p();
                    while (p.f()) {
                        final d a2 = p.a();
                        final d a3 = this.a(this.a.get(a2.c()), this.a.get(a2.d()));
                        this.b.put(a3, a2);
                        this.a.put(a2, a3);
                        p.g();
                        if (a) {
                            break;
                        }
                    }
                    return;
                }
                this.a.put(o.e(), d);
                o.g();
                if (a) {
                    break;
                }
            }
            final i j = i;
            continue;
        }
    }
    
    public void a(final C c, final c c2, final b b) {
        final boolean a = y.a.h.a;
        while (c.f()) {
            final Object d = c.d();
            b.a(d, c2.a(this.b.get(d)));
            c.g();
            if (a) {
                break;
            }
        }
    }
    
    public void b(final C c, final c c2, final b b) {
        final boolean a = y.a.h.a;
        while (c.f()) {
            final Object d = c.d();
            b.a(d, c2.c(this.b.get(d)));
            c.g();
            if (a) {
                break;
            }
        }
    }
    
    public void c(final C c, final c c2, final b b) {
        final boolean a = y.a.h.a;
        while (c.f()) {
            final Object d = c.d();
            b.a(d, c2.a(this.a.get(d)));
            c.g();
            if (a) {
                break;
            }
        }
    }
}
