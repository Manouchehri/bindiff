/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.util.Comparator;
import y.g.e;
import y.h.F;
import y.h.fj;

class K
implements Comparator {
    private final F a;

    K(F f2) {
        this.a = f2;
    }

    public int compare(Object object, Object object2) {
        fj fj2 = (fj)object;
        fj fj3 = (fj)object2;
        return e.a(fj2.getCenterY(), fj3.getCenterY());
    }
}

