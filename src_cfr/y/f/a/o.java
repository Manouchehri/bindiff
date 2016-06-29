/*
 * Decompiled with CFR 0_115.
 */
package y.f.a;

import y.c.D;
import y.c.q;
import y.d.g;
import y.f.a.j;
import y.f.a.m;
import y.f.a.p;

class o
implements g {
    private D a;
    private final j b;

    o(j j2) {
        this.b = j2;
        this.a = new D();
    }

    public D a() {
        return this.a;
    }

    @Override
    public void a(Object object, Object object2) {
        m m2 = (m)object;
        m m3 = (m)object2;
        this.a.add(new p(this.b, m2.a(), m3.a()));
    }
}

