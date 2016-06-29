/*
 * Decompiled with CFR 0_115.
 */
package y.f.g;

import y.c.D;
import y.d.g;
import y.d.m;
import y.d.t;
import y.f.g.n;
import y.f.g.q;
import y.f.g.u;

class p
implements g {
    private D a;
    private final n b;

    p(n n2) {
        this.b = n2;
        this.a = new D();
    }

    @Override
    public void a(Object object, Object object2) {
        u u2 = (u)object;
        u u3 = (u)object2;
        int n2 = u2.l() + u3.l();
        t t2 = m.a(u2, u3);
        if (t2 == null) return;
        this.a.add(new q(t2, n2, u2, u3));
    }

    public D a() {
        return this.a;
    }
}

