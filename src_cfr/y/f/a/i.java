/*
 * Decompiled with CFR 0_115.
 */
package y.f.a;

import y.c.d;
import y.c.e;
import y.f.X;
import y.f.a;
import y.f.a.f;
import y.f.a.h;
import y.f.ah;

class i
extends a {
    private final y.c.h a;
    private final ah b;
    private final h c;

    i(h h2, y.c.h h3, ah ah2) {
        this.c = h2;
        this.a = h3;
        this.b = ah2;
    }

    @Override
    public void c(X x2) {
        e e2;
        d d2;
        boolean bl2;
        int n2 = f.u;
        y.c.f f2 = new y.c.f();
        if (h.a(this.c)) {
            e2 = x2.p();
            while (e2.f()) {
                d2 = e2.a();
                bl2 = this.a.d(d2);
                if (n2 == 0) {
                    if (bl2) {
                        f2.add(d2);
                        x2.d(d2);
                    }
                    e2.g();
                    if (n2 == 0) continue;
                }
                break;
            }
        } else {
            this.b.c(x2);
            bl2 = h.a(this.c);
        }
        if (!bl2) return;
        e2 = f2.a();
        do {
            if (!e2.f()) return;
            d2 = e2.a();
            x2.e(d2);
            e2.g();
        } while (n2 == 0);
    }
}

