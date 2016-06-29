/*
 * Decompiled with CFR 0_115.
 */
package y.f.c;

import java.util.Comparator;
import y.c.d;
import y.f.aE;
import y.f.c.x;
import y.g.g;

class B
implements Comparator,
g {
    Comparator a;
    Comparator b;
    private final x c;

    B(x x2, Comparator comparator, Comparator comparator2) {
        this.c = x2;
        this.a = comparator;
        this.b = comparator2;
    }

    public int compare(Object object, Object object2) {
        aE aE2 = this.c.a((d)object);
        aE aE3 = this.c.a((d)object2);
        if (aE2 != null && aE2.a()) {
            if (aE3 == null) return -1;
            if (!aE3.a()) return -1;
            return this.b.compare(object, object2);
        }
        if (aE3 == null) return this.a.compare(object, object2);
        if (!aE3.a()) return this.a.compare(object, object2);
        return 1;
    }
}

