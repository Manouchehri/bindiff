/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import y.c.c;
import y.c.d;
import y.c.e;
import y.f.X;
import y.f.ae;
import y.f.ah;
import y.f.i.i;
import y.h.fj;
import y.h.hV;
import y.h.hY;

class hX
implements ah {
    private final i a;

    hX(i i2) {
        this.a = i2;
    }

    @Override
    public void c(X x2) {
        boolean bl2 = fj.z;
        c c2 = x2.c(hV.d);
        x2.a(hV.e, new hY(this, c2));
        this.a.c(x2);
        x2.d_(hV.e);
        e e2 = x2.p();
        do {
            if (!e2.f()) return;
            d d2 = e2.a();
            if (c2.b(d2) == hV.a) {
                ae.a(x2, d2);
            }
            e2.g();
        } while (!bl2);
    }
}

