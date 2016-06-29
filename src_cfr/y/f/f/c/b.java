/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.c;

import java.util.Comparator;
import y.c.C;
import y.c.D;
import y.f.f.b.o;
import y.f.f.c.c;
import y.f.f.c.d;
import y.f.f.c.e;
import y.f.f.c.g;
import y.f.f.c.h;
import y.f.f.c.k;
import y.f.f.c.l;
import y.f.f.c.n;
import y.f.f.c.p;
import y.f.f.c.q;

public class b
implements l {
    private int a = 1;

    public void a(int n2) {
        this.a = n2;
    }

    @Override
    public void a(y.f.f.b.h h2, p p2, p p3) {
        int n2 = g.a;
        q q2 = new q(p2, p3);
        q2.a(h2);
        int n3 = Integer.MAX_VALUE;
        int n4 = 0;
        int n5 = 1;
        int n6 = 0;
        boolean bl2 = true;
        do {
            if (!bl2) return;
            y.g.o.a(this, (Object)new StringBuffer().append("New Iteration: ").append(n5).toString());
            bl2 = false;
            switch (n5) {
                case 0: {
                    n4 = 1;
                    this.a(h2, p2, o.b);
                    n6 = q.a(h2, p2, p3);
                    if (n6 < n3) {
                        bl2 = true;
                    }
                    n3 = n6;
                    if (n2 == 0) break;
                }
                case 1: {
                    n4 = 0;
                    this.a(h2, p3, o.c);
                    n6 = q.a(h2, p2, p3);
                    if (n6 < n3) {
                        bl2 = true;
                    }
                    n3 = n6;
                }
            }
            n5 = n4;
            y.g.o.a(this, (Object)new StringBuffer().append("Total Edge Length: ").append(n6).toString());
        } while (n2 == 0);
    }

    public void a(y.f.f.b.h h2, p p2, o o2) {
        Object object;
        int n2;
        Object object2;
        int n3;
        g[] arrg;
        block12 : {
            n2 = g.a;
            p2.b();
            D d2 = this.a(p2.e());
            C c2 = d2.m();
            e e2 = new e(p2);
            while (c2.f()) {
                d d3 = (d)c2.d();
                n3 = d3.b();
                if (n2 == 0) {
                    switch (n3) {
                        case 0: {
                            object = d3.c();
                            arrg = e2.a((g)object);
                            object2 = arrg[0];
                            g g2 = arrg[1];
                            if (object2 != null && object2.i() != object.i() && !b.a(h2, (g)object2, (g)object)) {
                                p2.a((g)object2, (g)object, 1);
                            }
                            if (g2 == null || object.i() == g2.i() || b.a(h2, (g)object, g2)) break;
                            p2.a((g)object, g2, 1);
                            if (n2 == 0) break;
                        }
                        case 1: {
                            e2.b(d3.c());
                        }
                    }
                    c2.g();
                    if (n2 == 0) continue;
                }
                break block12;
            }
            n3 = this.a;
        }
        switch (n3) {
            case 0: {
                object = new k();
                object.a(p2);
                if (n2 == 0) return;
            }
            case 1: {
                arrg = new g[]();
                arrg.a(p2);
                if (n2 == 0) return;
            }
            case 2: {
                object2 = new n();
                object2.a(true);
                object2.a(p2);
            }
        }
    }

    protected D a(C c2) {
        int n2 = g.a;
        D d2 = new D();
        while (c2.f()) {
            g g2 = (g)c2.d();
            d d3 = new d(g2.d().i(), 0, g2);
            d d4 = new d(g2.e().i(), 1, g2);
            d2.add(d3);
            d2.add(d4);
            c2.g();
            if (n2 != 0) return d2;
            if (n2 == 0) continue;
        }
        d2.sort(new c(this));
        return d2;
    }

    protected static boolean a(y.f.f.b.h h2, g g2, g g3) {
        if (g2.e() == g3.d()) {
            y.c.d d2 = g2.g().a(g3.f());
            if (d2 == null) return false;
            return true;
        }
        if (g3.e() != g2.d()) return false;
        y.c.d d3 = g3.g().a(g2.f());
        if (d3 == null) return false;
        return true;
    }
}

