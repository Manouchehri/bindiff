/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import y.c.l;
import y.c.o;
import y.h.F;

class I
implements o {
    private final F a;

    I(F f2) {
        this.a = f2;
    }

    @Override
    public void onGraphEvent(l l2) {
        if (l2.a() != 3) return;
        if (!l2.b().equals(F.f(this.a))) return;
        this.a.n();
    }
}

