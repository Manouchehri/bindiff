/*
 * Decompiled with CFR 0_115.
 */
package y.f.i.a;

import java.util.HashSet;
import y.f.i.a.y;
import y.g.p;

class C
extends p {
    private final HashSet a;
    private final y b;

    C(y y2, HashSet hashSet) {
        this.b = y2;
        this.a = hashSet;
    }

    @Override
    public boolean d(Object object) {
        return this.a.contains(object);
    }
}

