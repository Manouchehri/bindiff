/*
 * Decompiled with CFR 0_115.
 */
package y.f.c.a;

import java.util.Comparator;
import y.c.h;
import y.f.c.a.aD;
import y.g.e;

class P
implements Comparator {
    private final h a;
    private final aD b;

    P(aD aD2, h h2) {
        this.b = aD2;
        this.a = h2;
    }

    public int compare(Object object, Object object2) {
        return e.a(this.a.a(object), this.a.a(object2));
    }
}

