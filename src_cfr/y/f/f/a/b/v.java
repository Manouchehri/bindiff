/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.a.b;

import java.util.Comparator;
import y.c.d;
import y.f.f.a.b.u;
import y.g.e;

class v
implements Comparator {
    private final u a;

    v(u u2) {
        this.a = u2;
    }

    public int compare(Object object, Object object2) {
        d d2 = (d)object;
        d d3 = (d)object2;
        return e.a(u.a(this.a).A(d3), u.a(this.a).A(d2));
    }
}

