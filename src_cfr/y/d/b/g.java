/*
 * Decompiled with CFR 0_115.
 */
package y.d.b;

import java.util.Comparator;
import y.d.b.d;

class g
implements Comparator {
    private final d a;

    g(d d2) {
        this.a = d2;
    }

    public int compare(Object object, Object object2) {
        return this.a.m(object, object2);
    }
}

