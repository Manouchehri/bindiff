/*
 * Decompiled with CFR 0_115.
 */
package y.f.i.a;

import y.c.f;
import y.c.h;
import y.d.g;
import y.d.m;
import y.f.i.a.E;
import y.f.i.a.ab;
import y.f.i.a.y;

class B
implements g {
    private final h a;
    private final h b;
    private final h c;
    private final f d;
    private final y e;

    B(y y2, h h2, h h3, h h4, f f2) {
        this.e = y2;
        this.a = h2;
        this.b = h3;
        this.c = h4;
        this.d = f2;
    }

    @Override
    public void a(Object object, Object object2) {
        E e2 = (E)object;
        E e3 = (E)object2;
        if (m.a(E.a(e2), E.a(e3)) == null) return;
        if (E.b(e2) == E.b(e3)) {
            this.a.a((Object)E.b(e2), this.a.a(E.b(e2)) + 1);
            if (!this.b.d(E.b(e2))) return;
            if (y.a(this.e, E.b(e2))) return;
            if (this.c.d(E.b(e2))) return;
            this.d.add(E.b(e2));
            this.c.a((Object)E.b(e2), true);
            if (ab.a == 0) return;
        }
        this.a.a((Object)E.b(e2), this.a.a(E.b(e2)) + 1);
        this.a.a((Object)E.b(e3), this.a.a(E.b(e3)) + 1);
    }
}

