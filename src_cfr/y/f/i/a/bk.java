/*
 * Decompiled with CFR 0_115.
 */
package y.f.i.a;

import y.f.i.a.bF;
import y.g.p;

class bK
extends p {
    private final bF a;

    bK(bF bF2) {
        this.a = bF2;
    }

    @Override
    public Object b(Object object) {
        if (bF.a(this.a).d(object)) {
            if (bF.f(this.a) == null) return null;
            Object object2 = bF.f(this.a).b(object);
            return object2;
        }
        if (bF.g(this.a) == null) return null;
        Object object3 = bF.g(this.a).b(object);
        return object3;
    }
}

