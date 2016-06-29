/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.util.Map;
import y.c.d;
import y.c.i;
import y.c.q;
import y.g.C;
import y.h.bF;

class bG
implements C {
    final C a;
    private final bF b;

    @Override
    public d a(i i2, q q2, q q3, d d2) {
        return this.a.a(i2, q2, q3, d2);
    }

    @Override
    public q a(i i2, q q2) {
        return this.a.a(i2, q2);
    }

    @Override
    public void a(i i2, i i3, Map map, Map map2) {
        this.a.a(i2, i3, map, map2);
        bF.a(this.b, i2, map, map2);
    }

    @Override
    public void a(i i2, i i3) {
        this.a.a(i2, i3);
    }

    public bG(bF bF2, C c2) {
        this.b = bF2;
        this.a = c2;
    }
}

