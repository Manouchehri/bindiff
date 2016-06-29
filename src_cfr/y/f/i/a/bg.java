/*
 * Decompiled with CFR 0_115.
 */
package y.f.i.a;

import y.f.i.a.bF;
import y.g.p;

class bG
extends p {
    private final bF a;

    bG(bF bF2) {
        this.a = bF2;
    }

    @Override
    public Object b(Object object) {
        if (bF.a(this.a).d(object)) {
            if (bF.b(this.a) == null) return null;
            Object object2 = bF.b(this.a).b(object);
            return object2;
        }
        if (bF.c(this.a) == null) return null;
        Object object3 = bF.c(this.a).b(object);
        return object3;
    }
}

