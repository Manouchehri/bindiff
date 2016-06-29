/*
 * Decompiled with CFR 0_115.
 */
package y.f.i.a;

import y.f.i.a.bF;
import y.g.p;

class bJ
extends p {
    private final bF a;

    bJ(bF bF2) {
        this.a = bF2;
    }

    @Override
    public Object b(Object object) {
        if (bF.a(this.a).d(object)) {
            if (bF.e(this.a) == null) return null;
            Object object2 = bF.e(this.a).b(object);
            return object2;
        }
        if (bF.d(this.a) == null) return null;
        Object object3 = bF.d(this.a).b(object);
        return object3;
    }
}

