/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.a;

import y.c.d;
import y.c.h;
import y.f.f.a.f;
import y.f.h.Q;
import y.f.h.p;

class i
implements Q {
    h a;

    i(h h2) {
        this.a = h2;
    }

    @Override
    public void a(d d2, d[] arrd) {
        boolean bl2 = f.a;
        int n2 = 0;
        do {
            if (n2 >= arrd.length) return;
            this.a.a((Object)arrd[n2], this.a.b(d2));
            ++n2;
        } while (!bl2);
    }

    @Override
    public void a(d[] arrd, d d2) {
        this.a.a((Object)d2, arrd[0]);
    }

    @Override
    public void a(d d2, p[] arrp, p[] arrp2) {
    }

    @Override
    public void b(d d2, p[] arrp, p[] arrp2) {
    }
}

