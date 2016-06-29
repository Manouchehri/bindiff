/*
 * Decompiled with CFR 0_115.
 */
package y.f.e;

import java.util.HashSet;
import y.f.e.a.ay;
import y.f.e.q;
import y.g.p;

class u
extends p {
    private final HashSet a;
    private final ay b;
    private final q d;

    u(q q2, HashSet hashSet, ay ay2) {
        this.d = q2;
        this.a = hashSet;
        this.b = ay2;
    }

    @Override
    public Object b(Object object) {
        if (!this.a.contains(object)) return null;
        return this.b;
    }
}

