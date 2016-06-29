/*
 * Decompiled with CFR 0_115.
 */
package y.f.c.a;

import java.util.Comparator;
import y.c.d;
import y.d.t;
import y.f.X;
import y.g.e;

final class cV
implements Comparator {
    boolean a;
    boolean b;
    X c;

    cV(X x2, boolean bl2, boolean bl3) {
        this.a = bl2;
        this.c = x2;
        this.b = bl3;
    }

    public int compare(Object object, Object object2) {
        d d2 = (d)object2;
        d d3 = (d)object;
        if (this.a) {
            if (!this.b) return e.a(this.c.n((d)d2).b, this.c.n((d)d3).b);
            return e.a(this.c.n((d)d2).a, this.c.n((d)d3).a);
        }
        if (!this.b) return e.a(this.c.o((d)d2).b, this.c.o((d)d3).b);
        return e.a(this.c.o((d)d2).a, this.c.o((d)d3).a);
    }
}

