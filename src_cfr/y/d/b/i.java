/*
 * Decompiled with CFR 0_115.
 */
package y.d.b;

import java.util.Comparator;
import y.d.b.d;
import y.g.g;

class i
implements Comparator,
g {
    private final d a;

    i(d d2) {
        this.a = d2;
    }

    public int compare(Object object, Object object2) {
        return this.a.j(object, object2);
    }
}

