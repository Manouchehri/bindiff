/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.e;

import java.util.Comparator;
import y.f.f.e.i;
import y.g.e;

class j
implements Comparator {
    private final i a;

    j(i i2) {
        this.a = i2;
    }

    public int compare(Object object, Object object2) {
        Integer n2 = (Integer)object;
        Integer n3 = (Integer)object2;
        return e.a(n2, n3);
    }
}

