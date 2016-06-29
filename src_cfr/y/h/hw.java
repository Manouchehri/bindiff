/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.util.HashSet;
import y.c.d;
import y.c.q;
import y.g.p;
import y.h.hV;

class hW
extends p {
    private final HashSet a;
    private final hV b;

    hW(hV hV2, HashSet hashSet) {
        this.b = hV2;
        this.a = hashSet;
    }

    @Override
    public boolean d(Object object) {
        d d2 = (d)object;
        if (this.a.contains(d2.c())) return false;
        if (this.a.contains(d2.d())) return false;
        return true;
    }
}

