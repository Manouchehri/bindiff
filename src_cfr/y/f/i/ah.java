/*
 * Decompiled with CFR 0_115.
 */
package y.f.i;

import java.util.HashMap;
import y.d.m;
import y.g.p;

class aH
extends p {
    private HashMap a = new HashMap();

    @Override
    public Object b(Object object) {
        return this.a.get(object);
    }

    public void a(m m2, Object object) {
        this.a.put(m2, object);
    }
}

