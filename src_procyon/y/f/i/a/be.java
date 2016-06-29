package y.f.i.a;

import java.util.*;
import y.c.*;

class be
{
    private final v a;
    private final D b;
    private p c;
    private final bc d;
    
    be(final bc d, final v a) {
        this.d = d;
        this.a = a;
        this.b = new D(a.m());
    }
    
    void a() {
        final int a = ab.a;
        if (this.c != null) {
            this.b();
        }
        this.c = bc.a(this.d).b(this.a);
        for (final g g : this.b) {
            this.a(g, g.g() ? bc.b(this.d) : bc.c(this.d));
            final M c = g.c();
            Label_0191: {
                if (g.g()) {
                    bc.a(this.d, 0, c.b() + bc.d(this.d), false);
                    bc.a(this.d, 2, c.a() - bc.d(this.d), false);
                    if (a == 0) {
                        break Label_0191;
                    }
                }
                bc.a(this.d, 1, c.b() + bc.d(this.d), false);
                bc.a(this.d, 3, c.a() - bc.d(this.d), false);
            }
            if (g.g()) {
                bc.a(this.d, null);
                if (a == 0) {
                    continue;
                }
            }
            bc.b(this.d, null);
            if (a != 0) {
                break;
            }
        }
    }
    
    private void a(final g g, final D d) {
        final ah k = g.k();
        if (k != null && bc.e(this.d).containsKey(k)) {
            ((bd)((p)bc.e(this.d).get(k)).c()).a.add(g);
            return;
        }
        bc.e(this.d).put((k != null) ? k : g, bc.a(this.d, new bd(this.d, g), d));
    }
    
    void b() {
        final int a = ab.a;
        if (this.c != null) {
            bc.a(this.d).h(this.c);
            this.c = null;
            final C m = this.b.m();
            while (m.f()) {
                final g g = (g)m.d();
                final ah k = g.k();
                final p p = bc.e(this.d).get((k != null) ? k : g);
                final bd bd = (bd)p.c();
                bd.a.remove(g);
                Label_0311: {
                    if (bd.a.size() == 0) {
                        bc.e(this.d).remove((k != null) ? k : g);
                        if (g.g()) {
                            bc.b(this.d).h(p);
                            bc.a(this.d, null);
                            bc.a(this.d, 2, bc.a(this.d, 0) - bc.d(this.d), true);
                            bc.a(this.d, 0, bc.a(this.d, 2) + bc.d(this.d), true);
                            if (a == 0) {
                                break Label_0311;
                            }
                        }
                        bc.c(this.d).h(p);
                        bc.b(this.d, null);
                        bc.a(this.d, 3, bc.a(this.d, 1) - bc.d(this.d), true);
                        bc.a(this.d, 1, bc.a(this.d, 3) + bc.d(this.d), true);
                    }
                }
                m.g();
                if (a != 0) {
                    break;
                }
            }
        }
    }
}
