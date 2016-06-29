/*
 * Decompiled with CFR 0_115.
 */
package y.f.c.a;

import java.util.Comparator;
import y.c.q;
import y.f.c.a.aD;
import y.f.c.a.aV;
import y.f.c.a.aX;
import y.g.e;

class R
implements Comparator {
    private final aV a;
    private final aD b;

    R(aD aD2, aV aV2) {
        this.b = aD2;
        this.a = aV2;
    }

    public int compare(Object object, Object object2) {
        return e.a(this.a.a((q)object).j(), this.a.a((q)object2).j());
    }
}

