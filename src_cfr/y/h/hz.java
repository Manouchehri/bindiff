/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.util.Map;
import y.c.d;
import y.c.f;
import y.c.i;
import y.c.q;
import y.g.C;

class hZ
implements C {
    private C a;
    private Map b;
    private Map c;
    private Map d;
    private f e;

    hZ(C c2, f f2, Map map, Map map2, Map map3) {
        this.a = c2;
        this.b = map;
        this.c = map2;
        this.d = map3;
        this.e = f2;
    }

    @Override
    public d a(i i2, q q2, q q3, d d2) {
        d d3 = this.a.a(i2, q2, q3, d2);
        this.d.put(d3, d2);
        this.e.add(d3);
        return d3;
    }

    @Override
    public q a(i i2, q q2) {
        q q3 = this.a.a(i2, q2);
        this.b.put(q3, q2);
        this.c.put(q2, q3);
        return q3;
    }

    @Override
    public void a(i i2, i i3, Map map, Map map2) {
        this.a.a(i2, i3, map, map2);
    }

    @Override
    public void a(i i2, i i3) {
        this.a.a(i2, i3);
    }
}

