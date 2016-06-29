/*
 * Decompiled with CFR 0_115.
 */
package y.f.c;

import y.c.c;
import y.g.p;

final class P
extends p {
    private final c a;
    private final Object b;

    public P(c c2, Object object) {
        this.a = c2;
        this.b = object;
    }

    @Override
    public Object b(Object object) {
        Object object2;
        Object object3 = this.a.b(object);
        if (object3 == null) {
            object2 = this.b;
            return object2;
        }
        object2 = object3;
        return object2;
    }
}

