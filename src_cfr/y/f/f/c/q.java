/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.c;

import java.util.Iterator;
import y.c.C;
import y.c.D;
import y.c.d;
import y.c.e;
import y.c.i;
import y.f.f.b.h;
import y.f.f.b.o;
import y.f.f.c.g;
import y.f.f.c.p;

public class q {
    protected h a;
    protected p b;
    protected p c;

    public q(p p2, p p3) {
        this.b = p2;
        this.c = p3;
        this.a();
    }

    public void a(h h2) {
        this.a = h2;
    }

    private void a() {
        this.a(this.b, this.c);
        this.a(this.c, this.b);
    }

    private void a(p p2, p p3) {
        int n2 = g.a;
        Iterator iterator = p2.d();
        do {
            if (!iterator.hasNext()) return;
            g g2 = (g)iterator.next();
            C c2 = g2.h().m();
            y.c.q q2 = (y.c.q)c2.d();
            c2.j();
            y.c.q q3 = (y.c.q)c2.d();
            g2.a(p3.a(q2), p3.a(q3));
        } while (n2 == 0);
    }

    public static int a(h h2, p p2, p p3) {
        int n2;
        int n3 = g.a;
        int n4 = 0;
        e e2 = h2.a().p();
        while (e2.f()) {
            g g2;
            g g3;
            d d2 = e2.a();
            n2 = (int)h2.h(d2).a(o.b) ? 1 : 0;
            if (n3 != 0) return n2;
            if (n2 != 0) {
                g2 = p2.a(d2.c());
                g3 = p2.a(d2.d());
                n4 = n4 + g3.i() - g2.i();
            }
            if (h2.h(d2).a(o.c)) {
                g2 = p3.a(d2.c());
                g3 = p3.a(d2.d());
                n4 = n4 + g3.i() - g2.i();
            }
            e2.g();
            if (n3 == 0) continue;
        }
        n2 = n4;
        return n2;
    }
}

