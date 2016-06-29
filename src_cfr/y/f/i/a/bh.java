/*
 * Decompiled with CFR 0_115.
 */
package y.f.i.a;

import y.f.i.a.bF;
import y.g.p;

class bH
extends p {
    private final bF a;

    bH(bF bF2) {
        this.a = bF2;
    }

    @Override
    public Object b(Object object) {
        if (bF.a(this.a).d(object)) {
            if (bF.c(this.a) == null) return null;
            Object object2 = bF.c(this.a).b(object);
            return object2;
        }
        if (bF.b(this.a) == null) return null;
        Object object3 = bF.b(this.a).b(object);
        return object3;
    }
}

