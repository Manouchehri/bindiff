/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.e;

import java.util.Comparator;
import y.f.f.e.a;
import y.g.e;

class b
implements Comparator {
    private final a a;

    b(a a2) {
        this.a = a2;
    }

    public int compare(Object object, Object object2) {
        Integer n2 = (Integer)object;
        Integer n3 = (Integer)object2;
        return e.a(n2, n3);
    }
}

