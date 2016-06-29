/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import y.g.z;
import y.h.bu;
import y.h.hP;

class hK
implements z {
    private final bu a;
    private final hP b;

    hK(hP hP2, bu bu2) {
        this.b = hP2;
        this.a = bu2;
    }

    @Override
    public boolean a(Object object) {
        if (hP.a(this.b, object, this.a)) return false;
        return true;
    }
}

