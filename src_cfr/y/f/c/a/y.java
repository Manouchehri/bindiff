/*
 * Decompiled with CFR 0_115.
 */
package y.f.c.a;

import java.util.Comparator;
import y.c.A;
import y.f.c.a.aD;
import y.g.e;

class Y
implements Comparator {
    private final A a;
    private final aD b;

    Y(aD aD2, A a2) {
        this.b = aD2;
        this.a = a2;
    }

    public int compare(Object object, Object object2) {
        return e.a(this.a.a(object), this.a.a(object2));
    }
}

