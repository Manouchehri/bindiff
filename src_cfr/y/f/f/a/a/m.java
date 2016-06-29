/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.a.a;

import y.c.C;
import y.c.D;
import y.c.p;
import y.f.f.a.a.e;
import y.f.f.a.a.f;
import y.f.f.a.a.g;
import y.f.f.a.a.h;

public class m {
    public static void a(h h2, e e2) {
        boolean bl2 = f.e;
        D d2 = new D();
        d2.b(e2);
        block0 : do {
            if (d2.isEmpty()) return;
            e e3 = (e)d2.g();
            h2.a(e3);
            C c2 = e3.a();
            do {
                if (!c2.f()) continue block0;
                d2.b((e)c2.d());
                c2.g();
                if (bl2) return;
            } while (!bl2);
            break;
        } while (true);
    }

    public static void a(h h2, g g2) {
        m.b(h2, g2.a());
    }

    public static void b(h h2, e e2) {
        boolean bl2 = f.e;
        D d2 = new D();
        d2.a(e2);
        block0 : do {
            if (d2.isEmpty()) return;
            e e3 = (e)d2.g();
            h2.a(e3);
            C c2 = e3.a();
            do {
                if (!c2.f()) continue block0;
                d2.a((e)c2.d());
                c2.g();
                if (bl2) return;
            } while (!bl2);
            break;
        } while (true);
    }

    public static void c(h h2, e e2) {
        boolean bl2 = f.e;
        C c2 = e2.a();
        while (c2.f()) {
            e e3 = (e)c2.d();
            m.c(h2, e3);
            c2.g();
            if (bl2) return;
            if (!bl2) continue;
        }
        h2.a(e2);
    }

    public static void b(h h2, g g2) {
        m.c(h2, g2.a());
    }
}

