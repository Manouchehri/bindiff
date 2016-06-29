/*
 * Decompiled with CFR 0_115.
 */
package y.f.c.a;

import java.util.Comparator;
import y.c.q;
import y.f.c.a.dt;
import y.g.e;

class dv
implements Comparator {
    private final dt a;

    dv(dt dt2) {
        this.a = dt2;
    }

    public int compare(Object object, Object object2) {
        return e.a(dt.a(this.a).b((q)object), dt.a(this.a).b((q)object2));
    }
}

